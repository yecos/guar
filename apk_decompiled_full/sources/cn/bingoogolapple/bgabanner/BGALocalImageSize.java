package cn.bingoogolapple.bgabanner;

/* loaded from: classes.dex */
public class BGALocalImageSize {
    private int maxHeight;
    private int maxWidth;
    private float minHeight;
    private float minWidth;

    public BGALocalImageSize(int i10, int i11, float f10, float f11) {
        this.maxWidth = i10;
        this.maxHeight = i11;
        this.minWidth = f10;
        this.minHeight = f11;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public float getMinHeight() {
        return this.minHeight;
    }

    public float getMinWidth() {
        return this.minWidth;
    }

    public void setMaxHeight(int i10) {
        this.maxHeight = i10;
    }

    public void setMaxWidth(int i10) {
        this.maxWidth = i10;
    }

    public void setMinHeight(float f10) {
        this.minHeight = f10;
    }

    public void setMinWidth(float f10) {
        this.minWidth = f10;
    }
}
