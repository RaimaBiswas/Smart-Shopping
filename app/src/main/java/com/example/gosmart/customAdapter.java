package com.example.gosmart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customAdapter extends ArrayAdapter {

    customAdapter(@NonNull Context context,String [] shops) {
        super(context, R.layout.custom_row_listview,shops);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater raimaInflater=LayoutInflater.from(getContext());
        View customView = raimaInflater.inflate(R.layout.custom_row_listview,parent,false);

        String singleShopItem= (String) getItem(position);//reference to items in foods array
        TextView shopName = (TextView)customView.findViewById(R.id.shopName);//reference to textView in custom_row
        ImageView storeImage = (ImageView)customView.findViewById(R.id.storeImage);//reference to imageView in custom_row

        if(singleShopItem=="BigBazaar") {
            shopName.setText(singleShopItem);
            storeImage.setImageResource(R.drawable.bigbazaarlogo);
        }

        else if(singleShopItem=="Reliance Fresh") {
            shopName.setText(singleShopItem);
            storeImage.setImageResource(R.drawable.reliance);
        }
        else if(singleShopItem=="Vishal Mega Mart") {
            shopName.setText(singleShopItem);
            storeImage.setImageResource(R.drawable.vishal);
        }
        else if(singleShopItem=="mBazaar") {
            shopName.setText(singleShopItem);
            storeImage.setImageResource(R.drawable.mbazaar);
        }
        else if(singleShopItem=="Patanjali"){
            shopName.setText(singleShopItem);
            storeImage.setImageResource(R.drawable.patanjali);
        }
        else if(singleShopItem=="The Body Shop"){
            shopName.setText(singleShopItem);
            storeImage.setImageResource(R.drawable.bodylogo);
        }
        return customView;
    }
}