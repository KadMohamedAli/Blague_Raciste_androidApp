package alooo.prog.blagueraciste;

import java.util.ArrayList;

public class Blague {
    private int type;
    //0-direct 1-une pause entre les deux parties
    private int categorie;
    //....
    private ArrayList<String> part_blague;
    private int state;
    //0-publie 1-examen
    private String user;
    private float note;
    private float viewers;

    public Blague(){

    }
    public Blague(ArrayList<String> blagues,int categorie,int state){
        this.part_blague=blagues;
        this.type=blagues.size()-1;
        this.categorie=categorie;
        this.state=state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public ArrayList<String> getPart_blague() {
        return part_blague;
    }

    public void setPart_blague(ArrayList<String> part_blague) {
        this.part_blague = part_blague;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
