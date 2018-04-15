package com.example.fernandon.android_client.TALLER2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fernandon.android_client.TALLER2.R;
import com.example.fernandon.android_client.TALLER2.model.Historia;
import com.example.fernandon.android_client.TALLER2.model.ListadoHistoriasFragment;

import java.util.List;


public class HistoriasListAdapter extends RecyclerView.Adapter<HistoriasListAdapter.HistoriasViewHolder>{

    private final ListadoHistoriasFragment.HistoriasListListener mHistoriasListListener;
    private List<Historia> mHistoria;

    public HistoriasListAdapter(List<Historia> historias, ListadoHistoriasFragment.HistoriasListListener listener){
        mHistoria = historias;
        mHistoriasListListener = listener;
    }

    public static class HistoriasViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final ImageView mPicture;
        private final TextView mTitulo;
        private final TextView mDescripcion;
        private final TextView mUbicacion;
        private final TextView mFecha;


        HistoriasViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mPicture = (ImageView) itemView.findViewById(R.id.imageHistoria);
            mTitulo = (TextView) itemView.findViewById(R.id.textTitulo);
            mDescripcion = (TextView) itemView.findViewById(R.id.textDescripcion);
            mUbicacion = (TextView) itemView.findViewById(R.id.textUbicacion);
            mFecha = (TextView) itemView.findViewById(R.id.textFechaHora);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public HistoriasListAdapter.HistoriasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_historia_larga, parent, false);
        HistoriasListAdapter.HistoriasViewHolder historiasViewHolder = new HistoriasListAdapter.HistoriasViewHolder(v);
        return historiasViewHolder;
    }


    @Override
    public void onBindViewHolder(HistoriasViewHolder holder, int position) {
        final Historia historia = mHistoria.get(position);

        holder.mPicture.setImageBitmap(historia.getPicture());

        holder.mTitulo.setText(historia.getmTitulo());
        holder.mDescripcion.setText(historia.getDescription());
        holder.mFecha.setText(historia.getFecha());
        holder.mUbicacion.setText(historia.getUbicacion());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHistoriasListListener.onHistoriaClicked(historia);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHistoria.size();
    }
}
