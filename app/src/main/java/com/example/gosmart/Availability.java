package com.example.gosmart;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class Availability extends AppCompatActivity {

    private EditText searchText;
    private Button searchButton;
    private ListView results;
    private PreLoadedDBHelper mDBHelper;
    private SQLiteDatabase mDb;
    private List<ProductAvailability> productAvailabilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.availability);
        searchText = (EditText) findViewById(R.id.searchProduct);
        searchButton = (Button) findViewById(R.id.search_button);
        results = (ListView) findViewById(R.id.search_results);
        mDBHelper = new PreLoadedDBHelper(this);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchForMatchingProduct();
                ;
            }
        });
        results.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Availability.this, ProductAvailabilityDetails.class);
                intent.putExtra("DATA", productAvailabilities.get(position));
                startActivity(intent);
            }
        });
    }

    private void searchForMatchingProduct() {
        String prod = searchText.getText().toString();
        if (prod != null && prod != "") {
            SearchProductTask task = new SearchProductTask(prod);
            task.execute();
        }
    }

    private void displayStoreList(List<ProductAvailability> availabilityList) {
        this.productAvailabilities = availabilityList;
        if (availabilityList.size() > 0) {
            ProductAvailabilityAdapter adapter = new ProductAvailabilityAdapter(this, availabilityList);
            results.setAdapter(adapter);
        } else {
            results.setAdapter(null);
        }
    }

    private class SearchProductTask extends AsyncTask<Void, Void, List<ProductAvailability>> {

        private String prod;

        SearchProductTask(String prod) {
            this.prod = prod;
        }

        @Override
        protected List<ProductAvailability> doInBackground(Void... params) {
            return mDBHelper.getMatchingStoreList(prod);
        }

        @Override
        protected void onPostExecute(List<ProductAvailability> productAvailabilities) {
            displayStoreList(productAvailabilities);
            super.onPostExecute(productAvailabilities);
        }
    }
}

