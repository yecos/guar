package tv.danmaku.ijk.media.player.widget.media;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: classes2.dex */
public interface IRenderView {
    public static final int AR_16_9_FIT_PARENT = 4;
    public static final int AR_4_3_FIT_PARENT = 5;
    public static final int AR_ASPECT_FILL_PARENT = 1;
    public static final int AR_ASPECT_FIT_PARENT = 0;
    public static final int AR_ASPECT_WRAP_CONTENT = 2;
    public static final int AR_MATCH_PARENT = 3;

    public interface IRenderCallback {
        void onSurfaceChanged(ISurfaceHolder iSurfaceHolder, int i10, int i11, int i12);

        void onSurfaceCreated(ISurfaceHolder iSurfaceHolder, int i10, int i11);

        void onSurfaceDestroyed(ISurfaceHolder iSurfaceHolder);
    }

    public interface ISurfaceHolder {
        void bindToMediaPlayer(IMediaPlayer iMediaPlayer);

        IRenderView getRenderView();

        SurfaceHolder getSurfaceHolder();

        SurfaceTexture getSurfaceTexture();

        Surface openSurface();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface RenderViewAspectRatio {
    }

    void addRenderCallback(IRenderCallback iRenderCallback);

    View getView();

    void removeRenderCallback(IRenderCallback iRenderCallback);

    void setAspectRatio(int i10);

    void setVideoRotation(int i10);

    void setVideoSampleAspectRatio(int i10, int i11);

    void setVideoSize(int i10, int i11);

    boolean shouldWaitForResize();
}
