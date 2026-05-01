package com.google.firebase.ktx;

import android.content.Context;
import ca.y;
import ca.y0;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.umeng.analytics.pro.f;
import java.lang.annotation.Annotation;
import java.util.concurrent.Executor;
import t9.i;

/* loaded from: classes2.dex */
public final class FirebaseKt {
    public static final String LIBRARY_NAME = "fire-core-ktx";

    public static final FirebaseApp app(Firebase firebase, String str) {
        i.g(firebase, "<this>");
        i.g(str, "name");
        FirebaseApp firebaseApp = FirebaseApp.getInstance(str);
        i.f(firebaseApp, "getInstance(name)");
        return firebaseApp;
    }

    private static final /* synthetic */ <T extends Annotation> Component<y> coroutineDispatcher() {
        i.l(4, "T");
        Component.Builder builder = Component.builder(Qualified.qualified(Annotation.class, y.class));
        i.l(4, "T");
        Component.Builder add = builder.add(Dependency.required((Qualified<?>) Qualified.qualified(Annotation.class, Executor.class)));
        i.k();
        Component<y> build = add.factory(new ComponentFactory() { // from class: com.google.firebase.ktx.FirebaseKt$coroutineDispatcher$1
            @Override // com.google.firebase.components.ComponentFactory
            public final y create(ComponentContainer componentContainer) {
                i.l(4, "T");
                Object obj = componentContainer.get(Qualified.qualified(Annotation.class, Executor.class));
                i.f(obj, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return y0.a((Executor) obj);
            }
        }).build();
        i.f(build, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return build;
    }

    public static final FirebaseApp getApp(Firebase firebase) {
        i.g(firebase, "<this>");
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        i.f(firebaseApp, "getInstance()");
        return firebaseApp;
    }

    public static final FirebaseOptions getOptions(Firebase firebase) {
        i.g(firebase, "<this>");
        FirebaseOptions options = getApp(Firebase.INSTANCE).getOptions();
        i.f(options, "Firebase.app.options");
        return options;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context) {
        i.g(firebase, "<this>");
        i.g(context, f.X);
        return FirebaseApp.initializeApp(context);
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions firebaseOptions) {
        i.g(firebase, "<this>");
        i.g(context, f.X);
        i.g(firebaseOptions, "options");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, firebaseOptions);
        i.f(initializeApp, "initializeApp(context, options)");
        return initializeApp;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions firebaseOptions, String str) {
        i.g(firebase, "<this>");
        i.g(context, f.X);
        i.g(firebaseOptions, "options");
        i.g(str, "name");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, firebaseOptions, str);
        i.f(initializeApp, "initializeApp(context, options, name)");
        return initializeApp;
    }
}
