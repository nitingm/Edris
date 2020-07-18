package com.example.ecom.product;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecom.R;
import com.example.ecom.fragments.ImageListFragment;
import com.example.ecom.fragments.ViewPagerActivity;
import com.example.ecom.notification.NotificationCountSetClass;
import com.example.ecom.options.CartListActivity;
import com.example.ecom.options.CompareActivity;
import com.example.ecom.startup.MainActivity;
import com.example.ecom.utility.ImageUrlUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailsActivity extends AppCompatActivity {
    int imagePosition;
    String stringImageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        SimpleDraweeView mImageView = (SimpleDraweeView)findViewById(R.id.image1);
        TextView textViewAddToCart = (TextView)findViewById(R.id.text_action_bottom1);
        TextView textViewBuyNow = (TextView)findViewById(R.id.text_action_bottom2);
        LinearLayout compare = (LinearLayout)findViewById(R.id.layout_action2);
        //Getting image uri from previous screen
        if (getIntent() != null) {
            stringImageUri = getIntent().getStringExtra(ImageListFragment.STRING_IMAGE_URI);
            imagePosition = getIntent().getIntExtra(ImageListFragment.STRING_IMAGE_URI,0);
        }
        Uri uri = Uri.parse(stringImageUri);
        mImageView.setImageURI(uri);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(ItemDetailsActivity.this, ViewPagerActivity.class);
                    intent.putExtra("position", imagePosition);
                    startActivity(intent);

            }
        });

        textViewAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                imageUrlUtils.addCartListImageUri(stringImageUri);
                Toast.makeText(ItemDetailsActivity.this,"Item added to cart.",Toast.LENGTH_SHORT).show();
                MainActivity.notificationCountCart++;
                NotificationCountSetClass.setNotifyCount(MainActivity.notificationCountCart);
            }
        });

        textViewBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                imageUrlUtils.addCartListImageUri(stringImageUri);
                MainActivity.notificationCountCart++;
                NotificationCountSetClass.setNotifyCount(MainActivity.notificationCountCart);
                startActivity(new Intent(ItemDetailsActivity.this, CartListActivity.class));

            }
        });

        compare.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                if(imageUrlUtils.getCompareListSize() < 2){
                    imageUrlUtils.addCompareListImageUri(stringImageUri);
                    Toast.makeText(ItemDetailsActivity.this,"Add another item to compare.",Toast.LENGTH_SHORT).show();
                }
                //fix the bug later
                //notifyDataSetChanged();
                if(imageUrlUtils.getCompareListSize() >= 2) {
                    Intent intent = new Intent(ItemDetailsActivity.this, CompareActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
