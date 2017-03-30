/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_7a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Martijn Landman
 */
public class VoorspellenORF {
    
    private static final List<String> startCodons = Arrays.asList("AUG","UUG","GUG");
    private static final List<String> stopCodons = Arrays.asList("UAA","UGA","UAG");
    private ArrayList<ORF> ORFs = new ArrayList<ORF>();
    
    /**
     *
     * @param nucleotideSequenties
     * @return
     */
    public ArrayList<ORF> voorspelORF(HashMap<String,String> nucleotideSequenties) {
        String readingFrame;
        String sequentie;
        int begin = 0;
        int eind;
        int lengte;
        boolean start;
        String codon = null;
        for (Map.Entry<String,String> entry : nucleotideSequenties.entrySet()) {
            start = false;
            readingFrame = entry.getKey();
            sequentie = entry.getValue();
            for (int i = 0; i < sequentie.length(); i+=3) {
                try {
                    codon = sequentie.substring(i, i+3).toUpperCase();
                } catch (StringIndexOutOfBoundsException e) {
                }
                if (!start && startCodons.contains(codon)) {
                    start = true;
                    begin = i+1;
                }
                else if (start && stopCodons.contains(codon)) {
                    start = false;
                    eind = i+3;
                    String ORFsequentie = sequentie.substring(begin-1, eind);
                    lengte = ORFsequentie.length();
                    ORF temp = new ORF(begin, eind, lengte, readingFrame, ORFsequentie);
                    ORFs.add(temp);
                }
            }
        }
        return ORFs;
    }

}
