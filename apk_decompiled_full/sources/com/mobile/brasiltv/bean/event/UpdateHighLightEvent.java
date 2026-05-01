package com.mobile.brasiltv.bean.event;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.taobao.accs.common.Constants;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class UpdateHighLightEvent {
    private String code;

    /* JADX WARN: Multi-variable type inference failed */
    public UpdateHighLightEvent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ UpdateHighLightEvent copy$default(UpdateHighLightEvent updateHighLightEvent, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = updateHighLightEvent.code;
        }
        return updateHighLightEvent.copy(str);
    }

    public final String component1() {
        return this.code;
    }

    public final UpdateHighLightEvent copy(String str) {
        i.g(str, Constants.KEY_HTTP_CODE);
        return new UpdateHighLightEvent(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UpdateHighLightEvent) && i.b(this.code, ((UpdateHighLightEvent) obj).code);
    }

    public final String getCode() {
        return this.code;
    }

    public int hashCode() {
        return this.code.hashCode();
    }

    public final void setCode(String str) {
        i.g(str, "<set-?>");
        this.code = str;
    }

    public String toString() {
        return "UpdateHighLightEvent(code=" + this.code + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public UpdateHighLightEvent(String str) {
        i.g(str, Constants.KEY_HTTP_CODE);
        this.code = str;
    }

    public /* synthetic */ UpdateHighLightEvent(String str, int i10, g gVar) {
        this((i10 & 1) != 0 ? "" : str);
    }
}
