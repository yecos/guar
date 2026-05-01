package tv.danmaku.ijk.media.player;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.Log;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import tv.danmaku.ijk.media.player.misc.ExoTrackInfo;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

/* loaded from: classes2.dex */
public class ExoMediaPlayer extends AbstractMediaPlayer {
    private Context mContext;
    private Handler mHandler;
    private SimpleExoPlayer mPlayer;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private SurfaceHolder mSurfaceHolder;
    private DefaultTrackSelector mTrackSelector;
    private final String TAG = "ExoMediaPlayer";
    private boolean mIsPreparing = true;
    private boolean mIsBuffering = false;

    public ExoMediaPlayer(Context context) {
        this.mContext = context;
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(this.mContext);
        this.mTrackSelector = defaultTrackSelector;
        defaultTrackSelector.setParameters(defaultTrackSelector.buildUponParameters().setPreferredAudioLanguage("por"));
        this.mPlayer = new SimpleExoPlayer.Builder(this.mContext).setTrackSelector(this.mTrackSelector).build();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mPlayer.addListener(new Player.EventListener() { // from class: tv.danmaku.ijk.media.player.ExoMediaPlayer.1
            public void onIsLoadingChanged(boolean z10) {
                if (z10) {
                    return;
                }
                ExoMediaPlayer exoMediaPlayer = ExoMediaPlayer.this;
                exoMediaPlayer.notifyOnBufferingUpdate(exoMediaPlayer.mPlayer.getBufferedPercentage(), ExoMediaPlayer.this.mPlayer.getBufferedPosition());
            }

            public void onIsPlayingChanged(boolean z10) {
            }

            public void onPlayWhenReadyChanged(boolean z10, int i10) {
            }

            public void onPlaybackStateChanged(int i10) {
                if (i10 == 2) {
                    ExoMediaPlayer.this.notifyOnInfo(IMediaPlayer.MEDIA_INFO_BUFFERING_START, IMediaPlayer.MEDIA_INFO_BUFFERING_START);
                    ExoMediaPlayer.this.mIsBuffering = true;
                    return;
                }
                if (i10 == 3) {
                    if (ExoMediaPlayer.this.mIsBuffering) {
                        ExoMediaPlayer.this.mIsBuffering = false;
                        ExoMediaPlayer.this.notifyOnInfo(IMediaPlayer.MEDIA_INFO_BUFFERING_END, IMediaPlayer.MEDIA_INFO_BUFFERING_END);
                    }
                    if (ExoMediaPlayer.this.mIsPreparing) {
                        ExoMediaPlayer.this.mIsPreparing = false;
                        ExoMediaPlayer.this.notifyOnPrepared();
                        return;
                    }
                    return;
                }
                if (i10 != 4) {
                    return;
                }
                if (ExoMediaPlayer.this.mIsBuffering) {
                    ExoMediaPlayer.this.mIsBuffering = false;
                    ExoMediaPlayer.this.notifyOnInfo(IMediaPlayer.MEDIA_INFO_BUFFERING_END, IMediaPlayer.MEDIA_INFO_BUFFERING_END);
                } else {
                    ExoMediaPlayer.this.stayAwake(false);
                    ExoMediaPlayer.this.notifyOnCompletion();
                }
            }

            public void onPlayerError(ExoPlaybackException exoPlaybackException) {
                ExoMediaPlayer.this.notifyOnError(exoPlaybackException.type, exoPlaybackException.rendererFormatSupport);
                ExoMediaPlayer.this.stayAwake(false);
            }

            public void onPositionDiscontinuity(int i10) {
            }

            public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            }
        });
        this.mPlayer.addAnalyticsListener(new AnalyticsListener() { // from class: tv.danmaku.ijk.media.player.ExoMediaPlayer.2
            public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i10, long j10) {
                Log.w("ExoMediaPlayer", "onDroppedVideoFrames:  droppedFrames: " + i10);
            }

            public void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            }

