package com.example.gosmart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //set profile image
        ImageView profile_image = (ImageView) findViewById(R.id.profile_image);
        profile_image.setImageResource(R.drawable.photo);

        String[] shops = {"BigBazaar", "Reliance Fresh", "Vishal Mega Mart", "mBazaar", "Patanjali", "The Body Shop"};
        ListAdapter raimaAdapter = new customAdapter(this, shops);
        //responsible to take array and arrange in a list

        ListView shopList = (ListView) findViewById(R.id.shopList);
        shopList.setAdapter(raimaAdapter);//adapter to convert food array to a list

        //now what will happen when list is selected
        shopList.setOnItemClickListener(//listener to listen to a click on an item
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String shop1 = String.valueOf(adapterView.getItemAtPosition(i));
                        String shop = shop1.concat(" welcomes you!");
                        Toast.makeText(Main2Activity.this, shop, Toast.LENGTH_LONG).show();
                        shop = "";
                        long futureTime = System.currentTimeMillis() + 40000;
                        try {
                            wait(futureTime);
                        } catch (Exception e) {
                        }
                        if (shop1 == "BigBazaar") {
                            onClickBigBazaar(view);
                        } else if (shop1 == "Reliance Fresh") {
                            onClickRelianceFresh(view);
                        } else if (shop1 == "Vishal Mega Mart") {
                            onClickVishal(view);
                        } else if (shop1 == "mBazaar") {
                            onClickmBazaar(view);
                        } else if (shop1 == "Patanjali") {
                            onClickPatanjali(view);
                        } else if (shop1 == "The Body Shop") {
                            onClickBodyShop(view);
                        }
                    }
                }
        );

        Bundle nameData = getIntent().getExtras();//allow ability to get data from previous activity

        String LogInMessage = nameData.getString("LogInMessage");//get extra information in string
        String LogInMessage1 = "Welcome ";
        String LogInMessage2 = LogInMessage1.concat(LogInMessage);
        final TextView showUser = (TextView) findViewById(R.id.showUser);
        showUser.setText(LogInMessage2);

    }
    //listener for knowing availability
    public void knowAvailability(View view) {
        Intent a = new Intent(this, Availability.class);
        startActivity(a);
    }
    //listener for finding product
    public void findProduct(View view) {
        Intent a = new Intent(this, FindingProduct.class);
        startActivity(a);
    }

    //listener for start shopping
    public void startShopping(View view) {
        Intent a = new Intent(this,startShopping.class);
        startActivity(a);
    }

    public void onClickBigBazaar(View view) {
        Intent i = new Intent(this, LinkBigBazaar.class);
        startActivity(i);
    }

    public void onClickRelianceFresh(View view) {
        Intent j = new Intent(this, LinkRelianceFresh.class);
        startActivity(j);
    }

    public void onClickVishal(View view) {
        Intent k = new Intent(this, LinkVishal.class);
        startActivity(k);
    }

    public void onClickmBazaar(View view) {
        Intent m = new Intent(this, LinkmBazaar.class);
        startActivity(m);
    }

    public void onClickPatanjali(View view) {
        Intent n = new Intent(this, LinkPatanjali.class);
        startActivity(n);
    }

    public void onClickBodyShop(View view) {
        Intent o = new Intent(this, LinkBodyShop.class);
        startActivity(o);
    }
}