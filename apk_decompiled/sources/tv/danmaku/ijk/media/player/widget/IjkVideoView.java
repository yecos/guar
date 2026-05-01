package tv.danmaku.ijk.media.player.widget;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.player.AndroidMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkTimedText;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.widget.media.FileMediaDataSource;
import tv.danmaku.ijk.media.player.widget.media.IMediaController;
import tv.danmaku.ijk.media.player.widget.media.IRenderView;
import tv.danmaku.ijk.media.player.widget.media.IjkInitManager;
import tv.danmaku.ijk.media.player.widget.media.MediaPlayerCompat;

/* loaded from: classes2.dex */
public class IjkVideoView extends FrameLayout implements MediaController.MediaPlayerControl {
    public static final int RENDER_NONE = 0;
    public static final int RENDER_SURFACE_VIEW = 1;
    public static final int RENDER_TEXTURE_VIEW = 2;
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 6;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private static final int STATE_STOP = 5;
    private String TAG;
    private boolean isIjkPlay;
    private Context mAppContext;
    private IMediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener;
    private boolean mCanPause;
    private boolean mCanSeekBack;
    private boolean mCanSeekForward;
    private IMediaPlayer.OnCompletionListener mCompletionListener;
    private int mCurrentAspectRatio;
    private int mCurrentBufferPercentage;
    private int mCurrentRender;
    private int mCurrentState;
    private IMediaPlayer.OnErrorListener mErrorListener;
    private Map<String, String> mHeaders;
    private IMediaPlayer.OnInfoListener mInfoListener;
    private IMediaController mMediaController;
    private IMediaPlayer mMediaPlayer;
    private IMediaPlayer.OnCompletionListener mOnCompletionListener;
    private IMediaPlayer.OnErrorListener mOnErrorListener;
    private IMediaPlayer.OnInfoListener mOnInfoListener;
    private IMediaPlayer.OnPreparedListener mOnPreparedListener;
    private IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private IMediaPlayer.OnTimedTextListener mOnTimedTextListener;
    IMediaPlayer.OnPreparedListener mPreparedListener;
    private IRenderView mRenderView;
    IRenderView.IRenderCallback mSHCallback;
    private IMediaPlayer.OnSeekCompleteListener mSeekCompleteListener;
    private int mSeekWhenPrepared;
    IMediaPlayer.OnVideoSizeChangedListener mSizeChangedListener;
    private int mSurfaceHeight;
    private IRenderView.ISurfaceHolder mSurfaceHolder;
    private int mSurfaceWidth;
    private int mTargetState;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;

