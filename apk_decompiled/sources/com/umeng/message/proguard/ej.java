package com.umeng.message.proguard;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* loaded from: classes3.dex */
public final class ej extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a, reason: collision with root package name */
    public cv f12057a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12058b;

    public ej(Context context) {
        super(context);
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        holder.setFormat(-3);
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ce.a("SurfaceView", "onAttachedToWindow");
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ce.a("SurfaceView", "onDetachedFromWindow");
    }

    public final void setVideoPlayer(cv cvVar) {
        this.f12057a = cvVar;
        if (cvVar != null) {
            cvVar.f11828b = getHolder();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        ce.a("SurfaceView", "surfaceChanged format:" + i10 + " width:" + i11 + " height:" + i12);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        ce.a("SurfaceView", "surfaceCreated");
        if (!this.f12058b) {
            cv cvVar = this.f12057a;
            if (cvVar != null) {
                cvVar.a();
                return;
            }
            return;
        }
        this.f12058b = true;
        cv cvVar2 = this.f12057a;
        if (cvVar2 != null) {
            cvVar2.c();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        ce.a("SurfaceView", "surfaceDestroyed playing:", Boolean.valueOf(this.f12058b));
        cv cvVar = this.f12057a;
        if (cvVar != null) {
            boolean d10 = cvVar.d();
            this.f12058b = d10;
            this.f12057a.a(d10);
        }
    }
}
