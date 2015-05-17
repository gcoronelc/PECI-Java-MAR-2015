package egcc.model;

import egcc.accesodb.AccesoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContadorModel {

	public static String getContador( String nombreTabla) throws Exception{
        
        Connection cn = AccesoDB.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String contador = null;
        
        String sql = "select right(concat(repeat('0',int_contlongitud)," +
		"int_contitem),int_contlongitud) as item from contador " + 
        "where vch_conttabla = ?";
        
        ps = cn.prepareStatement(sql);
		nombreTabla = nombreTabla.toUpperCase();
		ps.setString(1, nombreTabla);
        rs = ps.executeQuery();
        
        if( ! rs.next() ){
            return contador;
        } 
        
        contador = rs.getString("item");
    
        sql = "update contador " + 
        "set int_contitem = int_contitem + 1 " + 
        "where vch_conttabla = ?";
        
        ps = cn.prepareStatement(sql);
		ps.setString(1, nombreTabla);
		ps.executeUpdate();
        
        rs.close();
        ps.close();
        
        return contador;
        
    } // getContador
	
	
}
