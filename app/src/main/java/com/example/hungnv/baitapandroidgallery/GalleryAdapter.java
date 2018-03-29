package com.example.hungnv.baitapandroidgallery;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by hungnv on 3/29/2018.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder>{
    ArrayList<Integer> listImages;
    Context context;

    public GalleryAdapter(ArrayList<Integer> listImages, Context context) {
        this.listImages = listImages;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.ivItem.setImageResource(listImages.get(position));
        holder.ivItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(context.getResources().getString(R.string.image_id), listImages.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listImages.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivItem;
        public ViewHolder(View itemView) {
            super(itemView);
            ivItem = itemView.findViewById(R.id.ivItem);
        }
    }
}
