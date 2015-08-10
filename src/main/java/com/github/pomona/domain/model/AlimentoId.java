package com.github.pomona.domain.model;

import com.github.common.domain.model.ValueObject;

public class AlimentoId extends ValueObject{
    private String id;

    public AlimentoId(String umId) {
        this();

        this.setId(umId);
    }

    public AlimentoId(AlimentoId umAlimentoId) {
        this(umAlimentoId.id());
    }

    public String id() {
        return this.id;
    }

    @Override
    public boolean equals(Object umObjeto) {
        boolean equalObjects = false;

        if (umObjeto != null && this.getClass() == umObjeto.getClass()) {
            AlimentoId typedObject = (AlimentoId) umObjeto;
            equalObjects = this.id().equals(typedObject.id());
        }

        return equalObjects;
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
            + (57853 * 31)
            + this.id().hashCode();

        return hashCodeValue;
    }

    @Override
    public String toString() {
        return "AlimentoId [id=" + id + "]";
    }

    private AlimentoId() {
        super();
    }

    private void setId(String umId) {
        this.assertArgumentNotEmpty(umId, "The id must be provided.");
        this.assertArgumentLength(umId, 36, "The id must be 36 characters or less.");

        this.id = umId;
    }
}
