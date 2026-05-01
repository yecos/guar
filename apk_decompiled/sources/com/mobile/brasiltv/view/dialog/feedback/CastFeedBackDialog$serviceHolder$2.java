package com.mobile.brasiltv.view.dialog.feedback;

import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class CastFeedBackDialog$serviceHolder$2 extends j implements s9.a {
    final /* synthetic */ CastFeedBackDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CastFeedBackDialog$serviceHolder$2(CastFeedBackDialog castFeedBackDialog) {
        super(0);
        this.this$0 = castFeedBackDialog;
    }

    @Override // s9.a
    public final ServiceHolder invoke() {
        RecyclerView recyclerView = (RecyclerView) this.this$0.findViewById(R$id.slItemService);
        i.f(recyclerView, "slItemService");
        return new ServiceHolder(recyclerView, this.this$0);
    }
}
