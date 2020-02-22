package edu.txstate.drl81.rentalcarapp;

import org.json.JSONObject;

public class Car {
    private int id;
    private String name;
    private String brand;
    private float cost;
    //private int image;
    private String url;
    private String color;

    public Car(JSONObject carObj){

        try{
            this.id = carObj.getInt("id");
            this.name = carObj.getString("name");
            this.brand = carObj.getString("brand");
            this.cost = (float)carObj.getDouble("rent");
            this.url = carObj.getString("url");
            this.color = carObj.getString("color");

        }
        catch(Exception ex) {ex.printStackTrace();}
    }
    
    public Car (int id, String name, String brand, float cost, String url, String color){//int image
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.cost = cost;
        //this.image = image;
        this.url = url;
        this.color = color;
    }

    public int getId() {return id;}
    public void setId(int id){this.id = id;}

    public String getName() {return name;}
    public void setName(String id){this.name = name;}

    public String getBrand() {return brand;}
    public void setBrand(String brand){this.brand = brand;}

    public float getCost(){return cost;}
    public void setCost(float cost) {this.cost = cost;}

//    public int getImage() {
//        return image;
//    }
//    public void setImage(int image) {
//        this.image = image;
//    }

    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url;}

    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}

    @Override
    public String toString() { return this.name; }
}