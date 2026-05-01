package tv.danmaku.ijk.media.player.misc;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.MimeTypes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.Locale;

/* loaded from: classes2.dex */
public class ExoTrackInfo implements ITrackInfo {
    private TrackGroup mTrackGroup;

    public ExoTrackInfo(TrackGroup trackGroup) {
        this.mTrackGroup = trackGroup;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public IMediaFormat getFormat() {
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public String getInfoInline() {
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public String getLanguage() {
        return this.mTrackGroup.getFormat(0).language != null ? new Locale(this.mTrackGroup.getFormat(0).language).getISO3Language() : this.mTrackGroup.getFormat(0).language;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public int getTrackType() {
        String str = this.mTrackGroup.getFormat(0).sampleMimeType;
        if (MimeTypes.isVideo(str)) {
            return 1;
        }
        return MimeTypes.isAudio(str) ? 2 : 0;
    }

    public String toString() {
        return "ExoTrackInfo{mTrackGroup.Format=" + this.mTrackGroup.getFormat(0).toString() + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
