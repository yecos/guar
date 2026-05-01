package com.google.firebase.inappmessaging.internal.injection.modules;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.google.common.io.BaseEncoding;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import io.grpc.stub.h;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import y8.d;
import y8.j;
import y8.v0;

@Module
/* loaded from: classes2.dex */
public class GrpcClientModule {
    private final FirebaseApp firebaseApp;

    public GrpcClientModule(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }

    public static String getSignature(PackageManager packageManager, String str) {
        Signature[] signatureArr;
        Signature signature;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length != 0 && (signature = signatureArr[0]) != null) {
                return signatureDigest(signature);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static String signatureDigest(Signature signature) {
        try {
            return BaseEncoding.base16().upperCase().encode(MessageDigest.getInstance("SHA1").digest(signature.toByteArray()));
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @Provides
    public v0 providesApiKeyHeaders() {
        v0.d dVar = v0.f20029e;
        v0.g e10 = v0.g.e("X-Goog-Api-Key", dVar);
        v0.g e11 = v0.g.e("X-Android-Package", dVar);
        v0.g e12 = v0.g.e("X-Android-Cert", dVar);
        v0 v0Var = new v0();
        String packageName = this.firebaseApp.getApplicationContext().getPackageName();
        v0Var.o(e10, this.firebaseApp.getOptions().getApiKey());
        v0Var.o(e11, packageName);
        String signature = getSignature(this.firebaseApp.getApplicationContext().getPackageManager(), packageName);
        if (signature != null) {
            v0Var.o(e12, signature);
        }
        return v0Var;
    }

    @Provides
    @FirebaseAppScope
    public InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub providesInAppMessagingSdkServingStub(d dVar, v0 v0Var) {
        return InAppMessagingSdkServingGrpc.newBlockingStub(j.b(dVar, h.a(v0Var)));
    }
}
