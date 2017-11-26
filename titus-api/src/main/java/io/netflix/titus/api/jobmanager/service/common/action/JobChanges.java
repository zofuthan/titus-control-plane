/*
 * Copyright 2017 Netflix, Inc.
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

package io.netflix.titus.api.jobmanager.service.common.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.netflix.titus.common.framework.reconciler.ModelActionHolder;
import io.netflix.titus.common.util.tuple.Pair;

public final class JobChanges {

    private JobChanges() {
    }

    public static JobChange wrapper(JobChange original, String wrapperSummary) {
        return new JobChange(original.getActionKind(), original.getTrigger(), original.getId(), wrapperSummary + '(' + original.getSummary() + ')');
    }

    public static Pair<JobChange, List<ModelActionHolder>> wrapper(Pair<JobChange, List<ModelActionHolder>> original,
                                                             String wrapperSummary,
                                                             ModelActionHolder... wrapperActions) {
        ArrayList<ModelActionHolder> actions = new ArrayList<>(original.getRight());
        Collections.addAll(actions, wrapperActions);
        return Pair.of(wrapper(original.getLeft(), wrapperSummary), actions);
    }
}
