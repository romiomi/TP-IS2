package romi.com.pimes.mypimes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Romi on 28/10/2016.
 */
public class PedidosReaderDbHelper extends SQLiteOpenHelper {

    public PedidosReaderDbHelper(Context context) {
        super(context,
                DataBaseScript.DATABASE_NAME,
                null,
                DataBaseScript.DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
        Crear las tablas
         */
        db.execSQL(DataBaseScript.CREATE_PEDIDOS_SCRIPT);

        /*
        Insertar registros iniciales
         */
        db.execSQL(DataBaseScript.INSERT_PEDIDOS_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            /*  Añade los cambios que se realizarán en el esquema
                en tu proxima versión
             */
    }
}