package d2;

import com.bigbee.db.EventDbModel;

/* loaded from: classes.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void a(c cVar, b bVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
            }
            if ((i10 & 1) != 0) {
                bVar = null;
            }
            cVar.c(bVar);
        }
    }

    void a(EventDbModel eventDbModel);

    void b(EventDbModel eventDbModel);

    void c(b bVar);
}
