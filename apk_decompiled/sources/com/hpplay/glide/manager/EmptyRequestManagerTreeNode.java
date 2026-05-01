package com.hpplay.glide.manager;

import com.hpplay.glide.RequestManager;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
final class EmptyRequestManagerTreeNode implements RequestManagerTreeNode {
    @Override // com.hpplay.glide.manager.RequestManagerTreeNode
    public Set<RequestManager> getDescendants() {
        return Collections.emptySet();
    }
}
