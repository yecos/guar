package com.hpplay.sdk.source.localserver;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.hpplay.common.utils.ContextPath;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Random;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class LelinkServerInstance {
    private static final String HTTP_URL_HEADER = "http://";
    private static final String TAG = "LelinkServerInstance";
    private static LelinkServerInstance mLelinkServerInstance;
    private Context mContext;
    private LelinkFileServer mFileServer;
    private String mLocalIp;
    private boolean isInit = false;
    private int mHttpPort = 8091;

    public class PortCheckTask extends AsyncTask<Void, Void, Integer> {
        private PortCheckTask() {
        }

        @Override // android.os.AsyncTask
        public Integer doInBackground(Void... voidArr) {
            if (HapplayUtils.checkLoaclPort(LelinkServerInstance.this.mHttpPort)) {
                LelinkServerInstance.this.mHttpPort += new Random().nextInt(10);
                SourceLog.i(LelinkServerInstance.TAG, "port is use ,new port is :" + LelinkServerInstance.this.mHttpPort);
            } else {
                SourceLog.i(LelinkServerInstance.TAG, "port not use");
            }
            return Integer.valueOf(LelinkServerInstance.this.mHttpPort);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Integer num) {
            LelinkServerInstance.this.mHttpPort = num.intValue();
            if (LelinkServerInstance.this.mFileServer == null) {
                LelinkServerInstance lelinkServerInstance = LelinkServerInstance.this;
                lelinkServerInstance.mLocalIp = lelinkServerInstance.getRealIp();
                LelinkServerInstance.this.mFileServer = new LelinkFileServer(LelinkServerInstance.this.mLocalIp, LelinkServerInstance.this.mHttpPort);
                try {
                    LelinkServerInstance.this.mFileServer.start();
                } catch (IOException e10) {
                    SourceLog.w(LelinkServerInstance.TAG, e10);
                }
                SourceLog.debug(LelinkServerInstance.TAG, "start server " + LelinkServerInstance.this.mLocalIp + "  mHttpPort " + LelinkServerInstance.this.mHttpPort);
            } else if (LelinkServerInstance.this.mFileServer.isAlive()) {
                SourceLog.i(LelinkServerInstance.TAG, "server is start");
            } else {
                try {
                    LelinkServerInstance.this.mFileServer.stop();
                    LelinkServerInstance.this.mFileServer = new LelinkFileServer(HapplayUtils.getLoaclIp(), LelinkServerInstance.this.mHttpPort);
                    LelinkServerInstance.this.mFileServer.start();
                } catch (Exception e11) {
                    SourceLog.w(LelinkServerInstance.TAG, e11);
                }
            }
            super.onPostExecute((PortCheckTask) num);
        }
    }

    public static LelinkServerInstance getInstance() {
        if (mLelinkServerInstance == null) {
            mLelinkServerInstance = new LelinkServerInstance();
        }
        return mLelinkServerInstance;
    }

    private String getRelIp() {
        int hostCount = HapplayUtils.getHostCount();
        String str = null;
        for (int i10 = 0; i10 < hostCount; i10++) {
            String ipStr = HapplayUtils.getIpStr(i10);
            if (!TextUtils.isEmpty(ipStr) && !ipStr.endsWith(".1")) {
                str = ipStr;
            }
        }
        return str;
    }

    public String getFileDownloadUrl(String str, String str2) {
        String realIp = getRealIp();
        SourceLog.debug(TAG, " local ip " + this.mLocalIp + "  current ip " + realIp);
        LelinkFileServer lelinkFileServer = this.mFileServer;
        if (lelinkFileServer != null && !lelinkFileServer.wasStarted()) {
            SourceLog.i(TAG, " server dei restart server  ");
            startServer();
        } else if (!TextUtils.isEmpty(this.mLocalIp) && !this.mLocalIp.equals(realIp)) {
            SourceLog.i(TAG, "wifi change restart server  ");
            restartServer();
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str = URLEncoder.encode(str, XML.CHARSET_UTF8);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        if (TextUtils.isEmpty(str2)) {
            return HTTP_URL_HEADER + realIp + SOAP.DELIM + this.mHttpPort + File.separator + str;
        }
        return HTTP_URL_HEADER + realIp + SOAP.DELIM + this.mHttpPort + File.separator + str + Operator.Operation.EMPTY_PARAM + str2;
    }

    public String getHeicDirPath() {
        String path = Session.getInstance().getContextPath().getPath(ContextPath.SDCARD_IMG);
        if (TextUtils.isEmpty(path)) {
            SourceLog.w(TAG, "value is invalid");
            return null;
        }
        File file = new File(path);
        if (file.exists()) {
            String str = file.getAbsolutePath() + File.separator + "heic";
            if (new File(str).exists()) {
                return str;
            }
        }
        return null;
    }

    public String getHeicToJpegPath(String str) {
        SourceLog.i(TAG, "getHeciToJpegPath");
        try {
            String path = Session.getInstance().getContextPath().getPath(ContextPath.SDCARD_IMG);
            if (TextUtils.isEmpty(path)) {
                SourceLog.w(TAG, "value is invalid");
                return null;
            }
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(file.getAbsolutePath());
            String str2 = File.separator;
            sb.append(str2);
            sb.append("heic");
            String sb2 = sb.toString();
            File file2 = new File(sb2);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            String str3 = sb2 + str2 + System.currentTimeMillis() + ".jpeg";
            File file3 = new File(str3);
            if (file3.exists()) {
                file3.delete();
            }
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
            if (decodeFile.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream)) {
                bufferedOutputStream.flush();
            }
            bufferedOutputStream.close();
            return str3;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    public String getRealIp() {
        String str = "";
        try {
            if (HapplayUtils.isNetworkConnected(this.mContext)) {
                str = HapplayUtils.getWifiIp();
                if (TextUtils.isEmpty(str) || str.endsWith(".1")) {
                    str = getRelIp();
                    if (TextUtils.isEmpty(str)) {
                        str = HapplayUtils.getLoaclIp();
                    }
                }
                SourceLog.debug(TAG, "wifi ip  " + str + "    LoaclIp  " + HapplayUtils.getLoaclIp());
            } else {
                str = getRelIp();
                if (TextUtils.isEmpty(str)) {
                    str = HapplayUtils.getLoaclIp();
                }
                SourceLog.debug(TAG, "use moble host ip  " + this.mLocalIp + "    LoaclIp  " + HapplayUtils.getLoaclIp());
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return str;
    }

    public void init(Context context) {
        this.mContext = context;
        this.isInit = true;
    }

    public boolean isAlive() {
        LelinkFileServer lelinkFileServer = this.mFileServer;
        if (lelinkFileServer != null) {
            return lelinkFileServer.isAlive();
        }
        return false;
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void restartServer() {
        if (this.mFileServer != null) {
            stopServer();
        }
        startServer();
    }

    public void startServer() {
        LelinkFileServer lelinkFileServer = this.mFileServer;
        if (lelinkFileServer == null || !lelinkFileServer.isAlive()) {
            new PortCheckTask().executeOnExecutor(Executors.newCachedThreadPool(), new Void[0]);
        } else {
            SourceLog.i(TAG, "  already start");
        }
    }

    public void stopServer() {
        LelinkFileServer lelinkFileServer = this.mFileServer;
        if (lelinkFileServer != null) {
            lelinkFileServer.stop();
            this.mFileServer = null;
        }
        SourceLog.i(TAG, "stop server");
    }
}
