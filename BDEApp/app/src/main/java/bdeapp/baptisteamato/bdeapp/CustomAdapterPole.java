package bdeapp.baptisteamato.bdeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by BaptisteAmato on 06/12/2015.
 */

public class CustomAdapterPole extends BaseAdapter {

    String [] listeAssosPole;
    Context context;
    private static LayoutInflater inflater=null;

    public CustomAdapterPole(Context mContext, String[] mListeAssosPole) {

        context = mContext;
        listeAssosPole=mListeAssosPole;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listeAssosPole.length;
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
        ImageView iv;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.rowgridviewlayout_poles, null);
        holder.tv=(TextView) rowView.findViewById(R.id.nomAssoFromPole);
        holder.iv=(ImageView)rowView.findViewById(R.id.image_clic_asso_fromPole);

        holder.tv.setText(listeAssosPole[position]);


        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Toast.makeText(context, "You Clicked " + listeAssosPole[position], Toast.LENGTH_SHORT).show();
                //Toast.makeText(context, );
                holder.iv.setImageResource(android.R.color.transparent);
                holder.iv.setBackgroundResource(R.drawable.valide_blanc);

            }
        });



        return rowView;
    }

}
