package com.rds.andjaradji.devslopesradio.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rds.andjaradji.devslopesradio.Activities.MainActivity;
import com.rds.andjaradji.devslopesradio.Holder.StationViewHolder;
import com.rds.andjaradji.devslopesradio.Model.Station;
import com.rds.andjaradji.devslopesradio.R;

import java.util.ArrayList;

/**
 * Created by Anjar on 27/02/2018.
 */

public class StationsAdapter extends RecyclerView.Adapter<StationViewHolder> {
    private ArrayList<Station> stations;

    public StationsAdapter(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_station,parent,false);

        return new StationViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(StationViewHolder holder, final int position) {
        final Station station = stations.get(position);
        holder.updateUI(station);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Load the Detail Screen
                MainActivity.getMainActivity().loadDetailScreen(station);

            }
        });

    }

    @Override
    public int getItemCount() {
        return stations.size();
    }
}
