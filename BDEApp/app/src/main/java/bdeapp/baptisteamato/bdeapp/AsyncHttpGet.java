package bdeapp.baptisteamato.bdeapp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

/**
 * Created by BaptisteAmato on 17/09/2015.
 */

public class AsyncHttpGet extends AsyncTask<String, String, String> {

    private Context mContext;

    public AsyncHttpGet (Context context){
        mContext = context;
    }

    @Override
    protected String doInBackground(String... serverUrl) {

        BufferedReader reader = null;
        StringBuilder stringBuilder = null;

        try {
            URL url = new URL(serverUrl[0]);    // ici, serverURL[0] est l'URL de connexion
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.connect();
            int responseCode = urlConn.getResponseCode();
            //Log.d("responseCode",Integer.toString(responseCode));
            if (responseCode == 200) {
                reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                stringBuilder = new StringBuilder();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }
            }
        }catch (SocketTimeoutException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ioe) {
                    return null;
                }
            }
        }
        return stringBuilder.toString();
    }
}
