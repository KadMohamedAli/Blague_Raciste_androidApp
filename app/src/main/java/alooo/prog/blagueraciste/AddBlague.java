package alooo.prog.blagueraciste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddBlague extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private Spinner spinner;
    private Button submitButton;
    private Button plusMoinsButton;
    private int cptPlusMoinsButton;
    private ArrayList<String> liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_blague);

        editText1=findViewById(R.id.editTextAddBlague1);
        editText2=findViewById(R.id.editTextAddBlague2);
        spinner=findViewById(R.id.spinnerCategorie);
        submitButton=findViewById(R.id.submitButton);
        plusMoinsButton=findViewById(R.id.buttonPlusEtMoins);

        cptPlusMoinsButton=1;

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),liste.get(i),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, getCategorieList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkEditTexts();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkEditTexts();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkEditTexts();
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkEditTexts();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkEditTexts();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkEditTexts();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        plusMoinsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cptPlusMoinsButton=cptPlusMoinsButton+1;
                if((int)cptPlusMoinsButton%2==0){
                    plusMoinsButton.setText("-");
                    editText2.setEnabled(true);
                    editText2.setVisibility(View.VISIBLE);
                }
                else{
                    plusMoinsButton.setText("+");
                    editText2.setEnabled(false);
                    editText2.setVisibility(View.INVISIBLE);
                }
                checkEditTexts();
            }
        });

    }
    public ArrayList<String> getCategorieList(){
        RealTimeDataBaseHandler h=new RealTimeDataBaseHandler();
        liste=h.getCategories();
        return liste;
    }
    private void checkEditTexts(){
        if((int)cptPlusMoinsButton%2==0){
            if(editText1.getText().toString().isEmpty() || editText2.getText().toString().isEmpty()){
                submitButton.setEnabled(false);
            }
            else{
                submitButton.setEnabled(true);
            }
        }
        else{
            if(editText1.getText().toString().isEmpty() ){
                submitButton.setEnabled(false);
            }
            else{
                submitButton.setEnabled(true);
            }
        }
    }
}
