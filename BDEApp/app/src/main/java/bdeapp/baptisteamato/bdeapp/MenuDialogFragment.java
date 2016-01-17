package bdeapp.baptisteamato.bdeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by BaptisteAmato on 01/12/2015.
 */
public class MenuDialogFragment extends DialogFragment {

    ArrayList<HashMap<String, String>> listItem ;
    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu_dialog, container, false);
        //getDialog().setTitle("Simple Dialog");
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(true);

        HashMap<String, String> map;

        list = (ListView) rootView.findViewById(R.id.listviewMenu);
        listItem = new ArrayList<HashMap<String, String>>();

        /*-----------Ajout des éléments de la liste---------------*/

        map = new HashMap<String, String>();
        map.put("menu_item", "Mon flux");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("menu_item", "Pay'Utc");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("menu_item", "Weekmail");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("menu_item", "Carnet avantages");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("menu_item", "Calendrier des assos");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("menu_item", "Paramètres");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("menu_item", "Aide");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("menu_item", "Déconnexion");
        listItem.add(map);

        /*----------------------------------------------------------*/

        SimpleAdapter mSchedule;

        mSchedule = new SimpleAdapter (getActivity(), listItem, R.layout.rowlayout_menu,
                new String[] {"menu_item"}, new int[] {R.id.menu_item});

        list.setAdapter(mSchedule);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //on récupère la HashMap contenant les infos de notre item
                HashMap<String, String> map = (HashMap<String, String>) list.getItemAtPosition(position);
                String touched = new String(map.get("menu_item"));

                switch (touched) {
                    case "Paramètres":
                        getDialog().dismiss();
                        ((FrameLayout)getActivity().findViewById(R.id.fragment_container1)).setVisibility(View.GONE);
                        ((FrameLayout)getActivity().findViewById(R.id.fragment_container2)).setVisibility(View.GONE);
                        ParametresFragment3 parametresFragment3 = new ParametresFragment3();
                        final FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.fragment_container3, parametresFragment3, "ParametresFragment3");
                        ft.commit();
                        break;
                    case "Déconnexion":
                        Intent intentSelection = new Intent(getActivity(), ConnectionPage.class);
                        startActivity(intentSelection);
                        getActivity().finish();
                    default:
                        Toast.makeText(getActivity(), touched, Toast.LENGTH_SHORT).show();
                }
            }
        });


        return rootView;
    }
}
