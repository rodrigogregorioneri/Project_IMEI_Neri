package com.example.neri_desenvolvedor.project_imei_neri;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class CadastraActivity extends AppCompatActivity {
    EditText edMail, edSenha, edCSenha, edData;
    TextView imei;
    String  sen1, sen2;
    String sexo;
    RadioButton masc, femi;
    Button cadastrarLg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra2);
        cadastrarLg = (Button)findViewById(R.id.btnCadastrar);
        cadastrarLg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login lg = new Login();
                edMail = (EditText)findViewById(R.id.edEmail);
                edSenha = (EditText)findViewById(R.id.edSenha);
                edCSenha = (EditText)findViewById(R.id.edCSenha);
                edData = (EditText)findViewById(R.id.edData);
                masc = (RadioButton)findViewById(R.id.masc);
                femi = (RadioButton)findViewById(R.id.femi);
                imei = (TextView)findViewById(R.id.imei);
               /* lg.setEmail(String.valueOf(edMail.getText()));
                lg.setData_nasc(String.valueOf(edData));
                lg.setImsi(numeroSIM());
                lg.setImei(numeroIMEI());
                lg.setNomedocelular(nomeDoModelo());
                lg.setOperadora(operadora());*/
                if(masc.isChecked()){sexo = "Masculino";}
                if(femi.isChecked()){sexo = "Feminino";}

                /* imei.setText("Email: " + edMail.getText() + "\nData de Nascimento: " + edData.getText() + "\nSexo: " + sexo +
                        "\nIMEI: " + numeroIMEI() + "\nIMSI: " + numeroSIM() + "\nOperadora: " + operadora() + "\nNome do modelo:" + nomeDoModelo());*/
                sen1 = String.valueOf(edSenha.getText());
                sen2 = String.valueOf(edCSenha.getText());
                if(sen1.equals(sen2)){
                    lg.setSenha(String.valueOf(edSenha));
                    Intent intent = new Intent(getBaseContext(), ConfirmeActivity.class);
                    Bundle params = new Bundle();
                    intent.putExtra("email", edMail.getText().toString());
                    intent.putExtra("data", edData.getText().toString());
                    intent.putExtra("sexo", sexo);
                    intent.putExtra("imei", String.valueOf(numeroIMEI()).toString());
                    intent.putExtra("imsi", numeroSIM().toString());
                    intent.putExtra("operadora", operadora().toString());
                    intent.putExtra("modelo", nomeDoModelo().toString());
                   startActivity(intent);
                    finish();
                }else{
                    imei.setText("Senhas não conferem");
                }
            }
        });
    }
                public String numeroIMEI(){
                    String IMEI = "";
                    TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
                    IMEI = telephonyManager.getDeviceId();
                    return IMEI;
                }
                public String numeroSIM(){
                    String SIM = "";
                    TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
                    SIM = telephonyManager.getSimSerialNumber();
                    return SIM;
                }
                public String operadora(){
                    String OPERADORA = "";
                    TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
                    OPERADORA = telephonyManager.getSimOperatorName();
                    return OPERADORA;
                }
                public String nomeDoModelo() {
                        String fabricante = Build.MANUFACTURER;
                    String modelo = Build.MODEL;
                    if (modelo.startsWith(fabricante)) {
                        return capitalize(modelo);
                    } else {
                        return capitalize(fabricante) + " " + modelo;
                    }
                }
                private String capitalize(String s) {
                    if (s == null || s.length() == 0) {
                        return "";
                    }
                    char primeiro = s.charAt(0);
                    if (Character.isUpperCase(primeiro)) {
                        return s;
                    } else {
                        return Character.toUpperCase(primeiro) + s.substring(1);
                    }
                }
}
