package com.rds.andjaradji.devslopesradio.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rds.andjaradji.devslopesradio.Model.Station;
import com.rds.andjaradji.devslopesradio.R;

/**
 * Created by Anjar on 27/02/2018.
 */

public class StationViewHolder extends RecyclerView.ViewHolder {
    private ImageView mainStationImage;
    private TextView mainText;
    public StationViewHolder(View itemView) {
        super(itemView);

        mainStationImage = itemView.findViewById(R.id.mainStationImageID);
        mainText = itemView.findViewById(R.id.mainTextID);
    }

    public void updateUI (Station station){
        String uri = station.getImgUri();
        int resource = mainStationImage.getResources().getIdentifier(uri,null, mainStationImage.getContext().getPackageName());
        mainStationImage.setImageResource(resource);

        mainText.setText(station.getStationTitle());

    }

}
