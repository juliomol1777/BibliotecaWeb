/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categorias;

/**
 *
 * @author usuario
 */
public class CategoriaDao {
    public static boolean registrar(Categorias cat){
        try {
            String SQL="INSERT INTO categorias(nombre) values (?);";
            Connection con= Conexion.conectar();
            PreparedStatement st= con.prepareStatement(SQL);
            st.setString(1, cat.getNombre());
            if(st.executeUpdate()>0){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
        
    }
    
     public static ArrayList<Categorias> listar(){
        try {
            String SQL="select * from categorias;";
            Connection con= Conexion.conectar();
            PreparedStatement st= con.prepareStatement(SQL);
            //st.setString(1, cat.getNombre());
            ResultSet resultado= st.executeQuery();
            ArrayList<Categorias> lista= new ArrayList<>();
            Categorias cat;
            while(resultado.next()){
                cat= new Categorias();
                cat.setCodigo(resultado.getInt("codigo"));
                cat.setNombre(resultado.getString("nombre"));
                lista.add(cat);
            }
            return lista;

        } catch (SQLException ex) {
            return null;
        }

    }
    
    public static String getCategoria(int cod){
    try {
        String SQL="select nombre from categorias where codigo=?";
        Connection con= Conexion.conectar();
        PreparedStatement st= con.prepareStatement(SQL);
        st.setInt(1, cod);
        ResultSet resultado= st.executeQuery();
        if(resultado.next()){
            
            return resultado.getString("nombre");
            
        }
        return "--";

    } catch (SQLException ex) {
        return "--";
    }

}
    
}
