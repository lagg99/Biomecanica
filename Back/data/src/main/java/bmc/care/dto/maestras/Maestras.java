package bmc.care.dto.maestras;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Maestras {
    private int nmmaestro;
    private String cdmaestro;
    private String dsmaestro;
    private String feregistro;
    private String febaja;


    public String getCdmaestro() {
        return cdmaestro;
    }

    public void setCdmaestro(String cdmaestro) {
        this.cdmaestro = cdmaestro;
    }

    public String getDsmaestro() {
        return dsmaestro;
    }

    public void setDsmaestro(String dsmaestro) {
        this.dsmaestro = dsmaestro;
    }

    public String getFeregistro() {
        return feregistro;
    }

    public void setFeregistro(String feregistro) {
        this.feregistro = feregistro;
    }

    public String getFebaja() {
        return febaja;
    }

    public void setFebaja(String febaja) {
        this.febaja = febaja;
    }

    public int getNmmaestro() {
        return nmmaestro;
    }

    public void setNmmaestro(int nmmaestro) {
        this.nmmaestro = nmmaestro;
    }


    public String fechaActual(){
        Date fecha=new Date();
        SimpleDateFormat formatoFecha=new SimpleDateFormat("YYYY/MM/dd");
        return formatoFecha.format(fecha);

    }
}
