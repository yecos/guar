package anet.channel;

/* loaded from: classes.dex */
public interface SessionGetCallback {
    void onSessionGetFail();

    void onSessionGetSuccess(Session session);
}
