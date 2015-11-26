package bdeapp.baptisteamato.bdeapp;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

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
            MainActivityFragment1 firstFragment = new MainActivityFragment1();
            firstFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container1, firstFragment, "MainActivityFragment1").commit();
        }

        if (findViewById(R.id.fragment_container2) != null) {
            if (savedInstanceState != null) {
                return;
            }
            MainActivityFragment2 secondFragment = new MainActivityFragment2();
            secondFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2, secondFragment, "MainActivityFragment2").commit();
        }

        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button_accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

                ChoixAssoFragment1 firstFragment = new ChoixAssoFragment1();
                firstFragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container1, firstFragment, "ChoixAssoFragment1").commit();


                ChoixPoleFragment2 secondFragment = new ChoixPoleFragment2();
                secondFragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2, secondFragment, "ChoixPoleFragment2").commit();




            }
        });

    }
}