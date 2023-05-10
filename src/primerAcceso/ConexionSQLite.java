package primerAcceso;

import java.sql.*;

public class ConexionSQLite {

    public static void main(String[] args) {
        Connection conexion = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:productos.db");

            Statement statement = conexion.createStatement();
            String consulta = "SELECT * FROM mitabla";
            ResultSet resultSet = statement.executeQuery(consulta);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

