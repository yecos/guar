package q9;

import com.hpplay.cybergarage.upnp.Argument;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import t9.i;

/* loaded from: classes3.dex */
public abstract class d {
    public static final long a(Reader reader, Writer writer, int i10) {
        i.g(reader, "<this>");
        i.g(writer, Argument.OUT);
        char[] cArr = new char[i10];
        int read = reader.read(cArr);
        long j10 = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j10 += read;
            read = reader.read(cArr);
        }
        return j10;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        return a(reader, writer, i10);
    }

    public static final String c(Reader reader) {
        i.g(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        i.f(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }
}
