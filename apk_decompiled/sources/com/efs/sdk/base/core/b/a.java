package com.efs.sdk.base.core.b;

import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;

/* loaded from: classes.dex */
public final class a implements d {
    @Override // com.efs.sdk.base.core.b.d
    public final HttpResponse a(LogDto logDto, boolean z10) {
        com.efs.sdk.base.core.a.c a10 = com.efs.sdk.base.core.a.c.a();
        a10.f6053d = logDto.getCp();
        a10.f6054e = logDto.getDe();
        a10.f6056g = logDto.getLogProtocol();
        a10.f6057h = logDto.getLogType();
        a10.f6064o = logDto.getBodySize();
        String a11 = com.efs.sdk.base.core.config.remote.b.a().a(false);
        Log.i("efs.LogSendAction", "send data url is ".concat(String.valueOf(a11)));
        HttpResponse a12 = logDto.getLogBodyType() == 0 ? com.efs.sdk.base.core.a.a.a().a(a11, a10, logDto.getData(), logDto.isLimitByFlow()) : 1 == logDto.getLogBodyType() ? com.efs.sdk.base.core.a.a.a().a(a11, a10, logDto.getFile(), logDto.isLimitByFlow()) : new HttpResponse();
        if (a12.succ && z10) {
            FileUtil.delete(logDto.getFile());
        }
        return a12;
    }
}
