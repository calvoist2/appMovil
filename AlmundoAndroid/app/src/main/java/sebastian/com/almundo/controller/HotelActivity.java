package sebastian.com.almundo.controller;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import sebastian.com.almundo.R;
import sebastian.com.almundo.model.Description;

/**
 * Created by Sebas on 8/01/2018.
 */

public class HotelActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    Description description=new Description();
    String API_KEY="AIzaSyCxEAVfUB6LRQhF9izYizUmRGtClBpss7o";
    ImageView map;
    TextView address;
    TextView swimmingPool;
    TextView freeInternet;
    TextView breakfast;
    ProgressDialog progressDialog;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        description.setHotel_idHotel(getIntent().getIntExtra("hotelId",0));
        description.setHotelName(getIntent().getStringExtra("hotelName"));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(description.getHotelName());


        String url="http://testhotels.herokuapp.com/application/json/descriptions/descriptions.php";
        setContentView(R.layout.activity_hotel);
        progressDialog= new ProgressDialog(this);

        progressDialog.show();


        TextView hotelName = (TextView)findViewById(R.id.hotelNameDescription);
        hotelName.setText(description.getHotelName());
        RatingBar ratingBar=(RatingBar) findViewById(R.id.ratingDescription);
        ratingBar.setRating(getIntent().getIntExtra("rating",0));
        address=(TextView)findViewById(R.id.address);
        swimmingPool=(TextView)findViewById(R.id.swimmingPool);
        freeInternet=(TextView)findViewById(R.id.freeInternet);
        breakfast=(TextView)findViewById(R.id.breakfast);





         map= (ImageView)findViewById(R.id.map);

       // Picasso.with(this).load(hotels.get(i).getImage()).into(hotelImage);



        RequestQueue requestQueue= Volley.newRequestQueue(this);


        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(url,null,this,this);

        requestQueue.add(jsonObjectRequest);




    }
    @Override

    public boolean onOptionsItemSelected(MenuItem item){

        int id=item.getItemId();


        if(id==android.R.id.home){
            this.finish();

        }
        return super.onOptionsItemSelected(item);


    }

    @Override

    public void onResponse(JSONObject jsonObject){
        try{
            JSONArray descriptionsJSON=jsonObject.getJSONArray("description");






            for(int i=0;i<descriptionsJSON.length();i++){

                JSONObject descriptionJSON=descriptionsJSON.getJSONObject(i);


                if(descriptionJSON.getInt("hotel_IdHotel")==description.getHotel_idHotel()){
                    description.setGoogleMapURL(descriptionJSON.getString("googleMapURL")+API_KEY);
                    description.setAddress(descriptionJSON.getString("address"));
                    description.setSwimmingPool(descriptionJSON.getInt("swimmingPool"));
                    description.setBreakfastIncluded(descriptionJSON.getInt("breakfastIncluded"));
                    description.setFreeInternet(descriptionJSON.getInt("freeInternet"));




                }
            }


            Picasso.with(this).load(description.getGoogleMapURL()).into(map);
            address.setText(description.getAddress());

            if(description.isSwimmingPool()==1){
                swimmingPool.setText(getString(R.string.yes));


            }
            else{
                swimmingPool.setText(getString(R.string.no));
            }


            if(description.isFreeInternet()==1){
                freeInternet.setText(getString(R.string.yes));


            }
            else{
                freeInternet.setText(getString(R.string.no));
            }


            if(description.isBreakfastIncluded()==1){
                breakfast.setText(getString(R.string.yes));

            }
            else{
                breakfast.setText(getString(R.string.no));
            }
            progressDialog.hide();






        }catch(Exception e){


        }



    }


    @Override
    public void onErrorResponse(VolleyError volleyError){

    }
}
