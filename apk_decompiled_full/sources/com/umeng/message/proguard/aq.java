package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.badge.BadgeDrawable;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.UTrack;
import com.umeng.message.api.UPushInAppMessageCallback;
import com.umeng.message.api.UPushInAppMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import java.io.File;

/* loaded from: classes3.dex */
public final class aq {

    /* renamed from: a, reason: collision with root package name */
    protected ap f11538a;

    /* renamed from: b, reason: collision with root package name */
    public final at f11539b;

    /* renamed from: c, reason: collision with root package name */
    public final View.OnClickListener f11540c;

    /* renamed from: d, reason: collision with root package name */
    public int f11541d;

    public aq(Context context, final ap apVar) {
        this.f11538a = apVar;
        at atVar = new at(context, apVar);
        this.f11539b = atVar;
        atVar.setClipChildren(false);
        atVar.setClipToPadding(false);
        atVar.setClickable(true);
        atVar.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.proguard.aq.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    Activity activity = (Activity) view.getContext();
                    if (activity == null) {
                        return;
                    }
                    UPLog.i("Pop", "click msgId:", apVar.f11535a.getMsgId());
                    v.a().getNotificationClickHandler().handleMessage(activity, apVar.f11535a);
                    try {
                        UPushInAppMessageCallback inAppMessageCallback = v.a().getInAppMessageCallback();
                        if (inAppMessageCallback != null) {
                            inAppMessageCallback.onClick(y.a(), apVar.f11535a);
                        }
                    } catch (Throwable th) {
                        UPLog.e("Pop", "onClick", th);
                    }
                    ak.a().a(activity);
                    UTrack.getInstance().trackInAppNotifyClick(apVar.f11535a);
                } catch (Throwable th2) {
                    UPLog.e("Pop", th2);
                }
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.umeng.message.proguard.aq.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    Activity activity = (Activity) view.getContext();
                    if (activity == null) {
                        return;
                    }
                    UPLog.i("Pop", "close msgId:", apVar.f11535a.getMsgId());
                    ak.a().a(activity);
                } catch (Throwable th) {
                    UPLog.e("Pop", "onDismiss", th);
                }
            }
        };
        this.f11540c = onClickListener;
        atVar.setDismissListener(onClickListener);
        this.f11541d = bo.a(80.0f);
        UPushInAppMessageHandler inAppMessageHandler = v.a().getInAppMessageHandler();
        if (inAppMessageHandler != null) {
            try {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f11541d);
                layoutParams.gravity = 17;
                View view = inAppMessageHandler.getView(context, apVar.f11535a, layoutParams);
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    int i10 = layoutParams.height;
                    if (i10 > 0 && i10 != this.f11541d) {
                        this.f11541d = i10;
                    }
                    atVar.setBackgroundColor(0);
                    atVar.addView(view, layoutParams);
                    return;
                }
            } catch (Throwable th) {
                UPLog.e("Pop", "custom view error", th);
            }
        }
        final int a10 = bo.a(8.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            float f10 = a10;
            this.f11539b.setElevation(f10);
            this.f11539b.setTranslationZ(f10);
        }
        this.f11539b.setBackgroundDrawable(new ShapeDrawable(new RectShape() { // from class: com.umeng.message.proguard.aq.3
            @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
            public final void draw(Canvas canvas, Paint paint) {
                paint.setColor(-83886081);
                RectF rect = rect();
                int i11 = a10;
                canvas.drawRoundRect(rect, i11, i11, paint);
            }
        }));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(bo.a(12.0f), 0, bo.a(26.0f), 0);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 16;
        linearLayout.setLayoutParams(layoutParams2);
        this.f11539b.addView(linearLayout);
        Bitmap a11 = a(context, apVar.f11535a);
        if (a11 != null && a11.getWidth() > 0 && a11.getHeight() > 0) {
            ImageView imageView = new ImageView(context);
            int a12 = bo.a(48.0f);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(Math.min(a12 * 2, (a11.getWidth() * a12) / a11.getHeight()), a12);
            layoutParams3.gravity = 16;
            layoutParams3.leftMargin = bo.a(4.0f);
            linearLayout.addView(imageView, layoutParams3);
            imageView.setImageDrawable(new au(a11, bo.a(8.0f)));
        }
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.gravity = 16;
        if (a11 != null) {
            layoutParams4.leftMargin = bo.a(10.0f);
        }
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2, layoutParams4);
        TextView textView = new TextView(context);
        textView.setText(apVar.f11535a.getTitle());
        textView.setSingleLine();
        textView.setMaxLines(1);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(-14341836);
        textView.setTextSize(2, 16.0f);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setText(apVar.f11535a.getContent());
        textView2.setTextColor(-14341836);
        textView2.setSingleLine();
        textView2.setMaxLines(1);
        textView2.setTextSize(2, 14.0f);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.topMargin = bo.a(4.0f);
        linearLayout2.addView(textView2, layoutParams5);
        if (ak.a().c().f11528f) {
            int a13 = bo.a(24.0f);
            FrameLayout frameLayout = new FrameLayout(context);
            ar arVar = new ar(context);
            int a14 = bo.a(3.0f);
            int a15 = bo.a(8.0f);
            frameLayout.setPadding(a14, a15, a15, a14);
            frameLayout.addView(arVar);
            FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(a13, a13);
            layoutParams6.gravity = BadgeDrawable.TOP_END;
            this.f11539b.addView(frameLayout, layoutParams6);
            frameLayout.setOnClickListener(this.f11540c);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042 A[Catch: all -> 0x0068, TRY_ENTER, TryCatch #1 {all -> 0x0068, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x0011, B:9:0x0030, B:15:0x003a, B:13:0x0042, B:19:0x004c, B:21:0x005f), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030 A[Catch: all -> 0x0068, TRY_LEAVE, TryCatch #1 {all -> 0x0068, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x0011, B:9:0x0030, B:15:0x003a, B:13:0x0042, B:19:0x004c, B:21:0x005f), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap a(Context context, UMessage uMessage) {
        Bitmap bitmap;
        int i10;
        int c10;
        try {
            if (uMessage.isLargeIconFromInternet()) {
                String largeIconUrl = uMessage.getLargeIconUrl();
                if (!TextUtils.isEmpty(largeIconUrl)) {
                    bitmap = f.a(new File(f.g(context), UMUtils.MD5(largeIconUrl)), bo.a(48.0f), bo.a(48.0f));
                    if (bitmap == null) {
                        String largeIconDrawableName = uMessage.getLargeIconDrawableName();
                        if (!TextUtils.isEmpty(largeIconDrawableName)) {
                            try {
                                c10 = a.c(largeIconDrawableName);
                            } catch (Exception unused) {
                            }
                            if (c10 > 0) {
                                bitmap = BitmapFactory.decodeResource(context.getResources(), c10);
                            }
                        }
                        c10 = -1;
                        if (c10 > 0) {
                        }
                    }
                    return (bitmap != null || (i10 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon) <= 0) ? bitmap : BitmapFactory.decodeResource(context.getResources(), i10);
                }
            }
            bitmap = null;
            if (bitmap == null) {
            }
            if (bitmap != null) {
                return bitmap;
            }
        } catch (Throwable th) {
            UPLog.e("Pop", th);
            return null;
        }
    }

    public final ap b() {
        return this.f11538a;
    }

    public final String a() {
        return this.f11538a.f11535a.getMsgId();
    }
}
