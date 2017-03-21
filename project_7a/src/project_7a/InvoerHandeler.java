/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_7a;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author roel
 */
public class InvoerHandeler {
    
    private String nucleotideSequentie;
    private BufferedReader inFile;
    static StringBuilder seq = new StringBuilder();
    static String sequentie;
    
    
InvoerHandeler(String NSequentie){

        nucleotideSequentie = NSequentie;
}

    /**
     * @return the nucleotideSequentie
     */
    public String getNucleotideSequentie() {
        return nucleotideSequentie;
    }

    /**
     * @param nucleotideSequentie the nucleotideSequentie to set
     */
    public void setNucleotideSequentie(String nucleotideSequentie) {
        this.nucleotideSequentie = nucleotideSequentie;
    }
    
    public void Bestandlezen(bestand){
    String kaas;
    
    
        
    
    }
}
