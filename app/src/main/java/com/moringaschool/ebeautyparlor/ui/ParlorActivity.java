package com.moringaschool.ebeautyparlor.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.ebeautyparlor.BeautyParlorArrayAdapter;
import com.moringaschool.ebeautyparlor.R;
import com.moringaschool.ebeautyparlor.adapters.ParlorListAdapter;
import com.moringaschool.ebeautyparlor.services.SalonService;

import java.io.IOException;
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



    private String[] parlor = new String[]{"Beauty point", "Dida beauty parlor", "Sunsession beauty", " Amadivar beauty parlor", " StylePro point",
            "Superior point", "Brows salon", "farouk beauty", "New look",
            "Modern hair salon", "Belle beauty", "Yeshi parlor",
            "Beauty Hub", "Beauty solution", "Ladies bolsos", "Halda naturals", "Lock avenue", "Beauty point", "Jasmine beauty point", "Bella beauty parlor",
            "Maya salon kenya", "City girl place", "Bruno beauty point", "Emmah beauty parlor", "Natuaral beauty parlor"};
    private String[] services = new String[]{"Twists", "Short Wavy Bob", "Box braid hairstyles",
            "Cornrows braids", "Manicure and pedicure", "Soft dreadlocks"
            , " Facial make up", "Mohawk hair style", "french braid", "ponytail", "curly",
            "Natural hairstyle", "Box braid", "Dutch braid", "Crotchet braids", "Lemonade braids", "Fishtail braid", "Feed-in braid", "Godness braid", "Braided buns",
            "Triabal braids", "Fulani braids", "Waterfall braids", "Yarn braids", "Crown braids"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parlor);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        BeautyParlorArrayAdapter adapter = new BeautyParlorArrayAdapter(this, android.R.layout.simple_list_item_1, parlor, services);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String parlor = ((TextView) view).getText().toString();
                Log.v(TAG, "In the onItemClickListener!");
                Toast.makeText(ParlorActivity.this, parlor, Toast.LENGTH_LONG).show();
            }

        });
        mLocationTextView.setText("Here are all the beauty parlor near: " + location);
        getBeautyParlor(location);
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
                try{
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }) ;
    }
}
