package androidx.appcompat.widget;

import android.R;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class l2 extends e0.c implements View.OnClickListener {

    /* renamed from: l, reason: collision with root package name */
    public final SearchManager f1529l;

    /* renamed from: m, reason: collision with root package name */
    public final SearchView f1530m;

    /* renamed from: n, reason: collision with root package name */
    public final SearchableInfo f1531n;

    /* renamed from: o, reason: collision with root package name */
    public final Context f1532o;

    /* renamed from: p, reason: collision with root package name */
    public final WeakHashMap f1533p;

    /* renamed from: q, reason: collision with root package name */
    public final int f1534q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1535r;

    /* renamed from: s, reason: collision with root package name */
    public int f1536s;

    /* renamed from: t, reason: collision with root package name */
    public ColorStateList f1537t;

    /* renamed from: u, reason: collision with root package name */
    public int f1538u;

    /* renamed from: v, reason: collision with root package name */
    public int f1539v;

    /* renamed from: w, reason: collision with root package name */
    public int f1540w;

    /* renamed from: x, reason: collision with root package name */
    public int f1541x;

    /* renamed from: y, reason: collision with root package name */
    public int f1542y;

    /* renamed from: z, reason: collision with root package name */
    public int f1543z;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f1544a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f1545b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f1546c;

        /* renamed from: d, reason: collision with root package name */
        public final ImageView f1547d;

        /* renamed from: e, reason: collision with root package name */
        public final ImageView f1548e;

        public a(View view) {
            this.f1544a = (TextView) view.findViewById(R.id.text1);
            this.f1545b = (TextView) view.findViewById(R.id.text2);
            this.f1546c = (ImageView) view.findViewById(R.id.icon1);
            this.f1547d = (ImageView) view.findViewById(R.id.icon2);
            this.f1548e = (ImageView) view.findViewById(R$id.edit_query);
        }
    }

    public l2(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f1535r = false;
        this.f1536s = 1;
        this.f1538u = -1;
        this.f1539v = -1;
        this.f1540w = -1;
        this.f1541x = -1;
        this.f1542y = -1;
        this.f1543z = -1;
        this.f1529l = (SearchManager) this.f12834d.getSystemService(FirebaseAnalytics.Event.SEARCH);
        this.f1530m = searchView;
        this.f1531n = searchableInfo;
        this.f1534q = searchView.getSuggestionCommitIconResId();
        this.f1532o = context;
        this.f1533p = weakHashMap;
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    public static String w(Cursor cursor, int i10) {
        if (i10 == -1) {
            return null;
        }
        try {
            return cursor.getString(i10);
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e10);
            return null;
        }
    }

    public final void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1533p.put(str, drawable.getConstantState());
        }
    }

    public final void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // e0.a, e0.b.a
    public void a(Cursor cursor) {
        if (this.f1535r) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f1538u = cursor.getColumnIndex("suggest_text_1");
                this.f1539v = cursor.getColumnIndex("suggest_text_2");
                this.f1540w = cursor.getColumnIndex("suggest_text_2_url");
                this.f1541x = cursor.getColumnIndex("suggest_icon_1");
                this.f1542y = cursor.getColumnIndex("suggest_icon_2");
                this.f1543z = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e10);
        }
    }

    @Override // e0.a, e0.b.a
    public CharSequence b(Cursor cursor) {
        String o10;
        String o11;
        if (cursor == null) {
            return null;
        }
        String o12 = o(cursor, "suggest_intent_query");
        if (o12 != null) {
            return o12;
        }
        if (this.f1531n.shouldRewriteQueryFromData() && (o11 = o(cursor, "suggest_intent_data")) != null) {
            return o11;
        }
        if (!this.f1531n.shouldRewriteQueryFromText() || (o10 = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return o10;
    }

    @Override // e0.b.a
    public Cursor c(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f1530m.getVisibility() == 0 && this.f1530m.getWindowVisibility() == 0) {
            try {
                Cursor v10 = v(this.f1531n, charSequence2, 50);
                if (v10 != null) {
                    v10.getCount();
                    return v10;
                }
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // e0.a
    public void e(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i10 = this.f1543z;
        int i11 = i10 != -1 ? cursor.getInt(i10) : 0;
        if (aVar.f1544a != null) {
            z(aVar.f1544a, w(cursor, this.f1538u));
        }
        if (aVar.f1545b != null) {
            String w10 = w(cursor, this.f1540w);
            CharSequence l10 = w10 != null ? l(w10) : w(cursor, this.f1539v);
            if (TextUtils.isEmpty(l10)) {
                TextView textView = aVar.f1544a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f1544a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f1544a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f1544a.setMaxLines(1);
                }
            }
            z(aVar.f1545b, l10);
        }
        ImageView imageView = aVar.f1546c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f1547d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i12 = this.f1536s;
        if (i12 != 2 && (i12 != 1 || (i11 & 1) == 0)) {
            aVar.f1548e.setVisibility(8);
            return;
        }
        aVar.f1548e.setVisibility(0);
        aVar.f1548e.setTag(aVar.f1544a.getText());
        aVar.f1548e.setOnClickListener(this);
    }

    @Override // e0.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            View g10 = g(this.f12834d, this.f12833c, viewGroup);
            if (g10 != null) {
                ((a) g10.getTag()).f1544a.setText(e10.toString());
            }
            return g10;
        }
    }

    @Override // e0.a, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            View h10 = h(this.f12834d, this.f12833c, viewGroup);
            if (h10 != null) {
                ((a) h10.getTag()).f1544a.setText(e10.toString());
            }
            return h10;
        }
    }

    @Override // e0.c, e0.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View h10 = super.h(context, cursor, viewGroup);
        h10.setTag(new a(h10));
        ((ImageView) h10.findViewById(R$id.edit_query)).setImageResource(this.f1534q);
        return h10;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public final Drawable k(String str) {
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f1533p.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    public final CharSequence l(CharSequence charSequence) {
        if (this.f1537t == null) {
            TypedValue typedValue = new TypedValue();
            this.f12834d.getTheme().resolveAttribute(R$attr.textColorSearchUrl, typedValue, true);
            this.f1537t = this.f12834d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1537t, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    public final Drawable m(ComponentName componentName) {
        PackageManager packageManager = this.f12834d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid icon resource ");
            sb.append(iconResource);
            sb.append(" for ");
            sb.append(componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.toString();
            return null;
        }
    }

    public final Drawable n(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (!this.f1533p.containsKey(flattenToShortString)) {
            Drawable m10 = m(componentName);
            this.f1533p.put(flattenToShortString, m10 != null ? m10.getConstantState() : null);
            return m10;
        }
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f1533p.get(flattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f1532o.getResources());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(d());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(d());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1530m.z((CharSequence) tag);
        }
    }

    public final Drawable p(Cursor cursor) {
        Drawable n10 = n(this.f1531n.getSearchActivity());
        return n10 != null ? n10 : this.f12834d.getPackageManager().getDefaultActivityIcon();
    }

    public final Drawable q(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return r(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.f1532o.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(openInputStream, null);
            } finally {
                try {
                    openInputStream.close();
                } catch (IOException e10) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e10);
                }
            }
        } catch (FileNotFoundException e11) {
            StringBuilder sb = new StringBuilder();
            sb.append("Icon not found: ");
            sb.append(uri);
            sb.append(", ");
            sb.append(e11.getMessage());
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Icon not found: ");
        sb2.append(uri);
        sb2.append(", ");
        sb2.append(e11.getMessage());
        return null;
    }

    public Drawable r(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f12834d.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (parseInt != 0) {
                return resourcesForApplication.getDrawable(parseInt);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public final Drawable s(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1532o.getPackageName() + Operator.Operation.DIVISION + parseInt;
            Drawable k10 = k(str2);
            if (k10 != null) {
                return k10;
            }
            Drawable drawable = p.a.getDrawable(this.f1532o, parseInt);
            A(str2, drawable);
            return drawable;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Icon resource not found: ");
            sb.append(str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable k11 = k(str);
            if (k11 != null) {
                return k11;
            }
            Drawable q10 = q(Uri.parse(str));
            A(str, q10);
            return q10;
        }
    }

    public final Drawable t(Cursor cursor) {
        int i10 = this.f1541x;
        if (i10 == -1) {
            return null;
        }
        Drawable s10 = s(cursor.getString(i10));
        return s10 != null ? s10 : p(cursor);
    }

    public final Drawable u(Cursor cursor) {
        int i10 = this.f1542y;
        if (i10 == -1) {
            return null;
        }
        return s(cursor.getString(i10));
    }

    public Cursor v(SearchableInfo searchableInfo, String str, int i10) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i10 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i10));
        }
        return this.f12834d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    public void x(int i10) {
        this.f1536s = i10;
    }

    public final void y(ImageView imageView, Drawable drawable, int i10) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i10);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }
}
