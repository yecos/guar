package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.Log;

/* loaded from: classes.dex */
public final class c extends a {
    private static boolean c(LogDto logDto) {
        return logDto.isCp() || (1 == logDto.getLogProtocol() && !logDto.isSendImediately()) || 1 == logDto.getLogBodyType();
    }

    @Override // com.efs.sdk.base.core.c.a.a
    public final void a(LogDto logDto) {
        if (c(logDto)) {
            b(logDto);
            return;
        }
        byte[] a10 = com.efs.sdk.base.core.util.b.a(logDto.getData());
        if (a10 == null) {
            Log.w("efs.base", "gzip error");
            b(logDto);
        } else {
            logDto.setData(a10);
            logDto.setCp("gzip");
            b(logDto);
        }
    }
}
