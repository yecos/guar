package com.hpplay.common.utils;

import android.app.Application;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.common.log.LeLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes2.dex */
public class CertUtils {
    public static final String LEBO_DOMAIN = "lebo.cn";
    public static final String TAG = "CertUtils";
    public static final String TYPE_HTTPS = "https";
    public static final byte[] SKBS = {0, 0, 0, 2, 0, 0, 0, Ascii.DC4, 74, -67, -59, -66, 6, -2, 103, 79, 65, 111, 73, 105, 81, 40, Ascii.FS, Ascii.US, -87, Ascii.SYN, 38, 52, 0, 0, 4, 113, 4, 0, 11, 108, 101, 98, 111, 95, 99, 108, 105, 101, 110, 116, 0, 0, 1, -124, -92, -74, 86, Ascii.US, 0, 0, 0, 1, 0, 5, 88, 46, 53, 48, 57, 0, 0, 3, -39, 48, -126, 3, -43, 48, -126, 2, -67, 2, 9, 0, -118, -93, 51, 47, -54, 58, Ascii.RS, 58, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, -127, -83, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 67, 78, 49, Ascii.DC2, 48, 16, 6, 3, 85, 4, 8, 12, 9, 71, 117, 97, 110, 103, 68, 111, 110, 103, 49, 17, 48, 15, 6, 3, 85, 4, 7, 12, 8, 83, 104, 101, 110, 122, 104, 101, 110, 49, 43, 48, 41, 6, 3, 85, 4, 10, 12, 34, 83, 104, 101, 110, 122, 104, 101, 110, 32, 76, 101, 98, 111, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 67, 111, 46, 44, 32, 76, 116, 100, 46, 49, Ascii.SYN, 48, Ascii.DC4, 6, 3, 85, 4, 11, 12, 13, 73, 84, 32, 68, 101, 112, 97, 114, 116, 109, 101, 110, 116, 49, Ascii.NAK, 48, 19, 6, 3, 85, 4, 3, 12, 12, -28, -71, -112, -26, -110, -83, -26, -118, -107, -27, -79, -113, 49, Ascii.ESC, 48, Ascii.EM, 6, 9, 42, -122, 72, -122, -9, 13, 1, 9, 1, Ascii.SYN, 12, 108, 98, 107, 106, SignedBytes.MAX_POWER_OF_TWO, 108, 101, 98, 111, 46, 99, 110, 48, Ascii.RS, Ascii.ETB, 13, 50, 49, 48, 53, 50, 53, 48, 52, 48, 54, 53, 50, 90, Ascii.ETB, 13, 51, 54, 48, 53, 50, 49, 48, 52, 48, 54, 53, 50, 90, 48, -127, -86, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 67, 78, 49, Ascii.DC2, 48, 16, 6, 3, 85, 4, 8, 12, 9, 71, 117, 97, 110, 103, 68, 111, 110, 103, 49, 17, 48, 15, 6, 3, 85, 4, 7, 12, 8, 83, 104, 101, 110, 122, 104, 101, 110, 49, 43, 48, 41, 6, 3, 85, 4, 10, 12, 34, 83, 104, 101, 110, 122, 104, 101, 110, 32, 76, 101, 98, 111, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 67, 111, 46, 44, 32, 76, 116, 100, 46, 49, Ascii.SYN, 48, Ascii.DC4, 6, 3, 85, 4, 11, 12, 13, 73, 84, 32, 68, 101, 112, 97, 114, 116, 109, 101, 110, 116, 49, Ascii.DC2, 48, 16, 6, 3, 85, 4, 3, 12, 9, 42, 46, 108, 101, 98, 111, 46, 99, 110, 49, Ascii.ESC, 48, Ascii.EM, 6, 9, 42, -122, 72, -122, -9, 13, 1, 9, 1, Ascii.SYN, 12, 108, 98, 107, 106, SignedBytes.MAX_POWER_OF_TWO, 108, 101, 98, 111, 46, 99, 110, 48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -86, 4, 12, 126, 84, 48, -100, -79, -111, -114, -90, -42, -76, 122, 0, UnsignedBytes.MAX_POWER_OF_TWO, -7, -36, -1, 93, 122, -80, 55, 81, -21, 66, Ascii.ESC, -98, -99, 94, 114, 15, -45, Ascii.SYN, -8, 70, 99, -10, -110, -111, -22, 97, -84, 7, -17, -21, -52, 5, -93, 87, 102, -76, -38, -75, 98, -1, -117, 101, -38, -54, 124, 1, 107, -41, -58, 48, -58, -63, 13, Ascii.NAK, 104, Ascii.SYN, -69, 8, -9, 124, -80, 48, -104, Ascii.SUB, 66, 45, -83, -101, -107, 6, UnsignedBytes.MAX_POWER_OF_TWO, 103, -52, -32, 122, -78, 59, 93, 81, -113, 68, -109, Ascii.DC2, 120, 101, -104, -105, -24, 70, Ascii.DEL, -72, Ascii.DEL, 49, -85, 81, -95, -31, -65, Ascii.DEL, 117, 80, -120, 17, -13, -105, Ascii.DEL, -85, -7, -55, -89, Ascii.GS, -6, -51, -15, 11, -16, -74, 98, 63, 7, 46, -102, -39, -30, -123, -77, 52, -80, Ascii.SUB, -12, Ascii.DC4, -125, Ascii.ETB, 43, 83, 81, -84, -20, -70, -66, -1, 38, 48, -113, -36, -77, -120, Ascii.CAN, -82, -74, 45, -68, 77, 43, 93, -101, 42, -106, -103, Ascii.GS, -49, -17, 72, -39, 85, -90, -79, -85, 124, 70, 10, -120, 74, -71, 98, -104, 49, 122, Ascii.ESC, 54, -57, -66, -63, 117, 9, 58, 105, -91, 88, -101, 33, -69, 82, 77, -44, -92, 36, -120, 56, -85, 0, UnsignedBytes.MAX_POWER_OF_TWO, -61, 87, -113, 123, -77, -51, 72, -55, 103, -50, 104, -69, 76, 72, 36, -121, 50, Ascii.ESC, -91, -53, -66, 56, -87, -104, -69, 101, -63, -81, -95, -7, 39, 42, -96, 49, -53, 94, 121, 91, 2, 3, 1, 0, 1, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 94, -71, -19, 42, -55, -36, 83, -104, -91, -123, 50, 14, -103, Ascii.SUB, 116, -81, -61, 15, -49, -50, 76, 66, 101, -125, 89, 59, -60, 1, 79, 42, Ascii.SUB, -86, 80, 46, -62, 8, -54, 83, -64, 16, -57, 124, -83, 115, -63, Ascii.FS, 37, 52, 103, -22, 94, -57, 123, 39, -33, 0, 91, Ascii.NAK, -109, -110, 16, -93, 83, 120, -57, -61, -57, 87, 120, -63, 34, -104, -17, 37, -65, -12, 90, 15, -103, 81, 99, -93, 40, 85, -78, Ascii.SYN, -79, -23, 108, 72, 122, 72, -99, 120, Ascii.SYN, -101, 7, -17, 41, 51, -1, 50, 50, -56, SignedBytes.MAX_POWER_OF_TWO, -8, -61, -76, -94, 105, 123, 9, 41, -125, 103, 47, -22, 106, -48, -110, 32, -107, 12, -55, 57, 46, -115, 32, -28, -110, -69, 72, 67, -20, -127, SignedBytes.MAX_POWER_OF_TWO, -121, 19, -39, -18, -104, 41, -33, -77, 91, 17, -36, UnsignedBytes.MAX_POWER_OF_TWO, -77, 90, 3, 71, 88, 14, -84, 71, -53, 84, Ascii.FS, Ascii.EM, Ascii.ETB, 100, -72, -50, -120, -43, -22, -46, 111, -105, -114, 97, -57, 3, -61, 63, 6, 17, 118, -86, -14, 57, Ascii.DC4, 95, -36, 98, Ascii.DC2, 35, 69, 0, 90, -106, -15, 77, 56, 120, 54, -115, 55, 104, 84, 41, 
    -113, -9, -101, -124, 84, -72, -70, 13, 15, -16, -61, -122, -64, -49, 48, 70, -118, -31, 72, 14, 117, Ascii.SUB, -16, -61, Ascii.DC4, 122, 38, 110, -45, 57, -88, -90, 6, -57, -125, -49, 87, -19, -89, -86, -120, -121, -26, -14, 90, 72, -10, 3, 52, 112, 113, 19, 43, 38, 0, 0, 4, -12, 0, 0, 0, Ascii.DC4, -7, 48, -42, 103, -114, -84, 122, -3, 120, 37, -62, -57, 36, 17, -96, 68, -97, -44, -25, -101, 0, 0, 4, -116, 126, -46, -37, -111, -4, -44, 69, 32, Ascii.ESC, 36, 99, 40, -34, -68, -8, 33, 118, 56, Ascii.DC2, Ascii.ESC, 32, 90, 113, -101, 118, -73, -106, -89, 59, 106, 116, 90, -127, -44, 94, 52, -127, -75, Ascii.ETB, 121, 102, 117, 36, -122, -6, 66, -17, 32, -10, -5, 56, 16, 122, -92, -45, 93, -75, 103, -20, -78, -44, -40, Ascii.DEL, -116, 51, -35, -55, -108, 84, -56, 111, -71, -70, -23, 92, -61, -37, 104, -84, 62, Ascii.GS, 68, -68, -82, -108, 81, -77, -81, -70, 36, -47, 11, -113, -90, 38, 33, -54, 83, -23, -52, -16, -112, -54, -109, 92, 8, -82, 125, 67, -32, Ascii.US, 103, 86, -13, 61, -20, 34, -5, -123, -33, 118, -79, -44, 72, 104, 110, -40, 70, -69, 46, Ascii.DC2, 62, -106, -90, 61, -75, -96, -112, 102, 117, -102, -53, -31, 104, 19, -101, 50, -56, -96, Ascii.DEL, -71, -107, -40, -118, 55, -26, -24, -73, -72, -58, 48, Ascii.RS, 108, 11, 110, -76, 47, -22, 108, -27, 42, -102, -82, 97, 111, 70, 41, 90, Ascii.RS, 0, -89, 19, -14, -31, -41, 51, 49, -115, -32, 99, -4, 11, -61, -18, 82, 6, 55, -105, -15, -101, -98, -22, 104, -27, -110, -90, -65, 39, -2, -14, -12, 43, 51, 93, 91, -26, -114, -71, -50, 101, -4, -36, 4, 95, 17, 83, -24, -34, 93, 122, -73, 32, 73, 15, -104, -47, -121, -17, -9, 63, 79, 12, -28, 38, 119, -4, -17, 87, -70, -21, 44, 123, 50, -56, Ascii.ESC, 91, -82, -1, 33, -57, 125, UnsignedBytes.MAX_POWER_OF_TWO, -100, -97, 54, 47, 106, -108, -72, -7, 117, -98, -112, -83, 93, 14, -91, 2, 112, 58, 105, 123, Ascii.SUB, -90, -32, 82, 51, -103, -13, 98, 39, 101, -102, -33, -116, 112, -115, 54, 8, -23, 118, -106, -119, Ascii.US, 103, -54, -83, -126, 115, -42, 123, 55, 102, 116, -88, -61, 123, 16, 108, -73, -98, 56, -44, SignedBytes.MAX_POWER_OF_TWO, Ascii.NAK, 68, 94, -101, -76, 100, 62, -27, -55, -73, -34, 44, 78, -124, 36, -121, -6, -68, 36, -70, Ascii.CAN, -64, -69, 69, -95, -68, -6, 58, 48, -8, -29, -101, 77, -62, -74, -22, -77, -35, 122, -57, -4, -13, 116, 119, -50, -76, -34, Ascii.GS, -119, 73, -24, 76, 104, -26, -55, UnsignedBytes.MAX_POWER_OF_TWO, -47, -8, -46, -63, -121, 1, -123, -67, -117, -40, -76, 34, -112, -55, 92, -64, Ascii.DC2, 113, -15, 45, -78, -64, -115, -11, Ascii.DC2, 80, 81, -105, 66, 86, 81, 106, Ascii.RS, 112, 55, 57, -105, -71, -114, Ascii.SYN, -75, -77, -3, 73, 73, 8, 75, -101, -28, -30, 42, -103, Ascii.DC4, 42, -103, -72, 103, 14, -42, -22, -68, 88, 65, 57, -10, 15, 107, 7, 108, Ascii.ESC, -20, -62, 100, 67, -97, -113, 110, -62, -38, -16, -36, 85, -56, -42, -11, -51, -48, Ascii.US, 88, -124, -72, 33, 35, -118, 7, 40, -33, 109, 69, -65, 69, -42, -62, 123, 68, Ascii.DC2, 83, -16, -44, 103, 82, -66, -31, 39, -8, 73, -45, 104, 48, 108, -55, 83, -18, 99, 11, -41, -94, 95, 78, SignedBytes.MAX_POWER_OF_TWO, 110, 114, 112, -109, -7, UnsignedBytes.MAX_POWER_OF_TWO, Ascii.SUB, -100, -103, 87, 54, 36, -102, 97, 66, 3, -57, -114, -64, -93, -17, -79, 95, 100, -123, 122, 10, 35, -18, 3, 120, Ascii.EM, Ascii.US, -10, -37, -57, -7, -40, 17, 101, -95, Ascii.RS, -104, 16, -47, -122, 68, -94, 90, 67, -113, -106, 111, -124, Ascii.SUB, 83, -15, 77, 125, SignedBytes.MAX_POWER_OF_TWO, -88, 76, 91, -72, 120, 91, 100, 58, -90, -18, 126, 47, 15, -117, 99, 51, 93, -14, 35, -51, 74, -67, 77, 0, 6, 77, 55, 73, -36, -76, -80, Ascii.US, -42, 111, 42, -93, -57, -55, 100, 62, -80, -76, 113, 93, 0, 73, 84, -86, 102, -93, -23, -76, 7, Ascii.FS, -120, -107, 58, -39, 8, 77, -51, 9, -110, Ascii.DC2, 119, 58, 66, -27, 43, 63, -39, 51, 108, -30, 111, 44, 105, 33, -14, -109, 68, 72, -44, 123, 43, -5, 83, -75, 7, -102, 60, 48, -93, -18, -34, 92, -29, 3, 62, -44, -91, -17, -38, 115, 55, Ascii.CAN, -42, -53, 71, -77, 122, -14, -74, -57, -127, -98, -114, 57, -123, -127, 34, -21, 58, -45, -114, -9, -74, -14, -19, -57, -32, 6, 69, -113, 83, 111, -108, -124, -118, 102, -23, -56, UnsignedBytes.MAX_POWER_OF_TWO, 9, -116, -9, 2, -106, -80, -25, -102, -27, -108, -62, Ascii.US, 35, -97, -125, 42, -106, 45, -8, -12, -59, Ascii.SYN, 108, 92, 67, -26, -43, 8, -121, 72, -52, 10, -9, -106, -55, 69, 56, -17, 125, 14, 89, 99, 37, -118, 5, -29, 73, 118, -10, -6, -11, 79, 108, 67, 34, 74, -103, -49, -14, -97, -74, -7, -1, 88, Ascii.DC4, 119, Ascii.FS, -6, -51, -87, 91, -27, 96, 59, 122, -48, -108, -11, 69, -19, 47, -91, -88, 108, -114, 10, 50, 16, 70, -17, 36, -112, 1, 35, -100, 35, 56, -105, -85, 117, -87, 86, -76, -79, -53, 73, -78, -15, -105, -75, 3, 111, -112, -27, -72, 79, -31, 33, -34, Ascii.RS, -95, 63, -102, 85, 122, -84, -95, 110, -122, 40, 86, 104, 7, -117, 67, 0, -25, 6, 71, 13, 97, 71, -25, -76, 118, SignedBytes.MAX_POWER_OF_TWO, 9, 123, -69, 9, -71, -2, 59, -22, -41, -26, -84, -10, -63, 72, Ascii.ESC, -50, -39, -44, 106, 15, -30, 35, 56, -19, -123, -111, -100, Ascii.DEL, -60, -115, -116, 90, 13, -78, 93, 34, 38, 43, -3, 115, -116, Ascii.ETB, -94, 77, 67, -119, -118, -56, -105, 114, -11, -35, 50, 96, 73, 
    38, -72, 83, -69, -26, 114, -84, 110, Ascii.GS, -78, 99, -57, -31, 8, 69, 60, 33, -77, -29, -1, -101, -50, 98, 73, -52, Ascii.ETB, 61, 82, -34, 125, Ascii.RS, 33, -52, -63, Ascii.SUB, Ascii.EM, -111, Ascii.DEL, -26, -101, -12, -85, 114, -2, 114, -66, -67, 35, 96, -34, Ascii.RS, 89, 70, 50, 119, -53, -111, 65, -49, 5, -100, -88, 124, -68, -123, -83, -115, -66, Ascii.NAK, 113, 60, -63, -110, 90, -120, -3, -109, 100, -123, -2, 60, -34, 108, -40, -82, -82, 69, -92, -97, -119, -117, -110, 13, 90, -121, -75, 10, -54, -59, -33, -15, 11, -2, -113, 93, -117, 51, 36, -71, -35, -111, -100, 112, Ascii.SYN, 93, Ascii.CAN, 114, 121, 106, -11, 46, -57, Ascii.SUB, -121, -59, 96, -5, -52, -121, Ascii.DC2, -7, 37, 3, 120, 78, -94, -46, -20, 101, -23, -31, 122, 19, 0, -117, 98, -48, -48, -76, -75, 60, 103, -117, 114, -125, -122, -97, 89, 6, 88, -30, 15, -114, -119, 63, -117, 65, -71, -117, -2, 39, -120, 80, 114, -123, -73, 48, 66, -85, 35, 117, Ascii.RS, 124, 63, -98, -62, 58, Ascii.RS, -10, Ascii.DC2, Ascii.SUB, 50, -68, -80, 103, Ascii.ETB, 112, -50, 75, 68, Ascii.EM, Ascii.DC4, -13, 100, 4, -73, Ascii.RS, -37, -55, -104, -2, UnsignedBytes.MAX_POWER_OF_TWO, 3, -90, 13, -71, -33, -8, -93, 36, 104, -102, -75, -106, -93, -82, -53, -17, 121, -13, -41, -47, -63, 51, -109, 7, -6, 79, Ascii.SYN, 46, 71, -82, -126, -80, -27, -19, 117, -35, -10, 4, 19, 103, 77, 70, 75, Ascii.EM, -2, -82, 92, -30, -15, -101, -54, -77, 78, 34, -54, -97, -32, 84, -92, 11, 46, -110, 37, 44, -39, 49, -95, -90, 1, 34, -20, 15, -22, -78, 118, 113, 33, 111, -95, 69, -98, Ascii.GS, 78, -7, 58, 2, -66, -102, -94, 43, 97, -98, -7, -45, -92, 51, Ascii.ESC, 12, Ascii.FS, -95, -48, -81, -59, -26, -79, -20, -101, -24, 51, -44, Ascii.GS, 46, 6, -110, 0, 60, -36, -111, -110, -88, -90, Ascii.DC2, Ascii.NAK, -66, 75, -116, -13, -120, -84, 91, 94, 58, 76, 67, 9};
    public static final byte[] DWP = {108, 101, 98, 111, 50, 48, 50, 50};

