package com.titan.thumbnail;

import android.view.View;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import java.io.File;
import t9.i;

/* loaded from: classes3.dex */
public abstract class ThumbTarget extends SimpleTarget<File> {
    private final int tagId;
    private final String url;
    private final View view;

    public ThumbTarget(View view, String str) {
        i.h(view, "view");
        i.h(str, "url");
        this.view = view;
        this.url = str;
        this.tagId = R.id.glide_custom_view_target_tag;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public Request getRequest() {
        Object tag = this.view.getTag(this.tagId);
        if (!(tag instanceof Request)) {
            tag = null;
        }
        return (Request) tag;
    }

    public final String getUrl() {
        return this.url;
    }

    public final View getView() {
        return this.view;
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
        onResourceReady((File) obj, (Transition<? super File>) transition);
    }

    public abstract void onResourceReadyUrl(File file, String str);

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void setRequest(Request request) {
        this.view.setTag(this.tagId, request);
    }

    public void onResourceReady(File file, Transition<? super File> transition) {
        i.h(file, "resource");
        onResourceReadyUrl(file, this.url);
    }
}
