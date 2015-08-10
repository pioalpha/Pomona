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

public class AssertionConcern {

    protected AssertionConcern() {
        super();
    }

    protected void assertArgumentEquals(Object umObjeto1, Object umObjeto2, String umaMensagem) {
        if (!umObjeto1.equals(umObjeto2)) {
            throw new IllegalArgumentException(umaMensagem);
        }
    }

    protected void assertArgumentFalse(boolean umBoleano, String umaMensagem) {
        if (umBoleano) {
            throw new IllegalArgumentException(umaMensagem);
        }
    }

    protected void assertArgumentLength(String umaString, int umMaximo, String umaMensagem) {
        int length = umaString.trim().length();
        if (length > umMaximo) {
            throw new IllegalArgumentException(umaMensagem);
        }
    }

    protected void assertArgumentLength(String umaString, int umMinimo, int umMaximo, String umaMensagem) {
        int length = umaString.trim().length();
        if (length < umMinimo || length > umMaximo) {
            throw new IllegalArgumentException(umaMensagem);
        }
    }

    protected void assertArgumentNotEmpty(String umaString, String umaMensagem) {
        if (umaString == null || umaString.trim().isEmpty()) {
            throw new IllegalArgumentException(umaMensagem);
        }
    }

    protected void assertArgumentNotEquals(Object umObjeto1, Object umObjeto2, String umaMensagem) {
        if (umObjeto1.equals(umObjeto2)) {
            throw new IllegalArgumentException(umaMensagem);
        }
    }

    protected void assertArgumentNotNull(Object umObjeto, String umaMensagem) {
        if (umObjeto == null) {
            throw new IllegalArgumentException(umaMensagem);
        }
    }

    protected void assertArgumentRange(double umValor, double umMinimo, double umMaximo, String umaMensagem) {
        if (umValor < umMinimo || umValor > umMaximo) {
            throw new IllegalArgumentException(umaMensagem);
        }
    }

    protected void assertArgumentRange(float aValue, float aMinimum, float aMaximum, String aMessage) {
        if (aValue < aMinimum || aValue > aMaximum) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertArgumentRange(int aValue, int aMinimum, int aMaximum, String aMessage) {
        if (aValue < aMinimum || aValue > aMaximum) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertArgumentRange(long aValue, long aMinimum, long aMaximum, String aMessage) {
        if (aValue < aMinimum || aValue > aMaximum) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertArgumentTrue(boolean aBoolean, String aMessage) {
        if (!aBoolean) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertStateFalse(boolean aBoolean, String aMessage) {
        if (aBoolean) {
            throw new IllegalStateException(aMessage);
        }
    }

    protected void assertStateTrue(boolean aBoolean, String aMessage) {
        if (!aBoolean) {
            throw new IllegalStateException(aMessage);
        }
    }
}
