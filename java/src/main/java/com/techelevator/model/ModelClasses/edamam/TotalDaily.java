package com.techelevator.model.ModelClasses.edamam;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.model.ModelClasses.edamam.nutrientInfo.*;

import java.util.Objects;

public class TotalDaily {

    @JsonProperty("ENERC_KCAL")
    private ENERC_KCAL enerc_kcal;
//    private FAT fat;
//    private FASAT fasat;
    @JsonProperty("CHOCDF")
    private CHOCDF chocdf;
    @JsonProperty("FIBTG")
    private FIBTG fibtg;
//    private PROCNT procnt;
//    private CHOLE chole;
//    private NA na;
//    private CA ca;
//    private MG mg;
//    private K k;
//    private FE fe;
//    private ZN zn;
//    private P p;
//    private VITARae vitaRae;
//    private VITc viTc;
//    private THIA thia;
//    private RIBF ribf;
//    private NIA nia;
//    private VITB6A vitb6A;
//    private FOLDFE foldfe;
//    private VITB12 vitb12;
//    private VITD vitd;
//    private TOPCHA topcha;
//    private VITK1 vitk1;

    public TotalDaily() {};

    public ENERC_KCAL getEnerc_kcal() {
        return enerc_kcal;
    }

    public void setEnerc_kcal(ENERC_KCAL enerc_kcal) {
        this.enerc_kcal = enerc_kcal;
    }

    public CHOCDF getChocdf() {
        return chocdf;
    }

    public void setChocdf(CHOCDF chocdf) {
        this.chocdf = chocdf;
    }

    public FIBTG getFibtg() {
        return fibtg;
    }

    public void setFibtg(FIBTG fibtg) {
        this.fibtg = fibtg;
    }


}
