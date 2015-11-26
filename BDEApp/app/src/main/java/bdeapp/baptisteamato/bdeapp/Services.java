package bdeapp.baptisteamato.bdeapp;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by BaptisteAmato on 17/09/2015.
 */
public class Services {

    private Context mContext;

    public Services (Context context){
        mContext = context;
    }

    //renvoi du contenu de la page indiquée
    String getData(String url) {
        AsyncHttpGet connect = new AsyncHttpGet(mContext);
        String jsonStr = null;
        try {
            connect.execute(url);
        } catch (Exception e) {
            return null;
        }
        try {
            jsonStr = connect.get();
        } catch (Exception e) {
            return null;
        }

        return jsonStr;
    }




}
