/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_7a;

/**
 *
 * @author Martlan
 */
public class ORF {
    
    private int begin;
    private int eind;
    private int lengte;
    private String readingFrame;
    private String sequentie;
    
    ORF(int begin, int eind, int lengte, String readingFrame, String sequentie) {
        this.begin = begin;
        this.eind = eind;
        this.lengte = lengte;
        this.readingFrame = readingFrame;
        this.sequentie = sequentie;
    }

    /**
     * @return the begin
     */
    public int getBegin() {
        return begin;
    }

    /**
     * @param begin the begin to set
     */
    public void setBegin(int begin) {
        this.begin = begin;
    }

    /**
     * @return the eind
     */
    public int getEind() {
        return eind;
    }

    /**
     * @param eind the eind to set
     */
    public void setEind(int eind) {
        this.eind = eind;
    }

    /**
     * @return the readingFrame
     */
    public String getReadingFrame() {
        return readingFrame;
    }

    /**
     * @param readingFrame the readingFrame to set
     */
    public void setReadingFrame(String readingFrame) {
        this.readingFrame = readingFrame;
    }

    /**
     * @return the sequentie
     */
    public String getSequentie() {
        return sequentie;
    }

    /**
     * @param sequentie the sequentie to set
     */
    public void setSequentie(String sequentie) {
        this.sequentie = sequentie;
    }

    /**
     * @return the lengte
     */
    public int getLengte() {
        return lengte;
    }

    /**
     * @param lengte the lengte to set
     */
    public void setLengte(int lengte) {
        this.lengte = lengte;
    }
    
}
