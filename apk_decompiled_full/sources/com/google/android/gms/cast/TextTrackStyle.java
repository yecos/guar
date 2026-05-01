package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.PlatformVersion;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "TextTrackStyleCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class TextTrackStyle extends AbstractSafeParcelable {
    public static final int COLOR_UNSPECIFIED = 0;

    @RecentlyNonNull
    @KeepForSdk
    public static final Parcelable.Creator<TextTrackStyle> CREATOR = new zzdo();
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;

    @SafeParcelable.Field(id = 13)
    String zza;

    @SafeParcelable.Field(getter = "getFontScale", id = 2)
    private float zzb;

    @SafeParcelable.Field(getter = "getForegroundColor", id = 3)
    private int zzc;

    @SafeParcelable.Field(getter = "getBackgroundColor", id = 4)
    private int zzd;

    @SafeParcelable.Field(getter = "getEdgeType", id = 5)
    private int zze;

    @SafeParcelable.Field(getter = "getEdgeColor", id = 6)
    private int zzf;

    @SafeParcelable.Field(getter = "getWindowType", id = 7)
    private int zzg;

    @SafeParcelable.Field(getter = "getWindowColor", id = 8)
    private int zzh;

    @SafeParcelable.Field(getter = "getWindowCornerRadius", id = 9)
    private int zzi;

    @SafeParcelable.Field(getter = "getFontFamily", id = 10)
    private String zzj;

    @SafeParcelable.Field(getter = "getFontGenericFamily", id = 11)
    private int zzk;

    @SafeParcelable.Field(getter = "getFontStyle", id = 12)
    private int zzl;
    private JSONObject zzm;

    public TextTrackStyle() {
        this(1.0f, 0, 0, -1, 0, -1, 0, 0, null, -1, -1, null);
    }

    @RecentlyNonNull
    public static TextTrackStyle fromSystemSettings(@RecentlyNonNull Context context) {
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (!PlatformVersion.isAtLeastKitKat()) {
            return textTrackStyle;
        }
        CaptioningManager captioningManager = (CaptioningManager) context.getSystemService("captioning");
        if (captioningManager == null) {
            return textTrackStyle;
        }
        textTrackStyle.setFontScale(captioningManager.getFontScale());
        CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
        textTrackStyle.setBackgroundColor(userStyle.backgroundColor);
        textTrackStyle.setForegroundColor(userStyle.foregroundColor);
        int i10 = userStyle.edgeType;
        if (i10 == 1) {
            textTrackStyle.setEdgeType(1);
        } else if (i10 != 2) {
            textTrackStyle.setEdgeType(0);
        } else {
            textTrackStyle.setEdgeType(2);
        }
        textTrackStyle.setEdgeColor(userStyle.edgeColor);
        Typeface typeface = userStyle.getTypeface();
        if (typeface != null) {
            if (Typeface.MONOSPACE.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(1);
            } else if (Typeface.SANS_SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(0);
            } else if (Typeface.SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(2);
            } else {
                textTrackStyle.setFontGenericFamily(0);
            }
            boolean isBold = typeface.isBold();
            boolean isItalic = typeface.isItalic();
            if (isBold && isItalic) {
                textTrackStyle.setFontStyle(3);
            } else if (isBold) {
                textTrackStyle.setFontStyle(1);
            } else if (isItalic) {
                textTrackStyle.setFontStyle(2);
            } else {
                textTrackStyle.setFontStyle(0);
            }
        }
        return textTrackStyle;
    }

    private static final int zzb(String str) {
        if (str != null && str.length() == 9 && str.charAt(0) == '#') {
            try {
                return Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    private static final String zzc(int i10) {
        return String.format("#%02X%02X%02X%02X", Integer.valueOf(Color.red(i10)), Integer.valueOf(Color.green(i10)), Integer.valueOf(Color.blue(i10)), Integer.valueOf(Color.alpha(i10)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) obj;
        JSONObject jSONObject = this.zzm;
        boolean z10 = jSONObject == null;
        JSONObject jSONObject2 = textTrackStyle.zzm;
        if (z10 != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && this.zzb == textTrackStyle.zzb && this.zzc == textTrackStyle.zzc && this.zzd == textTrackStyle.zzd && this.zze == textTrackStyle.zze && this.zzf == textTrackStyle.zzf && this.zzg == textTrackStyle.zzg && this.zzh == textTrackStyle.zzh && this.zzi == textTrackStyle.zzi && CastUtils.zzh(this.zzj, textTrackStyle.zzj) && this.zzk == textTrackStyle.zzk && this.zzl == textTrackStyle.zzl;
    }

    @KeepForSdk
    public void fromJson(@RecentlyNonNull JSONObject jSONObject) {
        this.zzb = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.zzc = zzb(jSONObject.optString("foregroundColor"));
        this.zzd = zzb(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            String string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.zze = 0;
            } else if ("OUTLINE".equals(string)) {
                this.zze = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.zze = 2;
            } else if ("RAISED".equals(string)) {
                this.zze = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.zze = 4;
            }
        }
        this.zzf = zzb(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            String string2 = jSONObject.getString("windowType");
            if ("NONE".equals(string2)) {
                this.zzg = 0;
            } else if ("NORMAL".equals(string2)) {
                this.zzg = 1;
            } else if ("ROUNDED_CORNERS".equals(string2)) {
                this.zzg = 2;
            }
        }
        this.zzh = zzb(jSONObject.optString("windowColor"));
        if (this.zzg == 2) {
            this.zzi = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.zzj = CastUtils.optStringOrNull(jSONObject, "fontFamily");
        if (jSONObject.has("fontGenericFamily")) {
            String string3 = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string3)) {
                this.zzk = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string3)) {
                this.zzk = 1;
            } else if ("SERIF".equals(string3)) {
                this.zzk = 2;
            } else if ("MONOSPACED_SERIF".equals(string3)) {
                this.zzk = 3;
            } else if ("CASUAL".equals(string3)) {
                this.zzk = 4;
            } else if ("CURSIVE".equals(string3)) {
                this.zzk = 5;
            } else if ("SMALL_CAPITALS".equals(string3)) {
                this.zzk = 6;
            }
        }
        if (jSONObject.has("fontStyle")) {
            String string4 = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string4)) {
                this.zzl = 0;
            } else if ("BOLD".equals(string4)) {
                this.zzl = 1;
            } else if ("ITALIC".equals(string4)) {
                this.zzl = 2;
            } else if ("BOLD_ITALIC".equals(string4)) {
                this.zzl = 3;
            }
        }
        this.zzm = jSONObject.optJSONObject("customData");
    }

    public int getBackgroundColor() {
        return this.zzd;
    }

    @RecentlyNullable
    public JSONObject getCustomData() {
        return this.zzm;
    }

    public int getEdgeColor() {
        return this.zzf;
    }

    public int getEdgeType() {
        return this.zze;
    }

    @RecentlyNullable
    public String getFontFamily() {
        return this.zzj;
    }

    public int getFontGenericFamily() {
        return this.zzk;
    }

    public float getFontScale() {
        return this.zzb;
    }

    public int getFontStyle() {
        return this.zzl;
    }

    public int getForegroundColor() {
        return this.zzc;
    }

    public int getWindowColor() {
        return this.zzh;
    }

    public int getWindowCornerRadius() {
        return this.zzi;
    }

    public int getWindowType() {
        return this.zzg;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Integer.valueOf(this.zzf), Integer.valueOf(this.zzg), Integer.valueOf(this.zzh), Integer.valueOf(this.zzi), this.zzj, Integer.valueOf(this.zzk), Integer.valueOf(this.zzl), String.valueOf(this.zzm));
    }

    public void setBackgroundColor(int i10) {
        this.zzd = i10;
    }

    public void setCustomData(@RecentlyNonNull JSONObject jSONObject) {
        this.zzm = jSONObject;
    }

    public void setEdgeColor(int i10) {
        this.zzf = i10;
    }

    public void setEdgeType(int i10) {
        if (i10 < 0 || i10 > 4) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.zze = i10;
    }

    public void setFontFamily(@RecentlyNonNull String str) {
        this.zzj = str;
    }

    public void setFontGenericFamily(int i10) {
        if (i10 < 0 || i10 > 6) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.zzk = i10;
    }

    public void setFontScale(float f10) {
        this.zzb = f10;
    }

    public void setFontStyle(int i10) {
        if (i10 < 0 || i10 > 3) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.zzl = i10;
    }

    public void setForegroundColor(int i10) {
        this.zzc = i10;
    }

    public void setWindowColor(int i10) {
        this.zzh = i10;
    }

    public void setWindowCornerRadius(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        }
        this.zzi = i10;
    }

    public void setWindowType(int i10) {
        if (i10 < 0 || i10 > 2) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.zzg = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        JSONObject jSONObject = this.zzm;
        this.zza = jSONObject == null ? null : jSONObject.toString();
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 2, getFontScale());
        SafeParcelWriter.writeInt(parcel, 3, getForegroundColor());
        SafeParcelWriter.writeInt(parcel, 4, getBackgroundColor());
        SafeParcelWriter.writeInt(parcel, 5, getEdgeType());
        SafeParcelWriter.writeInt(parcel, 6, getEdgeColor());
        SafeParcelWriter.writeInt(parcel, 7, getWindowType());
        SafeParcelWriter.writeInt(parcel, 8, getWindowColor());
        SafeParcelWriter.writeInt(parcel, 9, getWindowCornerRadius());
        SafeParcelWriter.writeString(parcel, 10, getFontFamily(), false);
        SafeParcelWriter.writeInt(parcel, 11, getFontGenericFamily());
        SafeParcelWriter.writeInt(parcel, 12, getFontStyle());
        SafeParcelWriter.writeString(parcel, 13, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @RecentlyNonNull
    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", this.zzb);
            int i10 = this.zzc;
            if (i10 != 0) {
                jSONObject.put("foregroundColor", zzc(i10));
            }
            int i11 = this.zzd;
            if (i11 != 0) {
                jSONObject.put("backgroundColor", zzc(i11));
            }
            int i12 = this.zze;
            if (i12 == 0) {
                jSONObject.put("edgeType", "NONE");
            } else if (i12 == 1) {
                jSONObject.put("edgeType", "OUTLINE");
            } else if (i12 == 2) {
                jSONObject.put("edgeType", "DROP_SHADOW");
            } else if (i12 == 3) {
                jSONObject.put("edgeType", "RAISED");
            } else if (i12 == 4) {
                jSONObject.put("edgeType", "DEPRESSED");
            }
            int i13 = this.zzf;
            if (i13 != 0) {
                jSONObject.put("edgeColor", zzc(i13));
            }
            int i14 = this.zzg;
            if (i14 == 0) {
                jSONObject.put("windowType", "NONE");
            } else if (i14 == 1) {
                jSONObject.put("windowType", "NORMAL");
            } else if (i14 == 2) {
                jSONObject.put("windowType", "ROUNDED_CORNERS");
            }
            int i15 = this.zzh;
            if (i15 != 0) {
                jSONObject.put("windowColor", zzc(i15));
            }
            if (this.zzg == 2) {
                jSONObject.put("windowRoundedCornerRadius", this.zzi);
            }
            String str = this.zzj;
            if (str != null) {
                jSONObject.put("fontFamily", str);
            }
            switch (this.zzk) {
                case 0:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case 1:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case 2:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case 3:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case 4:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case 5:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case 6:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            int i16 = this.zzl;
            if (i16 == 0) {
                jSONObject.put("fontStyle", "NORMAL");
            } else if (i16 == 1) {
                jSONObject.put("fontStyle", "BOLD");
            } else if (i16 == 2) {
                jSONObject.put("fontStyle", "ITALIC");
            } else if (i16 == 3) {
                jSONObject.put("fontStyle", "BOLD_ITALIC");
            }
            JSONObject jSONObject2 = this.zzm;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @SafeParcelable.Constructor
    public TextTrackStyle(@SafeParcelable.Param(id = 2) float f10, @SafeParcelable.Param(id = 3) int i10, @SafeParcelable.Param(id = 4) int i11, @SafeParcelable.Param(id = 5) int i12, @SafeParcelable.Param(id = 6) int i13, @SafeParcelable.Param(id = 7) int i14, @SafeParcelable.Param(id = 8) int i15, @SafeParcelable.Param(id = 9) int i16, @SafeParcelable.Param(id = 10) String str, @SafeParcelable.Param(id = 11) int i17, @SafeParcelable.Param(id = 12) int i18, @SafeParcelable.Param(id = 13) String str2) {
        this.zzb = f10;
        this.zzc = i10;
        this.zzd = i11;
        this.zze = i12;
        this.zzf = i13;
        this.zzg = i14;
        this.zzh = i15;
        this.zzi = i16;
        this.zzj = str;
        this.zzk = i17;
        this.zzl = i18;
        this.zza = str2;
        if (str2 == null) {
            this.zzm = null;
            return;
        }
        try {
            this.zzm = new JSONObject(str2);
        } catch (JSONException unused) {
            this.zzm = null;
            this.zza = null;
        }
    }
}
