package romi.com.pimes.mypimes;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener{

    /*
    Instancias para los Views
     */
    Spinner genreSpinner;
    Spinner artistSpinner;
    TextView lyricList;
    EditText direccion;
    EditText telefono;

    /*
    Adaptadores para los Spinners
     */
    SimpleCursorAdapter genreSpinnerAdapter;

    /*
    Nuestro origen de datos
     */
    LyrikDataSource dataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Iniciando nuestro origen de datos
         */
        dataSource = new LyrikDataSource(this);

        /*
        Obteniendo las instancias de los Spinners
         */
        genreSpinner = (Spinner)findViewById(R.id.spinner);

        lyricList =(TextView)findViewById(R.id.textView2);

        direccion =(EditText) findViewById(R.id.editText);
        telefono =(EditText) findViewById(R.id.editText2);


        /*
        Creando Adaptador para GenreSpinner
         */
        genreSpinnerAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_spinner_item,//Layout simple
                dataSource.getAllClientes(),//Todos los registros
                new String[]{DataBaseScript.ClientesColumns.NAME_CLIE},//Mostrar solo el nombre
                new int[]{android.R.id.text1},//View para el nombre
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);//Observer para el refresco

        /*
        Seteando Adaptador de GenreSpinner
         */
        genreSpinner.setAdapter(genreSpinnerAdapter);

        /*
        Relacionado la escucha de selección de GenreSpinner
         */
        genreSpinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        /*
        Obteniendo el id del Spinner que recibió el evento
         */
        int idSpinner = parent.getId();


        switch(idSpinner) {

            case R.id.spinner:
            /*
            Obteniendo el id del género seleccionado
             */

                Cursor c2 = (Cursor) parent.getItemAtPosition(position);
                String clienteSelection = c2.getString(
                        c2.getColumnIndex(DataBaseScript.ClientesColumns.NAME_CLIE));

                 /*
                Cambiando el texto según el Cliente seleccionado
                 */

                String description = c2.getString(
                        c2.getColumnIndex(DataBaseScript.ClientesColumns.DIRECCION_CLIE));
                direccion.setText(description);

                String descriptionTel = c2.getString(
                        c2.getColumnIndex(DataBaseScript.ClientesColumns.TELEFONO_CLIE));
                telefono.setText(descriptionTel);

                break;

        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        /*
        Nada por hacer
         */

    }

    public void lanzar(View view) {
        Intent i = new Intent(this, PedidosActivity.class );
        startActivity(i);
    }

}