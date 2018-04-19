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
import com.example.fernandon.android_client.TALLER2.model.Amistad;
import com.example.fernandon.android_client.TALLER2.model.ListadoAmistadesFragment;
import com.example.fernandon.android_client.TALLER2.R;
import java.util.List;

public class AmistadesListAdapter extends RecyclerView.Adapter<AmistadesListAdapter.AmistadesViewHolder> {

    private final ListadoAmistadesFragment.AmistadesListListener mAmistadesListListener;
    private List<Amistad> mAmistades;

    public AmistadesListAdapter(List<Amistad> amistades, ListadoAmistadesFragment.AmistadesListListener listener){
        mAmistades = amistades;
        mAmistadesListListener = listener;
    }

    public static class AmistadesViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final ImageView mPicture;
        private final TextView mName;

        AmistadesViewHolder(View itemView) {
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
    public AmistadesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_contacto_pendiente, parent, false);
       // AmistadesViewHolder amistadesViewHolder = new AmistadesViewHolder(parent.getChildAt(0));
        AmistadesViewHolder amistadesViewHolder = new AmistadesViewHolder(v);
        return amistadesViewHolder;
    }

    @Override
    public void onBindViewHolder(AmistadesViewHolder holder, int position) {
        final Amistad amistad = mAmistades.get(position);

        Bitmap originalBitmap = amistad.getPicture();
        if (originalBitmap.getWidth() > originalBitmap.getHeight()){
            originalBitmap = Bitmap.createBitmap(originalBitmap, 0, 0, originalBitmap.getHeight(), originalBitmap.getHeight());
        }else if (originalBitmap.getWidth() < originalBitmap.getHeight()) {
            originalBitmap = Bitmap.createBitmap(originalBitmap, 0, 0, originalBitmap.getWidth(), originalBitmap.getWidth());
        }
        RoundedBitmapDrawable roundedDrawable = RoundedBitmapDrawableFactory.create(
                holder.mView.getContext().getResources(), originalBitmap);
        roundedDrawable.setCornerRadius(originalBitmap.getHeight());

        holder.mPicture.setImageDrawable(roundedDrawable);
        holder.mName.setText(amistad.getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAmistadesListListener.onAmistadClicked(amistad);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAmistades.size();
    }
}
