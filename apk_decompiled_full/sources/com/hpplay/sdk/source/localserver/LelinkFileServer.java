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
    */
    public c serveFile(String str, Map<String, String> map, File file, String str2) {
        long j10;
        String str3;
        boolean z10;
        long length;
        c newFixedFileResponse;
        c newFixedLengthResponse;
        int indexOf;
        LelinkFileServer lelinkFileServer = this;
        try {
            String hexString = Integer.toHexString((file.getAbsolutePath() + file.lastModified() + "" + file.length()).hashCode());
            String str4 = map.get("range");
            long j11 = -1;
            try {
                if (str4 != null && str4.startsWith("bytes=") && (indexOf = (str4 = str4.substring(6)).indexOf(45)) > 0) {
                    try {
                        j10 = Long.parseLong(str4.substring(0, indexOf));
                        try {
                            j11 = Long.parseLong(str4.substring(indexOf + 1));
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                    }
                    str3 = map.get("if-range");
                    if (str3 != null && !hexString.equals(str3)) {
                        z10 = false;
                        String str5 = map.get("if-none-match");
                        boolean z11 = str5 == null && (Operator.Operation.MULTIPLY.equals(str5) || str5.equals(hexString));
                        length = file.length();
                        if (z10 || str4 == null || j10 < 0 || j10 >= length) {
                            if (z10 || str4 == null || j10 < length) {
                                if (str4 != null && z11) {
                                    newFixedLengthResponse = newFixedLengthResponse(com.hpplay.a.a.a.c.d.NOT_MODIFIED, str2, "");
                                    newFixedLengthResponse.a("ETag", hexString);
                                } else if (z10 && z11) {
                                    newFixedLengthResponse = newFixedLengthResponse(com.hpplay.a.a.a.c.d.NOT_MODIFIED, str2, "");
                                    newFixedLengthResponse.a("ETag", hexString);
                                } else {
                                    lelinkFileServer = this;
                                    newFixedFileResponse = lelinkFileServer.newFixedFileResponse(file, str2);
                                    newFixedFileResponse.a("Content-Length", "" + length);
                                    newFixedFileResponse.a("ETag", hexString);
                                }
                                return newFixedLengthResponse;
                            }
                            newFixedFileResponse = newFixedLengthResponse(com.hpplay.a.a.a.c.d.RANGE_NOT_SATISFIABLE, d.MIME_PLAINTEXT, "");
                            newFixedFileResponse.a("Content-Range", "bytes */" + length);
                            newFixedFileResponse.a("ETag", hexString);
                        } else {
                            if (z11) {
                                newFixedLengthResponse = newFixedLengthResponse(com.hpplay.a.a.a.c.d.NOT_MODIFIED, str2, "");
                                newFixedLengthResponse.a("ETag", hexString);
                                return newFixedLengthResponse;
                            }
                            if (j11 < 0) {
                                j11 = length - 1;
                            }
                            long j12 = (j11 - j10) + 1;
                            long j13 = j12 < 0 ? 0L : j12;
                            FileInputStream fileInputStream = new FileInputStream(file);
                            fileInputStream.skip(j10);
                            newFixedFileResponse = c.a(com.hpplay.a.a.a.c.d.PARTIAL_CONTENT, str2, fileInputStream, j13);
                            newFixedFileResponse.a(HttpHeaders.ACCEPT_RANGES, HTTP.CONTENT_RANGE_BYTES);
                            newFixedFileResponse.a("Content-Length", "" + j13);
                            newFixedFileResponse.a("Content-Range", "bytes " + j10 + Operator.Operation.MINUS + j11 + Operator.Operation.DIVISION + length);
                            newFixedFileResponse.a("ETag", hexString);
                        }
                        return newFixedFileResponse;
                    }
                    z10 = true;
                    String str52 = map.get("if-none-match");
                    if (str52 == null) {
                    }
                    length = file.length();
                    if (z10) {
                    }
                    if (z10) {
                    }
                    if (str4 != null) {
                    }
                    if (z10) {
                    }
                    lelinkFileServer = this;
                    newFixedFileResponse = lelinkFileServer.newFixedFileResponse(file, str2);
                    newFixedFileResponse.a("Content-Length", "" + length);
                    newFixedFileResponse.a("ETag", hexString);
                    return newFixedFileResponse;
                }
                if (str3 != null) {
                    z10 = false;
                    String str522 = map.get("if-none-match");
                    if (str522 == null) {
                    }
                    length = file.length();
                    if (z10) {
                    }
                    if (z10) {
                    }
                    if (str4 != null) {
                    }
                    if (z10) {
                    }
                    lelinkFileServer = this;
                    newFixedFileResponse = lelinkFileServer.newFixedFileResponse(file, str2);
                    newFixedFileResponse.a("Content-Length", "" + length);
                    newFixedFileResponse.a("ETag", hexString);
                    return newFixedFileResponse;
                }
                if (z10) {
                }
                if (z10) {
                }
                if (str4 != null) {
                }
                if (z10) {
                }
                lelinkFileServer = this;
                newFixedFileResponse = lelinkFileServer.newFixedFileResponse(file, str2);
                newFixedFileResponse.a("Content-Length", "" + length);
                newFixedFileResponse.a("ETag", hexString);
                return newFixedFileResponse;
            } catch (Exception e10) {
                e = e10;
                lelinkFileServer = this;
                SourceLog.w(TAG, e);
                return lelinkFileServer.getForbiddenResponse("Reading file failed.");
            }
            j10 = 0;
            str3 = map.get("if-range");
            z10 = true;
            String str5222 = map.get("if-none-match");
            if (str5222 == null) {
            }
            length = file.length();
        } catch (Exception e11) {
            e = e11;
        }
    }
}
