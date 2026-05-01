package com.mobile.brasiltv.view;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.app.App;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class MsgNotifyDialog extends Dialog {
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_CALENDAR = 1;
    public static final int TYPE_NOTIFICATION = 2;
    private Activity activity;
    private final Handler mHandler;
    private final int type;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(t9.g gVar) {
            this();
        }
    }

    public /* synthetic */ MsgNotifyDialog(Activity activity, int i10, int i11, t9.g gVar) {
        this(activity, (i11 & 2) != 0 ? 1 : i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(MsgNotifyDialog msgNotifyDialog, View view) {
        t9.i.g(msgNotifyDialog, "this$0");
        if (msgNotifyDialog.type == 1) {
            msgNotifyDialog.checkCalendarPermission();
        } else {
            q5.i.f18197a.l(msgNotifyDialog.activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(MsgNotifyDialog msgNotifyDialog, View view) {
        t9.i.g(msgNotifyDialog, "this$0");
        msgNotifyDialog.dismiss();
        if (msgNotifyDialog.type == 1) {
            App.f8263e.a().j().o(System.currentTimeMillis());
        }
    }

    private final void checkCalendarPermission() {
        Activity activity = this.activity;
        t9.i.e(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        Observable s10 = new c8.b((androidx.fragment.app.e) activity).s(this.activity, "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR");
        final MsgNotifyDialog$checkCalendarPermission$1 msgNotifyDialog$checkCalendarPermission$1 = new MsgNotifyDialog$checkCalendarPermission$1(this);
        Consumer consumer = new Consumer() { // from class: com.mobile.brasiltv.view.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MsgNotifyDialog.checkCalendarPermission$lambda$7(s9.l.this, obj);
            }
        };
        final MsgNotifyDialog$checkCalendarPermission$2 msgNotifyDialog$checkCalendarPermission$2 = MsgNotifyDialog$checkCalendarPermission$2.INSTANCE;
        s10.subscribe(consumer, new Consumer() { // from class: com.mobile.brasiltv.view.r
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MsgNotifyDialog.checkCalendarPermission$lambda$8(s9.l.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkCalendarPermission$lambda$7(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkCalendarPermission$lambda$8(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    private final void recheckPermission() {
        int i10 = this.type;
        if (i10 != 1) {
            if (i10 != 2) {
                return;
            }
            q5.i iVar = q5.i.f18197a;
            Activity activity = this.activity;
            t9.i.d(activity);
            if (iVar.j(activity)) {
                com.mobile.brasiltv.utils.b0.U(this, "recheckPermission: type: 2 result: true");
                this.mHandler.postDelayed(new Runnable() { // from class: com.mobile.brasiltv.view.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        MsgNotifyDialog.recheckPermission$lambda$10(MsgNotifyDialog.this);
                    }
                }, 600L);
            }
            com.mobile.brasiltv.utils.b0.U(this, "recheckPermission: type: 2 result: false");
            return;
        }
        Activity activity2 = this.activity;
        t9.i.e(activity2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        c8.b bVar = new c8.b((androidx.fragment.app.e) activity2);
        boolean i11 = bVar.i("android.permission.READ_CALENDAR");
        boolean i12 = bVar.i("android.permission.WRITE_CALENDAR");
        StringBuilder sb = new StringBuilder();
        sb.append("recheckPermission: type: 1 result: ");
        sb.append(i11 && i12);
        com.mobile.brasiltv.utils.b0.U(this, sb.toString());
        if (i11 && i12) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.mobile.brasiltv.view.u
                @Override // java.lang.Runnable
                public final void run() {
                    MsgNotifyDialog.recheckPermission$lambda$9(MsgNotifyDialog.this);
                }
            }, 600L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recheckPermission$lambda$10(MsgNotifyDialog msgNotifyDialog) {
        t9.i.g(msgNotifyDialog, "this$0");
        msgNotifyDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recheckPermission$lambda$9(MsgNotifyDialog msgNotifyDialog) {
        t9.i.g(msgNotifyDialog, "this$0");
        msgNotifyDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestCalendarPermission() {
        Activity activity = this.activity;
        t9.i.e(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        Observable p10 = new c8.b((androidx.fragment.app.e) activity).p("android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR");
        Callable callable = new Callable() { // from class: com.mobile.brasiltv.view.w
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ArrayList requestCalendarPermission$lambda$3;
                requestCalendarPermission$lambda$3 = MsgNotifyDialog.requestCalendarPermission$lambda$3();
                return requestCalendarPermission$lambda$3;
            }
        };
        final MsgNotifyDialog$requestCalendarPermission$2 msgNotifyDialog$requestCalendarPermission$2 = new MsgNotifyDialog$requestCalendarPermission$2(this);
        Single collect = p10.collect(callable, new BiConsumer() { // from class: com.mobile.brasiltv.view.x
            @Override // io.reactivex.functions.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MsgNotifyDialog.requestCalendarPermission$lambda$4(s9.p.this, obj, obj2);
            }
        });
        final MsgNotifyDialog$requestCalendarPermission$3 msgNotifyDialog$requestCalendarPermission$3 = new MsgNotifyDialog$requestCalendarPermission$3(this);
        Consumer consumer = new Consumer() { // from class: com.mobile.brasiltv.view.y
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MsgNotifyDialog.requestCalendarPermission$lambda$5(s9.l.this, obj);
            }
        };
        final MsgNotifyDialog$requestCalendarPermission$4 msgNotifyDialog$requestCalendarPermission$4 = MsgNotifyDialog$requestCalendarPermission$4.INSTANCE;
        collect.subscribe(consumer, new Consumer() { // from class: com.mobile.brasiltv.view.z
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MsgNotifyDialog.requestCalendarPermission$lambda$6(s9.l.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList requestCalendarPermission$lambda$3() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Boolean.TRUE);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestCalendarPermission$lambda$4(s9.p pVar, Object obj, Object obj2) {
        t9.i.g(pVar, "$tmp0");
        pVar.invoke(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestCalendarPermission$lambda$5(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestCalendarPermission$lambda$6(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        com.mobile.brasiltv.utils.b0.U(this, "MsgNotifyDialog focus: " + z10);
        if (z10) {
            recheckPermission();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgNotifyDialog(Activity activity, int i10) {
        super(activity, R.style.OptionDialog);
        t9.i.d(activity);
        this.activity = activity;
        this.type = i10;
        this.mHandler = new Handler(Looper.getMainLooper());
        setContentView(R.layout.dialog_msg_notify);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = AutoUtils.getPercentWidthSize(520);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        if (i10 == 1) {
            ((KoocanButton) findViewById(R$id.mButtonEnableFunc)).setText(getContext().getResources().getString(R.string.open_msg_notify_calendar));
        } else {
            ((KoocanButton) findViewById(R$id.mButtonEnableFunc)).setText(getContext().getResources().getString(R.string.open_msg_notify_mobile));
            ((TextView) findViewById(R$id.mTvHint)).setVisibility(0);
        }
        ((KoocanButton) findViewById(R$id.mButtonEnableFunc)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MsgNotifyDialog._init_$lambda$1(MsgNotifyDialog.this, view);
            }
        });
        ((KoocanButton) findViewById(R$id.mButtonNotNeed)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MsgNotifyDialog._init_$lambda$2(MsgNotifyDialog.this, view);
            }
        });
        setCanceledOnTouchOutside(false);
    }
}
