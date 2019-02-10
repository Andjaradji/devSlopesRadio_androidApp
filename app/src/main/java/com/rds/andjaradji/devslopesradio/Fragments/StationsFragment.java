package com.rds.andjaradji.devslopesradio.Fragments;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rds.andjaradji.devslopesradio.Adapters.StationsAdapter;
import com.rds.andjaradji.devslopesradio.Holder.StationViewHolder;
import com.rds.andjaradji.devslopesradio.R;
import com.rds.andjaradji.devslopesradio.Services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StationsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_STATION_TYPE = "station_type";

    // TODO: Rename and change types of parameters
    private int mStationType;

    private RecyclerView rv;

    public static final int STATION_TYPE_FEATURED = 0;
    public static final int STATION_TYPE_RECENT = 1;
    public static final int STATION_TYPE_PARTY = 2;

    public StationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param stationType The Radio Stations Type.
     * @return A new instance of fragment StationsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StationsFragment newInstance(int stationType) {
        StationsFragment fragment = new StationsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STATION_TYPE,stationType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mStationType = getArguments().getInt(ARG_STATION_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stations, container, false);

        rv = view.findViewById(R.id.rvStationID);
        rv.setHasFixedSize(true);

        StationsAdapter sfAdapter;

        if (mStationType == STATION_TYPE_FEATURED){
            sfAdapter = new StationsAdapter(DataService.getInstance().getFeaturedStation());

        }else if (mStationType == STATION_TYPE_RECENT){
            sfAdapter = new StationsAdapter(DataService.getInstance().getRecentStation());

        }else {
            sfAdapter = new StationsAdapter(DataService.getInstance().getFeaturedStation());
        }

        rv.addItemDecoration(new HorizontalItemDecorator(20));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(sfAdapter);

        return view;
    }

}

class HorizontalItemDecorator extends RecyclerView.ItemDecoration {
    private final int spacer;

    public HorizontalItemDecorator(int spacer) {
        this.spacer = spacer;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.right = spacer;
    }
}
