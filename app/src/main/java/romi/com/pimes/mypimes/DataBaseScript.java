package romi.com.pimes.mypimes;

/**
 * Created by Romi on 27/10/2016.
 */
import android.content.ContentValues;
import android.provider.BaseColumns;

public class DataBaseScript {

    //Metainformación de la base de datos - Creacion de la Base de datos
    public static final String DATABASE_NAME = "database.db";
    public static final int DATABASE_VERSION = 1;
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";

    /*
    Nombres de las tablas
     */
    public static final String CLIENTES_TABLE_NAME = "Clientes";
    public static final String PRODUCTOS_TABLE_NAME = "Productos";
    public static final String PEDIDOS_TABLE_NAME = "Pedidos";

    public static void insert(ContentValues reg) {

        new StringBuilder().append("insert into").append(PEDIDOS_TABLE_NAME).append("(").append(PedidosColumns.ID_PRODUCTO).append(" ").append(PedidosColumns.PRECIO_PRODUCTO).append(" ").append(PedidosColumns.CANTIDAD_PEDIDO).append(" ").append(PedidosColumns.MONTO_PEDIDO).append("\")").toString();
    }


    /*
    Nombres de los campos de las tablas
     */
    public static class ClientesColumns {
        public static final String ID_CLIE = BaseColumns._ID;
        public static final String NAME_CLIE = "name";
        public static final String DIRECCION_CLIE = "direccion";
        public static final String TELEFONO_CLIE = "telefono";
    }

    public static class ProductosColumns {
        public static final String ID_PRODUCTO = BaseColumns._ID;
        public static final String NAME_PRODUCTO = "name";
        public static final String PRECIO_PRODUCTO = "precio";
    }

    public static class PedidosColumns {
        public static final String ID_PEDIDO = BaseColumns._ID;
        public static final String ID_CLIE = "name";
        public static final String ID_PRODUCTO = "producto";
        public static final String PRECIO_PRODUCTO = "precioProducto";
        public static final String CANTIDAD_PEDIDO = "cantidad";
        public static final String MONTO_PEDIDO = "monto";
    }

    /*
    Sentencia SQL para la creación de las tablas
     */
    public static final String CREATE_CLIENTES_SCRIPT =
            "create table " + CLIENTES_TABLE_NAME + "(" +
                    ClientesColumns.ID_CLIE + " " + INT_TYPE + " primary key," +
                    ClientesColumns.NAME_CLIE + " " + STRING_TYPE + " not null," +
                    ClientesColumns.DIRECCION_CLIE + " " + STRING_TYPE + " not null," +
                    ClientesColumns.TELEFONO_CLIE + " " + STRING_TYPE + " not null)";

    public static final String CREATE_PRODUCTOS_SCRIPT =
            "create table " + PRODUCTOS_TABLE_NAME + "(" +
                    ProductosColumns.ID_PRODUCTO + " " + INT_TYPE + " primary key," +
                    ProductosColumns.NAME_PRODUCTO + " " + STRING_TYPE + " not null," +
                    ProductosColumns.PRECIO_PRODUCTO + " " + STRING_TYPE + " not null)";

    public static final String CREATE_PEDIDOS_SCRIPT =
            "create table " + PEDIDOS_TABLE_NAME + "(" +
                    PedidosColumns.ID_PEDIDO + " " + INT_TYPE + " primary key," +
                    PedidosColumns.ID_CLIE + " " + STRING_TYPE + " not null," +
                    PedidosColumns.ID_PRODUCTO + " " + STRING_TYPE + " not null," +
                    PedidosColumns.PRECIO_PRODUCTO + " " + STRING_TYPE + " not null," +
                    PedidosColumns.CANTIDAD_PEDIDO+ " " + STRING_TYPE + " not null," +
                    PedidosColumns.MONTO_PEDIDO+ " " + STRING_TYPE + " not null)";

    /*
   Valores para la inserción de los Clientes
    */
    public static final String[] clientesNameValues;
    public static final String[] clientesKeyValues;
    public static final String[] clientesDirValues;
    public static final String[] clientesTelValues;

    static {
        clientesDirValues = new String[]{
                "sol", "SanLorenzo", "Luque", "Aregua"
        };
        clientesKeyValues = new String[]{
                "1000", "1001", "1002", "1003"
        };
        clientesNameValues = new String[]{
                "Luis", "Pedo", "Indie", "Camila"
        };
        clientesTelValues = new String[]{
                "12345", "123456", "34567", "98764"
        };
    }

    /*
    Sentencia SQL para la inserción de Géneros
     */
    public static final String INSERT_CLIENTES_SCRIPT;

    static {
        INSERT_CLIENTES_SCRIPT = "insert into " + CLIENTES_TABLE_NAME + " values " +
                "(" + clientesKeyValues[0] + ",\"" + clientesNameValues[0] + "\",\"" + clientesDirValues[0] + "\",\"" + clientesTelValues[0] + "\")," +
                "(" + clientesKeyValues[1] + ",\"" + clientesNameValues[1] + "\",\"" + clientesDirValues[1] + "\",\"" + clientesTelValues[1] + "\")," +
                "(" + clientesKeyValues[2] + ",\"" + clientesNameValues[2] + "\",\"" + clientesDirValues[2] + "\",\"" + clientesTelValues[2] + "\")," +
                "(" + clientesKeyValues[3] + ",\"" + clientesNameValues[3] + "\",\"" + clientesDirValues[3] + "\",\"" + clientesTelValues[3] + "\")";
    }


    /*
 Valores para la inserción de los Productos
  */
    public static final String[] productosNameValues;
    public static final String[] productosKeyValues;
    public static final String[] productosPrecioValues;

    static {
        productosNameValues = new String[]{
                "Zapato", "Celular", "Notebook", "Prueba"
        };
        productosKeyValues = new String[]{
                "1000", "1001", "1002", "1004"
        };
        productosPrecioValues = new String[]{
                "1000", "20000", "30000", "40000"
        };
    }

    /*
    Sentencia SQL para la inserción de Géneros
     */
    public static final String INSERT_PRODUCTOS_SCRIPT;

    static {
        INSERT_PRODUCTOS_SCRIPT = "insert into " + PRODUCTOS_TABLE_NAME + " values " +
                "(" + productosKeyValues[0] + ",\"" + productosNameValues[0] + "\",\"" + productosPrecioValues[0] + "\")," +
                "(" + productosKeyValues[1] + ",\"" + productosNameValues[1] + "\",\"" + productosPrecioValues[1] + "\")," +
                "(" + productosKeyValues[2] + ",\"" + productosNameValues[2] + "\",\"" + productosPrecioValues[2] + "\")," +
                "(" + productosKeyValues[3] + ",\"" + productosNameValues[3] + "\",\"" + productosPrecioValues[3] + "\")";
    }

    public static final String INSERT_PEDIDOS_SCRIPT;

    static {
        INSERT_PEDIDOS_SCRIPT = "insert into " + PEDIDOS_TABLE_NAME + " values " + "("+ PedidosColumns.ID_PRODUCTO + ","+ PedidosColumns.CANTIDAD_PEDIDO+","+PedidosColumns.MONTO_PEDIDO+")";
    }

}