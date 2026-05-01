package com.google.firebase.inappmessaging.display.internal;

/* loaded from: classes2.dex */
public class InAppMessageLayoutConfig {
    private Boolean animate;
    private Boolean autoDismiss;
    private Boolean backgroundEnabled;
    private Float maxBodyHeightWeight;
    private Float maxBodyWidthWeight;
    private Integer maxDialogHeightPx;
    private Integer maxDialogWidthPx;
    private Float maxImageHeightWeight;
    private Float maxImageWidthWeight;
    private Integer viewWindowGravity;
    private Integer windowFlag;
    private Integer windowHeight;
    private Integer windowWidth;

    public static class Builder {
        private final InAppMessageLayoutConfig config = new InAppMessageLayoutConfig();

        public InAppMessageLayoutConfig build() {
            return this.config;
        }

        public Builder setAnimate(Boolean bool) {
            this.config.animate = bool;
            return this;
        }

        public Builder setAutoDismiss(Boolean bool) {
            this.config.autoDismiss = bool;
            return this;
        }

        public Builder setBackgroundEnabled(Boolean bool) {
            this.config.backgroundEnabled = bool;
            return this;
        }

        public Builder setMaxBodyHeightWeight(Float f10) {
            this.config.maxBodyHeightWeight = f10;
            return this;
        }

        public Builder setMaxBodyWidthWeight(Float f10) {
            this.config.maxBodyWidthWeight = f10;
            return this;
        }

        public Builder setMaxDialogHeightPx(Integer num) {
            this.config.maxDialogHeightPx = num;
            return this;
        }

        public Builder setMaxDialogWidthPx(Integer num) {
            this.config.maxDialogWidthPx = num;
            return this;
        }

        public Builder setMaxImageHeightWeight(Float f10) {
            this.config.maxImageHeightWeight = f10;
            return this;
        }

        public Builder setMaxImageWidthWeight(Float f10) {
            this.config.maxImageWidthWeight = f10;
            return this;
        }

        public Builder setViewWindowGravity(Integer num) {
            this.config.viewWindowGravity = num;
            return this;
        }

        public Builder setWindowFlag(Integer num) {
            this.config.windowFlag = num;
            return this;
        }

        public Builder setWindowHeight(Integer num) {
            this.config.windowHeight = num;
            return this;
        }

        public Builder setWindowWidth(Integer num) {
            this.config.windowWidth = num;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public Boolean animate() {
        return this.animate;
    }

    public Boolean autoDismiss() {
        return this.autoDismiss;
    }

    public Boolean backgroundEnabled() {
        return this.backgroundEnabled;
    }

    public int getMaxBodyHeight() {
        return (int) (maxBodyHeightWeight().floatValue() * maxDialogHeightPx().intValue());
    }

    public int getMaxBodyWidth() {
        return (int) (maxBodyWidthWeight().floatValue() * maxDialogWidthPx().intValue());
    }

    public int getMaxImageHeight() {
        return (int) (maxImageHeightWeight().floatValue() * maxDialogHeightPx().intValue());
    }

    public int getMaxImageWidth() {
        return (int) (maxImageWidthWeight().floatValue() * maxDialogWidthPx().intValue());
    }

    public Float maxBodyHeightWeight() {
        return this.maxBodyHeightWeight;
    }

    public Float maxBodyWidthWeight() {
        return this.maxBodyWidthWeight;
    }

    public Integer maxDialogHeightPx() {
        return this.maxDialogHeightPx;
    }

    public Integer maxDialogWidthPx() {
        return this.maxDialogWidthPx;
    }

    public Float maxImageHeightWeight() {
        return this.maxImageHeightWeight;
    }

    public Float maxImageWidthWeight() {
        return this.maxImageWidthWeight;
    }

    public Integer viewWindowGravity() {
        return this.viewWindowGravity;
    }

    public Integer windowFlag() {
        return this.windowFlag;
    }

    public Integer windowHeight() {
        return this.windowHeight;
    }

    public Integer windowWidth() {
        return this.windowWidth;
    }
}
