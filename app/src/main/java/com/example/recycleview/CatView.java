package com.example.recycleview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.adapter.CatAdapter;
import com.example.recycleview.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatView extends AppCompatActivity implements CatAdapter.CatItemListenner {

    private RecyclerView recyclerViewCat;
    private CatAdapter catAdapter;

    private Button  button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cat_view);
        button=findViewById(R.id.buttonAddNew);
        recyclerViewCat=findViewById(R.id.recyclerViewCat);
        catAdapter=new CatAdapter(getListCat());
        catAdapter.setCatItemListenner(this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewCat.setLayoutManager(gridLayoutManager);
        recyclerViewCat.setAdapter(catAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CatView.this, "Add new Cat", Toast.LENGTH_SHORT).show();
                List<Cat> listCat=catAdapter.getListCat();
                listCat.add(new Cat("New Cat",R.drawable.bootscat));
                catAdapter.notifyDataSetChanged();
            }
        });
    }
    private List<Cat> getListCat(){
        List<Cat> catList=new ArrayList<>();
        catList.add(new Cat("BootsCat",R.drawable.bootscat));
        catList.add(new Cat("Doremon",R.drawable.doremon));
        catList.add(new Cat("Tomcat",R.drawable.tomcat));
        catList.add(new Cat("Oggy",R.drawable.oggy));
        catList.add(new Cat("Topcat",R.drawable.topcat));
        catList.add(new Cat("Tomjerry",R.drawable.tomjerry));
        return  catList;
    }

    @Override
    public void onCatClick(View view, int postion) {
        Cat cat=getListCat().get(postion);
        Toast.makeText(this, cat.getName(), Toast.LENGTH_SHORT).show();
    }
}