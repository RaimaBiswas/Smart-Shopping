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

import java.util.List;

public class ProductAvailabilityAdapter extends ArrayAdapter<ProductAvailability> {

    ProductAvailabilityAdapter(@NonNull Context context, List<ProductAvailability> productAvailabilities) {
        super(context, R.layout.custom_row_listview, productAvailabilities);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater raimaInflater = LayoutInflater.from(getContext());
        View customView = raimaInflater.inflate(R.layout.custom_row_listview, parent, false);

        ProductAvailability productAvailability = (ProductAvailability) getItem(position);//reference to items in foods array
        TextView shopName = (TextView) customView.findViewById(R.id.shopName);//reference to textView in custom_row
        ImageView storeImage = (ImageView) customView.findViewById(R.id.storeImage);//reference to imageView in custom_row

        if (productAvailability.getStore().equalsIgnoreCase("BigBazaar")) {
            shopName.setText("BigBazaar");
            storeImage.setImageResource(R.drawable.bigbazaarlogo);
        } else if (productAvailability.getStore().equalsIgnoreCase("RelianceFresh")) {
            shopName.setText("Reliance Fresh");
            storeImage.setImageResource(R.drawable.reliance);
        } else if (productAvailability.getStore().equalsIgnoreCase("Vishal")) {
            shopName.setText("Vishal Mega Mart");
            storeImage.setImageResource(R.drawable.vishal);
        } else if (productAvailability.getStore().equalsIgnoreCase("mBazaar")) {
            shopName.setText("mBazaar");
            storeImage.setImageResource(R.drawable.mbazaar);
        } else if (productAvailability.getStore().equalsIgnoreCase("Patanjali")) {
            shopName.setText("Patanjali");
            storeImage.setImageResource(R.drawable.patanjali);
        } else if (productAvailability.getStore().equalsIgnoreCase("BodyShop")) {
            shopName.setText("The Body Shop");
            storeImage.setImageResource(R.drawable.bodylogo);
        }
        return customView;
    }
}