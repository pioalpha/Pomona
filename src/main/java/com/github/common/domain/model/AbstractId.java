//   Copyright 2012,2013 Vaughn Vernon
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package com.github.common.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractId
    extends AssertionConcern
    implements Identity, Serializable {

    private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 36, unique = true)
    private String uuid;

    public String uuid() {
        return this.uuid;
    }

    @Override
    public boolean equals(Object umObjeto) {
        boolean equalObjects = false;

        if (umObjeto != null && this.getClass() == umObjeto.getClass()) {
            AbstractId typedObject = (AbstractId) umObjeto;
            equalObjects = this.uuid().equals(typedObject.uuid());
        }

        return equalObjects;
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
                + (this.hashValorImpar() * this.hashValorPrimo())
                + this.uuid().hashCode();

        return hashCodeValue;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [uuid=" + uuid + "]";
    }

    protected AbstractId(String umId) {
        this();

        this.setUuid(umId);
    }

    protected AbstractId() {
        super();
    }

    protected abstract int hashValorImpar();

    protected abstract int hashValorPrimo();

    protected void validarUuid(String umId) {
        // implemented by subclasses for validation.
        // throws a runtime exception if invalid.
    }

    private void setUuid(String umId) {
        this.assertArgumentNotEmpty(umId, "The basic identity is required.");
        this.assertArgumentLength(umId, 36, "The basic identity must be 36 characters.");

        this.validarUuid(umId);

        this.uuid = umId;
    }
}
