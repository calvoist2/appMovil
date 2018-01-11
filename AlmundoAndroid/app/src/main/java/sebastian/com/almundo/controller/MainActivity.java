package sebastian.com.almundo.controller;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import sebastian.com.almundo.R;
import sebastian.com.almundo.model.Hotel;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,Response.Listener<JSONObject>, Response.ErrorListener {
    List<Hotel> hotelList = new ArrayList<>();
    EditText search;
    Context context;
    MainActivity mainActivity;
    ListView hotelListView;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.hotelList));
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        search= (EditText)findViewById(R.id.search);

        hotelListView=(ListView)findViewById(R.id.hotelListView);
        hotelListView.setOnItemClickListener(this);

        mainActivity=this;


        progressDialog= new ProgressDialog(this);
        progressDialog.setTitle(getString(R.string.loading));


        String url="http://testhotels.herokuapp.com/application/json/hotels/hotels.php";

        progressDialog.show();


        RequestQueue requestQueue= Volley.newRequestQueue(this);


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url,null,this,this);

        requestQueue.add(jsonObjectRequest);



    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


        Intent i=new Intent(this,HotelActivity.class);

        int hotelId=hotelList.get(position).getId();
        String hotelName=hotelList.get(position).getName();
        int rating=hotelList.get(position).getStars();

        i.putExtra("hotelId",hotelId);
        i.putExtra("hotelName",hotelName);
        i.putExtra("rating",rating);




        startActivity(i);

    }
    @Override
    public void onResponse(JSONObject response) {

        try {

            JSONArray hotelsJSON=response.getJSONArray("hotels");



            for(int i=0;i< hotelsJSON.length();i++){

                JSONObject hotelJSON=hotelsJSON.getJSONObject(i);

                Hotel hotel= new Hotel();
                hotel.setName(hotelJSON.getString("name"));
                hotel.setImage(hotelJSON.getString("image"));
                hotel.setPrice(hotelJSON.getString("price"));
                hotel.setStars(hotelJSON.getInt("stars"));
                hotel.setId(hotelJSON.getInt("idHotel"));
                hotelList.add(hotel);

            }
            progressDialog.hide();

            hotelListView.setAdapter(new ListAdapter(this,hotelList));

            search.addTextChangedListener(new TextWatcher() {
                public void onTextChanged(CharSequence s, int start, int before, int count) {


                }
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                public void afterTextChanged(Editable s) {

                   List <Hotel> auxHotelList= new ArrayList<>();
                   for(int i=0;i<hotelList.size();i++){


                       if(hotelList.get(i).getName().contains(search.getText().toString())){
                           auxHotelList.add(hotelList.get(i));


                       }


                   }

                    hotelListView.setAdapter(new ListAdapter(mainActivity,auxHotelList));


                }
            });



        }catch (Exception e){

        }


    }

    @Override
    public void onErrorResponse(VolleyError error){

        Log.d("Error en respuesta",String.valueOf(error));
    }



}

