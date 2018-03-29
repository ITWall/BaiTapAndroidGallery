package com.example.hungnv.baitapandroidgallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by hungnv on 3/29/2018.
 */

public class DetailImageAdapter extends RecyclerView.Adapter<DetailImageAdapter.ViewHolder>{
    ArrayList<Integer> listImages;
    Context context;
    int imagePosition;
    IChangeImage iChangeImage;

    public DetailImageAdapter(ArrayList<Integer> listImages, Context context, int imagePosition, IChangeImage iChangeImage) {
        this.listImages = listImages;
        this.context = context;
        this.imagePosition = imagePosition;
        this.iChangeImage = iChangeImage;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item, null);
        v.setPadding(8,0,4,0);
        return new ViewHolder(v);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.ivItem.setImageResource(listImages.get(position));
        if(position == imagePosition){
            holder.ivItem.clearColorFilter();
        }else{
            holder.ivItem.setColorFilter(Color.parseColor(context.getResources().getString(R.color.colorFilter)));
        }
        holder.ivItem.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                iChangeImage.onChangeImage(listImages.get(position));
                imagePosition = position;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listImages.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivItem;
        @SuppressLint("ResourceType")
        public ViewHolder(View itemView) {
            super(itemView);
            ivItem = itemView.findViewById(R.id.ivItem);
        }
    }
}
