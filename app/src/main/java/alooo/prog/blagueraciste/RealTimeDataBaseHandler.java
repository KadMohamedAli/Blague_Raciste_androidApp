package alooo.prog.blagueraciste;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RealTimeDataBaseHandler {
    FirebaseDatabase database;
    DatabaseReference ref;

    public RealTimeDataBaseHandler(){
        database=FirebaseDatabase.getInstance("https://blague-raciste-default-rtdb.europe-west1.firebasedatabase.app/");
        ref= database.getReference();

    }
    public void srtuctureDataBase(){
        ref.child("Users");
        ref.child("Blagues");
        ref.child("sizeBlagues");
        ref.child("sizeUsers");
        ref.child("sizeBlaguesEnExamen");
    }
    public void addCategorieDeBlagues(String x){
        ref.child("BlaguesCategories").push().setValue(x);
    }
    public void addUser(User user,String id){
        ref.child("Users").child(id).setValue(user);
        ref.child("sizeUsers").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long value = snapshot.getValue(long.class);
                ref.child("sizeUsers").setValue(value+1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void addBlague(Blague blague){
        ref.child("Blagues").child("Approuve").push().setValue(blague);
        ref.child("sizeUsers").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long value = snapshot.getValue(long.class);
                ref.child("sizeBlagues").setValue(value+1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void addBlagueExamen(Blague blague){
        ref.child("Blagues").child("examen").push().setValue(blague);
        ref.child("sizeUsers").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long value = snapshot.getValue(long.class);
                ref.child("sizeBlaguesEnExamen").setValue(value+1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    //emb3d dirha tetbadel en temps reel c'est mieux :)
    public ArrayList<String> getCategories(){
        ArrayList<String> liste=new ArrayList<String>();
        ref.child("BlaguesCategories").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    liste.add(postSnapshot.getValue(String.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return liste;
    }



}
