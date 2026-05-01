package com.hpplay.sdk.source.process;

import com.hpplay.sdk.source.bean.BrowserConfigBean;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public class BrowserThread extends Thread {
    private static final int BROWSER_START = 0;
    private static final int BROWSER_STOP = 1;
    private static final String TAG = "BrowserThread";
    private BrowserConfigBean configBean;
    private LinkedBlockingQueue<Integer> browserQeue = new LinkedBlockingQueue<>(2);
    private boolean isStart = true;

    public BrowserThread(BrowserConfigBean browserConfigBean) {
        this.configBean = browserConfigBean;
    }

    public void release() {
        this.isStart = false;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        while (this.isStart) {
            try {
                int intValue = this.browserQeue.take().intValue();
                SourceLog.i(TAG, "browser flag => " + intValue + " b size " + this.browserQeue.size());
                if (intValue == 0) {
                    LelinkSdkManager.getInstance().stopBrowse();
                    LelinkSdkManager.getInstance().browse(this.configBean);
                } else {
                    LelinkSdkManager.getInstance().stopBrowse();
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
    }

    public void setConfigBean(BrowserConfigBean browserConfigBean) {
        this.configBean = browserConfigBean;
    }

    public void startBrowse() {
        try {
            this.browserQeue.add(0);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void stopBrowser() {
        try {
            this.browserQeue.add(1);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }
}
