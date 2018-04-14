package com.example.fernandon.android_client.TALLER2;

/**
 * Created by FernandoN on 14/04/2018.
 */

public class ListadoAmistadesFragment {
}
/*
package com.example.fernandon.android_client.TALLER2.utils;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fernandon.android_client.TALLER2.model.Amistad;
import com.example.fernandon.android_client.TALLER2.services.AmistadesService;
import com.example.fernandon.android_client.TALLER2.services.ServiceLocator;
import com.example.fernandon.android_client.R;
import com.example.fernandon.android_client.TALLER2.adapters.AmistadesListAdapter;


public class ListadoAmistadesFragment extends Fragment {

    private AmistadesListListener mAmistadesListListener;

    */
/**
 * This interface must be implemented by activities that contain this
 * fragment to allow an interaction in this fragment to be communicated
 * to the activity and potentially other fragments contained in that
 * activity.
 * <p/>
 * See the Android Training lesson <a href=
 * "http://developer.android.com/training/basics/fragments/communicating.html"
 * >Communicating with Other Fragments</a> for more information.
 *//*

    public interface AmistadesListListener {
        void onCommerceClicked(Amistad amistad);
    }

    */
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 *//*

    public ListadoAmistadesFragment() {
    }

    public static ListadoAmistadesFragment newInstance(int columnCount) {
        ListadoAmistadesFragment fragment = new ListadoAmistadesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_amistades_nuevas, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            AmistadesService amistadesService = getAmistadesService();
            recyclerView.setAdapter(new AmistadesListAdapter(amistadesService.getAmistades(), mAmistadesListListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AmistadesListListener) {
            mAmistadesListListener = ( AmistadesListListener ) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement CommerceListListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mAmistadesListListener = null;
    }

    private AmistadesService getAmistadesService() {
        return ServiceLocator.get(AmistadesService.class);
    }
}
*/