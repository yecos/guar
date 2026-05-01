package j6;

import mobile.com.requestframe.utils.response.Channel;

/* loaded from: classes3.dex */
public interface f extends l5.a {

    public static final class a {
        public static /* synthetic */ void a(f fVar, Channel channel, String str, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: matchProgramInfo");
            }
            if ((i10 & 2) != 0) {
                str = "";
            }
            fVar.b(channel, str);
        }
    }

    void b(Channel channel, String str);
}
