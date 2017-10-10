package com.example.angelus.ejercicio2moviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView textView;
EditText editText2;
Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView)findViewById(R.id.textView);
        String nombre = getIntent().getExtras().getString("nombre");
        String sexo = getIntent().getExtras().getString("sexo");
        textView.setText("Hola "+nombre+" eres "+sexo+" indicame tu edad");


        editText2 = (EditText)findViewById(R.id.editText2);
        button2 = (Button)findViewById(R.id.button2);



        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //observamos que con getIntent() recogemos la "intencion"/datos que le pasó el Padre
                getIntent().putExtra("edad", editText2.getText().toString());
                setResult(RESULT_OK, getIntent());
                finish();



            }

        });

    }
}
