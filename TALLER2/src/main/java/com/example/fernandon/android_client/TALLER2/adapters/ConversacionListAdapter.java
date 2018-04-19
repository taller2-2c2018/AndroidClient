package com.example.fernandon.android_client.TALLER2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fernandon.android_client.TALLER2.R;
import com.example.fernandon.android_client.TALLER2.model.Amistad;
import com.example.fernandon.android_client.TALLER2.model.Conversacion;
import com.example.fernandon.android_client.TALLER2.model.ListadoAmistadesFragment;
import com.example.fernandon.android_client.TALLER2.model.ListadoConversacionesFragment;

import java.util.List;

/**
 * Created by FernandoN on 15/04/2018.
 */

public class ConversacionListAdapter extends RecyclerView.Adapter<ConversacionListAdapter.ConversacionesViewHolder>  {

    private final ListadoConversacionesFragment.ConversacionesListListener mConversacionesListListener;
    private List<Conversacion> mConversaciones;

    public ConversacionListAdapter(List<Conversacion> conversaciones, ListadoConversacionesFragment.ConversacionesListListener listener){
        mConversaciones = conversaciones;
        mConversacionesListListener = listener;
    }

    public static class ConversacionesViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final TextView mNameUserConver;
        private final TextView mDescripcion;

        ConversacionesViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mNameUserConver = (TextView) itemView.findViewById(R.id.txtConversacionUserName);
            mDescripcion = (TextView) itemView.findViewById(R.id.txtConversacionUltimoContenido);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ConversacionesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_conversacion_box, parent, false);
        ConversacionesViewHolder conversacionesViewHolder = new ConversacionesViewHolder(v);
        return conversacionesViewHolder;
    }

    @Override
    public void onBindViewHolder(ConversacionesViewHolder holder, int position) {
        final Conversacion conversacion = mConversaciones.get(position);

        holder.mNameUserConver.setText(conversacion.getNombreConver());
        holder.mDescripcion.setText(conversacion.getDescription());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mConversacionesListListener.onConversacionClickedRechazar(conversacion);
                mConversacionesListListener.onConversacionClickedAceptar(conversacion);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mConversaciones.size();
    }
}
