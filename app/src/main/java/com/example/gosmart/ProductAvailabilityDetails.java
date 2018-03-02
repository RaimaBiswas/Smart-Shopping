package com.example.gosmart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tamalbhattacharya on 08/07/2017.
 */

public class ProductAvailabilityDetails extends Activity {
    private TextView product;
    private TextView store;
    private TextView section;
    private TextView aisle;
    private TextView shelf;
    private ImageView plan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_availability_details);
        product = (TextView) findViewById(R.id.product);
        store = (TextView) findViewById(R.id.store);
        section = (TextView) findViewById(R.id.section);
        aisle = (TextView) findViewById(R.id.aisle);
        shelf = (TextView) findViewById(R.id.shelf);
        plan = (ImageView) findViewById(R.id.plan);

        Intent intent = getIntent();
        ProductAvailability availability = (ProductAvailability) intent.getSerializableExtra("DATA");
        store.setText("Store : " + availability.getStore());
        section.setText("Section : " + availability.getSection());
        aisle.setText("Aisle : " + availability.getAisle());
        shelf.setText("Shelf : " + availability.getShelf());

        if (availability.getStore().equalsIgnoreCase("BigBazaar")) {
            store.setText("BigBazaar");
            plan.setImageResource(R.drawable.bigbazaar_plan);
        } else if (availability.getStore().equalsIgnoreCase("RelianceFresh")) {
            store.setText("Reliance Fresh");
            plan.setImageResource(R.drawable.reliance_plan);
        } else if (availability.getStore().equalsIgnoreCase("Vishal")) {
            store.setText("Vishal Mega Mart");
            plan.setImageResource(R.drawable.vishal_plan);
        } else if (availability.getStore().equalsIgnoreCase("mBazaar")) {
            store.setText("mBazaar");
            plan.setImageResource(R.drawable.mbazaar_plan);
        } else if (availability.getStore().equalsIgnoreCase("Patanjali")) {
            store.setText("Patanjali");
            plan.setImageResource(R.drawable.patanjali_plan);
        } else if (availability.getStore().equalsIgnoreCase("BodyShop")) {
            store.setText("The Body Shop");
            plan.setImageResource(R.drawable.bodyshop_plan);
        }
    }

}
