package com.fasterxml.jackson.databind.deser.std;

import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes.dex */
public class z extends e0 {
    public z() {
        super(StackTraceElement.class);
    }

    public StackTraceElement a(k3.g gVar, String str, String str2, String str3, int i10, String str4, String str5, String str6) {
        return new StackTraceElement(str, str2, str3, i10);
    }

    @Override // k3.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public StackTraceElement deserialize(c3.k kVar, k3.g gVar) {
        c3.n n10 = kVar.n();
        if (n10 != c3.n.START_OBJECT) {
            if (n10 != c3.n.START_ARRAY || !gVar.n0(k3.h.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                return (StackTraceElement) gVar.a0(this._valueClass, kVar);
            }
            kVar.s0();
            StackTraceElement deserialize = deserialize(kVar, gVar);
            if (kVar.s0() != c3.n.END_ARRAY) {
                handleMissingEndArrayForSingle(kVar, gVar);
            }
            return deserialize;
        }
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = "";
        String str5 = str4;
        String str6 = str5;
        int i10 = -1;
        while (true) {
            c3.n t02 = kVar.t0();
            if (t02 == c3.n.END_OBJECT) {
                return a(gVar, str4, str5, str6, i10, str, str2, str3);
            }
            String m10 = kVar.m();
            if ("className".equals(m10)) {
                str4 = kVar.Y();
            } else if ("classLoaderName".equals(m10)) {
                str3 = kVar.Y();
            } else if ("fileName".equals(m10)) {
                str6 = kVar.Y();
            } else if ("lineNumber".equals(m10)) {
                i10 = t02.d() ? kVar.P() : _parseIntPrimitive(kVar, gVar);
            } else if ("methodName".equals(m10)) {
                str5 = kVar.Y();
            } else if (!"nativeMethod".equals(m10)) {
                if ("moduleName".equals(m10)) {
                    str = kVar.Y();
                } else if ("moduleVersion".equals(m10)) {
                    str2 = kVar.Y();
                } else if (!"declaringClass".equals(m10) && !IjkMediaMeta.IJKM_KEY_FORMAT.equals(m10)) {
                    handleUnknownProperty(kVar, gVar, this._valueClass, m10);
                }
            }
            kVar.D0();
        }
    }
}
