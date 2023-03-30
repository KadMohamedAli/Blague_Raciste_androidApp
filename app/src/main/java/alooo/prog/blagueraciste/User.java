package alooo.prog.blagueraciste;

import java.util.ArrayList;

public class User {
    private String email;
    private String username;
    private String password;
    private int type;
    //0-chikor 1-admin_avec_pub 2-normal_sans_pub 3-normal_avec_pub 4-peut_seulement_voir
    private ArrayList<String> listeRefBlagues;
    private String[] listeDerniereBlagues;

    public User(String email,String password){
        this.email=email;
        this.password=password;
        listeRefBlagues=new ArrayList<String>();
        listeDerniereBlagues=new String[20];
    }
    public User(String email,String password,ArrayList<Long> listeRefBlagues){
        this.email=email;
        this.password=password;
        this.listeRefBlagues=getListeRefBlagues();
        listeDerniereBlagues=new String[20];
    }

    public void addBlagues(String ref){
        listeRefBlagues.add(ref);
    }
    public ArrayList<String> getListeRefBlagues(){
        return listeRefBlagues;
    }

    public void setUsername(String username){
        this.username=username;
    }
    public void setType(int type){
        this.type=type;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }

    public String[] getListeDerniereBlagues() {
        return listeDerniereBlagues;
    }

    public void setListeDerniereBlagues(String[] listeDerniereBlagues) {
        this.listeDerniereBlagues = listeDerniereBlagues;
    }
}
