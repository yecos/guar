package com.hpplay.component.browse;

/* loaded from: classes2.dex */
public class LelinkBrowseThread extends Thread {
    public LelinkBrowseThread(String str) {
        setName(str);
    }

    public LelinkBrowseThread(Runnable runnable, String str) {
        super(runnable);
        setName(str);
    }
}
