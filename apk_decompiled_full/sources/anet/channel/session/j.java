package anet.channel.session;

import android.content.Context;
import anet.channel.Session;
import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import org.android.spdy.AccsSSLCallback;
import org.android.spdy.SpdyProtocol;

/* loaded from: classes.dex */
class j implements AccsSSLCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f4117a;

    public j(TnetSpdySession tnetSpdySession) {
        this.f4117a = tnetSpdySession;
    }

    @Override // org.android.spdy.AccsSSLCallback
    public byte[] getSSLPublicKey(int i10, byte[] bArr) {
        byte[] bArr2;
        Context context;
        try {
            TnetSpdySession tnetSpdySession = this.f4117a;
            ISecurity iSecurity = tnetSpdySession.G;
            context = ((Session) tnetSpdySession).f3812a;
            bArr2 = iSecurity.decrypt(context, ISecurity.CIPHER_ALGORITHM_AES128, SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr);
            if (bArr2 != null) {
                try {
                    if (ALog.isPrintLog(2)) {
                        ALog.i("getSSLPublicKey", null, "decrypt", new String(bArr2));
                    }
                } catch (Throwable th) {
                    th = th;
                    ALog.e("awcn.TnetSpdySession", "getSSLPublicKey", null, th, new Object[0]);
                    return bArr2;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bArr2 = null;
        }
        return bArr2;
    }
}
