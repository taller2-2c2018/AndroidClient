package com.example.fernandon.android_client.TALLER2.adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                dialog.getWindow().setAttributes(lp);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                LinearLayout ll = dialog.findViewById(R.id.lista_mensajes);
                //ll.setLayoutParams(params);

                for ( Mensaje msj: msjs ) {
                    CardView cv = createCardView(v.getContext());
                    TextView text = createTextView(v.getContext());

                    text.setText(msj.getMensaje());
                    cv.addView(text);

                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);

                    if (msj.getEsEmisor() == 1 ){
                        layoutParams.addRule(RelativeLayout.ALIGN_LEFT);
                        //cv.setForegroundGravity(Gravity.LEFT);
                    }
                    else{
                        layoutParams.addRule(RelativeLayout.ALIGN_RIGHT);
                        //cv.setForegroundGravity(Gravity.RIGHT);
                        cv.setCardBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.verde));
                    }
                    layoutParams.setMargins(5, 2, 5, 2);
                    cv.setLayoutParams(layoutParams);

                    ll.addView(cv);

                }
                ll.addView(createMandadoMsjs(v.getContext()));
                dialog.show();
            }
        });
    }

    private LinearLayout createMandadoMsjs (Context context) {
        LinearLayout ll = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(8, 10, 16, 8);
        ll.setLayoutParams(params);
        ll.setOrientation(LinearLayout.HORIZONTAL);

        EditText et = new EditText(context);
        ImageButton acb = new ImageButton(context);

        Drawable dw = ResourcesCompat.getDrawable(context.getResources(), R.drawable.send_button, null);
        acb.setImageDrawable(dw);

        acb.setForegroundGravity(View.FOCUS_RIGHT);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(100,100 );
        params2.weight = 1;
        acb.setLayoutParams(params2);

        ll.addView(et);
        ll.addView(acb);
        return ll;
    }

    private CardView createCardView(Context context) {
        CardView cardview = new CardView(context);
        cardview.setRadius(10.0f);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cardview.setElevation(2);
            //cardview.setCardBackgroundColor(getColor(R.color.light_brown));
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(8, 10, 16, 8);
        cardview.setLayoutParams(params);
        return cardview;
    }

    private TextView createTextView(Context context) {
        TextView tv = new TextView(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        tv.setLayoutParams(params);
        tv.setTextSize(20);

        return tv;
    }

    @Override
    public int getItemCount() {
        return mConversaciones.size();
    }
}
