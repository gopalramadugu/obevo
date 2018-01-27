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
package com.gs.obevo.mongodb.impl;

import com.gs.obevo.api.platform.Platform;
import com.gs.obevo.impl.AbstractEnvironmentEnricher;
import com.gs.obevo.mongodb.api.appdata.MongoDbEnvironment;
import org.apache.commons.configuration.HierarchicalConfiguration;

public class MongoDbEnvironmentEnricher extends AbstractEnvironmentEnricher<MongoDbEnvironment> {
    @Override
    protected MongoDbEnvironment createNewEnv() {
        return new MongoDbEnvironment();
    }

    @Override
    protected void createEnv(MongoDbEnvironment env, HierarchicalConfiguration sysCfg, HierarchicalConfiguration envCfg, Platform systemDbPlatform) {
        env.setPlatform((MongoDbPlatform) systemDbPlatform);
        env.setConnectionURI(envCfg.getString("[@connectionURI]"));
    }
}
