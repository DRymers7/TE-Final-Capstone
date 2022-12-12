package com.techelevator.model.ModelClasses.edamam;

import com.techelevator.model.ModelClasses.edamam.nutrientInfo.*;

import java.util.Objects;

public class TotalDaily {

    private ENERC_KCAL enerc_kcal;
    private FAT fat;
    private FASAT fasat;
    private CHOCDF chocdf;
    private FIBTG fibtg;
    private PROCNT procnt;
    private CHOLE chole;
    private NA na;
    private CA ca;
    private MG mg;
    private K k;
    private FE fe;
    private ZN zn;
    private P p;
    private VITARae vitaRae;
    private VITc viTc;
    private THIA thia;
    private RIBF ribf;
    private NIA nia;
    private VITB6A vitb6A;
    private FOLDFE foldfe;
    private VITB12 vitb12;
    private VITD vitd;
    private TOPCHA topcha;
    private VITK1 vitk1;

    public TotalDaily() {};

    public ENERC_KCAL getEnerc_kcal() {
        return enerc_kcal;
    }

    public void setEnerc_kcal(ENERC_KCAL enerc_kcal) {
        this.enerc_kcal = enerc_kcal;
    }

    public FAT getFat() {
        return fat;
    }

    public void setFat(FAT fat) {
        this.fat = fat;
    }

    public FASAT getFasat() {
        return fasat;
    }

    public void setFasat(FASAT fasat) {
        this.fasat = fasat;
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

    public PROCNT getProcnt() {
        return procnt;
    }

    public void setProcnt(PROCNT procnt) {
        this.procnt = procnt;
    }

    public CHOLE getChole() {
        return chole;
    }

    public void setChole(CHOLE chole) {
        this.chole = chole;
    }

    public NA getNa() {
        return na;
    }

    public void setNa(NA na) {
        this.na = na;
    }

    public CA getCa() {
        return ca;
    }

    public void setCa(CA ca) {
        this.ca = ca;
    }

    public MG getMg() {
        return mg;
    }

    public void setMg(MG mg) {
        this.mg = mg;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public FE getFe() {
        return fe;
    }

    public void setFe(FE fe) {
        this.fe = fe;
    }

    public ZN getZn() {
        return zn;
    }

    public void setZn(ZN zn) {
        this.zn = zn;
    }

    public P getP() {
        return p;
    }

    public void setP(P p) {
        this.p = p;
    }

    public VITARae getVitaRae() {
        return vitaRae;
    }

    public void setVitaRae(VITARae vitaRae) {
        this.vitaRae = vitaRae;
    }

    public VITc getViTc() {
        return viTc;
    }

    public void setViTc(VITc viTc) {
        this.viTc = viTc;
    }

    public THIA getThia() {
        return thia;
    }

    public void setThia(THIA thia) {
        this.thia = thia;
    }

    public RIBF getRibf() {
        return ribf;
    }

    public void setRibf(RIBF ribf) {
        this.ribf = ribf;
    }

    public NIA getNia() {
        return nia;
    }

    public void setNia(NIA nia) {
        this.nia = nia;
    }

    public VITB6A getVitb6A() {
        return vitb6A;
    }

    public void setVitb6A(VITB6A vitb6A) {
        this.vitb6A = vitb6A;
    }

    public FOLDFE getFoldfe() {
        return foldfe;
    }

    public void setFoldfe(FOLDFE foldfe) {
        this.foldfe = foldfe;
    }

    public VITB12 getVitb12() {
        return vitb12;
    }

    public void setVitb12(VITB12 vitb12) {
        this.vitb12 = vitb12;
    }

    public VITD getVitd() {
        return vitd;
    }

    public void setVitd(VITD vitd) {
        this.vitd = vitd;
    }

    public TOPCHA getTopcha() {
        return topcha;
    }

    public void setTopcha(TOPCHA topcha) {
        this.topcha = topcha;
    }

    public VITK1 getVitk1() {
        return vitk1;
    }

    public void setVitk1(VITK1 vitk1) {
        this.vitk1 = vitk1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalDaily that = (TotalDaily) o;
        return Objects.equals(enerc_kcal, that.enerc_kcal) && Objects.equals(fat, that.fat) && Objects.equals(fasat, that.fasat) && Objects.equals(chocdf, that.chocdf) && Objects.equals(fibtg, that.fibtg) && Objects.equals(procnt, that.procnt) && Objects.equals(chole, that.chole) && Objects.equals(na, that.na) && Objects.equals(ca, that.ca) && Objects.equals(mg, that.mg) && Objects.equals(k, that.k) && Objects.equals(fe, that.fe) && Objects.equals(zn, that.zn) && Objects.equals(p, that.p) && Objects.equals(vitaRae, that.vitaRae) && Objects.equals(viTc, that.viTc) && Objects.equals(thia, that.thia) && Objects.equals(ribf, that.ribf) && Objects.equals(nia, that.nia) && Objects.equals(vitb6A, that.vitb6A) && Objects.equals(foldfe, that.foldfe) && Objects.equals(vitb12, that.vitb12) && Objects.equals(vitd, that.vitd) && Objects.equals(topcha, that.topcha) && Objects.equals(vitk1, that.vitk1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enerc_kcal, fat, fasat, chocdf, fibtg, procnt, chole, na, ca, mg, k, fe, zn, p, vitaRae, viTc, thia, ribf, nia, vitb6A, foldfe, vitb12, vitd, topcha, vitk1);
    }

    @Override
    public String toString() {
        return "TotalDaily{" +
                "enerc_kcal=" + enerc_kcal +
                ", fat=" + fat +
                ", fasat=" + fasat +
                ", chocdf=" + chocdf +
                ", fibtg=" + fibtg +
                ", procnt=" + procnt +
                ", chole=" + chole +
                ", na=" + na +
                ", ca=" + ca +
                ", mg=" + mg +
                ", k=" + k +
                ", fe=" + fe +
                ", zn=" + zn +
                ", p=" + p +
                ", vitaRae=" + vitaRae +
                ", viTc=" + viTc +
                ", thia=" + thia +
                ", ribf=" + ribf +
                ", nia=" + nia +
                ", vitb6A=" + vitb6A +
                ", foldfe=" + foldfe +
                ", vitb12=" + vitb12 +
                ", vitd=" + vitd +
                ", topcha=" + topcha +
                ", vitk1=" + vitk1 +
                '}';
    }
}
