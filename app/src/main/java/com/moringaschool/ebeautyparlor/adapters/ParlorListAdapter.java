package com.moringaschool.ebeautyparlor.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.ebeautyparlor.R;
import com.moringaschool.ebeautyparlor.models.BeautyParlor;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ParlorListAdapter extends RecyclerView.Adapter<ParlorListAdapter.ParlorViewHolder> {
    private Context mContext;
    private List<BeautyParlor> mParlor;

    public ParlorListAdapter(Context context, List<BeautyParlor> parlors) {
        mContext = context;
        mParlor = parlors;
    }

    @Override
    public ParlorListAdapter.ParlorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parlor_list_item, parent, false);
        ParlorViewHolder viewHolder = new ParlorViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ParlorListAdapter.ParlorViewHolder holder, int position) {
        holder.bindParlor(mParlor.get(position));
    }

    @Override
    public int getItemCount() {
        return mParlor.size();
    }

    public class ParlorViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.parlorImageView)
        ImageView mParlorImageView;
        @BindView(R.id.parlorNameTextView)
        TextView mNameTextView;
       @BindView(R.id.categoryTextView)
       TextView mCategoryTextView;
        @BindView(R.id.ratingTextView)
        TextView mRatingTextView;
        private Context mContext;

        public ParlorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindParlor(BeautyParlor  beautyParlor) {
            Picasso.get().load(beautyParlor.getImageUrl()).into(mParlorImageView);
            mNameTextView.setText(beautyParlor.getName());
            mCategoryTextView.setText(beautyParlor.getCategories());
            mRatingTextView.setText("Rating: " +  beautyParlor.getRating() + "/5");
        }
    }
}
