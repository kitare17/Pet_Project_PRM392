package com.example.recycleview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.adapter.ShopAdapter;
import com.example.recycleview.database.ShopDB;
import com.example.recycleview.model.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopLab extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ImageView imageViewAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shop_lab2);


        recyclerView=findViewById(R.id.recycler_view_shop);
        List<Shop> shopList=getListShop();
        ShopAdapter shopAdapter=new ShopAdapter(shopList);


        recyclerView.setAdapter(shopAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        imageViewAdd=findViewById(R.id.image_view_add);

        imageViewAdd.setOnClickListener(v -> {
            ShopDB shopDB = new ShopDB(this);
            shopDB.insertShop("Shop 1", R.drawable.doremon);
            Toast.makeText(this, "Shop added", Toast.LENGTH_SHORT).show();
            List<Shop> shops=getListShop();
            shopAdapter.setShopList(shops);
            shopAdapter.notifyDataSetChanged();
        });
    }

    public  List<Shop> getListShop(){
        ShopDB shopDB = new ShopDB(this);
        List<Shop> shopList = shopDB.getAllShop();

        return shopList;
    }

    public  void insertShop(){

    }
}