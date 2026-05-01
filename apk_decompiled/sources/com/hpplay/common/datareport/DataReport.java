package com.hpplay.common.datareport;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.log.LeLog;
import com.hpplay.common.perfume.CTCipher;
import com.hpplay.cybergarage.xml.XML;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class DataReport {
    private static final String TAG = "DataReport";
    private static DataReport instance;
    private CTCipher mCTCipher;
    private final int MAX_SEMAPHORE = 5;
    private AtomicInteger mSemaphore = new AtomicInteger(5);
    private ArrayList<ReportRunnable> mTaskList = new ArrayList<>();
    private final int MAX_TASK_SIZE = 50;

    public static abstract class ReportRunnable implements Runnable {
        public ReportBean reportBean;
    }

    private DataReport() {
    }

    private void addTask(ReportBean reportBean, final boolean z10) {
        while (this.mTaskList.size() > 50) {
            this.mTaskList.remove(0);
        }
        ReportRunnable reportRunnable = new ReportRunnable() { // from class: com.hpplay.common.datareport.DataReport.1
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(this.reportBean.httpParameter.in.params) && !TextUtils.isEmpty(this.reportBean.encryptVersion) && DataReport.this.mCTCipher != null) {
                    String str = this.reportBean.httpParameter.in.params;
                    try {
                        str = DataReport.this.mCTCipher.encrypt(str);
                    } catch (Exception e10) {
                        LeLog.w(DataReport.TAG, e10);
                    }
                    AsyncHttpParameter.In in = this.reportBean.httpParameter.in;
                    if (in.requestMethod == 0) {
                        try {
                            str = URLEncoder.encode(str, XML.CHARSET_UTF8);
                        } catch (Exception e11) {
                            LeLog.w(DataReport.TAG, e11);
                        }
                        this.reportBean.httpParameter.in.params = "v=" + this.reportBean.encryptVersion + "&s=" + str;
                    } else {
                        String str2 = in.requestUrl;
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.endsWith(Operator.Operation.EMPTY_PARAM)) {
                                StringBuilder sb = new StringBuilder();
                                AsyncHttpParameter.In in2 = this.reportBean.httpParameter.in;
                                sb.append(in2.requestUrl);
                                sb.append("v=");
                                sb.append(this.reportBean.encryptVersion);
                                in2.requestUrl = sb.toString();
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                AsyncHttpParameter.In in3 = this.reportBean.httpParameter.in;
                                sb2.append(in3.requestUrl);
                                sb2.append("?v=");
                                sb2.append(this.reportBean.encryptVersion);
                                in3.requestUrl = sb2.toString();
                            }
                        }
                        if (z10) {
                            try {
                                str = URLEncoder.encode(str, XML.CHARSET_UTF8);
                            } catch (Exception e12) {
                                LeLog.w(DataReport.TAG, e12);
                            }
                        }
                        this.reportBean.httpParameter.in.params = str;
                    }
                }
                AsyncManager asyncManager = AsyncManager.getInstance();
                ReportBean reportBean2 = this.reportBean;
                asyncManager.exeHttpTask(reportBean2.httpParameter, reportBean2.listener);
                DataReport.this.mSemaphore.set(Math.min(5, DataReport.this.mSemaphore.incrementAndGet()));
                DataReport.this.exeTask();
            }
        };
        reportRunnable.reportBean = reportBean;
        try {
            this.mTaskList.add(reportRunnable);
        } catch (Exception e10) {
            LeLog.w(TAG, "addTask " + e10);
        }
        exeTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exeTask() {
        if (this.mTaskList.size() <= 0 || this.mSemaphore.get() <= 0) {
            if (this.mTaskList.size() == 0) {
                this.mSemaphore.set(5);
                return;
            }
            return;
        }
        this.mSemaphore.getAndDecrement();
        try {
            AsyncManager.getInstance().exeRunnable(this.mTaskList.remove(0), null);
        } catch (Exception e10) {
            LeLog.w(TAG, e10);
            exeTask();
        }
    }

    public static void initDataReport(Context context, String str) {
        initLocalInstance(context.getApplicationContext(), str);
    }

    private static synchronized void initLocalInstance(Context context, String str) {
        synchronized (DataReport.class) {
            synchronized (DataReport.class) {
                if (instance == null) {
                    instance = new DataReport();
                }
                instance.setEncrypt(str);
            }
        }
    }

    public static void onDataReport(ReportBean reportBean) {
        onDataReport(reportBean, false);
    }

    private void setEncrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mCTCipher = new CTCipher(str);
    }

    public static void onDataReport(ReportBean reportBean, boolean z10) {
        DataReport dataReport = instance;
        if (dataReport == null) {
            LeLog.w(TAG, "onDataReport ignore,must call initDataReport first");
        } else {
            dataReport.addTask(reportBean, z10);
        }
    }
}
