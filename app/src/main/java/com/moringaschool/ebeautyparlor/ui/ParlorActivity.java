package com.moringaschool.ebeautyparlor.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.ebeautyparlor.BeautyParlorArrayAdapter;
import com.moringaschool.ebeautyparlor.R;
import com.moringaschool.ebeautyparlor.adapters.ParlorListAdapter;
import com.moringaschool.ebeautyparlor.models.BeautyParlor;
import com.moringaschool.ebeautyparlor.services.SalonService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ParlorActivity extends AppCompatActivity {
    public static final String TAG = ParlorActivity.class.getSimpleName();
    @BindView(R.id.locationTextView)
    TextView mLocationTextView;
    @BindView(R.id.listView)
    ListView mListView;
    public ArrayList<BeautyParlor> mBeautyparlors = new ArrayList<>();

//    private String[] parlor = new String[]{"Beauty point", "Dida beauty parlor", "Sunsession beauty", " Amadivar beauty parlor", " StylePro point",
//            "Superior point", "Brows salon", "farouk beauty", "New look",
//            "Modern hair salon", "Belle beauty", "Yeshi parlor",
//            "Beauty Hub", "Beauty solution", "Ladies bolsos", "Halda naturals", "Lock avenue", "Beauty point", "Jasmine beauty point", "Bella beauty parlor",
//            "Maya salon kenya", "City girl place", "Bruno beauty point", "Emmah beauty parlor", "Natuaral beauty parlor"};
//    private String[] services = new String[]{"Twists", "Short Wavy Bob", "Box braid hairstyles",
//            "Cornrows braids", "Manicure and pedicure", "Soft dreadlocks"
//            , " Facial make up", "Mohawk hair style", "french braid", "ponytail", "curly",
//            "Natural hairstyle", "Box braid", "Dutch braid", "Crotchet braids", "Lemonade braids", "Fishtail braid", "Feed-in braid", "Godness braid", "Braided buns",
//            "Triabal braids", "Fulani braids", "Waterfall braids", "Yarn braids", "Crown braids"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parlor);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the beauty parlor near: " + location);
        getBeautyParlor(location) ;

    }

    private void getBeautyParlor(String location){
        final SalonService salonService = new SalonService();
        salonService.findBeautyParlor(location, new Callback(){

            @Override
            public void onFailure(Call call, IOException e){
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                 mBeautyparlors = salonService.processResults(response);
                ParlorActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] beautyparlorNames = new String[mBeautyparlors.size()];
                        for(int i = 0; i<beautyparlorNames.length;i++){
                            beautyparlorNames[i]=mBeautyparlors.get(i).getName();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(ParlorActivity.this, android.R.layout.simple_list_item_1, beautyparlorNames);
                        mListView.setAdapter(adapter);
                        for (BeautyParlor  beautyParlor : mBeautyparlors) {
                            Log.d(TAG, "Name: " + beautyParlor.getName());
                            Log.d(TAG, "Phone: " + beautyParlor.getPhone());
                            Log.d(TAG, "Website: " + beautyParlor.getWebsite());
                            Log.d(TAG, "Image url: " + beautyParlor.getImageUrl());
                            Log.d(TAG, "Rating: " + Double.toString(beautyParlor.getRating()));
                            Log.d(TAG, "Address: " + android.text.TextUtils.join(", ", beautyParlor.getAddress()));
                            Log.d(TAG, "Categories: " + beautyParlor.getCategories().toString());
                        }
                    }
                });
            }
        });
    }

}
