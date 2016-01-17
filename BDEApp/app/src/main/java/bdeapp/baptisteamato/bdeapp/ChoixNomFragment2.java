package bdeapp.baptisteamato.bdeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by BaptisteAmato on 14/09/2015.
 */

public class ChoixNomFragment2 extends Fragment {

    ArrayList<HashMap<String, String>> nomAssoListItem ;
    ListView nomAssoList;
    EditText editSearch;

    public ChoixNomFragment2() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container.removeAllViews();



        View view = inflater.inflate(R.layout.fragment2_choix_nom, container, false);
        Services services = new Services(getActivity());

        String login = "nterisse";
        final int nbAssos = services.getNbAssos();
        final String listeNomAsso[] = services.getListeNomsAssos(nbAssos);
        final int nbAssosLogin = services.getNbAssosLogin(login);
        final String listeNomsAssosLogin[] = services.getListeNomsAssosLogin(nbAssosLogin, login);

        editSearch = (EditText) view.findViewById(R.id.editSearch);
        HashMap<String, String> map;

        nomAssoList = (ListView) view.findViewById(R.id.listviewNomAsso);
        nomAssoListItem = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < nbAssos; i++) {
            map = new HashMap<String, String>();
            map.put("nomAsso", listeNomAsso[i]);
            int resourceId;
            if (Arrays.asList(listeNomsAssosLogin).contains(listeNomAsso[i])){
                resourceId = getResources().getIdentifier("valide_noir", "drawable", getResources().getString(R.string.package_name));
                map.put("image_clic_asso", String.valueOf(resourceId));
                map.put("image_clic_asso_nom", "valide");
            }
            else{
                resourceId = getResources().getIdentifier("ajouter_noir", "drawable", getResources().getString(R.string.package_name));
                map.put("image_clic_asso", String.valueOf(resourceId));
                map.put("image_clic_asso_nom", "ajouter");
            }

            nomAssoListItem.add(map);
        }




        //on trie par ordre alphabétique
        Collections.sort(nomAssoListItem, new Comparator<HashMap<String, String>>() {
            public int compare(HashMap<String, String> mapping1, HashMap<String, String> mapping2) {
                return mapping1.get("nomAsso").compareTo(mapping2.get("nomAsso"));
            }
        });


        SimpleAdapter mSchedule;

        mSchedule = new SimpleAdapter (getActivity(), nomAssoListItem, R.layout.rowlayout_nomasso,
                    new String[] {"nomAsso", "image_clic_asso"}, new int[] {R.id.nomAsso, R.id.image_clic_asso});



        nomAssoList.setAdapter(mSchedule);




        /*nomAssoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //on récupère la HashMap contenant les infos de notre item
                HashMap<String, String> map = (HashMap<String, String>) nomAssoList.getItemAtPosition(position);
                Toast.makeText(getActivity(), map.get("image_clic_asso_nom"), Toast.LENGTH_SHORT).show();
                if (map.get("image_clic_asso_nom").equals(new String("ajouter")))
                    image_clic_asso.setBackgroundResource(R.drawable.valide_noir);
                else
                    image_clic_asso.setBackgroundResource(R.drawable.ajouter_noir);
            }
        });*/

        nomAssoList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> arg0, View v, int position,
                                    long arg3) {
                ImageView image_clic_asso=(ImageView) v.findViewById(R.id.image_clic_asso);
                HashMap<String, String> map = (HashMap<String, String>) nomAssoList.getItemAtPosition(position);
                Toast.makeText(getActivity(), map.get("image_clic_asso_nom"), Toast.LENGTH_SHORT).show();
                if (map.get("image_clic_asso_nom").equals(new String("ajouter"))){
                    image_clic_asso.setImageResource(android.R.color.transparent);
                    image_clic_asso.setBackgroundResource(R.drawable.valide_noir);
                    map.put("image_clic_asso_nom", "valide");
                }
                else{
                    image_clic_asso.setImageResource(android.R.color.transparent);
                    image_clic_asso.setBackgroundResource(R.drawable.ajouter_noir);
                    map.put("image_clic_asso_nom", "ajouter");
                }

            }

        });

        editSearch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                editSearch.requestFocusFromTouch();
                return false;
            }
        });



        editSearch.addTextChangedListener(new TextWatcher() {   //Barre de recherche
            //principe : dès que l'on écrit quelque chose, on récupère la liste entière et on enlève ce qui ne correspond pas
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String txt = editSearch.getText().toString();
                ArrayList<HashMap<String, String>> temp = new ArrayList<HashMap<String, String>>(nomAssoListItem); //copie, mais pas pointeur
                int length = txt.length();
                if (length == 0) {  //on affiche tout
                    SimpleAdapter mSchedule = new SimpleAdapter(getActivity(), nomAssoListItem, R.layout.rowlayout_nomasso,
                            new String[]{"nomAsso"}, new int[]{R.id.nomAsso});
                    nomAssoList.setAdapter(mSchedule);
                } else {    //on enlève les "mauvais" items
                    int nbAssosTemp = nbAssos;
                    for (int i = 0; i < nbAssosTemp; i++) {  //on regarde si ce qui est écrit est contenu dans chaque item
                        if (!temp.get(i).get("nomAsso").toString().toLowerCase().contains(txt.toLowerCase())) {
                            temp.remove(i);
                            //on enlève un élément, donc on doit rester sur le même indice dans la liste et décrémenter nbElements
                            i--;
                            nbAssosTemp--;
                        }
                    }
                    if (nbAssosTemp == 0)
                        Toast.makeText(getActivity(), "Aucun résultat", Toast.LENGTH_SHORT).show();

                    SimpleAdapter mSchedule = new SimpleAdapter(getActivity(), temp, R.layout.rowlayout_nomasso,
                            new String[]{"nomAsso"}, new int[]{R.id.nomAsso});
                    nomAssoList.setAdapter(mSchedule);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

        });



        return view;
    }

}
