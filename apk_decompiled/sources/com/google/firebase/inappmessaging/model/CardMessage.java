package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public class CardMessage extends InAppMessage {
    private final String backgroundHexColor;
    private final Text body;
    private final ImageData landscapeImageData;
    private final ImageData portraitImageData;
    private final Action primaryAction;
    private final Action secondaryAction;
    private final Text title;

    public static class Builder {
        String backgroundHexColor;
        Text body;
        ImageData landscapeImageData;
        ImageData portraitImageData;
        Action primaryAction;
        Action secondaryAction;
        Text title;

        public CardMessage build(CampaignMetadata campaignMetadata, Map<String, String> map) {
            Action action = this.primaryAction;
            if (action == null) {
                throw new IllegalArgumentException("Card model must have a primary action");
            }
            if (action.getButton() == null) {
                throw new IllegalArgumentException("Card model must have a primary action button");
            }
            Action action2 = this.secondaryAction;
            if (action2 != null && action2.getButton() == null) {
                throw new IllegalArgumentException("Card model secondary action must be null or have a button");
            }
            if (this.title == null) {
                throw new IllegalArgumentException("Card model must have a title");
            }
            if (this.portraitImageData == null && this.landscapeImageData == null) {
                throw new IllegalArgumentException("Card model must have at least one image");
            }
            if (TextUtils.isEmpty(this.backgroundHexColor)) {
                throw new IllegalArgumentException("Card model must have a background color");
            }
            return new CardMessage(campaignMetadata, this.title, this.body, this.portraitImageData, this.landscapeImageData, this.backgroundHexColor, this.primaryAction, this.secondaryAction, map);
        }

        public Builder setBackgroundHexColor(String str) {
            this.backgroundHexColor = str;
            return this;
        }

        public Builder setBody(Text text) {
            this.body = text;
            return this;
        }

        public Builder setLandscapeImageData(ImageData imageData) {
            this.landscapeImageData = imageData;
            return this;
        }

        public Builder setPortraitImageData(ImageData imageData) {
            this.portraitImageData = imageData;
            return this;
        }

        public Builder setPrimaryAction(Action action) {
            this.primaryAction = action;
            return this;
        }

        public Builder setSecondaryAction(Action action) {
            this.secondaryAction = action;
            return this;
        }

        public Builder setTitle(Text text) {
            this.title = text;
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
        if (!(obj instanceof CardMessage)) {
            return false;
        }
        CardMessage cardMessage = (CardMessage) obj;
        if (hashCode() != cardMessage.hashCode()) {
            return false;
        }
        Text text = this.body;
        if ((text == null && cardMessage.body != null) || (text != null && !text.equals(cardMessage.body))) {
            return false;
        }
        Action action = this.secondaryAction;
        if ((action == null && cardMessage.secondaryAction != null) || (action != null && !action.equals(cardMessage.secondaryAction))) {
            return false;
        }
        ImageData imageData = this.portraitImageData;
        if ((imageData == null && cardMessage.portraitImageData != null) || (imageData != null && !imageData.equals(cardMessage.portraitImageData))) {
            return false;
        }
        ImageData imageData2 = this.landscapeImageData;
        return (imageData2 != null || cardMessage.landscapeImageData == null) && (imageData2 == null || imageData2.equals(cardMessage.landscapeImageData)) && this.title.equals(cardMessage.title) && this.primaryAction.equals(cardMessage.primaryAction) && this.backgroundHexColor.equals(cardMessage.backgroundHexColor);
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Deprecated
    public Action getAction() {
        return this.primaryAction;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public String getBackgroundHexColor() {
        return this.backgroundHexColor;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public Text getBody() {
        return this.body;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Deprecated
    public ImageData getImageData() {
        return this.portraitImageData;
    }

    public ImageData getLandscapeImageData() {
        return this.landscapeImageData;
    }

    public ImageData getPortraitImageData() {
        return this.portraitImageData;
    }

    public Action getPrimaryAction() {
        return this.primaryAction;
    }

    public Action getSecondaryAction() {
        return this.secondaryAction;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public Text getTitle() {
        return this.title;
    }

    public int hashCode() {
        Text text = this.body;
        int hashCode = text != null ? text.hashCode() : 0;
        Action action = this.secondaryAction;
        int hashCode2 = action != null ? action.hashCode() : 0;
        ImageData imageData = this.portraitImageData;
        int hashCode3 = imageData != null ? imageData.hashCode() : 0;
        ImageData imageData2 = this.landscapeImageData;
        return this.title.hashCode() + hashCode + this.backgroundHexColor.hashCode() + this.primaryAction.hashCode() + hashCode2 + hashCode3 + (imageData2 != null ? imageData2.hashCode() : 0);
    }

    private CardMessage(CampaignMetadata campaignMetadata, Text text, Text text2, ImageData imageData, ImageData imageData2, String str, Action action, Action action2, Map<String, String> map) {
        super(campaignMetadata, MessageType.CARD, map);
        this.title = text;
        this.body = text2;
        this.portraitImageData = imageData;
        this.landscapeImageData = imageData2;
        this.backgroundHexColor = str;
        this.primaryAction = action;
        this.secondaryAction = action2;
    }
}
