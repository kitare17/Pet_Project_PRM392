package com.example.recycleview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.model.Cat;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder>{
    private List<Cat> listCat;

    private CatItemListenner catItemListenner;


    public void setCatItemListenner(CatItemListenner catItemListenner) {
        this.catItemListenner = catItemListenner;
    }

    public List<Cat> getListCat() {
        return listCat;
    }

    public CatItemListenner getCatItemListenner() {
        return catItemListenner;
    }

    public CatAdapter(List<Cat> listCat) {
        this.listCat = listCat;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat=listCat.get(position);
        holder.imageView.setImageResource(cat.getImage());
        holder.textView.setText(cat.getName());
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(), "You clicked on "+cat.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return listCat.size();
    }

    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imageView;
        private TextView textView;
//        private CardView cardView;
        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
//            cardView=itemView.findViewById(R.id.cardViewMain);
            imageView=itemView.findViewById(R.id.imageViewCat);
            textView=itemView.findViewById(R.id.textViewCat);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
              if(catItemListenner!=null){
                  catItemListenner.onCatClick(view,getAdapterPosition());
              }
        }
    }



    public interface CatItemListenner{
        public void onCatClick(View view,int postion);
    }
}
