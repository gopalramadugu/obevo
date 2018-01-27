/**
 * Copyright 2017 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.gs.obevocomparer.util;

import java.util.Collection;

public class CollectionFactory<T> implements Factory<Collection<T>> {

    private final Class<? extends Collection> collectionClass;

    @SuppressWarnings( { "rawtypes", "unchecked" })
    public CollectionFactory(Class<? extends Collection> collectionClass) {
        this.collectionClass = collectionClass;
    }

    public Collection<T> create() {
        try {
            return this.collectionClass.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
