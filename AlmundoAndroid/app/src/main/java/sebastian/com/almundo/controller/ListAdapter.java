package sebastian.com.almundo.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import sebastian.com.almundo.R;
import sebastian.com.almundo.model.Hotel;

/**
 * Created by Sebas on 7/01/2018.
 */

public class ListAdapter extends BaseAdapter {

    List <Hotel>hotels;
    MainActivity mainActivity;


    public ListAdapter(MainActivity mainActivity, List<Hotel> hotels){
        this.hotels=hotels;
        this.mainActivity=mainActivity;



    }

    @Override
    public int getCount() {
        return hotels.size();
    }

    @Override
    public Object getItem(int i) {
        return hotels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater=mainActivity.getLayoutInflater();
        view=layoutInflater.inflate(R.layout.list_item,null,true);

        ImageView hotelImage= (ImageView)view.findViewById(R.id.hotelImage);
        Picasso.with(mainActivity).load(hotels.get(i).getImage()).into(hotelImage);
        TextView hotelName=(TextView)view.findViewById(R.id.hotelName);
        hotelName.setText(hotels.get(i).getName());
        RatingBar ratingBar= (RatingBar)view.findViewById(R.id.rating);
        ratingBar.setRating(hotels.get(i).getStars());
        ratingBar.setEnabled(false);
        ratingBar.setActivated(false);
        ratingBar.setClickable(false);
        TextView price= (TextView)view.findViewById(R.id.price);
        price.setText("COP "+hotels.get(i).getPrice());





        return view;
    }
}
