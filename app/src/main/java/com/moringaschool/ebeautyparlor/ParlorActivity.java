package com.moringaschool.ebeautyparlor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ParlorActivity extends AppCompatActivity {
    public static final String TAG = ParlorActivity.class.getSimpleName();
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;
    private String[] parlor = new String[]{"London", "Storm",
            "Atlas", "Artemus", "pampurr", "Scrodinger",
            "Powder", "Zelda", "sisto", "Andy and leah",
            "Abel", "Frazzle", "Sabrina",
            "cyborg", "Chip", "Modecai", "Elsa", "Milo", "Nova", "Quarry", "Jasmine", "Bella",
            "Furry", "Dunkin", "Sync", "Izzy", "Tulsa"};
    private String[] services = new String[]{"Abyssinian", "American Bobtail", "American curl",
            "American Shorthair", "American Wirehair", "Applehead Siamese"
            , "Balinese", "Bengal", "Birman", "Bombay", "British Shorthair",
            "Burmese", "Burmilla", "Calico", "Canadian Hairless", "Chartreux", "Chausie", "Chinchilla", "Cymric", "Devon Rex",
            "Dilute Calico", "Domestic Long Hair", "Domestic Medium Hair", "Egyptian Mau", "Exotic Shorthair", "Havana", "Himalayan"};

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
        mLocationTextView.setText("Available parlor for you : " + location);
        Log.d(TAG, "In the onCreate method!");
    }
}