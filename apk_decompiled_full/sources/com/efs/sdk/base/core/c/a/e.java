package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.http.HttpResponse;

/* loaded from: classes.dex */
public final class e extends a {
    @Override // com.efs.sdk.base.core.c.a.a
    public final void a(LogDto logDto) {
        com.efs.sdk.base.core.d.f fVar;
        com.efs.sdk.base.core.d.f fVar2;
        HttpResponse a10;
        if (!logDto.isSendImediately()) {
            b(logDto);
            return;
        }
        com.efs.sdk.base.core.b.e a11 = com.efs.sdk.base.core.b.e.a();
        if (!logDto.isLimitByFlow() || com.efs.sdk.base.core.b.c.a().a(logDto.getLogType(), logDto.getBodySize())) {
            fVar = f.a.f6196a;
            fVar.f6194c.b();
            fVar2 = f.a.f6196a;
            fVar2.f6194c.c();
            a10 = a11.f6076c.a(logDto, false);
        } else {
            a10 = new HttpResponse();
            a10.data = "flow_limit";
        }
        logDto.setResponseDto(a10);
        b(logDto);
    }
}
