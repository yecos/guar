package com.hpplay.common.utils;

import com.hpplay.cybergarage.xml.XML;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public class FieldUtil {
    private static final Charset charset = Charset.forName(XML.CHARSET_UTF8);

    /* renamed from: m, reason: collision with root package name */
    public static final byte[] f7332m = {109, 97, 99};
    public static final byte[] M = {77, 97, 99};

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f7331a = {97, 110, 100, 114, 111, 105, 100, 95, 105, 100};
    public static final byte[] aId = {97, 110, 100, 114, 111, 105, 100, 73, 100};

    public static String getString(byte[] bArr) {
        return new String(bArr, charset);
    }
}
