package com.umeng.message.tag;

import android.app.Application;
import android.text.TextUtils;
import android.util.Pair;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushTagCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.be;
import com.umeng.message.proguard.bi;
import com.umeng.message.proguard.d;
import com.umeng.message.proguard.e;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.g;
import com.umeng.message.proguard.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TagManager {

    /* renamed from: b, reason: collision with root package name */
    private static volatile TagManager f12245b;

    /* renamed from: a, reason: collision with root package name */
    private final be f12246a = new be();

    @Deprecated
    public interface TCallBack extends UPushTagCallback<ITagManager.Result> {
    }

    @Deprecated
    public interface TagListCallBack extends UPushTagCallback<List<String>> {
    }

    private TagManager() {
    }

    public static /* synthetic */ boolean b() {
        boolean z10 = MessageSharedPrefs.getInstance(y.a()).f11344b.b("tag_send_policy", -1) == 1;
        if (z10) {
            UPLog.i("TagManager", "tag server disable!");
        }
        return z10;
    }

    public static /* synthetic */ JSONObject d() {
        Application a10 = y.a();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", e.a());
        jSONObject.put("utdid", d.o(a10));
        jSONObject.put("device_token", MessageSharedPrefs.getInstance(a10).l());
        jSONObject.put("ts", System.currentTimeMillis());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ITagManager.Result e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", ITagManager.SUCCESS);
            jSONObject.put("remain", MessageSharedPrefs.getInstance(y.a()).d());
        } catch (Exception e10) {
            UPLog.e("TagManager", e10);
        }
        return new ITagManager.Result(jSONObject);
    }

    public static TagManager getInstance() {
        if (f12245b == null) {
            synchronized (TagManager.class) {
                if (f12245b == null) {
                    f12245b = new TagManager();
                }
            }
        }
        return f12245b;
    }

    public void addTags(final UPushTagCallback<ITagManager.Result> uPushTagCallback, final String... strArr) {
        b.b(new Runnable() { // from class: com.umeng.message.tag.TagManager.1
            @Override // java.lang.Runnable
            public final void run() {
                ITagManager.Result result;
                boolean z10;
                ITagManager.Result result2 = new ITagManager.Result();
                try {
                    String[] strArr2 = strArr;
                    if (strArr2 != null && strArr2.length != 0) {
                        if (TagManager.a()) {
                            UPLog.e("TagManager", "No utdid or device_token");
                            result2.setErrors("No utdid or device_token");
                            try {
                                uPushTagCallback.onMessage(false, result2);
                                return;
                            } catch (Throwable th) {
                                UPLog.e("TagManager", th);
                                return;
                            }
                        }
                        if (TagManager.b()) {
                            UPLog.e("TagManager", "Tag api is disabled by the server");
                            result2.setErrors("Tag api is disabled by the server");
                            try {
                                uPushTagCallback.onMessage(false, result2);
                                return;
                            } catch (Throwable th2) {
                                UPLog.e("TagManager", th2);
                                return;
                            }
                        }
                        Application a10 = y.a();
                        ArrayList arrayList = new ArrayList();
                        Set<String> b10 = MessageSharedPrefs.getInstance(a10).f11344b.b("tags", new HashSet());
                        for (String str : strArr) {
                            if (!b10.contains(str) && !arrayList.contains(str)) {
                                byte[] bytes = str.getBytes();
                                if (bytes == null || bytes.length > 128 || bytes.length <= 0) {
                                    UPLog.e("TagManager", "tag length must be 1~128 byte");
                                    result2.setErrors("tag length must be 1~128 byte");
                                    try {
                                        uPushTagCallback.onMessage(false, result2);
                                        return;
                                    } catch (Throwable th3) {
                                        UPLog.e("TagManager", th3);
                                        return;
                                    }
                                }
                                arrayList.add(str);
                            }
                        }
                        if (arrayList.size() > MessageSharedPrefs.getInstance(a10).d()) {
                            UPLog.e("TagManager", "tag count limit");
                            result2.setErrors("tag count limit");
                            try {
                                uPushTagCallback.onMessage(false, result2);
                                return;
                            } catch (Throwable th4) {
                                UPLog.e("TagManager", th4);
                                return;
                            }
                        }
                        if (!MessageSharedPrefs.getInstance(a10).a("tag_add_")) {
                            UPLog.e("TagManager", "interval limit");
                            result2.setErrors("interval limit");
                            try {
                                uPushTagCallback.onMessage(false, result2);
                                return;
                            } catch (Throwable th5) {
                                UPLog.e("TagManager", th5);
                                return;
                            }
                        }
                        if (arrayList.size() == 0) {
                            try {
                                uPushTagCallback.onMessage(true, TagManager.e());
                                return;
                            } catch (Throwable th6) {
                                UPLog.e("TagManager", th6);
                                return;
                            }
                        }
                        try {
                            JSONObject d10 = TagManager.d();
                            d10.put("tags", bi.a(arrayList));
                            be unused = TagManager.this.f12246a;
                            String[] strArr3 = strArr;
                            Application a11 = y.a();
                            result = new ITagManager.Result(g.a(d10, "https://msg.umengcloud.com/v3/tag/add", UMUtils.getAppkey(a11)));
                            if (TextUtils.equals(result.status, ITagManager.SUCCESS)) {
                                MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a11);
                                messageSharedPrefs.a(strArr3);
                                messageSharedPrefs.a(result.remain);
                                messageSharedPrefs.a("tag_add_", result.interval);
                            }
                        } catch (Exception e10) {
                            e = e10;
                        }
                        try {
                            try {
                                z10 = result.status.equals(ITagManager.SUCCESS);
                            } catch (Exception e11) {
                                e = e11;
                                result2 = result;
                                UPLog.e("TagManager", e);
                                result = result2;
                                z10 = false;
                                uPushTagCallback.onMessage(z10, result);
                                return;
                            } catch (Throwable th7) {
                                th = th7;
                                result2 = result;
                                try {
                                    UPLog.e("TagManager", th);
                                    try {
                                        uPushTagCallback.onMessage(false, result2);
                                        return;
                                    } catch (Throwable th8) {
                                        UPLog.e("TagManager", th8);
                                        return;
                                    }
                                } finally {
                                }
                            }
                            uPushTagCallback.onMessage(z10, result);
                            return;
                        } catch (Throwable th9) {
                            UPLog.e("TagManager", th9);
                            return;
                        }
                    }
                    UPLog.e("TagManager", "No tags");
                    result2.setErrors("No tags");
                    try {
                        uPushTagCallback.onMessage(false, result2);
                    } catch (Throwable th10) {
                        UPLog.e("TagManager", th10);
                    }
                } catch (Throwable th11) {
                    th = th11;
                }
            }
        });
    }

    public void deleteTags(final UPushTagCallback<ITagManager.Result> uPushTagCallback, final String... strArr) {
        b.b(new Runnable() { // from class: com.umeng.message.tag.TagManager.2
            @Override // java.lang.Runnable
            public final void run() {
                ITagManager.Result result;
                int i10;
                ITagManager.Result result2 = new ITagManager.Result();
                boolean z10 = false;
                try {
                    Application a10 = y.a();
                    String[] strArr2 = strArr;
                    if (strArr2 != null && strArr2.length > 0) {
                        int length = strArr2.length;
                        while (i10 < length) {
                            byte[] bytes = strArr2[i10].getBytes();
                            i10 = (bytes != null && bytes.length <= 128 && bytes.length > 0) ? i10 + 1 : 0;
                            result2.setErrors("tag length must be 1~128 byte.");
                            try {
                                return;
                            } catch (Throwable th) {
                                return;
                            }
                        }
                    }
                    if (!MessageSharedPrefs.getInstance(a10).a("tag_del_")) {
                        UPLog.e("TagManager", "interval limit");
                        result2.setErrors("interval limit");
                        try {
                            uPushTagCallback.onMessage(false, result2);
                            return;
                        } catch (Throwable th2) {
                            UPLog.e("TagManager", th2);
                            return;
                        }
                    }
                    if (TagManager.b()) {
                        result2.setErrors("tag server disable.");
                        try {
                            uPushTagCallback.onMessage(false, result2);
                            return;
                        } catch (Throwable th3) {
                            UPLog.e("TagManager", th3);
                            return;
                        }
                    }
                    if (TagManager.a()) {
                        result2.setErrors("check request failed.");
                        try {
                            uPushTagCallback.onMessage(false, result2);
                            return;
                        } catch (Throwable th4) {
                            UPLog.e("TagManager", th4);
                            return;
                        }
                    }
                    String[] strArr3 = strArr;
                    if (strArr3 == null || strArr3.length == 0) {
                        UPLog.e("TagManager", "No tags.");
                        result2.setErrors("No tags.");
                        try {
                            uPushTagCallback.onMessage(true, result2);
                            return;
                        } catch (Throwable th5) {
                            UPLog.e("TagManager", th5);
                            return;
                        }
                    }
                    try {
                        JSONObject d10 = TagManager.d();
                        String[] strArr4 = strArr;
                        d10.put("tags", strArr4 == null ? "" : bi.a(Arrays.asList(strArr4)));
                        be unused = TagManager.this.f12246a;
                        String[] strArr5 = strArr;
                        Application a11 = y.a();
                        result = new ITagManager.Result(g.a(d10, "https://msg.umengcloud.com/v3/tag/delete", UMUtils.getAppkey(a11)));
                        if (TextUtils.equals(result.status, ITagManager.SUCCESS)) {
                            MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a11);
                            if (strArr5 != null && strArr5.length != 0) {
                                Set<String> b10 = messageSharedPrefs.f11344b.b("tags", new HashSet());
                                for (String str : strArr5) {
                                    b10.remove(str);
                                }
                                messageSharedPrefs.f11344b.a("tags", b10);
                            }
                            messageSharedPrefs.a(result.remain);
                            messageSharedPrefs.a("tag_del_", result.interval);
                        }
                    } catch (Exception e10) {
                        e = e10;
                    }
                    try {
                        try {
                            z10 = result.status.equals(ITagManager.SUCCESS);
                        } catch (Exception e11) {
                            e = e11;
                            result2 = result;
                            UPLog.e("TagManager", e);
                            result = result2;
                            uPushTagCallback.onMessage(z10, result);
                        } catch (Throwable th6) {
                            th = th6;
                            result2 = result;
                            try {
                                UPLog.e("TagManager", th);
                                try {
                                    uPushTagCallback.onMessage(false, result2);
                                    return;
                                } catch (Throwable th7) {
                                    UPLog.e("TagManager", th7);
                                    return;
                                }
                            } finally {
                                try {
                                    uPushTagCallback.onMessage(false, result2);
                                } catch (Throwable th8) {
                                    UPLog.e("TagManager", th8);
                                }
                            }
                        }
                        uPushTagCallback.onMessage(z10, result);
                    } catch (Throwable th9) {
                        UPLog.e("TagManager", th9);
                    }
                } catch (Throwable th10) {
                    th = th10;
                }
            }
        });
    }

    public void getTags(final UPushTagCallback<List<String>> uPushTagCallback) {
        b.b(new Runnable() { // from class: com.umeng.message.tag.TagManager.3
            @Override // java.lang.Runnable
            public final void run() {
                Pair pair;
                ArrayList arrayList = new ArrayList();
                boolean z10 = false;
                try {
                    if (!MessageSharedPrefs.getInstance(y.a()).a("tag_add_")) {
                        UPLog.e("TagManager", "interval limit");
                        try {
                            return;
                        } catch (Throwable th) {
                            return;
                        }
                    }
                    if (TagManager.b()) {
                        try {
                            uPushTagCallback.onMessage(false, arrayList);
                            return;
                        } catch (Throwable th2) {
                            UPLog.e("TagManager", th2);
                            return;
                        }
                    }
                    boolean a10 = TagManager.a();
                    try {
                        if (a10) {
                            try {
                                uPushTagCallback.onMessage(false, arrayList);
                                return;
                            } catch (Throwable th3) {
                                UPLog.e("TagManager", th3);
                                return;
                            }
                        }
                        try {
                            be unused = TagManager.this.f12246a;
                            JSONObject d10 = TagManager.d();
                            Application a11 = y.a();
                            JSONObject a12 = g.a(d10, "https://msg.umengcloud.com/v3/tag/get", UMUtils.getAppkey(a11));
                            if (a12 == null) {
                                pair = new Pair(Boolean.FALSE, null);
                            } else {
                                ITagManager.Result result = new ITagManager.Result(a12);
                                boolean equals = TextUtils.equals(result.status, ITagManager.SUCCESS);
                                if (equals) {
                                    MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a11);
                                    messageSharedPrefs.a(result.remain);
                                    messageSharedPrefs.a("tag_get_", result.interval);
                                    String optString = a12.optString("tags");
                                    if (optString.length() > 0) {
                                        String[] split = optString.split(",");
                                        List asList = Arrays.asList(split);
                                        messageSharedPrefs.f11344b.a("tags");
                                        messageSharedPrefs.a(split);
                                        pair = new Pair(Boolean.TRUE, asList);
                                    }
                                }
                                pair = new Pair(Boolean.valueOf(equals), null);
                            }
                            a10 = ((Boolean) pair.first).booleanValue();
                        } catch (Exception e10) {
                            e = e10;
                            a10 = false;
                        }
                        try {
                            List list = (List) pair.second;
                            if (list != null && !list.isEmpty()) {
                                arrayList.addAll(list);
                            }
                        } catch (Exception e11) {
                            e = e11;
                            UPLog.e("TagManager", "getTags error:", e);
                            uPushTagCallback.onMessage(a10, arrayList);
                        }
                        try {
                            uPushTagCallback.onMessage(a10, arrayList);
                        } catch (Throwable th4) {
                            UPLog.e("TagManager", th4);
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z10 = a10;
                        try {
                            UPLog.e("TagManager", th);
                            try {
                                uPushTagCallback.onMessage(z10, arrayList);
                            } catch (Throwable th6) {
                                UPLog.e("TagManager", th6);
                            }
                        } finally {
                            try {
                                uPushTagCallback.onMessage(z10, arrayList);
                            } catch (Throwable th7) {
                                UPLog.e("TagManager", th7);
                            }
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                }
            }
        });
    }

    public static /* synthetic */ boolean a() {
        if (TextUtils.isEmpty(d.o(y.a()))) {
            UPLog.e("TagManager", "utdid empty.");
            return true;
        }
        if (f.b()) {
            UPLog.i("TagManager", "check tag failed, silent mode!");
            return true;
        }
        if (!TextUtils.isEmpty(PushAgent.getInstance(y.a()).getRegistrationId())) {
            return false;
        }
        UPLog.e("TagManager", "deviceToken empty.");
        return true;
    }
}
