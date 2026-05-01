package com.efs.sdk.net.a.a;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.net.a.a.f;
import com.hpplay.component.common.ParamsMap;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    Map<String, Long> f6374a = new HashMap();

    public static long a(f.b bVar) {
        try {
            if (bVar.d() != null) {
                return r2.length;
            }
            return 0L;
        } catch (IOException | OutOfMemoryError e10) {
            e10.printStackTrace();
            return 0L;
        }
    }

    public static InputStream a(String str, String str2, String str3, InputStream inputStream) {
        Log.i("NetTrace-Interceptor", "save interpret response stream");
        com.efs.sdk.net.a.c a10 = com.efs.sdk.net.a.a.a().a(str);
        a10.f6402i = str2;
        if (str2 != null) {
            if (str2.contains(ParamsMap.MirrorParams.MIRROR_DOC_MODE) || str2.contains("json")) {
                ByteArrayOutputStream a11 = a(inputStream, a10, str3);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a11.toByteArray());
                try {
                    a11.close();
                } catch (IOException e10) {
                    Log.e("NetTrace-Interceptor", "save interpret response stream, e is ".concat(String.valueOf(e10)));
                }
                return byteArrayInputStream;
            }
        }
        a10.f6403j = 0L;
        return inputStream;
    }

    private static ByteArrayOutputStream a(InputStream inputStream, com.efs.sdk.net.a.c cVar, String str) {
        BufferedReader bufferedReader;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e10) {
                Log.e("NetTrace-Interceptor", "parse and save body, e is ".concat(String.valueOf(e10)));
            }
        }
        byteArrayOutputStream.flush();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        if ("gzip".equals(str)) {
            bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(byteArrayInputStream)));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream));
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            sb.append(readLine + '\n');
        }
        cVar.f6403j = sb.toString().getBytes().length;
        return byteArrayOutputStream;
    }
}
