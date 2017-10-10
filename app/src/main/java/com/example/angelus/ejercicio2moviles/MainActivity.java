package com.example.angelus.ejercicio2moviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    RadioGroup radio;
    RadioButton radioButton, radioButton2;
    TextView textView4;

    private static final int CHILD_REQUEST = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.editText);
        radio = (RadioGroup) findViewById(R.id.radio);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        button = (Button) findViewById(R.id.button);
        textView4 = (TextView)findViewById(R.id.textView4);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //El contexto y la clase a la cual nos vamos a dirigir
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);

                //con la "intencion" y el metodo putExtra podemos añadir datos y asociarle un identificador
                intent.putExtra("nombre", editText.getText().toString());


                //Comprobamos cual radioButton esta seleccionado y guardamos ese dato
                if (radioButton.isChecked() == true) {
                    intent.putExtra("sexo", (radioButton.getText().toString()));
                }
                if (radioButton2.isChecked() == true) {
                    intent.putExtra("sexo", (radioButton2.getText().toString()));
                }

                //iniciamos la activity2 pasandole el intent que son los datos que hemos recogido
                //el CHILD_REQUEST es el identificador que le damos de la activity padre, para que vuelva
                startActivityForResult(intent, CHILD_REQUEST);
            }

        });


    }

    //con este metodo ya creado de onActivityResult recuperatemos el intent pasado a la subActivity(Main2Activity)
    //Comprobamos con resultCode si la hija respondio bien, entonces modificamos el textView correspondiente.

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);



        if ((requestCode == CHILD_REQUEST) && (resultCode == RESULT_OK)) {

            //el dato que pudimos guardar en su momento en la subActivity.
            String sEdad = data.getExtras().getString("edad");
            int edad;

            try {
            edad = Integer.parseInt(sEdad);

            if(edad < 18){
                textView4.setText("Eres mas joven que un milenial tienes: "+edad) ;
            }
            if(edad >= 18 && edad < 25){
                textView4.setText("Como tienes "+edad+" ya eres mayor de edad");
            }
            if(edad >= 25 && edad < 35){
                textView4.setText("Como tienes "+edad+" estas en la flor de la vida");
            }else if(edad >= 35){
                textView4.setText("Como tienes "+edad+" ai ai ai ai ai....");
            }

            }catch (Exception e){
                textView4.setText("No pusiste un Numero entero");
            };



            }
        }


}
