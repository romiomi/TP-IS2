package romi.com.pimes.mypimes;

/**
 * Created by Romi on 27/10/2016.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LyrikReaderDbHelper extends SQLiteOpenHelper {



    public LyrikReaderDbHelper(Context context){
        super(  context,
                DataBaseScript.DATABASE_NAME,
                null,
                DataBaseScript.DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
        Crear las tablas
         */
        db.execSQL(DataBaseScript.CREATE_CLIENTES_SCRIPT);
        db.execSQL(DataBaseScript.CREATE_PRODUCTOS_SCRIPT);
        db.execSQL(DataBaseScript.CREATE_PEDIDOS_SCRIPT);

        /*
        Insertar registros iniciales
         */
        db.execSQL(DataBaseScript.INSERT_CLIENTES_SCRIPT);
        db.execSQL(DataBaseScript.INSERT_PRODUCTOS_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            /*  Añade los cambios que se realizarán en el esquema
                en tu proxima versión
             */
    }

}
