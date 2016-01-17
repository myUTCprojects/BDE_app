package bdeapp.baptisteamato.bdeapp;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by BaptisteAmato on 14/09/2015.
 */
public class MainActivity extends FragmentActivity {    //Gestionnaire des fragments de l'application

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_menu = (Button)findViewById(R.id.button_menu);
        Button button_accueil = (Button)findViewById(R.id.button_accueil);
        Button button_recherche = (Button)findViewById(R.id.button_recherche);

        if (findViewById(R.id.fragment_container1) != null) {
            if (savedInstanceState != null) {
                return;
            }
            MainActivityFragment1 mainActivityFragment1 = new MainActivityFragment1();
            mainActivityFragment1.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container1, mainActivityFragment1, "MainActivityFragment1").commit();
        }

        if (findViewById(R.id.fragment_container2) != null) {
            if (savedInstanceState != null) {
                return;
            }
            MainActivityFragment2 mainActivityFragment2 = new MainActivityFragment2();
            mainActivityFragment2.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2, mainActivityFragment2, "MainActivityFragment2").commit();
        }

        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MenuDialogFragment dialogFragment = new MenuDialogFragment ();
                dialogFragment.show(getSupportFragmentManager(), "MenuDialogFragment");

            }
        });

        button_accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((FrameLayout)findViewById(R.id.fragment_container1)).setVisibility(View.VISIBLE);
                ((FrameLayout)findViewById(R.id.fragment_container2)).setVisibility(View.VISIBLE);

                MainActivityFragment1 firstFragment = new MainActivityFragment1();
                firstFragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container1, firstFragment, "MainActivityFragment1").commit();


                MainActivityFragment2 secondFragment = new MainActivityFragment2();
                secondFragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2, secondFragment, "MainActivityFragment2").commit();



            }
        });

        button_recherche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText recherche = (EditText)findViewById(R.id.button_recherche_editText);
                ImageView image_recherche = (ImageView)findViewById(R.id.image_recherche);

                if (recherche.getVisibility() == View.GONE){
                    recherche.setVisibility(View.VISIBLE);
                    recherche.bringToFront();
                    //image_recherche.setImageDrawable(getResources().getDrawable(R.drawable.button_recherche_noir));
                }
                else{
                    recherche.setVisibility(View.GONE);
                    //image_recherche.setImageDrawable(getResources().getDrawable(R.drawable.button_recherche));
                }



            }
        });

    }
}