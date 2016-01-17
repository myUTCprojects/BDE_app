package bdeapp.baptisteamato.bdeapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by BaptisteAmato on 10/12/2015.
 */
public class MesAssosFragment2 extends Fragment {

    public MesAssosFragment2() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container.removeAllViews();

        View view = inflater.inflate(R.layout.fragment2_mesassos, container, false);
        SharedPreferences settings = getActivity().getSharedPreferences("PREFS_NAME", 0);
        Services services = new Services(getActivity());

        Fragment frag = getFragmentManager().findFragmentById(R.id.fragment_container1);
        ((TextView) frag.getView().findViewById(R.id.title_fragment1_main)).setText("Mes assos");


        String login = "nterisse";
        int nbAssosLogin = services.getNbAssosLogin(login);
        Log.d("nb", String.valueOf(nbAssosLogin));
        String listeAssosLogin[] = services.getListeNomsAssosLogin(nbAssosLogin, login);

        for (int i=0; i < nbAssosLogin; i++){
            if(listeAssosLogin[i] != null)
                Log.d("asso[" + i + "]", listeAssosLogin[i]);
        }


        GridView gv = (GridView) view.findViewById(R.id.gridViewMesAssos);

        gv.setAdapter(new CustomAdapterMesAssos(getActivity().getApplicationContext(), listeAssosLogin));

        return view;
    }
}
