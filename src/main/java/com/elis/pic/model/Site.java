package com.elis.pic.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="SITE")
public class Site {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Size(min=3, max=50)
    @Column(name = "NOM", nullable = false)
    private String nom;
 
    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(name = "DATE_OUVERTURE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate dateOuverture;
 
    @NotNull
    @Digits(integer=8, fraction=2)
    @Column(name = "NOMBRE_SALARIES", nullable = false)
    private BigDecimal nombreSalaries;
     
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getNom() {
        return nom;
    }
 
    public void setNom(String nom) {
        this.nom = nom;
    }
 
    public LocalDate getDateOuverture() {
        return dateOuverture;
    }
 
    public void setDateOuverture(LocalDate dateOuverture) {
        this.dateOuverture = dateOuverture;
    }
 
    public BigDecimal getNombreSalaries() {
        return nombreSalaries;
    }
 
    public void setNombreSalaries(BigDecimal nombreSalaries) {
        this.nombreSalaries = nombreSalaries;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Site))
            return false;
        Site other = (Site) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Site [id=" + id + ", nom=" + nom + ", dateOuverture="
                + dateOuverture + ", nombreSalaries=" + nombreSalaries + "]";
    }
     
}
