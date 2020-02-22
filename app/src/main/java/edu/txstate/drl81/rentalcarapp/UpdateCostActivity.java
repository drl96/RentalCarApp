package edu.txstate.drl81.rentalcarapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.TextHttpResponseHandler;

import java.text.DecimalFormat;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;

public class UpdateCostActivity extends AppCompatActivity {

    private int idUpdate;
    private String nameUpdate;
    private int positionUpdate;
    DecimalFormat currency = new DecimalFormat("###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cost);

        final TextView txtDispIDandName = findViewById(R.id.txtDispIDandName);
        final EditText txtNewCostInput = findViewById(R.id.txtNewCostInput);
        Button btnUpdate = findViewById(R.id.btnUpdate);
        Button btnHome = findViewById(R.id.btnHome);

        SharedPreferences sharedPref3 = PreferenceManager.getDefaultSharedPreferences(this);
        idUpdate = sharedPref3.getInt("id", 0);
        nameUpdate = sharedPref3.getString("name", "No name found.");
        positionUpdate = sharedPref3.getInt("position", 0);

        txtDispIDandName.setText("Car ID: " + idUpdate + "\n" + "Car Name: " + nameUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String url = "rentalcars/" + positionUpdate + "/rent.json";
                StringEntity entity = null;
                try {
                    String rentText = txtNewCostInput.getText().toString();
                    float newRent;

                    if(rentText.equals("")) {
                        Toast.makeText(UpdateCostActivity.this, "Please enter a rental cost.", Toast.LENGTH_SHORT).show();
                        return;
                    }else {
                        newRent = Float.parseFloat(rentText);
                        entity = new StringEntity("" + currency.format(newRent));
                    }

                }  catch(Exception ex) {
                    ex.printStackTrace();
                }
                entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/text"));
                CarRestClient.put(UpdateCostActivity.this, url, entity,
                        "application/text", new TextHttpResponseHandler(){
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                                Toast.makeText(UpdateCostActivity.this, "success", Toast.LENGTH_LONG).show();

                            }
                            @Override
                            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                                Toast.makeText(UpdateCostActivity.this, responseString, Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateCostActivity.this, MainActivity.class));
            }
        });

    }
}
