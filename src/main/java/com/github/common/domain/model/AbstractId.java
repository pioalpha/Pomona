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

public abstract class AbstractId
    extends AssertionConcern
    implements Identity, Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    public String id() {
        return this.id;
    }

    @Override
    public boolean equals(Object umObjeto) {
        boolean equalObjects = false;

        if (umObjeto != null && this.getClass() == umObjeto.getClass()) {
            AbstractId typedObject = (AbstractId) umObjeto;
            equalObjects = this.id().equals(typedObject.id());
        }

        return equalObjects;
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
                + (this.hashOddValue() * this.hashPrimeValue())
                + this.id().hashCode();

        return hashCodeValue;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + "]";
    }

    protected AbstractId(String umId) {
        this();

        this.setId(umId);
    }

    protected AbstractId() {
        super();
    }

    protected abstract int hashOddValue();

    protected abstract int hashPrimeValue();

    protected void validateId(String umId) {
        // implemented by subclasses for validation.
        // throws a runtime exception if invalid.
    }

    private void setId(String umId) {
        this.assertArgumentNotEmpty(umId, "The basic identity is required.");
        this.assertArgumentLength(umId, 36, "The basic identity must be 36 characters.");

        this.validateId(umId);

        this.id = umId;
    }
}
