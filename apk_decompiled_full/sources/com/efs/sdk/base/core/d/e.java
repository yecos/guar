package com.efs.sdk.base.core.d;

import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import com.efs.sdk.base.http.HttpResponse;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class e implements com.efs.sdk.base.core.b.d {
    private static void a(HttpResponse httpResponse) {
        if (httpResponse == null || TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        for (String str : httpResponse.data.split("`")) {
            String[] split = str.split(Operator.Operation.EQUALS);
            if (split.length >= 2) {
                if (split[0].equalsIgnoreCase("retcode")) {
                    httpResponse.setBizCode(split[1]);
                } else {
                    ((Map) httpResponse.extra).put(split[0], split[1]);
                }
            }
        }
    }

    @Override // com.efs.sdk.base.core.b.d
    public final HttpResponse a(LogDto logDto, boolean z10) {
        HttpResponse httpResponse;
        f fVar;
        try {
            fVar = f.a.f6196a;
            c cVar = fVar.f6192a;
            String valueOf = String.valueOf(System.currentTimeMillis());
            String md5 = EncodeUtil.md5(cVar.f6185b + cVar.f6186c + valueOf + "AppChk#2014");
            StringBuilder sb = new StringBuilder();
            String str = cVar.f6184a;
            if (str.startsWith(HttpConstant.HTTP)) {
                sb.append(str);
                sb.append("?chk=");
            } else {
                sb.append(str);
                sb.append("?chk=");
            }
            sb.append(md5.substring(md5.length() - 8));
            sb.append("&vno=");
            sb.append(valueOf);
            sb.append("&uuid=");
            sb.append(cVar.f6186c);
            sb.append("&app=");
            sb.append(cVar.f6185b);
            sb.append("&zip=gzip");
            String sb2 = sb.toString();
            int i10 = 0;
            byte[] bArr = new byte[0];
            if (logDto.getLogBodyType() == 0) {
                bArr = logDto.getData();
                i10 = bArr.length;
            } else if (1 == logDto.getLogBodyType()) {
                bArr = FileUtil.read(logDto.getFile().getPath());
                i10 = bArr.length;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Content-Length", String.valueOf(i10));
            com.efs.sdk.base.core.util.a.d a10 = new com.efs.sdk.base.core.util.a.d(sb2).a(hashMap);
            a10.f6235a.f6229c = bArr;
            httpResponse = a10.a().b();
            a(httpResponse);
        } catch (Throwable th) {
            httpResponse = 0 == 0 ? new HttpResponse() : null;
            Log.e("efs.wa.send", "get file size error", th);
        }
        if (httpResponse.succ) {
            Log.i("efs.base", "wa upload succ, " + httpResponse.toString());
            FileUtil.delete(logDto.getFile());
            return httpResponse;
        }
        Log.i("efs.base", "wa upload fail, resp is " + httpResponse.toString());
        return httpResponse;
    }
}
