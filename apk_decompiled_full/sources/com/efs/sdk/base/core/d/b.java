package com.efs.sdk.base.core.d;

import com.efs.sdk.base.core.config.GlobalInfo;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.protocol.record.AbsRecordLog;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public final class b extends AbsRecordLog {

    /* renamed from: a, reason: collision with root package name */
    private String f6178a;

    /* renamed from: b, reason: collision with root package name */
    private String f6179b;

    /* renamed from: c, reason: collision with root package name */
    private String f6180c;

    /* renamed from: d, reason: collision with root package name */
    private String f6181d;

    /* renamed from: e, reason: collision with root package name */
    private long f6182e;

    /* renamed from: f, reason: collision with root package name */
    private long f6183f;

    public b(String str, String str2, String str3) {
        super("wa");
        this.f6182e = 0L;
        this.f6183f = 0L;
        this.f6178a = str;
        this.f6179b = str2;
        this.f6181d = str3;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS", Locale.CHINA);
        com.efs.sdk.base.core.a.a.a();
        this.f6180c = simpleDateFormat.format(new Date(com.efs.sdk.base.core.a.a.b()));
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final byte[] generate() {
        String generateString = generateString();
        if (ControllerCenter.getGlobalEnvStruct().isPrintLogDetail()) {
            Log.i("efs.base", generateString);
        }
        return generateString.getBytes();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String generateString() {
        StringBuilder sb = new StringBuilder();
        sb.append("lt=event`");
        sb.append("ev_ct=");
        sb.append(this.f6178a);
        sb.append("`");
        sb.append("ev_ac=");
        sb.append(this.f6179b);
        sb.append("`");
        sb.append("tm=");
        sb.append(this.f6180c);
        sb.append("`");
        sb.append("dn=");
        sb.append(this.f6181d);
        sb.append("`");
        for (Map.Entry<String, Object> entry : this.dataMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append(Operator.Operation.EQUALS);
            sb.append(entry.getValue());
            sb.append("`");
        }
        return sb.subSequence(0, sb.length() - 1).toString();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String getLinkId() {
        return "";
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String getLinkKey() {
        return "";
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final long getLogBeginTime() {
        return this.f6182e;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final long getLogEndTime() {
        return this.f6183f;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final void insertGlobal(GlobalInfo globalInfo) {
        this.dataMap.putAll(globalInfo.getGlobalInfoMap());
        this.dataMap.putAll(ControllerCenter.getGlobalEnvStruct().getPublicParamMap());
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final void setLogBeginTime(long j10) {
        this.f6182e = j10;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final void setLogEndTime(long j10) {
        this.f6183f = j10;
    }
}
