package com.mobile.brasiltv.view;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.msandroid.mobile.R;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class LoadingDialog extends DialogFragment {
    public static final Companion Companion = new Companion(null);
    private static LoadingDialog loadingDialog;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(t9.g gVar) {
            this();
        }

        public final void hidden() {
            try {
                LoadingDialog loadingDialog = LoadingDialog.loadingDialog;
                if (loadingDialog != null) {
                    loadingDialog.dismiss();
                }
            } catch (Exception unused) {
            }
            LoadingDialog.loadingDialog = null;
        }

        public final void show(FragmentManager fragmentManager) {
            boolean isStateSaved;
            hidden();
            LoadingDialog.loadingDialog = new LoadingDialog();
            if (Build.VERSION.SDK_INT > 26) {
                boolean z10 = false;
                if (fragmentManager != null) {
                    isStateSaved = fragmentManager.isStateSaved();
                    if (isStateSaved) {
                        z10 = true;
                    }
                }
                if (z10) {
                    return;
                }
            }
            LoadingDialog loadingDialog = LoadingDialog.loadingDialog;
            if (loadingDialog != null) {
                loadingDialog.show(fragmentManager, "loading");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(View view) {
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i10) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Window window2;
        t9.i.g(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(1);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window2 = dialog2.getWindow()) != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null && (window = dialog3.getWindow()) != null) {
            window.setFlags(8, 8);
        }
        View inflate = layoutInflater.inflate(R.layout.dialog_loading, viewGroup);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoadingDialog.onCreateView$lambda$1(view);
            }
        });
        return inflate;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.1f;
        window.setAttributes(attributes);
    }
}
