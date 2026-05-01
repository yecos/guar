package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.firebase.inappmessaging.model.Text;

/* loaded from: classes2.dex */
public class Button {
    private final String buttonHexColor;
    private final Text text;

    public static class Builder {
        private String buttonHexColor;
        private Text text;

        public Button build() {
            if (TextUtils.isEmpty(this.buttonHexColor)) {
                throw new IllegalArgumentException("Button model must have a color");
            }
            Text text = this.text;
            if (text != null) {
                return new Button(text, this.buttonHexColor);
            }
            throw new IllegalArgumentException("Button model must have text");
        }

        public Builder setButtonHexColor(String str) {
            this.buttonHexColor = str;
            return this;
        }

        public Builder setText(Text text) {
            this.text = text;
            return this;
        }

        public Builder setText(MessagesProto.Text text) {
            Text.Builder builder = new Text.Builder();
            builder.setText(text);
            this.text = builder.build();
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
        if (!(obj instanceof Button)) {
            return false;
        }
        Button button = (Button) obj;
        return hashCode() == button.hashCode() && this.text.equals(button.text) && this.buttonHexColor.equals(button.buttonHexColor);
    }

    public String getButtonHexColor() {
        return this.buttonHexColor;
    }

    public Text getText() {
        return this.text;
    }

    public int hashCode() {
        return this.text.hashCode() + this.buttonHexColor.hashCode();
    }

    private Button(Text text, String str) {
        this.text = text;
        this.buttonHexColor = str;
    }
}
