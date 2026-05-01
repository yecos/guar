package com.mobile.brasiltv.view;

import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public class MoreTextView extends AutoLinearLayout {
    private static final int LIMIT_LINES = 1000;
    private boolean isFoldUp;
    private String mLessStr;
    private int mMaxLine;
    private String mText;
    private TextView mTvContent;
    private TextView mTvMore;

    public MoreTextView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEllipsis() {
        Layout layout = this.mTvContent.getLayout();
        if (layout == null) {
            return;
        }
        boolean z10 = true;
        int ellipsisCount = layout.getEllipsisCount(this.mTvContent.getLineCount() - 1);
        if (this.mTvContent.getLineCount() <= this.mTvContent.getMaxLines() && ellipsisCount == 0) {
            z10 = false;
        }
        this.isFoldUp = z10;
        this.mTvMore.setVisibility(z10 ? 0 : 8);
        this.mTvMore.setText(R.string.view_more);
        if (z10) {
            String str = this.mText;
            int lineEnd = new StaticLayout(str, 0, str.length(), this.mTvContent.getPaint(), this.mTvContent.getMeasuredWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineEnd(2);
            if (lineEnd > 210) {
                lineEnd = 210;
            }
            subStringWithText(this.mTvContent, this.mText, lineEnd - 6, this.mTvMore.getText().toString());
            setMoreMargin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMoreMargin() {
        if (this.isFoldUp) {
            AutoLinearLayout.LayoutParams layoutParams = new AutoLinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams) layoutParams).topMargin = -AutoUtils.getPercentHeightSize(36);
            ((LinearLayout.LayoutParams) layoutParams).gravity = 5;
            this.mTvMore.setLayoutParams(layoutParams);
            return;
        }
        AutoLinearLayout.LayoutParams layoutParams2 = new AutoLinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) layoutParams2).topMargin = 0;
        ((LinearLayout.LayoutParams) layoutParams2).gravity = 5;
        this.mTvMore.setLayoutParams(layoutParams2);
    }

    private void subStringWithText(TextView textView, String str, int i10, String str2) {
        while (true) {
            String substring = str.substring(0, i10);
            textView.setText(substring + "...." + str2);
            if (textView.getLayout().getEllipsisCount(r1.getLineCount() - 1) <= 0) {
                String str3 = substring + "...";
                this.mLessStr = str3;
                textView.setText(str3);
                return;
            }
            i10 -= 2;
        }
    }

    public void setMaxLine(int i10) {
        this.mMaxLine = i10;
        this.mTvContent.setMaxLines(i10);
    }

    public void setMoreText(String str) {
        this.mText = str;
        if (TextUtils.isEmpty(str)) {
            this.mTvMore.setVisibility(8);
        } else {
            this.mTvContent.setText(str);
            this.mTvContent.post(new Runnable() { // from class: com.mobile.brasiltv.view.MoreTextView.2
                @Override // java.lang.Runnable
                public void run() {
                    MoreTextView.this.setEllipsis();
                }
            });
        }
    }

    public MoreTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MoreTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mMaxLine = 3;
        this.isFoldUp = false;
        this.mText = "";
        this.mLessStr = "";
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.layout_more_text, (ViewGroup) this, true);
        TextView textView = (TextView) findViewById(R.id.tv_content);
        this.mTvContent = textView;
        textView.setMaxLines(this.mMaxLine);
        TextView textView2 = (TextView) findViewById(R.id.tv_more);
        this.mTvMore = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.MoreTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MoreTextView.this.isFoldUp) {
                    MoreTextView.this.mTvMore.setText(R.string.pack_up);
                    MoreTextView.this.mTvContent.setMaxLines(1000);
                    MoreTextView.this.mTvContent.setText(MoreTextView.this.mText);
                } else {
                    MoreTextView.this.mTvMore.setText(R.string.view_more);
                    MoreTextView.this.mTvContent.setMaxLines(MoreTextView.this.mMaxLine);
                    MoreTextView.this.mTvContent.setText(MoreTextView.this.mLessStr);
                }
                MoreTextView.this.isFoldUp = !r2.isFoldUp;
                MoreTextView.this.setMoreMargin();
            }
        });
    }
}
