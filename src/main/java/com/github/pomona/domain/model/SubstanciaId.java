package com.github.pomona.domain.model;

import com.github.common.domain.model.ValueObject;

public class SubstanciaId extends ValueObject{
    private String id;

    public SubstanciaId(String umId) {
        this();

        this.setId(umId);
    }

    public SubstanciaId(SubstanciaId umAlimentoId) {
        this(umAlimentoId.id());
    }

    public String id() {
        return this.id;
    }

    @Override
    public boolean equals(Object umObjeto) {
        boolean equalObjects = false;

        if (umObjeto != null && this.getClass() == umObjeto.getClass()) {
            SubstanciaId typedObject = (SubstanciaId) umObjeto;
            equalObjects = this.id().equals(typedObject.id());
        }

        return equalObjects;
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
            + (38313 * 43)
            + this.id().hashCode();

        return hashCodeValue;
    }

    @Override
    public String toString() {
        return "SubstanciaId [id=" + id + "]";
    }

    private SubstanciaId() {
        super();
    }

    private void setId(String umId) {
        this.assertArgumentNotEmpty(umId, "The id must be provided.");
        this.assertArgumentLength(umId, 36, "The id must be 36 characters or less.");

        this.id = umId;
    }
}
