package cap13;

import java.sql.*;
import java.util.Properties;

public class Ejemplo1301 {

    public static void main(String[] args) {

        // Definimos 3 variables de tipo Connection
        Connection conn1 = null;
        Connection conn2 = null;
        Connection conn3 = null;

        // Iniciamos un manejador de errores estándar
        try {

            // Cargamos el driver con Class.forName()
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();

            //Definimos JDBC URL, usuario, y contraseña
            String jdbcUrl = "jdbc:odbc:DSNGustavo";
            String user = "sistemas";
            String pwd = "pacherrez";
            System.out.println("Abriendo las conexiones de base de datos...");

            // Uso del primer método getConnection usando solo una JDBC URL
            conn1 = DriverManager.getConnection(jdbcUrl + ";UID=" + user + ";PWD=" + pwd);

            System.out.println("Prueba" + conn1.isClosed());
            
            // Comprobar si la conexión es satisfactoria
            if (conn1 != null) {
                System.out.println("Conexión 1 satisfactoria!!!");
            }

            // Uso del segundo método getConnection. Este requiere 
            // de un objeto Properties para guardar información especifica
            Properties prop = new Properties();
            prop.put("user", user);
            prop.put("password", pwd);
            conn2 = DriverManager.getConnection(jdbcUrl, prop);

            // Comprobar si la conexión es satisfactoria
            if (conn2 != null) {
                System.out.println("Conexión 2 satisfactoria!!!");
            }

            // Uso del tercer método getConnection que requiere tres
            // parámetros String; JDBC URL, usuario, y contraseña
            conn3 = DriverManager.getConnection(jdbcUrl, user, pwd);

            // Comprobar si la conexión es satisfactoria
            if (conn3 != null) {
                System.out.println("Conexión 3 satisfactoria!!!");
            }

            // Cerrar explícitamente todas las conexiones. SIEMPRE HACER ESTO!!!
            conn1.close();
            conn2.close();
            conn3.close();
            
            System.out.println("Prueba" + conn1.isClosed());
            
            // Comprobar si las conexiones están cerradas
            System.out.println("Cerrando todas las conexiones...");
            if (conn1.isClosed()) {
                System.out.println("Conexión 1 está cerrada");
            }
            if (conn2.isClosed()) {
                System.out.println("Conexión 2 está cerrada");
            }
            if (conn3.isClosed()) {
                System.out.println("Conexión 3 está cerrada");
            }

        } catch (SQLException se) {
            // Manejo de errores para  DriverManager
            se.printStackTrace();
        } catch (Exception e) {
            // Manejo de errores para Class.forName y todas las otras excepciones
            e.printStackTrace();
        } finally {
            // Bloque finally
            try {
                if (conn1 != null) {
                    conn1.close();
                }
                if (conn2 != null) {
                    conn2.close();
                }
                if (conn3 != null) {
                    conn3.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } // Fin detry en finally

        } // Fin de try

    } // Fin de método main
    
} // Fin de la clase Ejemplo0901