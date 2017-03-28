/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_7a;

/**
 *
 * @author Martijn Landman
 */
public class SequentieHandler {
    
    public static void main(String[] args) {
        new SequentieHandler().maakReadingFrames("aucg");
    }
    
    public void maakReadingFrames(String nucleotideSequentie) {
        String forwardSequentie = nucleotideSequentie.toUpperCase();
        String reverseSequentie = maakReverseSequentie(forwardSequentie);
//        System.out.println(forwardSequentie+"\n"+reverseSequentie);
        
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
    
    public void maakAminozuurSequentie(String nucleotideSequentie) {
        
    }
    
}
