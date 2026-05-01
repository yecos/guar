package com.mobile.brasiltv.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class DropDownPop extends PopupWindow {
    private Context context;
    private final h9.g mAdapter$delegate;
    private ListView mListView;
    private OnItemClickListener mListener;

    public static final class MyAdapter extends BaseAdapter {
        private Context context;
        private ArrayList<SwitchAccountBean> mData;
        private OnItemClickListener mListener;
        private int mSelection;

        public MyAdapter(Context context) {
            t9.i.g(context, com.umeng.analytics.pro.f.X);
            this.context = context;
            this.mData = new ArrayList<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void getView$lambda$0(MyAdapter myAdapter, int i10, TextView textView, SwitchAccountBean switchAccountBean, View view) {
            t9.i.g(myAdapter, "this$0");
            t9.i.g(textView, "$textView");
            t9.i.g(switchAccountBean, "$bean");
            OnItemClickListener onItemClickListener = myAdapter.mListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemRemoveClick(i10, textView.getText().toString(), switchAccountBean);
            }
        }

        public final Context getContext() {
            return this.context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mData.size();
        }

        public final ArrayList<SwitchAccountBean> getData() {
            return this.mData;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            SwitchAccountBean switchAccountBean = this.mData.get(i10);
            t9.i.f(switchAccountBean, "mData[position]");
            return switchAccountBean;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        public final OnItemClickListener getMListener() {
            return this.mListener;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x007d, code lost:
        
            if (r3.equals(com.titans.entity.CdnType.DIGITAL_TYPE_PEERSTAR) == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x00bb, code lost:
        
            r0.setImageResource(com.msandroid.mobile.R.mipmap.ic_spinner_type_id);
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0086, code lost:
        
            if (r3.equals(com.titans.entity.CdnType.DIGITAL_TYPE_PCDN) == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x009b, code lost:
        
            r0.setImageResource(com.msandroid.mobile.R.mipmap.ic_spinner_type_phone);
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x008f, code lost:
        
            if (r3.equals("4") == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0098, code lost:
        
            if (r3.equals("3") == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00b8, code lost:
        
            if (r3.equals("1") == false) goto L33;
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
        public android.view.View getView(final int r8, android.view.View r9, android.view.ViewGroup r10) {
            /*
                Method dump skipped, instructions count: 360
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.DropDownPop.MyAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }

        public final void setContext(Context context) {
            t9.i.g(context, "<set-?>");
            this.context = context;
        }

        public final void setData(ArrayList<SwitchAccountBean> arrayList) {
            t9.i.g(arrayList, "data");
            this.mData.clear();
            this.mData.addAll(arrayList);
            notifyDataSetChanged();
        }

        public final void setMListener(OnItemClickListener onItemClickListener) {
            this.mListener = onItemClickListener;
        }

        public final void setSelection(int i10) {
            this.mSelection = i10;
            notifyDataSetChanged();
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int i10, SwitchAccountBean switchAccountBean);

        void onItemRemoveClick(int i10, String str, SwitchAccountBean switchAccountBean);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DropDownPop(Context context) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.context = context;
        this.mAdapter$delegate = h9.h.b(new DropDownPop$mAdapter$2(this));
        initView();
    }

    private final MyAdapter getMAdapter() {
        return (MyAdapter) this.mAdapter$delegate.getValue();
    }

    private final void initView() {
        setFocusable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setWidth(AutoUtils.getPercentWidthSize(660));
        setHeight(-2);
        ListView listView = new ListView(this.context);
        this.mListView = listView;
        listView.setFocusable(true);
        AutoLinearLayout.LayoutParams layoutParams = new AutoLinearLayout.LayoutParams(-1, -2);
        ListView listView2 = this.mListView;
        ListView listView3 = null;
        if (listView2 == null) {
            t9.i.w("mListView");
            listView2 = null;
        }
        listView2.setLayoutParams(layoutParams);
        ListView listView4 = this.mListView;
        if (listView4 == null) {
            t9.i.w("mListView");
            listView4 = null;
        }
        listView4.setBackgroundResource(R.drawable.bg_associate_email);
        ListView listView5 = this.mListView;
        if (listView5 == null) {
            t9.i.w("mListView");
            listView5 = null;
        }
        listView5.setDividerHeight(0);
        ListView listView6 = this.mListView;
        if (listView6 == null) {
            t9.i.w("mListView");
            listView6 = null;
        }
        setContentView(listView6);
        ListView listView7 = this.mListView;
        if (listView7 == null) {
            t9.i.w("mListView");
            listView7 = null;
        }
        listView7.setAdapter((ListAdapter) getMAdapter());
        ListView listView8 = this.mListView;
        if (listView8 == null) {
            t9.i.w("mListView");
        } else {
            listView3 = listView8;
        }
        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.mobile.brasiltv.view.h
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                DropDownPop.initView$lambda$0(DropDownPop.this, adapterView, view, i10, j10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(DropDownPop dropDownPop, AdapterView adapterView, View view, int i10, long j10) {
        t9.i.g(dropDownPop, "this$0");
        OnItemClickListener onItemClickListener = dropDownPop.mListener;
        if (onItemClickListener != null) {
            SwitchAccountBean switchAccountBean = dropDownPop.getMAdapter().getData().get(i10);
            t9.i.f(switchAccountBean, "mAdapter.getData()[position]");
            onItemClickListener.onItemClick(i10, switchAccountBean);
        }
        dropDownPop.dismiss();
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        t9.i.g(context, "<set-?>");
        this.context = context;
    }

    public final void setData(ArrayList<SwitchAccountBean> arrayList) {
        t9.i.g(arrayList, "data");
        getMAdapter().setData(arrayList);
    }

    public final void setItemClickListener(OnItemClickListener onItemClickListener) {
        t9.i.g(onItemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener = onItemClickListener;
        getMAdapter().setMListener(onItemClickListener);
    }
}
