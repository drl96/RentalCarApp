package edu.txstate.drl81.rentalcarapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class SelectedCarInfoActivity extends AppCompatActivity {

    private int intId;
    private String name;
    private String brand;
    private float cost;
    private String carUrl;
    private String color;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_car_info);

        SharedPreferences sharedPref2 = PreferenceManager.getDefaultSharedPreferences(this);
        intId = sharedPref2.getInt("id", 0);
        name = sharedPref2.getString("name","");
        brand = sharedPref2.getString("brand", "");
        cost = sharedPref2.getFloat("cost", 0);
        carUrl = sharedPref2.getString("url", "");
        color = sharedPref2.getString("color", "No color found.");
        position = sharedPref2.getInt("position", 0);




        TextView txtCarInfo = (TextView) findViewById(R.id.txtDisplayCarInfo);
        DecimalFormat currency = new DecimalFormat("$###,##0.00");
        txtCarInfo.setText("Car ID: " + intId + "\n" + "Car Name: " + name + "\n" + "Car Brand: " + brand + "\n" + "Rental Cost Per Day: " + currency.format(cost));

        final Button btnCarInfo = findViewById(R.id.btnCarInfo);

        if (carUrl.equals("")){
            btnCarInfo.setEnabled(false);
        }

        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnCarInfo.isEnabled()){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(carUrl)));
                }
            }
        });


        final EditText txtNumberDays = findViewById(R.id.txtNumberDays);
        Button btnCalcTotal = findViewById(R.id.btnCalcTotal);

        btnCalcTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intNumDays = Integer.parseInt(txtNumberDays.getText().toString());
                if (intNumDays < 30){
                    float dblTotalCost = cost * intNumDays;
                    DecimalFormat currency = new DecimalFormat("$###,##0.00");
                    Toast.makeText(SelectedCarInfoActivity.this, "Total Cost:" + currency.format(dblTotalCost), Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(SelectedCarInfoActivity.this, "Please call 512-777-2222", Toast.LENGTH_LONG).show();

                }

            }
        });

        Button btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                startActivity(new Intent(SelectedCarInfoActivity.this, UpdateCostActivity.class));
            }
        });




    }
}
