/*
 * Copyright 2016 Michel Vollebregt
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

package com.github.mvollebregt.wildmock.fluentinterface;

import com.github.mvollebregt.wildmock.exceptions.WithClauseNotSatisfiedException;
import com.github.mvollebregt.wildmock.function.ActionX;
import com.github.mvollebregt.wildmock.function.VarargsCallable;

import java.util.List;

import static com.github.mvollebregt.wildmock.implementation.MockContext.getMockContext;

public class Verify {

    private final Class[] classes;
    private final VarargsCallable expectedCalls;
    private List<Object[]> matches;

    public static Verify verify(ActionX expectedCalls) {
        Verify verify = new Verify(expectedCalls);
        verify.check();
        return verify;
    }

    Verify(VarargsCallable expectedCalls, Class... classes) {
        this.classes = classes;
        this.expectedCalls = expectedCalls;
    }

    void with(VarargsCallable<Boolean> predicate) {
        if (!matches.stream().filter(predicate::apply).findAny().isPresent()) {
            throw new WithClauseNotSatisfiedException(matches);
        }
    }

    void check() {
        matches = getMockContext().verify(expectedCalls, classes);
    }
}
