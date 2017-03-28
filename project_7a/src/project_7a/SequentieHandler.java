/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_7a;

import java.util.HashMap;

/**
 *
 * @author Martijn Landman
 */
public class SequentieHandler {
    
    private HashMap<String, String> readingFrames = new HashMap<String, String>();
    private String aminozuurSequentie = "";
    private static final HashMap<String, String> code;
    static {
        code = new HashMap<String, String>();
        code.put("uuu", "F");code.put("ucu", "S");code.put("uau", "Y");code.put("ugu", "C");
        code.put("uuc", "F");code.put("ucc", "S");code.put("uac", "Y");code.put("ugc", "C");
        code.put("uua", "L");code.put("uca", "S");code.put("uaa", "*");code.put("uga", "*");
        code.put("uug", "L");code.put("ucg", "S");code.put("uag", "*");code.put("ugg", "W");
        code.put("cuu", "L");code.put("ccu", "P");code.put("cau", "H");code.put("cgu", "R");
        code.put("cuc", "L");code.put("ccc", "P");code.put("cac", "H");code.put("cgc", "R");
        code.put("cua", "L");code.put("cca", "P");code.put("caa", "Q");code.put("cga", "R");
        code.put("cug", "L");code.put("ccg", "P");code.put("cag", "Q");code.put("cgg", "R");
        code.put("auu", "I");code.put("acu", "u");code.put("aau", "N");code.put("agu", "S");
        code.put("auc", "I");code.put("acc", "u");code.put("aac", "N");code.put("agc", "S");
        code.put("aua", "I");code.put("aca", "u");code.put("aaa", "K");code.put("aga", "R");
        code.put("aug", "M");code.put("acg", "u");code.put("aag", "K");code.put("agg", "R");
        code.put("guu", "V");code.put("gcu", "A");code.put("gau", "D");code.put("ggu", "G");
        code.put("guc", "V");code.put("gcc", "A");code.put("gac", "D");code.put("ggc", "G");
        code.put("gua", "V");code.put("gca", "A");code.put("gaa", "E");code.put("gga", "G");
        code.put("gug", "V");code.put("gcg", "A");code.put("gag", "E");code.put("ggg", "G");
    }
    
    public HashMap maakReadingFrames(String nucleotideSequentie) {
        String forwardSequentie = nucleotideSequentie.toUpperCase();
        String reverseSequentie = maakReverseSequentie(forwardSequentie);
        readingFrames.put("1+", forwardSequentie);
        readingFrames.put("2+", forwardSequentie.substring(1, forwardSequentie.length()));
        readingFrames.put("3+", forwardSequentie.substring(2, forwardSequentie.length()));
        readingFrames.put("1-", reverseSequentie);
        readingFrames.put("2-", reverseSequentie.substring(1, reverseSequentie.length()));
        readingFrames.put("3-", reverseSequentie.substring(2, reverseSequentie.length()));
        return readingFrames;
    }
    
    public String maakReverseSequentie(String forwardSequentie) {
        String reverseSequentie = "";
        for (int i=0; i<forwardSequentie.length(); i++){
            switch (forwardSequentie.charAt(i)) {
                case 'A':
                    reverseSequentie += "U";
                    break;
                case 'U':
                    reverseSequentie += "A";
                    break;
                case 'C':
                    reverseSequentie += "G";
                    break;
                case 'G':
                    reverseSequentie += "C";
                    break;
                default:
                    break;
            }
        }
        return reverseSequentie;
    }
    
    public String maakAminozuurSequentie(String nucleotideSequentie) {
        for (int i=0; i<nucleotideSequentie.length(); i+=3) {
            try {
                String codon = nucleotideSequentie.substring(i, i+3);
                aminozuurSequentie += code.get(codon);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("OUT OF BOUNDS");
            }
        }
        
        return aminozuurSequentie;
    }
    
}
