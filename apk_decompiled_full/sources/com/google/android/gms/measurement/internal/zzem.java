package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class zzem implements Runnable {
    final /* synthetic */ zzen zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzej zzd;
    private final String zze;
    private final Map zzf;

    public zzem(zzen zzenVar, String str, URL url, byte[] bArr, Map map, zzej zzejVar) {
        this.zza = zzenVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzejVar);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzejVar;
        this.zze = str;
        this.zzf = map;
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00fa: MOVE (r12 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:251), block:B:80:0x00f8 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0100: MOVE (r12 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:257), block:B:78:0x00fd */
    /* JADX WARN: Removed duplicated region for block: B:26:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0163 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Throwable th;
        HttpURLConnection httpURLConnection;
        Map map;
        IOException e10;
        Map map2;
        int i10;
        zzel zzelVar;
        zzfo zzfoVar;
        IOException iOException;
        int i11;
        zzen zzenVar;
        URLConnection openConnection;
        int responseCode;
        Map map3;
        Map map4;
        InputStream inputStream;
        this.zza.zzax();
        OutputStream outputStream = null;
        try {
            zzenVar = this.zza;
            openConnection = this.zzb.openConnection();
        } catch (IOException e11) {
            e10 = e11;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
            map = null;
        }
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain HTTP connection");
        }
        httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        zzenVar.zzt.zzf();
        httpURLConnection.setConnectTimeout(60000);
        zzenVar.zzt.zzf();
        httpURLConnection.setReadTimeout(61000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setDoInput(true);
        try {
            Map map5 = this.zzf;
            if (map5 != null) {
                for (Map.Entry entry : map5.entrySet()) {
                    httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (this.zzc != null) {
                byte[] zzy = this.zza.zzf.zzu().zzy(this.zzc);
                zzef zzj = this.zza.zzt.zzay().zzj();
                int length = zzy.length;
                zzj.zzb("Uploading data. size", Integer.valueOf(length));
                httpURLConnection.setDoOutput(true);
                httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                httpURLConnection.setFixedLengthStreamingMode(length);
                httpURLConnection.connect();
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                try {
                    outputStream2.write(zzy);
                    outputStream2.close();
                } catch (IOException e12) {
                    e10 = e12;
                    map2 = null;
                    outputStream = outputStream2;
                    iOException = e10;
                    i11 = 0;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e13) {
                            this.zza.zzt.zzay().zzd().zzc("Error closing HTTP compressed POST connection output stream. appId", zzeh.zzn(this.zze), e13);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzfoVar = this.zza.zzt.zzaz();
                    zzelVar = new zzel(this.zze, this.zzd, i11, iOException, null, map2, null);
                    zzfoVar.zzp(zzelVar);
                } catch (Throwable th3) {
                    th = th3;
                    map = null;
                    outputStream = outputStream2;
                    i10 = 0;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e14) {
                            this.zza.zzt.zzay().zzd().zzc("Error closing HTTP compressed POST connection output stream. appId", zzeh.zzn(this.zze), e14);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.zza.zzt.zzaz().zzp(new zzel(this.zze, this.zzd, i10, null, null, map, null));
                    throw th;
                }
            }
            responseCode = httpURLConnection.getResponseCode();
        } catch (IOException e15) {
            map2 = null;
            iOException = e15;
            i11 = 0;
            if (outputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            zzfoVar = this.zza.zzt.zzaz();
            zzelVar = new zzel(this.zze, this.zzd, i11, iOException, null, map2, null);
            zzfoVar.zzp(zzelVar);
        } catch (Throwable th4) {
            map = null;
            th = th4;
        }
        try {
            try {
                Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        zzfoVar = this.zza.zzt.zzaz();
                        zzelVar = new zzel(this.zze, this.zzd, responseCode, null, byteArray, headerFields, null);
                    } catch (Throwable th5) {
                        th = th5;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = null;
                }
            } catch (IOException e16) {
                map2 = null;
                iOException = e16;
                i11 = responseCode;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                zzfoVar = this.zza.zzt.zzaz();
                zzelVar = new zzel(this.zze, this.zzd, i11, iOException, null, map2, null);
                zzfoVar.zzp(zzelVar);
            } catch (Throwable th7) {
                th = th7;
                map = null;
                i10 = responseCode;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                this.zza.zzt.zzaz().zzp(new zzel(this.zze, this.zzd, i10, null, null, map, null));
                throw th;
            }
        } catch (IOException e17) {
            iOException = e17;
            i11 = responseCode;
            map2 = map4;
            if (outputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            zzfoVar = this.zza.zzt.zzaz();
            zzelVar = new zzel(this.zze, this.zzd, i11, iOException, null, map2, null);
            zzfoVar.zzp(zzelVar);
        } catch (Throwable th8) {
            th = th8;
            i10 = responseCode;
            map = map3;
            if (outputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            this.zza.zzt.zzaz().zzp(new zzel(this.zze, this.zzd, i10, null, null, map, null));
            throw th;
        }
        zzfoVar.zzp(zzelVar);
    }
}
