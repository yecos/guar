package com.alibaba.sdk.android.utils.crashdefend;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class e {
    public static void a(Context context, a aVar, List<c> list) {
        if (context == null) {
            return;
        }
        synchronized (list) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (aVar != null) {
                        jSONObject.put("startSerialNumber", aVar.f5986a);
                    }
                    try {
                        JSONArray jSONArray = new JSONArray();
                        for (c cVar : list) {
                            if (cVar != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("sdkId", cVar.f52a);
                                jSONObject2.put(Constants.KEY_SDK_VERSION, cVar.f54b);
                                jSONObject2.put("crashLimit", cVar.f5992a);
                                jSONObject2.put("crashCount", cVar.crashCount);
                                jSONObject2.put("waitTime", cVar.f5993b);
                                jSONObject2.put("registerSerialNumber", cVar.f53b);
                                jSONObject2.put("startSerialNumber", cVar.f50a);
                                jSONObject2.put("restoreCount", cVar.f5994c);
                                jSONArray.put(jSONObject2);
                            }
                        }
                        jSONObject.put("sdkList", jSONArray);
                    } catch (JSONException unused) {
                    }
                    String jSONObject3 = jSONObject.toString();
                    fileOutputStream = m26a(context) ? context.openFileOutput("com_alibaba_aliyun_crash_defend_sdk_info", 0) : context.openFileOutput("com_alibaba_aliyun_crash_defend_sdk_info_" + a(context), 0);
                    fileOutputStream.write(jSONObject3.getBytes());
                } catch (Throwable th) {
                    throw th;
                }
            } catch (IOException unused2) {
                if (fileOutputStream != null) {
                }
            } catch (Exception unused3) {
                if (fileOutputStream != null) {
                }
            } catch (Throwable th2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th2;
            }
            try {
                fileOutputStream.close();
            } catch (IOException unused5) {
            }
        }
    }

    private static String b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return "";
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    private static String c(Context context) {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, context.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, new Object[0]);
        } catch (Exception e10) {
            StringBuilder sb = new StringBuilder();
            sb.append("getProcessNameByActivityThread error: ");
            sb.append(e10);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0066, code lost:
    
        if (r3 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0051, code lost:
    
        if (r3 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x004e, code lost:
    
        if (r3 != null) goto L57;
     */
    /* renamed from: a, reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m27a(Context context, a aVar, List<c> list) {
        byte[] bArr;
        if (context == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        synchronized (list) {
            FileInputStream fileInputStream = null;
            try {
                try {
                    fileInputStream = m26a(context) ? context.openFileInput("com_alibaba_aliyun_crash_defend_sdk_info") : context.openFileInput("com_alibaba_aliyun_crash_defend_sdk_info_" + a(context));
                    bArr = new byte[512];
                } catch (FileNotFoundException e10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("load sdk file fail:");
                    sb2.append(e10.getMessage());
                } catch (IOException unused) {
                } catch (Exception unused2) {
                }
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        sb.append(new String(bArr, 0, read));
                    }
                    try {
                        break;
                    } catch (IOException unused3) {
                    }
                }
                fileInputStream.close();
                if (sb.length() == 0) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(sb.toString());
                    aVar.f5986a = jSONObject.optLong("startSerialNumber", 1L);
                    JSONArray jSONArray = jSONObject.getJSONArray("sdkList");
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                        if (jSONObject2 != null) {
                            c cVar = new c();
                            cVar.f52a = jSONObject2.optString("sdkId", "");
                            cVar.f54b = jSONObject2.optString(Constants.KEY_SDK_VERSION, "");
                            cVar.f5992a = jSONObject2.optInt("crashLimit", -1);
                            cVar.crashCount = jSONObject2.optInt("crashCount", 0);
                            cVar.f5993b = jSONObject2.optInt("waitTime", 0);
                            cVar.f53b = jSONObject2.optLong("registerSerialNumber", 0L);
                            cVar.f50a = jSONObject2.optLong("startSerialNumber", 0L);
                            cVar.f5994c = jSONObject2.optInt("restoreCount", 0);
                            if (!TextUtils.isEmpty(cVar.f52a)) {
                                list.add(cVar);
                            }
                        }
                    }
                } catch (JSONException | Exception unused4) {
                }
                return true;
            } catch (Throwable th) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m26a(Context context) {
        return context.getPackageName().equalsIgnoreCase(a(context));
    }

    private static String a(Context context) {
        String processName;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
            return processName;
        }
        String c10 = c(context);
        if (!TextUtils.isEmpty(c10)) {
            return c10;
        }
        String a10 = a();
        return !TextUtils.isEmpty(a10) ? a10 : b(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a() {
        Throwable th;
        BufferedReader bufferedReader;
        String str;
        BufferedReader bufferedReader2 = null;
        try {
            File file = new File("/proc/" + Process.myPid() + "/cmdline");
            if (file.exists()) {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    try {
                        bufferedReader2 = bufferedReader;
                        str = bufferedReader.readLine().trim();
                    } catch (Exception e10) {
                        e = e10;
                        StringBuilder sb = new StringBuilder();
                        sb.append("getProcessNameByPid error: ");
                        sb.append(e);
                        if (bufferedReader == null) {
                            return null;
                        }
                        try {
                            bufferedReader.close();
                            return null;
                        } catch (IOException e11) {
                            e11.printStackTrace();
                            return null;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    throw th;
                }
            } else {
                str = null;
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            return str;
        } catch (Exception e14) {
            e = e14;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            throw th;
        }
    }
}
