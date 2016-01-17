package bdeapp.baptisteamato.bdeapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by BaptisteAmato on 14/09/2015.
 */
public class MainActivityFragment2 extends Fragment {


    public MainActivityFragment2() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container.removeAllViews();


        View view = inflater.inflate(R.layout.fragment2_main, container, false);

        Button mesAssos = (Button) view.findViewById(R.id.mesAssos);
        Button mesEvenements = (Button) view.findViewById(R.id.mesEvenements);
        Button ajouterAsso = (Button) view.findViewById(R.id.ajouterAsso);
        Button choisirAsso = (Button) view.findViewById(R.id.choisirAsso);

        /*--------------gestion couleur------------------*/

        SharedPreferences settings = getActivity().getSharedPreferences("PREFS_NAME", 0);
        String colorSetting = settings.getString("colorSetting", "green");
        RelativeLayout rl_mes_assos = (RelativeLayout)view.findViewById(R.id.rl_mes_assos);
        RelativeLayout rl_mes_evenements = (RelativeLayout)view.findViewById(R.id.rl_mes_evenements);
        RelativeLayout rl_ajouter_assos = (RelativeLayout)view.findViewById(R.id.rl_ajouter_asso);
        RelativeLayout rl_ajouter_evenement = (RelativeLayout)view.findViewById(R.id.rl_ajouter_evenement);
        if (colorSetting.equals(new String("green"))){
            rl_mes_assos.setBackgroundColor(getResources().getColor(R.color.water_light_green));
            rl_mes_evenements.setBackgroundColor(getResources().getColor(R.color.water_dark_green));
            rl_ajouter_assos.setBackgroundColor(getResources().getColor(R.color.water_dark_green));
            rl_ajouter_evenement.setBackgroundColor(getResources().getColor(R.color.water_light_green));
        }
        else{
            rl_mes_assos.setBackgroundColor(getResources().getColor(R.color.light_purple));
            rl_mes_evenements.setBackgroundColor(getResources().getColor(R.color.dark_purple));
            rl_ajouter_assos.setBackgroundColor(getResources().getColor(R.color.dark_purple));
            rl_ajouter_evenement.setBackgroundColor(getResources().getColor(R.color.light_purple));
        }
        /*---------------------------------------------*/


        mesAssos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            MesAssosFragment2 mesAssosFragment2 = new MesAssosFragment2();
            final FragmentTransaction ft2 = getFragmentManager().beginTransaction();
            ft2.replace(R.id.fragment_container2, mesAssosFragment2, "MesAssosFragment2");
            ft2.commit();

            }
        });

        mesEvenements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Toast.makeText(getActivity(), "Mes evenements", Toast.LENGTH_SHORT).show();

            }
        });

        ajouterAsso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Toast.makeText(getActivity(), "Ajouter une asso", Toast.LENGTH_SHORT).show();

            }
        });

        choisirAsso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            ChoixAssoFragment1 choixAssoFragment1 = new ChoixAssoFragment1();
            final FragmentTransaction ft1 = getFragmentManager().beginTransaction();
            ft1.replace(R.id.fragment_container1, choixAssoFragment1, "ChoixAssoFragment1");
            ft1.commit();

            ChoixPoleFragment2 choixPoleFragment2 = new ChoixPoleFragment2();
            final FragmentTransaction ft2 = getFragmentManager().beginTransaction();
            ft2.replace(R.id.fragment_container2, choixPoleFragment2, "ChoixPoleFragment2");
            ft2.commit();

            }
        });



        return view;
    }

}
