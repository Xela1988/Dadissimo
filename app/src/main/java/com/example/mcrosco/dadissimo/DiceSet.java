package com.example.mcrosco.dadissimo;

import android.media.audiofx.AudioEffect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by Sara on 08/06/2016.
 */
public class DiceSet implements ISetThrowable{



    // fa i calcoli sulla lista di dadi

    String resu4 = "D4: ";
    String resu6 = "D6: ";
    String resu8 = "D8: ";
    String resu10 = "D10: ";
    String resu12 = "D12: ";
    String resu20 = "D20: ";
    String resu100 = "D100: ";
    String totale = "";


    // scorre sulla lista, tira i random e salva la somma
    public void rollAll(List<Dado> diceSet){

        int somma = 0;
        for (int i = 0; i < diceSet.size(); i++){

            int casuale = new Random().nextInt(diceSet.get(i).getFaces()) +1;
            somma += casuale;


            switch (diceSet.get(i).getFaces()){
                case 4:
                    resu4+="["+ Integer.toString(casuale)+"] ";
                    totale  = Integer.toString(somma);
                    break;

                case 6:
                    resu6+="["+ Integer.toString(casuale)+"] ";
                    totale = Integer.toString(somma);
                    break;

                case 8:
                    resu8+="["+ Integer.toString(casuale)+"] ";
                    totale = Integer.toString(somma);
                    break;

                case 10:
                    resu10 += "["+ Integer.toString(casuale)+"] ";
                    totale = Integer.toString(somma);
                    break;

                case 12:
                    resu12 += "["+ Integer.toString(casuale)+"] ";
                    totale = Integer.toString(somma);
                    break;

                case 20:
                    resu20+= "["+ Integer.toString(casuale)+"] ";
                    totale = Integer.toString(somma);
                    break;

                case 100:

                    resu100 += "["+ Integer.toString(casuale)+"] ";
                    totale = Integer.toString(somma);
                    break;
            }
        }
    }

    //per ogni dado che tiri prendi il numero delle facce e in base a quello (switch) stampalo nella textview corrispondente


}

