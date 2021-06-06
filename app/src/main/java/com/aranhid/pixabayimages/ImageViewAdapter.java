package com.aranhid.pixabayimages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageViewAdapter extends RecyclerView.Adapter<ImageViewAdapter.ViewHolder> {
    ArrayList<Hit> hits;

    public ImageViewAdapter(ArrayList<Hit> hits) {
        super();
        this.hits = hits;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindTo(hits.get(position));
    }

    @Override
    public int getItemCount() {
        return hits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView tvUser;
        TextView tvTags;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            tvUser = itemView.findViewById(R.id.imageUser);
            tvTags = itemView.findViewById(R.id.imageTags);
        }

        public void bindTo(Hit hit) {
            Picasso.get().load(hit.webformatURL).into(imageView);
            tvUser.setText(hit.user);
            tvTags.setText(hit.tags);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
