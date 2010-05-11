/**
 * Copyright 2010 CosmoCode GmbH
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

package de.cosmocode.palava.ipc.protocol;

import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.inject.internal.Maps;

import de.cosmocode.palava.ipc.IpcSession;
import de.cosmocode.palava.scope.AbstractScopeContext;

/**
 * Default implementation of the {@link DetachedConnection} interface.
 *
 * @since 1.0
 * @author Willi Schoenborn
 */
public final class DefaultDetachedConnection extends AbstractScopeContext implements DetachedConnection {

    private final Map<Object, Object> context = Maps.newHashMap();
    
    private IpcSession currentSession;

    @Override
    protected Map<Object, Object> context() {
        return context;
    }

    @Override
    public void attachTo(IpcSession session) {
        this.currentSession = Preconditions.checkNotNull(session, "Session");
    }

    @Override
    public IpcSession getSession() {
        Preconditions.checkState(currentSession != null, "Not yet attached to a session");
        return currentSession;
    }

}
