package com.example.mcrosco.dadissimo;

import android.widget.TextView;

import java.util.List;

/**
 * Created by Sara on 08/06/2016.
 */
public interface ISetThrowable {

    void rollAll(List<Dado> listad);
    //ritorna la somma e i singoli tiri. Vuole una lista di oggetti di tipo dado, ognuno con la sua faccia

}
