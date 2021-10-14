package bmc.care.dto.dataMaestra;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataMaestra {
    private int nmmaestro;
    private int nmdato;
    private String cddato;
    private String dsdato;
    private String cddato1;
    private String cddato2;
    private  String cddato3;
    private String feregitro;
    private String febaja;

    public int getNmmaestro() {
        return nmmaestro;
    }

    public void setNmmaestro(int nmmaestro) {
        this.nmmaestro = nmmaestro;
    }

    public int getNmdato() {
        return nmdato;
    }

    public void setNmdato(int nmdato) {
        this.nmdato = nmdato;
    }

    public String getCddato() {
        return cddato;
    }

    public void setCddato(String cddato) {
        this.cddato = cddato;
    }

    public String getDsdato() {
        return dsdato;
    }

    public void setDsdato(String dsdato) {
        this.dsdato = dsdato;
    }

    public String getCddato1() {
        return cddato1;
    }

    public void setCddato1(String cddato1) {
        this.cddato1 = cddato1;
    }

    public String getCddato2() {
        return cddato2;
    }

    public void setCddato2(String cddato2) {
        this.cddato2 = cddato2;
    }

    public String getCddato3() {
        return cddato3;
    }

    public void setCddato3(String cddato3) {
        this.cddato3 = cddato3;
    }

    public String getFeregitro() {
        return feregitro;
    }

    public void setFeregitro(String feregitro) {
        this.feregitro = feregitro;
    }

    public String getFebaja() {
        return febaja;
    }

    public void setFebaja(String febaja) {
        this.febaja = febaja;
    }
    public String fechaActual(){
        Date fecha=new Date();
        SimpleDateFormat formatoFecha=new SimpleDateFormat("YYYY/MM/dd");
        return formatoFecha.format(fecha);

    }
}
