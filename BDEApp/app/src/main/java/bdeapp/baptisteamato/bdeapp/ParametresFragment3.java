package bdeapp.baptisteamato.bdeapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by BaptisteAmato on 01/12/2015.
 */
public class ParametresFragment3 extends Fragment{

    public ParametresFragment3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container.removeAllViews();


        View view = inflater.inflate(R.layout.fragment3_parametres, container, false);

        Switch colorChoice = (Switch)view.findViewById(R.id.colorChoice);
        Switch notificationChoice = (Switch)view.findViewById(R.id.notificationChoice);

        SharedPreferences settings = getActivity().getSharedPreferences("PREFS_NAME", 0);
        String colorSetting = settings.getString("colorSetting", "green");

        if (colorSetting.equals(new String("green"))) {
            colorChoice.setChecked(false);
        }
        else {
            colorChoice.setChecked(true);
        }

        String notificationSetting = settings.getString("notificationSetting", "OFF");

        if (notificationSetting.equals(new String("ON"))) {
            notificationChoice.setChecked(true);
        }
        else {
            notificationChoice.setChecked(false);
        }

        colorChoice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (buttonView.isChecked()){
                        SharedPreferences settings = getActivity().getSharedPreferences("PREFS_NAME", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("colorSetting", "purple");
                        editor.commit();
                    }
                    else{
                        SharedPreferences settings = getActivity().getSharedPreferences("PREFS_NAME", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("colorSetting", "green");
                        editor.commit();
                    }
                }
        });

        notificationChoice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (buttonView.isChecked()){
                    SharedPreferences settings = getActivity().getSharedPreferences("PREFS_NAME", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("notificationSetting", "ON");
                    editor.commit();
                }
                else{
                    SharedPreferences settings = getActivity().getSharedPreferences("PREFS_NAME", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("notificationSetting", "OFF");
                    editor.commit();
                }
            }
        });

        return view;
    }
}
