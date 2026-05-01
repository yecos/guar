package com.mobile.brasiltv.view.dialog.feedback;

import android.widget.ScrollView;
import com.mobile.brasiltv.R$id;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class FeedBackFullScreenDialog$contentHolder$2 extends j implements s9.a {
    final /* synthetic */ String $name;
    final /* synthetic */ FeedBackFullScreenDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBackFullScreenDialog$contentHolder$2(String str, FeedBackFullScreenDialog feedBackFullScreenDialog) {
        super(0);
        this.$name = str;
        this.this$0 = feedBackFullScreenDialog;
    }

    @Override // s9.a
    public final ContentHolder invoke() {
        String str = this.$name;
        ScrollView scrollView = (ScrollView) this.this$0.findViewById(R$id.slItemContent);
        i.f(scrollView, "slItemContent");
        return new ContentHolder(str, scrollView, this.this$0);
    }
}
