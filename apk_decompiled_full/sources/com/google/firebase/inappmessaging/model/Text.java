package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.MessagesProto;

/* loaded from: classes2.dex */
public class Text {
    private final String hexColor;
    private final String text;

    public static class Builder {
        private String hexColor;
        private String text;

        public Text build() {
            if (TextUtils.isEmpty(this.hexColor)) {
                throw new IllegalArgumentException("Text model must have a color");
            }
            return new Text(this.text, this.hexColor);
        }

        public Builder setHexColor(String str) {
            this.hexColor = str;
            return this;
        }

        public Builder setText(String str) {
            this.text = str;
            return this;
        }

        public Builder setText(MessagesProto.Text text) {
            setText(text.getText());
            setHexColor(text.getHexColor());
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Text)) {
            return false;
        }
        Text text = (Text) obj;
        if (hashCode() != text.hashCode()) {
            return false;
        }
        String str = this.text;
        return (str != null || text.text == null) && (str == null || str.equals(text.text)) && this.hexColor.equals(text.hexColor);
    }

    public String getHexColor() {
        return this.hexColor;
    }

    public String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        return str != null ? str.hashCode() + this.hexColor.hashCode() : this.hexColor.hashCode();
    }

    private Text(String str, String str2) {
        this.text = str;
        this.hexColor = str2;
    }
}
