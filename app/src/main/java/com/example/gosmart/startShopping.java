package com.example.gosmart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class startShopping extends AppCompatActivity {

    Button scan;
    Button add;
    EditText txt;
    TextView disp;
    myDBHandler dbHandler;
    String barresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_shopping);
        init();
    }

    void init()
    {
        scan=(Button)findViewById(R.id.scan);
        add=(Button)findViewById(R.id.add);
        //txt=(EditText)findViewById(R.id.txt);
        disp=(TextView)findViewById(R.id.disp);
        dbHandler = new myDBHandler(this,null,null,1);
        operation();
    }

    void operation()
    {
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IntentIntegrator(startShopping.this).initiateScan();
            }
        });
        /*add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d[] = txt.getText().toString().split(",");
                Products product = new Products(d[0],d[1],d[2]);
                dbHandler.addProduct(product);
                //printDatabase();
            }
        });*/
    }

    public void printDatabase(String result)
    {
        String dbString = dbHandler.databaseToString(result);
        String oldstring = disp.getText().toString();
        String text = oldstring + dbString;
        disp.setText(text);
        //txt.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null)
        {
            if(result.getContents() == null)
            {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                barresult = result.getContents();
                printDatabase(barresult);
            }
        }
        else
        {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}