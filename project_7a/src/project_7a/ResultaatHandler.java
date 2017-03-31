/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_7a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marliek Bonnecroij
 */
public class ResultaatHandler {
    
    static int sequentieID;
    
    public static Connection getConnectie() {
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
    
    public static void opslaanSeq(String nucleotideSequentie) {
        try{
            Connection conn = getConnectie();
            String querySeq ="insert into sequentie(sequentie_id , invoer_sequentie)" + "values (?,?)";
            PreparedStatement preparedQuery = conn.prepareStatement(querySeq);
            preparedQuery.setInt(1,getSequentie_id());
            preparedQuery.setString(2, nucleotideSequentie);
            preparedQuery.execute();
            
            conn.close();
        }catch(Exception e){System.out.println(e);}
    }
    
    public static void opslaanORF(ArrayList<ORF> ORFs) {
        try{
            Connection conn = getConnectie();
            for (ORF ORF : ORFs) {
                String queryORF = "insert into orf (ORF_id, ORF_sequentie, ORF_lengte, reading_frame, begin, eind, Sequentie_sequentie_id)" + "values (?,?,?,?,?,?,?)";
                PreparedStatement preparedORF = conn.prepareStatement(queryORF);
                preparedORF.setInt(1, getORF_id());
                preparedORF.setString(2, ORF.getSequentie()); 
                preparedORF.setInt(3, ORF.getLengte());
                preparedORF.setString(4, ORF.getReadingFrame());
                preparedORF.setInt(5, ORF.getBegin());
                preparedORF.setInt(6, ORF.getEind());
                preparedORF.setInt(7, sequentieID);
                preparedORF.execute();
            }
            conn.close();
        }catch(Exception e){System.out.println(e);}      
    }
    
    public static int getORF_id() {
        try {
            int ORFid = 0;
            Connection conn = getConnectie();
            PreparedStatement ps = conn.prepareStatement("SELECT MAX(ORF_ID) FROM ORF");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ORFid = rs.getInt(1);
            }
            return ORFid+1;
        } catch (SQLException ex) {
            Logger.getLogger(ResultaatHandler.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }
    
    public static int getSequentie_id() {
        try {
            Connection conn = getConnectie();
            PreparedStatement ps = conn.prepareStatement("SELECT MAX(sequentie_ID) FROM Sequentie");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                sequentieID = rs.getInt(1)+1;
            }
            return sequentieID;
        } catch (SQLException ex) {
            System.out.println("");
            return 1;
        }
    }
    
}
