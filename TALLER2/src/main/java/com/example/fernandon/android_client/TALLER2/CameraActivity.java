package com.example.fernandon.android_client.TALLER2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class CameraActivity extends Activity {
    //Necesitamos un Boton y un imageView
    private Button btn_hacerfoto;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_crear_historia_larga);
        //Relacionamos con el XML
        img = (ImageView)this.findViewById(R.id.imgMostrar);
        btn_hacerfoto = (Button) this.findViewById(R.id.btn_camara);
        //Añadimos el Listener Boton
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
                //Uri uriSavedImage = Uri.fromFile(image);
                Uri uriSavedImage = FileProvider.getUriForFile(v.getContext(), v.getContext().getApplicationContext().getPackageName() + ".my.package.name.provider", image);
                //Le decimos al Intent que queremos grabar la imagen
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
                cameraIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                //Lanzamos la aplicacion de la camara con retorno (forResult)
                startActivityForResult(cameraIntent, 1);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bitmap bMap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+ "/AndroidFacil/"+"foto.jpg");
            img.setImageBitmap(bMap);
        }
    }
}
