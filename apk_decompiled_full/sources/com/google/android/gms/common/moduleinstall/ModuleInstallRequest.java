package com.google.android.gms.common.moduleinstall;

import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ModuleInstallRequest {
    private final List zaa;
    private final InstallStatusListener zab;
    private final Executor zac;
    private final boolean zad;

    public static class Builder {
        private final List zaa = new ArrayList();
        private boolean zab = true;
        private InstallStatusListener zac;
        private Executor zad;

        @CanIgnoreReturnValue
        public Builder addApi(OptionalModuleApi optionalModuleApi) {
            this.zaa.add(optionalModuleApi);
            return this;
        }

        public ModuleInstallRequest build() {
            return new ModuleInstallRequest(this.zaa, this.zac, this.zad, this.zab, null);
        }

        @CanIgnoreReturnValue
        public Builder setListener(InstallStatusListener installStatusListener, Executor executor) {
            this.zac = installStatusListener;
            this.zad = executor;
            return this;
        }

        public Builder setListener(InstallStatusListener installStatusListener) {
            return setListener(installStatusListener, null);
        }
    }

    public /* synthetic */ ModuleInstallRequest(List list, InstallStatusListener installStatusListener, Executor executor, boolean z10, zac zacVar) {
        Preconditions.checkNotNull(list, "APIs must not be null.");
        Preconditions.checkArgument(!list.isEmpty(), "APIs must not be empty.");
        if (executor != null) {
            Preconditions.checkNotNull(installStatusListener, "Listener must not be null when listener executor is set.");
        }
        this.zaa = list;
        this.zab = installStatusListener;
        this.zac = executor;
        this.zad = z10;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public List<OptionalModuleApi> getApis() {
        return this.zaa;
    }

    public InstallStatusListener getListener() {
        return this.zab;
    }

    public Executor getListenerExecutor() {
        return this.zac;
    }

    @ShowFirstParty
    public final boolean zaa() {
        return this.zad;
    }
}
