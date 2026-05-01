package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.util.Log;
import androidx.media.AudioAttributesCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class MediaControllerCompat {

    /* renamed from: a, reason: collision with root package name */
    public final b f607a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaSessionCompat.Token f608b;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f609c = new ConcurrentHashMap();

    public static class MediaControllerImplApi21 implements b {

        /* renamed from: a, reason: collision with root package name */
        public final MediaController f610a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f611b = new Object();

        /* renamed from: c, reason: collision with root package name */
        public final List f612c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public HashMap f613d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        public final MediaSessionCompat.Token f614e;

        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a, reason: collision with root package name */
            public WeakReference f615a;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.f615a = new WeakReference(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i10, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f615a.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.f611b) {
                    mediaControllerImplApi21.f614e.d(b.a.i0(o.o.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                    mediaControllerImplApi21.f614e.e(y0.a.b(bundle, "android.support.v4.media.session.SESSION_TOKEN2"));
                    mediaControllerImplApi21.f();
                }
            }
        }

        public static class a extends a.c {
            public a(a aVar) {
                super(aVar);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void G(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void P(Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void W(CharSequence charSequence) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void l(List list) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void t() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void v(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f614e = token;
            this.f610a = new MediaController(context, n.a(token.c()));
            if (token.a() == null) {
                g();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public final void a(a aVar) {
            this.f610a.unregisterCallback(aVar.f616a);
            synchronized (this.f611b) {
                if (this.f614e.a() != null) {
                    try {
                        a aVar2 = (a) this.f613d.remove(aVar);
                        if (aVar2 != null) {
                            aVar.f618c = null;
                            this.f614e.a().R(aVar2);
                        }
                    } catch (RemoteException e10) {
                        Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e10);
                    }
                } else {
                    this.f612c.remove(aVar);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public PendingIntent b() {
            PendingIntent sessionActivity;
            sessionActivity = this.f610a.getSessionActivity();
            return sessionActivity;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public e c() {
            MediaController.TransportControls transportControls;
            transportControls = this.f610a.getTransportControls();
            return new f(transportControls);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public final void d(a aVar, Handler handler) {
            this.f610a.registerCallback(aVar.f616a, handler);
            synchronized (this.f611b) {
                if (this.f614e.a() != null) {
                    a aVar2 = new a(aVar);
                    this.f613d.put(aVar, aVar2);
                    aVar.f618c = aVar2;
                    try {
                        this.f614e.a().H(aVar2);
                        aVar.m(13, null, null);
                    } catch (RemoteException e10) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e10);
                    }
                } else {
                    aVar.f618c = null;
                    this.f612c.add(aVar);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public PlaybackStateCompat e() {
            PlaybackState playbackState;
            if (this.f614e.a() != null) {
                try {
                    return this.f614e.a().e();
                } catch (RemoteException e10) {
                    Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e10);
                }
            }
            playbackState = this.f610a.getPlaybackState();
            if (playbackState != null) {
                return PlaybackStateCompat.a(playbackState);
            }
            return null;
        }

        public void f() {
            if (this.f614e.a() == null) {
                return;
            }
            for (a aVar : this.f612c) {
                a aVar2 = new a(aVar);
                this.f613d.put(aVar, aVar2);
                aVar.f618c = aVar2;
                try {
                    this.f614e.a().H(aVar2);
                    aVar.m(13, null, null);
                } catch (RemoteException e10) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e10);
                }
            }
            this.f612c.clear();
        }

        public final void g() {
            h("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public MediaMetadataCompat getMetadata() {
            MediaMetadata metadata;
            metadata = this.f610a.getMetadata();
            if (metadata != null) {
                return MediaMetadataCompat.b(metadata);
            }
            return null;
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.f610a.sendCommand(str, bundle, resultReceiver);
        }
    }

    public static abstract class a implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        public final MediaController.Callback f616a;

        /* renamed from: b, reason: collision with root package name */
        public b f617b;

        /* renamed from: c, reason: collision with root package name */
        public android.support.v4.media.session.a f618c;

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a, reason: collision with other inner class name */
        public static class C0008a extends MediaController.Callback {

            /* renamed from: a, reason: collision with root package name */
            public final WeakReference f619a;

            public C0008a(a aVar) {
                this.f619a = new WeakReference(aVar);
            }

            @Override // android.media.session.MediaController.Callback
            public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
                int playbackType;
                AudioAttributes audioAttributes;
                int volumeControl;
                int maxVolume;
                int currentVolume;
                a aVar = (a) this.f619a.get();
                if (aVar != null) {
                    playbackType = playbackInfo.getPlaybackType();
                    audioAttributes = playbackInfo.getAudioAttributes();
                    AudioAttributesCompat c10 = AudioAttributesCompat.c(audioAttributes);
                    volumeControl = playbackInfo.getVolumeControl();
                    maxVolume = playbackInfo.getMaxVolume();
                    currentVolume = playbackInfo.getCurrentVolume();
                    aVar.a(new d(playbackType, c10, volumeControl, maxVolume, currentVolume));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onExtrasChanged(Bundle bundle) {
                MediaSessionCompat.c(bundle);
                a aVar = (a) this.f619a.get();
                if (aVar != null) {
                    aVar.c(bundle);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onMetadataChanged(MediaMetadata mediaMetadata) {
                a aVar = (a) this.f619a.get();
                if (aVar != null) {
                    aVar.d(MediaMetadataCompat.b(mediaMetadata));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onPlaybackStateChanged(PlaybackState playbackState) {
                a aVar = (a) this.f619a.get();
                if (aVar == null || aVar.f618c != null) {
                    return;
                }
                aVar.e(PlaybackStateCompat.a(playbackState));
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueChanged(List list) {
                a aVar = (a) this.f619a.get();
                if (aVar != null) {
                    aVar.f(MediaSessionCompat.QueueItem.b(list));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueTitleChanged(CharSequence charSequence) {
                a aVar = (a) this.f619a.get();
                if (aVar != null) {
                    aVar.g(charSequence);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionDestroyed() {
                a aVar = (a) this.f619a.get();
                if (aVar != null) {
                    aVar.i();
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionEvent(String str, Bundle bundle) {
                MediaSessionCompat.c(bundle);
                a aVar = (a) this.f619a.get();
                if (aVar != null) {
                    if (aVar.f618c == null || Build.VERSION.SDK_INT >= 23) {
                        aVar.j(str, bundle);
                    }
                }
            }
        }

        public class b extends Handler {

            /* renamed from: a, reason: collision with root package name */
            public boolean f620a;

            public b(Looper looper) {
                super(looper);
                this.f620a = false;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (this.f620a) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.c(data);
                            a.this.j((String) message.obj, data);
                            break;
                        case 2:
                            a.this.e((PlaybackStateCompat) message.obj);
                            break;
                        case 3:
                            a.this.d((MediaMetadataCompat) message.obj);
                            break;
                        case 4:
                            a.this.a((d) message.obj);
                            break;
                        case 5:
                            a.this.f((List) message.obj);
                            break;
                        case 6:
                            a.this.g((CharSequence) message.obj);
                            break;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.c(bundle);
                            a.this.c(bundle);
                            break;
                        case 8:
                            a.this.i();
                            break;
                        case 9:
                            a.this.h(((Integer) message.obj).intValue());
                            break;
                        case 11:
                            a.this.b(((Boolean) message.obj).booleanValue());
                            break;
                        case 12:
                            a.this.l(((Integer) message.obj).intValue());
                            break;
                        case 13:
                            a.this.k();
                            break;
                    }
                }
            }
        }

        public static class c extends a.AbstractBinderC0010a {

            /* renamed from: a, reason: collision with root package name */
            public final WeakReference f622a;

            public c(a aVar) {
                this.f622a = new WeakReference(aVar);
            }

            public void G(ParcelableVolumeInfo parcelableVolumeInfo) {
                a aVar = (a) this.f622a.get();
                if (aVar != null) {
                    aVar.m(4, parcelableVolumeInfo != null ? new d(parcelableVolumeInfo.f697a, parcelableVolumeInfo.f698b, parcelableVolumeInfo.f699c, parcelableVolumeInfo.f700d, parcelableVolumeInfo.f701e) : null, null);
                }
            }

            public void P(Bundle bundle) {
                a aVar = (a) this.f622a.get();
                if (aVar != null) {
                    aVar.m(7, bundle, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void T(boolean z10) {
                a aVar = (a) this.f622a.get();
                if (aVar != null) {
                    aVar.m(11, Boolean.valueOf(z10), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void V(boolean z10) {
            }

            public void W(CharSequence charSequence) {
                a aVar = (a) this.f622a.get();
                if (aVar != null) {
                    aVar.m(6, charSequence, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void Z(int i10) {
                a aVar = (a) this.f622a.get();
                if (aVar != null) {
                    aVar.m(9, Integer.valueOf(i10), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void h0(PlaybackStateCompat playbackStateCompat) {
                a aVar = (a) this.f622a.get();
                if (aVar != null) {
                    aVar.m(2, playbackStateCompat, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void k() {
                a aVar = (a) this.f622a.get();
                if (aVar != null) {
                    aVar.m(13, null, null);
                }
            }

            public void l(List list) {
                a aVar = (a) this.f622a.get();
                if (aVar != null) {
                    aVar.m(5, list, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void onEvent(String str, Bundle bundle) {
                a aVar = (a) this.f622a.get();
                if (aVar != null) {
                    aVar.m(1, str, bundle);
                }
            }

            public void t() {
                a aVar = (a) this.f622a.get();
                if (aVar != null) {
                    aVar.m(8, null, null);
                }
            }

            public void v(MediaMetadataCompat mediaMetadataCompat) {
                a aVar = (a) this.f622a.get();
                if (aVar != null) {
                    aVar.m(3, mediaMetadataCompat, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void z(int i10) {
                a aVar = (a) this.f622a.get();
                if (aVar != null) {
                    aVar.m(12, Integer.valueOf(i10), null);
                }
            }
        }

        public a() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f616a = new C0008a(this);
            } else {
                this.f616a = null;
                this.f618c = new c(this);
            }
        }

        public void a(d dVar) {
        }

        public void b(boolean z10) {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            m(8, null, null);
        }

        public void c(Bundle bundle) {
        }

        public abstract void d(MediaMetadataCompat mediaMetadataCompat);

        public void e(PlaybackStateCompat playbackStateCompat) {
        }

        public void f(List list) {
        }

        public void g(CharSequence charSequence) {
        }

        public void h(int i10) {
        }

        public abstract void i();

        public void j(String str, Bundle bundle) {
        }

        public void k() {
        }

        public void l(int i10) {
        }

        public void m(int i10, Object obj, Bundle bundle) {
            b bVar = this.f617b;
            if (bVar != null) {
                Message obtainMessage = bVar.obtainMessage(i10, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        public void n(Handler handler) {
            if (handler != null) {
                b bVar = new b(handler.getLooper());
                this.f617b = bVar;
                bVar.f620a = true;
            } else {
                b bVar2 = this.f617b;
                if (bVar2 != null) {
                    bVar2.f620a = false;
                    bVar2.removeCallbacksAndMessages(null);
                    this.f617b = null;
                }
            }
        }
    }

    public interface b {
        void a(a aVar);

        PendingIntent b();

        e c();

        void d(a aVar, Handler handler);

        PlaybackStateCompat e();

        MediaMetadataCompat getMetadata();
    }

    public static class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public android.support.v4.media.session.b f623a;

        /* renamed from: b, reason: collision with root package name */
        public e f624b;

        public c(MediaSessionCompat.Token token) {
            this.f623a = b.a.i0((IBinder) token.c());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public void a(a aVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.f623a.R(aVar.f618c);
                this.f623a.asBinder().unlinkToDeath(aVar, 0);
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e10);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public PendingIntent b() {
            try {
                return this.f623a.i();
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in getSessionActivity.", e10);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public e c() {
            if (this.f624b == null) {
                this.f624b = new g(this.f623a);
            }
            return this.f624b;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public void d(a aVar, Handler handler) {
            if (aVar == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.f623a.asBinder().linkToDeath(aVar, 0);
                this.f623a.H(aVar.f618c);
                aVar.m(13, null, null);
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", e10);
                aVar.m(8, null, null);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public PlaybackStateCompat e() {
            try {
                return this.f623a.e();
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e10);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public MediaMetadataCompat getMetadata() {
            try {
                return this.f623a.getMetadata();
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in getMetadata.", e10);
                return null;
            }
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f625a;

        /* renamed from: b, reason: collision with root package name */
        public final AudioAttributesCompat f626b;

        /* renamed from: c, reason: collision with root package name */
        public final int f627c;

        /* renamed from: d, reason: collision with root package name */
        public final int f628d;

        /* renamed from: e, reason: collision with root package name */
        public final int f629e;

        public d(int i10, int i11, int i12, int i13, int i14) {
            this(i10, new AudioAttributesCompat.a().b(i11).a(), i12, i13, i14);
        }

        public d(int i10, AudioAttributesCompat audioAttributesCompat, int i11, int i12, int i13) {
            this.f625a = i10;
            this.f626b = audioAttributesCompat;
            this.f627c = i11;
            this.f628d = i12;
            this.f629e = i13;
        }
    }

    public static abstract class e {
        public abstract void a();

        public abstract void b();

        public abstract void c();
    }

    public static class f extends e {

        /* renamed from: a, reason: collision with root package name */
        public final MediaController.TransportControls f630a;

        public f(MediaController.TransportControls transportControls) {
            this.f630a = transportControls;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void a() {
            this.f630a.pause();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void b() {
            this.f630a.play();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void c() {
            this.f630a.stop();
        }
    }

    public static class g extends e {

        /* renamed from: a, reason: collision with root package name */
        public android.support.v4.media.session.b f631a;

        public g(android.support.v4.media.session.b bVar) {
            this.f631a = bVar;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void a() {
            try {
                this.f631a.pause();
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in pause.", e10);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void b() {
            try {
                this.f631a.a0();
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in play.", e10);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void c() {
            try {
                this.f631a.stop();
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in stop.", e10);
            }
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        MediaSessionCompat.Token f10 = mediaSessionCompat.f();
        this.f608b = f10;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f607a = new MediaControllerImplApi21(context, f10);
        } else {
            this.f607a = new c(f10);
        }
    }

    public MediaMetadataCompat a() {
        return this.f607a.getMetadata();
    }

    public PlaybackStateCompat b() {
        return this.f607a.e();
    }

    public PendingIntent c() {
        return this.f607a.b();
    }

    public e d() {
        return this.f607a.c();
    }

    public void e(a aVar) {
        f(aVar, null);
    }

    public void f(a aVar, Handler handler) {
        if (aVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if (this.f609c.putIfAbsent(aVar, Boolean.TRUE) != null) {
            return;
        }
        if (handler == null) {
            handler = new Handler();
        }
        aVar.n(handler);
        this.f607a.d(aVar, handler);
    }

    public void g(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if (this.f609c.remove(aVar) == null) {
            return;
        }
        try {
            this.f607a.a(aVar);
        } finally {
            aVar.n(null);
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        if (token != null) {
            this.f608b = token;
            if (Build.VERSION.SDK_INT >= 21) {
                this.f607a = new MediaControllerImplApi21(context, token);
                return;
            } else {
                this.f607a = new c(token);
                return;
            }
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }
}
