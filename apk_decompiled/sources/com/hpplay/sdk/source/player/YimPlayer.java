package com.hpplay.sdk.source.player;

import android.content.Context;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.protocol.YimBridge;

/* loaded from: classes3.dex */
public class YimPlayer extends AbsPlayer {
    public YimPlayer(Context context, OutParameter outParameter) {
        super(context);
        this.mBridge = new YimBridge(context, outParameter);
        initListener();
    }

    @Override // com.hpplay.sdk.source.player.AbsPlayer, com.hpplay.sdk.source.player.IPlayer
    public boolean pause(String str) {
        this.mBridge.pause(str);
        return true;
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void release(String str) {
        this.mBridge.release();
        removeListener();
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean resume(String str) {
        this.mBridge.resume(str);
        return true;
    }

    @Override // com.hpplay.sdk.source.player.AbsPlayer, com.hpplay.sdk.source.player.IPlayer
    public boolean seekTo(String str, int i10) {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter == null || outParameter.castType == 2 || outParameter.mimeType == 103) {
            return false;
        }
        this.mBridge.seekTo(i10);
        return true;
    }

    @Override // com.hpplay.sdk.source.player.AbsPlayer, com.hpplay.sdk.source.player.IPlayer
    public void setMirrorScreenSecret(boolean z10) {
        this.mBridge.setMirrorScreenSecret(z10);
    }

    @Override // com.hpplay.sdk.source.player.AbsPlayer, com.hpplay.sdk.source.player.IPlayer
    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
        this.mBridge.setSecondMirrorView(secondMirrorView);
    }

    @Override // com.hpplay.sdk.source.player.AbsPlayer, com.hpplay.sdk.source.player.IPlayer
    public void setWatermarkVisible(boolean z10) {
        this.mBridge.setWatermarkVisible(z10);
    }

    @Override // com.hpplay.sdk.source.player.AbsPlayer, com.hpplay.sdk.source.player.IPlayer
    public boolean start(String str) {
        int i10 = this.mCurrentState;
        if (i10 == 0) {
            this.mBridge.play(str);
            this.mCurrentState = 3;
            return true;
        }
        if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4) {
            return false;
        }
        this.mBridge.resume(str);
        return true;
    }

    @Override // com.hpplay.sdk.source.player.AbsPlayer, com.hpplay.sdk.source.player.IPlayer
    public void stop(String str) {
        this.mBridge.stop(str);
    }

    @Override // com.hpplay.sdk.source.player.AbsPlayer, com.hpplay.sdk.source.player.IPlayer
    public boolean switchExpansionScreen(boolean z10) {
        return this.mBridge.switchExpansionScreen(z10);
    }
}
