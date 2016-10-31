package romi.com.pimes.mypimes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by Romi on 28/10/2016.
 */
public class ListaPedidosActivity extends Activity {

    private ListView listaPedidos;

    private EditText producto;
    private EditText precio;
    private EditText cantidad;
    private EditText monto;

    private PedidosDataSource openHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pedidos);

        //listaPedidos = (ListView) findViewById(R.id.listView);

        producto = (EditText) findViewById(R.id.editText5);
        precio = (EditText) findViewById(R.id.editText6);
        cantidad = (EditText) findViewById(R.id.editText7);
        monto = (EditText) findViewById(R.id.editText8);

        /*Cursor cursor = openHelper.getAllPedidos();

        String[] from = new String[] {
                DataBaseScript.PedidosColumns.ID_PRODUCTO,
                DataBaseScript.PedidosColumns.PRECIO_PRODUCTO,
                DataBaseScript.PedidosColumns.CANTIDAD_PEDIDO
        };
        int[] to = new int[] {
                R.id.spinner2,
                R.id.editText3,
                R.id.spinner3
        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                ListaPedidosActivity.this, R.layout.activity_lista_pedidos, cursor, from, to);

        adapter.notifyDataSetChanged();
        listaPedidos.setAdapter(adapter);*/

        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        if (extras != null) {//ver si contiene datos
            String datoProducto=(String)extras.get("producto");
            String datoPrecio= (String) extras.get("precio");
            String datoCantidad=(String)extras.get("cantidad");
            String datoMonto=(String)extras.get("monto");

            producto.setText(datoProducto);
            precio.setText(datoPrecio);
            cantidad.setText(datoCantidad);
            monto.setText(datoMonto);

        }
    }

    public void Finalizar(View view) {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void Atras(View view) {

        Intent i = new Intent(this, PedidosActivity.class);
        startActivity(i);
    }
}
