package com.hpplay.sdk.source.mdns.utils;

import java.io.Closeable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class Misc {
    public static final Logger globalLogger = Logger.getLogger("global");

    public static final void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static final Logger getLogger(Class<?> cls, boolean z10) {
        return getLogger(cls.getName(), z10);
    }

    public static Level setGlobalLogLevel(Level level) {
        Logger logger = globalLogger;
        Level level2 = logger.getLevel();
        logger.setLevel(Level.FINE);
        return level2;
    }

    public static final String throwableToString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return th.getMessage() + "\nStack Trace:\n" + stringWriter.toString();
    }

    public static final StringBuilder trimTrailingDot(StringBuilder sb) {
        int length = sb.length() - 1;
        while (true) {
            if (length >= 0) {
                char charAt = sb.charAt(length);
                if (charAt != '.' && !Character.isWhitespace(charAt)) {
                    sb.setLength(length);
                    break;
                }
                length--;
            } else {
                break;
            }
        }
        return sb;
    }

    public static final String unescape(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z10 = false;
        int i10 = 0;
        int i11 = 0;
        for (char c10 : str.toCharArray()) {
            if (c10 == '\\') {
                z10 = true;
                i10 = 2;
                i11 = 0;
            } else {
                if (z10 && i10 < 0) {
                    sb.append((char) i11);
                    z10 = false;
                }
                if (!z10) {
                    sb.append(c10);
                } else if (Character.isDigit(c10)) {
                    double d10 = i11;
                    double d11 = c10 - '0';
                    double pow = Math.pow(10.0d, i10);
                    Double.isNaN(d11);
                    Double.isNaN(d10);
                    i11 = (int) (d10 + (d11 * pow));
                }
                i10--;
            }
        }
        return sb.toString();
    }

    public static final Logger getLogger(String str, boolean z10) {
        Logger logger = Logger.getLogger(str);
        logger.setParent(globalLogger);
        if (z10) {
            logger.setLevel(Level.FINEST);
        }
        return logger;
    }

    public static final String trimTrailingDot(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            if (charAt != '.' && !Character.isWhitespace(charAt)) {
                return str.substring(0, length + 1);
            }
        }
        return str;
    }
}
