package com.mobile.brasiltv.view.login;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.view.DropDownListView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class QuickLoginPanel extends AutoLinearLayout implements ILoginPanel {
    public Map<Integer, View> _$_findViewCache;
    private final Runnable mGoLoginRunnable;
    private IQuickLoginCallback mQuickLoginCallback;
    private boolean quickLoginExpired;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QuickLoginPanel(Context context) {
        this(context, null, 0, 6, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final void initListeners() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        ((TextView) _$_findCachedViewById(R$id.mTvQuickLogin)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuickLoginPanel.initListeners$lambda$0(QuickLoginPanel.this, view);
            }
        });
        ((DropDownListView) _$_findCachedViewById(R$id.mDropView)).setRemoveAccountListener(new QuickLoginPanel$initListeners$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$0(QuickLoginPanel quickLoginPanel, View view) {
        t9.i.g(quickLoginPanel, "this$0");
        IQuickLoginCallback iQuickLoginCallback = quickLoginPanel.mQuickLoginCallback;
        if (iQuickLoginCallback != null) {
            iQuickLoginCallback.onAccountLogin(((DropDownListView) quickLoginPanel._$_findCachedViewById(R$id.mDropView)).getSelectAccount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mGoLoginRunnable$lambda$1(QuickLoginPanel quickLoginPanel) {
        t9.i.g(quickLoginPanel, "this$0");
        ((TextView) quickLoginPanel._$_findCachedViewById(R$id.mTvError)).setVisibility(8);
        if (quickLoginPanel.quickLoginExpired) {
            quickLoginPanel.quickLoginExpired = false;
            IQuickLoginCallback iQuickLoginCallback = quickLoginPanel.mQuickLoginCallback;
            if (iQuickLoginCallback != null) {
                iQuickLoginCallback.onLoginExpired(((DropDownListView) quickLoginPanel._$_findCachedViewById(R$id.mDropView)).getSelectAccount());
            }
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i10) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void attachDataToView(ArrayList<SwitchAccountBean> arrayList) {
        t9.i.g(arrayList, "list");
        ((DropDownListView) _$_findCachedViewById(R$id.mDropView)).attachDataToView(arrayList);
        ((TextView) _$_findCachedViewById(R$id.mTvQuickLogin)).setEnabled(!arrayList.isEmpty());
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void cancelSmsCountDown() {
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void closeLoginPanel() {
        IQuickLoginCallback iQuickLoginCallback = this.mQuickLoginCallback;
        if (iQuickLoginCallback != null) {
            iQuickLoginCallback.onClosePanel();
        }
        ((TextView) _$_findCachedViewById(R$id.mTvError)).removeCallbacks(this.mGoLoginRunnable);
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void fillAccount(String str) {
        t9.i.g(str, "account");
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public String getMobile() {
        return "";
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void hideErrorHint(long j10) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((TextView) _$_findCachedViewById(R$id.mTvError)).removeCallbacks(this.mGoLoginRunnable);
    }

    public final void setAccountLoginCallback(IQuickLoginCallback iQuickLoginCallback) {
        t9.i.g(iQuickLoginCallback, "callback");
        this.mQuickLoginCallback = iQuickLoginCallback;
    }

    public final void showError(String str) {
        t9.i.g(str, "error");
        if (t9.i.b(str, "aaa100012") || t9.i.b(str, "aaa100022") || t9.i.b(str, "aaa100027") || t9.i.b(str, "aaa100028") || t9.i.b(str, "aaa100080") || t9.i.b(str, "aaa100081") || t9.i.b(str, "aaa100091") || t9.i.b(str, "aaa100081") || t9.i.b(str, "aaa100093") || t9.i.b(str, "portal100075")) {
            this.quickLoginExpired = true;
            ((TextView) _$_findCachedViewById(R$id.mTvError)).setText(getContext().getString(R.string.switch_account_expired));
        } else {
            if (t9.i.b(na.d.b(str), "EA2")) {
                this.quickLoginExpired = false;
                com.mobile.brasiltv.utils.x xVar = com.mobile.brasiltv.utils.x.f8754a;
                Context context = getContext();
                t9.i.f(context, com.umeng.analytics.pro.f.X);
                xVar.w(context, new QuickLoginPanel$showError$1(str));
                return;
            }
            this.quickLoginExpired = false;
            ((TextView) _$_findCachedViewById(R$id.mTvError)).setText(getContext().getString(R.string.scan_login_failed));
        }
        int i10 = R$id.mTvError;
        ((TextView) _$_findCachedViewById(i10)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i10)).removeCallbacks(this.mGoLoginRunnable);
        ((TextView) _$_findCachedViewById(i10)).postDelayed(this.mGoLoginRunnable, 3000L);
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void showErrorHint(String str) {
        t9.i.g(str, "errorHint");
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void startSmsCountDown() {
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void updateAreaInfo(String str, String str2) {
        t9.i.g(str, "area");
        t9.i.g(str2, "areaCode");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QuickLoginPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickLoginPanel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.layout_quick_login_panel, (ViewGroup) this, true);
        initListeners();
        this.mGoLoginRunnable = new Runnable() { // from class: com.mobile.brasiltv.view.login.t
            @Override // java.lang.Runnable
            public final void run() {
                QuickLoginPanel.mGoLoginRunnable$lambda$1(QuickLoginPanel.this);
            }
        };
    }

    public /* synthetic */ QuickLoginPanel(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
