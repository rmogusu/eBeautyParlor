package com.moringaschool.ebeautyparlor.ui;

import android.content.Intent;
import android.icu.util.ULocale;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.ebeautyparlor.R;
import com.moringaschool.ebeautyparlor.models.BeautyParlor;
import com.moringaschool.ebeautyparlor.models.Parlor;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ParlorDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParlorDetailFragment extends Fragment implements View.OnClickListener{


        @BindView(R.id.parlorImageView)
        ImageView mImageLabel;
        @BindView(R.id.parlorNameTextView)
        TextView mNameLabel;
        @BindView(R.id.styleTextView) TextView mCategoriesLabel;
        @BindView(R.id.ratingTextView) TextView mRatingLabel;
        @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
        @BindView(R.id.phoneTextView) TextView mPhoneLabel;
        @BindView(R.id.addressTextView) TextView mAddressLabel;
        @BindView(R.id.saveParlorButton) TextView mSaveRestaurantButton;

        private BeautyParlor   mParlor;

        public ParlorDetailFragment() {
            // Required empty public constructor
        }

        public static ParlorDetailFragment newInstance(BeautyParlor  parlor ) {
            ParlorDetailFragment parlorDetailFragment = new ParlorDetailFragment();
            Bundle args = new Bundle();
            args.putParcelable("parlor", Parcels.wrap(parlor));
            parlorDetailFragment.setArguments(args);
            return parlorDetailFragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mParlor  = Parcels.unwrap(getArguments().getParcelable("parlor"));
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_parlor_detail, container, false);
            ButterKnife.bind(this, view);

            Picasso.get().load(mParlor.getImageUrl()).into(mImageLabel);
            List<String> categories = new ArrayList<>();

//            for (Category category: mParlor .getCategories()) {
//                categories.add(category.getTitle());
//                mWebsiteLabel.setOnClickListener(this);
//                mPhoneLabel.setOnClickListener(this);
//                mAddressLabel.setOnClickListener(this);
//                return view;
//            }

            mNameLabel.setText(mParlor .getName());
            //mCategoriesLabel.setText(android.text.TextUtils.join(", ", categories));
            mRatingLabel.setText(Double.toString(mParlor.getRating()) + "/5");
            mPhoneLabel.setText(mParlor.getPhone());
            mAddressLabel.setText(mParlor.getAddress());

            return view;
        }
        @Override
        public void onClick(View v) {
//            if (v == mWebsiteLabel) {
//                Intent webIntent = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse(mParlor.getUrl()));
//                startActivity(webIntent);
//            }
            if (v == mPhoneLabel) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + mParlor.getPhone()));
                startActivity(phoneIntent);
            }
//            if (v == mAddressLabel) {
//                Intent mapIntent = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("geo:" + mParlor .getCoordinates().getLatitude()
//                                + "," + mRestaurant.getCoordinates().getLongitude()
//                                + "?q=(" + mRestaurant.getName() + ")"));
//                startActivity(mapIntent);
//            }
        }
    }
