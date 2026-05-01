package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaDescription;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.b;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k0.l;

/* loaded from: classes.dex */
public class MediaSessionCompat {

    /* renamed from: d, reason: collision with root package name */
    public static int f632d;

    /* renamed from: a, reason: collision with root package name */
    public final c f633a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaControllerCompat f634b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f635c;

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public ResultReceiver f639a;

        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper[] newArray(int i10) {
                return new ResultReceiverWrapper[i10];
            }
        }

        public ResultReceiverWrapper(Parcel parcel) {
            this.f639a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            this.f639a.writeToParcel(parcel, i10);
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final Object f640a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f641b;

        /* renamed from: c, reason: collision with root package name */
        public android.support.v4.media.session.b f642c;

        /* renamed from: d, reason: collision with root package name */
        public y0.d f643d;

        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Token createFromParcel(Parcel parcel) {
                return new Token(Build.VERSION.SDK_INT >= 21 ? parcel.readParcelable(null) : parcel.readStrongBinder());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Token[] newArray(int i10) {
                return new Token[i10];
            }
        }

        public Token(Object obj) {
            this(obj, null, null);
        }

        public android.support.v4.media.session.b a() {
            android.support.v4.media.session.b bVar;
            synchronized (this.f640a) {
                bVar = this.f642c;
            }
            return bVar;
        }

        public y0.d b() {
            y0.d dVar;
            synchronized (this.f640a) {
                dVar = this.f643d;
            }
            return dVar;
        }

        public Object c() {
            return this.f641b;
        }

        public void d(android.support.v4.media.session.b bVar) {
            synchronized (this.f640a) {
                this.f642c = bVar;
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void e(y0.d dVar) {
            synchronized (this.f640a) {
                this.f643d = dVar;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f641b;
            if (obj2 == null) {
                return token.f641b == null;
            }
            Object obj3 = token.f641b;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f641b;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f641b, i10);
            } else {
                parcel.writeStrongBinder((IBinder) this.f641b);
            }
        }

        public Token(Object obj, android.support.v4.media.session.b bVar, y0.d dVar) {
            this.f640a = new Object();
            this.f641b = obj;
            this.f642c = bVar;
            this.f643d = dVar;
        }
    }

    public class a extends b {
        public a() {
        }
    }

    public static abstract class b {
        final MediaSession.Callback mCallbackFwk;
        a mCallbackHandler;
        final Object mLock = new Object();
        private boolean mMediaPlayPausePendingOnHandler;
        WeakReference<c> mSessionImpl;

        public class a extends Handler {
            public a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c cVar;
                b bVar;
                a aVar;
                if (message.what == 1) {
                    synchronized (b.this.mLock) {
                        cVar = b.this.mSessionImpl.get();
                        bVar = b.this;
                        aVar = bVar.mCallbackHandler;
                    }
                    if (cVar == null || bVar != cVar.k() || aVar == null) {
                        return;
                    }
                    cVar.d((k0.d) message.obj);
                    b.this.handleMediaPlayPauseIfPendingOnHandler(cVar, aVar);
                    cVar.d(null);
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$b$b, reason: collision with other inner class name */
        public class C0009b extends MediaSession.Callback {
            public C0009b() {
            }

            public final void a(c cVar) {
                cVar.d(null);
            }

            public final f b() {
                f fVar;
                synchronized (b.this.mLock) {
                    fVar = (f) b.this.mSessionImpl.get();
                }
                if (b.this == fVar.k()) {
                    return fVar;
                }
                return null;
            }

            public final void c(c cVar) {
                if (Build.VERSION.SDK_INT >= 28) {
                    return;
                }
                String h10 = cVar.h();
                if (TextUtils.isEmpty(h10)) {
                    h10 = "android.media.session.MediaController";
                }
                cVar.d(new k0.d(h10, -1, -1));
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                MediaSessionCompat.c(bundle);
                c(b10);
                try {
                    QueueItem queueItem = null;
                    IBinder asBinder = null;
                    queueItem = null;
                    if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                        Bundle bundle2 = new Bundle();
                        Token g10 = b10.g();
                        android.support.v4.media.session.b a10 = g10.a();
                        if (a10 != null) {
                            asBinder = a10.asBinder();
                        }
                        o.o.b(bundle2, "android.support.v4.media.session.EXTRA_BINDER", asBinder);
                        y0.a.c(bundle2, "android.support.v4.media.session.SESSION_TOKEN2", g10.b());
                        resultReceiver.send(0, bundle2);
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                        b.this.onAddQueueItem((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                        b.this.onAddQueueItem((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                    } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                        b.this.onRemoveQueueItem((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                    } else if (!str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                        b.this.onCommand(str, bundle, resultReceiver);
                    } else if (b10.f656h != null) {
                        int i10 = bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                        if (i10 >= 0 && i10 < b10.f656h.size()) {
                            queueItem = (QueueItem) b10.f656h.get(i10);
                        }
                        if (queueItem != null) {
                            b.this.onRemoveQueueItem(queueItem.c());
                        }
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
                }
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCustomAction(String str, Bundle bundle) {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                MediaSessionCompat.c(bundle);
                c(b10);
                try {
                    if (str.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                        Uri uri = (Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                        Bundle bundle2 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.c(bundle2);
                        b.this.onPlayFromUri(uri, bundle2);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                        b.this.onPrepare();
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                        String string = bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                        Bundle bundle3 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.c(bundle3);
                        b.this.onPrepareFromMediaId(string, bundle3);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                        String string2 = bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                        Bundle bundle4 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.c(bundle4);
                        b.this.onPrepareFromSearch(string2, bundle4);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                        Uri uri2 = (Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                        Bundle bundle5 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.c(bundle5);
                        b.this.onPrepareFromUri(uri2, bundle5);
                    } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                        b.this.onSetCaptioningEnabled(bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                        b.this.onSetRepeatMode(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                        b.this.onSetShuffleMode(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
                        RatingCompat ratingCompat = (RatingCompat) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING");
                        Bundle bundle6 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.c(bundle6);
                        b.this.onSetRating(ratingCompat, bundle6);
                    } else if (str.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                        b.this.onSetPlaybackSpeed(bundle.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f));
                    } else {
                        b.this.onCustomAction(str, bundle);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the data.");
                }
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onFastForward() {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                c(b10);
                b.this.onFastForward();
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public boolean onMediaButtonEvent(Intent intent) {
                f b10 = b();
                if (b10 == null) {
                    return false;
                }
                c(b10);
                boolean onMediaButtonEvent = b.this.onMediaButtonEvent(intent);
                a(b10);
                return onMediaButtonEvent || super.onMediaButtonEvent(intent);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPause() {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                c(b10);
                b.this.onPause();
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlay() {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                c(b10);
                b.this.onPlay();
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromMediaId(String str, Bundle bundle) {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                MediaSessionCompat.c(bundle);
                c(b10);
                b.this.onPlayFromMediaId(str, bundle);
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromSearch(String str, Bundle bundle) {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                MediaSessionCompat.c(bundle);
                c(b10);
                b.this.onPlayFromSearch(str, bundle);
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromUri(Uri uri, Bundle bundle) {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                MediaSessionCompat.c(bundle);
                c(b10);
                b.this.onPlayFromUri(uri, bundle);
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepare() {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                c(b10);
                b.this.onPrepare();
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromMediaId(String str, Bundle bundle) {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                MediaSessionCompat.c(bundle);
                c(b10);
                b.this.onPrepareFromMediaId(str, bundle);
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromSearch(String str, Bundle bundle) {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                MediaSessionCompat.c(bundle);
                c(b10);
                b.this.onPrepareFromSearch(str, bundle);
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                MediaSessionCompat.c(bundle);
                c(b10);
                b.this.onPrepareFromUri(uri, bundle);
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onRewind() {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                c(b10);
                b.this.onRewind();
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSeekTo(long j10) {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                c(b10);
                b.this.onSeekTo(j10);
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetPlaybackSpeed(float f10) {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                c(b10);
                b.this.onSetPlaybackSpeed(f10);
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetRating(Rating rating) {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                c(b10);
                b.this.onSetRating(RatingCompat.a(rating));
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToNext() {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                c(b10);
                b.this.onSkipToNext();
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToPrevious() {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                c(b10);
                b.this.onSkipToPrevious();
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToQueueItem(long j10) {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                c(b10);
                b.this.onSkipToQueueItem(j10);
                a(b10);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onStop() {
                f b10 = b();
                if (b10 == null) {
                    return;
                }
                c(b10);
                b.this.onStop();
                a(b10);
            }
        }

        public b() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.mCallbackFwk = new C0009b();
            } else {
                this.mCallbackFwk = null;
            }
            this.mSessionImpl = new WeakReference<>(null);
        }

        public void handleMediaPlayPauseIfPendingOnHandler(c cVar, Handler handler) {
            if (this.mMediaPlayPausePendingOnHandler) {
                this.mMediaPlayPausePendingOnHandler = false;
                handler.removeMessages(1);
                PlaybackStateCompat e10 = cVar.e();
                long b10 = e10 == null ? 0L : e10.b();
                boolean z10 = e10 != null && e10.g() == 3;
                boolean z11 = (516 & b10) != 0;
                boolean z12 = (b10 & 514) != 0;
                if (z10 && z12) {
                    onPause();
                } else {
                    if (z10 || !z11) {
                        return;
                    }
                    onPlay();
                }
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void onCustomAction(String str, Bundle bundle) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            c cVar;
            a aVar;
            KeyEvent keyEvent;
            if (Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            synchronized (this.mLock) {
                cVar = this.mSessionImpl.get();
                aVar = this.mCallbackHandler;
            }
            if (cVar == null || aVar == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            k0.d o10 = cVar.o();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 79 && keyCode != 85) {
                handleMediaPlayPauseIfPendingOnHandler(cVar, aVar);
                return false;
            }
            if (keyEvent.getRepeatCount() != 0) {
                handleMediaPlayPauseIfPendingOnHandler(cVar, aVar);
            } else if (this.mMediaPlayPausePendingOnHandler) {
                aVar.removeMessages(1);
                this.mMediaPlayPausePendingOnHandler = false;
                PlaybackStateCompat e10 = cVar.e();
                if (((e10 == null ? 0L : e10.b()) & 32) != 0) {
                    onSkipToNext();
                }
            } else {
                this.mMediaPlayPausePendingOnHandler = true;
                aVar.sendMessageDelayed(aVar.obtainMessage(1, o10), ViewConfiguration.getDoubleTapTimeout());
            }
            return true;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int i10) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long j10) {
        }

        public void onSetCaptioningEnabled(boolean z10) {
        }

        public void onSetPlaybackSpeed(float f10) {
        }

        public void onSetRating(RatingCompat ratingCompat) {
        }

        public void onSetRepeatMode(int i10) {
        }

        public void onSetShuffleMode(int i10) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long j10) {
        }

        public void onStop() {
        }

        public void setSessionImpl(c cVar, Handler handler) {
            synchronized (this.mLock) {
                this.mSessionImpl = new WeakReference<>(cVar);
                a aVar = this.mCallbackHandler;
                a aVar2 = null;
                if (aVar != null) {
                    aVar.removeCallbacksAndMessages(null);
                }
                if (cVar != null && handler != null) {
                    aVar2 = new a(handler.getLooper());
                }
                this.mCallbackHandler = aVar2;
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
        }

        public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
        }
    }

    public interface c {
        void a(k0.l lVar);

        void b(b bVar, Handler handler);

        void c(MediaMetadataCompat mediaMetadataCompat);

        void d(k0.d dVar);

        PlaybackStateCompat e();

        void f(PlaybackStateCompat playbackStateCompat);

        Token g();

        String h();

        void i(PendingIntent pendingIntent);

        boolean isActive();

        void j(int i10);

        b k();

        void l(PendingIntent pendingIntent);

        Object m();

        void n(boolean z10);

        k0.d o();

        void release();
    }

    public static class d extends i {
        public static boolean G = true;

        public class a implements RemoteControlClient.OnPlaybackPositionUpdateListener {
            public a() {
            }

            @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
            public void onPlaybackPositionUpdate(long j10) {
                d.this.u(18, -1, -1, Long.valueOf(j10), null);
            }
        }

        public d(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, y0.d dVar, Bundle bundle) {
            super(context, str, componentName, pendingIntent, dVar, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.i
        public void A(PlaybackStateCompat playbackStateCompat) {
            long f10 = playbackStateCompat.f();
            float d10 = playbackStateCompat.d();
            long c10 = playbackStateCompat.c();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (playbackStateCompat.g() == 3) {
                long j10 = 0;
                if (f10 > 0) {
                    if (c10 > 0) {
                        j10 = elapsedRealtime - c10;
                        if (d10 > 0.0f && d10 != 1.0f) {
                            j10 = (long) (j10 * d10);
                        }
                    }
                    f10 += j10;
                }
            }
            this.f674j.setPlaybackState(s(playbackStateCompat.g()), f10, d10);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.i
        public void C(PendingIntent pendingIntent, ComponentName componentName) {
            if (G) {
                this.f673i.unregisterMediaButtonEventReceiver(pendingIntent);
            } else {
                super.C(pendingIntent, componentName);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.i, android.support.v4.media.session.MediaSessionCompat.c
        public void b(b bVar, Handler handler) {
            super.b(bVar, handler);
            if (bVar == null) {
                this.f674j.setPlaybackPositionUpdateListener(null);
            } else {
                this.f674j.setPlaybackPositionUpdateListener(new a());
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.i
        public int t(long j10) {
            int t10 = super.t(j10);
            return (j10 & 256) != 0 ? t10 | 256 : t10;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.i
        public void v(PendingIntent pendingIntent, ComponentName componentName) {
            if (G) {
                try {
                    this.f673i.registerMediaButtonEventReceiver(pendingIntent);
                } catch (NullPointerException unused) {
                    G = false;
                }
            }
            if (G) {
                return;
            }
            super.v(pendingIntent, componentName);
        }
    }

    public static class e extends d {

        public class a implements RemoteControlClient.OnMetadataUpdateListener {
            public a() {
            }

            @Override // android.media.RemoteControlClient.OnMetadataUpdateListener
            public void onMetadataUpdate(int i10, Object obj) {
                if (i10 == 268435457 && (obj instanceof Rating)) {
                    e.this.u(19, -1, -1, RatingCompat.a(obj), null);
                }
            }
        }

        public e(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, y0.d dVar, Bundle bundle) {
            super(context, str, componentName, pendingIntent, dVar, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.d, android.support.v4.media.session.MediaSessionCompat.i, android.support.v4.media.session.MediaSessionCompat.c
        public void b(b bVar, Handler handler) {
            super.b(bVar, handler);
            if (bVar == null) {
                this.f674j.setMetadataUpdateListener(null);
            } else {
                this.f674j.setMetadataUpdateListener(new a());
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.i
        public RemoteControlClient.MetadataEditor q(Bundle bundle) {
            RemoteControlClient.MetadataEditor q10 = super.q(bundle);
            PlaybackStateCompat playbackStateCompat = this.f684t;
            if (((playbackStateCompat == null ? 0L : playbackStateCompat.b()) & 128) != 0) {
                q10.addEditableKey(268435457);
            }
            if (bundle == null) {
                return q10;
            }
            if (bundle.containsKey("android.media.metadata.YEAR")) {
                q10.putLong(8, bundle.getLong("android.media.metadata.YEAR"));
            }
            if (bundle.containsKey("android.media.metadata.RATING")) {
                q10.putObject(101, (Object) bundle.getParcelable("android.media.metadata.RATING"));
            }
            if (bundle.containsKey("android.media.metadata.USER_RATING")) {
                q10.putObject(268435457, (Object) bundle.getParcelable("android.media.metadata.USER_RATING"));
            }
            return q10;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.d, android.support.v4.media.session.MediaSessionCompat.i
        public int t(long j10) {
            int t10 = super.t(j10);
            return (j10 & 128) != 0 ? t10 | 512 : t10;
        }
    }

    public static class f implements c {

        /* renamed from: a, reason: collision with root package name */
        public final MediaSession f649a;

        /* renamed from: b, reason: collision with root package name */
        public final Token f650b;

        /* renamed from: d, reason: collision with root package name */
        public Bundle f652d;

        /* renamed from: g, reason: collision with root package name */
        public PlaybackStateCompat f655g;

        /* renamed from: h, reason: collision with root package name */
        public List f656h;

        /* renamed from: i, reason: collision with root package name */
        public MediaMetadataCompat f657i;

        /* renamed from: j, reason: collision with root package name */
        public int f658j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f659k;

        /* renamed from: l, reason: collision with root package name */
        public int f660l;

        /* renamed from: m, reason: collision with root package name */
        public int f661m;

        /* renamed from: n, reason: collision with root package name */
        public b f662n;

        /* renamed from: o, reason: collision with root package name */
        public k0.d f663o;

        /* renamed from: c, reason: collision with root package name */
        public final Object f651c = new Object();

        /* renamed from: e, reason: collision with root package name */
        public boolean f653e = false;

        /* renamed from: f, reason: collision with root package name */
        public final RemoteCallbackList f654f = new RemoteCallbackList();

        public class a extends b.a {
            public a() {
            }

            @Override // android.support.v4.media.session.b
            public void A(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void B() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void C(long j10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void D(boolean z10) {
            }

            @Override // android.support.v4.media.session.b
            public void E(int i10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public String F() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void H(android.support.v4.media.session.a aVar) {
                if (f.this.f653e) {
                    return;
                }
                f.this.f654f.register(aVar, new k0.d("android.media.session.MediaController", Binder.getCallingPid(), Binder.getCallingUid()));
            }

            @Override // android.support.v4.media.session.b
            public void I(RatingCompat ratingCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void J(int i10, int i11, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void K(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean L() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void M(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void N(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void O() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public CharSequence Q() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void R(android.support.v4.media.session.a aVar) {
                f.this.f654f.unregister(aVar);
            }

            @Override // android.support.v4.media.session.b
            public void S() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void U(float f10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void X(int i10, int i11, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void Y(boolean z10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void a0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public List b0() {
                return null;
            }

            @Override // android.support.v4.media.session.b
            public void c0(int i10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public long d0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public PlaybackStateCompat e() {
                f fVar = f.this;
                return MediaSessionCompat.g(fVar.f655g, fVar.f657i);
            }

            @Override // android.support.v4.media.session.b
            public int e0() {
                return f.this.f660l;
            }

            @Override // android.support.v4.media.session.b
            public void f(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public ParcelableVolumeInfo f0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean g() {
                return false;
            }

            @Override // android.support.v4.media.session.b
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public String getTag() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void h(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public PendingIntent i() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public int j() {
                return f.this.f658j;
            }

            @Override // android.support.v4.media.session.b
            public void m(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public Bundle n() {
                if (f.this.f652d == null) {
                    return null;
                }
                return new Bundle(f.this.f652d);
            }

            @Override // android.support.v4.media.session.b
            public void next() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void o(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void p(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void pause() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void previous() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void q(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean r(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void s(RatingCompat ratingCompat, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void seekTo(long j10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void stop() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void u(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public int w() {
                return f.this.f661m;
            }

            @Override // android.support.v4.media.session.b
            public void x(int i10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean y() {
                return f.this.f659k;
            }
        }

        public f(MediaSession mediaSession, y0.d dVar, Bundle bundle) {
            MediaSession.Token sessionToken;
            this.f649a = mediaSession;
            sessionToken = mediaSession.getSessionToken();
            this.f650b = new Token(sessionToken, new a(), dVar);
            this.f652d = bundle;
            p(3);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void a(k0.l lVar) {
            this.f649a.setPlaybackToRemote(a0.a(lVar.d()));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void b(b bVar, Handler handler) {
            synchronized (this.f651c) {
                this.f662n = bVar;
                this.f649a.setCallback(bVar == null ? null : bVar.mCallbackFwk, handler);
                if (bVar != null) {
                    bVar.setSessionImpl(this, handler);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void c(MediaMetadataCompat mediaMetadataCompat) {
            this.f657i = mediaMetadataCompat;
            this.f649a.setMetadata(mediaMetadataCompat == null ? null : android.support.v4.media.u.a(mediaMetadataCompat.g()));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void d(k0.d dVar) {
            synchronized (this.f651c) {
                this.f663o = dVar;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public PlaybackStateCompat e() {
            return this.f655g;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void f(PlaybackStateCompat playbackStateCompat) {
            this.f655g = playbackStateCompat;
            for (int beginBroadcast = this.f654f.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f654f.getBroadcastItem(beginBroadcast)).h0(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f654f.finishBroadcast();
            this.f649a.setPlaybackState(playbackStateCompat == null ? null : u.a(playbackStateCompat.e()));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public Token g() {
            return this.f650b;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public String h() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            try {
                return (String) this.f649a.getClass().getMethod("getCallingPackage", new Class[0]).invoke(this.f649a, new Object[0]);
            } catch (Exception e10) {
                Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e10);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void i(PendingIntent pendingIntent) {
            this.f649a.setSessionActivity(pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public boolean isActive() {
            boolean isActive;
            isActive = this.f649a.isActive();
            return isActive;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void j(int i10) {
            AudioAttributes build;
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.setLegacyStreamType(i10);
            MediaSession mediaSession = this.f649a;
            build = builder.build();
            mediaSession.setPlaybackToLocal(build);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public b k() {
            b bVar;
            synchronized (this.f651c) {
                bVar = this.f662n;
            }
            return bVar;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void l(PendingIntent pendingIntent) {
            this.f649a.setMediaButtonReceiver(pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public Object m() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void n(boolean z10) {
            this.f649a.setActive(z10);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public k0.d o() {
            k0.d dVar;
            synchronized (this.f651c) {
                dVar = this.f663o;
            }
            return dVar;
        }

        public void p(int i10) {
            this.f649a.setFlags(i10 | 1 | 2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void release() {
            this.f653e = true;
            this.f654f.kill();
            this.f649a.setCallback(null);
            this.f649a.release();
        }
    }

    public static class g extends f {
        public g(MediaSession mediaSession, y0.d dVar, Bundle bundle) {
            super(mediaSession, dVar, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.f, android.support.v4.media.session.MediaSessionCompat.c
        public void d(k0.d dVar) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.f, android.support.v4.media.session.MediaSessionCompat.c
        public final k0.d o() {
            MediaSessionManager.RemoteUserInfo currentControllerInfo;
            currentControllerInfo = this.f649a.getCurrentControllerInfo();
            return new k0.d(currentControllerInfo);
        }
    }

    public static class h extends g {
        public h(MediaSession mediaSession, y0.d dVar, Bundle bundle) {
            super(mediaSession, dVar, bundle);
        }
    }

    public static class i implements c {
        public int A;
        public Bundle B;
        public int C;
        public int D;
        public k0.l E;

        /* renamed from: a, reason: collision with root package name */
        public final Context f665a;

        /* renamed from: b, reason: collision with root package name */
        public final ComponentName f666b;

        /* renamed from: c, reason: collision with root package name */
        public final PendingIntent f667c;

        /* renamed from: d, reason: collision with root package name */
        public final c f668d;

        /* renamed from: e, reason: collision with root package name */
        public final Token f669e;

        /* renamed from: f, reason: collision with root package name */
        public final String f670f;

        /* renamed from: g, reason: collision with root package name */
        public final Bundle f671g;

        /* renamed from: h, reason: collision with root package name */
        public final String f672h;

        /* renamed from: i, reason: collision with root package name */
        public final AudioManager f673i;

        /* renamed from: j, reason: collision with root package name */
        public final RemoteControlClient f674j;

        /* renamed from: m, reason: collision with root package name */
        public d f677m;

        /* renamed from: p, reason: collision with root package name */
        public volatile b f680p;

        /* renamed from: q, reason: collision with root package name */
        public k0.d f681q;

        /* renamed from: s, reason: collision with root package name */
        public MediaMetadataCompat f683s;

        /* renamed from: t, reason: collision with root package name */
        public PlaybackStateCompat f684t;

        /* renamed from: u, reason: collision with root package name */
        public PendingIntent f685u;

        /* renamed from: v, reason: collision with root package name */
        public List f686v;

        /* renamed from: w, reason: collision with root package name */
        public CharSequence f687w;

        /* renamed from: x, reason: collision with root package name */
        public int f688x;

        /* renamed from: y, reason: collision with root package name */
        public boolean f689y;

        /* renamed from: z, reason: collision with root package name */
        public int f690z;

        /* renamed from: k, reason: collision with root package name */
        public final Object f675k = new Object();

        /* renamed from: l, reason: collision with root package name */
        public final RemoteCallbackList f676l = new RemoteCallbackList();

        /* renamed from: n, reason: collision with root package name */
        public boolean f678n = false;

        /* renamed from: o, reason: collision with root package name */
        public boolean f679o = false;

        /* renamed from: r, reason: collision with root package name */
        public int f682r = 3;
        public l.c F = new a();

        public class a extends l.c {
            public a() {
            }

            @Override // k0.l.c
            public void a(k0.l lVar) {
                if (i.this.E != lVar) {
                    return;
                }
                i iVar = i.this;
                i.this.z(new ParcelableVolumeInfo(iVar.C, iVar.D, lVar.c(), lVar.b(), lVar.a()));
            }
        }

        public static final class b {

            /* renamed from: a, reason: collision with root package name */
            public final String f692a;

            /* renamed from: b, reason: collision with root package name */
            public final Bundle f693b;

            /* renamed from: c, reason: collision with root package name */
            public final ResultReceiver f694c;

            public b(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f692a = str;
                this.f693b = bundle;
                this.f694c = resultReceiver;
            }
        }

        public class c extends b.a {
            public c() {
            }

            @Override // android.support.v4.media.session.b
            public void A(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                m0(1, new b(str, bundle, resultReceiverWrapper == null ? null : resultReceiverWrapper.f639a));
            }

            @Override // android.support.v4.media.session.b
            public void B() {
                k0(17);
            }

            @Override // android.support.v4.media.session.b
            public void C(long j10) {
                m0(11, Long.valueOf(j10));
            }

            @Override // android.support.v4.media.session.b
            public void D(boolean z10) {
            }

            @Override // android.support.v4.media.session.b
            public void E(int i10) {
                l0(30, i10);
            }

            @Override // android.support.v4.media.session.b
            public String F() {
                return i.this.f670f;
            }

            @Override // android.support.v4.media.session.b
            public void H(android.support.v4.media.session.a aVar) {
                if (i.this.f678n) {
                    try {
                        aVar.t();
                    } catch (Exception unused) {
                    }
                } else {
                    i.this.f676l.register(aVar, new k0.d(i.this.r(Binder.getCallingUid()), Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            @Override // android.support.v4.media.session.b
            public void I(RatingCompat ratingCompat) {
                m0(19, ratingCompat);
            }

            @Override // android.support.v4.media.session.b
            public void J(int i10, int i11, String str) {
                i.this.B(i10, i11);
            }

            @Override // android.support.v4.media.session.b
            public void K(MediaDescriptionCompat mediaDescriptionCompat) {
                m0(27, mediaDescriptionCompat);
            }

            @Override // android.support.v4.media.session.b
            public boolean L() {
                return true;
            }

            @Override // android.support.v4.media.session.b
            public void M(MediaDescriptionCompat mediaDescriptionCompat) {
                m0(25, mediaDescriptionCompat);
            }

            @Override // android.support.v4.media.session.b
            public void N(String str, Bundle bundle) {
                o0(5, str, bundle);
            }

            @Override // android.support.v4.media.session.b
            public void O() {
                k0(3);
            }

            @Override // android.support.v4.media.session.b
            public CharSequence Q() {
                return i.this.f687w;
            }

            @Override // android.support.v4.media.session.b
            public void R(android.support.v4.media.session.a aVar) {
                i.this.f676l.unregister(aVar);
            }

            @Override // android.support.v4.media.session.b
            public void S() {
                k0(16);
            }

            @Override // android.support.v4.media.session.b
            public void U(float f10) {
                m0(32, Float.valueOf(f10));
            }

            @Override // android.support.v4.media.session.b
            public void X(int i10, int i11, String str) {
                i.this.p(i10, i11);
            }

            @Override // android.support.v4.media.session.b
            public void Y(boolean z10) {
                m0(29, Boolean.valueOf(z10));
            }

            @Override // android.support.v4.media.session.b
            public void a0() {
                k0(7);
            }

            @Override // android.support.v4.media.session.b
            public List b0() {
                List list;
                synchronized (i.this.f675k) {
                    list = i.this.f686v;
                }
                return list;
            }

            @Override // android.support.v4.media.session.b
            public void c0(int i10) {
                l0(23, i10);
            }

            @Override // android.support.v4.media.session.b
            public long d0() {
                long j10;
                synchronized (i.this.f675k) {
                    j10 = i.this.f682r;
                }
                return j10;
            }

            @Override // android.support.v4.media.session.b
            public PlaybackStateCompat e() {
                PlaybackStateCompat playbackStateCompat;
                MediaMetadataCompat mediaMetadataCompat;
                synchronized (i.this.f675k) {
                    i iVar = i.this;
                    playbackStateCompat = iVar.f684t;
                    mediaMetadataCompat = iVar.f683s;
                }
                return MediaSessionCompat.g(playbackStateCompat, mediaMetadataCompat);
            }

            @Override // android.support.v4.media.session.b
            public int e0() {
                return i.this.f690z;
            }

            @Override // android.support.v4.media.session.b
            public void f(String str, Bundle bundle) {
                o0(20, str, bundle);
            }

            @Override // android.support.v4.media.session.b
            public ParcelableVolumeInfo f0() {
                int i10;
                int i11;
                int i12;
                int streamMaxVolume;
                int streamVolume;
                synchronized (i.this.f675k) {
                    i iVar = i.this;
                    i10 = iVar.C;
                    i11 = iVar.D;
                    k0.l lVar = iVar.E;
                    i12 = 2;
                    if (i10 == 2) {
                        int c10 = lVar.c();
                        int b10 = lVar.b();
                        streamVolume = lVar.a();
                        streamMaxVolume = b10;
                        i12 = c10;
                    } else {
                        streamMaxVolume = iVar.f673i.getStreamMaxVolume(i11);
                        streamVolume = i.this.f673i.getStreamVolume(i11);
                    }
                }
                return new ParcelableVolumeInfo(i10, i11, i12, streamMaxVolume, streamVolume);
            }

            @Override // android.support.v4.media.session.b
            public boolean g() {
                return false;
            }

            @Override // android.support.v4.media.session.b
            public Bundle getExtras() {
                Bundle bundle;
                synchronized (i.this.f675k) {
                    bundle = i.this.B;
                }
                return bundle;
            }

            @Override // android.support.v4.media.session.b
            public MediaMetadataCompat getMetadata() {
                return i.this.f683s;
            }

            @Override // android.support.v4.media.session.b
            public String getTag() {
                return i.this.f672h;
            }

            @Override // android.support.v4.media.session.b
            public void h(Uri uri, Bundle bundle) {
                o0(6, uri, bundle);
            }

            @Override // android.support.v4.media.session.b
            public PendingIntent i() {
                PendingIntent pendingIntent;
                synchronized (i.this.f675k) {
                    pendingIntent = i.this.f685u;
                }
                return pendingIntent;
            }

            @Override // android.support.v4.media.session.b
            public int j() {
                return i.this.f688x;
            }

            public void k0(int i10) {
                i.this.u(i10, 0, 0, null, null);
            }

            public void l0(int i10, int i11) {
                i.this.u(i10, i11, 0, null, null);
            }

            @Override // android.support.v4.media.session.b
            public void m(String str, Bundle bundle) {
                o0(4, str, bundle);
            }

            public void m0(int i10, Object obj) {
                i.this.u(i10, 0, 0, obj, null);
            }

            @Override // android.support.v4.media.session.b
            public Bundle n() {
                if (i.this.f671g == null) {
                    return null;
                }
                return new Bundle(i.this.f671g);
            }

            public void n0(int i10, Object obj, int i11) {
                i.this.u(i10, i11, 0, obj, null);
            }

            @Override // android.support.v4.media.session.b
            public void next() {
                k0(14);
            }

            @Override // android.support.v4.media.session.b
            public void o(String str, Bundle bundle) {
                o0(8, str, bundle);
            }

            public void o0(int i10, Object obj, Bundle bundle) {
                i.this.u(i10, 0, 0, obj, bundle);
            }

            @Override // android.support.v4.media.session.b
            public void p(String str, Bundle bundle) {
                o0(9, str, bundle);
            }

            @Override // android.support.v4.media.session.b
            public void pause() {
                k0(12);
            }

            @Override // android.support.v4.media.session.b
            public void previous() {
                k0(15);
            }

            @Override // android.support.v4.media.session.b
            public void q(Uri uri, Bundle bundle) {
                o0(10, uri, bundle);
            }

            @Override // android.support.v4.media.session.b
            public boolean r(KeyEvent keyEvent) {
                m0(21, keyEvent);
                return true;
            }

            @Override // android.support.v4.media.session.b
            public void s(RatingCompat ratingCompat, Bundle bundle) {
                o0(31, ratingCompat, bundle);
            }

            @Override // android.support.v4.media.session.b
            public void seekTo(long j10) {
                m0(18, Long.valueOf(j10));
            }

            @Override // android.support.v4.media.session.b
            public void stop() {
                k0(13);
            }

            @Override // android.support.v4.media.session.b
            public void u(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
                n0(26, mediaDescriptionCompat, i10);
            }

            @Override // android.support.v4.media.session.b
            public int w() {
                return i.this.A;
            }

            @Override // android.support.v4.media.session.b
            public void x(int i10) {
                l0(28, i10);
            }

            @Override // android.support.v4.media.session.b
            public boolean y() {
                return i.this.f689y;
            }
        }

        public class d extends Handler {
            public d(Looper looper) {
                super(looper);
            }

            public final void a(KeyEvent keyEvent, b bVar) {
                if (keyEvent == null || keyEvent.getAction() != 0) {
                    return;
                }
                PlaybackStateCompat playbackStateCompat = i.this.f684t;
                long b10 = playbackStateCompat == null ? 0L : playbackStateCompat.b();
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 126) {
                    if ((b10 & 4) != 0) {
                        bVar.onPlay();
                    }
                    return;
                }
                if (keyCode == 127) {
                    if ((b10 & 2) != 0) {
                        bVar.onPause();
                        return;
                    }
                    return;
                }
                switch (keyCode) {
                    case 86:
                        if ((b10 & 1) != 0) {
                            bVar.onStop();
                            break;
                        }
                        break;
                    case 87:
                        if ((b10 & 32) != 0) {
                            bVar.onSkipToNext();
                            break;
                        }
                        break;
                    case 88:
                        if ((b10 & 16) != 0) {
                            bVar.onSkipToPrevious();
                            break;
                        }
                        break;
                    case 89:
                        if ((b10 & 8) != 0) {
                            bVar.onRewind();
                            break;
                        }
                        break;
                    case 90:
                        if ((b10 & 64) != 0) {
                            bVar.onFastForward();
                            break;
                        }
                        break;
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                b bVar = i.this.f680p;
                if (bVar == null) {
                    return;
                }
                Bundle data = message.getData();
                MediaSessionCompat.c(data);
                i.this.d(new k0.d(data.getString("data_calling_pkg"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid")));
                Bundle bundle = data.getBundle("data_extras");
                MediaSessionCompat.c(bundle);
                try {
                    switch (message.what) {
                        case 1:
                            b bVar2 = (b) message.obj;
                            bVar.onCommand(bVar2.f692a, bVar2.f693b, bVar2.f694c);
                            break;
                        case 2:
                            i.this.p(message.arg1, 0);
                            break;
                        case 3:
                            bVar.onPrepare();
                            break;
                        case 4:
                            bVar.onPrepareFromMediaId((String) message.obj, bundle);
                            break;
                        case 5:
                            bVar.onPrepareFromSearch((String) message.obj, bundle);
                            break;
                        case 6:
                            bVar.onPrepareFromUri((Uri) message.obj, bundle);
                            break;
                        case 7:
                            bVar.onPlay();
                            break;
                        case 8:
                            bVar.onPlayFromMediaId((String) message.obj, bundle);
                            break;
                        case 9:
                            bVar.onPlayFromSearch((String) message.obj, bundle);
                            break;
                        case 10:
                            bVar.onPlayFromUri((Uri) message.obj, bundle);
                            break;
                        case 11:
                            bVar.onSkipToQueueItem(((Long) message.obj).longValue());
                            break;
                        case 12:
                            bVar.onPause();
                            break;
                        case 13:
                            bVar.onStop();
                            break;
                        case 14:
                            bVar.onSkipToNext();
                            break;
                        case 15:
                            bVar.onSkipToPrevious();
                            break;
                        case 16:
                            bVar.onFastForward();
                            break;
                        case 17:
                            bVar.onRewind();
                            break;
                        case 18:
                            bVar.onSeekTo(((Long) message.obj).longValue());
                            break;
                        case 19:
                            bVar.onSetRating((RatingCompat) message.obj);
                            break;
                        case 20:
                            bVar.onCustomAction((String) message.obj, bundle);
                            break;
                        case 21:
                            KeyEvent keyEvent = (KeyEvent) message.obj;
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!bVar.onMediaButtonEvent(intent)) {
                                a(keyEvent, bVar);
                                break;
                            }
                            break;
                        case 22:
                            i.this.B(message.arg1, 0);
                            break;
                        case 23:
                            bVar.onSetRepeatMode(message.arg1);
                            break;
                        case 25:
                            bVar.onAddQueueItem((MediaDescriptionCompat) message.obj);
                            break;
                        case 26:
                            bVar.onAddQueueItem((MediaDescriptionCompat) message.obj, message.arg1);
                            break;
                        case 27:
                            bVar.onRemoveQueueItem((MediaDescriptionCompat) message.obj);
                            break;
                        case 28:
                            List list = i.this.f686v;
                            if (list != null) {
                                int i10 = message.arg1;
                                QueueItem queueItem = (i10 < 0 || i10 >= list.size()) ? null : (QueueItem) i.this.f686v.get(message.arg1);
                                if (queueItem != null) {
                                    bVar.onRemoveQueueItem(queueItem.c());
                                    break;
                                }
                            }
                            break;
                        case 29:
                            bVar.onSetCaptioningEnabled(((Boolean) message.obj).booleanValue());
                            break;
                        case 30:
                            bVar.onSetShuffleMode(message.arg1);
                            break;
                        case 31:
                            bVar.onSetRating((RatingCompat) message.obj, bundle);
                            break;
                        case 32:
                            bVar.onSetPlaybackSpeed(((Float) message.obj).floatValue());
                            break;
                    }
                } finally {
                    i.this.d(null);
                }
            }
        }

        public i(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, y0.d dVar, Bundle bundle) {
            if (componentName == null) {
                throw new IllegalArgumentException("MediaButtonReceiver component may not be null");
            }
            this.f665a = context;
            this.f670f = context.getPackageName();
            this.f671g = bundle;
            this.f673i = (AudioManager) context.getSystemService("audio");
            this.f672h = str;
            this.f666b = componentName;
            this.f667c = pendingIntent;
            c cVar = new c();
            this.f668d = cVar;
            this.f669e = new Token(cVar, null, dVar);
            this.f688x = 0;
            this.C = 1;
            this.D = 3;
            this.f674j = new RemoteControlClient(pendingIntent);
        }

        public abstract void A(PlaybackStateCompat playbackStateCompat);

        public void B(int i10, int i11) {
            if (this.C != 2) {
                this.f673i.setStreamVolume(this.D, i10, i11);
                return;
            }
            k0.l lVar = this.E;
            if (lVar != null) {
                lVar.f(i10);
            }
        }

        public void C(PendingIntent pendingIntent, ComponentName componentName) {
            this.f673i.unregisterMediaButtonEventReceiver(componentName);
        }

        public void D() {
            if (!this.f679o) {
                C(this.f667c, this.f666b);
                this.f674j.setPlaybackState(0);
                this.f673i.unregisterRemoteControlClient(this.f674j);
            } else {
                v(this.f667c, this.f666b);
                this.f673i.registerRemoteControlClient(this.f674j);
                c(this.f683s);
                f(this.f684t);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void a(k0.l lVar) {
            if (lVar == null) {
                throw new IllegalArgumentException("volumeProvider may not be null");
            }
            k0.l lVar2 = this.E;
            if (lVar2 != null) {
                lVar2.g(null);
            }
            this.C = 2;
            this.E = lVar;
            z(new ParcelableVolumeInfo(this.C, this.D, this.E.c(), this.E.b(), this.E.a()));
            lVar.g(this.F);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0030 A[Catch: all -> 0x0037, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:10:0x0010, B:11:0x001b, B:13:0x0021, B:15:0x0025, B:16:0x002a, B:18:0x0030, B:19:0x0035), top: B:3:0x0003 }] */
        @Override // android.support.v4.media.session.MediaSessionCompat.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(b bVar, Handler handler) {
            d dVar;
            synchronized (this.f675k) {
                d dVar2 = this.f677m;
                if (dVar2 != null) {
                    dVar2.removeCallbacksAndMessages(null);
                }
                if (bVar != null && handler != null) {
                    dVar = new d(handler.getLooper());
                    this.f677m = dVar;
                    if (this.f680p != bVar && this.f680p != null) {
                        this.f680p.setSessionImpl(null, null);
                    }
                    this.f680p = bVar;
                    if (this.f680p != null) {
                        this.f680p.setSessionImpl(this, handler);
                    }
                }
                dVar = null;
                this.f677m = dVar;
                if (this.f680p != bVar) {
                    this.f680p.setSessionImpl(null, null);
                }
                this.f680p = bVar;
                if (this.f680p != null) {
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void c(MediaMetadataCompat mediaMetadataCompat) {
            if (mediaMetadataCompat != null) {
                mediaMetadataCompat = new MediaMetadataCompat.b(mediaMetadataCompat, MediaSessionCompat.f632d).a();
            }
            synchronized (this.f675k) {
                this.f683s = mediaMetadataCompat;
            }
            w(mediaMetadataCompat);
            if (this.f679o) {
                q(mediaMetadataCompat == null ? null : mediaMetadataCompat.d()).apply();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void d(k0.d dVar) {
            synchronized (this.f675k) {
                this.f681q = dVar;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public PlaybackStateCompat e() {
            PlaybackStateCompat playbackStateCompat;
            synchronized (this.f675k) {
                playbackStateCompat = this.f684t;
            }
            return playbackStateCompat;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void f(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.f675k) {
                this.f684t = playbackStateCompat;
            }
            y(playbackStateCompat);
            if (this.f679o) {
                if (playbackStateCompat == null) {
                    this.f674j.setPlaybackState(0);
                    this.f674j.setTransportControlFlags(0);
                } else {
                    A(playbackStateCompat);
                    this.f674j.setTransportControlFlags(t(playbackStateCompat.b()));
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public Token g() {
            return this.f669e;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public String h() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void i(PendingIntent pendingIntent) {
            synchronized (this.f675k) {
                this.f685u = pendingIntent;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public boolean isActive() {
            return this.f679o;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void j(int i10) {
            k0.l lVar = this.E;
            if (lVar != null) {
                lVar.g(null);
            }
            this.D = i10;
            this.C = 1;
            int i11 = this.C;
            int i12 = this.D;
            z(new ParcelableVolumeInfo(i11, i12, 2, this.f673i.getStreamMaxVolume(i12), this.f673i.getStreamVolume(this.D)));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public b k() {
            b bVar;
            synchronized (this.f675k) {
                bVar = this.f680p;
            }
            return bVar;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void l(PendingIntent pendingIntent) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public Object m() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void n(boolean z10) {
            if (z10 == this.f679o) {
                return;
            }
            this.f679o = z10;
            D();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public k0.d o() {
            k0.d dVar;
            synchronized (this.f675k) {
                dVar = this.f681q;
            }
            return dVar;
        }

        public void p(int i10, int i11) {
            if (this.C != 2) {
                this.f673i.adjustStreamVolume(this.D, i10, i11);
                return;
            }
            k0.l lVar = this.E;
            if (lVar != null) {
                lVar.e(i10);
            }
        }

        public RemoteControlClient.MetadataEditor q(Bundle bundle) {
            RemoteControlClient.MetadataEditor editMetadata = this.f674j.editMetadata(true);
            if (bundle == null) {
                return editMetadata;
            }
            if (bundle.containsKey("android.media.metadata.ART")) {
                Bitmap bitmap = (Bitmap) bundle.getParcelable("android.media.metadata.ART");
                if (bitmap != null) {
                    bitmap = bitmap.copy(bitmap.getConfig(), false);
                }
                editMetadata.putBitmap(100, bitmap);
            } else if (bundle.containsKey("android.media.metadata.ALBUM_ART")) {
                Bitmap bitmap2 = (Bitmap) bundle.getParcelable("android.media.metadata.ALBUM_ART");
                if (bitmap2 != null) {
                    bitmap2 = bitmap2.copy(bitmap2.getConfig(), false);
                }
                editMetadata.putBitmap(100, bitmap2);
            }
            if (bundle.containsKey("android.media.metadata.ALBUM")) {
                editMetadata.putString(1, bundle.getString("android.media.metadata.ALBUM"));
            }
            if (bundle.containsKey("android.media.metadata.ALBUM_ARTIST")) {
                editMetadata.putString(13, bundle.getString("android.media.metadata.ALBUM_ARTIST"));
            }
            if (bundle.containsKey("android.media.metadata.ARTIST")) {
                editMetadata.putString(2, bundle.getString("android.media.metadata.ARTIST"));
            }
            if (bundle.containsKey("android.media.metadata.AUTHOR")) {
                editMetadata.putString(3, bundle.getString("android.media.metadata.AUTHOR"));
            }
            if (bundle.containsKey("android.media.metadata.COMPILATION")) {
                editMetadata.putString(15, bundle.getString("android.media.metadata.COMPILATION"));
            }
            if (bundle.containsKey("android.media.metadata.COMPOSER")) {
                editMetadata.putString(4, bundle.getString("android.media.metadata.COMPOSER"));
            }
            if (bundle.containsKey("android.media.metadata.DATE")) {
                editMetadata.putString(5, bundle.getString("android.media.metadata.DATE"));
            }
            if (bundle.containsKey("android.media.metadata.DISC_NUMBER")) {
                editMetadata.putLong(14, bundle.getLong("android.media.metadata.DISC_NUMBER"));
            }
            if (bundle.containsKey("android.media.metadata.DURATION")) {
                editMetadata.putLong(9, bundle.getLong("android.media.metadata.DURATION"));
            }
            if (bundle.containsKey("android.media.metadata.GENRE")) {
                editMetadata.putString(6, bundle.getString("android.media.metadata.GENRE"));
            }
            if (bundle.containsKey("android.media.metadata.TITLE")) {
                editMetadata.putString(7, bundle.getString("android.media.metadata.TITLE"));
            }
            if (bundle.containsKey("android.media.metadata.TRACK_NUMBER")) {
                editMetadata.putLong(0, bundle.getLong("android.media.metadata.TRACK_NUMBER"));
            }
            if (bundle.containsKey("android.media.metadata.WRITER")) {
                editMetadata.putString(11, bundle.getString("android.media.metadata.WRITER"));
            }
            return editMetadata;
        }

        public String r(int i10) {
            String nameForUid = this.f665a.getPackageManager().getNameForUid(i10);
            return TextUtils.isEmpty(nameForUid) ? "android.media.session.MediaController" : nameForUid;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void release() {
            this.f679o = false;
            this.f678n = true;
            D();
            x();
            b(null, null);
        }

        public int s(int i10) {
            switch (i10) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                case 8:
                    return 8;
                case 7:
                    return 9;
                case 9:
                    return 7;
                case 10:
                case 11:
                    return 6;
                default:
                    return -1;
            }
        }

        public int t(long j10) {
            int i10 = (1 & j10) != 0 ? 32 : 0;
            if ((2 & j10) != 0) {
                i10 |= 16;
            }
            if ((4 & j10) != 0) {
                i10 |= 4;
            }
            if ((8 & j10) != 0) {
                i10 |= 2;
            }
            if ((16 & j10) != 0) {
                i10 |= 1;
            }
            if ((32 & j10) != 0) {
                i10 |= 128;
            }
            if ((64 & j10) != 0) {
                i10 |= 64;
            }
            return (j10 & 512) != 0 ? i10 | 8 : i10;
        }

        public void u(int i10, int i11, int i12, Object obj, Bundle bundle) {
            synchronized (this.f675k) {
                d dVar = this.f677m;
                if (dVar != null) {
                    Message obtainMessage = dVar.obtainMessage(i10, i11, i12, obj);
                    Bundle bundle2 = new Bundle();
                    int callingUid = Binder.getCallingUid();
                    bundle2.putInt("data_calling_uid", callingUid);
                    bundle2.putString("data_calling_pkg", r(callingUid));
                    int callingPid = Binder.getCallingPid();
                    if (callingPid > 0) {
                        bundle2.putInt("data_calling_pid", callingPid);
                    } else {
                        bundle2.putInt("data_calling_pid", -1);
                    }
                    if (bundle != null) {
                        bundle2.putBundle("data_extras", bundle);
                    }
                    obtainMessage.setData(bundle2);
                    obtainMessage.sendToTarget();
                }
            }
        }

        public void v(PendingIntent pendingIntent, ComponentName componentName) {
            this.f673i.registerMediaButtonEventReceiver(componentName);
        }

        public final void w(MediaMetadataCompat mediaMetadataCompat) {
            for (int beginBroadcast = this.f676l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f676l.getBroadcastItem(beginBroadcast)).v(mediaMetadataCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f676l.finishBroadcast();
        }

        public final void x() {
            for (int beginBroadcast = this.f676l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f676l.getBroadcastItem(beginBroadcast)).t();
                } catch (RemoteException unused) {
                }
            }
            this.f676l.finishBroadcast();
            this.f676l.kill();
        }

        public final void y(PlaybackStateCompat playbackStateCompat) {
            for (int beginBroadcast = this.f676l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f676l.getBroadcastItem(beginBroadcast)).h0(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f676l.finishBroadcast();
        }

        public void z(ParcelableVolumeInfo parcelableVolumeInfo) {
            for (int beginBroadcast = this.f676l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f676l.getBroadcastItem(beginBroadcast)).G(parcelableVolumeInfo);
                } catch (RemoteException unused) {
                }
            }
            this.f676l.finishBroadcast();
        }
    }

    public interface j {
        void a();
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, null);
    }

    public static void c(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static PlaybackStateCompat g(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long j10 = -1;
        if (playbackStateCompat.f() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.g() != 3 && playbackStateCompat.g() != 4 && playbackStateCompat.g() != 5) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.c() <= 0) {
            return playbackStateCompat;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long d10 = ((long) (playbackStateCompat.d() * (elapsedRealtime - r0))) + playbackStateCompat.f();
        if (mediaMetadataCompat != null && mediaMetadataCompat.a("android.media.metadata.DURATION")) {
            j10 = mediaMetadataCompat.f("android.media.metadata.DURATION");
        }
        return new PlaybackStateCompat.b(playbackStateCompat).d(playbackStateCompat.g(), (j10 < 0 || d10 <= j10) ? d10 < 0 ? 0L : d10 : j10, playbackStateCompat.d(), elapsedRealtime).a();
    }

    public static Bundle s(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        c(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    public void a(j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.f635c.add(jVar);
    }

    public final MediaSession b(Context context, String str, Bundle bundle) {
        return Build.VERSION.SDK_INT >= 29 ? new MediaSession(context, str, bundle) : new MediaSession(context, str);
    }

    public MediaControllerCompat d() {
        return this.f634b;
    }

    public Object e() {
        return this.f633a.m();
    }

    public Token f() {
        return this.f633a.g();
    }

    public boolean h() {
        return this.f633a.isActive();
    }

    public void i() {
        this.f633a.release();
    }

    public void j(j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.f635c.remove(jVar);
    }

    public void k(boolean z10) {
        this.f633a.n(z10);
        Iterator it = this.f635c.iterator();
        while (it.hasNext()) {
            ((j) it.next()).a();
        }
    }

    public void l(b bVar) {
        m(bVar, null);
    }

    public void m(b bVar, Handler handler) {
        if (bVar == null) {
            this.f633a.b(null, null);
            return;
        }
        c cVar = this.f633a;
        if (handler == null) {
            handler = new Handler();
        }
        cVar.b(bVar, handler);
    }

    public void n(MediaMetadataCompat mediaMetadataCompat) {
        this.f633a.c(mediaMetadataCompat);
    }

    public void o(PlaybackStateCompat playbackStateCompat) {
        this.f633a.f(playbackStateCompat);
    }

    public void p(int i10) {
        this.f633a.j(i10);
    }

    public void q(k0.l lVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        this.f633a.a(lVar);
    }

    public void r(PendingIntent pendingIntent) {
        this.f633a.i(pendingIntent);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        this(context, str, componentName, pendingIntent, bundle, null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle, y0.d dVar) {
        this.f635c = new ArrayList();
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                ComponentName a10 = componentName == null ? m0.a.a(context) : componentName;
                if (a10 != null && pendingIntent == null) {
                    Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                    intent.setComponent(a10);
                    pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
                }
                PendingIntent pendingIntent2 = pendingIntent;
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 21) {
                    MediaSession b10 = b(context, str, bundle);
                    if (i10 >= 29) {
                        this.f633a = new h(b10, dVar, bundle);
                    } else if (i10 >= 28) {
                        this.f633a = new g(b10, dVar, bundle);
                    } else {
                        this.f633a = new f(b10, dVar, bundle);
                    }
                    m(new a(), new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()));
                    this.f633a.l(pendingIntent2);
                } else {
                    this.f633a = new e(context, str, a10, pendingIntent2, dVar, bundle);
                }
                this.f634b = new MediaControllerCompat(context, this);
                if (f632d == 0) {
                    f632d = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        throw new IllegalArgumentException("context must not be null");
    }

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final MediaDescriptionCompat f636a;

        /* renamed from: b, reason: collision with root package name */
        public final long f637b;

        /* renamed from: c, reason: collision with root package name */
        public MediaSession.QueueItem f638c;

        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public QueueItem[] newArray(int i10) {
                return new QueueItem[i10];
            }
        }

        public QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j10) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if (j10 == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.f636a = mediaDescriptionCompat;
            this.f637b = j10;
            this.f638c = queueItem;
        }

        public static QueueItem a(Object obj) {
            MediaDescription description;
            long queueId;
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            MediaSession.QueueItem a10 = k0.a(obj);
            description = a10.getDescription();
            MediaDescriptionCompat a11 = MediaDescriptionCompat.a(description);
            queueId = a10.getQueueId();
            return new QueueItem(a10, a11, queueId);
        }

        public static List b(List list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            return arrayList;
        }

        public MediaDescriptionCompat c() {
            return this.f636a;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f636a + ", Id=" + this.f637b + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            this.f636a.writeToParcel(parcel, i10);
            parcel.writeLong(this.f637b);
        }

        public QueueItem(Parcel parcel) {
            this.f636a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f637b = parcel.readLong();
        }
    }
}
