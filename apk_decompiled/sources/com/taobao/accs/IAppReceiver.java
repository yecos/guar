package com.taobao.accs;

import androidx.annotation.Keep;
import java.util.Map;

@Keep
/* loaded from: classes3.dex */
public interface IAppReceiver {
    @Keep
    Map<String, String> getAllServices();

    @Keep
    String getService(String str);

    @Keep
    void onBindApp(int i10);

    @Keep
    void onBindUser(String str, int i10);

    @Keep
    void onData(String str, String str2, byte[] bArr);

    @Keep
    void onSendData(String str, int i10);

    @Keep
    void onUnbindApp(int i10);

    @Keep
    void onUnbindUser(int i10);
}
