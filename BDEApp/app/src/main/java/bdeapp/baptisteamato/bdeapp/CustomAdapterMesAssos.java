package bdeapp.baptisteamato.bdeapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by BaptisteAmato on 06/12/2015.
 */

public class CustomAdapterMesAssos extends BaseAdapter {

    String [] listeAssosLogin;
    Context context;
    private static LayoutInflater inflater=null;

    public CustomAdapterMesAssos(Context mContext, String[] mListeAssosLogin) {

        context = mContext;
        listeAssosLogin = mListeAssosLogin;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listeAssosLogin.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.rowgridviewlayout_mesassos, null);

        /*--------------gestion couleur------------------*/
        SharedPreferences settings = context.getSharedPreferences("PREFS_NAME", 0);
        String colorSetting = settings.getString("colorSetting", "green");
        RelativeLayout rl_mes_assos_gridview = (RelativeLayout)rowView.findViewById(R.id.rl_mes_assos_gridview);
        if (colorSetting.equals(new String("green"))){
            rl_mes_assos_gridview.setBackgroundColor(context.getResources().getColor(R.color.water_light_green));
        }
        else {
            rl_mes_assos_gridview.setBackgroundColor(context.getResources().getColor(R.color.light_purple));
        }
        /*---------------------------------------------------*/



        holder.tv=(TextView) rowView.findViewById(R.id.nomMesAssos);

        holder.tv.setText(listeAssosLogin[position]);


        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(context, "You Clicked " + listeAssosLogin[position], Toast.LENGTH_SHORT).show();

            }
        });



        return rowView;
    }

}
