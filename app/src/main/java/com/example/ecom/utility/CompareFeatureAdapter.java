package com.example.ecom.utility;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ecom.R;

import java.util.LinkedHashMap;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CompareFeatureAdapter extends RecyclerView.Adapter<CompareFeatureAdapter.ViewHolder> {
    private static final String TAG = "CompareFeatureAdapter";
    private LinkedHashMap<String, String> ph1;
    private LinkedHashMap<String, String> ph2;
    private Context mcontext;
    public CompareFeatureAdapter(Context context, LinkedHashMap<String, String> ph1, LinkedHashMap<String, String> ph2) {
        this.ph1 = ph1;
        this.ph2 = ph2;
        mcontext = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.compare_feature, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG,"CompareFeatureAdapter: onBindViewHolder: called");

        holder.feature.setText(ph1.size() >= ph2.size() ?(String)ph1.keySet().toArray()[position] : (String)ph2.keySet().toArray()[position]);
        holder.product1.setText("OnePlus 8");
        holder.product2.setText("Samsung S10");
        holder.description1.setText(position < ph1.size() ? (String)ph1.values().toArray()[position] : "--");
        holder.description2.setText(position < ph2.size() ? (String)ph2.values().toArray()[position] : "--");
    }


    @Override
    public int getItemCount() {
        return ph1.values().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView feature;
        TextView product1;
        TextView product2;
        TextView description1;
        TextView description2;
        //LinearLayout featureLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            feature = (TextView) itemView.findViewById(R.id.feature);
            product1 = (TextView)itemView.findViewById(R.id.product_1_name);
            product2 = (TextView)itemView.findViewById(R.id.product_2_name);
            description1 = (TextView)itemView.findViewById(R.id.description1);
            description2 = (TextView)itemView.findViewById(R.id.description2);
            //featureLayout = (LinearLayout) itemView.findViewById(R.id.compare_feature_layout);
        }
    }
}