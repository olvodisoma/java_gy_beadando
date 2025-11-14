package hu.nje.nb1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "uzenet")
public class Uzenet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "A név megadása kötelező!")
    private String nev;

    @NotBlank(message = "Az email megadása kötelező!")
    @Email(message = "Érvényes email címet adj meg!")
    private String email;

    @NotBlank(message = "Az üzenet nem lehet üres!")
    private String uzenet;

    @Column(name = "kuldes_ideje", insertable = false, updatable = false)
    private LocalDateTime kuldesIdeje;

    // Getterek és setterek
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNev() { return nev; }
    public void setNev(String nev) { this.nev = nev; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUzenet() { return uzenet; }
    public void setUzenet(String uzenet) { this.uzenet = uzenet; }

    public LocalDateTime getKuldesIdeje() { return kuldesIdeje; }
    public void setKuldesIdeje(LocalDateTime kuldesIdeje) { this.kuldesIdeje = kuldesIdeje; }
}
