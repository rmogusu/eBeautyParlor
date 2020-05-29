package com.moringaschool.ebeautyparlor.ui;

import androidx.appcompat.app.AppCompatActivity;

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

import butterknife.BindView;
import butterknife.ButterKnife;

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

        BeautyParlorArrayAdapter adapter = new BeautyParlorArrayAdapter(this, android.R.layout.simple_list_item_1, parlor, services);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String pet = ((TextView) view).getText().toString();
                Log.v(TAG, "In the onItemClickListener!");
                Toast.makeText(ParlorActivity.this, pet, Toast.LENGTH_LONG).show();
            }

        });
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the beauty parlor near: " + location);
        Log.d(TAG, "In the onCreate method!");

    }

}