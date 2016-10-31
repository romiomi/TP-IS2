package romi.com.pimes.mypimes;

/**
 * Created by Romi on 27/10/2016.
 */

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

/**
 * Created by Romi on 26/10/2016.
 */
public class PedidosActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private PedidosReaderDbHelper openHelper;
    private SQLiteDatabase database;
    private  SQLiteDatabase db;
    /*
    Instancias para los Views
     */
    Spinner productosSpinner;
    EditText precio;
    EditText respuesta;
    Spinner cantidadSpinner;
    Button registrarPedido;

    Spinner clientesSpinner;

    /*
    Adaptadores para los Spinners
     */
    SimpleCursorAdapter productosSpinnerAdapter;

    /*
    Nuestro origen de datos
     */
    PedidosDataSource dataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        /*
        Iniciando nuestro origen de datos
         */
        dataSource = new PedidosDataSource(this);

        /*
        Obteniendo las instancias de los Spinners y EditText
         */
        productosSpinner = (Spinner) findViewById(R.id.spinner2);
        precio = (EditText) findViewById(R.id.editText3);
        respuesta = (EditText) findViewById(R.id.editText4);
        cantidadSpinner = (Spinner) findViewById(R.id.spinner3);
        registrarPedido = (Button) findViewById(R.id.button2);

        clientesSpinner = (Spinner) findViewById(R.id.spinner);
        /*
        Creando Adaptador para productosSpinner
         */
        productosSpinnerAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_spinner_item,//Layout simple
                dataSource.getAllProductos(),//Todos los registros
                new String[]{DataBaseScript.ProductosColumns.NAME_PRODUCTO},//Mostrar solo el nombre
                new int[]{android.R.id.text1},//View para el nombre
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);//Observer para el refresco

        /*
        Seteando Adaptador de productosSpinner
         */
        productosSpinner.setAdapter(productosSpinnerAdapter);

        /*
        Relacionado la escucha de selección de productosSpinner
         */
        productosSpinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        /*
        Obteniendo el id del Spinner que recibió el evento
         */
        int idSpinner = parent.getId();


        switch (idSpinner) {

            case R.id.spinner2:
            /*
            Obteniendo el id del producto seleccionado
             */

                Cursor c3 = (Cursor) parent.getItemAtPosition(position);
                String productosSelection = c3.getString(
                        c3.getColumnIndex(DataBaseScript.ProductosColumns.NAME_PRODUCTO));

                /*
                Cambiando el texto del precio según el producto seleccionado
                 */
                String precioDesc = c3.getString(
                        c3.getColumnIndex(DataBaseScript.ProductosColumns.PRECIO_PRODUCTO));
                precio.setText(precioDesc);

                /*
                Calculo del Valor de la Compra
                */
                int a = Integer.valueOf(precio.getText().toString());
                int b = Integer.valueOf(cantidadSpinner.getSelectedItem().toString());

                int c = a*b;

                respuesta.setText("El valor de la compra es :"+c);


                break;



        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        /*
        Nada por hacer
         */

    }

    public void onClick(View view) {
        if(view == registrarPedido){
            guardar();

            Intent i = new Intent(this, ListaPedidosActivity.class );

            String Producto= productosSpinner.getSelectedItem().toString();
            String Precio= precio.getText().toString();
            String Cantidad= cantidadSpinner.getSelectedItem().toString();
            String Monto= respuesta.getText().toString();

            i.putExtra("producto",Producto);
            i.putExtra("precio",Precio);
            i.putExtra("cantidad",Cantidad);
            i.putExtra("monto",Monto);



            startActivity(i);

        }
    }

    public SQLiteDatabase getWritableDatabase() {
        return db;
    }

    private void guardar()
    {
        //
        // Obtenemos los datos del formulario
        //
        ContentValues reg = new ContentValues();

        reg.put(DataBaseScript.PedidosColumns.ID_PRODUCTO, productosSpinner.getSelectedItem().toString().intern().length());
        reg.put(DataBaseScript.PedidosColumns.PRECIO_PRODUCTO, precio.getText().toString());
        reg.put(DataBaseScript.PedidosColumns.CANTIDAD_PEDIDO, cantidadSpinner.getSelectedItem().toString().intern());
        reg.put(DataBaseScript.PedidosColumns.MONTO_PEDIDO, respuesta.getText().toString());


        DataBaseScript.insert(reg);
        //
        // Devolvemos el control
        //
        setResult(RESULT_OK);
        finish();
    }

    private void cancelar()
    {
        setResult(RESULT_CANCELED, null);
        finish();
    }

}
