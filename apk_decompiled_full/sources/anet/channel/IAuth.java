package anet.channel;

/* loaded from: classes.dex */
public interface IAuth {

    public interface AuthCallback {
        void onAuthFail(int i10, String str);

        void onAuthSuccess();
    }

    void auth(Session session, AuthCallback authCallback);
}
