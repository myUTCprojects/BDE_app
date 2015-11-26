package bdeapp.baptisteamato.bdeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by BaptisteAmato on 14/09/2015.
 */
public class ChoixAssoFragment1 extends Fragment {


    public ChoixAssoFragment1() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container.removeAllViews();



        final View view = inflater.inflate(R.layout.fragment1_choix_asso, container, false);

        Button parPole = (Button) view.findViewById(R.id.parPole);
        Button parNom = (Button) view.findViewById(R.id.parNom);

        parPole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView txtParPole = (TextView)view.findViewById(R.id.txtParPole);
                TextView txtParNom = (TextView)view.findViewById(R.id.txtParNom);
                txtParPole.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
                txtParNom.setBackgroundColor(getActivity().getResources().getColor(R.color.beige));

                ChoixPoleFragment2 choixPoleFragment2 = new ChoixPoleFragment2();
                final FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                ft1.replace(R.id.fragment_container2, choixPoleFragment2, "ChoixPoleFragment2");
                ft1.commit();
            }
        });

        parNom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView txtParNom = (TextView)view.findViewById(R.id.txtParNom);
                TextView txtParPole = (TextView)view.findViewById(R.id.txtParPole);
                txtParNom.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
                txtParPole.setBackgroundColor(getActivity().getResources().getColor(R.color.beige));

                ChoixNomFragment2 choixNomFragment2 = new ChoixNomFragment2();
                final FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                ft1.replace(R.id.fragment_container2, choixNomFragment2, "ChoixNomFragment2");
                ft1.commit();
            }
        });

        return view;
    }
}
