package com.mobile.brasiltv.view.dialog;

import android.app.Dialog;
import com.mobile.brasiltv.app.App;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public final class DialogManager {
    public static final String DIALOG_AD = "ad";
    public static final String DIALOG_BLACK_LIST = "black_list";
    public static final String DIALOG_EXPIRED = "expired";
    public static final String DIALOG_FORCE_BIND = "force_bind";
    public static final String DIALOG_INAPP_MSG_ACTIVITY_REMIND = "activity_remind";
    public static final String DIALOG_INAPP_MSG_COUPON_BENEFITS = "coupon_benefits";
    public static final String DIALOG_INAPP_MSG_GET_CASHBACK = "cashback";
    public static final String DIALOG_INAPP_MSG_ORDER_PAY_FAILURE = "order_pay_failure";
    public static final String DIALOG_INAPP_MSG_SERVICE_EFFECT = "service_effect";
    public static final String DIALOG_LOGIN_NO_EFFECT = "login_no_effect";
    public static final String DIALOG_NEW_BIND = "new_bind";
    public static final String DIALOG_NOTICE = "notice";
    public static final String DIALOG_NO_KEEP_ACTIVITIES = "no_keep_activities";
    public static final String DIALOG_OPEN_NOTIFY = "open_notify";
    public static final String DIALOG_REMOTE_LOGIN = "remote_login";
    public static final String DIALOG_TRIAL_END = "trial_end";
    public static final String DIALOG_UPDATE = "update";
    public static final String DIALOG_VERSION_FORBIDDEN = "version_forbidden";
    public static final DialogManager INSTANCE = new DialogManager();
    private static HashMap<String, List<Dialog>> dialogMap = new HashMap<>();
    private static boolean isDialogShowing;

    private DialogManager() {
    }

    private final void addDialog(Dialog dialog, String str) {
        List<Dialog> list = dialogMap.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(dialog);
        dialogMap.put(str, list);
    }

    private final boolean isEmptyCacheDialog() {
        if (dialogMap.isEmpty()) {
            return true;
        }
        Set<String> keySet = dialogMap.keySet();
        t9.i.f(keySet, "dialogMap.keys");
        Iterator<T> it = keySet.iterator();
        while (it.hasNext()) {
            if (com.mobile.brasiltv.utils.b0.I(dialogMap.get((String) it.next()))) {
                return false;
            }
        }
        return true;
    }

    private final boolean showByDialogType(String str) {
        List<Dialog> list = dialogMap.get(str);
        if (list == null || list.isEmpty()) {
            return false;
        }
        list.get(0).show();
        list.remove(0);
        if (list.isEmpty()) {
            dialogMap.remove(str);
        }
        return true;
    }

    private final void showByPriorityLevel() {
        if (showByDialogType(DIALOG_NO_KEEP_ACTIVITIES) || showByDialogType(DIALOG_OPEN_NOTIFY) || showByDialogType(DIALOG_VERSION_FORBIDDEN) || showByDialogType(DIALOG_UPDATE) || showByDialogType(DIALOG_FORCE_BIND) || showByDialogType(DIALOG_NOTICE) || showByDialogType(DIALOG_REMOTE_LOGIN) || showByDialogType(DIALOG_LOGIN_NO_EFFECT) || showByDialogType(DIALOG_BLACK_LIST) || showByDialogType(DIALOG_EXPIRED) || showByDialogType(DIALOG_TRIAL_END)) {
            return;
        }
        if (showByDialogType(DIALOG_NEW_BIND)) {
            na.f.i(App.f8263e.a(), "keyShowGiftDaysDialog", false);
            return;
        }
        if (showByDialogType("ad") || showByDialogType(DIALOG_INAPP_MSG_ACTIVITY_REMIND) || showByDialogType(DIALOG_INAPP_MSG_COUPON_BENEFITS) || showByDialogType(DIALOG_INAPP_MSG_GET_CASHBACK) || showByDialogType(DIALOG_INAPP_MSG_SERVICE_EFFECT)) {
            return;
        }
        showByDialogType(DIALOG_INAPP_MSG_ORDER_PAY_FAILURE);
    }

    public final void clear() {
        dialogMap.clear();
    }

    public final void clearSaveDialog(String... strArr) {
        t9.i.g(strArr, "dialogTypes");
        for (String str : strArr) {
            if (com.mobile.brasiltv.utils.b0.I(dialogMap.get(str))) {
                dialogMap.remove(str);
            }
        }
    }

    public final void dismissAndShowNext(Dialog dialog) {
        t9.i.g(dialog, "dialog");
        dialog.dismiss();
        showNext(dialog);
    }

    public final boolean hasDialogSaved(String str) {
        t9.i.g(str, "dialogType");
        return com.mobile.brasiltv.utils.b0.I(dialogMap.get(str));
    }

    public final boolean isDialogShowing() {
        return isDialogShowing;
    }

    public final void reset() {
        isDialogShowing = false;
    }

    public final void showByManager(Dialog dialog, String str) {
        t9.i.g(dialog, "dialog");
        t9.i.g(str, "priorityLevel");
        if (isDialogShowing || !isEmptyCacheDialog()) {
            addDialog(dialog, str);
            return;
        }
        dialog.show();
        isDialogShowing = true;
        if (t9.i.b(str, DIALOG_NEW_BIND)) {
            na.f.i(dialog.getContext(), "keyShowGiftDaysDialog", false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
    
        if (r4.isEmpty() == true) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void showNext(android.app.Dialog r4) {
        /*
            r3 = this;
            java.lang.String r0 = "dialog"
            t9.i.g(r4, r0)
            boolean r4 = r4 instanceof com.mobile.brasiltv.view.BlackListDialog
            r0 = 0
            if (r4 == 0) goto L3c
            java.util.HashMap<java.lang.String, java.util.List<android.app.Dialog>> r4 = com.mobile.brasiltv.view.dialog.DialogManager.dialogMap
            java.lang.String r1 = "black_list"
            java.lang.Object r4 = r4.get(r1)
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = com.mobile.brasiltv.utils.b0.I(r4)
            if (r4 == 0) goto L3c
            java.util.HashMap<java.lang.String, java.util.List<android.app.Dialog>> r4 = com.mobile.brasiltv.view.dialog.DialogManager.dialogMap
            java.lang.Object r4 = r4.get(r1)
            java.util.List r4 = (java.util.List) r4
            if (r4 == 0) goto L2a
            java.lang.Object r2 = r4.remove(r0)
            android.app.Dialog r2 = (android.app.Dialog) r2
        L2a:
            if (r4 == 0) goto L34
            boolean r4 = r4.isEmpty()
            r2 = 1
            if (r4 != r2) goto L34
            goto L35
        L34:
            r2 = 0
        L35:
            if (r2 == 0) goto L3c
            java.util.HashMap<java.lang.String, java.util.List<android.app.Dialog>> r4 = com.mobile.brasiltv.view.dialog.DialogManager.dialogMap
            r4.remove(r1)
        L3c:
            boolean r4 = r3.isEmptyCacheDialog()
            if (r4 == 0) goto L45
            com.mobile.brasiltv.view.dialog.DialogManager.isDialogShowing = r0
            goto L48
        L45:
            r3.showByPriorityLevel()
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.dialog.DialogManager.showNext(android.app.Dialog):void");
    }
}
