package com.example.usuario.laggersappmod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Contacto extends AppCompatActivity {

    Button btnenviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        btnenviar = findViewById(R.id.buttonenv);
        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mail = new Intent(Intent.ACTION_SEND);
                //String to = ((EditText)findViewById(R.id.editTextcorreo)).getText().toString();
                String sub = ((TextView)findViewById(R.id.editTextcorreo)).getText().toString();
                String mess = ((EditText)findViewById(R.id.editTextComentario)).getText().toString();
                if(mess.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Por favor escríbe un Mensaje :D",Toast.LENGTH_SHORT).show();

                }else{
                    mail = new Intent(Intent.ACTION_SEND);
                    mail.putExtra(Intent.EXTRA_EMAIL,new String[]{"laggersvca@gmail.com"});
                    mail.putExtra(Intent.EXTRA_SUBJECT, "Comentario Laggersapp");
                    mail.putExtra(Intent.EXTRA_TEXT, mess);
                    mail.setType("message/rfc822");
                    startActivity(Intent.createChooser(mail, "Enviar mail via:"));
                }

            }
        });
    }
}
