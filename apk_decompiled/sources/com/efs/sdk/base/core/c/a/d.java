package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.processor.action.ILogEncryptAction;

/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: b, reason: collision with root package name */
    private ILogEncryptAction f6099b;

    public d() {
        if (ControllerCenter.getGlobalEnvStruct().getLogEncryptAction() == null) {
            this.f6099b = new com.efs.sdk.base.core.c.b();
        } else {
            this.f6099b = ControllerCenter.getGlobalEnvStruct().getLogEncryptAction();
        }
    }

    @Override // com.efs.sdk.base.core.c.a.a
    public final void a(LogDto logDto) {
        boolean z10 = true;
        if (!logDto.isDe() && !"wa".equals(logDto.getLogType()) && Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType()) && 1 != logDto.getLogBodyType()) {
            z10 = false;
        }
        if (z10) {
            b(logDto);
            return;
        }
        byte[] encrypt = this.f6099b.encrypt(ControllerCenter.getGlobalEnvStruct().getSecret(), logDto.getData());
        if (encrypt != null) {
            logDto.setData(encrypt);
            logDto.setDe(this.f6099b.getDeVal());
        }
        b(logDto);
    }
}
