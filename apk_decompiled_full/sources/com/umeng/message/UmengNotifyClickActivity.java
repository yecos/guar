package com.umeng.message;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;

/* loaded from: classes3.dex */
public abstract class UmengNotifyClickActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private final UmengNotifyClick f11350a = new UmengNotifyClick() { // from class: com.umeng.message.UmengNotifyClickActivity.1
        @Override // com.umeng.message.UmengNotifyClick
        public final void onChangeBadgeNumber(UMessage uMessage) {
            if (UmengNotifyClickActivity.this.canChangeBadgeNum(uMessage)) {
                super.onChangeBadgeNumber(uMessage);
            }
        }

        @Override // com.umeng.message.UmengNotifyClick
        public final void onMessage(final UMessage uMessage) {
            if (UmengNotifyClickActivity.this.isFinishing()) {
                return;
            }
            UmengNotifyClickActivity.this.runOnUiThread(new Runnable() { // from class: com.umeng.message.UmengNotifyClickActivity.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        UmengNotifyClickActivity.this.onMessage(uMessage);
                    } catch (Throwable th) {
                        UPLog.e("UmengNotifyClickActivity", th);
                    }
                }
            });
        }

        @Override // com.umeng.message.UmengNotifyClick
        public final void onMessageReceived(Intent intent) {
            UmengNotifyClickActivity.this.onMessage(intent);
        }
    };

    public boolean canChangeBadgeNum(UMessage uMessage) {
        return true;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11350a.onCreate(this, getIntent());
    }

    @Deprecated
    public void onMessage(Intent intent) {
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f11350a.onNewIntent(intent);
    }

    public void onMessage(UMessage uMessage) {
    }
}
