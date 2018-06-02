package com.example.fernandon.android_client.TALLER2.model;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fernandon.android_client.TALLER2.CameraActivity;
import com.example.fernandon.android_client.TALLER2.Filters.SearchFilter;
import com.example.fernandon.android_client.TALLER2.R;

import com.example.fernandon.android_client.TALLER2.adapters.HistoriasListAdapter;
import com.example.fernandon.android_client.TALLER2.services.HistoriasService;
import com.example.fernandon.android_client.TALLER2.services.ServiceLocator;
import com.example.fernandon.android_client.TALLER2.services.UsersService;

import java.io.File;
import java.util.List;


public class ListadoHistoriasFragment extends Fragment {

    private HistoriasListListener mHistoriasListListener;
    private UsersListListener mUsersListListener;
    private AppCompatButton mButtonNuevaHistoriaView;
    private RecyclerView mRecyclerView;
    private SearchView mSearchView;


    public interface HistoriasListListener {
        void onHistoriaClicked(Historia historia);
    }

    public interface UsersListListener {
        void onUserClicked(User user);
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

        mSearchView = view.findViewById(R.id.searchViewList);
        mButtonNuevaHistoriaView = view.findViewById(R.id.buttonIngresaHistoria);

        mRecyclerView = view.findViewById(R.id.listHistoriasRecientes);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HistoriasService historiasService = getHistoriasService();
        mRecyclerView.setAdapter(new HistoriasListAdapter(historiasService.getHistorias(), mHistoriasListListener));

        setUpNuevaHistoriaView();
        setUpSearchView();
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

    private UsersService getUsersService() {
        return ServiceLocator.get(UsersService.class);
    }

    private void setUpSearchView() {
        mSearchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                filterUsersByText(newText, false);
                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                filterUsersByText(query, true);
                return true;
            }
        });
    }

    private void setUpNuevaHistoriaView() {
        mButtonNuevaHistoriaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), CameraActivity.class);
                getActivity().startActivity(intent);

                /*Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dialog_crear_historia_larga);

                ImageView img = dialog.findViewById(R.id.imgMostrar);
                Button btn_hacerfoto = dialog.findViewById(R.id.btn_camara);

                btn_hacerfoto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Creamos el Intent para llamar a la Camara
                        Intent cameraIntent = new Intent(
                                android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        //Creamos una carpeta en la memeria del terminal
                        File imagesFolder = new File(
                                Environment.getExternalStorageDirectory(), "AndroidFacil");
                        imagesFolder.mkdirs();
                        //añadimos el nombre de la imagen
                        File image = new File(imagesFolder, "foto.jpg");
                        Uri uriSavedImage = Uri.fromFile(image);
                        //Le decimos al Intent que queremos grabar la imagen
                        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
                        //Lanzamos la aplicacion de la camara con retorno (forResult)
                        startActivityForResult(cameraIntent, 1);
                    }
                });
                dialog.show();
                */
/*
                protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                    //Comprovamos que la foto se a realizado
                    if (requestCode == 1 && resultCode == RESULT_OK) {
                        //Creamos un bitmap con la imagen recientemente
                        //almacenada en la memoria
                        Bitmap bMap = BitmapFactory.decodeFile(
                                Environment.getExternalStorageDirectory()+
                                “/AndroidFacil/”+“foto.jpg”);
                        //Añadimos el bitmap al imageView para
                        //mostrarlo por pantalla
                        img.setImageBitmap(bMap);
                    }
                }*/

            }
        });
    }

    private void enterUserPerfil(String query){

    }

    private void filterUsersByText(String searchText, boolean notifyNoneUsers) {
        List<String> usuarios = getHistoriasService().getUsers();
        if (usuarios != null) {
            SearchFilter saerchFilter = new SearchFilter(searchText);
            List<String> filteredUsers = saerchFilter.apply(usuarios);
            loadUsers(filteredUsers, notifyNoneUsers);
        }
    }
    private void loadUsers(List<String> usuarios, boolean notifyNoneUsers) {
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //mRecyclerView.setAdapter(new UserListAdapter(usuarios, mUsersListListener));
        if (notifyNoneUsers && usuarios.size() < 1) {
            Toast.makeText(getContext(), "No existen usuarios con ese nombre", Toast.LENGTH_LONG).show();
        }
    }
}