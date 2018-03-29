package com.example.hungnv.baitapandroidgallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements IChangeImage{
    ImageView ivDetail;
    RecyclerView rvAllImages;
    private DetailImageAdapter adapter;
    private ArrayList<Integer> listImages = new ArrayList<>();
    private IChangeImage iChangeImage = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ivDetail = findViewById(R.id.ivDetail);
        rvAllImages = findViewById(R.id.rvAllImages);
        int idImage = getIntent().getIntExtra(getResources().getString(R.string.image_id),0);
        ivDetail.setImageResource(idImage);
        init();
        adapter = new DetailImageAdapter(listImages, this, listImages.indexOf(idImage), iChangeImage);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvAllImages.setLayoutManager(layoutManager);
        rvAllImages.setAdapter(adapter);
        rvAllImages.scrollToPosition(listImages.indexOf(idImage));

    }

    public void init(){
        listImages.add(R.drawable.brain);
        listImages.add(R.drawable.salt);
        listImages.add(R.drawable.doge);
        listImages.add(R.drawable.cat);
    }

    @Override
    public void onChangeImage(int idImage) {
        ivDetail.setImageResource(idImage);
    }
}
