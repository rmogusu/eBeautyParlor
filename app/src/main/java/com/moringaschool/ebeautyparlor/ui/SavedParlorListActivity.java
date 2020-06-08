package com.moringaschool.ebeautyparlor.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.ebeautyparlor.Constants;
import com.moringaschool.ebeautyparlor.R;

import com.moringaschool.ebeautyparlor.adapters.FirebaseParlorViewHolder;
import com.moringaschool.ebeautyparlor.adapters.ParlorListAdapter;
import com.moringaschool.ebeautyparlor.models.BeautyParlor;
import com.moringaschool.ebeautyparlor.models.Parlor;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedParlorListActivity extends AppCompatActivity {
    private DatabaseReference mParlorReference;
    private FirebaseRecyclerAdapter<BeautyParlor , FirebaseParlorViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    private ParlorListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parlor);
        ButterKnife.bind(this);
        final ArrayList<BeautyParlor> parlors = new ArrayList<>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_PARLORS).child(uid);
        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    parlors.add(snapshot.getValue(BeautyParlor.class));

                }
                mAdapter = new ParlorListAdapter(SavedParlorListActivity.this, parlors);
                mAdapter = new ParlorListAdapter(getApplicationContext(), parlors);
                mRecyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager =
                        new LinearLayoutManager(SavedParlorListActivity.this);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setHasFixedSize(true);

                showParlors();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    private void showParlors() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }

}