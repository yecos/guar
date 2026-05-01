package com.bumptech.glide.manager;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.o;
import androidx.lifecycle.d;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
final class LifecycleRequestManagerRetriever {
    private final RequestManagerRetriever.RequestManagerFactory factory;
    final Map<d, RequestManager> lifecycleToRequestManager = new HashMap();

    public final class SupportRequestManagerTreeNode implements RequestManagerTreeNode {
        private final o childFragmentManager;

        public SupportRequestManagerTreeNode(o oVar) {
            this.childFragmentManager = oVar;
        }

        private void getChildFragmentsRecursive(o oVar, Set<RequestManager> set) {
            List s02 = oVar.s0();
            int size = s02.size();
            for (int i10 = 0; i10 < size; i10++) {
                Fragment fragment = (Fragment) s02.get(i10);
                getChildFragmentsRecursive(fragment.getChildFragmentManager(), set);
                RequestManager only = LifecycleRequestManagerRetriever.this.getOnly(fragment.getLifecycle());
                if (only != null) {
                    set.add(only);
                }
            }
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        public Set<RequestManager> getDescendants() {
            HashSet hashSet = new HashSet();
            getChildFragmentsRecursive(this.childFragmentManager, hashSet);
            return hashSet;
        }
    }

    public LifecycleRequestManagerRetriever(RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.factory = requestManagerFactory;
    }

    public RequestManager getOnly(d dVar) {
        Util.assertMainThread();
        return this.lifecycleToRequestManager.get(dVar);
    }

    public RequestManager getOrCreate(Context context, Glide glide, final d dVar, o oVar, boolean z10) {
        Util.assertMainThread();
        RequestManager only = getOnly(dVar);
        if (only != null) {
            return only;
        }
        LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(dVar);
        RequestManager build = this.factory.build(glide, lifecycleLifecycle, new SupportRequestManagerTreeNode(oVar), context);
        this.lifecycleToRequestManager.put(dVar, build);
        lifecycleLifecycle.addListener(new LifecycleListener() { // from class: com.bumptech.glide.manager.LifecycleRequestManagerRetriever.1
            @Override // com.bumptech.glide.manager.LifecycleListener
            public void onDestroy() {
                LifecycleRequestManagerRetriever.this.lifecycleToRequestManager.remove(dVar);
            }

            @Override // com.bumptech.glide.manager.LifecycleListener
            public void onStart() {
            }

            @Override // com.bumptech.glide.manager.LifecycleListener
            public void onStop() {
            }
        });
        if (z10) {
            build.onStart();
        }
        return build;
    }
}
