package com.example.fernandon.android_client.TALLER2.adapters;

import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fernandon.android_client.TALLER2.R;
import com.example.fernandon.android_client.TALLER2.model.ListadoNotificacionesFragment;
import com.example.fernandon.android_client.TALLER2.model.Notificacion;
//import com.example.fernandon.android_client.TALLER2.model.Historia;
//import com.example.fernandon.android_client.TALLER2.model.ListadoHistoriasFragment;
import java.util.List;

public class NotificacionesListAdapter extends RecyclerView.Adapter<NotificacionesListAdapter.NotificacionesViewHolder>{

    private final ListadoNotificacionesFragment.NotificacionesListListener mNotificacionesListListener;
    private List<Notificacion> mNotificaciones;

    public NotificacionesListAdapter(List<Notificacion> notificaciones, ListadoNotificacionesFragment.NotificacionesListListener listener){
        mNotificaciones = notificaciones;
        mNotificacionesListListener = listener;
    }

    public static class NotificacionesViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final ImageView mPicture;
        private final TextView mTitulo;
        private final TextView mDescripcion;

        NotificacionesViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mPicture = (ImageView) itemView.findViewById(R.id.imgNotificacion);
            mTitulo = (TextView) itemView.findViewById(R.id.nomNotificacion);
            mDescripcion = (TextView) itemView.findViewById(R.id.descNotificacion);

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public NotificacionesListAdapter.NotificacionesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_notificacion, parent, false);
        NotificacionesListAdapter.NotificacionesViewHolder notificacionesViewHolder = new NotificacionesListAdapter.NotificacionesViewHolder(v);
        return notificacionesViewHolder;
    }


    @Override
    public void onBindViewHolder(NotificacionesViewHolder holder, int position) {
        final Notificacion notificacion = mNotificaciones.get(position);

        Bitmap originalBitmap = notificacion.getPicture();
        if (originalBitmap.getWidth() > originalBitmap.getHeight()){
            originalBitmap = Bitmap.createBitmap(originalBitmap, 0, 0, originalBitmap.getHeight(), originalBitmap.getHeight());
        }else if (originalBitmap.getWidth() < originalBitmap.getHeight()) {
            originalBitmap = Bitmap.createBitmap(originalBitmap, 0, 0, originalBitmap.getWidth(), originalBitmap.getWidth());
        }
        RoundedBitmapDrawable roundedDrawable = RoundedBitmapDrawableFactory.create(
                holder.mView.getContext().getResources(), originalBitmap);
        roundedDrawable.setCornerRadius(originalBitmap.getHeight());

        holder.mPicture.setImageDrawable(roundedDrawable);
        holder.mTitulo.setText(notificacion.getmTitulo());
        holder.mDescripcion.setText(notificacion.getDescription());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNotificacionesListListener.onNotificacionClicked(notificacion);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNotificaciones.size();
    }
}
