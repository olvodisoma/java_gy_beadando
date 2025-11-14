package hu.nje.nb1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "klub")
public class Klub {

    @Id
    private Integer id;

    private String csapatnev;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCsapatnev() {
        return csapatnev;
    }

    public void setCsapatnev(String csapatnev) {
        this.csapatnev = csapatnev;
    }
}
