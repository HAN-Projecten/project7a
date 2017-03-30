/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_7a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Marliek
 */
public class ResultaatHandler {
    static int sequentie_id;
    static int ORF_id;
   
    
    public static void main(String[] args) throws Exception{
        opslaanSeq(nucleotideSequentie);
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
    public static void opslaanSeq(String nucleotideSequentie) throws Exception{
        try{
            Connection conn = getConnectie();
            String querySeq ="insert into sequentie(sequentie_id , invoer_sequentie)" + "values (?,?)";
            PreparedStatement preparedQuery = conn.prepareStatement(querySeq);
            preparedQuery.setInt(0,sequentie_id );
            preparedQuery.setString(1, nucleotideSequentie);
            preparedQuery.execute();
            
            conn.close();
        }catch(Exception e){System.out.println(e);}
    }
    public static void opslaanORF(ArrayList<ORF> ORFs) throws Exception{
        try{
            Connection conn = getConnectie();
            for (ORF ORF : ORFs) {
                String queryORF = "insert into orf (ORF_id, ORF_sequentie, ORF_lengte, reading_frame, begin, eind, Sequentie_sequentie_id)" + "values (?,?,?,?,?,?,?)";
                PreparedStatement preparedORF = conn.prepareStatement(queryORF);
                preparedORF.setInt(0, ORF_id);
                preparedORF.setString(1, ORF.getSequentie()); 
                preparedORF.setInt(2, ORF.getLengte());
                preparedORF.setString(3, ORF.getReadingFrame());
                preparedORF.setInt(4, ORF.getBegin());
                preparedORF.setInt(5, ORF.getEind());
                preparedORF.setInt(6, sequentie_id);
                preparedORF.execute();
            }
            conn.close();
        }catch(Exception e){System.out.println(e);}      
    }
}
