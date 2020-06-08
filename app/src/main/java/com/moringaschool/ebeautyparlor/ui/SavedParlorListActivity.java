package com.moringaschool.ebeautyparlor.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.ebeautyparlor.Constants;
import com.moringaschool.ebeautyparlor.R;
import com.moringaschool.ebeautyparlor.adapters.FirebaseParlorViewHolder;
import com.moringaschool.ebeautyparlor.models.Parlor;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedParlorListActivity extends AppCompatActivity {
    private DatabaseReference mParlorReference;
    private FirebaseRecyclerAdapter<Parlor, FirebaseParlorViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parlor);
        ButterKnife.bind(this);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        mParlorReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_PARLORS).child(uid);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Parlor> options =
                new FirebaseRecyclerOptions.Builder<Parlor>()
                        .setQuery(mParlorReference, Parlor.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Parlor, FirebaseParlorViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseParlorViewHolder firebaseParlorViewHolder, int position, @NonNull Parlor parlor) {
                firebaseParlorViewHolder.bindParlor(parlor);
            }
            @NonNull
            @Override
            public FirebaseParlorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parlor_list_item, parent, false);
                return new FirebaseParlorViewHolder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }
}