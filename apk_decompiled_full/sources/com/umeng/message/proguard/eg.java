package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.umeng.message.push.R;

/* loaded from: classes3.dex */
public final class eg extends eh {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f12030a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f12031b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f12032c;

    public eg(Context context) {
        super(context);
        View.inflate(getContext(), R.layout.umeng_fi_layout, this);
        this.f12030a = (ImageView) findViewById(R.id.umeng_fi_close);
        this.f12031b = (ImageView) findViewById(R.id.umeng_fi_img);
        this.f12032c = (ImageView) findViewById(R.id.umeng_fi_mark);
    }

    public final void setAdImage(Bitmap bitmap) {
        if (bitmap == null || bitmap.getWidth() == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f12031b.getLayoutParams();
        int a10 = ed.a(64.0f);
        layoutParams.width = a10;
        layoutParams.height = Math.min((a10 * bitmap.getHeight()) / bitmap.getWidth(), layoutParams.width * 2);
        this.f12031b.setLayoutParams(layoutParams);
        this.f12031b.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f12031b.setImageBitmap(bitmap);
    }

    public final void setAdMarkVisibility(boolean z10) {
        ImageView imageView = this.f12032c;
        if (imageView != null) {
            if (z10) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public final void setCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f12030a;
        if (imageView != null) {
            imageView.setTag(onClickListener);
            this.f12030a.setOnClickListener(onClickListener);
        }
    }

    public final void setIconClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f12031b;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }
}
