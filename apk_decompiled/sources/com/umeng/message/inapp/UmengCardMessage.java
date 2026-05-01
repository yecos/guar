package com.umeng.message.inapp;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.firebase.messaging.Constants;
import com.hpplay.sdk.source.common.global.Constant;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.a;
import com.umeng.message.proguard.aj;
import com.umeng.message.proguard.bo;
import com.umeng.message.proguard.br;
import com.umeng.message.proguard.f;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class UmengCardMessage extends DialogFragment {

    /* renamed from: b, reason: collision with root package name */
    private static final String f11389b = "com.umeng.message.inapp.UmengCardMessage";

    /* renamed from: a, reason: collision with root package name */
    public IUmengInAppMsgCloseCallback f11390a;

    /* renamed from: c, reason: collision with root package name */
    private Activity f11391c;

    /* renamed from: d, reason: collision with root package name */
    private UInAppMessage f11392d;

    /* renamed from: e, reason: collision with root package name */
    private String f11393e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f11394f;

    /* renamed from: g, reason: collision with root package name */
    private ViewGroup f11395g;

    /* renamed from: h, reason: collision with root package name */
    private int f11396h;

    /* renamed from: i, reason: collision with root package name */
    private int f11397i;

    /* renamed from: j, reason: collision with root package name */
    private int f11398j;

    /* renamed from: k, reason: collision with root package name */
    private int f11399k;

    /* renamed from: l, reason: collision with root package name */
    private UInAppHandler f11400l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f11401m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f11402n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f11403o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f11404p = false;

    /* renamed from: q, reason: collision with root package name */
    private String[] f11405q = {"18", "16", "16"};

    public static /* synthetic */ boolean a(UmengCardMessage umengCardMessage) {
        umengCardMessage.f11402n = true;
        return true;
    }

    public static /* synthetic */ boolean e(UmengCardMessage umengCardMessage) {
        umengCardMessage.f11404p = true;
        return true;
    }

    public static /* synthetic */ boolean f(UmengCardMessage umengCardMessage) {
        umengCardMessage.f11403o = true;
        return true;
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f11395g != null) {
            RelativeLayout.LayoutParams layoutParams = configuration.orientation == 1 ? new RelativeLayout.LayoutParams(-1, -2) : new RelativeLayout.LayoutParams(-2, -1);
            int a10 = bo.a(30.0f);
            int a11 = bo.a(15.0f);
            layoutParams.setMargins(a10, a11, a10, a11);
            layoutParams.addRule(13);
            this.f11395g.setLayoutParams(layoutParams);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, R.style.Theme.NoTitleBar);
        setRetainInstance(true);
        try {
            this.f11391c = getActivity();
            Bundle arguments = getArguments();
            this.f11392d = new UInAppMessage(new JSONObject(arguments.getString(Constant.KEY_MSG)));
            this.f11393e = arguments.getString(Constants.ScionAnalytics.PARAM_LABEL);
            byte[] byteArray = arguments.getByteArray("bitmapByte");
            if (byteArray != null) {
                this.f11394f = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            }
            this.f11400l = InAppMessageManager.getInstance(this.f11391c).getInAppHandler();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        int i10 = this.f11392d.msg_type;
        if (i10 == 5 || i10 == 6) {
            String a10 = InAppMessageManager.getInstance(this.f11391c).a("KEY_PLAIN_TEXT_SIZE", "");
            String[] split = !TextUtils.isEmpty(a10) ? a10.split(",") : null;
            if (split != null) {
                this.f11405q = split;
            }
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.requestWindowFeature(1);
        return onCreateDialog;
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Rect rect;
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            int height = rect.height() - bo.a(65.0f);
            this.f11397i = height;
            double d10 = height;
            Double.isNaN(d10);
            this.f11396h = (int) (d10 * 1.2d);
            int width = rect.width() - bo.a(70.0f);
            this.f11398j = width;
            this.f11399k = (width / 2) * 3;
        } else {
            rect = null;
        }
        int i10 = this.f11392d.msg_type;
        if (i10 == 2 || i10 == 3) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f11391c);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.setBackgroundColor(Color.parseColor("#33000000"));
            RelativeLayout.LayoutParams layoutParams = getResources().getConfiguration().orientation == 1 ? new RelativeLayout.LayoutParams(-1, -2) : this.f11392d.msg_type == 2 ? new RelativeLayout.LayoutParams(this.f11396h, this.f11397i) : new RelativeLayout.LayoutParams(-2, -1);
            int a10 = bo.a(30.0f);
            int a11 = bo.a(15.0f);
            layoutParams.setMargins(a10, a11, a10, a11);
            layoutParams.addRule(13);
            FrameLayout frameLayout = new FrameLayout(this.f11391c);
            this.f11395g = frameLayout;
            frameLayout.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int a12 = bo.a(12.0f);
            layoutParams2.setMargins(a12, a12, a12, a12);
            ImageView imageView = new ImageView(this.f11391c);
            imageView.setLayoutParams(layoutParams2);
            imageView.setAdjustViewBounds(true);
            imageView.setId(f.a());
            imageView.setImageBitmap(this.f11394f);
            this.f11395g.addView(imageView);
            int a13 = bo.a(24.0f);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(a13, a13, 5);
            br brVar = new br(this.f11391c);
            brVar.setLayoutParams(layoutParams3);
            this.f11395g.addView(brVar);
            relativeLayout.addView(this.f11395g);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UmengCardMessage.a(UmengCardMessage.this);
                    if (TextUtils.equals("none", UmengCardMessage.this.f11392d.action_type)) {
                        return;
                    }
                    UmengCardMessage.this.f11400l.handleInAppMessage(UmengCardMessage.this.f11391c, UmengCardMessage.this.f11392d, 16);
                    UmengCardMessage.this.dismiss();
                }
            });
            brVar.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UmengCardMessage.e(UmengCardMessage.this);
                    UmengCardMessage.this.dismiss();
                }
            });
            return relativeLayout;
        }
        if (i10 == 4) {
            View inflate = layoutInflater.inflate(a.a("umeng_custom_card_message"), viewGroup, false);
            ImageView imageView2 = (ImageView) inflate.findViewById(a.b("umeng_card_message_image"));
            Button button = (Button) inflate.findViewById(a.b("umeng_card_message_ok"));
            Button button2 = (Button) inflate.findViewById(a.b("umeng_card_message_close"));
            imageView2.setImageBitmap(this.f11394f);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UmengCardMessage.a(UmengCardMessage.this);
                    if (TextUtils.equals("none", UmengCardMessage.this.f11392d.action_type)) {
                        return;
                    }
                    UmengCardMessage.this.f11400l.handleInAppMessage(UmengCardMessage.this.f11391c, UmengCardMessage.this.f11392d, 16);
                    UmengCardMessage.this.dismiss();
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UmengCardMessage.f(UmengCardMessage.this);
                    if (TextUtils.equals("none", UmengCardMessage.this.f11392d.action_type)) {
                        return;
                    }
                    UmengCardMessage.this.f11400l.handleInAppMessage(UmengCardMessage.this.f11391c, UmengCardMessage.this.f11392d, 19);
                    UmengCardMessage.this.dismiss();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UmengCardMessage.e(UmengCardMessage.this);
                    UmengCardMessage.this.dismiss();
                }
            });
            return inflate;
        }
        if ((i10 != 5 && i10 != 6) || rect == null) {
            return null;
        }
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f11391c);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout2.setBackgroundColor(Color.parseColor("#33000000"));
        if (getResources().getConfiguration().orientation == 1) {
            int width2 = rect.width() - bo.a(70.0f);
            this.f11398j = width2;
            if (this.f11392d.msg_type == 5) {
                this.f11399k = (width2 / 6) * 5;
            } else {
                this.f11399k = (width2 / 2) * 3;
            }
        } else {
            int height2 = rect.height() - bo.a(65.0f);
            this.f11399k = height2;
            this.f11398j = (height2 / 5) * 6;
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.f11398j, this.f11399k);
        layoutParams4.addRule(13);
        LinearLayout linearLayout = new LinearLayout(this.f11391c);
        linearLayout.setLayoutParams(layoutParams4);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        int a14 = bo.a(20.0f);
        layoutParams5.setMargins(a14, a14, a14, a14);
        TextView textView = new TextView(this.f11391c);
        textView.setLayoutParams(layoutParams5);
        textView.setGravity(17);
        textView.setText(this.f11392d.title);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        textView.setTextSize(Integer.parseInt(this.f11405q[0]));
        textView.setTextColor(Color.parseColor("#000000"));
        linearLayout.addView(textView);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams6.setMargins(a14, 0, a14, 0);
        layoutParams6.weight = 1.0f;
        ScrollView scrollView = new ScrollView(this.f11391c);
        scrollView.setLayoutParams(layoutParams6);
        scrollView.setScrollBarStyle(16777216);
        scrollView.setVerticalScrollBarEnabled(false);
        TextView textView2 = new TextView(this.f11391c);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView2.setText(this.f11392d.content);
        textView2.setTextSize(Integer.parseInt(this.f11405q[1]));
        textView2.setTextColor(Color.parseColor("#000000"));
        scrollView.addView(textView2);
        linearLayout.addView(scrollView);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(bo.a(1.0f), Color.parseColor("#D8D8D8"));
        gradientDrawable.setCornerRadius(20.0f);
        gradientDrawable.setColor(-1);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, bo.a(35.0f));
        layoutParams7.setMargins(a14, bo.a(30.0f), a14, a14);
        TextView textView3 = new TextView(this.f11391c);
        textView3.setLayoutParams(layoutParams7);
        textView3.setGravity(17);
        textView3.setBackgroundColor(Color.parseColor("#FFFFFF"));
        textView3.setText(this.f11392d.button_text);
        textView3.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        textView3.setTextSize(Integer.parseInt(this.f11405q[2]));
        textView3.setTextColor(Color.parseColor("#000000"));
        textView3.setBackgroundDrawable(gradientDrawable);
        linearLayout.addView(textView3);
        relativeLayout2.addView(linearLayout);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UmengCardMessage.a(UmengCardMessage.this);
                UmengCardMessage.this.f11400l.handleInAppMessage(UmengCardMessage.this.f11391c, UmengCardMessage.this.f11392d, 18);
                UmengCardMessage.this.dismiss();
            }
        });
        return relativeLayout2;
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        aj a10 = aj.a(this.f11391c);
        UInAppMessage uInAppMessage = this.f11392d;
        a10.a(uInAppMessage.msg_id, uInAppMessage.msg_type, 0, this.f11402n ? 1 : 0, 0, 0, this.f11404p ? 1 : 0, 0, this.f11403o ? 1 : 0);
        this.f11404p = false;
        this.f11402n = false;
        this.f11403o = false;
        this.f11401m = false;
        IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback = this.f11390a;
        if (iUmengInAppMsgCloseCallback != null) {
            iUmengInAppMsgCloseCallback.onClose();
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onStart() {
        super.onStart();
        if (!this.f11401m) {
            aj a10 = aj.a(this.f11391c);
            UInAppMessage uInAppMessage = this.f11392d;
            a10.a(uInAppMessage.msg_id, uInAppMessage.msg_type, 1, 0, 0, 0, 0, 0, 0);
        }
        this.f11401m = true;
    }
}
