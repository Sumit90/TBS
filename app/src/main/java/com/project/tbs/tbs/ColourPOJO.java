package com.project.tbs.tbs;

/**
 * Created by home on 11-05-2015.
 */
public class ColourPOJO {

    String colourCode;
    String colourName;
    String colourRGB;
    String colourHex;

    public ColourPOJO()
    {

    }

    public ColourPOJO(String colourCode,String colourName,String colourRGB,String colourHex)
    {
        this.colourCode=colourCode;
        this.colourName=colourName;
        this.colourRGB=colourRGB;
        this.colourHex=colourHex;
    }


    public String getColourCode() {
        return colourCode;
    }

    public void setColourCode(String colourCode) {
        this.colourCode = colourCode;
    }

    public String getColourName() {
        return colourName;
    }

    public void setColourName(String colourName) {
        this.colourName = colourName;
    }

    public String getColourRGB() {
        return colourRGB;
    }

    public void setColourRGB(String colourRGB) {
        this.colourRGB = colourRGB;
    }

    public String getColourHex() {
        return colourHex;
    }

    public void setColourHex(String colourHex) {
        this.colourHex = colourHex;
    }
}
