/*
 * Copyright 2018 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.titus.supplementary.relocation.connector;

import com.netflix.titus.runtime.connector.GrpcClientConfiguration;
import com.netflix.titus.runtime.util.SpringConfigurationUtil;
import org.springframework.core.env.Environment;

public class GrpcClientConfigurationBean implements GrpcClientConfiguration {

    private static final String PREFIX = "titus.grpcClient.";

    private final Environment environment;

    public GrpcClientConfigurationBean(Environment environment) {
        this.environment = environment;
    }

    @Override
    public String getHostname() {
        return SpringConfigurationUtil.getString(environment, PREFIX + "hostname", "localhost");
    }

    @Override
    public int getGrpcPort() {
        return SpringConfigurationUtil.getInt(environment, PREFIX + "grpcPort", 7104);
    }

    @Override
    public long getRequestTimeout() {
        return SpringConfigurationUtil.getLong(environment, PREFIX + "requestTimeout", 10000);
    }

    @Override
    public int getMaxTaskPageSize() {
        return SpringConfigurationUtil.getInt(environment, PREFIX + "maxTaskPageSize", 5000);
    }
}
