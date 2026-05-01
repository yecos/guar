package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.msandroid.mobile.R;
import f5.c;

/* loaded from: classes3.dex */
public class TransitionLanguageAty extends c {

    /* renamed from: k, reason: collision with root package name */
    public Handler f8234k = new a();

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            TransitionLanguageAty.this.startActivity(new Intent(TransitionLanguageAty.this, (Class<?>) MainAty.class));
            TransitionLanguageAty.this.finish();
        }
    }

    @Override // f5.c, i5.a, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_transition_language);
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f8234k.sendEmptyMessageDelayed(0, 1000L);
    }
}
