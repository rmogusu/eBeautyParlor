package com.moringaschool.ebeautyparlor.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.ebeautyparlor.Constants;
import com.moringaschool.ebeautyparlor.R;
import com.moringaschool.ebeautyparlor.models.BeautyParlor;
import com.moringaschool.ebeautyparlor.models.Parlor;
import com.moringaschool.ebeautyparlor.ui.ParlorDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseParlorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    View mView;
    Context mContext;

    public FirebaseParlorViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }
    public void bindParlor(Parlor   parlor) {
        ImageView parlorImageView = (ImageView) mView.findViewById(R.id.parlorImageView);
        TextView nameTextView = (TextView) mView.findViewById(R.id.parlorNameTextView);
        TextView categoryTextView = (TextView) mView.findViewById(R.id.categoryTextView);
        TextView ratingTextView = (TextView) mView.findViewById(R.id.ratingTextView);

        Picasso.get().load(parlor.getImageUrl()).into(parlorImageView);

        nameTextView.setText(parlor.getName());
        categoryTextView.setText(parlor.getCategories());
        ratingTextView.setText("Rating: " + parlor.getRating() + "/5");
    }
    @Override
    public void onClick(View view) {
        final ArrayList<Parlor> parlors = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_PARLORS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    parlors.add(snapshot.getValue(Parlor.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, ParlorDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("parlors", Parcels.wrap(parlors));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
