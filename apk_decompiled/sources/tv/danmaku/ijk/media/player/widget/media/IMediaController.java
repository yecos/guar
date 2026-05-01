package tv.danmaku.ijk.media.player.widget.media;

import android.view.View;
import android.widget.MediaController;

/* loaded from: classes2.dex */
public interface IMediaController {
    void hide();

    boolean isShowing();

    void setAnchorView(View view);

    void setEnabled(boolean z10);

    void setMediaPlayer(MediaController.MediaPlayerControl mediaPlayerControl);

    void show();

    void show(int i10);

    void showOnce(View view);
}
