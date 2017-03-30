/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_7a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Marliek
 */
public class ResultaatHandler {
    static String nucleotideSequentie = "atgttaaaagctataagtagatcaaagatagcaatcaatctgattcgttattcatcaacagctagcaatagtccaaagt";
    public static void main(String[] args) throws Exception{
        opslaanResultaten();
    }
    public static Connection getConnectie() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mydb";
            String username = "Marliek";
            String password = "280793Mb";
            Class.forName(driver);
            
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return conn;
        }catch(Exception e){System.out.println(e);}
        return null;
    }
    public static void opslaanResultaten() throws Exception{
        try{
            Connection conn = getConnectie();
            String querySeq ="insert into sequentie(sequentie_id , invoer_sequentie)" + "values (?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(querySeq);
            preparedStmt.setInt(1, 1);
            preparedStmt.setString(2, nucleotideSequentie);
            preparedStmt.execute();
      
            conn.close();
        }catch(Exception e){System.out.println(e);}
        
    }
}
