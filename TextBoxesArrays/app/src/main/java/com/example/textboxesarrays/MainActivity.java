package com.example.textboxesarrays;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btn_j_addRestaurant;
    Button btn_j_pickRestaurant;

    EditText et_j_newRestaurant;
    TextView txt_j_restaurant;
    TextView txt_j_errorNoRestaurant;
    int count=0;
    int randomPos;
    private String[] restaurants = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_j_addRestaurant = findViewById(R.id.btn_v_addRestaurant);
        btn_j_pickRestaurant = findViewById(R.id.btn_v_pickRestaurant);
        et_j_newRestaurant = findViewById(R.id.et_v_newRestaurant);
        txt_j_restaurant = findViewById(R.id.txt_v_restaurant);
        txt_j_errorNoRestaurant=findViewById(R.id.txt_v_errorNoRestaurant);

        //testing to make sure I can edit the text view
        txt_j_restaurant.setText("Hello");

        addRestaurantButtonEvent();
        pickRestaurantButtonEvent();
    }

    public void addRestaurantButtonEvent() {
        btn_j_addRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Add", "Add button pressed");
                //Check to see if the array is full
                //If not full add restaurant to array
                if (checkArrayFull())
                {

                    //do something so the user cannot add more restaurants
                    txt_j_errorNoRestaurant.setText("List is full. Click find restaurant.");
                    txt_j_errorNoRestaurant.setVisibility(View.VISIBLE);
                }
                else
                {

                    //If not full add restaurant to array
                    //If not full add restaurant to array
                    //Get the value from the edit text and convert to a string
                    //strings are compared in java using .equals
                    if (!et_j_newRestaurant.getText().toString().equals(""))
                    {
                        //Remove Error Message
                        txt_j_errorNoRestaurant.setVisibility(View.INVISIBLE);
                        //add to array
                        restaurants[count]=et_j_newRestaurant.getText().toString();
                        count++;
                        //Clear Textbox
                        et_j_newRestaurant.setText("");
                    }
                    else
                    {
                        //Error: enter a restaurant
                        txt_j_errorNoRestaurant.setText(("ERROR: Please pick a restaurant"));
                        txt_j_errorNoRestaurant.setVisibility(View.VISIBLE);
                    }
                }

            }
        });
    }

    public void pickRestaurantButtonEvent() {
        btn_j_pickRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Pick", "Pick button pressed");


                //If something is stored in the array then display
                if(count>0)
                {
                    randomPos=(int)Math.random()*count;
                    displayRestaurants();
                    txt_j_restaurant.setText(restaurants[randomPos]);
                }
                else
                {
                    txt_j_errorNoRestaurant.setText(("Cannot pick when nothing is in array."));
                    txt_j_errorNoRestaurant.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void clickRestaurantEditTextEvent()
    {
        et_j_newRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    public boolean checkArrayFull()
    {
        //Log.d("Length",restaurants.length+"");
        if (count < 6)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public void displayRestaurants()
    {
        for(int i=0; i< restaurants.length; i++)
        {
            //Only display if there is something stored in the array at position i
            if(restaurants[i]!=null)
            {
                Log.d("Restaurant",restaurants[i]);
            }
        }
    }
}



