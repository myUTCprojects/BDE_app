package bdeapp.baptisteamato.bdeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by BaptisteAmato on 06/12/2015.
 */
public class PoleFragment2 extends Fragment {


    public PoleFragment2() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container.removeAllViews();


        View view = inflater.inflate(R.layout.fragment2_pole, container, false);
        Services services = new Services(getActivity());
        String pole = "";
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            pole = bundle.getString("pole", "");
        }
        String poleJson = "";
        ((TextView) view.findViewById(R.id.nomPole)).setText(pole.toUpperCase());
        if (pole.equals(new String("pae"))) {
            poleJson = "Pôle Artistique et évènementiel";
        }
        else if (pole.equals(new String("pte"))){
            poleJson = "Pôle Technologie et Entreprenariat";
        }
        else if(pole.equals(new String("pvdc"))) {
            poleJson = "Pôle Vie du Campus";
        }
        else if(pole.equals(new String("psec"))) {
            poleJson = "Pôle Solidarité et Citoyenneté";
        }
        else{
            poleJson = "";
        }

        int nbAssosPole = services.getNbAssosPole(poleJson);
        String listeAssosPole[] = services.getListeNomsAssosPole(nbAssosPole, poleJson);

        for (int i=0; i < nbAssosPole; i++){
            if(listeAssosPole[i] != null)
                Log.d("asso[" + i + "]", listeAssosPole[i]);
        }


        GridView gv = (GridView) view.findViewById(R.id.gridViewPole);

        gv.setAdapter(new CustomAdapterPole(getActivity().getApplicationContext(), listeAssosPole));


        return view;

    }
}
