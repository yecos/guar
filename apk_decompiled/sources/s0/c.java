package s0;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class c {
    public static void a(t0.b bVar) {
        ArrayList<String> arrayList = new ArrayList();
        Cursor B = bVar.B("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (B.moveToNext()) {
            try {
                arrayList.add(B.getString(0));
            } catch (Throwable th) {
                B.close();
                throw th;
            }
        }
        B.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                bVar.execSQL("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    public static Cursor b(q0.e eVar, t0.e eVar2, boolean z10, CancellationSignal cancellationSignal) {
        Cursor q10 = eVar.q(eVar2, cancellationSignal);
        if (!z10 || !(q10 instanceof AbstractWindowedCursor)) {
            return q10;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) q10;
        int count = abstractWindowedCursor.getCount();
        return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? b.a(abstractWindowedCursor) : q10;
    }

    public static int c(File file) {
        AbstractInterruptibleChannel abstractInterruptibleChannel = null;
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            FileChannel channel = new FileInputStream(file).getChannel();
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(allocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            allocate.rewind();
            int i10 = allocate.getInt();
            channel.close();
            return i10;
        } catch (Throwable th) {
            if (0 != 0) {
                abstractInterruptibleChannel.close();
            }
            throw th;
        }
    }
}
