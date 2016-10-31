package romi.com.pimes.mypimes;

/**
 * Created by Romi on 27/10/2016.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PedidosDataSource {

    /*
    Variables para manipulación de datos
     */
    private PedidosReaderDbHelper openHelper;
    private SQLiteDatabase database;


    public PedidosDataSource(Context context) {
        /*
        Creando una instancia hacia la base de datos
         */
        openHelper = new PedidosReaderDbHelper(context);
        database = openHelper.getWritableDatabase();
    }

    public Cursor getAllProductos(){
        /*
        Seleccionamos todas las filas de la tabla Productos
         */
        return database.rawQuery(
                "select * from " + DataBaseScript.PRODUCTOS_TABLE_NAME, null);
    }

    public Cursor getAllPedidos(){
        /*
        Seleccionamos todas las filas de la tabla Pedidos
         */
        return database.rawQuery(
                "select * from " + DataBaseScript.PEDIDOS_TABLE_NAME, null);
    }


    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DataBaseScript.PedidosColumns.ID_PRODUCTO,
                DataBaseScript.PedidosColumns.CANTIDAD_PEDIDO,
                DataBaseScript.PedidosColumns.MONTO_PEDIDO
        };
        Cursor c = database.query(DataBaseScript.PEDIDOS_TABLE_NAME, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }
}

