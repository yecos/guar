package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.taobao.accs.common.Constants;
import javax.inject.Named;
import javax.inject.Singleton;
import y8.d;
import y8.s0;

@Module
/* loaded from: classes2.dex */
public class GrpcChannelModule {
    @Provides
    @Singleton
    public d providesGrpcChannel(@Named("host") String str) {
        return s0.b(str).a();
    }

    @Provides
    @Singleton
    @Named(Constants.KEY_HOST)
    public String providesServiceHost() {
        return "firebaseinappmessaging.googleapis.com";
    }
}
