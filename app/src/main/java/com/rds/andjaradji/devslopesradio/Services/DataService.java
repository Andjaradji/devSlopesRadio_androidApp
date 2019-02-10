package com.rds.andjaradji.devslopesradio.Services;

import com.rds.andjaradji.devslopesradio.Model.Station;

import java.util.ArrayList;

/**
 * Created by Anjar on 28/02/2018.
 */

public class DataService {
    private static final DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {
    }

    public ArrayList<Station> getFeaturedStation () {
        //pretend we just downloaded data from the internet
        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan (Tunes for Travel)","flightplanmusic"));
        list.add(new Station("Two Wheelin' (Biking Playlist)","bicyclemusic"));
        list.add(new Station("Kids Jam (Music for Children)","kidsmusic"));

        return list;
    }

    public ArrayList<Station> getRecentStation () {
        //pretend we just downloaded data from the internet
        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan (Tunes for Travel)","vinylmusic"));
        list.add(new Station("Two Wheelin' (Biking Playlist)","socialmusic"));
        list.add(new Station("Kids Jam (Music for Children)","keymusic"));
        return list;
    }

    public ArrayList<Station> getPartyStation () {
        //pretend we just downloaded data from the internet
        ArrayList<Station> list = new ArrayList<>();
        return list;
    }
}
