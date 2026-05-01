package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.core.config.remote.RemoteConfig;
import com.efs.sdk.base.core.model.LogDto;

/* loaded from: classes.dex */
public final class f extends a {
    @Override // com.efs.sdk.base.core.c.a.a
    public final void a(LogDto logDto) {
        Double d10;
        com.efs.sdk.base.core.config.remote.b a10 = com.efs.sdk.base.core.config.remote.b.a();
        String logType = logDto.getLogType();
        RemoteConfig remoteConfig = a10.f6151d;
        if (com.efs.sdk.base.core.config.remote.b.f6148a.nextDouble() * 100.0d <= ((!remoteConfig.mUploadSampleRateMap.containsKey(logType) || (d10 = remoteConfig.mUploadSampleRateMap.get(logType)) == null) ? 100.0d : d10.doubleValue())) {
            b(logDto);
        }
    }
}
