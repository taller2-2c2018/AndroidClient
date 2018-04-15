package com.example.fernandon.android_client.TALLER2.model;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fernandon.android_client.TALLER2.R;
import com.example.fernandon.android_client.TALLER2.adapters.HistoriasListAdapter;
import com.example.fernandon.android_client.TALLER2.services.HistoriasService;
import com.example.fernandon.android_client.TALLER2.services.ServiceLocator;


public class ListadoHistoriasFragment extends Fragment {

    private HistoriasListListener mHistoriasListListener;


    public interface HistoriasListListener {
        void onHistoriaClicked(Historia historia);
    }

    public ListadoHistoriasFragment() {
    }

    public static ListadoHistoriasFragment newInstance(int columnCount) {
        ListadoHistoriasFragment fragment = new ListadoHistoriasFragment();
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
            HistoriasService historiasService = getHistoriasService();
            recyclerView.setAdapter(new HistoriasListAdapter(historiasService.getHistorias(), mHistoriasListListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof HistoriasListListener) {
            mHistoriasListListener = ( HistoriasListListener ) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement CommerceListListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mHistoriasListListener = null;
    }

    private HistoriasService getHistoriasService() {
        return ServiceLocator.get(HistoriasService.class);
    }
}