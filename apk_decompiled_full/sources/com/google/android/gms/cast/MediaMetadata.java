package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "MediaMetadataCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class MediaMetadata extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";

    @RecentlyNonNull
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";

    @RecentlyNonNull
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";

    @RecentlyNonNull
    public static final String KEY_BOOK_TITLE = "com.google.android.gms.cast.metadata.BOOK_TITLE";

    @RecentlyNonNull
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";

    @RecentlyNonNull
    public static final String KEY_CHAPTER_NUMBER = "com.google.android.gms.cast.metadata.CHAPTER_NUMBER";

    @RecentlyNonNull
    public static final String KEY_CHAPTER_TITLE = "com.google.android.gms.cast.metadata.CHAPTER_TITLE";

    @RecentlyNonNull
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";

    @RecentlyNonNull
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";

    @RecentlyNonNull
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";

    @RecentlyNonNull
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";

    @RecentlyNonNull
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";

    @RecentlyNonNull
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";

    @RecentlyNonNull
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";

    @RecentlyNonNull
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";

    @RecentlyNonNull
    public static final String KEY_QUEUE_ITEM_ID = "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID";

    @RecentlyNonNull
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";

    @RecentlyNonNull
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";

    @RecentlyNonNull
    public static final String KEY_SECTION_DURATION = "com.google.android.gms.cast.metadata.SECTION_DURATION";

    @RecentlyNonNull
    public static final String KEY_SECTION_START_ABSOLUTE_TIME = "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME";

    @RecentlyNonNull
    public static final String KEY_SECTION_START_TIME_IN_CONTAINER = "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER";

    @RecentlyNonNull
    public static final String KEY_SECTION_START_TIME_IN_MEDIA = "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA";

    @RecentlyNonNull
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";

    @RecentlyNonNull
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";

    @RecentlyNonNull
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";

    @RecentlyNonNull
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";

    @RecentlyNonNull
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";

    @RecentlyNonNull
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_AUDIOBOOK_CHAPTER = 5;
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    private static final zzbz zzc;

    @SafeParcelable.Field(id = 3)
    final Bundle zza;

    @SafeParcelable.Field(getter = "getImages", id = 2)
    private final List<WebImage> zzd;

    @SafeParcelable.Field(getter = "getMediaType", id = 4)
    private int zze;
    private final Writer zzf;
    private static final String[] zzb = {"none", "String", "int", "double", "ISO-8601 date String", "Time in milliseconds as long"};

    @RecentlyNonNull
    public static final Parcelable.Creator<MediaMetadata> CREATOR = new zzca();

    @KeepForSdk
    public class Writer {
        public Writer() {
        }

        @RecentlyNullable
        @KeepForSdk
        public Object getRawValue(@RecentlyNonNull String str) {
            return MediaMetadata.this.zza.get(str);
        }

        @KeepForSdk
        public void remove(@RecentlyNonNull String str) {
            MediaMetadata.this.zza.remove(str);
        }

        @KeepForSdk
        public void setMediaType(int i10) {
            MediaMetadata.this.zze = i10;
        }
    }

    static {
        zzbz zzbzVar = new zzbz();
        zzbzVar.zzb(KEY_CREATION_DATE, "creationDateTime", 4);
        zzbzVar.zzb(KEY_RELEASE_DATE, "releaseDate", 4);
        zzbzVar.zzb(KEY_BROADCAST_DATE, "originalAirdate", 4);
        zzbzVar.zzb(KEY_TITLE, "title", 1);
        zzbzVar.zzb(KEY_SUBTITLE, MediaTrack.ROLE_SUBTITLE, 1);
        zzbzVar.zzb(KEY_ARTIST, "artist", 1);
        zzbzVar.zzb(KEY_ALBUM_ARTIST, "albumArtist", 1);
        zzbzVar.zzb(KEY_ALBUM_TITLE, "albumName", 1);
        zzbzVar.zzb(KEY_COMPOSER, "composer", 1);
        zzbzVar.zzb(KEY_DISC_NUMBER, "discNumber", 2);
        zzbzVar.zzb(KEY_TRACK_NUMBER, "trackNumber", 2);
        zzbzVar.zzb(KEY_SEASON_NUMBER, "season", 2);
        zzbzVar.zzb(KEY_EPISODE_NUMBER, "episode", 2);
        zzbzVar.zzb(KEY_SERIES_TITLE, "seriesTitle", 1);
        zzbzVar.zzb(KEY_STUDIO, "studio", 1);
        zzbzVar.zzb(KEY_WIDTH, "width", 2);
        zzbzVar.zzb(KEY_HEIGHT, "height", 2);
        zzbzVar.zzb(KEY_LOCATION_NAME, "location", 1);
        zzbzVar.zzb(KEY_LOCATION_LATITUDE, "latitude", 3);
        zzbzVar.zzb(KEY_LOCATION_LONGITUDE, "longitude", 3);
        zzbzVar.zzb(KEY_SECTION_DURATION, "sectionDuration", 5);
        zzbzVar.zzb(KEY_SECTION_START_TIME_IN_MEDIA, "sectionStartTimeInMedia", 5);
        zzbzVar.zzb(KEY_SECTION_START_ABSOLUTE_TIME, "sectionStartAbsoluteTime", 5);
        zzbzVar.zzb(KEY_SECTION_START_TIME_IN_CONTAINER, "sectionStartTimeInContainer", 5);
        zzbzVar.zzb(KEY_QUEUE_ITEM_ID, "queueItemId", 2);
        zzbzVar.zzb(KEY_BOOK_TITLE, "bookTitle", 1);
        zzbzVar.zzb(KEY_CHAPTER_NUMBER, "chapterNumber", 2);
        zzbzVar.zzb(KEY_CHAPTER_TITLE, "chapterTitle", 1);
        zzc = zzbzVar;
    }

    public MediaMetadata() {
        this(0);
    }

    @KeepForSdk
    public static int getTypeForKey(@RecentlyNonNull String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        return zzc.zza(str);
    }

    @KeepForSdk
    public static void throwIfWrongType(@RecentlyNonNull String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int zza = zzc.zza(str);
        if (zza == i10 || zza == 0) {
            return;
        }
        String str2 = zzb[i10];
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length());
        sb.append("Value for ");
        sb.append(str);
        sb.append(" must be a ");
        sb.append(str2);
        throw new IllegalArgumentException(sb.toString());
    }

    private final boolean zzd(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !zzd((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    public void addImage(@RecentlyNonNull WebImage webImage) {
        this.zzd.add(webImage);
    }

    public void clear() {
        this.zza.clear();
        this.zzd.clear();
    }

    public void clearImages() {
        this.zzd.clear();
    }

    public boolean containsKey(@RecentlyNonNull String str) {
        return this.zza.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return zzd(this.zza, mediaMetadata.zza) && this.zzd.equals(mediaMetadata.zzd);
    }

    @RecentlyNullable
    public Calendar getDate(@RecentlyNonNull String str) {
        throwIfWrongType(str, 4);
        String string = this.zza.getString(str);
        if (string != null) {
            return com.google.android.gms.cast.internal.media.zza.zzb(string);
        }
        return null;
    }

    @RecentlyNullable
    public String getDateAsString(@RecentlyNonNull String str) {
        throwIfWrongType(str, 4);
        return this.zza.getString(str);
    }

    public double getDouble(@RecentlyNonNull String str) {
        throwIfWrongType(str, 3);
        return this.zza.getDouble(str);
    }

    @RecentlyNonNull
    public List<WebImage> getImages() {
        return this.zzd;
    }

    public int getInt(@RecentlyNonNull String str) {
        throwIfWrongType(str, 2);
        return this.zza.getInt(str);
    }

    public int getMediaType() {
        return this.zze;
    }

    @RecentlyNullable
    public String getString(@RecentlyNonNull String str) {
        throwIfWrongType(str, 1);
        return this.zza.getString(str);
    }

    public long getTimeMillis(@RecentlyNonNull String str) {
        throwIfWrongType(str, 5);
        return this.zza.getLong(str);
    }

    @RecentlyNonNull
    @KeepForSdk
    public Writer getWriter() {
        return this.zzf;
    }

    public boolean hasImages() {
        List<WebImage> list = this.zzd;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public int hashCode() {
        Bundle bundle = this.zza;
        int i10 = 17;
        if (bundle != null) {
            Iterator<String> it = bundle.keySet().iterator();
            while (it.hasNext()) {
                Object obj = this.zza.get(it.next());
                i10 = (i10 * 31) + (obj != null ? obj.hashCode() : 0);
            }
        }
        return (i10 * 31) + this.zzd.hashCode();
    }

    @RecentlyNonNull
    public Set<String> keySet() {
        return this.zza.keySet();
    }

    public void putDate(@RecentlyNonNull String str, @RecentlyNonNull Calendar calendar) {
        throwIfWrongType(str, 4);
        this.zza.putString(str, com.google.android.gms.cast.internal.media.zza.zza(calendar));
    }

    public void putDouble(@RecentlyNonNull String str, double d10) {
        throwIfWrongType(str, 3);
        this.zza.putDouble(str, d10);
    }

    public void putInt(@RecentlyNonNull String str, int i10) {
        throwIfWrongType(str, 2);
        this.zza.putInt(str, i10);
    }

    public void putString(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        throwIfWrongType(str, 1);
        this.zza.putString(str, str2);
    }

    public void putTimeMillis(@RecentlyNonNull String str, long j10) {
        throwIfWrongType(str, 5);
        this.zza.putLong(str, j10);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, getImages(), false);
        SafeParcelWriter.writeBundle(parcel, 3, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 4, getMediaType());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @RecentlyNonNull
    public final JSONObject zza() {
        zzbz zzbzVar;
        String zzc2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.zze);
        } catch (JSONException unused) {
        }
        JSONArray zzc3 = com.google.android.gms.cast.internal.media.zza.zzc(this.zzd);
        if (zzc3.length() != 0) {
            try {
                jSONObject.put("images", zzc3);
            } catch (JSONException unused2) {
            }
        }
        ArrayList<String> arrayList = new ArrayList();
        int i10 = this.zze;
        if (i10 == 0) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
        } else if (i10 == 1) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
        } else if (i10 == 2) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
        } else if (i10 == 3) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_ARTIST, KEY_ALBUM_TITLE, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
        } else if (i10 == 4) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
        } else if (i10 == 5) {
            Collections.addAll(arrayList, KEY_CHAPTER_TITLE, KEY_CHAPTER_NUMBER, KEY_TITLE, KEY_BOOK_TITLE, KEY_SUBTITLE);
        }
        Collections.addAll(arrayList, KEY_SECTION_DURATION, KEY_SECTION_START_TIME_IN_MEDIA, KEY_SECTION_START_ABSOLUTE_TIME, KEY_SECTION_START_TIME_IN_CONTAINER, KEY_QUEUE_ITEM_ID);
        try {
            for (String str : arrayList) {
                if (str != null && this.zza.containsKey(str) && (zzc2 = (zzbzVar = zzc).zzc(str)) != null) {
                    int zza = zzbzVar.zza(str);
                    if (zza != 1) {
                        if (zza == 2) {
                            jSONObject.put(zzc2, this.zza.getInt(str));
                        } else if (zza == 3) {
                            jSONObject.put(zzc2, this.zza.getDouble(str));
                        } else if (zza != 4) {
                            if (zza == 5) {
                                jSONObject.put(zzc2, CastUtils.millisecToSec(this.zza.getLong(str)));
                            }
                        }
                    }
                    jSONObject.put(zzc2, this.zza.getString(str));
                }
            }
            for (String str2 : this.zza.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.zza.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException unused3) {
        }
        return jSONObject;
    }

    public final void zzc(@RecentlyNonNull JSONObject jSONObject) {
        clear();
        this.zze = 0;
        try {
            this.zze = jSONObject.getInt("metadataType");
        } catch (JSONException unused) {
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        if (optJSONArray != null) {
            com.google.android.gms.cast.internal.media.zza.zzd(this.zzd, optJSONArray);
        }
        ArrayList arrayList = new ArrayList();
        int i10 = this.zze;
        if (i10 == 0) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
        } else if (i10 == 1) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
        } else if (i10 == 2) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
        } else if (i10 == 3) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_ALBUM_TITLE, KEY_ARTIST, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
        } else if (i10 == 4) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
        } else if (i10 == 5) {
            Collections.addAll(arrayList, KEY_CHAPTER_TITLE, KEY_CHAPTER_NUMBER, KEY_TITLE, KEY_BOOK_TITLE, KEY_SUBTITLE);
        }
        Collections.addAll(arrayList, KEY_SECTION_DURATION, KEY_SECTION_START_TIME_IN_MEDIA, KEY_SECTION_START_ABSOLUTE_TIME, KEY_SECTION_START_TIME_IN_CONTAINER, KEY_QUEUE_ITEM_ID);
        HashSet hashSet = new HashSet(arrayList);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && !"metadataType".equals(next)) {
                    zzbz zzbzVar = zzc;
                    String zzd = zzbzVar.zzd(next);
                    if (zzd == null) {
                        Object obj = jSONObject.get(next);
                        if (obj instanceof String) {
                            this.zza.putString(next, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.zza.putInt(next, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.zza.putDouble(next, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(zzd)) {
                        try {
                            Object obj2 = jSONObject.get(next);
                            if (obj2 != null) {
                                int zza = zzbzVar.zza(zzd);
                                if (zza != 1) {
                                    if (zza != 2) {
                                        if (zza == 3) {
                                            double optDouble = jSONObject.optDouble(next);
                                            if (!Double.isNaN(optDouble)) {
                                                this.zza.putDouble(zzd, optDouble);
                                            }
                                        } else if (zza != 4) {
                                            if (zza == 5) {
                                                this.zza.putLong(zzd, CastUtils.secToMillisec(jSONObject.optLong(next)));
                                            }
                                        } else if (obj2 instanceof String) {
                                            String str = (String) obj2;
                                            if (com.google.android.gms.cast.internal.media.zza.zzb(str) != null) {
                                                this.zza.putString(zzd, str);
                                            }
                                        }
                                    } else if (obj2 instanceof Integer) {
                                        this.zza.putInt(zzd, ((Integer) obj2).intValue());
                                    }
                                } else if (obj2 instanceof String) {
                                    this.zza.putString(zzd, (String) obj2);
                                }
                            }
                        } catch (JSONException unused2) {
                        }
                    }
                }
            }
        } catch (JSONException unused3) {
        }
    }

    public MediaMetadata(int i10) {
        this(new ArrayList(), new Bundle(), i10);
    }

    @SafeParcelable.Constructor
    public MediaMetadata(@SafeParcelable.Param(id = 2) List<WebImage> list, @SafeParcelable.Param(id = 3) Bundle bundle, @SafeParcelable.Param(id = 4) int i10) {
        this.zzf = new Writer();
        this.zzd = list;
        this.zza = bundle;
        this.zze = i10;
    }
}
