package model.beans;

import java.io.Serializable;

public class UserBean implements Serializable {
    
    private String username;
    private String nome; 
    private String cognome; 


    public void setUsername(String username){
        this.username = username;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public String getUsername(){
        return this.username;
    }
    
    public String getNome(){
        return this.nome;
    }

    public String getCognome(){
        return this.cognome; 
    }
}
