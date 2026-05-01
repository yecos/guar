package g;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.o1;
import androidx.appcompat.widget.r2;
import b0.t;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class g extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f13440e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f13441f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f13442a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f13443b;

    /* renamed from: c, reason: collision with root package name */
    public Context f13444c;

    /* renamed from: d, reason: collision with root package name */
    public Object f13445d;

    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        public static final Class[] f13446c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        public Object f13447a;

        /* renamed from: b, reason: collision with root package name */
        public Method f13448b;

        public a(Object obj, String str) {
            this.f13447a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f13448b = cls.getMethod(str, f13446c);
            } catch (Exception e10) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e10);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f13448b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f13448b.invoke(this.f13447a, menuItem)).booleanValue();
                }
                this.f13448b.invoke(this.f13447a, menuItem);
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public class b {
        public b0.b A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;

        /* renamed from: a, reason: collision with root package name */
        public Menu f13449a;

        /* renamed from: b, reason: collision with root package name */
        public int f13450b;

        /* renamed from: c, reason: collision with root package name */
        public int f13451c;

        /* renamed from: d, reason: collision with root package name */
        public int f13452d;

        /* renamed from: e, reason: collision with root package name */
        public int f13453e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f13454f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f13455g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f13456h;

        /* renamed from: i, reason: collision with root package name */
        public int f13457i;

        /* renamed from: j, reason: collision with root package name */
        public int f13458j;

        /* renamed from: k, reason: collision with root package name */
        public CharSequence f13459k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f13460l;

        /* renamed from: m, reason: collision with root package name */
        public int f13461m;

        /* renamed from: n, reason: collision with root package name */
        public char f13462n;

        /* renamed from: o, reason: collision with root package name */
        public int f13463o;

        /* renamed from: p, reason: collision with root package name */
        public char f13464p;

        /* renamed from: q, reason: collision with root package name */
        public int f13465q;

        /* renamed from: r, reason: collision with root package name */
        public int f13466r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f13467s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f13468t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f13469u;

        /* renamed from: v, reason: collision with root package name */
        public int f13470v;

        /* renamed from: w, reason: collision with root package name */
        public int f13471w;

        /* renamed from: x, reason: collision with root package name */
        public String f13472x;

        /* renamed from: y, reason: collision with root package name */
        public String f13473y;

        /* renamed from: z, reason: collision with root package name */
        public String f13474z;

        public b(Menu menu) {
            this.f13449a = menu;
            h();
        }

        public void a() {
            this.f13456h = true;
            i(this.f13449a.add(this.f13450b, this.f13457i, this.f13458j, this.f13459k));
        }

        public SubMenu b() {
            this.f13456h = true;
            SubMenu addSubMenu = this.f13449a.addSubMenu(this.f13450b, this.f13457i, this.f13458j, this.f13459k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public final char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        public boolean d() {
            return this.f13456h;
        }

        public final Object e(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f13444c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot instantiate class: ");
                sb.append(str);
                return null;
            }
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f13444c.obtainStyledAttributes(attributeSet, R$styleable.A);
            this.f13450b = obtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
            this.f13451c = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
            this.f13452d = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
            this.f13453e = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
            this.f13454f = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
            this.f13455g = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            r2 t10 = r2.t(g.this.f13444c, attributeSet, R$styleable.B);
            this.f13457i = t10.n(R$styleable.MenuItem_android_id, 0);
            this.f13458j = (t10.k(R$styleable.MenuItem_android_menuCategory, this.f13451c) & (-65536)) | (t10.k(R$styleable.MenuItem_android_orderInCategory, this.f13452d) & Message.MAXLENGTH);
            this.f13459k = t10.p(R$styleable.MenuItem_android_title);
            this.f13460l = t10.p(R$styleable.MenuItem_android_titleCondensed);
            this.f13461m = t10.n(R$styleable.MenuItem_android_icon, 0);
            this.f13462n = c(t10.o(R$styleable.MenuItem_android_alphabeticShortcut));
            this.f13463o = t10.k(R$styleable.MenuItem_alphabeticModifiers, 4096);
            this.f13464p = c(t10.o(R$styleable.MenuItem_android_numericShortcut));
            this.f13465q = t10.k(R$styleable.MenuItem_numericModifiers, 4096);
            int i10 = R$styleable.MenuItem_android_checkable;
            if (t10.r(i10)) {
                this.f13466r = t10.a(i10, false) ? 1 : 0;
            } else {
                this.f13466r = this.f13453e;
            }
            this.f13467s = t10.a(R$styleable.MenuItem_android_checked, false);
            this.f13468t = t10.a(R$styleable.MenuItem_android_visible, this.f13454f);
            this.f13469u = t10.a(R$styleable.MenuItem_android_enabled, this.f13455g);
            this.f13470v = t10.k(R$styleable.MenuItem_showAsAction, -1);
            this.f13474z = t10.o(R$styleable.MenuItem_android_onClick);
            this.f13471w = t10.n(R$styleable.MenuItem_actionLayout, 0);
            this.f13472x = t10.o(R$styleable.MenuItem_actionViewClass);
            String o10 = t10.o(R$styleable.MenuItem_actionProviderClass);
            this.f13473y = o10;
            if ((o10 != null) && this.f13471w == 0 && this.f13472x == null) {
                this.A = (b0.b) e(o10, g.f13441f, g.this.f13443b);
            } else {
                this.A = null;
            }
            this.B = t10.p(R$styleable.MenuItem_contentDescription);
            this.C = t10.p(R$styleable.MenuItem_tooltipText);
            int i11 = R$styleable.MenuItem_iconTintMode;
            if (t10.r(i11)) {
                this.E = o1.e(t10.k(i11, -1), this.E);
            } else {
                this.E = null;
            }
            int i12 = R$styleable.MenuItem_iconTint;
            if (t10.r(i12)) {
                this.D = t10.c(i12);
            } else {
                this.D = null;
            }
            t10.v();
            this.f13456h = false;
        }

        public void h() {
            this.f13450b = 0;
            this.f13451c = 0;
            this.f13452d = 0;
            this.f13453e = 0;
            this.f13454f = true;
            this.f13455g = true;
        }

        public final void i(MenuItem menuItem) {
            boolean z10 = false;
            menuItem.setChecked(this.f13467s).setVisible(this.f13468t).setEnabled(this.f13469u).setCheckable(this.f13466r >= 1).setTitleCondensed(this.f13460l).setIcon(this.f13461m);
            int i10 = this.f13470v;
            if (i10 >= 0) {
                menuItem.setShowAsAction(i10);
            }
            if (this.f13474z != null) {
                if (g.this.f13444c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f13474z));
            }
            boolean z11 = menuItem instanceof androidx.appcompat.view.menu.i;
            if (z11) {
            }
            if (this.f13466r >= 2) {
                if (z11) {
                    ((androidx.appcompat.view.menu.i) menuItem).t(true);
                } else if (menuItem instanceof androidx.appcompat.view.menu.j) {
                    ((androidx.appcompat.view.menu.j) menuItem).h(true);
                }
            }
            String str = this.f13472x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f13440e, g.this.f13442a));
                z10 = true;
            }
            int i11 = this.f13471w;
            if (i11 > 0 && !z10) {
                menuItem.setActionView(i11);
            }
            b0.b bVar = this.A;
            if (bVar != null) {
                t.b(menuItem, bVar);
            }
            t.d(menuItem, this.B);
            t.h(menuItem, this.C);
            t.c(menuItem, this.f13462n, this.f13463o);
            t.g(menuItem, this.f13464p, this.f13465q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                t.f(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                t.e(menuItem, colorStateList);
            }
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f13440e = clsArr;
        f13441f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f13444c = context;
        Object[] objArr = {context};
        this.f13442a = objArr;
        this.f13443b = objArr;
    }

    public final Object a(Object obj) {
        return obj instanceof Activity ? obj : obj instanceof ContextWrapper ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public Object b() {
        if (this.f13445d == null) {
            this.f13445d = a(this.f13444c);
        }
        return this.f13445d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        if (r15 == 2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        if (r15 == 3) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        if (r15.equals(r8) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        r8 = null;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b9, code lost:
    
        r15 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        if (r15.equals("group") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        r0.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        if (r15.equals(com.hpplay.component.protocol.PlistBuilder.KEY_ITEM) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r0.d() != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        r15 = r0.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
    
        if (r15 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r15.b() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        if (r15.equals("menu") == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        if (r7 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
    
        if (r15.equals("group") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
    
        r0.f(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
    
        if (r15.equals(com.hpplay.component.protocol.PlistBuilder.KEY_ITEM) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a5, code lost:
    
        r0.g(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ad, code lost:
    
        if (r15.equals("menu") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00af, code lost:
    
        c(r13, r14, r0.b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b7, code lost:
    
        r8 = r15;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c5, code lost:
    
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c6, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
    
        r8 = null;
        r6 = false;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        if (r6 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        if (r15 == 1) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) {
        /*
            r12 = this;
            g.g$b r0 = new g.g$b
            r0.<init>(r15)
            int r15 = r13.getEventType()
        L9:
            r1 = 2
            java.lang.String r2 = "menu"
            r3 = 1
            if (r15 != r1) goto L35
            java.lang.String r15 = r13.getName()
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L1e
            int r15 = r13.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Expecting menu, got "
            r14.append(r0)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L35:
            int r15 = r13.next()
            if (r15 != r3) goto L9
        L3b:
            r4 = 0
            r5 = 0
            r8 = r5
            r6 = 0
            r7 = 0
        L40:
            if (r6 != 0) goto Lc6
            if (r15 == r3) goto Lbe
            java.lang.String r9 = "item"
            java.lang.String r10 = "group"
            if (r15 == r1) goto L8e
            r11 = 3
            if (r15 == r11) goto L4f
            goto Lb9
        L4f:
            java.lang.String r15 = r13.getName()
            if (r7 == 0) goto L5e
            boolean r11 = r15.equals(r8)
            if (r11 == 0) goto L5e
            r8 = r5
            r7 = 0
            goto Lb9
        L5e:
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L68
            r0.h()
            goto Lb9
        L68:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto L86
            boolean r15 = r0.d()
            if (r15 != 0) goto Lb9
            b0.b r15 = r0.A
            if (r15 == 0) goto L82
            boolean r15 = r15.b()
            if (r15 == 0) goto L82
            r0.b()
            goto Lb9
        L82:
            r0.a()
            goto Lb9
        L86:
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto Lb9
            r6 = 1
            goto Lb9
        L8e:
            if (r7 == 0) goto L91
            goto Lb9
        L91:
            java.lang.String r15 = r13.getName()
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L9f
            r0.f(r14)
            goto Lb9
        L9f:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto La9
            r0.g(r14)
            goto Lb9
        La9:
            boolean r9 = r15.equals(r2)
            if (r9 == 0) goto Lb7
            android.view.SubMenu r15 = r0.b()
            r12.c(r13, r14, r15)
            goto Lb9
        Lb7:
            r8 = r15
            r7 = 1
        Lb9:
            int r15 = r13.next()
            goto L40
        Lbe:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Unexpected end of document"
            r13.<init>(r14)
            throw r13
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.g.c(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    @Override // android.view.MenuInflater
    public void inflate(int i10, Menu menu) {
        if (!(menu instanceof u.a)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f13444c.getResources().getLayout(i10);
                    c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (XmlPullParserException e10) {
                    throw new InflateException("Error inflating menu XML", e10);
                }
            } catch (IOException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }
}
