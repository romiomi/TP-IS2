package romi.com.pimes.mypimes;

/**
 * Created by Romi on 27/10/2016.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class LyrikDataSource {

    /*
    Variables para manipulación de datos
     */
    private LyrikReaderDbHelper openHelper;
    private SQLiteDatabase database;

    public LyrikDataSource(Context context) {
        /*
        Creando una instancia hacia la base de datos
         */
        openHelper = new LyrikReaderDbHelper(context);
        database = openHelper.getWritableDatabase();
    }

    public Cursor getAllClientes(){
        /*
        Seleccionamos todas las filas de la tabla Clientes
         */
        return database.rawQuery(
                "select * from " + DataBaseScript.CLIENTES_TABLE_NAME, null);
    }

    public Cursor getAllProductos(){
        /*
        Seleccionamos todas las filas de la tabla Productos
         */
        return database.rawQuery(
                "select * from " + DataBaseScript.PRODUCTOS_TABLE_NAME, null);
    }


    public Cursor getOtrosDatosByClientes(String clientesSelection) {

        /*
        Argumentos del WHERE
         */
        String selectionArgs[] = new String[]{clientesSelection};


        String query =
                "select "+DataBaseScript.ClientesColumns.ID_CLIE+","+DataBaseScript.ClientesColumns.NAME_CLIE+
                        " from "+DataBaseScript.CLIENTES_TABLE_NAME +
                        " where "+DataBaseScript.ClientesColumns.ID_CLIE+
                        "= ?";
        return database.rawQuery(query,selectionArgs);
    }
}
