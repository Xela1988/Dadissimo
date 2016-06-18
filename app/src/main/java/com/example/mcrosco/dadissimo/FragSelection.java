package com.example.mcrosco.dadissimo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sara on 08/06/2016.
 */
public class FragSelection extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    EditText edit4, edit6, edit8, edit10, edit12, edit20, edit100;
    TextView text4, text6, text8, text10, text12, text20, text100, textTotale;
    Button buttonReset, buttonThrow;
    CheckBox d4, d6, d8, d10, d12, d20, d100;
    List<Dado> listaDadi = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_selection, viewGroup, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        initViews(view);
        initListeners();
    }

    private void initViews(View view) {
        edit4 = (EditText) view.findViewById(R.id.editD4);
        edit6 = (EditText) view.findViewById(R.id.editD6);
        edit8 = (EditText) view.findViewById(R.id.editD8);
        edit10 = (EditText) view.findViewById(R.id.editD10);
        edit12 = (EditText) view.findViewById(R.id.editD12);
        edit20 = (EditText) view.findViewById(R.id.editD20);
        edit100 = (EditText) view.findViewById(R.id.editD100);

        buttonReset = (Button) view.findViewById(R.id.buttonReset);
        buttonThrow = (Button) view.findViewById(R.id.buttonThrow);

        d4 = (CheckBox) view.findViewById(R.id.d4);
        d6 = (CheckBox) view.findViewById(R.id.d6);
        d8 = (CheckBox) view.findViewById(R.id.d8);
        d10 = (CheckBox) view.findViewById(R.id.d10);
        d12 = (CheckBox) view.findViewById(R.id.d12);
        d20 = (CheckBox) view.findViewById(R.id.d20);
        d100 = (CheckBox) view.findViewById(R.id.d100);

        text4= (TextView) view.findViewById(R.id.text4);
        text6= (TextView) view.findViewById(R.id.text6);
        text8= (TextView) view.findViewById(R.id.text8);
        text10= (TextView) view.findViewById(R.id.text10);
        text12= (TextView) view.findViewById(R.id.text12);
        text20= (TextView) view.findViewById(R.id.text20);
        text100= (TextView) view.findViewById(R.id.text100);
        textTotale =(TextView)view.findViewById(R.id.totale);


    }

    private void initListeners() {

        buttonReset.setOnClickListener(this);
        buttonThrow.setOnClickListener(this);
        d4.setOnCheckedChangeListener(this);
        d6.setOnCheckedChangeListener(this);
        d8.setOnCheckedChangeListener(this);
        d10.setOnCheckedChangeListener(this);
        d12.setOnCheckedChangeListener(this);
        d20.setOnCheckedChangeListener(this);
        d100.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()) {
            case R.id.d4:
                if (isChecked) {
                    edit4.setText("1");
                } else {
                    edit4.setText("");
                }
                break;

            case R.id.d6:
                if (isChecked) {
                    edit6.setText("1");
                } else {
                    edit6.setText("");
                }
                break;

            case R.id.d8:
                if (isChecked) {
                    edit8.setText("1");
                } else {
                    edit8.setText("");
                }
                break;

            case R.id.d10:
                if (isChecked) {
                    edit10.setText("1");
                } else {
                    edit10.setText("");
                }
                break;

            case R.id.d12:
                if (isChecked) {
                    edit12.setText("1");
                } else {
                    edit12.setText("");
                }
                break;

            case R.id.d20:
                if (isChecked) {
                    edit20.setText("1");
                } else {
                    edit20.setText("");
                }
                break;

            case R.id.d100:
                if (isChecked) {
                    edit100.setText("1");
                } else {
                    edit100.setText("");
                }
                break;

        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonReset:
                d4.setChecked(false);
                d6.setChecked(false);
                d8.setChecked(false);
                d10.setChecked(false);
                d12.setChecked(false);
                d20.setChecked(false);
                d100.setChecked(false);
                edit4.setText("");
                edit6.setText("");
                edit8.setText("");
                edit10.setText("");
                edit12.setText("");
                edit20.setText("");
                edit100.setText("");
                text4.setText("D4:");
                text6.setText("D6:");
                text8.setText("D8:");
                text10.setText("D10:");
                text12.setText("D12:");
                text20.setText("D20:");
                text100.setText("D100:");
                textTotale.setText("TOTAL:");

                break;

            case R.id.buttonThrow:

                //ripulisco la lista dai throw precedenti
                if (!listaDadi.isEmpty()){
                    listaDadi.clear();
                }

                //creo tante volte ogni dado quante mi serve, e li salvo nella lista di dadi
                createAndAdd(controllaDadi(edit4), 4);
                createAndAdd(controllaDadi(edit6), 6);
                createAndAdd(controllaDadi(edit8), 8);
                createAndAdd(controllaDadi(edit10), 10);
                createAndAdd(controllaDadi(edit12), 12);
                createAndAdd(controllaDadi(edit20), 20);
                createAndAdd(controllaDadi(edit100), 100);

                //creo un oggetto di tipo diceSet per poter chiamare il rollAll sulla lista
                DiceSet diceSet = new DiceSet();
                diceSet.rollAll(listaDadi);

                text4.setText(diceSet.resu4);
                text6.setText(diceSet.resu6);
                text8.setText(diceSet.resu8);
                text10.setText(diceSet.resu10);
                text12.setText(diceSet.resu12);
                text20.setText(diceSet.resu20);
                text100.setText(diceSet.resu100);
                textTotale.setText("TOTAL: " + diceSet.totale);

                break;
        }
    }

    // ritorna il numero di volte che devo creare il dado
    public int controllaDadi(EditText edit){
        int numero;
        try{
            numero = Integer.parseInt(edit.getEditableText().toString());
        }
        catch(NumberFormatException e){
            numero = 0;
        }
        return numero;
    }

    //modifico il create and add per: invece che aggiungerli a una lista, li concateno a una stringa
    //

    // devo dargli in input IL NUMERO di volte: me lo da controlla dadi
    public void createAndAdd(int times, int faces){
        for (int i = 0; i < times; i++){
            listaDadi.add(new Dado(faces));
        }
    }

    public void clickThrow(){
        buttonThrow.performClick();
    }

    public void shakedice() {
        createAndAdd(controllaDadi(edit4), 4);
        createAndAdd(controllaDadi(edit6), 6);
        createAndAdd(controllaDadi(edit8), 8);
        createAndAdd(controllaDadi(edit10), 10);
        createAndAdd(controllaDadi(edit12), 12);
        createAndAdd(controllaDadi(edit20), 20);
        createAndAdd(controllaDadi(edit100), 100);

    }

}