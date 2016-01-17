package bdeapp.baptisteamato.bdeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by BaptisteAmato on 14/09/2015.
 */
public class ChoixPoleFragment2 extends Fragment {


    public ChoixPoleFragment2() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container.removeAllViews();


        final View view = inflater.inflate(R.layout.fragment2_choix_pole, container, false);

        view.post(new Runnable() {
            @Override
            public void run() {

                /*((ImageView) view.findViewById(R.id.img_pae)).setBackgroundResource(R.drawable.logo_pae);
                ((ImageView) view.findViewById(R.id.img_psec)).setBackgroundResource(R.drawable.logo_psec);
                ((ImageView) view.findViewById(R.id.img_pte)).setBackgroundResource(R.drawable.logo_pte);
                ((ImageView) view.findViewById(R.id.img_pvdc)).setBackgroundResource(R.drawable.logo_pvdc);*/

            }
        });

        Button pae = (Button)view.findViewById(R.id.pae);
        Button pte = (Button)view.findViewById(R.id.pte);
        Button psec = (Button)view.findViewById(R.id.psec);
        Button pvdc = (Button)view.findViewById(R.id.pvdc);

        pae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PoleFragment2 poleFragment2 = new PoleFragment2();
                Bundle bundle = new Bundle();
                bundle.putString("pole", "pae");
                poleFragment2.setArguments(bundle);
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container2, poleFragment2, "PoleFragment2");
                ft.commit();
            }
        });

        pte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PoleFragment2 poleFragment2 = new PoleFragment2();
                Bundle bundle = new Bundle();
                bundle.putString("pole", "pte");
                poleFragment2.setArguments(bundle);
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container2, poleFragment2, "PoleFragment2");
                ft.commit();
            }
        });

        psec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PoleFragment2 poleFragment2 = new PoleFragment2();
                Bundle bundle = new Bundle();
                bundle.putString("pole", "psec");
                poleFragment2.setArguments(bundle);
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container2, poleFragment2, "PoleFragment2");
                ft.commit();
            }
        });

        pvdc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PoleFragment2 poleFragment2 = new PoleFragment2();
                Bundle bundle = new Bundle();
                bundle.putString("pole", "pvdc");
                poleFragment2.setArguments(bundle);
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container2, poleFragment2, "PoleFragment2");
                ft.commit();
            }
        });

        return view;
    }

}
