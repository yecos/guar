package com.google.android.gms.cast.framework.media;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class zzbv extends ArrayAdapter<MediaTrack> implements View.OnClickListener {
    private final Context zza;
    private int zzb;

    public zzbv(Context context, List<MediaTrack> list, int i10) {
        super(context, R.layout.cast_tracks_chooser_dialog_row_layout, list == null ? new ArrayList<>() : list);
        this.zza = context;
        this.zzb = i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x008c, code lost:
    
        if (android.text.TextUtils.isEmpty(r2) == false) goto L20;
     */
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        zzbu zzbuVar;
        if (view == null) {
            view = ((LayoutInflater) Preconditions.checkNotNull((LayoutInflater) this.zza.getSystemService("layout_inflater"))).inflate(R.layout.cast_tracks_chooser_dialog_row_layout, viewGroup, false);
            zzbuVar = new zzbu(this, (TextView) view.findViewById(R.id.text), (RadioButton) view.findViewById(R.id.radio), null);
            view.setTag(zzbuVar);
        } else {
            zzbuVar = (zzbu) Preconditions.checkNotNull((zzbu) view.getTag());
        }
        zzbuVar.zzb.setTag(Integer.valueOf(i10));
        zzbuVar.zzb.setChecked(this.zzb == i10);
        view.setOnClickListener(this);
        MediaTrack mediaTrack = (MediaTrack) Preconditions.checkNotNull((MediaTrack) getItem(i10));
        String name = mediaTrack.getName();
        Locale languageLocale = mediaTrack.getLanguageLocale();
        if (TextUtils.isEmpty(name)) {
            if (mediaTrack.getSubtype() == 2) {
                name = this.zza.getString(R.string.cast_tracks_chooser_dialog_closed_captions);
            } else {
                if (languageLocale != null) {
                    name = languageLocale.getDisplayLanguage();
                }
                name = this.zza.getString(R.string.cast_tracks_chooser_dialog_default_track_name, Integer.valueOf(i10 + 1));
            }
        }
        zzbuVar.zza.setText(name);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zzb = ((Integer) Preconditions.checkNotNull(((zzbu) Preconditions.checkNotNull((zzbu) view.getTag())).zzb.getTag())).intValue();
        notifyDataSetChanged();
    }

    public final MediaTrack zza() {
        int i10 = this.zzb;
        if (i10 < 0 || i10 >= getCount()) {
            return null;
        }
        return (MediaTrack) getItem(this.zzb);
    }
}
