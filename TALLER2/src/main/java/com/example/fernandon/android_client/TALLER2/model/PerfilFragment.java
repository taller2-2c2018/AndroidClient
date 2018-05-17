package com.example.fernandon.android_client.TALLER2.model;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fernandon.android_client.TALLER2.LoginActivity;
import com.example.fernandon.android_client.TALLER2.R;
import com.example.fernandon.android_client.TALLER2.adapters.HistoriasListAdapter;
import com.example.fernandon.android_client.TALLER2.adapters.PerfilListAdapter;
import com.example.fernandon.android_client.TALLER2.services.HistoriasService;
import com.example.fernandon.android_client.TALLER2.services.PerfilService;
import com.example.fernandon.android_client.TALLER2.services.ServiceLocator;

/**
 * Created by FernandoN on 18/04/2018.
 */

public class PerfilFragment extends Fragment{

    private PerfilFragment.PerfilListener mPerfilListener;
    private RecyclerView mRecyclerView;
    private ListadoHistoriasFragment.HistoriasListListener mHistoriasListListener;


    public interface PerfilListener {
        void onPerfilClicked(Perfil perfil);
    }

    public PerfilFragment() {
    }

    public static PerfilFragment newInstance(int columnCount) {
        PerfilFragment fragment = new PerfilFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //View view = container.getChildAt(0);
        View view = inflater.inflate(R.layout.activity_mi_perfil, container, false);

        mRecyclerView = view.findViewById(R.id.historias_perfil_local);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HistoriasService historiasService = getHistoriasService();
        mRecyclerView.setAdapter(new HistoriasListAdapter(historiasService.getHistorias(), mHistoriasListListener));

        AppCompatButton exit = view.findViewById(R.id.salir_app);

        exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                exit();
            }
        });

        return view;
    }

    public void exit(){
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PerfilFragment.PerfilListener) {
            mPerfilListener = (PerfilFragment.PerfilListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement PerfilListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPerfilListener = null;
    }

    private HistoriasService getHistoriasService() {
        return ServiceLocator.get(HistoriasService.class);
    }

    private PerfilService getPerfilService() {
        return ServiceLocator.get(PerfilService.class);
    }
}