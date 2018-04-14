package com.example.fernandon.android_client.TALLER2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.LoginManager;

import java.util.ArrayList;
import java.util.List;

import static com.example.fernandon.android_client.TALLER2.R.id.buttonMenu;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    public void goMenu(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void goChat(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void goNotif(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void exit(View v){
        //Intent myIntent = new Intent(this.getActivity(), LoginActivity.class);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        LoginManager.getInstance().logOut();
    }
    public void goPerfil(View v){
        //Intent myIntent = new Intent(PlaceholderFragment.this.getActivity(), MiPerfilActivity.class);
        Intent intent = new Intent(this, MiPerfilActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();
        /*
        //noinspection SimplifiableIfStatement
        if (id == R.id.id_salir_l){
            exit();
            return true;
        }
        if (id == R.id.id_mi_perfil_l){
            goPerfil();
            return true;
        }
        */
        return false;
        //return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setHasOptionsMenu(true);
        }

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public void exit(View v){
            Intent myIntent = new Intent(PlaceholderFragment.this.getActivity(), LoginActivity.class);
            //Intent intent = new Intent(this, LoginActivity.class);
            startActivity(myIntent);
            LoginManager.getInstance().logOut();
        }
        public void goPerfil(View v){
            Intent myIntent = new Intent(PlaceholderFragment.this.getActivity(), MiPerfilActivity.class);
            //Intent intent = new Intent(this, MiPerfilActivity.class);
            startActivity(myIntent);
        }

        public void aceptarUsuario(View v){
            v.setVisibility(View.GONE);
        }
        public void rechazarUsuario(View v){
            v.setVisibility(View.GONE);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            return false;
            //return super.onOptionsItemSelected(item);
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ImageButton b_menu = (ImageButton) rootView.findViewById(R.id.buttonMenu);
            b_menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LinearLayout ll = (LinearLayout) rootView.findViewById(R.id.menu_cambiante);
                    ll.removeAllViews();
                    ll.addView( getLayoutInflater().inflate(R.layout.activity_historias, null));
                }
            });

            ImageButton b_amigos = (ImageButton) rootView.findViewById(R.id.buttonAmigos);
            b_amigos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LinearLayout ll = (LinearLayout) rootView.findViewById(R.id.menu_cambiante);
                    ll.removeAllViews();
                    ll.addView( getLayoutInflater().inflate(R.layout.activity_amistades_nuevas, null));
                }
            });

            ImageButton b_notificaciones = (ImageButton) rootView.findViewById(R.id.buttonNotificaciones);
            b_notificaciones.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LinearLayout ll = (LinearLayout) rootView.findViewById(R.id.menu_cambiante);
                    ll.removeAllViews();
                    ll.addView( getLayoutInflater().inflate(R.layout.activity_notificaciones, null));
                }
            });

            ImageButton b_chat = (ImageButton) rootView.findViewById(R.id.buttonChat);
            b_chat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LinearLayout ll = (LinearLayout) rootView.findViewById(R.id.menu_cambiante);
                    ll.removeAllViews();
                    ll.addView( getLayoutInflater().inflate(R.layout.activity_mi_perfil, null));
                }
            });

            ImageButton b_options = (ImageButton) rootView.findViewById(R.id.buttonOptions);
            b_options.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LinearLayout ll = (LinearLayout) rootView.findViewById(R.id.menu_cambiante);
                    ll.removeAllViews();
                    ll.addView( getLayoutInflater().inflate(R.layout.activity_options2, null));
                }
            });

            return rootView;

        }
    }
    public void pantallaPPAL(){
        Intent intent = new Intent(this, MiPerfilActivity.class);
        startActivity(intent);
    }
    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 1;
        }
    }
}
