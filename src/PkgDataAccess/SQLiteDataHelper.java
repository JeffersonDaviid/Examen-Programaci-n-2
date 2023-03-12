/*  
*  Copyright (C) 2K23, patmic
*  pat_mic@hotmail.com
*  Version 1.0
*/
package PkgDataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <b> SQLiteDataHelper, </b> permite la gestion y el acceso a los datos a una
 * base de datos SQLite3
 */
public abstract class SQLiteDataHelper {

    private static String ccDBPathConeccion = "jdbc:sqlite:data/prueba.db";
    private static Connection ccConexion = null;

    /**
     * <b>connSQLITE</b>, permite crear una sola instancia-Singeton para la
     * coneccion a la base de datos
     * 
     * @return retorna coneccion a la base de datos definida en el contructor
     * @throws SQLException
     */
    protected static Connection ccGetConnection() throws SQLException {

        if (ccConexion == null || ccConexion.isClosed()) {
            ccConexion = DriverManager.getConnection(ccDBPathConeccion);
        }
        return ccConexion;

    }

    protected static ResultSet ccGetResultSet(String sql) {
        Connection ccConexion = null;
        Statement ccStmt = null;
        ResultSet ccRs = null;

        try {
            ccConexion = ccGetConnection(); // jdbc:sqlite:data\\TinderPet.db
            ccStmt = ccConexion.createStatement(); // CRUD : select * ...
            ccRs = ccStmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Fallo CRUD en getResultSet(String sql)\nMensaje: " + e.getMessage());
        }
        return ccRs;

    }

}

/*
 * ref:
 * https://android.googlesource.com/platform/frameworks/base/+/master/core/java/
 * android/database/sqlite/SQLiteOpenHelper.java
 */