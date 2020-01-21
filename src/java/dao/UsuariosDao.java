/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.*;
import model.Usuarios;

/**
 *
 * @author usuario
 */
public class UsuariosDao {
    public static Usuarios accesar(String usuario, String contra){
        try {
            
            String SQL="select Nombre,nivel from login where Nombre='"+usuario+"' and password='"+contra+"';";
       
            Connection con= Conexion.conectar();
            PreparedStatement st= con.prepareStatement(SQL);
            ResultSet resultado= st.executeQuery();
            Usuarios u=null;
            while(resultado.next()){
                u= new Usuarios();
                u.setNombre(resultado.getString("Nombre"));
                u.setNivel(resultado.getInt("nivel"));
            }
            return u;
        }catch (SQLException ex) {
            return null;
        }
    }
}
