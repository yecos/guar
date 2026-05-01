package com.hpplay.sdk.source.localserver;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.hpplay.a.a.a.b.a;
import com.hpplay.a.a.a.c.b;
import com.hpplay.a.a.a.c.c;
import com.hpplay.a.a.a.d;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.logwriter.f;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.LogCache;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.UriUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public class LelinkFileServer extends d {
    private static final String TAG = "LelinkFileServer";

    public LelinkFileServer(String str, int i10) {
        super(str, i10);
    }

    private c defaultRespond(Map<String, String> map, com.hpplay.a.a.a.c cVar, String str) {
        String replace = str.trim().replace(File.separatorChar, '/');
        if (replace.indexOf(63) >= 0) {
            replace = replace.substring(0, replace.indexOf(63));
        }
        String mimeTypeForFile = d.getMimeTypeForFile(replace);
        SourceLog.i(TAG, " uri path  " + replace);
        if (!TextUtils.isEmpty(replace) && replace.startsWith("/content")) {
            String substring = replace.substring(1, replace.length());
            Uri parse = Uri.parse(substring);
            if (Build.VERSION.SDK_INT > 28) {
                try {
                    InputStream openInputStream = HapplayUtils.getApplication().getContentResolver().openInputStream(parse);
                    SourceLog.i(TAG, " uri mode send stream " + substring);
                    if (parse.toString().contains("image")) {
                        mimeTypeForFile = "image/jpeg";
                    } else if (parse.toString().endsWith("mp4")) {
                        mimeTypeForFile = "video/mp4";
                    }
                    c serveFileForStream = serveFileForStream(parse, map, openInputStream, mimeTypeForFile);
                    return serveFileForStream != null ? serveFileForStream : getNotFoundResponse();
                } catch (Exception e10) {
                    SourceLog.w(TAG, e10);
                    return getNotFoundResponse();
                }
            }
            replace = UriUtils.getFilePathByUri(HapplayUtils.getApplication(), parse);
        } else if (!TextUtils.isEmpty(replace) && (replace.contains("slog") || replace.contains("scacheLog"))) {
            SourceLog.flushLogWriter();
            replace = LogCache.getLogOutputFilePath();
            if (TextUtils.isEmpty(replace)) {
                SourceLog.i(TAG, "logRespond,log zipFilePath is null ");
                return c.a(com.hpplay.a.a.a.c.d.NOT_FOUND, d.MIME_PLAINTEXT, "Error 404, log file not found.");
            }
            f.a().c(replace);
        }
        if (!new File(replace).exists()) {
            return getNotFoundResponse();
        }
        c serveFile = serveFile(replace, map, new File(replace), mimeTypeForFile);
        return serveFile != null ? serveFile : getNotFoundResponse();
    }

    private c newFixedFileResponse(File file, String str) {
        c a10 = c.a(com.hpplay.a.a.a.c.d.OK, str, new FileInputStream(file), (int) file.length());
        a10.a(HttpHeaders.ACCEPT_RANGES, HTTP.CONTENT_RANGE_BYTES);
        return a10;
    }

    public static c newFixedLengthResponse(b bVar, String str, String str2) {
        c a10 = c.a(bVar, str, str2);
        a10.a(HttpHeaders.ACCEPT_RANGES, HTTP.CONTENT_RANGE_BYTES);
        return a10;
    }

    private c respond(Map<String, String> map, com.hpplay.a.a.a.c cVar, String str) {
        return a.OPTIONS.equals(cVar.e()) ? c.a(com.hpplay.a.a.a.c.d.OK, d.MIME_PLAINTEXT, null, 0L) : defaultRespond(map, cVar, str);
    }

    private c serveFileForStream(Uri uri, Map<String, String> map, InputStream inputStream, String str) {
        String str2;
        String str3;
        long j10;
        long j11;
        boolean z10;
        String str4;
        long available;
        c a10;
        try {
            str3 = map.get("range");
            j10 = -1;
            if (str3 == null || !str3.startsWith("bytes=")) {
                j11 = 0;
            } else {
                String substring = str3.substring(6);
                int indexOf = substring.indexOf(45);
                if (indexOf > 0) {
                    try {
                        j11 = Long.parseLong(substring.substring(0, indexOf));
                    } catch (Exception e10) {
                        e = e10;
                        j11 = 0;
                    }
                    try {
                        j10 = Long.parseLong(substring.substring(indexOf + 1));
                    } catch (Exception e11) {
                        e = e11;
                        SourceLog.w(TAG, e);
                        str3 = substring;
                        String str5 = map.get("if-range");
                        if (str5 != null) {
                        }
                        str4 = map.get("if-none-match");
                        if (str4 != null) {
                            str4.equals("");
                        }
                        available = inputStream.available();
                        if (!z10) {
                        }
                        if (z10) {
                        }
                        a10 = c.a(com.hpplay.a.a.a.c.d.OK, str, inputStream, inputStream.available());
                        a10.a(HttpHeaders.ACCEPT_RANGES, HTTP.CONTENT_RANGE_BYTES);
                        a10.a("Content-Length", "" + available);
                        a10.a("ETag", "");
                        return a10;
                    }
                } else {
                    j11 = 0;
                }
                str3 = substring;
            }
            String str52 = map.get("if-range");
            z10 = str52 != null || "".equals(str52);
            str4 = map.get("if-none-match");
            if (str4 != null && !Operator.Operation.MULTIPLY.equals(str4)) {
                str4.equals("");
            }
            available = inputStream.available();
        } catch (Exception e12) {
            e = e12;
            str2 = TAG;
        }
        try {
            if (!z10 && str3 != null && j11 >= 0 && j11 < available) {
                if (j10 < 0) {
                    j10 = available - 1;
                }
                long j12 = (j10 - j11) + 1;
                long j13 = j12 < 0 ? 0L : j12;
                inputStream.skip(j11);
                a10 = c.a(com.hpplay.a.a.a.c.d.PARTIAL_CONTENT, str, inputStream, j13);
                a10.a(HttpHeaders.ACCEPT_RANGES, HTTP.CONTENT_RANGE_BYTES);
                a10.a("Content-Length", "" + j13);
                a10.a("Content-Range", "bytes " + j11 + Operator.Operation.MINUS + j10 + Operator.Operation.DIVISION + available);
                a10.a("ETag", "");
            } else if (z10 || str3 == null || j11 < available) {
                a10 = c.a(com.hpplay.a.a.a.c.d.OK, str, inputStream, inputStream.available());
                a10.a(HttpHeaders.ACCEPT_RANGES, HTTP.CONTENT_RANGE_BYTES);
                a10.a("Content-Length", "" + available);
                a10.a("ETag", "");
            } else {
                a10 = newFixedLengthResponse(com.hpplay.a.a.a.c.d.RANGE_NOT_SATISFIABLE, d.MIME_PLAINTEXT, "");
                a10.a("Content-Range", "bytes */" + available);
                a10.a("ETag", "");
            }
            return a10;
        } catch (Exception e13) {
            e = e13;
            str2 = TAG;
            SourceLog.w(str2, e);
            return getForbiddenResponse("Reading file failed.");
        }
    }

    public c getForbiddenResponse(String str) {
        return c.a(com.hpplay.a.a.a.c.d.FORBIDDEN, d.MIME_PLAINTEXT, "FORBIDDEN: " + str);
    }

    public c getInternalErrorResponse(String str) {
        return c.a(com.hpplay.a.a.a.c.d.INTERNAL_ERROR, d.MIME_PLAINTEXT, "INTERNAL ERROR: " + str);
    }

    public c getNotFoundResponse() {
        return c.a(com.hpplay.a.a.a.c.d.NOT_FOUND, d.MIME_PLAINTEXT, "Error 404, file not found.");
    }

    @Override // com.hpplay.a.a.a.d
    public c serve(com.hpplay.a.a.a.c cVar) {
        Map<String, String> c10 = cVar.c();
        cVar.f();
        String i10 = cVar.i();
        SourceLog.i(TAG, i10);
        return respond(Collections.unmodifiableMap(c10), cVar, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0088 A[Catch: Exception -> 0x018e, TryCatch #1 {Exception -> 0x018e, blocks: (B:3:0x000a, B:5:0x0041, B:7:0x0049, B:14:0x006a, B:16:0x0074, B:20:0x007e, B:22:0x0088, B:24:0x0090, B:27:0x0099, B:64:0x0173), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0126 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0150 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0164 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.hpplay.a.a.a.c.c serveFile(java.lang.String r21, java.util.Map<java.lang.String, java.lang.String> r22, java.io.File r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.localserver.LelinkFileServer.serveFile(java.lang.String, java.util.Map, java.io.File, java.lang.String):com.hpplay.a.a.a.c.c");
    }
}
