package com.example.neri_desenvolvedor.project_imei_neri;

/**
 * Created by NERI-DESENVOLVEDOR on 31/03/2016.
 */
public class Login {

    private String email;
    private String senha;


    public Login() {
        this.setEmail(email);
        this.setSenha(senha);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
