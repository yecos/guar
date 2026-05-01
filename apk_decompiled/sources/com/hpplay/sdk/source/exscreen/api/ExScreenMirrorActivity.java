package com.hpplay.sdk.source.exscreen.api;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import com.hpplay.sdk.source.api.IExternalScreenListener;
import com.hpplay.sdk.source.api.LelinkExternalScreen;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.log.SourceLog;

@Deprecated
/* loaded from: classes3.dex */
public abstract class ExScreenMirrorActivity extends Activity implements IExternalScreenListener {
    private static final String TAG = "ExScreenMirrorActivity";

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.hpplay.sdk.source.api.IExternalScreenListener
    public LelinkExternalScreen onCreateScreen(int i10, Display display) {
        return onStartBuildExternalScreen(i10, display);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        SourceLog.i(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onResume() {
        SourceLog.i(TAG, "onResume");
        super.onResume();
    }

    public abstract LelinkExternalScreen onStartBuildExternalScreen(int i10, Display display);

    @Override // android.app.Activity
    public void onStop() {
        SourceLog.i(TAG, "onStop");
        super.onStop();
    }

    public void startExternalMirror(LelinkServiceInfo lelinkServiceInfo, boolean z10, boolean z11, int i10, int i11) {
    }
}
