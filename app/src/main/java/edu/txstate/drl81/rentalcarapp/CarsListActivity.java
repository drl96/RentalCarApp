package edu.txstate.drl81.rentalcarapp;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.message.BasicHeader;

public class CarsListActivity extends ListActivity {

//    int[] intCarIds = {101, 102, 103, 104, 105};
//    String[] strCarNames = {"Camaro", "Mustang", "Frontier", "Accord", "Avalon"};
//    String[] strBrands = {"Chevrolet", "Ford", "Nissan", "Honda", "Toyota"};
//    float[] dblRentalCosts = {250, 200, 223, 123, 155};
//    String[] strCarUrls = {"https://www.chevrolet.com/performance/camaro-sports-car", "https://www.ford.com/cars/mustang/", "https://www.nissanusa.com/vehicles/trucks/frontier.html", "https://automobiles.honda.com/accord-sedan", "https://www.toyota.com/avalon/"};

    int[] carImage = {R.drawable.car_image_forground, 0, 0, 0, 0 };    //code for car images goes here

    List<Car> rentalCars;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCars();
    }

    protected void getCars(){
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("Accept", "application/json"));
        CarRestClient.get(CarsListActivity.this,"rentalcars.json", headers.toArray(new Header[headers.size()]), null,new JsonHttpResponseHandler(){
            public void onSuccess(int statusCode, Header[] headers, JSONArray response){
                rentalCars = new ArrayList<Car>();
                for(int i = 0; i < response.length(); i++){
                    try{
                        rentalCars.add(new Car(response.getJSONObject(i)));
                    }catch(Exception ex){ex.printStackTrace();}
                }
                setListAdapter(new ArrayAdapter<Car>(CarsListActivity.this,R.layout.activity_cars_list,R.id.txtCars, rentalCars));
            }
        });
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {//position = index

        Car selectedCar =  rentalCars.get(position);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(CarsListActivity.this);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putInt("id", selectedCar.getId());
        editor.putString("name",selectedCar.getName());
        editor.putString("brand",selectedCar.getBrand());
        editor.putFloat("cost", (float)selectedCar.getCost());
        editor.putString("url", selectedCar.getUrl());
        editor.putString("color", selectedCar.getColor());
        editor.putInt("position", position);
        editor.commit();


        startActivity(new Intent(CarsListActivity.this, SelectedCarInfoActivity.class));

        //DecimalFormat tenth = new DecimalFormat("$###,###.##");

    }
}

