package com.efs.sdk.base.core.model;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.io.File;

/* loaded from: classes.dex */
public class LogDto {

    /* renamed from: a, reason: collision with root package name */
    private a f6202a;

    /* renamed from: b, reason: collision with root package name */
    private b f6203b = new b();

    /* renamed from: c, reason: collision with root package name */
    private byte[] f6204c;

    /* renamed from: d, reason: collision with root package name */
    private File f6205d;

    public LogDto(String str, byte b10) {
        this.f6202a = new a(str, b10);
    }

    private void a() {
        if (getLogBodyType() == 0 && getData() != null) {
            this.f6202a.f6211f = getData().length;
        } else if (getLogBodyType() == 1 && getFile().exists()) {
            this.f6202a.f6211f = getFile().length();
        }
    }

    public static LogDto buildLogDto(ILogProtocol iLogProtocol) {
        LogDto logDto;
        LogDto logDto2 = null;
        try {
            logDto = new LogDto(iLogProtocol.getLogType(), iLogProtocol.getLogProtocol());
        } catch (Exception e10) {
            e = e10;
        }
        try {
            int bodyType = iLogProtocol.getBodyType();
            if (bodyType == 0) {
                logDto.setLogBodyType(0);
                logDto.setData(iLogProtocol.generate());
                if (Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType())) {
                    logDto.setUid(ControllerCenter.getGlobalEnvStruct().getLogUid());
                    logDto.setDid(ControllerCenter.getGlobalEnvStruct().getLogDid());
                    logDto.setBeginTime(iLogProtocol.getLogBeginTime());
                    logDto.setEndTime(iLogProtocol.getLogEndTime());
                }
            } else if (bodyType != 1) {
                Log.w("efs.base", "Can not support body type: " + iLogProtocol.getBodyType());
            } else {
                logDto.setLogBodyType(1);
                logDto.setFile(new File(iLogProtocol.getFilePath()));
            }
            return logDto;
        } catch (Exception e11) {
            e = e11;
            logDto2 = logDto;
            Log.e("efs.base", "log send error", e);
            return logDto2;
        }
    }

    public long getBeginTime() {
        return this.f6202a.f6215j;
    }

    public long getBodySize() {
        a();
        return this.f6202a.f6211f;
    }

    public String getCp() {
        return this.f6202a.f6209d;
    }

    public byte[] getData() {
        return this.f6204c;
    }

    public int getDe() {
        return this.f6202a.f6210e;
    }

    public String getDid() {
        return this.f6202a.f6214i;
    }

    public long getEndTime() {
        return this.f6202a.f6216k;
    }

    public File getFile() {
        return this.f6205d;
    }

    public int getLogBodyType() {
        return this.f6202a.f6208c;
    }

    public int getLogCnt() {
        return this.f6202a.f6212g;
    }

    public byte getLogProtocol() {
        return this.f6202a.f6207b;
    }

    public String getLogType() {
        return this.f6202a.f6206a;
    }

    public HttpResponse getResponseDto() {
        return this.f6203b.f6219c;
    }

    public String getUid() {
        return this.f6202a.f6213h;
    }

    public boolean isCp() {
        return !"none".equals(this.f6202a.f6209d);
    }

    public boolean isDe() {
        return 1 != this.f6202a.f6210e;
    }

    public boolean isLimitByFlow() {
        return this.f6203b.f6218b;
    }

    public boolean isSendImediately() {
        return this.f6203b.f6217a;
    }

    public void setBeginTime(long j10) {
        this.f6202a.f6215j = j10;
    }

    public void setCp(String str) {
        this.f6202a.f6209d = str;
    }

    public void setData(byte[] bArr) {
        this.f6204c = bArr;
        a();
    }

    public void setDe(int i10) {
        this.f6202a.f6210e = i10;
        a();
    }

    public void setDid(String str) {
        this.f6202a.f6214i = str;
    }

    public void setEndTime(long j10) {
        this.f6202a.f6216k = j10;
    }

    public void setFile(File file) {
        this.f6205d = file;
    }

    public void setLimitByFlow(boolean z10) {
        this.f6203b.f6218b = z10;
    }

    public void setLogBodyType(int i10) {
        this.f6202a.f6208c = i10;
    }

    public void setLogCnt(int i10) {
        this.f6202a.f6212g = i10;
    }

    public void setResponseDto(HttpResponse httpResponse) {
        this.f6203b.f6219c = httpResponse;
    }

    public void setSendImediately(boolean z10) {
        this.f6203b.f6217a = z10;
    }

    public void setUid(String str) {
        this.f6202a.f6213h = str;
    }
}
