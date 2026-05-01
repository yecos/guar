package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f702a;

    /* renamed from: b, reason: collision with root package name */
    public final long f703b;

    /* renamed from: c, reason: collision with root package name */
    public final long f704c;

    /* renamed from: d, reason: collision with root package name */
    public final float f705d;

    /* renamed from: e, reason: collision with root package name */
    public final long f706e;

    /* renamed from: f, reason: collision with root package name */
    public final int f707f;

    /* renamed from: g, reason: collision with root package name */
    public final CharSequence f708g;

    /* renamed from: h, reason: collision with root package name */
    public final long f709h;

    /* renamed from: i, reason: collision with root package name */
    public List f710i;

    /* renamed from: j, reason: collision with root package name */
    public final long f711j;

    /* renamed from: k, reason: collision with root package name */
    public final Bundle f712k;

    /* renamed from: l, reason: collision with root package name */
    public PlaybackState f713l;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i10) {
            return new PlaybackStateCompat[i10];
        }
    }

    public PlaybackStateCompat(int i10, long j10, long j11, float f10, long j12, int i11, CharSequence charSequence, long j13, List list, long j14, Bundle bundle) {
        this.f702a = i10;
        this.f703b = j10;
        this.f704c = j11;
        this.f705d = f10;
        this.f706e = j12;
        this.f707f = i11;
        this.f708g = charSequence;
        this.f709h = j13;
        this.f710i = new ArrayList(list);
        this.f711j = j14;
        this.f712k = bundle;
    }

    public static PlaybackStateCompat a(Object obj) {
        List customActions;
        ArrayList arrayList;
        int state;
        long position;
        long bufferedPosition;
        float playbackSpeed;
        long actions;
        CharSequence errorMessage;
        long lastPositionUpdateTime;
        long activeQueueItemId;
        Bundle bundle = null;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        PlaybackState a10 = u.a(obj);
        customActions = a10.getCustomActions();
        if (customActions != null) {
            ArrayList arrayList2 = new ArrayList(customActions.size());
            Iterator it = customActions.iterator();
            while (it.hasNext()) {
                arrayList2.add(CustomAction.a(it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = a10.getExtras();
            MediaSessionCompat.c(bundle);
        }
        state = a10.getState();
        position = a10.getPosition();
        bufferedPosition = a10.getBufferedPosition();
        playbackSpeed = a10.getPlaybackSpeed();
        actions = a10.getActions();
        errorMessage = a10.getErrorMessage();
        lastPositionUpdateTime = a10.getLastPositionUpdateTime();
        activeQueueItemId = a10.getActiveQueueItemId();
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(state, position, bufferedPosition, playbackSpeed, actions, 0, errorMessage, lastPositionUpdateTime, arrayList, activeQueueItemId, bundle);
        playbackStateCompat.f713l = a10;
        return playbackStateCompat;
    }

    public long b() {
        return this.f706e;
    }

    public long c() {
        return this.f709h;
    }

    public float d() {
        return this.f705d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object e() {
        PlaybackState build;
        if (this.f713l == null && Build.VERSION.SDK_INT >= 21) {
            PlaybackState.Builder builder = new PlaybackState.Builder();
            builder.setState(this.f702a, this.f703b, this.f705d, this.f709h);
            builder.setBufferedPosition(this.f704c);
            builder.setActions(this.f706e);
            builder.setErrorMessage(this.f708g);
            Iterator it = this.f710i.iterator();
            while (it.hasNext()) {
                builder.addCustomAction(s0.a(((CustomAction) it.next()).b()));
            }
            builder.setActiveQueueItemId(this.f711j);
            if (Build.VERSION.SDK_INT >= 22) {
                builder.setExtras(this.f712k);
            }
            build = builder.build();
            this.f713l = build;
        }
        return this.f713l;
    }

    public long f() {
        return this.f703b;
    }

    public int g() {
        return this.f702a;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f702a + ", position=" + this.f703b + ", buffered position=" + this.f704c + ", speed=" + this.f705d + ", updated=" + this.f709h + ", actions=" + this.f706e + ", error code=" + this.f707f + ", error message=" + this.f708g + ", custom actions=" + this.f710i + ", active item id=" + this.f711j + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f702a);
        parcel.writeLong(this.f703b);
        parcel.writeFloat(this.f705d);
        parcel.writeLong(this.f709h);
        parcel.writeLong(this.f704c);
        parcel.writeLong(this.f706e);
        TextUtils.writeToParcel(this.f708g, parcel, i10);
        parcel.writeTypedList(this.f710i);
        parcel.writeLong(this.f711j);
        parcel.writeBundle(this.f712k);
        parcel.writeInt(this.f707f);
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final List f719a;

        /* renamed from: b, reason: collision with root package name */
        public int f720b;

        /* renamed from: c, reason: collision with root package name */
        public long f721c;

        /* renamed from: d, reason: collision with root package name */
        public long f722d;

        /* renamed from: e, reason: collision with root package name */
        public float f723e;

        /* renamed from: f, reason: collision with root package name */
        public long f724f;

        /* renamed from: g, reason: collision with root package name */
        public int f725g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f726h;

        /* renamed from: i, reason: collision with root package name */
        public long f727i;

        /* renamed from: j, reason: collision with root package name */
        public long f728j;

        /* renamed from: k, reason: collision with root package name */
        public Bundle f729k;

        public b() {
            this.f719a = new ArrayList();
            this.f728j = -1L;
        }

        public PlaybackStateCompat a() {
            return new PlaybackStateCompat(this.f720b, this.f721c, this.f722d, this.f723e, this.f724f, this.f725g, this.f726h, this.f727i, this.f719a, this.f728j, this.f729k);
        }

        public b b(long j10) {
            this.f724f = j10;
            return this;
        }

        public b c(int i10, long j10, float f10) {
            return d(i10, j10, f10, SystemClock.elapsedRealtime());
        }

        public b d(int i10, long j10, float f10, long j11) {
            this.f720b = i10;
            this.f721c = j10;
            this.f727i = j11;
            this.f723e = f10;
            return this;
        }

        public b(PlaybackStateCompat playbackStateCompat) {
            ArrayList arrayList = new ArrayList();
            this.f719a = arrayList;
            this.f728j = -1L;
            this.f720b = playbackStateCompat.f702a;
            this.f721c = playbackStateCompat.f703b;
            this.f723e = playbackStateCompat.f705d;
            this.f727i = playbackStateCompat.f709h;
            this.f722d = playbackStateCompat.f704c;
            this.f724f = playbackStateCompat.f706e;
            this.f725g = playbackStateCompat.f707f;
            this.f726h = playbackStateCompat.f708g;
            List list = playbackStateCompat.f710i;
            if (list != null) {
                arrayList.addAll(list);
            }
            this.f728j = playbackStateCompat.f711j;
            this.f729k = playbackStateCompat.f712k;
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final String f714a;

        /* renamed from: b, reason: collision with root package name */
        public final CharSequence f715b;

        /* renamed from: c, reason: collision with root package name */
        public final int f716c;

        /* renamed from: d, reason: collision with root package name */
        public final Bundle f717d;

        /* renamed from: e, reason: collision with root package name */
        public PlaybackState.CustomAction f718e;

        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i10) {
                return new CustomAction[i10];
            }
        }

        public CustomAction(String str, CharSequence charSequence, int i10, Bundle bundle) {
            this.f714a = str;
            this.f715b = charSequence;
            this.f716c = i10;
            this.f717d = bundle;
        }

        public static CustomAction a(Object obj) {
            Bundle extras;
            String action;
            CharSequence name;
            int icon;
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            PlaybackState.CustomAction a10 = s0.a(obj);
            extras = a10.getExtras();
            MediaSessionCompat.c(extras);
            action = a10.getAction();
            name = a10.getName();
            icon = a10.getIcon();
            CustomAction customAction = new CustomAction(action, name, icon, extras);
            customAction.f718e = a10;
            return customAction;
        }

        public Object b() {
            PlaybackState.CustomAction build;
            PlaybackState.CustomAction customAction = this.f718e;
            if (customAction != null || Build.VERSION.SDK_INT < 21) {
                return customAction;
            }
            PlaybackState.CustomAction.Builder builder = new PlaybackState.CustomAction.Builder(this.f714a, this.f715b, this.f716c);
            builder.setExtras(this.f717d);
            build = builder.build();
            return build;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f715b) + ", mIcon=" + this.f716c + ", mExtras=" + this.f717d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f714a);
            TextUtils.writeToParcel(this.f715b, parcel, i10);
            parcel.writeInt(this.f716c);
            parcel.writeBundle(this.f717d);
        }

        public CustomAction(Parcel parcel) {
            this.f714a = parcel.readString();
            this.f715b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f716c = parcel.readInt();
            this.f717d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f702a = parcel.readInt();
        this.f703b = parcel.readLong();
        this.f705d = parcel.readFloat();
        this.f709h = parcel.readLong();
        this.f704c = parcel.readLong();
        this.f706e = parcel.readLong();
        this.f708g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f710i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f711j = parcel.readLong();
        this.f712k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f707f = parcel.readInt();
    }
}
