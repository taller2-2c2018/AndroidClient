package com.example.fernandon.android_client.TALLER2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fernandon.android_client.TALLER2.R;
import com.example.fernandon.android_client.TALLER2.model.Perfil;
import com.example.fernandon.android_client.TALLER2.model.PerfilFragment;
//import com.example.fernandon.android_client.TALLER2.model.Amistad;
//import com.example.fernandon.android_client.TALLER2.model.ListadoAmistadesFragment;

import java.util.List;

/**
 * Created by FernandoN on 18/04/2018.
 */

public class PerfilListAdapter extends RecyclerView.Adapter<PerfilListAdapter.PerfilViewHolder>{

    private final PerfilFragment.PerfilListener mPerfilListener;
    private List<Perfil> mPerfiles;

    public PerfilListAdapter(List<Perfil> perfiles, PerfilFragment.PerfilListener listener){
        mPerfiles = perfiles;
        mPerfilListener = listener;
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final ImageView mPicture;
        private final TextView mName;

        PerfilViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mPicture = (ImageView) itemView.findViewById(R.id.id_imagencontactonuevo);
            mName = (TextView) itemView.findViewById(R.id.id_nomcontactonuevo);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_contacto_pendiente, parent, false);
        // AmistadesViewHolder amistadesViewHolder = new AmistadesViewHolder(parent.getChildAt(0));
        PerfilViewHolder perfilViewHolder = new PerfilViewHolder(v);
        return perfilViewHolder;
    }

    @Override
    public void onBindViewHolder(PerfilViewHolder holder, int position) {
        final Perfil perfil = mPerfiles.get(position);
        holder.mPicture.setImageBitmap(perfil.getPicture());
        holder.mName.setText(perfil.getNombre());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPerfilListener.onPerfilClicked(perfil);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPerfiles.size();
    }
}
