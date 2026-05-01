package com.mobile.brasiltv.view.login;

/* loaded from: classes3.dex */
public interface ILoginPanel {
    void cancelSmsCountDown();

    void closeLoginPanel();

    void fillAccount(String str);

    String getMobile();

    void hideErrorHint(long j10);

    void showErrorHint(String str);

    void startSmsCountDown();

    void updateAreaInfo(String str, String str2);
}
