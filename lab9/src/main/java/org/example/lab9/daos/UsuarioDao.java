package org.example.lab9.daos;
import org.example.lab9.dto.listaUsuarios;
import org.example.lab9.beans.usuario;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao extends DaoBase{
    public ArrayList<listaUsuarios> listarUsuarios(){

        ArrayList<listaUsuarios> lista = new ArrayList<>();

        String sql = "select u.nombres, u.apellidos, l.categoria, l.fecha_emision, l.fecha_caducidad, " +
                "(select p.nombre_pais from pais p WHERE p.idpais = l.pais_idpais) as 'pais'" +
                "from usuario u, licencia l, pais p" +
                "inner join renta_auto r on (r.usuario_idusuario = u.idUsuario) " +
                "group by r.usuario_idusuario " +
                "where u.rol_idrol ='1' or u.rol_idrol ='3' ";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                listaUsuarios e = new listaUsuarios();
                e.setNombres(rs.getString(1));
                e.setApellidos(rs.getString(2));
                e.setCategoria_licencia(rs.getString(3));
                e.setFecha_emision(rs.getDate(4));
                e.setFecha_caducidad(rs.getDate(5));

                e.setPais(rs.getString(6));
                e.setReserva(rs.getBoolean(7));


                lista.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;

    }
    public boolean validarUsuarioPassword(String username, String password){

        String sql = "SELECT * FROM credenciales_usuario where correo = ? and contraseña_encriptada = SHA2(?,256)";

        boolean exito = false;

        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,username);
            pstmt.setString(2,password);

            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    exito = true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return exito;
    }
    public usuario getUsuarioCorreo(String correo){
        usuario usuario = new usuario();
        String sql = "SELECT * FROM usuario WHERE idusuario = (SELECT idusuario FROM credenciales_usuario WHERE correo = ?)";
        try(Connection connection = this.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,correo);


            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    usuario.setIdUsuario(rs.getInt(1));
                    usuario.setNombres(rs.getString(2));
                    usuario.setApellidos(rs.getString(3));
                    usuario.setTelefono(rs.getInt(4));
                    usuario.setIdRol(rs.getInt(5));
                    usuario.setIdLicencia(rs.getInt(6));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return usuario;
    }
}
