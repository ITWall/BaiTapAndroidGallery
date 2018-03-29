package com.example.hungnv.baitapandroidgallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvGallery;
    private GalleryAdapter adapter;
    private ArrayList<Integer> listImages = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvGallery = findViewById(R.id.rvGallery);
        init();
        adapter = new GalleryAdapter(listImages, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        rvGallery.setLayoutManager(layoutManager);
        rvGallery.setAdapter(adapter);
    }

    public void init(){
        listImages.add(R.drawable.brain);
        listImages.add(R.drawable.salt);
        listImages.add(R.drawable.doge);
        listImages.add(R.drawable.cat);
    }
}
