package bdeapp.baptisteamato.bdeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ConnectionPage extends Activity {

    EditText login;
    EditText password;
    Button connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_page);

        login = (EditText) findViewById(R.id.conn_login);
        password = (EditText) findViewById(R.id.conn_pwd);
        connection = (Button) findViewById(R.id.conn_button);

        Intent intentSelection = new Intent(ConnectionPage.this, MainActivity.class);
        startActivity(intentSelection);
        finish();

        connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*if (login.getText().toString().equals("amatobap"))
                {
                    Intent intentSelection = new Intent(ConnectionPage.this, MainActivity.class);
                    startActivity(intentSelection);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Connexion échouée", Toast.LENGTH_SHORT).show();
                }*/

            }
        });

    }


}
