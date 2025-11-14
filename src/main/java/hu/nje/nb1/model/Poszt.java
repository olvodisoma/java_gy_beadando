package hu.nje.nb1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "poszt")
public class Poszt {

    @Id
    private Integer id;

    private String nev;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }
}
