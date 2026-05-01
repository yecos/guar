package com.mobile.brasiltv.view;

import android.content.Intent;
import android.webkit.JavascriptInterface;
import com.mobile.brasiltv.activity.PlayAty;
import com.mobile.brasiltv.activity.WebViewAty;
import com.mobile.brasiltv.bean.event.CreateOrderEvent;
import com.mobile.brasiltv.mine.activity.AccountBindAty;
import com.msandroid.mobile.R;
import i6.g0;
import w6.i;

/* loaded from: classes3.dex */
public class Controller {
    private WebViewAty mActivity;

    public class ShareBean {
        private String answerUrl;
        private String code;
        private String content;
        private String img;
        private String title;

        public ShareBean() {
        }

        public String getAnswerUrl() {
            return this.answerUrl;
        }

        public String getCode() {
            return this.code;
        }

        public String getContent() {
            return this.content;
        }

        public String getImg() {
            return this.img;
        }

        public String getTitle() {
            return this.title;
        }

        public void setAnswerUrl(String str) {
            this.answerUrl = str;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setImg(String str) {
            this.img = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    public Controller(WebViewAty webViewAty) {
        this.mActivity = webViewAty;
    }

    @JavascriptInterface
    public void createOrder(String str) {
        xa.c.c().j(new CreateOrderEvent(str));
    }

    @JavascriptInterface
    public void dismiss() {
        this.mActivity.w3();
    }

    @JavascriptInterface
    public void enterPlayAty(String str, String str2, String str3) {
        Intent intent = new Intent(this.mActivity, (Class<?>) PlayAty.class);
        g0.a aVar = i6.g0.f14313b0;
        intent.putExtra(aVar.j(), str);
        intent.putExtra(aVar.a(), str2);
        intent.putExtra(aVar.f(), str3);
        this.mActivity.startActivity(intent);
    }

    @JavascriptInterface
    public String getPlatformType() {
        return "android";
    }

    @JavascriptInterface
    public String getVipCode() {
        return "VipCode";
    }

    @JavascriptInterface
    public void postPayInfo(String str) {
    }

    @JavascriptInterface
    public void postWebCashPayInfo(String str) {
    }

    @JavascriptInterface
    public void retrieveCouponSuccess() {
        i.c cVar = w6.i.f19214g;
        cVar.i0(false);
        cVar.r0(0);
        cVar.a(this.mActivity);
    }

    @JavascriptInterface
    public void shareText(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType(com.hpplay.a.a.a.d.MIME_PLAINTEXT);
        intent.putExtra("android.intent.extra.TEXT", str);
        this.mActivity.startActivity(Intent.createChooser(intent, this.mActivity.getResources().getString(R.string.mine_invite_friend)));
    }

    @JavascriptInterface
    public void startBindAty() {
        this.mActivity.startActivity(new Intent(this.mActivity, (Class<?>) AccountBindAty.class));
    }

    @JavascriptInterface
    public void shareText(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType(com.hpplay.a.a.a.d.MIME_PLAINTEXT);
        intent.putExtra("android.intent.extra.TEXT", str);
        this.mActivity.startActivity(Intent.createChooser(intent, str2));
    }
}
