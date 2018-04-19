package com.example.fernandon.android_client.TALLER2.model;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fernandon.android_client.TALLER2.R;
//import com.example.fernandon.android_client.TALLER2.adapters.HistoriasListAdapter;
//import com.example.fernandon.android_client.TALLER2.services.HistoriasService;
import com.example.fernandon.android_client.TALLER2.adapters.PerfilListAdapter;
import com.example.fernandon.android_client.TALLER2.services.PerfilService;
import com.example.fernandon.android_client.TALLER2.services.ServiceLocator;

/**
 * Created by FernandoN on 18/04/2018.
 */

public class PerfilFragment extends Fragment{

    private PerfilFragment.PerfilListener mPerfilListener;

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
        View view = inflater.inflate(R.layout.fragment_historias_recientes, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            PerfilService perfilService = getPerfilService();
            recyclerView.setAdapter(new PerfilListAdapter(perfilService.getPerfiles(), mPerfilListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PerfilFragment.PerfilListener) {
            mPerfilListener = (PerfilFragment.PerfilListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement CommerceListListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPerfilListener = null;
    }

    private PerfilService getPerfilService() {
        return ServiceLocator.get(PerfilService.class);
    }
}