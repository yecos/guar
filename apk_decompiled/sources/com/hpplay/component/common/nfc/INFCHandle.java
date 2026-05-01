package com.hpplay.component.common.nfc;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.Tag;

/* loaded from: classes2.dex */
public interface INFCHandle {
    byte[] ReadCard(Intent intent);

    boolean deletePassword(Tag tag, String str);

    void disableForegroundDispatch(Activity activity);

    void enableForegroundDispatch(Activity activity, PendingIntent pendingIntent, IntentFilter[] intentFilterArr, String[][] strArr);

    boolean erase(Tag tag, String str);

    boolean setPassword(Tag tag, String str);

    boolean writeCard(Tag tag, String str, String str2, String str3);
}
