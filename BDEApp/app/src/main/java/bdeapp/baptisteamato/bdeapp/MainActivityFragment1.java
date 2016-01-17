package bdeapp.baptisteamato.bdeapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by BaptisteAmato on 14/09/2015.
 */
public class MainActivityFragment1 extends Fragment {


    public MainActivityFragment1() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container.removeAllViews();

        View view = inflater.inflate(R.layout.fragment1_main, container, false);
        SharedPreferences settings = getActivity().getSharedPreferences("PREFS_NAME", 0);

        ((TextView)view.findViewById(R.id.title_fragment1_main)).setText("Portail des assos");

        /*--------------gestion couleur------------------*/

        String colorSetting = settings.getString("colorSetting", "green");

        RelativeLayout rl = (RelativeLayout)view.findViewById(R.id.rl);


        if (colorSetting.equals(new String("green"))){
            rl.setBackgroundColor(getResources().getColor(R.color.water_dark_green));
        }
        else{
            rl.setBackgroundColor(getResources().getColor(R.color.dark_purple));
        }
        /*----------------------------------------------------*/

        /*--------------gestion notification------------------*/
        String notificationSetting = settings.getString("notificationSetting", "OFF");
        Button notification_button = (Button)view.findViewById(R.id.notification_button);
        TextView number_notif = (TextView)view.findViewById(R.id.number_notif);
        int notificationNumber = settings.getInt("notificationNumber", 0);
        if (notificationSetting.equals(new String("ON"))){
            if (notificationNumber == 0){
                notification_button.setBackgroundResource(R.drawable.notif);
            }
            else{
                if (colorSetting.equals(new String("green"))){
                    notification_button.setBackgroundResource(R.drawable.notif_green);
                }
                else{
                    notification_button.setBackgroundResource(R.drawable.notif_purple);
                }
                number_notif.setText(notificationNumber);
                number_notif.bringToFront();
            }
        }
        /*-----------------------------------------------------*/

        Button deconnexion = (Button)view.findViewById(R.id.deconnexion);

        deconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSelection = new Intent(getActivity(), ConnectionPage.class);
                startActivity(intentSelection);
                getActivity().finish();
            }
        });


        notification_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationDialogFragment dialogFragment = new NotificationDialogFragment ();
                dialogFragment.show(getActivity().getSupportFragmentManager(), "NotificationDialogFragment");
            }
        });


        return view;
    }

}
