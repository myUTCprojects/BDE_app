package bdeapp.baptisteamato.bdeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
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

        String sections = "abcdefghilmnopqrstuvz";

        editSearch = (EditText) view.findViewById(R.id.editSearch);
        HashMap<String, String> map;

        nomAssoList = (ListView) view.findViewById(R.id.listviewNomAsso);
        nomAssoListItem = new ArrayList<HashMap<String, String>>();

        final int nbElements = 26;
        for (char i = 'z'; i >= 'a'; i--) {
            map = new HashMap<String, String>();
            map.put("nomAsso", String.valueOf(i));
            nomAssoListItem.add(map);
        }




        //on trie par ordre alphab�tique
        Collections.sort(nomAssoListItem, new Comparator<HashMap<String, String>>() {
            public int compare(HashMap<String, String> mapping1, HashMap<String, String> mapping2) {
                return mapping1.get("nomAsso").compareTo(mapping2.get("nomAsso"));
            }
        });


        SimpleAdapter mSchedule;

        mSchedule = new SimpleAdapter (getActivity(), nomAssoListItem, R.layout.rowlayout_nomasso,
                    new String[] {"nomAsso"}, new int[] {R.id.nomAsso});



        nomAssoList.setAdapter(mSchedule);


        nomAssoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //on r�cup�re la HashMap contenant les infos de notre item
                HashMap<String, String> map = (HashMap<String, String>) nomAssoList.getItemAtPosition(position);
                Toast.makeText(getActivity(), map.get("nomAsso"), Toast.LENGTH_SHORT).show();
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
            //principe : d�s que l'on �crit quelque chose, on r�cup�re la liste enti�re et on enl�ve ce qui ne correspond pas
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String txt = editSearch.getText().toString();
                ArrayList<HashMap<String, String>> temp = new ArrayList<HashMap<String, String>>(nomAssoListItem); //copie, mais pas pointeur
                int length = txt.length();
                if (length == 0) {  //on affiche tout
                    SimpleAdapter mSchedule = new SimpleAdapter(getActivity(), nomAssoListItem, R.layout.rowlayout_nomasso,
                            new String[]{"nomAsso"}, new int[]{R.id.nomAsso});
                    nomAssoList.setAdapter(mSchedule);
                } else {    //on enl�ve les "mauvais" items
                    int nbElementsTemp = nbElements;
                    for (int i = 0; i < nbElementsTemp; i++) {  //on regarde si ce qui est �crit est contenu dans chaque item
                        if (!temp.get(i).get("nomAsso").toString().toLowerCase().contains(txt.toLowerCase())) {
                            temp.remove(i);
                            //on enl�ve un �l�ment, donc on doit rester sur le m�me indice dans la liste et d�cr�menter nbElements
                            i--;
                            nbElementsTemp--;
                        }
                    }
                    if (nbElementsTemp == 0)
                        Toast.makeText(getActivity(), "Aucun r�sultat", Toast.LENGTH_SHORT).show();

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
