package com.rds.andjaradji.devslopesradio.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rds.andjaradji.devslopesradio.Fragments.DetailsFragment;
import com.rds.andjaradji.devslopesradio.Fragments.MainFragment;
import com.rds.andjaradji.devslopesradio.Model.Station;
import com.rds.andjaradji.devslopesradio.R;

public class MainActivity extends AppCompatActivity {
    private static MainActivity mainActivity;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.setMainActivity(this);

        FragmentManager fManager = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment)fManager.findFragmentById(R.id.mainFragmentContainerID);

        if (mainFragment == null){
            mainFragment = MainFragment.newInstance("Blah", "Kah");
            fManager.beginTransaction().add(R.id.mainFragmentContainerID,mainFragment).commit();
        }
    }

    public void loadDetailScreen (Station selectedStation){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFragmentContainerID,new DetailsFragment())
                .addToBackStack(null)
                .commit();
    }
}
