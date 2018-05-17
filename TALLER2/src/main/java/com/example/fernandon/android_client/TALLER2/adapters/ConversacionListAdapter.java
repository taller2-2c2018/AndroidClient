package com.example.fernandon.android_client.TALLER2.adapters;

import android.app.Dialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fernandon.android_client.TALLER2.R;
import com.example.fernandon.android_client.TALLER2.model.Amistad;
import com.example.fernandon.android_client.TALLER2.model.Conversacion;
import com.example.fernandon.android_client.TALLER2.model.ListadoAmistadesFragment;
import com.example.fernandon.android_client.TALLER2.model.ListadoConversacionesFragment;
import com.example.fernandon.android_client.TALLER2.model.Mensaje;

import org.w3c.dom.Text;

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
        private final TextView mCantMsjSinLeer;

        ConversacionesViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mNameUserConver = (TextView) itemView.findViewById(R.id.txtConversacionUserName);
            mDescripcion = (TextView) itemView.findViewById(R.id.txtConversacionUltimoContenido);
            mCantMsjSinLeer = (TextView) itemView.findViewById(R.id.txtConversacionCantMsjs);
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
    public void onBindViewHolder(final ConversacionesViewHolder holder, int position) {
        final Conversacion conversacion = mConversaciones.get(position);

        holder.mNameUserConver.setText(conversacion.getNombreConver());
        holder.mDescripcion.setText(conversacion.getDescription());

        int tieneMsjsSinLeer = conversacion.getCantMsjSinLeer();
        if ( tieneMsjsSinLeer > 0 ) {
            String textoAGenerar = "(" + String.valueOf(tieneMsjsSinLeer) + ")";
            holder.mCantMsjSinLeer.setText(textoAGenerar);
            holder.mCantMsjSinLeer.setVisibility(View.VISIBLE);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List <Mensaje> msjs =  conversacion.getMensajeria();

                Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dialog_conversacion);
                LinearLayout ll = dialog.findViewById(R.id.lista_mensajes);

                for ( Mensaje msj: msjs ) {
                    CardView cv = (CardView) v.findViewById(R.id.cv_mensaje_usuario);
                    TextView text = (TextView) v.findViewById(R.id.mensajeUsuario);
                    text.setText(msj.getMensaje());
                    if (msj.getEsEmisor() == 1 ){
                        text.setGravity(Gravity.LEFT);
                    }
                    else{
                        text.setGravity(Gravity.RIGHT);
                    }
                    ll.addView(text);
                }
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mConversaciones.size();
    }
}
