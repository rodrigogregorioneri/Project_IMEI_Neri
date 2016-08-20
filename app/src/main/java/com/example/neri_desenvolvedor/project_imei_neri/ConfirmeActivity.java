package com.example.neri_desenvolvedor.project_imei_neri;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

public class ConfirmeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirme);

        Login lg = new Login();

        TextView temail = (TextView)findViewById(R.id.edEmail);
        TextView tdata = (TextView)findViewById(R.id.edData);
        TextView tsexo = (TextView)findViewById(R.id.edSexo);
        TextView timei = (TextView)findViewById(R.id.edImei);
        TextView timsi = (TextView)findViewById(R.id.edMsi);
        TextView toperadora = (TextView)findViewById(R.id.edOperadora);
        TextView tmodelo = (TextView)findViewById(R.id.edModelo);

        Button btngravar = (Button)findViewById(R.id.btnGravar);



        Intent intent = getIntent();

        final String email = intent.getStringExtra("email");
        final String data = intent.getStringExtra("data");
        final String senha = intent.getStringExtra("senha");
        final String sexo = intent.getStringExtra("sexo");
        final String imei = intent.getStringExtra("imei");
        final String imsi = intent.getStringExtra("imsi");
        final String operadora = intent.getStringExtra("operadora");
        final String modelo = intent.getStringExtra("modelo");

        temail.setText("Email: "+email);
        tdata.setText("Data: "+data);
        tsexo.setText("Sexo: "+sexo);
        timei.setText("IMEI: "+imei);
        timsi.setText("IMSI: "+imsi);
        toperadora.setText("Operadora: " + operadora);
        tmodelo.setText("Modelo: " + modelo);


        btngravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControlerDoBanco crud = new ControlerDoBanco(getBaseContext());
                String resultado;
                resultado = crud.insereDado(email,data,senha,sexo,imei,imsi,operadora,modelo);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
