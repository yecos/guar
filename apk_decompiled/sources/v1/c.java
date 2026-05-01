package v1;

import com.advertlib.bean.AdInfo;
import java.util.List;

/* loaded from: classes.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ AdInfo a(c cVar, String str, List list, String str2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRandomAdInfo");
            }
            if ((i10 & 4) != 0) {
                str2 = null;
            }
            return cVar.a(str, list, str2);
        }
    }

    AdInfo a(String str, List list, String str2);
}
