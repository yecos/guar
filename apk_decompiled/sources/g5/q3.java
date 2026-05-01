package g5;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class q3 extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public Context f13839a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f13840b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13841c;

    /* renamed from: d, reason: collision with root package name */
    public a f13842d;

    public interface a {
        void a(int i10, SwitchAccountBean switchAccountBean);

        void b(int i10, String str, SwitchAccountBean switchAccountBean);

        void onBack();
    }

    public final class b {

        /* renamed from: a, reason: collision with root package name */
        public View f13843a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f13844b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f13845c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f13846d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f13847e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f13848f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ q3 f13849g;

        public b(q3 q3Var, View view) {
            t9.i.g(view, "itemView");
            this.f13849g = q3Var;
            this.f13843a = view;
            this.f13844b = (ImageView) view.findViewById(R.id.mIvIcon);
            this.f13845c = (TextView) this.f13843a.findViewById(R.id.mTvAccountName);
            this.f13846d = (TextView) this.f13843a.findViewById(R.id.mTvAccountId);
            this.f13847e = (TextView) this.f13843a.findViewById(R.id.mTvNickName);
            this.f13848f = (ImageView) this.f13843a.findViewById(R.id.mIvStatus);
            AutoUtils.auto(this.f13843a);
            this.f13843a.setTag(this);
        }

        public final View a() {
            return this.f13843a;
        }

        public final ImageView b() {
            return this.f13844b;
        }

        public final ImageView c() {
            return this.f13848f;
        }

        public final TextView d() {
            return this.f13846d;
        }

        public final TextView e() {
            return this.f13845c;
        }

        public final TextView f() {
            return this.f13847e;
        }
    }

    public q3(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f13839a = context;
        this.f13840b = new ArrayList();
    }

    public static final void e(SwitchAccountBean switchAccountBean, q3 q3Var, int i10, b bVar, View view) {
        a aVar;
        t9.i.g(switchAccountBean, "$bean");
        t9.i.g(q3Var, "this$0");
        t9.i.g(bVar, "$holder");
        if (!switchAccountBean.isLogged() && q3Var.f13841c) {
            a aVar2 = q3Var.f13842d;
            if (aVar2 != null) {
                aVar2.b(i10, bVar.e().getText().toString(), switchAccountBean);
                return;
            }
            return;
        }
        if (!switchAccountBean.isLogged() || q3Var.f13841c || (aVar = q3Var.f13842d) == null) {
            return;
        }
        aVar.onBack();
    }

    public static final void f(SwitchAccountBean switchAccountBean, q3 q3Var, int i10, View view) {
        a aVar;
        t9.i.g(switchAccountBean, "$bean");
        t9.i.g(q3Var, "this$0");
        if (!switchAccountBean.isLogged() || q3Var.f13841c) {
            if (q3Var.f13841c || (aVar = q3Var.f13842d) == null) {
                return;
            }
            aVar.a(i10, switchAccountBean);
            return;
        }
        a aVar2 = q3Var.f13842d;
        if (aVar2 != null) {
            aVar2.onBack();
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public SwitchAccountBean getItem(int i10) {
        Object obj = this.f13840b.get(i10);
        t9.i.f(obj, "mList[position]");
        return (SwitchAccountBean) obj;
    }

    public final ArrayList d() {
        return this.f13840b;
    }

    public final boolean g() {
        return this.f13841c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f13840b.size() >= 5) {
            return 5;
        }
        return this.f13840b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0195, code lost:
    
        if (r1.equals(com.titans.entity.CdnType.DIGITAL_TYPE_PEERSTAR) == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01d5, code lost:
    
        r13.b().setImageResource(com.msandroid.mobile.R.mipmap.ic_account_type_id);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x019c, code lost:
    
        if (r1.equals(com.titans.entity.CdnType.DIGITAL_TYPE_PCDN) == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01ad, code lost:
    
        r13.b().setImageResource(com.msandroid.mobile.R.mipmap.ic_account_type_phone);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01a3, code lost:
    
        if (r1.equals("4") == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01aa, code lost:
    
        if (r1.equals("3") == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01d2, code lost:
    
        if (r1.equals("1") == false) goto L78;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getView(final int r11, android.view.View r12, android.view.ViewGroup r13) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.q3.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final void h(a aVar) {
        this.f13842d = aVar;
    }

    public final void i(ArrayList arrayList) {
        t9.i.g(arrayList, "value");
        this.f13840b.clear();
        this.f13840b.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final void j(boolean z10) {
        this.f13841c = z10;
    }
}
