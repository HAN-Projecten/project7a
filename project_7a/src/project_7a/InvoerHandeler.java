/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_7a;

import java.io.*;

/**
 *
 * @author roel
 */

public class InvoerHandeler {
    
    static StringBuilder seq = new StringBuilder();
    static String sequentie;
    static String header;
    static boolean dna;

   public static void bestandLezen(BufferedReader bestand) throws FileNotFoundException, IOException{    
        String line = "";
        boolean start = false ;

        while ( ( line = bestand.readLine()) != null){
            if (line.startsWith(">") && !start ){
                header = line;
                start = true;
            }
            else if (line.startsWith(">") && start) {
                break;
            }
            else {
                seq.append(line);
            }
        }
        sequentie = seq.toString();
    }
                
   
   public boolean DNAorNOT(String doorvoer){
       dna = false;
       final String ISDNA = "^[AUCG]+$";  

       dna = doorvoer.matches(ISDNA);
       return dna;
    }
}


    
    

