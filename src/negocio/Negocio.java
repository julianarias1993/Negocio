package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Negocio {

    public static void main(String[] args) {
        
        Connection conexion;
        
        try{        
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/negocio","root","");
            Statement stmt = conexion.createStatement();
            ResultSet consulta = stmt.executeQuery("SELECT * FROM clientes WHERE id = ");
            ResultSetMetaData metadata = consulta.getMetaData();
            
            System.out.println( metadata.getColumnName(1)+"\t|"+
                                metadata.getColumnName(2)+"\t|"+
                                metadata.getColumnName(3)+"\t|"+
                                metadata.getColumnName(4)+"\t|");
            
            System.out.println("");
            while(consulta.next()){
                for(int i = 1; i <= metadata.getColumnCount(); i++) {
                    System.out.print(consulta.getString(i)+"\t|");
                }
                System.out.println("");
            }
            
        }catch(SQLException ex){
            System.out.println(ex);       
        }
    }
}