    public static Application getApplication() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            return (Application) cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, null), null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static SSLSocketFactory getCertCAS() {
        ByteArrayInputStream byteArrayInputStream;
        KeyStore keyStore;
        SSLSocketFactory sSLSocketFactory = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                keyStore = KeyStore.getInstance("BKS");
                byteArrayInputStream = new ByteArrayInputStream(SKBS);
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            try {
                byte[] bArr = DWP;
                keyStore.load(byteArrayInputStream, new String(bArr).toCharArray());
                byteArrayInputStream.close();
                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                keyManagerFactory.init(keyStore, new String(bArr).toCharArray());
                keyManagerFactory.init(keyStore, new String(bArr).toCharArray());
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                final X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new BufferedInputStream(getApplication().getAssets().open("root.crt")));
                sSLContext.init(keyManagerFactory.getKeyManagers(), new TrustManager[]{new X509TrustManager() { // from class: com.hpplay.common.utils.CertUtils.1
                    @Override // javax.net.ssl.X509TrustManager
                    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                        LeLog.i(CertUtils.TAG, "=====checkClientTrusted======");
                    }

                    @Override // javax.net.ssl.X509TrustManager
                    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                        for (X509Certificate x509Certificate2 : x509CertificateArr) {
                            x509Certificate2.checkValidity();
                            try {
                                x509Certificate.getPublicKey();
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                        }
                    }

                    @Override // javax.net.ssl.X509TrustManager
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                }}, new SecureRandom());
                sSLSocketFactory = sSLContext.getSocketFactory();
                byteArrayInputStream.close();
            } catch (Exception e11) {
                e = e11;
                e.printStackTrace();
                byteArrayInputStream.close();
                return sSLSocketFactory;
            }
        } catch (Exception e12) {
            e = e12;
            byteArrayInputStream = null;
        } catch (Throwable th2) {
            byteArrayInputStream = null;
            th = th2;
            try {
                byteArrayInputStream.close();
            } catch (IOException e13) {
                e13.printStackTrace();
            }
            throw th;
        }
        return sSLSocketFactory;
    }

    public static SSLSocketFactory getCertCNS() {
        ByteArrayInputStream byteArrayInputStream;
        KeyStore keyStore;
        SSLSocketFactory sSLSocketFactory = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                keyStore = KeyStore.getInstance("BKS");
                byteArrayInputStream = new ByteArrayInputStream(SKBS);
            } catch (Exception e10) {
                LeLog.w(TAG, e10);
            }
            try {
                byte[] bArr = DWP;
                keyStore.load(byteArrayInputStream, new String(bArr).toCharArray());
                byteArrayInputStream.close();
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                keyManagerFactory.init(keyStore, new String(bArr).toCharArray());
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                sSLContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
                sSLSocketFactory = sSLContext.getSocketFactory();
                byteArrayInputStream.close();
            } catch (Exception e11) {
                e = e11;
                LeLog.w(TAG, e);
                byteArrayInputStream.close();
                return sSLSocketFactory;
            }
        } catch (Exception e12) {
            e = e12;
            byteArrayInputStream = null;
        } catch (Throwable th2) {
            byteArrayInputStream = null;
            th = th2;
            try {
                byteArrayInputStream.close();
            } catch (Exception e13) {
                LeLog.w(TAG, e13);
            }
            throw th;
        }
        return sSLSocketFactory;
    }

    public static TrustManager getDefaultTrustManager() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            return trustManagerFactory.getTrustManagers()[0];
        } catch (Exception e10) {
            LeLog.w(TAG, e10);
            return null;
        }
    }

    public static HttpURLConnection getHttpURLConnection(URL url) {
        if (!url.toString().startsWith("https") || !url.toString().contains(LEBO_DOMAIN)) {
            return (HttpURLConnection) url.openConnection();
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setSSLSocketFactory(getCertCNS());
        return httpsURLConnection;
    }
}
