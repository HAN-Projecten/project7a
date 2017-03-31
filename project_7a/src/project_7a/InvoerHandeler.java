/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_7a;

import java.io.*;

/**
 *
 * @author Roel Koper
 */

public class InvoerHandeler {
    
    StringBuilder seq = new StringBuilder();
    String sequentie;
    String header;
    boolean dna;

    /**
     *
     * @param bestand
     * @return 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String bestandLezen(BufferedReader bestand) throws FileNotFoundException, IOException{    
        String line;
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
        return sequentie;
    }
                
    /**
     *
     * @param doorvoer
     * @return
     */
    public boolean DNAorNOT(String doorvoer){
       dna = false;
       final String ISDNA = "^[AUCG]+$";  

       dna = doorvoer.matches(ISDNA);
       return dna;
    }
}


    
    

