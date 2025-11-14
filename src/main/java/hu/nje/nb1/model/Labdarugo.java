package hu.nje.nb1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "labdarugo")
public class Labdarugo {

    @Id
    private Integer id;

    private Integer mezszam;

    @ManyToOne
    @JoinColumn(name = "klubid")
    private Klub klub;

    @ManyToOne
    @JoinColumn(name = "posztid")
    private Poszt poszt;

    private String utonev;
    private String vezeteknev;

    private LocalDate szulido;

    private Integer magyar;
    private Integer kulfoldi;
    private Integer ertek;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMezszam() {
        return mezszam;
    }

    public void setMezszam(Integer mezszam) {
        this.mezszam = mezszam;
    }

    public Klub getKlub() {
        return klub;
    }

    public void setKlub(Klub klub) {
        this.klub = klub;
    }

    public Poszt getPoszt() {
        return poszt;
    }

    public void setPoszt(Poszt poszt) {
        this.poszt = poszt;
    }

    public String getUtonev() {
        return utonev;
    }

    public void setUtonev(String utonev) {
        this.utonev = utonev;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }

    public LocalDate getSzulido() {
        return szulido;
    }

    public void setSzulido(LocalDate szulido) {
        this.szulido = szulido;
    }

    public Integer getMagyar() {
        return magyar;
    }

    public void setMagyar(Integer magyar) {
        this.magyar = magyar;
    }

    public Integer getKulfoldi() {
        return kulfoldi;
    }

    public void setKulfoldi(Integer kulfoldi) {
        this.kulfoldi = kulfoldi;
    }

    public Integer getErtek() {
        return ertek;
    }

    public void setErtek(Integer ertek) {
        this.ertek = ertek;
    }
}
