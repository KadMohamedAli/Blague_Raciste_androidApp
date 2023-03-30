package alooo.prog.blagueraciste.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

import alooo.prog.blagueraciste.Blague;
import alooo.prog.blagueraciste.R;
import alooo.prog.blagueraciste.RealTimeDataBaseHandler;
import alooo.prog.blagueraciste.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private TextView texte;
    private int i;
    private FragmentHomeBinding binding;
    private Blague currentBlague;
    private ConstraintLayout constraintLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayList<String> s=new ArrayList<String>();s.add("Quel est le point commun entre un noir et un vélo??");s.add("ça marche mieux avec des chaines");
        currentBlague=new Blague(s,0,0);

        RealTimeDataBaseHandler h=new RealTimeDataBaseHandler();
        //delete h ...

        texte=root.findViewById(R.id.text_home);
        constraintLayout=root.findViewById(R.id.fragement_home_parent);
        getBlague();
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i<currentBlague.getType()) {
                    i++;
                    String x=texte.getText()+System.lineSeparator()+currentBlague.getPart_blague().get(i);
                    texte.setText(x);
                }
                else{
                    texte.setText("");
                    getBlague();
                }
            }
        });


        return root;
    }

    public void getBlague(){


        afficherBlague();
    }

    public void afficherBlague(){
        i=0;

        texte.setText(currentBlague.getPart_blague().get(i));


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}