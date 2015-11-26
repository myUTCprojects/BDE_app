package bdeapp.baptisteamato.bdeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by BaptisteAmato on 14/09/2015.
 */
public class MainActivityFragment1 extends Fragment {


    public MainActivityFragment1() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container.removeAllViews();



        View view = inflater.inflate(R.layout.fragment1_main, container, false);

        return view;
    }

}
