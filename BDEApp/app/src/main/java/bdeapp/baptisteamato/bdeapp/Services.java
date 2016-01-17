package bdeapp.baptisteamato.bdeapp;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLEncoder;
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

    //renvoi du nombre d'assos
    public int getNbAssos() {
        int nbAssos = 0;
        String serverURL = mContext.getResources().getString(R.string.liste_assos);
        String jsonStr = getData(serverURL);
        if (jsonStr != null) {
            try {
                JSONArray data = new JSONArray(jsonStr);
                for (int i = 0; i < data.length(); i++) {
                    nbAssos++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nbAssos;
    }

    //renvoi de la liste des assos
    public String[] getListeNomsAssos(int nbAssos) {
        String listeAssos[] = new String[nbAssos];
        String serverURL = mContext.getResources().getString(R.string.liste_assos);
        String jsonStr = getData(serverURL);
        if (jsonStr != null) {
            try {
                JSONArray data = new JSONArray(jsonStr);
                for (int i = 0; i < data.length(); i++) {
                    JSONObject jsonObject = data.getJSONObject(i);
                    //listeAssos[i] = jsonObject.optString("name").toString();
                    byte[] utf8 = jsonObject.optString("name").toString().getBytes("UTF-8");
                    listeAssos[i] = new String(utf8, "UTF-8");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listeAssos;
    }


    //renvoi du nombre d'assos auxquelles est abonné un étudiant
    public int getNbAssosLogin(String login) {
        int nbAssos = 0;
        String serverURL = mContext.getResources().getString(R.string.liste_assos_utilisateur1);
        serverURL += login;
        serverURL += mContext.getResources().getString(R.string.liste_assos_utilisateur2);
        String jsonStr = getData(serverURL);
        if (jsonStr != null) {
            try {
                JSONArray data = new JSONArray(jsonStr);
                for (int i = 0; i < data.length(); i++) {
                    nbAssos++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nbAssos;
    }

    //renvoi de la liste des assos auxquelles est abonné un étudiant
    public String[] getListeNomsAssosLogin(int nbAssosLogin, String login) {
        String listeAssosLogin[] = new String[nbAssosLogin];
        String serverURL = mContext.getResources().getString(R.string.liste_assos_utilisateur1);
        serverURL += login;
        serverURL += mContext.getResources().getString(R.string.liste_assos_utilisateur2);
        String jsonStr = getData(serverURL);
        if (jsonStr != null) {
            try {
                JSONArray data = new JSONArray(jsonStr);
                for (int i = 0; i < data.length(); i++) {
                    JSONObject jsonObject = data.getJSONObject(i);
                    listeAssosLogin[i] = jsonObject.optString("name").toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listeAssosLogin;
    }


    //renvoi du nombre d'assos d'un pole
    public int getNbAssosPole(String pole) {
        int nbAssosPole = 0;
        String serverURL = mContext.getResources().getString(R.string.liste_assos);
        String jsonStr = getData(serverURL);
        if (jsonStr != null) {
            try {
                JSONArray data = new JSONArray(jsonStr);
                for (int i = 0; i < data.length(); i++) {
                    JSONObject jsonObject = data.getJSONObject(i);
                    JSONObject jsonObjectPole = new JSONObject(jsonObject.optString("pole").toString());
                    Log.d("test", jsonObjectPole.optString("name").toString() + " = " + pole);
                    if (jsonObjectPole.optString("name").toString().equals(new String(pole))){
                        nbAssosPole++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nbAssosPole;
    }

    //renvoi de la liste des assos d'un pole
    public String[] getListeNomsAssosPole(int nbAssosPole, String pole) {
        String listeAssosPole[] = new String[nbAssosPole];
        int j = 0;
        String serverURL = mContext.getResources().getString(R.string.liste_assos);
        String jsonStr = getData(serverURL);
        if (jsonStr != null) {
            try {
                JSONArray data = new JSONArray(jsonStr);
                for (int i = 0; i < data.length(); i++) {
                    JSONObject jsonObject = data.getJSONObject(i);
                    JSONObject jsonObjectPole = new JSONObject(jsonObject.optString("pole").toString());
                    if (jsonObjectPole.optString("name").toString().equals(new String(pole))){
                        listeAssosPole[j++] = jsonObject.optString("name").toString();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listeAssosPole;
    }




}