    public IjkVideoView(Context context) {
        super(context);
        this.TAG = "IjkVideoView";
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.mCanPause = true;
        this.mCanSeekBack = true;
        this.mCanSeekForward = true;
        this.isIjkPlay = false;
        this.mSizeChangedListener = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.1
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i10, int i11, int i12, int i13) {
                IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
                IjkVideoView.this.mVideoSarNum = iMediaPlayer.getVideoSarNum();
                IjkVideoView.this.mVideoSarDen = iMediaPlayer.getVideoSarDen();
                if (IjkVideoView.this.mVideoWidth == 0 || IjkVideoView.this.mVideoHeight == 0) {
                    return;
                }
                if (IjkVideoView.this.mRenderView != null) {
                    IjkVideoView.this.mRenderView.setVideoSize(IjkVideoView.this.mVideoWidth, IjkVideoView.this.mVideoHeight);
                    IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(IjkVideoView.this.mVideoSarNum, IjkVideoView.this.mVideoSarDen);
                }
                IjkVideoView.this.requestLayout();
            }
        };
        this.mPreparedListener = new IMediaPlayer.OnPreparedListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.mCurrentState = 2;
                if (IjkVideoView.this.mOnPreparedListener != null) {
                    IjkVideoView.this.mOnPreparedListener.onPrepared(IjkVideoView.this.mMediaPlayer);
                }
                if (IjkVideoView.this.mMediaController != null) {
                    IjkVideoView.this.mMediaController.setEnabled(true);
                }
                IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
                int i10 = IjkVideoView.this.mSeekWhenPrepared;
                if (i10 != 0) {
                    IjkVideoView.this.seekTo(i10);
                }
                IjkVideoView.this.mMediaPlayer.getMediaInfo();
                if (IjkVideoView.this.mVideoWidth == 0 || IjkVideoView.this.mVideoHeight == 0) {
                    if (IjkVideoView.this.mTargetState == 3) {
                        IjkVideoView.this.start();
                        return;
                    }
                    return;
                }
                if (IjkVideoView.this.mRenderView != null) {
                    IjkVideoView.this.mRenderView.setVideoSize(IjkVideoView.this.mVideoWidth, IjkVideoView.this.mVideoHeight);
                    IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(IjkVideoView.this.mVideoSarNum, IjkVideoView.this.mVideoSarDen);
                    if (!IjkVideoView.this.mRenderView.shouldWaitForResize() || (IjkVideoView.this.mSurfaceWidth == IjkVideoView.this.mVideoWidth && IjkVideoView.this.mSurfaceHeight == IjkVideoView.this.mVideoHeight)) {
                        if (IjkVideoView.this.mTargetState == 3) {
                            IjkVideoView.this.start();
                            if (IjkVideoView.this.mMediaController != null) {
                                IjkVideoView.this.mMediaController.show();
                                return;
                            }
                            return;
                        }
                        if (IjkVideoView.this.isPlaying()) {
                            return;
                        }
                        if ((i10 != 0 || IjkVideoView.this.getCurrentPosition() > 0) && IjkVideoView.this.mMediaController != null) {
                            IjkVideoView.this.mMediaController.show(0);
                        }
                    }
                }
            }
        };
        this.mCompletionListener = new IMediaPlayer.OnCompletionListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.mCurrentState = 6;
                IjkVideoView.this.mTargetState = 6;
                if (IjkVideoView.this.mMediaController != null) {
                    IjkVideoView.this.mMediaController.hide();
                }
                if (IjkVideoView.this.mOnCompletionListener != null) {
                    IjkVideoView.this.mOnCompletionListener.onCompletion(IjkVideoView.this.mMediaPlayer);
                }
            }
        };
        this.mInfoListener = new IMediaPlayer.OnInfoListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i10, int i11) {
                if (IjkVideoView.this.mOnInfoListener != null) {
                    IjkVideoView.this.mOnInfoListener.onInfo(iMediaPlayer, i10, i11);
                }
                String unused = IjkVideoView.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(" arg1 ");
                sb.append(i10);
                sb.append("  this : ");
                sb.append(this);
                if (i10 == 3) {
                    String unused2 = IjkVideoView.this.TAG;
                    if (IjkVideoView.this.mTargetState != 4 || IjkVideoView.this.mCurrentState == IjkVideoView.this.mTargetState) {
                        return true;
                    }
                    IjkVideoView.this.pause();
                    return true;
                }
                if (i10 == 901) {
                    String unused3 = IjkVideoView.this.TAG;
                    return true;
                }
                if (i10 == 902) {
                    String unused4 = IjkVideoView.this.TAG;
                    return true;
                }
                if (i10 == 10001) {
                    IjkVideoView.this.mVideoRotationDegree = i11;
                    String unused5 = IjkVideoView.this.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("MEDIA_INFO_VIDEO_ROTATION_CHANGED: ");
                    sb2.append(i11);
                    if (IjkVideoView.this.mRenderView == null) {
                        return true;
                    }
                    IjkVideoView.this.mRenderView.setVideoRotation(i11);
                    return true;
                }
                if (i10 == 10002) {
                    String unused6 = IjkVideoView.this.TAG;
                    return true;
                }
                switch (i10) {
                    case 700:
                        String unused7 = IjkVideoView.this.TAG;
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                        String unused8 = IjkVideoView.this.TAG;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("MEDIA_INFO_BUFFERING_START:");
                        sb3.append(this);
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                        if (IjkVideoView.this.mTargetState == 4 && IjkVideoView.this.mCurrentState != IjkVideoView.this.mTargetState) {
                            IjkVideoView.this.pause();
                        }
                        String unused9 = IjkVideoView.this.TAG;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("MEDIA_INFO_BUFFERING_END: mTargetState ");
                        sb4.append(IjkVideoView.this.mTargetState);
                        sb4.append("  mCurrentState ");
                        sb4.append(IjkVideoView.this.mCurrentState);
                        sb4.append("   ");
                        sb4.append(this);
                        break;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                        String unused10 = IjkVideoView.this.TAG;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("MEDIA_INFO_NETWORK_BANDWIDTH: ");
                        sb5.append(i11);
                        break;
                    default:
                        switch (i10) {
                            case 800:
                                String unused11 = IjkVideoView.this.TAG;
                                break;
                            case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                                String unused12 = IjkVideoView.this.TAG;
                                break;
                            case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                                String unused13 = IjkVideoView.this.TAG;
                                break;
                        }
                }
                return true;
            }
        };
        this.mErrorListener = new IMediaPlayer.OnErrorListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i10, int i11) {
                String unused = IjkVideoView.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Error: ");
                sb.append(i10);
                sb.append(",");
                sb.append(i11);
                IjkVideoView.this.mCurrentState = -1;
                IjkVideoView.this.mTargetState = -1;
                if (IjkVideoView.this.mMediaController != null) {
                    IjkVideoView.this.mMediaController.hide();
                }
                if (IjkVideoView.this.mOnErrorListener != null && IjkVideoView.this.mOnErrorListener.onError(IjkVideoView.this.mMediaPlayer, i10, i11)) {
                    return true;
                }
                IjkVideoView.this.getWindowToken();
                return true;
            }
        };
        this.mBufferingUpdateListener = new IMediaPlayer.OnBufferingUpdateListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.6
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i10, long j10) {
                IjkVideoView.this.mCurrentBufferPercentage = i10;
            }
        };
        this.mSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.7
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            }
        };
        this.mOnTimedTextListener = new IMediaPlayer.OnTimedTextListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.8
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener
            public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
            }
        };
        this.mSHCallback = new IRenderView.IRenderCallback() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.9
            @Override // tv.danmaku.ijk.media.player.widget.media.IRenderView.IRenderCallback
            public void onSurfaceChanged(IRenderView.ISurfaceHolder iSurfaceHolder, int i10, int i11, int i12) {
                if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                    Log.e(IjkVideoView.this.TAG, "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.mSurfaceWidth = i11;
                IjkVideoView.this.mSurfaceHeight = i12;
                boolean z10 = true;
                boolean z11 = IjkVideoView.this.mTargetState == 3;
                if (IjkVideoView.this.mRenderView.shouldWaitForResize() && (IjkVideoView.this.mVideoWidth != i11 || IjkVideoView.this.mVideoHeight != i12)) {
                    z10 = false;
                }
                if (IjkVideoView.this.mMediaPlayer != null && z11 && z10) {
                    if (IjkVideoView.this.mSeekWhenPrepared != 0) {
                        IjkVideoView ijkVideoView = IjkVideoView.this;
                        ijkVideoView.seekTo(ijkVideoView.mSeekWhenPrepared);
                    }
                    IjkVideoView.this.start();
                }
            }

            @Override // tv.danmaku.ijk.media.player.widget.media.IRenderView.IRenderCallback
            public void onSurfaceCreated(IRenderView.ISurfaceHolder iSurfaceHolder, int i10, int i11) {
                if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                    Log.e(IjkVideoView.this.TAG, "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.surfaceCreated();
                IjkVideoView.this.mSurfaceHolder = iSurfaceHolder;
                if (IjkVideoView.this.mMediaPlayer == null) {
                    IjkVideoView.this.openVideo();
                } else {
                    IjkVideoView ijkVideoView = IjkVideoView.this;
                    ijkVideoView.bindSurfaceHolder(ijkVideoView.mMediaPlayer, iSurfaceHolder);
                }
            }

            @Override // tv.danmaku.ijk.media.player.widget.media.IRenderView.IRenderCallback
            public void onSurfaceDestroyed(IRenderView.ISurfaceHolder iSurfaceHolder) {
                if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                    Log.e(IjkVideoView.this.TAG, "onSurfaceDestroyed: unmatched render callback\n");
                } else {
                    IjkVideoView.this.mSurfaceHolder = null;
                    IjkVideoView.this.releaseWithoutStop();
                }
            }
        };
        this.mCurrentAspectRatio = 0;
        this.mCurrentRender = 1;
        initVideoView(context);
    }

    private void attachMediaController() {
        IMediaController iMediaController;
        if (this.mMediaPlayer == null || (iMediaController = this.mMediaController) == null) {
            return;
        }
        iMediaController.setMediaPlayer(this);
        this.mMediaController.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
        this.mMediaController.setEnabled(isInPlaybackState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindSurfaceHolder(IMediaPlayer iMediaPlayer, IRenderView.ISurfaceHolder iSurfaceHolder) {
        if (iMediaPlayer == null) {
            return;
        }
        if (iSurfaceHolder == null) {
            iMediaPlayer.setDisplay(null);
        } else {
            iSurfaceHolder.bindToMediaPlayer(iMediaPlayer);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private IMediaPlayer createPlayer() {
        AndroidMediaPlayer androidMediaPlayer;
        if (this.mUri == null) {
            androidMediaPlayer = null;
        } else if (this.isIjkPlay) {
            IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
            IjkMediaPlayer.native_setLogLevel(6);
            ijkMediaPlayer.setOption(4, "mediacodec", 1L);
            ijkMediaPlayer.setOption(4, "opensles", 0L);
            ijkMediaPlayer.setOption(4, "overlay-format", 842225234L);
            ijkMediaPlayer.setOption(1, "http-detect-range-support", 0L);
            ijkMediaPlayer.setOption(2, "skip_loop_filter", 48L);
            ijkMediaPlayer.setOption(4, "live-streaming", 1L);
            ijkMediaPlayer.setOption(4, "delay-optimization", 1L);
            ijkMediaPlayer.setOption(4, "start-on-prepared", 1L);
            ijkMediaPlayer.setOption(4, "timeout", 20000L);
            ijkMediaPlayer.setOption(4, "get-av-frame-timeout", 20000L);
            ijkMediaPlayer.setOption(4, "cache-buffer-duration", 2000L);
            ijkMediaPlayer.setOption(4, "max-cache-buffer-duration", 4000L);
            ijkMediaPlayer.setOption(1, "analyzemaxduration", 100L);
            ijkMediaPlayer.setOption(1, "flush_packets", 1L);
            ijkMediaPlayer.setOption(4, "framedrop", 1L);
            ijkMediaPlayer.setOption(4, "render-wait-start", 1L);
            androidMediaPlayer = ijkMediaPlayer;
        } else {
            androidMediaPlayer = new AndroidMediaPlayer();
        }
        androidMediaPlayer.setLooping(false);
        return androidMediaPlayer;
    }

    private void initRenders() {
        this.mCurrentRender = 1;
        setRender(1);
    }

    private void initVideoView(Context context) {
        this.mAppContext = context.getApplicationContext();
        initRenders();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mCurrentState = 0;
        this.mTargetState = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openVideo() {
        if (this.mUri == null || this.mSurfaceHolder == null) {
            return;
        }
        release(false);
        ((AudioManager) this.mAppContext.getSystemService("audio")).requestAudioFocus(null, 3, 1);
        try {
            IMediaPlayer createPlayer = createPlayer();
            this.mMediaPlayer = createPlayer;
            createPlayer.setOnPreparedListener(this.mPreparedListener);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
            this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
            this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
            this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
            this.mMediaPlayer.setOnSeekCompleteListener(this.mSeekCompleteListener);
            this.mMediaPlayer.setOnTimedTextListener(this.mOnTimedTextListener);
            this.mMediaPlayer.setLooping(false);
            this.mCurrentBufferPercentage = 0;
            String scheme = this.mUri.getScheme();
            if (Build.VERSION.SDK_INT < 23 || !((TextUtils.isEmpty(scheme) || scheme.equalsIgnoreCase("file")) && (this.mMediaPlayer instanceof IjkMediaPlayer))) {
                this.mMediaPlayer.setDataSource(this.mAppContext, this.mUri, this.mHeaders);
            } else {
                this.mMediaPlayer.setDataSource(new FileMediaDataSource(new File(this.mUri.toString())));
            }
            reflectSubTitleService();
            bindSurfaceHolder(this.mMediaPlayer, this.mSurfaceHolder);
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
            startPrepare();
            this.mMediaPlayer.prepareAsync();
            this.mCurrentState = 1;
            attachMediaController();
        } catch (IOException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to open content: ");
            sb.append(this.mUri);
            this.mCurrentState = -1;
            this.mTargetState = -1;
            this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
        } catch (IllegalArgumentException unused2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to open content: ");
            sb2.append(this.mUri);
            this.mCurrentState = -1;
            this.mTargetState = -1;
            this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
        } catch (IllegalStateException unused3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to open content: ");
            sb3.append(this.mUri);
            this.mCurrentState = -1;
            this.mTargetState = -1;
            this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
        }
    }

    private void reflectSubTitleService() {
        if (Build.VERSION.SDK_INT == 19) {
            try {
                IMediaPlayer iMediaPlayer = this.mMediaPlayer;
                if (iMediaPlayer instanceof AndroidMediaPlayer) {
                    Field declaredField = ((AndroidMediaPlayer) iMediaPlayer).getInternalMediaPlayer().getClass().getDeclaredField("subTitleService");
                    declaredField.setAccessible(true);
                    declaredField.set(((AndroidMediaPlayer) this.mMediaPlayer).getInternalMediaPlayer(), null);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void toggleMediaControlsVisiblity() {
        if (this.mMediaController.isShowing()) {
            this.mMediaController.hide();
        } else {
            this.mMediaController.show();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.mCanPause;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.mCanSeekBack;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.mCanSeekForward;
    }

    public void deselectTrack(int i10) {
        MediaPlayerCompat.deselectTrack(this.mMediaPlayer, i10);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.mCurrentBufferPercentage;
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return (int) this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (isInPlaybackState()) {
            return (int) this.mMediaPlayer.getDuration();
        }
        return -1;
    }

    public IMediaPlayer getMediaPlayer() {
        return this.mMediaPlayer;
    }

    public int getSelectedTrack(int i10) {
        return MediaPlayerCompat.getSelectedTrack(this.mMediaPlayer, i10);
    }

    public ITrackInfo[] getTrackInfo() {
        IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer == null) {
            return null;
        }
        return iMediaPlayer.getTrackInfo();
    }

    public boolean isInPlaybackState() {
        int i10;
        return (this.mMediaPlayer == null || (i10 = this.mCurrentState) == -1 || i10 == 0 || i10 == 1 || i10 == 5) ? false : true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IjkInitManager.getInstance().initIjk();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IjkInitManager.getInstance().endIjk();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.mCurrentState = 4;
        }
        this.mTargetState = 4;
    }

    public void release(boolean z10) {
        IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay(null);
            this.mMediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            if (z10) {
                this.mTargetState = 0;
            }
            ((AudioManager) this.mAppContext.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public void releaseWithoutStop() {
        IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay(null);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i10) {
        if (!isInPlaybackState()) {
            this.mSeekWhenPrepared = i10;
            return;
        }
        this.mMediaPlayer.seekTo(i10);
        this.mSeekWhenPrepared = 0;
        startSeekto(i10);
    }

    public void selectTrack(int i10) {
        MediaPlayerCompat.selectTrack(this.mMediaPlayer, i10);
    }

    public void setAspectRatio(int i10) {
        this.mCurrentAspectRatio = i10;
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            iRenderView.setAspectRatio(i10);
        }
    }

    public void setMediaController(IMediaController iMediaController) {
        IMediaController iMediaController2 = this.mMediaController;
        if (iMediaController2 != null) {
            iMediaController2.hide();
        }
        this.mMediaController = iMediaController;
        attachMediaController();
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    public void setPlayMode(boolean z10) {
        this.isIjkPlay = z10;
    }

    public void setRender(int i10) {
        if (i10 == 0) {
            setRenderView(null);
            return;
        }
        if (i10 == 1) {
            setRenderView(new SurfaceRenderView(getContext()));
            return;
        }
        if (i10 != 2) {
            Log.e(this.TAG, String.format(Locale.getDefault(), "invalid render %d\n", Integer.valueOf(i10)));
            return;
        }
        TextureRenderView textureRenderView = new TextureRenderView(getContext());
        if (this.mMediaPlayer != null) {
            textureRenderView.getSurfaceHolder().bindToMediaPlayer(this.mMediaPlayer);
            textureRenderView.setVideoSize(this.mMediaPlayer.getVideoWidth(), this.mMediaPlayer.getVideoHeight());
            textureRenderView.setVideoSampleAspectRatio(this.mMediaPlayer.getVideoSarNum(), this.mMediaPlayer.getVideoSarDen());
            textureRenderView.setAspectRatio(this.mCurrentAspectRatio);
        }
        setRenderView(textureRenderView);
    }

    public void setRenderView(IRenderView iRenderView) {
        int i10;
        int i11;
        if (this.mRenderView != null) {
            IMediaPlayer iMediaPlayer = this.mMediaPlayer;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay(null);
            }
            View view = this.mRenderView.getView();
            this.mRenderView.removeRenderCallback(this.mSHCallback);
            this.mRenderView = null;
            removeView(view);
        }
        if (iRenderView == null) {
            return;
        }
        this.mRenderView = iRenderView;
        iRenderView.setAspectRatio(this.mCurrentAspectRatio);
        int i12 = this.mVideoWidth;
        if (i12 > 0 && (i11 = this.mVideoHeight) > 0) {
            iRenderView.setVideoSize(i12, i11);
        }
        int i13 = this.mVideoSarNum;
        if (i13 > 0 && (i10 = this.mVideoSarDen) > 0) {
            iRenderView.setVideoSampleAspectRatio(i13, i10);
        }
        View view2 = this.mRenderView.getView();
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        addView(view2);
        this.mRenderView.addRenderCallback(this.mSHCallback);
        this.mRenderView.setVideoRotation(this.mVideoRotationDegree);
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (isInPlaybackState()) {
            this.mMediaPlayer.start();
            this.mCurrentState = 3;
        }
        this.mTargetState = 3;
    }

    public void startPrepare() {
    }

    public void startSeekto(int i10) {
    }

    public void stopPlayback() {
        IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            this.mTargetState = 0;
            ((AudioManager) this.mAppContext.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public void surfaceCreated() {
    }

    public void suspend() {
        release(false);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        this.mUri = uri;
        this.mHeaders = map;
        this.mSeekWhenPrepared = 0;
        initRenders();
        openVideo();
        requestLayout();
        invalidate();
    }

    public IjkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "IjkVideoView";
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.mCanPause = true;
        this.mCanSeekBack = true;
        this.mCanSeekForward = true;
        this.isIjkPlay = false;
        this.mSizeChangedListener = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.1
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i10, int i11, int i12, int i13) {
                IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
                IjkVideoView.this.mVideoSarNum = iMediaPlayer.getVideoSarNum();
                IjkVideoView.this.mVideoSarDen = iMediaPlayer.getVideoSarDen();
                if (IjkVideoView.this.mVideoWidth == 0 || IjkVideoView.this.mVideoHeight == 0) {
                    return;
                }
                if (IjkVideoView.this.mRenderView != null) {
                    IjkVideoView.this.mRenderView.setVideoSize(IjkVideoView.this.mVideoWidth, IjkVideoView.this.mVideoHeight);
                    IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(IjkVideoView.this.mVideoSarNum, IjkVideoView.this.mVideoSarDen);
                }
                IjkVideoView.this.requestLayout();
            }
        };
        this.mPreparedListener = new IMediaPlayer.OnPreparedListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.mCurrentState = 2;
                if (IjkVideoView.this.mOnPreparedListener != null) {
                    IjkVideoView.this.mOnPreparedListener.onPrepared(IjkVideoView.this.mMediaPlayer);
                }
                if (IjkVideoView.this.mMediaController != null) {
                    IjkVideoView.this.mMediaController.setEnabled(true);
                }
                IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
                int i10 = IjkVideoView.this.mSeekWhenPrepared;
                if (i10 != 0) {
                    IjkVideoView.this.seekTo(i10);
                }
                IjkVideoView.this.mMediaPlayer.getMediaInfo();
                if (IjkVideoView.this.mVideoWidth == 0 || IjkVideoView.this.mVideoHeight == 0) {
                    if (IjkVideoView.this.mTargetState == 3) {
                        IjkVideoView.this.start();
                        return;
                    }
                    return;
                }
                if (IjkVideoView.this.mRenderView != null) {
                    IjkVideoView.this.mRenderView.setVideoSize(IjkVideoView.this.mVideoWidth, IjkVideoView.this.mVideoHeight);
                    IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(IjkVideoView.this.mVideoSarNum, IjkVideoView.this.mVideoSarDen);
                    if (!IjkVideoView.this.mRenderView.shouldWaitForResize() || (IjkVideoView.this.mSurfaceWidth == IjkVideoView.this.mVideoWidth && IjkVideoView.this.mSurfaceHeight == IjkVideoView.this.mVideoHeight)) {
                        if (IjkVideoView.this.mTargetState == 3) {
                            IjkVideoView.this.start();
                            if (IjkVideoView.this.mMediaController != null) {
                                IjkVideoView.this.mMediaController.show();
                                return;
                            }
                            return;
                        }
                        if (IjkVideoView.this.isPlaying()) {
                            return;
                        }
                        if ((i10 != 0 || IjkVideoView.this.getCurrentPosition() > 0) && IjkVideoView.this.mMediaController != null) {
                            IjkVideoView.this.mMediaController.show(0);
                        }
                    }
                }
            }
        };
        this.mCompletionListener = new IMediaPlayer.OnCompletionListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.mCurrentState = 6;
                IjkVideoView.this.mTargetState = 6;
                if (IjkVideoView.this.mMediaController != null) {
                    IjkVideoView.this.mMediaController.hide();
                }
                if (IjkVideoView.this.mOnCompletionListener != null) {
                    IjkVideoView.this.mOnCompletionListener.onCompletion(IjkVideoView.this.mMediaPlayer);
                }
            }
        };
        this.mInfoListener = new IMediaPlayer.OnInfoListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i10, int i11) {
                if (IjkVideoView.this.mOnInfoListener != null) {
                    IjkVideoView.this.mOnInfoListener.onInfo(iMediaPlayer, i10, i11);
                }
                String unused = IjkVideoView.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(" arg1 ");
                sb.append(i10);
                sb.append("  this : ");
                sb.append(this);
                if (i10 == 3) {
                    String unused2 = IjkVideoView.this.TAG;
                    if (IjkVideoView.this.mTargetState != 4 || IjkVideoView.this.mCurrentState == IjkVideoView.this.mTargetState) {
                        return true;
                    }
                    IjkVideoView.this.pause();
                    return true;
                }
                if (i10 == 901) {
                    String unused3 = IjkVideoView.this.TAG;
                    return true;
                }
                if (i10 == 902) {
                    String unused4 = IjkVideoView.this.TAG;
                    return true;
                }
                if (i10 == 10001) {
                    IjkVideoView.this.mVideoRotationDegree = i11;
                    String unused5 = IjkVideoView.this.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("MEDIA_INFO_VIDEO_ROTATION_CHANGED: ");
                    sb2.append(i11);
                    if (IjkVideoView.this.mRenderView == null) {
                        return true;
                    }
                    IjkVideoView.this.mRenderView.setVideoRotation(i11);
                    return true;
                }
                if (i10 == 10002) {
                    String unused6 = IjkVideoView.this.TAG;
                    return true;
                }
                switch (i10) {
                    case 700:
                        String unused7 = IjkVideoView.this.TAG;
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                        String unused8 = IjkVideoView.this.TAG;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("MEDIA_INFO_BUFFERING_START:");
                        sb3.append(this);
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                        if (IjkVideoView.this.mTargetState == 4 && IjkVideoView.this.mCurrentState != IjkVideoView.this.mTargetState) {
                            IjkVideoView.this.pause();
                        }
                        String unused9 = IjkVideoView.this.TAG;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("MEDIA_INFO_BUFFERING_END: mTargetState ");
                        sb4.append(IjkVideoView.this.mTargetState);
                        sb4.append("  mCurrentState ");
                        sb4.append(IjkVideoView.this.mCurrentState);
                        sb4.append("   ");
                        sb4.append(this);
                        break;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                        String unused10 = IjkVideoView.this.TAG;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("MEDIA_INFO_NETWORK_BANDWIDTH: ");
                        sb5.append(i11);
                        break;
                    default:
                        switch (i10) {
                            case 800:
                                String unused11 = IjkVideoView.this.TAG;
                                break;
                            case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                                String unused12 = IjkVideoView.this.TAG;
                                break;
                            case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                                String unused13 = IjkVideoView.this.TAG;
                                break;
                        }
                }
                return true;
            }
        };
        this.mErrorListener = new IMediaPlayer.OnErrorListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i10, int i11) {
                String unused = IjkVideoView.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Error: ");
                sb.append(i10);
                sb.append(",");
                sb.append(i11);
                IjkVideoView.this.mCurrentState = -1;
                IjkVideoView.this.mTargetState = -1;
                if (IjkVideoView.this.mMediaController != null) {
                    IjkVideoView.this.mMediaController.hide();
                }
                if (IjkVideoView.this.mOnErrorListener != null && IjkVideoView.this.mOnErrorListener.onError(IjkVideoView.this.mMediaPlayer, i10, i11)) {
                    return true;
                }
                IjkVideoView.this.getWindowToken();
                return true;
            }
        };
        this.mBufferingUpdateListener = new IMediaPlayer.OnBufferingUpdateListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.6
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i10, long j10) {
                IjkVideoView.this.mCurrentBufferPercentage = i10;
            }
        };
        this.mSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.7
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            }
        };
        this.mOnTimedTextListener = new IMediaPlayer.OnTimedTextListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.8
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener
            public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
            }
        };
        this.mSHCallback = new IRenderView.IRenderCallback() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.9
            @Override // tv.danmaku.ijk.media.player.widget.media.IRenderView.IRenderCallback
            public void onSurfaceChanged(IRenderView.ISurfaceHolder iSurfaceHolder, int i10, int i11, int i12) {
                if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                    Log.e(IjkVideoView.this.TAG, "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.mSurfaceWidth = i11;
                IjkVideoView.this.mSurfaceHeight = i12;
                boolean z10 = true;
                boolean z11 = IjkVideoView.this.mTargetState == 3;
                if (IjkVideoView.this.mRenderView.shouldWaitForResize() && (IjkVideoView.this.mVideoWidth != i11 || IjkVideoView.this.mVideoHeight != i12)) {
                    z10 = false;
                }
                if (IjkVideoView.this.mMediaPlayer != null && z11 && z10) {
                    if (IjkVideoView.this.mSeekWhenPrepared != 0) {
                        IjkVideoView ijkVideoView = IjkVideoView.this;
                        ijkVideoView.seekTo(ijkVideoView.mSeekWhenPrepared);
                    }
                    IjkVideoView.this.start();
                }
            }

            @Override // tv.danmaku.ijk.media.player.widget.media.IRenderView.IRenderCallback
            public void onSurfaceCreated(IRenderView.ISurfaceHolder iSurfaceHolder, int i10, int i11) {
                if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                    Log.e(IjkVideoView.this.TAG, "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.surfaceCreated();
                IjkVideoView.this.mSurfaceHolder = iSurfaceHolder;
                if (IjkVideoView.this.mMediaPlayer == null) {
                    IjkVideoView.this.openVideo();
                } else {
                    IjkVideoView ijkVideoView = IjkVideoView.this;
                    ijkVideoView.bindSurfaceHolder(ijkVideoView.mMediaPlayer, iSurfaceHolder);
                }
            }

            @Override // tv.danmaku.ijk.media.player.widget.media.IRenderView.IRenderCallback
            public void onSurfaceDestroyed(IRenderView.ISurfaceHolder iSurfaceHolder) {
                if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                    Log.e(IjkVideoView.this.TAG, "onSurfaceDestroyed: unmatched render callback\n");
                } else {
                    IjkVideoView.this.mSurfaceHolder = null;
                    IjkVideoView.this.releaseWithoutStop();
                }
            }
        };
        this.mCurrentAspectRatio = 0;
        this.mCurrentRender = 1;
        initVideoView(context);
    }

    public IjkVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.TAG = "IjkVideoView";
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.mCanPause = true;
        this.mCanSeekBack = true;
        this.mCanSeekForward = true;
        this.isIjkPlay = false;
        this.mSizeChangedListener = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.1
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i102, int i11, int i12, int i13) {
                IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
                IjkVideoView.this.mVideoSarNum = iMediaPlayer.getVideoSarNum();
                IjkVideoView.this.mVideoSarDen = iMediaPlayer.getVideoSarDen();
                if (IjkVideoView.this.mVideoWidth == 0 || IjkVideoView.this.mVideoHeight == 0) {
                    return;
                }
                if (IjkVideoView.this.mRenderView != null) {
                    IjkVideoView.this.mRenderView.setVideoSize(IjkVideoView.this.mVideoWidth, IjkVideoView.this.mVideoHeight);
                    IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(IjkVideoView.this.mVideoSarNum, IjkVideoView.this.mVideoSarDen);
                }
                IjkVideoView.this.requestLayout();
            }
        };
        this.mPreparedListener = new IMediaPlayer.OnPreparedListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.mCurrentState = 2;
                if (IjkVideoView.this.mOnPreparedListener != null) {
                    IjkVideoView.this.mOnPreparedListener.onPrepared(IjkVideoView.this.mMediaPlayer);
                }
                if (IjkVideoView.this.mMediaController != null) {
                    IjkVideoView.this.mMediaController.setEnabled(true);
                }
                IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
                int i102 = IjkVideoView.this.mSeekWhenPrepared;
                if (i102 != 0) {
                    IjkVideoView.this.seekTo(i102);
                }
                IjkVideoView.this.mMediaPlayer.getMediaInfo();
                if (IjkVideoView.this.mVideoWidth == 0 || IjkVideoView.this.mVideoHeight == 0) {
                    if (IjkVideoView.this.mTargetState == 3) {
                        IjkVideoView.this.start();
                        return;
                    }
                    return;
                }
                if (IjkVideoView.this.mRenderView != null) {
                    IjkVideoView.this.mRenderView.setVideoSize(IjkVideoView.this.mVideoWidth, IjkVideoView.this.mVideoHeight);
                    IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(IjkVideoView.this.mVideoSarNum, IjkVideoView.this.mVideoSarDen);
                    if (!IjkVideoView.this.mRenderView.shouldWaitForResize() || (IjkVideoView.this.mSurfaceWidth == IjkVideoView.this.mVideoWidth && IjkVideoView.this.mSurfaceHeight == IjkVideoView.this.mVideoHeight)) {
                        if (IjkVideoView.this.mTargetState == 3) {
                            IjkVideoView.this.start();
                            if (IjkVideoView.this.mMediaController != null) {
                                IjkVideoView.this.mMediaController.show();
                                return;
                            }
                            return;
                        }
                        if (IjkVideoView.this.isPlaying()) {
                            return;
                        }
                        if ((i102 != 0 || IjkVideoView.this.getCurrentPosition() > 0) && IjkVideoView.this.mMediaController != null) {
                            IjkVideoView.this.mMediaController.show(0);
                        }
                    }
                }
            }
        };
        this.mCompletionListener = new IMediaPlayer.OnCompletionListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.mCurrentState = 6;
                IjkVideoView.this.mTargetState = 6;
                if (IjkVideoView.this.mMediaController != null) {
                    IjkVideoView.this.mMediaController.hide();
                }
                if (IjkVideoView.this.mOnCompletionListener != null) {
                    IjkVideoView.this.mOnCompletionListener.onCompletion(IjkVideoView.this.mMediaPlayer);
                }
            }
        };
        this.mInfoListener = new IMediaPlayer.OnInfoListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i102, int i11) {
                if (IjkVideoView.this.mOnInfoListener != null) {
                    IjkVideoView.this.mOnInfoListener.onInfo(iMediaPlayer, i102, i11);
                }
                String unused = IjkVideoView.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(" arg1 ");
                sb.append(i102);
                sb.append("  this : ");
                sb.append(this);
                if (i102 == 3) {
                    String unused2 = IjkVideoView.this.TAG;
                    if (IjkVideoView.this.mTargetState != 4 || IjkVideoView.this.mCurrentState == IjkVideoView.this.mTargetState) {
                        return true;
                    }
                    IjkVideoView.this.pause();
                    return true;
                }
                if (i102 == 901) {
                    String unused3 = IjkVideoView.this.TAG;
                    return true;
                }
                if (i102 == 902) {
                    String unused4 = IjkVideoView.this.TAG;
                    return true;
                }
                if (i102 == 10001) {
                    IjkVideoView.this.mVideoRotationDegree = i11;
                    String unused5 = IjkVideoView.this.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("MEDIA_INFO_VIDEO_ROTATION_CHANGED: ");
                    sb2.append(i11);
                    if (IjkVideoView.this.mRenderView == null) {
                        return true;
                    }
                    IjkVideoView.this.mRenderView.setVideoRotation(i11);
                    return true;
                }
                if (i102 == 10002) {
                    String unused6 = IjkVideoView.this.TAG;
                    return true;
                }
                switch (i102) {
                    case 700:
                        String unused7 = IjkVideoView.this.TAG;
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                        String unused8 = IjkVideoView.this.TAG;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("MEDIA_INFO_BUFFERING_START:");
                        sb3.append(this);
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                        if (IjkVideoView.this.mTargetState == 4 && IjkVideoView.this.mCurrentState != IjkVideoView.this.mTargetState) {
                            IjkVideoView.this.pause();
                        }
                        String unused9 = IjkVideoView.this.TAG;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("MEDIA_INFO_BUFFERING_END: mTargetState ");
                        sb4.append(IjkVideoView.this.mTargetState);
                        sb4.append("  mCurrentState ");
                        sb4.append(IjkVideoView.this.mCurrentState);
                        sb4.append("   ");
                        sb4.append(this);
                        break;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                        String unused10 = IjkVideoView.this.TAG;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("MEDIA_INFO_NETWORK_BANDWIDTH: ");
                        sb5.append(i11);
                        break;
                    default:
                        switch (i102) {
                            case 800:
                                String unused11 = IjkVideoView.this.TAG;
                                break;
                            case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                                String unused12 = IjkVideoView.this.TAG;
                                break;
                            case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                                String unused13 = IjkVideoView.this.TAG;
                                break;
                        }
                }
                return true;
            }
        };
        this.mErrorListener = new IMediaPlayer.OnErrorListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i102, int i11) {
                String unused = IjkVideoView.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Error: ");
                sb.append(i102);
                sb.append(",");
                sb.append(i11);
                IjkVideoView.this.mCurrentState = -1;
                IjkVideoView.this.mTargetState = -1;
                if (IjkVideoView.this.mMediaController != null) {
                    IjkVideoView.this.mMediaController.hide();
                }
                if (IjkVideoView.this.mOnErrorListener != null && IjkVideoView.this.mOnErrorListener.onError(IjkVideoView.this.mMediaPlayer, i102, i11)) {
                    return true;
                }
                IjkVideoView.this.getWindowToken();
                return true;
            }
        };
        this.mBufferingUpdateListener = new IMediaPlayer.OnBufferingUpdateListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.6
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i102, long j10) {
                IjkVideoView.this.mCurrentBufferPercentage = i102;
            }
        };
        this.mSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.7
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            }
        };
        this.mOnTimedTextListener = new IMediaPlayer.OnTimedTextListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.8
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener
            public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
            }
        };
        this.mSHCallback = new IRenderView.IRenderCallback() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.9
            @Override // tv.danmaku.ijk.media.player.widget.media.IRenderView.IRenderCallback
            public void onSurfaceChanged(IRenderView.ISurfaceHolder iSurfaceHolder, int i102, int i11, int i12) {
                if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                    Log.e(IjkVideoView.this.TAG, "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.mSurfaceWidth = i11;
                IjkVideoView.this.mSurfaceHeight = i12;
                boolean z10 = true;
                boolean z11 = IjkVideoView.this.mTargetState == 3;
                if (IjkVideoView.this.mRenderView.shouldWaitForResize() && (IjkVideoView.this.mVideoWidth != i11 || IjkVideoView.this.mVideoHeight != i12)) {
                    z10 = false;
                }
                if (IjkVideoView.this.mMediaPlayer != null && z11 && z10) {
                    if (IjkVideoView.this.mSeekWhenPrepared != 0) {
                        IjkVideoView ijkVideoView = IjkVideoView.this;
                        ijkVideoView.seekTo(ijkVideoView.mSeekWhenPrepared);
                    }
                    IjkVideoView.this.start();
                }
            }

            @Override // tv.danmaku.ijk.media.player.widget.media.IRenderView.IRenderCallback
            public void onSurfaceCreated(IRenderView.ISurfaceHolder iSurfaceHolder, int i102, int i11) {
                if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                    Log.e(IjkVideoView.this.TAG, "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.surfaceCreated();
                IjkVideoView.this.mSurfaceHolder = iSurfaceHolder;
                if (IjkVideoView.this.mMediaPlayer == null) {
                    IjkVideoView.this.openVideo();
                } else {
                    IjkVideoView ijkVideoView = IjkVideoView.this;
                    ijkVideoView.bindSurfaceHolder(ijkVideoView.mMediaPlayer, iSurfaceHolder);
                }
            }

            @Override // tv.danmaku.ijk.media.player.widget.media.IRenderView.IRenderCallback
            public void onSurfaceDestroyed(IRenderView.ISurfaceHolder iSurfaceHolder) {
                if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                    Log.e(IjkVideoView.this.TAG, "onSurfaceDestroyed: unmatched render callback\n");
                } else {
                    IjkVideoView.this.mSurfaceHolder = null;
                    IjkVideoView.this.releaseWithoutStop();
                }
            }
        };
        this.mCurrentAspectRatio = 0;
        this.mCurrentRender = 1;
        initVideoView(context);
    }

    public IjkVideoView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.TAG = "IjkVideoView";
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.mCanPause = true;
        this.mCanSeekBack = true;
        this.mCanSeekForward = true;
        this.isIjkPlay = false;
        this.mSizeChangedListener = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.1
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i102, int i112, int i12, int i13) {
                IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
                IjkVideoView.this.mVideoSarNum = iMediaPlayer.getVideoSarNum();
                IjkVideoView.this.mVideoSarDen = iMediaPlayer.getVideoSarDen();
                if (IjkVideoView.this.mVideoWidth == 0 || IjkVideoView.this.mVideoHeight == 0) {
                    return;
                }
                if (IjkVideoView.this.mRenderView != null) {
                    IjkVideoView.this.mRenderView.setVideoSize(IjkVideoView.this.mVideoWidth, IjkVideoView.this.mVideoHeight);
                    IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(IjkVideoView.this.mVideoSarNum, IjkVideoView.this.mVideoSarDen);
                }
                IjkVideoView.this.requestLayout();
            }
        };
        this.mPreparedListener = new IMediaPlayer.OnPreparedListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.mCurrentState = 2;
                if (IjkVideoView.this.mOnPreparedListener != null) {
                    IjkVideoView.this.mOnPreparedListener.onPrepared(IjkVideoView.this.mMediaPlayer);
                }
                if (IjkVideoView.this.mMediaController != null) {
                    IjkVideoView.this.mMediaController.setEnabled(true);
                }
                IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
                IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
                int i102 = IjkVideoView.this.mSeekWhenPrepared;
                if (i102 != 0) {
                    IjkVideoView.this.seekTo(i102);
                }
                IjkVideoView.this.mMediaPlayer.getMediaInfo();
                if (IjkVideoView.this.mVideoWidth == 0 || IjkVideoView.this.mVideoHeight == 0) {
                    if (IjkVideoView.this.mTargetState == 3) {
                        IjkVideoView.this.start();
                        return;
                    }
                    return;
                }
                if (IjkVideoView.this.mRenderView != null) {
                    IjkVideoView.this.mRenderView.setVideoSize(IjkVideoView.this.mVideoWidth, IjkVideoView.this.mVideoHeight);
                    IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(IjkVideoView.this.mVideoSarNum, IjkVideoView.this.mVideoSarDen);
                    if (!IjkVideoView.this.mRenderView.shouldWaitForResize() || (IjkVideoView.this.mSurfaceWidth == IjkVideoView.this.mVideoWidth && IjkVideoView.this.mSurfaceHeight == IjkVideoView.this.mVideoHeight)) {
                        if (IjkVideoView.this.mTargetState == 3) {
                            IjkVideoView.this.start();
                            if (IjkVideoView.this.mMediaController != null) {
                                IjkVideoView.this.mMediaController.show();
                                return;
                            }
                            return;
                        }
                        if (IjkVideoView.this.isPlaying()) {
                            return;
                        }
                        if ((i102 != 0 || IjkVideoView.this.getCurrentPosition() > 0) && IjkVideoView.this.mMediaController != null) {
                            IjkVideoView.this.mMediaController.show(0);
                        }
                    }
                }
            }
        };
        this.mCompletionListener = new IMediaPlayer.OnCompletionListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                IjkVideoView.this.mCurrentState = 6;
                IjkVideoView.this.mTargetState = 6;
                if (IjkVideoView.this.mMediaController != null) {
                    IjkVideoView.this.mMediaController.hide();
                }
                if (IjkVideoView.this.mOnCompletionListener != null) {
                    IjkVideoView.this.mOnCompletionListener.onCompletion(IjkVideoView.this.mMediaPlayer);
                }
            }
        };
        this.mInfoListener = new IMediaPlayer.OnInfoListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i102, int i112) {
                if (IjkVideoView.this.mOnInfoListener != null) {
                    IjkVideoView.this.mOnInfoListener.onInfo(iMediaPlayer, i102, i112);
                }
                String unused = IjkVideoView.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(" arg1 ");
                sb.append(i102);
                sb.append("  this : ");
                sb.append(this);
                if (i102 == 3) {
                    String unused2 = IjkVideoView.this.TAG;
                    if (IjkVideoView.this.mTargetState != 4 || IjkVideoView.this.mCurrentState == IjkVideoView.this.mTargetState) {
                        return true;
                    }
                    IjkVideoView.this.pause();
                    return true;
                }
                if (i102 == 901) {
                    String unused3 = IjkVideoView.this.TAG;
                    return true;
                }
                if (i102 == 902) {
                    String unused4 = IjkVideoView.this.TAG;
                    return true;
                }
                if (i102 == 10001) {
                    IjkVideoView.this.mVideoRotationDegree = i112;
                    String unused5 = IjkVideoView.this.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("MEDIA_INFO_VIDEO_ROTATION_CHANGED: ");
                    sb2.append(i112);
                    if (IjkVideoView.this.mRenderView == null) {
                        return true;
                    }
                    IjkVideoView.this.mRenderView.setVideoRotation(i112);
                    return true;
                }
                if (i102 == 10002) {
                    String unused6 = IjkVideoView.this.TAG;
                    return true;
                }
                switch (i102) {
                    case 700:
                        String unused7 = IjkVideoView.this.TAG;
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                        String unused8 = IjkVideoView.this.TAG;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("MEDIA_INFO_BUFFERING_START:");
                        sb3.append(this);
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                        if (IjkVideoView.this.mTargetState == 4 && IjkVideoView.this.mCurrentState != IjkVideoView.this.mTargetState) {
                            IjkVideoView.this.pause();
                        }
                        String unused9 = IjkVideoView.this.TAG;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("MEDIA_INFO_BUFFERING_END: mTargetState ");
                        sb4.append(IjkVideoView.this.mTargetState);
                        sb4.append("  mCurrentState ");
                        sb4.append(IjkVideoView.this.mCurrentState);
                        sb4.append("   ");
                        sb4.append(this);
                        break;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                        String unused10 = IjkVideoView.this.TAG;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("MEDIA_INFO_NETWORK_BANDWIDTH: ");
                        sb5.append(i112);
                        break;
                    default:
                        switch (i102) {
                            case 800:
                                String unused11 = IjkVideoView.this.TAG;
                                break;
                            case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                                String unused12 = IjkVideoView.this.TAG;
                                break;
                            case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                                String unused13 = IjkVideoView.this.TAG;
                                break;
                        }
                }
                return true;
            }
        };
        this.mErrorListener = new IMediaPlayer.OnErrorListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i102, int i112) {
                String unused = IjkVideoView.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Error: ");
                sb.append(i102);
                sb.append(",");
                sb.append(i112);
                IjkVideoView.this.mCurrentState = -1;
                IjkVideoView.this.mTargetState = -1;
                if (IjkVideoView.this.mMediaController != null) {
                    IjkVideoView.this.mMediaController.hide();
                }
                if (IjkVideoView.this.mOnErrorListener != null && IjkVideoView.this.mOnErrorListener.onError(IjkVideoView.this.mMediaPlayer, i102, i112)) {
                    return true;
                }
                IjkVideoView.this.getWindowToken();
                return true;
            }
        };
        this.mBufferingUpdateListener = new IMediaPlayer.OnBufferingUpdateListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.6
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i102, long j10) {
                IjkVideoView.this.mCurrentBufferPercentage = i102;
            }
        };
        this.mSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.7
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            }
        };
        this.mOnTimedTextListener = new IMediaPlayer.OnTimedTextListener() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.8
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener
            public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
            }
        };
        this.mSHCallback = new IRenderView.IRenderCallback() { // from class: tv.danmaku.ijk.media.player.widget.IjkVideoView.9
            @Override // tv.danmaku.ijk.media.player.widget.media.IRenderView.IRenderCallback
            public void onSurfaceChanged(IRenderView.ISurfaceHolder iSurfaceHolder, int i102, int i112, int i12) {
                if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                    Log.e(IjkVideoView.this.TAG, "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.mSurfaceWidth = i112;
                IjkVideoView.this.mSurfaceHeight = i12;
                boolean z10 = true;
                boolean z11 = IjkVideoView.this.mTargetState == 3;
                if (IjkVideoView.this.mRenderView.shouldWaitForResize() && (IjkVideoView.this.mVideoWidth != i112 || IjkVideoView.this.mVideoHeight != i12)) {
                    z10 = false;
                }
                if (IjkVideoView.this.mMediaPlayer != null && z11 && z10) {
                    if (IjkVideoView.this.mSeekWhenPrepared != 0) {
                        IjkVideoView ijkVideoView = IjkVideoView.this;
                        ijkVideoView.seekTo(ijkVideoView.mSeekWhenPrepared);
                    }
                    IjkVideoView.this.start();
                }
            }

            @Override // tv.danmaku.ijk.media.player.widget.media.IRenderView.IRenderCallback
            public void onSurfaceCreated(IRenderView.ISurfaceHolder iSurfaceHolder, int i102, int i112) {
                if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                    Log.e(IjkVideoView.this.TAG, "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                IjkVideoView.this.surfaceCreated();
                IjkVideoView.this.mSurfaceHolder = iSurfaceHolder;
                if (IjkVideoView.this.mMediaPlayer == null) {
                    IjkVideoView.this.openVideo();
                } else {
                    IjkVideoView ijkVideoView = IjkVideoView.this;
                    ijkVideoView.bindSurfaceHolder(ijkVideoView.mMediaPlayer, iSurfaceHolder);
                }
            }

            @Override // tv.danmaku.ijk.media.player.widget.media.IRenderView.IRenderCallback
            public void onSurfaceDestroyed(IRenderView.ISurfaceHolder iSurfaceHolder) {
                if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                    Log.e(IjkVideoView.this.TAG, "onSurfaceDestroyed: unmatched render callback\n");
                } else {
                    IjkVideoView.this.mSurfaceHolder = null;
                    IjkVideoView.this.releaseWithoutStop();
                }
            }
        };
        this.mCurrentAspectRatio = 0;
        this.mCurrentRender = 1;
        initVideoView(context);
    }
}
