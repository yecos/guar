package com.google.firebase.inappmessaging.model;

import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class ImageOnlyMessage extends InAppMessage {

    @Nullable
    private Action action;
    private ImageData imageData;

    public static class Builder {

        @Nullable
        Action action;

        @Nullable
        ImageData imageData;

        public ImageOnlyMessage build(CampaignMetadata campaignMetadata, @Nullable Map<String, String> map) {
            ImageData imageData = this.imageData;
            if (imageData != null) {
                return new ImageOnlyMessage(campaignMetadata, imageData, this.action, map);
            }
            throw new IllegalArgumentException("ImageOnly model must have image data");
        }

        public Builder setAction(@Nullable Action action) {
            this.action = action;
            return this;
        }

        public Builder setImageData(@Nullable ImageData imageData) {
            this.imageData = imageData;
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
        if (!(obj instanceof ImageOnlyMessage)) {
            return false;
        }
        ImageOnlyMessage imageOnlyMessage = (ImageOnlyMessage) obj;
        if (hashCode() != imageOnlyMessage.hashCode()) {
            return false;
        }
        Action action = this.action;
        return (action != null || imageOnlyMessage.action == null) && (action == null || action.equals(imageOnlyMessage.action)) && this.imageData.equals(imageOnlyMessage.imageData);
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    public Action getAction() {
        return this.action;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public ImageData getImageData() {
        return this.imageData;
    }

    public int hashCode() {
        Action action = this.action;
        return this.imageData.hashCode() + (action != null ? action.hashCode() : 0);
    }

    private ImageOnlyMessage(CampaignMetadata campaignMetadata, ImageData imageData, @Nullable Action action, @Nullable Map<String, String> map) {
        super(campaignMetadata, MessageType.IMAGE_ONLY, map);
        this.imageData = imageData;
        this.action = action;
    }
}
