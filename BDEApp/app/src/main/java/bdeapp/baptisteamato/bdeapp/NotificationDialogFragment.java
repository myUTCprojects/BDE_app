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
public class NotificationDialogFragment extends DialogFragment {

    ArrayList<HashMap<String, String>> listItem ;
    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notification_dialog, container, false);
        getDialog().setTitle("Notifications");
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(true);

        HashMap<String, String> map;

        list = (ListView) rootView.findViewById(R.id.listviewNotification);
        listItem = new ArrayList<HashMap<String, String>>();

        Services services = new Services(getActivity());

        /*-----------Ajout des éléments de la liste---------------*/

        /*int nbNotificatiosn = services.getNbNotificationsLogin();
        String listNotifications[nbNotification] = services.getNotificationsLogin();

        for (int i = 0; i < nbNotification; i++){
            map = new HashMap<String, String>();
            map.put("notificationText", "Mon flux");
            map.put("notificationTemps", "Il y a 2 jours");
            listItem.add(map);
        }*/


        map = new HashMap<String, String>();
        map.put("notificationText", "Premiere notif");
        map.put("notificationTemps", "Il y a 1 jours");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("notificationText", "Deuxieme notif");
        map.put("notificationTemps", "Il y a 2 jours");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("notificationText", "Troisieme notif");
        map.put("notificationTemps", "Il y a 3 jours");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("notificationText", "Quatrieme notif");
        map.put("notificationTemps", "Il y a 4 jours");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("notificationText", "Cinquieme notif");
        map.put("notificationTemps", "Il y a 5 jours");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("notificationText", "Sixieme notif");
        map.put("notificationTemps", "Il y a 6 jours");
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("notificationText", "Septieme notif");
        map.put("notificationTemps", "Il y a 7 jours");
        listItem.add(map);


        /*----------------------------------------------------------*/

        SimpleAdapter mSchedule;

        mSchedule = new SimpleAdapter (getActivity(), listItem, R.layout.rowlayout_notification,
                new String[] {"notificationText", "notificationTemps"}, new int[] {R.id.notificationText, R.id.notificationTemps});

        list.setAdapter(mSchedule);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //on récupère la HashMap contenant les infos de notre item
                HashMap<String, String> map = (HashMap<String, String>) list.getItemAtPosition(position);
                String touched = new String(map.get("notificationText"));

            }
        });


        return rootView;
    }
}
