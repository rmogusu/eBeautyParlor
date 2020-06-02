package com.moringaschool.ebeautyparlor.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.moringaschool.ebeautyparlor.R;
import com.moringaschool.ebeautyparlor.adapters.ParlorListAdapter;
import com.moringaschool.ebeautyparlor.models.BeautyParlor;;
import com.moringaschool.ebeautyparlor.network.SalonApi;
import com.moringaschool.ebeautyparlor.network.SalonClient;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class ParlorActivity extends AppCompatActivity {
    public static final String TAG = ParlorActivity.class.getSimpleName();
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    private ParlorListAdapter mAdapter;

    public List<BeautyParlor> parlors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parlor);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        SalonApi client = SalonClient.getClient();
        Call<List<BeautyParlor>> call = client.getBeautyParlor(location, "parlors");
        call.enqueue(new Callback<List<BeautyParlor>>() {
            @Override
            public void onResponse(Call<List<BeautyParlor>> call, Response<List<BeautyParlor>> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    parlors = response .body();
                    mAdapter = new ParlorListAdapter(ParlorActivity.this,parlors);
                    mRecyclerView .setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(ParlorActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                    showParlors();
                } else {
                    showUnsuccessfulMessage();
                }
            }

        @Override
            public void onFailure(Call<List<BeautyParlor>> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }

        });
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showParlors() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}