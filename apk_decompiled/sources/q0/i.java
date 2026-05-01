package q0;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/* loaded from: classes.dex */
public class i implements t0.c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f18169a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18170b;

    /* renamed from: c, reason: collision with root package name */
    public final File f18171c;

    /* renamed from: d, reason: collision with root package name */
    public final int f18172d;

    /* renamed from: e, reason: collision with root package name */
    public final t0.c f18173e;

    /* renamed from: f, reason: collision with root package name */
    public a f18174f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f18175g;

    public i(Context context, String str, File file, int i10, t0.c cVar) {
        this.f18169a = context;
        this.f18170b = str;
        this.f18171c = file;
        this.f18172d = i10;
        this.f18173e = cVar;
    }

    @Override // t0.c
    public synchronized t0.b A() {
        if (!this.f18175g) {
            c();
            this.f18175g = true;
        }
        return this.f18173e.A();
    }

    public final void a(File file) {
        ReadableByteChannel channel;
        if (this.f18170b != null) {
            channel = Channels.newChannel(this.f18169a.getAssets().open(this.f18170b));
        } else {
            if (this.f18171c == null) {
                throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
            }
            channel = new FileInputStream(this.f18171c).getChannel();
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f18169a.getCacheDir());
        createTempFile.deleteOnExit();
        s0.d.a(channel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        if (createTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    public void b(a aVar) {
        this.f18174f = aVar;
    }

    public final void c() {
        String databaseName = getDatabaseName();
        File databasePath = this.f18169a.getDatabasePath(databaseName);
        a aVar = this.f18174f;
        s0.a aVar2 = new s0.a(databaseName, this.f18169a.getFilesDir(), aVar == null || aVar.f18112j);
        try {
            aVar2.b();
            if (!databasePath.exists()) {
                try {
                    a(databasePath);
                    return;
                } catch (IOException e10) {
                    throw new RuntimeException("Unable to copy database file.", e10);
                }
            }
            if (this.f18174f == null) {
                return;
            }
            try {
                int c10 = s0.c.c(databasePath);
                int i10 = this.f18172d;
                if (c10 == i10) {
                    return;
                }
                if (this.f18174f.a(c10, i10)) {
                    return;
                }
                if (this.f18169a.deleteDatabase(databaseName)) {
                    try {
                        a(databasePath);
                    } catch (IOException unused) {
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to delete database file (");
                    sb.append(databaseName);
                    sb.append(") for a copy destructive migration.");
                }
            } catch (IOException unused2) {
            }
        } finally {
            aVar2.c();
        }
    }

    @Override // t0.c, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f18173e.close();
        this.f18175g = false;
    }

    @Override // t0.c
    public String getDatabaseName() {
        return this.f18173e.getDatabaseName();
    }

    @Override // t0.c
    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.f18173e.setWriteAheadLoggingEnabled(z10);
    }
}
