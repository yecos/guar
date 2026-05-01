package com.hpplay.sdk.source.browser.view;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class DeviceAdapter extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7471a = "DeviceAdapter";

    /* renamed from: b, reason: collision with root package name */
    private Context f7472b;

    /* renamed from: c, reason: collision with root package name */
    private List<com.hpplay.sdk.source.browser.a.a> f7473c;

    /* renamed from: d, reason: collision with root package name */
    private com.hpplay.sdk.source.browser.a.a f7474d;

    public static class ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public RelativeLayout f7475a;

        /* renamed from: b, reason: collision with root package name */
        public LinearLayout f7476b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f7477c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f7478d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f7479e;

        public ViewHolder(Context context) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            this.f7475a = relativeLayout;
            relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            LinearLayout linearLayout = new LinearLayout(context);
            this.f7476b = linearLayout;
            linearLayout.setOrientation(0);
            this.f7476b.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.f7475a.addView(this.f7476b);
            ImageView imageView = new ImageView(context);
            this.f7477c = imageView;
            imageView.setId(com.hpplay.sdk.source.browser.b.c.a());
            this.f7477c.setPadding(com.hpplay.sdk.source.browser.b.b.a(context, 32.0d), com.hpplay.sdk.source.browser.b.b.a(context, 40.0d), com.hpplay.sdk.source.browser.b.b.a(context, 24.0d), com.hpplay.sdk.source.browser.b.b.a(context, 40.0d));
            this.f7476b.addView(this.f7477c, new LinearLayout.LayoutParams(-2, -2));
            TextView textView = new TextView(context);
            this.f7478d = textView;
            textView.setId(com.hpplay.sdk.source.browser.b.c.a());
            this.f7478d.setPadding(com.hpplay.sdk.source.browser.b.b.a(context, 20.0d), com.hpplay.sdk.source.browser.b.b.a(context, 44.0d), com.hpplay.sdk.source.browser.b.b.a(context, 20.0d), com.hpplay.sdk.source.browser.b.b.a(context, 44.0d));
            this.f7478d.setTextSize(2, 16.0f);
            this.f7478d.setTextColor(-1);
            this.f7478d.setGravity(8388627);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.f7476b.addView(this.f7478d, layoutParams);
            layoutParams.weight = 1.0f;
            this.f7479e = new ImageView(context);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.a(context, 140.0d), com.hpplay.sdk.source.browser.b.b.a(context, 40.0d));
            layoutParams2.setMargins(com.hpplay.sdk.source.browser.b.b.a(context, 32.0d), com.hpplay.sdk.source.browser.b.b.a(context, 44.0d), com.hpplay.sdk.source.browser.b.b.a(context, 32.0d), com.hpplay.sdk.source.browser.b.b.a(context, 44.0d));
            this.f7476b.addView(this.f7479e, layoutParams2);
        }
    }

    public DeviceAdapter(Context context, List<com.hpplay.sdk.source.browser.a.a> list) {
        new ArrayList();
        this.f7472b = context;
        this.f7473c = list;
    }

    public void a(com.hpplay.sdk.source.browser.a.a aVar) {
        this.f7474d = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<com.hpplay.sdk.source.browser.a.a> list = this.f7473c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f7473c.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004b  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getView(int r5, android.view.View r6, android.view.ViewGroup r7) {
        /*
            r4 = this;
            if (r6 != 0) goto L12
            com.hpplay.sdk.source.browser.view.DeviceAdapter$ViewHolder r6 = new com.hpplay.sdk.source.browser.view.DeviceAdapter$ViewHolder
            android.content.Context r7 = r4.f7472b
            r6.<init>(r7)
            android.widget.RelativeLayout r7 = r6.f7475a
            r7.setTag(r6)
        Le:
            r3 = r7
            r7 = r6
            r6 = r3
            goto L27
        L12:
            java.lang.Object r7 = r6.getTag()
            com.hpplay.sdk.source.browser.view.DeviceAdapter$ViewHolder r7 = (com.hpplay.sdk.source.browser.view.DeviceAdapter.ViewHolder) r7
            if (r7 != 0) goto L27
            com.hpplay.sdk.source.browser.view.DeviceAdapter$ViewHolder r6 = new com.hpplay.sdk.source.browser.view.DeviceAdapter$ViewHolder
            android.content.Context r7 = r4.f7472b
            r6.<init>(r7)
            android.widget.RelativeLayout r7 = r6.f7475a
            r7.setTag(r6)
            goto Le
        L27:
            java.util.List<com.hpplay.sdk.source.browser.a.a> r0 = r4.f7473c     // Catch: java.lang.Exception -> Laa
            java.lang.Object r5 = r0.get(r5)     // Catch: java.lang.Exception -> Laa
            com.hpplay.sdk.source.browser.a.a r5 = (com.hpplay.sdk.source.browser.a.a) r5     // Catch: java.lang.Exception -> Laa
            android.widget.ImageView r0 = r7.f7477c
            android.content.Context r1 = r4.f7472b
            java.lang.String r2 = "hpplay/device_icon.png"
            android.graphics.Bitmap r1 = com.hpplay.sdk.source.browser.b.c.a(r1, r2)
            r0.setImageBitmap(r1)
            android.widget.TextView r0 = r7.f7478d
            java.lang.String r1 = r5.b()
            r0.setText(r1)
            boolean r0 = r5.e()
            if (r0 == 0) goto L59
            android.widget.ImageView r0 = r7.f7479e
            android.content.Context r1 = r4.f7472b
            java.lang.String r2 = "hpplay/last_device_icon.png"
            android.graphics.Bitmap r1 = com.hpplay.sdk.source.browser.b.c.a(r1, r2)
            r0.setImageBitmap(r1)
            goto L88
        L59:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = r5.c()
            r0.append(r1)
            java.lang.String r1 = ""
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            boolean r0 = com.hpplay.sdk.source.browser.b.c.b(r0)
            if (r0 == 0) goto L82
            android.widget.ImageView r0 = r7.f7479e
            android.content.Context r1 = r4.f7472b
            java.lang.String r2 = "hpplay/dongle_flag_icon.png"
            android.graphics.Bitmap r1 = com.hpplay.sdk.source.browser.b.c.a(r1, r2)
            r0.setImageBitmap(r1)
            goto L88
        L82:
            android.widget.ImageView r0 = r7.f7479e
            r1 = 0
            r0.setImageBitmap(r1)
        L88:
            com.hpplay.sdk.source.browser.a.a r0 = r4.f7474d
            if (r0 == 0) goto La3
            java.lang.String r0 = r0.b()
            java.lang.String r5 = r5.b()
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto La3
            android.widget.RelativeLayout r5 = r7.f7475a
            r7 = -15526892(0xffffffffff131414, float:-1.9550077E38)
            r5.setBackgroundColor(r7)
            goto La9
        La3:
            android.widget.RelativeLayout r5 = r7.f7475a
            r7 = 0
            r5.setBackgroundColor(r7)
        La9:
            return r6
        Laa:
            r5 = move-exception
            java.lang.String r7 = "DeviceAdapter"
            com.hpplay.common.log.LeLog.w(r7, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.browser.view.DeviceAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
