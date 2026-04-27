package dao; // 

import config.ConexionDB; // 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Vehiculo; // 

public class VehiculoDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    /**
     * Registra un nuevo vehículo en la base de datos.*
     * @param v
     * @return 
     */
    public boolean insertar(Vehiculo v) {
        // Solo enviamos placa, tipo e idpersona. MySQL pondrá el ID solo.
        String sql = "INSERT INTO vehiculo (placa, tipo, idpersona) VALUES (?, ?, ?)";
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);

            ps.setString(1, v.getplaca());
            ps.setString(2, v.gettipo());
            ps.setInt(3, v.getidpersona());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    /**
     * CONSULTAR (LISTAR) Obtiene todos los registros de la tabla vehiculo *
     * @return 
     */
    public List<Vehiculo> listar() {
        List<Vehiculo> lista = new ArrayList<>();
        String sql = "SELECT * FROM vehiculo";
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vehiculo v = new Vehiculo();
                v.setidvehiculo(rs.getInt("idvehiculo"));
                v.setplaca(rs.getString("placa"));
                v.settipo(rs.getString("tipo"));
                v.setidpersona(rs.getInt("idpersona"));
                lista.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    /**
     * ACTUALIZAR Modifica los datos de un vehículo existente basado en su ID.*
     * @param v
     * @return 
     */
    public boolean actualizar(Vehiculo v) {
        String sql = "UPDATE vehiculo SET placa=?, tipo=?, idpersona=? WHERE idvehiculo=?";
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getplaca());
            ps.setString(2, v.gettipo());
            ps.setInt(3, v.getidpersona());
            ps.setInt(4, v.getidvehiculo());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    /**
     * ELIMINAR Borra un registro de la tabla vehiculo.*
     * @param id
     * @return 
     */
    public boolean eliminar(int id) {
        String sql = "DELETE FROM vehiculo WHERE idvehiculo = ?";
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
}
