package com.umeng.message.proguard;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.umeng.message.proguard.bx;

/* loaded from: classes3.dex */
public final class cv implements bx.f {

    /* renamed from: a, reason: collision with root package name */
    public Uri f11827a;

    /* renamed from: b, reason: collision with root package name */
    public SurfaceHolder f11828b;

    /* renamed from: c, reason: collision with root package name */
    int f11829c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11830d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11831e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11832f;

    /* renamed from: g, reason: collision with root package name */
    public int f11833g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f11834h;

    /* renamed from: i, reason: collision with root package name */
    public long f11835i;

    /* renamed from: j, reason: collision with root package name */
    public int f11836j;

    /* renamed from: k, reason: collision with root package name */
    public int f11837k;

    /* renamed from: l, reason: collision with root package name */
    public bx.e f11838l;

    /* renamed from: m, reason: collision with root package name */
    private MediaPlayer f11839m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f11840n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f11841o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f11842p;

    /* renamed from: q, reason: collision with root package name */
    private long f11843q;

    private void d(int i10) {
        MediaPlayer mediaPlayer = this.f11839m;
        if (mediaPlayer != null) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    mediaPlayer.seekTo(i10, 3);
                } else {
                    mediaPlayer.seekTo(i10);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void f() {
        MediaPlayer mediaPlayer = this.f11839m;
        if (mediaPlayer != null) {
            try {
                if (this.f11830d) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                } else {
                    mediaPlayer.setVolume(1.0f, 1.0f);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void g() {
        if (this.f11827a == null) {
            ce.a("VideoPlayer", "init uri null!");
            return;
        }
        SurfaceHolder surfaceHolder = this.f11828b;
        if (surfaceHolder == null) {
            ce.a("VideoPlayer", "init surfaceHolder null!");
            this.f11842p = true;
            return;
        }
        try {
            Surface surface = surfaceHolder.getSurface();
            if (!surface.isValid()) {
                ce.a("VideoPlayer", "init surface not valid!");
                this.f11842p = true;
                return;
            }
            MediaPlayer mediaPlayer = this.f11839m;
            if (mediaPlayer == null) {
                this.f11839m = new MediaPlayer();
            } else {
                mediaPlayer.reset();
            }
            this.f11839m.setAudioStreamType(3);
            this.f11839m.setDataSource(this.f11827a.getPath());
            f();
            this.f11839m.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.umeng.message.proguard.cv.2
                @Override // android.media.MediaPlayer.OnInfoListener
                public final boolean onInfo(MediaPlayer mediaPlayer2, int i10, int i11) {
                    ce.a("VideoPlayer", "onInfo what:" + i10 + " extra:" + i11);
                    return false;
                }
            });
            this.f11839m.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.umeng.message.proguard.cv.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer2) {
                    try {
                        bx.e eVar = cv.this.f11838l;
                        if (eVar != null) {
                            eVar.d();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    try {
                        cv cvVar = cv.this;
                        int i10 = cvVar.f11833g;
                        cvVar.f11829c = i10;
                        cvVar.c(i10);
                        cv cvVar2 = cv.this;
                        cvVar2.f11829c = 0;
                        if (!cvVar2.f11831e) {
                            mediaPlayer2.seekTo(0);
                            return;
                        }
                        mediaPlayer2.start();
                        cv cvVar3 = cv.this;
                        cvVar3.b(cvVar3.f11829c);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            });
            this.f11839m.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.umeng.message.proguard.cv.4
                @Override // android.media.MediaPlayer.OnErrorListener
                public final boolean onError(MediaPlayer mediaPlayer2, int i10, int i11) {
                    ce.d("VideoPlayer", "onError what:" + i10 + " extra:" + i11);
                    try {
                        cv.this.a(false);
                        bx.e eVar = cv.this.f11838l;
                        if (eVar != null) {
                            eVar.a("media player error, what:" + i10 + " extra:" + i11);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    return false;
                }
            });
            this.f11839m.setVideoScalingMode(1);
            this.f11839m.setSurface(surface);
            this.f11839m.setScreenOnWhilePlaying(true);
            this.f11839m.setLooping(false);
            this.f11839m.setOnPreparedListener(null);
            this.f11839m.prepare();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void a() {
        try {
            g();
            if (this.f11839m != null) {
                d(this.f11829c);
                ce.a("VideoPlayer", "preview position:" + this.f11829c);
                if (this.f11842p) {
                    c();
                    this.f11842p = false;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized boolean b() {
        if (!this.f11840n) {
            c();
        }
        return !this.f11840n;
    }

    public final synchronized void c() {
        MediaPlayer mediaPlayer;
        try {
            if (!this.f11841o && this.f11840n && (mediaPlayer = this.f11839m) != null && !mediaPlayer.isPlaying()) {
                this.f11839m.start();
                this.f11840n = false;
                this.f11829c = this.f11839m.getCurrentPosition();
                ce.a("VideoPlayer", "start position:" + this.f11829c);
                b(this.f11829c);
                bx.e eVar = this.f11838l;
                if (eVar != null) {
                    eVar.b();
                }
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            MediaPlayer mediaPlayer2 = this.f11839m;
            if (mediaPlayer2 == null || !mediaPlayer2.isPlaying()) {
                g();
                if (this.f11839m != null) {
                    d(this.f11829c);
                    ce.a("VideoPlayer", "start position:" + this.f11829c);
                    this.f11839m.start();
                    b(this.f11829c);
                    bx.e eVar2 = this.f11838l;
                    if (eVar2 != null) {
                        eVar2.b();
                    }
                }
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
            } finally {
                this.f11841o = false;
            }
        }
    }

    public final int e() {
        MediaPlayer mediaPlayer = this.f11839m;
        if (mediaPlayer != null) {
            try {
                this.f11829c = mediaPlayer.getCurrentPosition();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this.f11829c;
    }

    public final void b(boolean z10) {
        this.f11830d = z10;
        f();
    }

    public final synchronized void b(int i10) {
        this.f11834h = true;
        this.f11843q = i10;
    }

    public final boolean d() {
        MediaPlayer mediaPlayer = this.f11839m;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            return mediaPlayer.isPlaying();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final synchronized void a(boolean z10) {
        try {
            if (this.f11839m != null) {
                c(z10);
                this.f11839m.release();
            }
        } finally {
            try {
                this.f11841o = false;
                this.f11840n = false;
            } finally {
            }
        }
        this.f11841o = false;
        this.f11840n = false;
    }

    public final synchronized void a(int i10) {
        if (d()) {
            c(i10);
            b(i10);
        }
    }

    private synchronized void c(boolean z10) {
        bx.e eVar;
        this.f11841o = true;
        MediaPlayer mediaPlayer = this.f11839m;
        if (mediaPlayer != null) {
            try {
                this.f11829c = mediaPlayer.getCurrentPosition();
                mediaPlayer.stop();
                ce.a("VideoPlayer", "stop position:" + this.f11829c);
                c(this.f11829c);
                if (!this.f11840n && z10 && (eVar = this.f11838l) != null) {
                    eVar.c();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final synchronized void c(int i10) {
        long j10 = this.f11843q;
        if (j10 >= 0) {
            this.f11835i += i10 - j10;
        }
        this.f11843q = -1L;
    }
}
