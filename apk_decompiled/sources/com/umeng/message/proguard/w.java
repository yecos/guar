package com.umeng.message.proguard;

import android.app.Application;
import android.content.ContentProviderOperation;
import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UPLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class w implements UMLogDataProtocol {

    /* renamed from: b, reason: collision with root package name */
    private static final UMLogDataProtocol f12215b = new w();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f12216a = false;

    private w() {
    }

    public static UMLogDataProtocol a() {
        return f12215b;
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public final void removeCacheData(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(obj.toString()).optJSONObject("content");
            if (optJSONObject == null) {
                return;
            }
            Application a10 = y.a();
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            JSONArray optJSONArray = optJSONObject.optJSONArray("push");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    JSONObject jSONObject = (JSONObject) optJSONArray.get(i10);
                    arrayList.add(ContentProviderOperation.newDelete(h.d(a10)).withSelection("MsgId=? And ActionType=?", new String[]{jSONObject.optString("msg_id"), String.valueOf(jSONObject.optInt("action_type"))}).build());
                }
            }
            a10.getContentResolver().applyBatch(h.f(a10), arrayList);
        } catch (Throwable th) {
            UPLog.e("Event", th);
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public final JSONObject setupReportData(long j10) {
        return null;
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public final void workEvent(Object obj, int i10) {
        int i11;
        JSONObject buildEnvelopeWithExtHeader;
        JSONArray optJSONArray;
        JSONObject buildEnvelopeWithExtHeader2;
        JSONObject buildEnvelopeWithExtHeader3;
        JSONObject jSONObject;
        JSONObject buildEnvelopeWithExtHeader4;
        if (obj == null) {
        }
        int i12 = 0;
        try {
            switch (i10) {
                case 16385:
                    Application a10 = y.a();
                    JSONObject jSONObject2 = new JSONObject(obj.toString());
                    JSONObject optJSONObject = jSONObject2.optJSONObject("content");
                    if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("push")) == null || optJSONArray.length() <= 0) {
                        i11 = -1;
                    } else {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray.get(0);
                        int optInt = jSONObject3.optInt("action_type");
                        if (optInt != 70 && optInt != 71) {
                            if (optInt == 0) {
                                ((aw) PushAgent.getInstance(a10).getMessageNotifyApi()).a(jSONObject3);
                            }
                            bb.a(a10).a(jSONObject3.optString("msg_id"), optInt, jSONObject3.optLong("ts"));
                        }
                        i11 = optInt;
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("header");
                    if (optJSONObject2 == null || optJSONObject == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a10, optJSONObject2, optJSONObject, "umpx_push_logs", com.umeng.analytics.pro.bt.aD, MsgConstant.SDK_VERSION)) == null || buildEnvelopeWithExtHeader.has("exception") || i11 == 70 || i11 == 71) {
                        break;
                    } else {
                        try {
                            removeCacheData(jSONObject2);
                            break;
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                            return;
                        }
                    }
                case 16386:
                    Application a11 = y.a();
                    JSONObject jSONObject4 = new JSONObject(obj.toString());
                    JSONObject optJSONObject3 = jSONObject4.optJSONObject("header");
                    JSONObject optJSONObject4 = jSONObject4.optJSONObject("content");
                    if (optJSONObject3 != null && optJSONObject4 != null && (buildEnvelopeWithExtHeader2 = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a11, optJSONObject3, optJSONObject4, "umpx_push_launch", com.umeng.analytics.pro.bt.aD, MsgConstant.SDK_VERSION)) != null && !buildEnvelopeWithExtHeader2.has("exception")) {
                        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a11);
                        messageSharedPrefs.f11344b.a(com.umeng.analytics.pro.f.f10334p, System.currentTimeMillis());
                        try {
                            int parseInt = Integer.parseInt(UMEnvelopeBuild.imprintProperty(a11, "launch_policy", "-1"));
                            UPLog.i("Event", "launch policy:", Integer.valueOf(parseInt));
                            if (parseInt > 0) {
                                messageSharedPrefs.f11344b.a("launch_send_policy", parseInt);
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            int parseInt2 = Integer.parseInt(UMEnvelopeBuild.imprintProperty(a11, "tag_policy", "-1"));
                            UPLog.i("Event", "tag policy:", Integer.valueOf(parseInt2));
                            if (parseInt2 > 0) {
                                messageSharedPrefs.f11344b.a("tag_send_policy", parseInt2);
                                break;
                            }
                        } catch (Throwable unused2) {
                            return;
                        }
                    }
                    break;
                case 16387:
                    Application a12 = y.a();
                    JSONObject jSONObject5 = new JSONObject(obj.toString());
                    JSONObject optJSONObject5 = jSONObject5.optJSONObject("header");
                    JSONObject optJSONObject6 = jSONObject5.optJSONObject("content");
                    if (optJSONObject5 != null && optJSONObject6 != null && (buildEnvelopeWithExtHeader3 = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a12, optJSONObject5, optJSONObject6, "umpx_push_register", com.umeng.analytics.pro.bt.aD, MsgConstant.SDK_VERSION)) != null && !buildEnvelopeWithExtHeader3.has("exception")) {
                        MessageSharedPrefs.getInstance(a12).f11344b.a("has_register", true);
                        break;
                    }
                    break;
                case 16388:
                    Application a13 = y.a();
                    JSONObject jSONObject6 = new JSONObject(obj.toString());
                    JSONObject optJSONObject7 = jSONObject6.optJSONObject("jsonHeader");
                    JSONObject optJSONObject8 = jSONObject6.optJSONObject("jsonBody");
                    String optString = jSONObject6.optString("um_px_path");
                    if (optJSONObject7 != null && optJSONObject8 != null) {
                        optJSONObject7.put(com.umeng.analytics.pro.bt.aR, MsgConstant.SDK_VERSION);
                        optJSONObject7.put("din", d.c(y.a()));
                        optJSONObject7.put("push_switch", d.p(y.a()));
                        JSONArray optJSONArray2 = optJSONObject8.optJSONArray("push");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0 && (i12 = (jSONObject = (JSONObject) optJSONArray2.get(0)).optInt("action_type")) == 0) {
                            ((aw) PushAgent.getInstance(a13).getMessageNotifyApi()).a(jSONObject);
                        }
                        JSONObject buildEnvelopeWithExtHeader5 = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a13, optJSONObject7, optJSONObject8, optString, com.umeng.analytics.pro.bt.aD, MsgConstant.SDK_VERSION);
                        if (buildEnvelopeWithExtHeader5 != null && !buildEnvelopeWithExtHeader5.has("exception") && i12 != 6 && i12 != 7) {
                            a(a13, optJSONObject8.getJSONArray("push"));
                            break;
                        }
                    }
                    break;
                case 16389:
                    Application a14 = y.a();
                    JSONObject jSONObject7 = new JSONObject(obj.toString());
                    JSONObject optJSONObject9 = jSONObject7.optJSONObject("header");
                    JSONObject optJSONObject10 = jSONObject7.optJSONObject("content");
                    if (optJSONObject9 != null && optJSONObject10 != null && (buildEnvelopeWithExtHeader4 = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a14, optJSONObject9, optJSONObject10, "umpx_push_logs", com.umeng.analytics.pro.bt.aD, MsgConstant.SDK_VERSION)) != null && !buildEnvelopeWithExtHeader4.has("exception")) {
                        z.a();
                        z.a(optJSONObject10.getJSONArray("push"));
                        break;
                    }
                    break;
                case 16390:
                    JSONObject jSONObject8 = new JSONObject(obj.toString());
                    Application a15 = y.a();
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put(com.umeng.analytics.pro.bt.aR, MsgConstant.SDK_VERSION);
                    jSONObject9.put("din", d.c(a15));
                    jSONObject9.put("push_switch", d.p(a15));
                    JSONObject jSONObject10 = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    jSONObject8.put("pa", "");
                    jSONObject8.put("device_token", PushAgent.getInstance(a15).getRegistrationId());
                    jSONObject8.put("msg_id", "");
                    jSONObject8.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject8);
                    jSONObject10.put("push", jSONArray);
                    UMEnvelopeBuild.buildEnvelopeWithExtHeader(a15, jSONObject9, jSONObject10, "umpx_push_logs", com.umeng.analytics.pro.bt.aD, MsgConstant.SDK_VERSION);
                    break;
                case 16391:
                case 16392:
                    Application a16 = y.a();
                    JSONObject jSONObject11 = new JSONObject(obj.toString());
                    JSONObject optJSONObject11 = jSONObject11.optJSONObject("content");
                    JSONObject optJSONObject12 = jSONObject11.optJSONObject("header");
                    if (optJSONObject12 != null && optJSONObject11 != null) {
                        UMEnvelopeBuild.buildEnvelopeWithExtHeader(a16, optJSONObject12, optJSONObject11, "umpx_push_logs", com.umeng.analytics.pro.bt.aD, MsgConstant.SDK_VERSION);
                    }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void a(Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i10);
                    arrayList.add(ContentProviderOperation.newDelete(h.d(context)).withSelection("MsgId=? And ActionType=?", new String[]{jSONObject.optString("msg_id"), String.valueOf(jSONObject.optInt("action_type"))}).build());
                }
                context.getContentResolver().applyBatch(h.f(context), arrayList);
            } catch (Throwable th) {
                UPLog.e("Event", "remove cache error:" + th.getMessage());
            }
        }
    }
}
