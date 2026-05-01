package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Singleton;

@Module
/* loaded from: classes2.dex */
public class ForegroundFlowableModule {
    @Provides
    @Singleton
    @AppForeground
    public ConnectableFlowable<String> providesAppForegroundEventStream(Application application) {
        ForegroundNotifier foregroundNotifier = new ForegroundNotifier();
        ConnectableFlowable<String> foregroundFlowable = foregroundNotifier.foregroundFlowable();
        foregroundFlowable.connect();
        application.registerActivityLifecycleCallbacks(foregroundNotifier);
        return foregroundFlowable;
    }
}
