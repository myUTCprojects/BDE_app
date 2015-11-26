package bdeapp.baptisteamato.bdeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

        mesAssos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Mes assos", Toast.LENGTH_SHORT).show();

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
