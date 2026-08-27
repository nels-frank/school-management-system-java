/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adzua Frank
 */
@Entity
@Table(name = "resultusers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultusers.findAll", query = "SELECT r FROM Resultusers r")
    , @NamedQuery(name = "Resultusers.findByUsername", query = "SELECT r FROM Resultusers r WHERE r.username = :username")
    , @NamedQuery(name = "Resultusers.findByPassword", query = "SELECT r FROM Resultusers r WHERE r.password = :password")
    , @NamedQuery(name = "Resultusers.findByRole", query = "SELECT r FROM Resultusers r WHERE r.role = :role")
    , @NamedQuery(name = "Resultusers.deleteByUsername", query = "DELETE FROM Resultusers r WHERE r.username = :username")
    , @NamedQuery(name = "Resultusers.findByStatus", query = "SELECT r FROM Resultusers r WHERE r.status = :status")})
public class Resultusers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "username")
    private String username;
    @Size(max = 100)
    @Column(name = "password")
    private String password;
    @Size(max = 100)
    @Column(name = "role")
    private String role;
    @Size(max = 100)
    @Column(name = "status")
    private String status;

    public Resultusers() {
    }

    public Resultusers(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultusers)) {
            return false;
        }
        Resultusers other = (Resultusers) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Resultusers[ username=" + username + " ]";
    }
    
}
