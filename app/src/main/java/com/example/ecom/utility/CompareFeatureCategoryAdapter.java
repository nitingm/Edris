package com.example.ecom.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ecom.R;

import java.util.LinkedHashMap;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CompareFeatureCategoryAdapter extends RecyclerView.Adapter<CompareFeatureCategoryAdapter.ViewHolder>{
    private static final String TAG = "CompareFeatureCategoryAdapter";
    private Context mContext;
    private LinkedHashMap<String, LinkedHashMap<String, String>> ph1;
    private LinkedHashMap<String, LinkedHashMap<String, String>> ph2;

    public CompareFeatureCategoryAdapter (Context context, LinkedHashMap<String,LinkedHashMap<String, String>> ph1,
                                   LinkedHashMap<String, LinkedHashMap<String, String>> ph2) {
        mContext = context;
        this.ph1 = ph1;
        this.ph2 = ph2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feature_category, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String key1 = (String)ph1.keySet().toArray()[position];
        String key2 = (String)ph2.keySet().toArray()[position];
        holder.categoryFeature.setText((String)ph1.keySet().toArray()[position]);
        CompareFeatureAdapter childAdapter = new CompareFeatureAdapter(mContext,ph1.get(key1),ph2.get(key2));
        holder.childrecycler.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
        holder.childrecycler.setHasFixedSize(true);
        holder.childrecycler.setAdapter(childAdapter);
        childAdapter.notifyDataSetChanged();
        //holder.childrecycler.setNestedScrollingEnabled(false);
    }

    @Override
    public int getItemCount() {
        return ph1.values().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryFeature;
        RecyclerView childrecycler;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryFeature = (TextView) itemView.findViewById(R.id.category_feature);
            childrecycler = (RecyclerView) itemView.findViewById(R.id.feature_recycler);
        }
    }
}