            public void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            }

            public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Surface surface) {
                ExoMediaPlayer.this.notifyOnInfo(3, 3);
            }

            public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stayAwake(boolean z10) {
        this.mStayAwake = z10;
        updateSurfaceScreenOn();
    }

    private void updateSurfaceScreenOn() {
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return this.mPlayer.getAudioSessionId();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return this.mPlayer.getCurrentPosition();
        }
        final AtomicLong atomicLong = new AtomicLong(-1L);
        this.mHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.ExoMediaPlayer.10
            @Override // java.lang.Runnable
            public void run() {
                atomicLong.set(ExoMediaPlayer.this.mPlayer.getCurrentPosition());
            }
        });
        while (atomicLong.get() == -1) {
        }
        return atomicLong.get();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return this.mPlayer.getDuration();
        }
        final AtomicLong atomicLong = new AtomicLong(-1L);
        this.mHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.ExoMediaPlayer.11
            @Override // java.lang.Runnable
            public void run() {
                atomicLong.set(ExoMediaPlayer.this.mPlayer.getDuration());
            }
        });
        while (atomicLong.get() == -1) {
        }
        return atomicLong.get();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.mMediaPlayerName = "ExoPlayer";
        return mediaInfo;
    }

    public int getSelectedAudioTrack(int i10) {
        if (this.mPlayer.getAudioFormat() == null || this.mPlayer.getAudioFormat().id == null) {
            return -1;
        }
        return Integer.getInteger(this.mPlayer.getAudioFormat().id, -1).intValue() - 1;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        ArrayList arrayList = new ArrayList();
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.mTrackSelector.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo != null) {
            for (int i10 = 0; i10 < currentMappedTrackInfo.getRendererCount(); i10++) {
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i10);
                for (int i11 = 0; i11 < trackGroups.length; i11++) {
                    arrayList.add(new ExoTrackInfo(trackGroups.get(i11)));
                }
            }
        }
        return arrayList.size() > 0 ? (ITrackInfo[]) arrayList.toArray(new ExoTrackInfo[0]) : new ITrackInfo[0];
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        if (this.mPlayer.getVideoFormat() == null) {
            return 0;
        }
        return this.mPlayer.getVideoFormat().height;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        if (this.mPlayer.getVideoFormat() == null) {
            return 0;
        }
        return this.mPlayer.getVideoFormat().width;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return this.mPlayer.getRepeatMode() == 2;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(-1);
        this.mHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.ExoMediaPlayer.15
            @Override // java.lang.Runnable
            public void run() {
                atomicInteger.set(ExoMediaPlayer.this.mPlayer.getRepeatMode());
            }
        });
        while (atomicInteger.get() == -1) {
        }
        return atomicInteger.get() == 2;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return this.mPlayer.isPlaying();
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        this.mHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.ExoMediaPlayer.8
            @Override // java.lang.Runnable
            public void run() {
                atomicBoolean2.set(ExoMediaPlayer.this.mPlayer.isPlaying());
                atomicBoolean.set(true);
            }
        });
        while (!atomicBoolean.get()) {
        }
        return atomicBoolean2.get();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() {
        stayAwake(false);
        this.mHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.ExoMediaPlayer.7
            @Override // java.lang.Runnable
            public void run() {
                ExoMediaPlayer.this.mPlayer.pause();
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() {
        this.mHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.ExoMediaPlayer.5
            @Override // java.lang.Runnable
            public void run() {
                ExoMediaPlayer.this.mPlayer.setPlayWhenReady(true);
                ExoMediaPlayer.this.mPlayer.prepare();
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        stayAwake(false);
        this.mHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.ExoMediaPlayer.12
            @Override // java.lang.Runnable
            public void run() {
                ExoMediaPlayer.this.mPlayer.release();
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        stayAwake(false);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void seekTo(final long j10) {
        this.mHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.ExoMediaPlayer.9
            @Override // java.lang.Runnable
            public void run() {
                ExoMediaPlayer.this.mPlayer.seekTo(j10);
            }
        });
    }

    public void selectAudioTrack(String str) {
        DefaultTrackSelector defaultTrackSelector = this.mTrackSelector;
        defaultTrackSelector.setParameters(defaultTrackSelector.getParameters().buildUpon().setPreferredAudioLanguage(str));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i10) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        if (surfaceHolder == null) {
            setSurface(null);
        } else {
            setSurface(surfaceHolder.getSurface());
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z10) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z10) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(final boolean z10) {
        this.mHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.ExoMediaPlayer.14
            @Override // java.lang.Runnable
            public void run() {
                ExoMediaPlayer.this.mPlayer.setRepeatMode(z10 ? 2 : 0);
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z10) {
        if (this.mScreenOnWhilePlaying != z10) {
            if (z10 && this.mSurfaceHolder == null) {
                Log.w("ExoMediaPlayer", "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z10;
            updateSurfaceScreenOn();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(final Surface surface) {
        this.mHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.ExoMediaPlayer.16
            @Override // java.lang.Runnable
            public void run() {
                ExoMediaPlayer.this.mPlayer.setVideoSurface(surface);
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(final float f10, float f11) {
        this.mHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.ExoMediaPlayer.13
            @Override // java.lang.Runnable
            public void run() {
                ExoMediaPlayer.this.mPlayer.setVolume(f10);
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setWakeMode(Context context, int i10) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() {
        stayAwake(true);
        this.mPlayer.play();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() {
        stayAwake(false);
        this.mHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.ExoMediaPlayer.6
            @Override // java.lang.Runnable
            public void run() {
                ExoMediaPlayer.this.mPlayer.stop();
                ExoMediaPlayer.this.mPlayer.release();
                ExoMediaPlayer.this.mPlayer.setVideoSurface((Surface) null);
            }
        });
    }

    public void selectAudioTrack(int i10) {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.mTrackSelector.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo != null) {
            int i11 = -1;
            int i12 = -1;
            for (int i13 = 0; i13 < currentMappedTrackInfo.getRendererCount(); i13++) {
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i13);
                int rendererType = currentMappedTrackInfo.getRendererType(i13);
                for (int i14 = 0; i14 < trackGroups.length; i14++) {
                    i12++;
                    if (1 == rendererType) {
                        i11++;
                        if (i10 == i12) {
                            break;
                        }
                    }
                }
            }
            TrackGroupArray trackGroups2 = currentMappedTrackInfo.getTrackGroups(1);
            DefaultTrackSelector.SelectionOverride selectionOverride = new DefaultTrackSelector.SelectionOverride(i11, new int[]{0});
            DefaultTrackSelector defaultTrackSelector = this.mTrackSelector;
            defaultTrackSelector.setParameters(defaultTrackSelector.getParameters().buildUpon().setSelectionOverride(1, trackGroups2, selectionOverride));
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, final Uri uri) {
        this.mHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.ExoMediaPlayer.3
            @Override // java.lang.Runnable
            public void run() {
                ExoMediaPlayer.this.mPlayer.setMediaItem(MediaItem.fromUri(uri));
            }
        });
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(final String str) {
        this.mHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.ExoMediaPlayer.4
            @Override // java.lang.Runnable
            public void run() {
                ExoMediaPlayer.this.mPlayer.setMediaItem(MediaItem.fromUri(str));
            }
        });
    }
}
