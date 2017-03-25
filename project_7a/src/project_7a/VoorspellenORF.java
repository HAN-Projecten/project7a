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
 * @author Martlan
 */
public class VoorspellenORF {
    
    private static final List<String> startCodons = Arrays.asList("AUG","UUG","GUG");
    private static final List<String> stopCodons = Arrays.asList("UAA","UGA","UAG");
    private List<ORF> ORFs = new ArrayList<ORF>();
    
    public static void main(String[] args) {
        HashMap stuff = new HashMap();
        stuff.put("1+", "atcAUGuuuaaauuuUGAtttUUGcccaaacccUAG");
        new VoorspellenORF().voorspelORF(stuff);
    }
    
    public void voorspelORF(HashMap<String,String> nucleotideSequenties) {
        String readingFrame;
        String sequentie;
        int begin = 0;
        int eind;
        int lengte;
        boolean start = false;
        String codon = null;
        for (Map.Entry<String,String> entry : nucleotideSequenties.entrySet()) {
            readingFrame = entry.getKey();
            sequentie = entry.getValue();
            for (int i = 0; i < sequentie.length(); i+=3) {
                try {
                    codon = sequentie.substring(i, i+3).toUpperCase();
//                    System.out.println(codon);
                } catch (StringIndexOutOfBoundsException e) {
//                    System.out.println("OUT OF BOUNDS");
                }
                if (!start && startCodons.contains(codon)) {
                    start = true;
                    begin = i+1;
                }
                else if (start && stopCodons.contains(codon)) {
                    start = false;
                    eind = i+3;
                    String ORFsequentie = sequentie.substring(begin-1, eind).toUpperCase();
                    lengte = ORFsequentie.length();
                    ORF temp = new ORF(begin, eind, lengte, readingFrame, ORFsequentie);
                    ORFs.add(temp);
                }
            }
        }
//        System.out.println(ORFs);
//        System.out.println(ORFs.get(0).getBegin()+"\n"+ORFs.get(0).getEind()+"\n"+ORFs.get(0).getLengte()+"\n"+ORFs.get(0).getSequentie()+"\n"+ORFs.get(0).getReadingFrame());
    }

}
