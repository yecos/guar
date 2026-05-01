package com.hpplay.sdk.source.browser.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hpplay.common.log.LeLog;
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
    */
    public View getView(int i10, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        ViewHolder viewHolder2;
        RelativeLayout relativeLayout;
        com.hpplay.sdk.source.browser.a.a aVar;
        com.hpplay.sdk.source.browser.a.a aVar2;
        try {
            if (view != null) {
                viewHolder = (ViewHolder) view.getTag();
                if (viewHolder == null) {
                    viewHolder2 = new ViewHolder(this.f7472b);
                    relativeLayout = viewHolder2.f7475a;
                    relativeLayout.setTag(viewHolder2);
                }
                aVar = this.f7473c.get(i10);
                viewHolder.f7477c.setImageBitmap(com.hpplay.sdk.source.browser.b.c.a(this.f7472b, b.f7587a));
                viewHolder.f7478d.setText(aVar.b());
                if (aVar.e()) {
                    if (com.hpplay.sdk.source.browser.b.c.b(aVar.c() + "")) {
                        viewHolder.f7479e.setImageBitmap(com.hpplay.sdk.source.browser.b.c.a(this.f7472b, b.f7589c));
                    } else {
                        viewHolder.f7479e.setImageBitmap(null);
                    }
                } else {
                    viewHolder.f7479e.setImageBitmap(com.hpplay.sdk.source.browser.b.c.a(this.f7472b, b.f7588b));
                }
                aVar2 = this.f7474d;
                if (aVar2 == null && aVar2.b().equals(aVar.b())) {
                    viewHolder.f7475a.setBackgroundColor(-15526892);
                } else {
                    viewHolder.f7475a.setBackgroundColor(0);
                }
                return view;
            }
            viewHolder2 = new ViewHolder(this.f7472b);
            relativeLayout = viewHolder2.f7475a;
            relativeLayout.setTag(viewHolder2);
            aVar = this.f7473c.get(i10);
            viewHolder.f7477c.setImageBitmap(com.hpplay.sdk.source.browser.b.c.a(this.f7472b, b.f7587a));
            viewHolder.f7478d.setText(aVar.b());
            if (aVar.e()) {
            }
            aVar2 = this.f7474d;
            if (aVar2 == null) {
            }
            viewHolder.f7475a.setBackgroundColor(0);
            return view;
        } catch (Exception e10) {
            LeLog.w(f7471a, e10);
            return view;
        }
        RelativeLayout relativeLayout2 = relativeLayout;
        viewHolder = viewHolder2;
        view = relativeLayout2;
    }
}
