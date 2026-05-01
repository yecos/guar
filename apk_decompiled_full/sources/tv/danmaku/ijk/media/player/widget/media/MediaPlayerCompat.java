package tv.danmaku.ijk.media.player.widget.media;

import com.raizlabs.android.dbflow.sql.language.Operator;
import tv.danmaku.ijk.media.player.ExoMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.MediaPlayerProxy;
import tv.danmaku.ijk.media.player.TextureMediaPlayer;

/* loaded from: classes2.dex */
public class MediaPlayerCompat {
    public static void deselectTrack(IMediaPlayer iMediaPlayer, int i10) {
        IjkMediaPlayer ijkMediaPlayer = getIjkMediaPlayer(iMediaPlayer);
        if (ijkMediaPlayer == null) {
            return;
        }
        ijkMediaPlayer.deselectTrack(i10);
    }

    public static IjkMediaPlayer getIjkMediaPlayer(IMediaPlayer iMediaPlayer) {
        if (iMediaPlayer == null) {
            return null;
        }
        if (iMediaPlayer instanceof IjkMediaPlayer) {
            return (IjkMediaPlayer) iMediaPlayer;
        }
        if (!(iMediaPlayer instanceof MediaPlayerProxy)) {
            return null;
        }
        MediaPlayerProxy mediaPlayerProxy = (MediaPlayerProxy) iMediaPlayer;
        if (mediaPlayerProxy.getInternalMediaPlayer() instanceof IjkMediaPlayer) {
            return (IjkMediaPlayer) mediaPlayerProxy.getInternalMediaPlayer();
        }
        return null;
    }

    public static String getName(IMediaPlayer iMediaPlayer) {
        if (iMediaPlayer == null) {
            return "null";
        }
        if (!(iMediaPlayer instanceof TextureMediaPlayer)) {
            return iMediaPlayer.getClass().getSimpleName();
        }
        StringBuilder sb = new StringBuilder("TextureMediaPlayer <");
        IMediaPlayer internalMediaPlayer = ((TextureMediaPlayer) iMediaPlayer).getInternalMediaPlayer();
        if (internalMediaPlayer == null) {
            sb.append("null>");
        } else {
            sb.append(internalMediaPlayer.getClass().getSimpleName());
            sb.append(Operator.Operation.GREATER_THAN);
        }
        return sb.toString();
    }

    public static int getSelectedTrack(IMediaPlayer iMediaPlayer, int i10) {
        if (iMediaPlayer instanceof ExoMediaPlayer) {
            return ((ExoMediaPlayer) iMediaPlayer).getSelectedAudioTrack(i10);
        }
        IjkMediaPlayer ijkMediaPlayer = getIjkMediaPlayer(iMediaPlayer);
        if (ijkMediaPlayer == null) {
            return -1;
        }
        return ijkMediaPlayer.getSelectedTrack(i10);
    }

    public static void selectTrack(IMediaPlayer iMediaPlayer, int i10) {
        IjkMediaPlayer ijkMediaPlayer = getIjkMediaPlayer(iMediaPlayer);
        if (ijkMediaPlayer == null) {
            return;
        }
        ijkMediaPlayer.selectTrack(i10);
    }
}
