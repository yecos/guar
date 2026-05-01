package t0;

import android.database.Cursor;
import android.os.CancellationSignal;
import java.io.Closeable;
import java.util.List;

/* loaded from: classes.dex */
public interface b extends Closeable {
    Cursor B(String str);

    boolean G();

    void beginTransaction();

    f compileStatement(String str);

    void endTransaction();

    void execSQL(String str);

    String getPath();

    List i();

    boolean isOpen();

    Cursor k(e eVar, CancellationSignal cancellationSignal);

    void l(String str, Object[] objArr);

    void setTransactionSuccessful();

    Cursor w(e eVar);
}
