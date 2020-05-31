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
import com.moringaschool.ebeautyparlor.ui.ParlorActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ParlorListAdapter extends RecyclerView.Adapter<ParlorListAdapter.ParlorViewHolder>{
    private Context mContext;
    private String[] mParlor;
    private String[] mServices;

    public ParlorListAdapter(Context mContext, int resource, String[] mParlor, String[] mServices) {
        this.mContext = mContext;
        this.mContext = mContext;
        this.mParlor  = mParlor;
        this.mServices  = mServices;

    }


    @Override
    public ParlorListAdapter.ParlorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parlor_list_item, parent, false);
        ParlorViewHolder viewHolder = new ParlorViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ParlorListAdapter.ParlorViewHolder holder, int position) {
        String parlor= mParlor[position];
        String service = mServices[position];

    }

    @Override
    public int getItemCount() {
        return mParlor.length;
    }

    public class ParlorViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.parlorImageView) ImageView mParlorImageView;
        @BindView(R.id.parlorNameTextView) TextView mNameTextView;
        //@BindView(R.id.serTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public ParlorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindParlor(BeautyParlor parlors) {
//            mNameTextView.setText(restaurant.getName());
//            mCategoryTextView.setText(restaurant.getCategories().get(0).getTitle());
//            mRatingTextView.setText("Rating: " + restaurant.getRating() + "/5");
        }
        //public void bindRestaurant(Business restaurant) {
//            mNameTextView.setText(restaurant.getName());
//            mCategoryTextView.setText(restaurant.getCategories().get(0).getTitle());
//            mRatingTextView.setText("Rating: " + restaurant.getRating() + "/5");
//        }

    }
}
