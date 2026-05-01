package com.hpplay.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.hpplay.glide.request.animation.GlideAnimation;

/* loaded from: classes2.dex */
public class AppWidgetTarget extends SimpleTarget<Bitmap> {
    private final ComponentName componentName;
    private final Context context;
    private final RemoteViews remoteViews;
    private final int viewId;
    private final int[] widgetIds;

    public AppWidgetTarget(Context context, RemoteViews remoteViews, int i10, int i11, int i12, int... iArr) {
        super(i11, i12);
        if (context == null) {
            throw new NullPointerException("Context can not be null!");
        }
        if (iArr == null) {
            throw new NullPointerException("WidgetIds can not be null!");
        }
        if (iArr.length == 0) {
            throw new IllegalArgumentException("WidgetIds must have length > 0");
        }
        if (remoteViews == null) {
            throw new NullPointerException("RemoteViews object can not be null!");
        }
        this.context = context;
        this.remoteViews = remoteViews;
        this.viewId = i10;
        this.widgetIds = iArr;
        this.componentName = null;
    }

    private void update() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.context);
        ComponentName componentName = this.componentName;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.remoteViews);
        } else {
            appWidgetManager.updateAppWidget(this.widgetIds, this.remoteViews);
        }
    }

    @Override // com.hpplay.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        onResourceReady((Bitmap) obj, (GlideAnimation<? super Bitmap>) glideAnimation);
    }

    public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }

    public AppWidgetTarget(Context context, RemoteViews remoteViews, int i10, int... iArr) {
        this(context, remoteViews, i10, Integer.MIN_VALUE, Integer.MIN_VALUE, iArr);
    }

    public AppWidgetTarget(Context context, RemoteViews remoteViews, int i10, int i11, int i12, ComponentName componentName) {
        super(i11, i12);
        if (context == null) {
            throw new NullPointerException("Context can not be null!");
        }
        if (componentName == null) {
            throw new NullPointerException("ComponentName can not be null!");
        }
        if (remoteViews != null) {
            this.context = context;
            this.remoteViews = remoteViews;
            this.viewId = i10;
            this.componentName = componentName;
            this.widgetIds = null;
            return;
        }
        throw new NullPointerException("RemoteViews object can not be null!");
    }

    public AppWidgetTarget(Context context, RemoteViews remoteViews, int i10, ComponentName componentName) {
        this(context, remoteViews, i10, Integer.MIN_VALUE, Integer.MIN_VALUE, componentName);
    }
}
