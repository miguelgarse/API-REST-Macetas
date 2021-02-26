package com.tfg.cloudlab.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACTION")
public class Actions implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String actionDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }

    @Override
    public String toString() {
        return "Actions{" +
                "id=" + id +
                ", actionDesc='" + actionDesc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actions)) return false;
        Actions actions = (Actions) o;
        return Objects.equals(id, actions.id) &&
                Objects.equals(actionDesc, actions.actionDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actionDesc);
    }
}
