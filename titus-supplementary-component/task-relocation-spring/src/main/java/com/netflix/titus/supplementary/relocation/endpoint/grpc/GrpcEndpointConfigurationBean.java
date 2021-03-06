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

package com.netflix.titus.supplementary.relocation.endpoint.grpc;

import com.netflix.titus.runtime.endpoint.common.grpc.GrpcEndpointConfiguration;
import com.netflix.titus.runtime.util.SpringConfigurationUtil;
import org.springframework.core.env.Environment;

public class GrpcEndpointConfigurationBean implements GrpcEndpointConfiguration {

    private final Environment environment;
    private final String prefix;

    public GrpcEndpointConfigurationBean(Environment environment, String prefix) {
        this.environment = environment;
        this.prefix = prefix;
    }

    @Override
    public int getPort() {
        return SpringConfigurationUtil.getInt(environment, prefix + "port", 7104);
    }

    @Override
    public long getShutdownTimeoutMs() {
        return SpringConfigurationUtil.getLong(environment, prefix + "shutdownTimeoutMs", 30_000);
    }

    @Override
    public long getMaxConnectionAgeMs() {
        return SpringConfigurationUtil.getLong(environment, prefix + "maxConnectionAgeMs", 1800000);
    }
}
