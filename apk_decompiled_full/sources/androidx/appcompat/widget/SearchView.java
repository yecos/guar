package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import com.google.android.gms.actions.SearchIntents;
import com.google.common.primitives.Ints;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends u1 implements g.c {

    /* renamed from: h0, reason: collision with root package name */
    public static final k f1358h0 = new k();
    public boolean A;
    public CharSequence B;
    public boolean C;
    public boolean D;
    public int E;
    public boolean F;
    public CharSequence G;
    public CharSequence H;
    public boolean I;
    public int J;
    public SearchableInfo K;
    public Bundle L;
    public final Runnable M;
    public Runnable N;
    public final WeakHashMap O;
    public final View.OnClickListener Q;
    public View.OnKeyListener S;
    public final TextView.OnEditorActionListener V;
    public final AdapterView.OnItemClickListener W;

    /* renamed from: a, reason: collision with root package name */
    public final SearchAutoComplete f1359a;

    /* renamed from: b, reason: collision with root package name */
    public final View f1360b;

    /* renamed from: c, reason: collision with root package name */
    public final View f1361c;

    /* renamed from: d, reason: collision with root package name */
    public final View f1362d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f1363e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f1364f;

    /* renamed from: f0, reason: collision with root package name */
    public final AdapterView.OnItemSelectedListener f1365f0;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f1366g;

    /* renamed from: g0, reason: collision with root package name */
    public TextWatcher f1367g0;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f1368h;

    /* renamed from: i, reason: collision with root package name */
    public final View f1369i;

    /* renamed from: j, reason: collision with root package name */
    public p f1370j;

    /* renamed from: k, reason: collision with root package name */
    public Rect f1371k;

    /* renamed from: l, reason: collision with root package name */
    public Rect f1372l;

    /* renamed from: m, reason: collision with root package name */
    public int[] f1373m;

    /* renamed from: n, reason: collision with root package name */
    public int[] f1374n;

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f1375o;

    /* renamed from: p, reason: collision with root package name */
    public final Drawable f1376p;

    /* renamed from: q, reason: collision with root package name */
    public final int f1377q;

    /* renamed from: r, reason: collision with root package name */
    public final int f1378r;

    /* renamed from: s, reason: collision with root package name */
    public final Intent f1379s;

    /* renamed from: t, reason: collision with root package name */
    public final Intent f1380t;

    /* renamed from: u, reason: collision with root package name */
    public final CharSequence f1381u;

    /* renamed from: v, reason: collision with root package name */
    public View.OnFocusChangeListener f1382v;

    /* renamed from: w, reason: collision with root package name */
    public View.OnClickListener f1383w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f1384x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f1385y;

    /* renamed from: z, reason: collision with root package name */
    public e0.a f1386z;

    public static class SearchAutoComplete extends androidx.appcompat.widget.e {

        /* renamed from: d, reason: collision with root package name */
        public int f1387d;

        /* renamed from: e, reason: collision with root package name */
        public SearchView f1388e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f1389f;

        /* renamed from: g, reason: collision with root package name */
        public final Runnable f1390g;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.b();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i10 = configuration.screenWidthDp;
            int i11 = configuration.screenHeightDp;
            if (i10 >= 960 && i11 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i10 < 600) {
                return (i10 < 640 || i11 < 480) ? 160 : 192;
            }
            return 192;
        }

        public boolean a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public void b() {
            if (this.f1389f) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f1389f = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f1387d <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.e, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1389f) {
                removeCallbacks(this.f1390g);
                post(this.f1390g);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z10, int i10, Rect rect) {
            super.onFocusChanged(z10, i10, rect);
            this.f1388e.E();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
            if (i10 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1388e.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i10, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z10) {
            super.onWindowFocusChanged(z10);
            if (z10 && this.f1388e.hasFocus() && getVisibility() == 0) {
                this.f1389f = true;
                if (SearchView.r(getContext())) {
                    SearchView.f1358h0.c(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z10) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z10) {
                this.f1389f = false;
                removeCallbacks(this.f1390g);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f1389f = true;
                    return;
                }
                this.f1389f = false;
                removeCallbacks(this.f1390g);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f1388e = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i10) {
            super.setThreshold(i10);
            this.f1387d = i10;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f1390g = new a();
            this.f1387d = getThreshold();
        }
    }

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            SearchView.this.D(charSequence);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.K();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.a aVar = SearchView.this.f1386z;
            if (aVar instanceof l2) {
                aVar.a(null);
            }
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f1382v;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z10);
            }
        }
    }

    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            SearchView.this.g();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f1363e) {
                searchView.A();
                return;
            }
            if (view == searchView.f1366g) {
                searchView.w();
                return;
            }
            if (view == searchView.f1364f) {
                searchView.B();
            } else if (view == searchView.f1368h) {
                searchView.F();
            } else if (view == searchView.f1359a) {
                searchView.m();
            }
        }
    }

    public class g implements View.OnKeyListener {
        public g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.K == null) {
                return false;
            }
            if (searchView.f1359a.isPopupShowing() && SearchView.this.f1359a.getListSelection() != -1) {
                return SearchView.this.C(view, i10, keyEvent);
            }
            if (SearchView.this.f1359a.a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i10 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.u(0, null, searchView2.f1359a.getText().toString());
            return true;
        }
    }

    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
            SearchView.this.B();
            return true;
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            SearchView.this.x(i10, 0, null);
        }
    }

    public class j implements AdapterView.OnItemSelectedListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i10, long j10) {
            SearchView.this.y(i10);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public Method f1402a;

        /* renamed from: b, reason: collision with root package name */
        public Method f1403b;

        /* renamed from: c, reason: collision with root package name */
        public Method f1404c;

        public k() {
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1402a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1403b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f1404c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public void a(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f1403b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void b(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f1402a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void c(AutoCompleteTextView autoCompleteTextView, boolean z10) {
            Method method = this.f1404c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.valueOf(z10));
                } catch (Exception unused) {
                }
            }
        }
    }

    public interface l {
    }

    public interface m {
    }

    public interface n {
    }

    public static class o extends f0.a {
        public static final Parcelable.Creator<o> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public boolean f1405a;

        public static class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public o createFromParcel(Parcel parcel) {
                return new o(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public o createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new o(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public o[] newArray(int i10) {
                return new o[i10];
            }
        }

        public o(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1405a + "}";
        }

        @Override // f0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Boolean.valueOf(this.f1405a));
        }

        public o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1405a = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    public static class p extends TouchDelegate {

        /* renamed from: a, reason: collision with root package name */
        public final View f1406a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f1407b;

        /* renamed from: c, reason: collision with root package name */
        public final Rect f1408c;

        /* renamed from: d, reason: collision with root package name */
        public final Rect f1409d;

        /* renamed from: e, reason: collision with root package name */
        public final int f1410e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f1411f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1410e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f1407b = new Rect();
            this.f1409d = new Rect();
            this.f1408c = new Rect();
            a(rect, rect2);
            this.f1406a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f1407b.set(rect);
            this.f1409d.set(rect);
            Rect rect3 = this.f1409d;
            int i10 = this.f1410e;
            rect3.inset(-i10, -i10);
            this.f1408c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z10;
            boolean z11;
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z12 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z11 = this.f1411f;
                    if (z11 && !this.f1409d.contains(x10, y10)) {
                        z12 = z11;
                        z10 = false;
                    }
                } else {
                    if (action == 3) {
                        z11 = this.f1411f;
                        this.f1411f = false;
                    }
                    z10 = true;
                    z12 = false;
                }
                z12 = z11;
                z10 = true;
            } else {
                if (this.f1407b.contains(x10, y10)) {
                    this.f1411f = true;
                    z10 = true;
                }
                z10 = true;
                z12 = false;
            }
            if (!z12) {
                return false;
            }
            if (!z10 || this.f1408c.contains(x10, y10)) {
                Rect rect = this.f1408c;
                motionEvent.setLocation(x10 - rect.left, y10 - rect.top);
            } else {
                motionEvent.setLocation(this.f1406a.getWidth() / 2, this.f1406a.getHeight() / 2);
            }
            return this.f1406a.dispatchTouchEvent(motionEvent);
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_width);
    }

    public static boolean r(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private void setQuery(CharSequence charSequence) {
        this.f1359a.setText(charSequence);
        this.f1359a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void A() {
        P(false);
        this.f1359a.requestFocus();
        this.f1359a.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f1383w;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void B() {
        Editable text = this.f1359a.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.K != null) {
            u(0, null, text.toString());
        }
        this.f1359a.setImeVisibility(false);
        l();
    }

    public boolean C(View view, int i10, KeyEvent keyEvent) {
        if (this.K != null && this.f1386z != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i10 == 66 || i10 == 84 || i10 == 61) {
                return x(this.f1359a.getListSelection(), 0, null);
            }
            if (i10 == 21 || i10 == 22) {
                this.f1359a.setSelection(i10 == 21 ? 0 : this.f1359a.length());
                this.f1359a.setListSelection(0);
                this.f1359a.clearListSelection();
                f1358h0.c(this.f1359a, true);
                return true;
            }
            if (i10 == 19) {
                this.f1359a.getListSelection();
                return false;
            }
        }
        return false;
    }

    public void D(CharSequence charSequence) {
        Editable text = this.f1359a.getText();
        this.H = text;
        boolean z10 = !TextUtils.isEmpty(text);
        O(z10);
        Q(!z10);
        J();
        N();
        this.G = charSequence.toString();
    }

    public void E() {
        P(q());
        G();
        if (this.f1359a.hasFocus()) {
            m();
        }
    }

    public void F() {
        SearchableInfo searchableInfo = this.K;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(k(this.f1379s, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(j(this.f1380t, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
        }
    }

    public final void G() {
        post(this.M);
    }

    public final void H(int i10) {
        Editable text = this.f1359a.getText();
        Cursor d10 = this.f1386z.d();
        if (d10 == null) {
            return;
        }
        if (!d10.moveToPosition(i10)) {
            setQuery(text);
            return;
        }
        CharSequence b10 = this.f1386z.b(d10);
        if (b10 != null) {
            setQuery(b10);
        } else {
            setQuery(text);
        }
    }

    public void I(CharSequence charSequence, boolean z10) {
        this.f1359a.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f1359a;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.H = charSequence;
        }
        if (!z10 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        B();
    }

    public final void J() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f1359a.getText());
        if (!z11 && (!this.f1384x || this.I)) {
            z10 = false;
        }
        this.f1366g.setVisibility(z10 ? 0 : 8);
        Drawable drawable = this.f1366g.getDrawable();
        if (drawable != null) {
            drawable.setState(z11 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public void K() {
        int[] iArr = this.f1359a.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f1361c.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1362d.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void L() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1359a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(o(queryHint));
    }

    public final void M() {
        this.f1359a.setThreshold(this.K.getSuggestThreshold());
        this.f1359a.setImeOptions(this.K.getImeOptions());
        int inputType = this.K.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.K.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f1359a.setInputType(inputType);
        e0.a aVar = this.f1386z;
        if (aVar != null) {
            aVar.a(null);
        }
        if (this.K.getSuggestAuthority() != null) {
            l2 l2Var = new l2(getContext(), this, this.K, this.O);
            this.f1386z = l2Var;
            this.f1359a.setAdapter(l2Var);
            ((l2) this.f1386z).x(this.C ? 2 : 1);
        }
    }

    public final void N() {
        this.f1362d.setVisibility((s() && (this.f1364f.getVisibility() == 0 || this.f1368h.getVisibility() == 0)) ? 0 : 8);
    }

    public final void O(boolean z10) {
        this.f1364f.setVisibility((this.A && s() && hasFocus() && (z10 || !this.F)) ? 0 : 8);
    }

    public final void P(boolean z10) {
        this.f1385y = z10;
        int i10 = z10 ? 0 : 8;
        boolean z11 = !TextUtils.isEmpty(this.f1359a.getText());
        this.f1363e.setVisibility(i10);
        O(z11);
        this.f1360b.setVisibility(z10 ? 8 : 0);
        this.f1375o.setVisibility((this.f1375o.getDrawable() == null || this.f1384x) ? 8 : 0);
        J();
        Q(!z11);
        N();
    }

    public final void Q(boolean z10) {
        int i10 = 8;
        if (this.F && !q() && z10) {
            this.f1364f.setVisibility(8);
            i10 = 0;
        }
        this.f1368h.setVisibility(i10);
    }

    @Override // g.c
    public void a() {
        if (this.I) {
            return;
        }
        this.I = true;
        int imeOptions = this.f1359a.getImeOptions();
        this.J = imeOptions;
        this.f1359a.setImeOptions(imeOptions | 33554432);
        this.f1359a.setText("");
        setIconified(false);
    }

    @Override // g.c
    public void c() {
        I("", false);
        clearFocus();
        P(true);
        this.f1359a.setImeOptions(this.J);
        this.I = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.D = true;
        super.clearFocus();
        this.f1359a.clearFocus();
        this.f1359a.setImeVisibility(false);
        this.D = false;
    }

    public void g() {
        if (this.f1369i.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f1361c.getPaddingLeft();
            Rect rect = new Rect();
            boolean b10 = y2.b(this);
            int dimensionPixelSize = this.f1384x ? resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_text_padding_left) : 0;
            this.f1359a.getDropDownBackground().getPadding(rect);
            this.f1359a.setDropDownHorizontalOffset(b10 ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f1359a.setDropDownWidth((((this.f1369i.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    public int getImeOptions() {
        return this.f1359a.getImeOptions();
    }

    public int getInputType() {
        return this.f1359a.getInputType();
    }

    public int getMaxWidth() {
        return this.E;
    }

    public CharSequence getQuery() {
        return this.f1359a.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.B;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.K;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f1381u : getContext().getText(this.K.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.f1378r;
    }

    public int getSuggestionRowLayout() {
        return this.f1377q;
    }

    public e0.a getSuggestionsAdapter() {
        return this.f1386z;
    }

    public final Intent h(String str, Uri uri, String str2, String str3, int i10, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.H);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.L;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i10 != 0) {
            intent.putExtra("action_key", i10);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.K.getSearchActivity());
        return intent;
    }

    public final Intent i(Cursor cursor, int i10, String str) {
        int i11;
        String o10;
        try {
            try {
                String o11 = l2.o(cursor, "suggest_intent_action");
                if (o11 == null) {
                    o11 = this.K.getSuggestIntentAction();
                }
                if (o11 == null) {
                    o11 = "android.intent.action.SEARCH";
                }
                String str2 = o11;
                String o12 = l2.o(cursor, "suggest_intent_data");
                if (o12 == null) {
                    o12 = this.K.getSuggestIntentData();
                }
                if (o12 != null && (o10 = l2.o(cursor, "suggest_intent_data_id")) != null) {
                    o12 = o12 + Operator.Operation.DIVISION + Uri.encode(o10);
                }
                return h(str2, o12 == null ? null : Uri.parse(o12), l2.o(cursor, "suggest_intent_extra_data"), l2.o(cursor, "suggest_intent_query"), i10, str);
            } catch (RuntimeException unused) {
                i11 = -1;
                StringBuilder sb = new StringBuilder();
                sb.append("Search suggestions cursor at row ");
                sb.append(i11);
                sb.append(" returned exception.");
                return null;
            }
        } catch (RuntimeException unused2) {
            i11 = cursor.getPosition();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Search suggestions cursor at row ");
            sb2.append(i11);
            sb2.append(" returned exception.");
            return null;
        }
    }

    public final Intent j(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, Ints.MAX_POWER_OF_TWO);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.L;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final Intent k(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    public final void l() {
        this.f1359a.dismissDropDown();
    }

    public void m() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1359a.refreshAutoCompleteResults();
            return;
        }
        k kVar = f1358h0;
        kVar.b(this.f1359a);
        kVar.a(this.f1359a);
    }

    public final void n(View view, Rect rect) {
        view.getLocationInWindow(this.f1373m);
        getLocationInWindow(this.f1374n);
        int[] iArr = this.f1373m;
        int i10 = iArr[1];
        int[] iArr2 = this.f1374n;
        int i11 = i10 - iArr2[1];
        int i12 = iArr[0] - iArr2[0];
        rect.set(i12, i11, view.getWidth() + i12, view.getHeight() + i11);
    }

    public final CharSequence o(CharSequence charSequence) {
        if (!this.f1384x || this.f1376p == null) {
            return charSequence;
        }
        double textSize = this.f1359a.getTextSize();
        Double.isNaN(textSize);
        int i10 = (int) (textSize * 1.25d);
        this.f1376p.setBounds(0, 0, i10, i10);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f1376p), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.M);
        post(this.N);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.u1, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            n(this.f1359a, this.f1371k);
            Rect rect = this.f1372l;
            Rect rect2 = this.f1371k;
            rect.set(rect2.left, 0, rect2.right, i13 - i11);
            p pVar = this.f1370j;
            if (pVar != null) {
                pVar.a(this.f1372l, this.f1371k);
                return;
            }
            p pVar2 = new p(this.f1372l, this.f1371k, this.f1359a);
            this.f1370j = pVar2;
            setTouchDelegate(pVar2);
        }
    }

    @Override // androidx.appcompat.widget.u1, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        if (q()) {
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE) {
            int i13 = this.E;
            size = i13 > 0 ? Math.min(i13, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.E;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i12 = this.E) > 0) {
            size = Math.min(i12, size);
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(size2, Ints.MAX_POWER_OF_TWO));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.getSuperState());
        P(oVar.f1405a);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.f1405a = q();
        return oVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        G();
    }

    public final boolean p() {
        SearchableInfo searchableInfo = this.K;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = this.K.getVoiceSearchLaunchWebSearch() ? this.f1379s : this.K.getVoiceSearchLaunchRecognizer() ? this.f1380t : null;
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    public boolean q() {
        return this.f1385y;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i10, Rect rect) {
        if (this.D || !isFocusable()) {
            return false;
        }
        if (q()) {
            return super.requestFocus(i10, rect);
        }
        boolean requestFocus = this.f1359a.requestFocus(i10, rect);
        if (requestFocus) {
            P(false);
        }
        return requestFocus;
    }

    public final boolean s() {
        return (this.A || this.F) && !q();
    }

    public void setAppSearchData(Bundle bundle) {
        this.L = bundle;
    }

    public void setIconified(boolean z10) {
        if (z10) {
            w();
        } else {
            A();
        }
    }

    public void setIconifiedByDefault(boolean z10) {
        if (this.f1384x == z10) {
            return;
        }
        this.f1384x = z10;
        P(z10);
        L();
    }

    public void setImeOptions(int i10) {
        this.f1359a.setImeOptions(i10);
    }

    public void setInputType(int i10) {
        this.f1359a.setInputType(i10);
    }

    public void setMaxWidth(int i10) {
        this.E = i10;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f1382v = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f1383w = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.B = charSequence;
        L();
    }

    public void setQueryRefinementEnabled(boolean z10) {
        this.C = z10;
        e0.a aVar = this.f1386z;
        if (aVar instanceof l2) {
            ((l2) aVar).x(z10 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.K = searchableInfo;
        if (searchableInfo != null) {
            M();
            L();
        }
        boolean p10 = p();
        this.F = p10;
        if (p10) {
            this.f1359a.setPrivateImeOptions("nm");
        }
        P(q());
    }

    public void setSubmitButtonEnabled(boolean z10) {
        this.A = z10;
        P(q());
    }

    public void setSuggestionsAdapter(e0.a aVar) {
        this.f1386z = aVar;
        this.f1359a.setAdapter(aVar);
    }

    public final void t(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e10) {
            Log.e("SearchView", "Failed launch activity: " + intent, e10);
        }
    }

    public void u(int i10, String str, String str2) {
        getContext().startActivity(h("android.intent.action.SEARCH", null, null, str2, i10, str));
    }

    public final boolean v(int i10, int i11, String str) {
        Cursor d10 = this.f1386z.d();
        if (d10 == null || !d10.moveToPosition(i10)) {
            return false;
        }
        t(i(d10, i11, str));
        return true;
    }

    public void w() {
        if (!TextUtils.isEmpty(this.f1359a.getText())) {
            this.f1359a.setText("");
            this.f1359a.requestFocus();
            this.f1359a.setImeVisibility(true);
        } else if (this.f1384x) {
            clearFocus();
            P(true);
        }
    }

    public boolean x(int i10, int i11, String str) {
        v(i10, 0, null);
        this.f1359a.setImeVisibility(false);
        l();
        return true;
    }

    public boolean y(int i10) {
        H(i10);
        return true;
    }

    public void z(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1371k = new Rect();
        this.f1372l = new Rect();
        this.f1373m = new int[2];
        this.f1374n = new int[2];
        this.M = new b();
        this.N = new c();
        this.O = new WeakHashMap();
        f fVar = new f();
        this.Q = fVar;
        this.S = new g();
        h hVar = new h();
        this.V = hVar;
        i iVar = new i();
        this.W = iVar;
        j jVar = new j();
        this.f1365f0 = jVar;
        this.f1367g0 = new a();
        r2 u10 = r2.u(context, attributeSet, R$styleable.G, i10, 0);
        LayoutInflater.from(context).inflate(u10.n(R$styleable.SearchView_layout, R$layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R$id.search_src_text);
        this.f1359a = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f1360b = findViewById(R$id.search_edit_frame);
        View findViewById = findViewById(R$id.search_plate);
        this.f1361c = findViewById;
        View findViewById2 = findViewById(R$id.submit_area);
        this.f1362d = findViewById2;
        ImageView imageView = (ImageView) findViewById(R$id.search_button);
        this.f1363e = imageView;
        ImageView imageView2 = (ImageView) findViewById(R$id.search_go_btn);
        this.f1364f = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R$id.search_close_btn);
        this.f1366g = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R$id.search_voice_btn);
        this.f1368h = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R$id.search_mag_icon);
        this.f1375o = imageView5;
        b0.c1.o0(findViewById, u10.g(R$styleable.SearchView_queryBackground));
        b0.c1.o0(findViewById2, u10.g(R$styleable.SearchView_submitBackground));
        int i11 = R$styleable.SearchView_searchIcon;
        imageView.setImageDrawable(u10.g(i11));
        imageView2.setImageDrawable(u10.g(R$styleable.SearchView_goIcon));
        imageView3.setImageDrawable(u10.g(R$styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(u10.g(R$styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(u10.g(i11));
        this.f1376p = u10.g(R$styleable.SearchView_searchHintIcon);
        u2.a(imageView, getResources().getString(R$string.abc_searchview_description_search));
        this.f1377q = u10.n(R$styleable.SearchView_suggestionRowLayout, R$layout.abc_search_dropdown_item_icons_2line);
        this.f1378r = u10.n(R$styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f1367g0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.S);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(u10.a(R$styleable.SearchView_iconifiedByDefault, true));
        int f10 = u10.f(R$styleable.SearchView_android_maxWidth, -1);
        if (f10 != -1) {
            setMaxWidth(f10);
        }
        this.f1381u = u10.p(R$styleable.SearchView_defaultQueryHint);
        this.B = u10.p(R$styleable.SearchView_queryHint);
        int k10 = u10.k(R$styleable.SearchView_android_imeOptions, -1);
        if (k10 != -1) {
            setImeOptions(k10);
        }
        int k11 = u10.k(R$styleable.SearchView_android_inputType, -1);
        if (k11 != -1) {
            setInputType(k11);
        }
        setFocusable(u10.a(R$styleable.SearchView_android_focusable, true));
        u10.v();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f1379s = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f1380t = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f1369i = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new e());
        }
        P(this.f1384x);
        L();
    }
}
