package com.example.ecom.options;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ecom.R;
import com.example.ecom.utility.CompareData;
import com.example.ecom.utility.CompareFeatureCategoryAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.LinkedHashMap;

public class CompareActivity extends AppCompatActivity {
    private LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String,String>>> products =
                        new  LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String,String>>>();
    private SimpleDraweeView phone1;
    private SimpleDraweeView phone2;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);
        CompareData dataObj = new CompareData();                                   
        products = dataObj.productsListMap;
        phone1 = (SimpleDraweeView) findViewById(R.id.img1);
        phone2 = (SimpleDraweeView)findViewById(R.id.img2);

        Uri uri1 = Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTew8sG-D-Is6ZoK4JuZ_zmUY4AxSqtwkzGmHkLfglVHQTM7tER&usqp=CAU");
        phone1.setImageURI(uri1);

        Uri uri2 = Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQLEEveHak7ZlBytszZDNSjK3RqZ2KYCGVMB8RnNOnBgmlpJahX&usqp=CAU");
        phone2.setImageURI(uri2);
        initRecyclerView();
    }

    private void initRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.compare_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(CompareActivity.this));
        recyclerView.setHasFixedSize(true);
         
        CompareFeatureCategoryAdapter parentAdapter = new CompareFeatureCategoryAdapter(CompareActivity.this,
                products.get("OnePlus 8"), products.get("Samsung Galaxy S10 plus"));
        recyclerView.setAdapter(parentAdapter);
        parentAdapter.notifyDataSetChanged();
    }
        
}
                                                   