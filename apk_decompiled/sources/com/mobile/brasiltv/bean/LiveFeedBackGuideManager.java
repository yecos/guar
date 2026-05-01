package com.mobile.brasiltv.bean;

import android.content.Context;
import android.view.View;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.view.dialog.GuideDialog;
import t9.i;

/* loaded from: classes3.dex */
public final class LiveFeedBackGuideManager extends BaseGuideManager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveFeedBackGuideManager(Context context, View view, String str, String str2, GuideDialog.Direction direction) {
        super(context, view, str, str2, direction, null, true, true, null);
        i.g(str2, "content");
        i.g(direction, "diretion");
    }

    @Override // com.mobile.brasiltv.bean.BaseGuideManager
    public void alreadyShow() {
        if (getKey() == null) {
            return;
        }
        App.f8263e.a().getSharedPreferences("show_gesture", 0).edit().putBoolean(getKey(), true).apply();
    }

    @Override // com.mobile.brasiltv.bean.BaseGuideManager
    public boolean isShow() {
        if (getKey() == null) {
            return true;
        }
        return !App.f8263e.a().getSharedPreferences("show_gesture", 0).getBoolean(getKey(), false);
    }
}
