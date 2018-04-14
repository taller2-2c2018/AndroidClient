package com.example.fernandon.android_client.TALLER2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import com.facebook.login.LoginManager;

import java.util.ArrayList;

/**
 * Created by FernandoN on 01/04/2018.
 */

public class HistoriasAdaptor extends ListActivity {

    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    int clickCounter=0;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.id_salir_l){

            return true;
        }

        return false;
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_historias);
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        setListAdapter(adapter);
    }

    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
    public void addItems(View v) {
        listItems.add("Clicked : "+clickCounter++);
        adapter.notifyDataSetChanged();
    }

    public void exit(View v){
        //Intent myIntent = new Intent(MainActivity.PlaceholderFragment.this.getActivity(), LoginActivity.class);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        LoginManager.getInstance().logOut();
    }
    public void goPerfil(View v){
        //Intent myIntent = new Intent(MainActivity.PlaceholderFragment.this.getActivity(), MiPerfilActivity.class);
        Intent intent = new Intent(this, MiPerfilActivity.class);
        startActivity(intent);
    }
    public void aceptarUsuario(View v){
        v.setVisibility(View.GONE);
    }
    public void rechazarUsuario(View v){
        v.setVisibility(View.GONE);
    }
}