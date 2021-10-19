package bmc.care.dto;

public class Paciente {
    private int nmid;
    private int nmid_persona;
    private int nmid_medicotra;
    private String dseps;
    private String dsarl;
    private String feregistro;
    private String febaja;
    private String cdusuario;
    private String dscondicion;

    public int getNmid() {
        return nmid;
    }

    public void setNmid(int nmid) {
        this.nmid = nmid;
    }

    public int getNmid_persona() {
        return nmid_persona;
    }

    public void setNmid_persona(int nmid_persona) {
        this.nmid_persona = nmid_persona;
    }

    public int getNmid_medicotra() {
        return nmid_medicotra;
    }

    public void setNmid_medicotra(int nmid_medicotra) {
        this.nmid_medicotra = nmid_medicotra;
    }

    public String getDseps() {
        return dseps;
    }

    public void setDseps(String dseps) {
        this.dseps = dseps;
    }

    public String getDsarl() {
        return dsarl;
    }

    public void setDsarl(String dsarl) {
        this.dsarl = dsarl;
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

    public String getCdusuario() {
        return cdusuario;
    }

    public void setCdusuario(String cdusuario) {
        this.cdusuario = cdusuario;
    }

    public String getDscondicion() {
        return dscondicion;
    }

    public void setDscondicion(String dscondicion) {
        this.dscondicion = dscondicion;
    }
}
