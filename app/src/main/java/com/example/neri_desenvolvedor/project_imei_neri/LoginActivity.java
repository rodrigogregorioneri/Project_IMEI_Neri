package com.example.neri_desenvolvedor.project_imei_neri;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
TextView  cadastre_se;
Button btnLogar;
    EditText edLogin,edSenha;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edLogin = (EditText)findViewById(R.id.edLogin);
        edSenha = (EditText)findViewById(R.id.edSenha);
        btnLogar = (Button)findViewById(R.id.btnLogar);
        cadastre_se = (TextView) findViewById(R.id.labelCadastrar);

        cadastre_se.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(getBaseContext(), CadastraActivity.class);
                startActivity(intent);
            }
        });

        btnLogar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


               Login login = new Login();





                ControlerDoBanco contro = new ControlerDoBanco(getBaseContext());




                if(contro.autentica(String.valueOf(edLogin.getText()).toString(), String.valueOf(edSenha.getText()).toString())){
                    Intent intent = new Intent(getBaseContext(), Principal.class);
                    startActivity(intent);
                }

                //if(contro.buscar(login.getSenha()) ){
                //}else{
               // }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
