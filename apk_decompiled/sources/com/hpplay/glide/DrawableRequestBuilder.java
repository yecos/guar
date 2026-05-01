package com.hpplay.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.hpplay.glide.load.Encoder;
import com.hpplay.glide.load.Key;
import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.ResourceEncoder;
import com.hpplay.glide.load.Transformation;
import com.hpplay.glide.load.engine.DiskCacheStrategy;
import com.hpplay.glide.load.model.ImageVideoWrapper;
import com.hpplay.glide.load.resource.bitmap.BitmapTransformation;
import com.hpplay.glide.load.resource.drawable.GlideDrawable;
import com.hpplay.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.hpplay.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation;
import com.hpplay.glide.load.resource.transcode.ResourceTranscoder;
import com.hpplay.glide.manager.Lifecycle;
import com.hpplay.glide.manager.RequestTracker;
import com.hpplay.glide.provider.LoadProvider;
import com.hpplay.glide.request.RequestListener;
import com.hpplay.glide.request.animation.DrawableCrossFadeFactory;
import com.hpplay.glide.request.animation.ViewPropertyAnimation;
import com.hpplay.glide.request.target.Target;
import java.io.File;

/* loaded from: classes2.dex */
public class DrawableRequestBuilder<ModelType> extends GenericRequestBuilder<ModelType, ImageVideoWrapper, GifBitmapWrapper, GlideDrawable> implements BitmapOptions, DrawableOptions {
    public DrawableRequestBuilder(Context context, Class<ModelType> cls, LoadProvider<ModelType, ImageVideoWrapper, GifBitmapWrapper, GlideDrawable> loadProvider, Glide glide, RequestTracker requestTracker, Lifecycle lifecycle) {
        super(context, cls, loadProvider, GlideDrawable.class, glide, requestTracker, lifecycle);
        crossFade();
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public void applyCenterCrop() {
        centerCrop();
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public void applyFitCenter() {
        fitCenter();
    }

    public DrawableRequestBuilder<ModelType> bitmapTransform(Transformation<Bitmap>... transformationArr) {
        GifBitmapWrapperTransformation[] gifBitmapWrapperTransformationArr = new GifBitmapWrapperTransformation[transformationArr.length];
        for (int i10 = 0; i10 < transformationArr.length; i10++) {
            gifBitmapWrapperTransformationArr[i10] = new GifBitmapWrapperTransformation(this.glide.getBitmapPool(), transformationArr[i10]);
        }
        return transform((Transformation<GifBitmapWrapper>[]) gifBitmapWrapperTransformationArr);
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public Target<GlideDrawable> into(ImageView imageView) {
        return super.into(imageView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public /* bridge */ /* synthetic */ GenericRequestBuilder load(Object obj) {
        return load((DrawableRequestBuilder<ModelType>) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> cacheDecoder(ResourceDecoder<File, GifBitmapWrapper> resourceDecoder) {
        super.cacheDecoder((ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.hpplay.glide.BitmapOptions
    public DrawableRequestBuilder<ModelType> centerCrop() {
        return transform(this.glide.getDrawableCenterCrop());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> decoder(ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> resourceDecoder) {
        super.decoder((ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> dontAnimate() {
        super.dontAnimate();
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> dontTransform() {
        super.dontTransform();
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> encoder(ResourceEncoder<GifBitmapWrapper> resourceEncoder) {
        super.encoder((ResourceEncoder) resourceEncoder);
        return this;
    }

    @Override // com.hpplay.glide.BitmapOptions
    public DrawableRequestBuilder<ModelType> fitCenter() {
        return transform(this.glide.getDrawableFitCenter());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> listener(RequestListener<? super ModelType, GlideDrawable> requestListener) {
        super.listener((RequestListener) requestListener);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> load(ModelType modeltype) {
        super.load((DrawableRequestBuilder<ModelType>) modeltype);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> override(int i10, int i11) {
        super.override(i10, i11);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> priority(Priority priority) {
        super.priority(priority);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> signature(Key key) {
        super.signature(key);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> sizeMultiplier(float f10) {
        super.sizeMultiplier(f10);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> skipMemoryCache(boolean z10) {
        super.skipMemoryCache(z10);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> sourceEncoder(Encoder<ImageVideoWrapper> encoder) {
        super.sourceEncoder((Encoder) encoder);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> transcoder(ResourceTranscoder<GifBitmapWrapper, GlideDrawable> resourceTranscoder) {
        super.transcoder((ResourceTranscoder) resourceTranscoder);
        return this;
    }

    public DrawableRequestBuilder<ModelType> transform(BitmapTransformation... bitmapTransformationArr) {
        return bitmapTransform(bitmapTransformationArr);
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    /* renamed from: clone */
    public DrawableRequestBuilder<ModelType> mo36clone() {
        return (DrawableRequestBuilder) super.mo36clone();
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> error(int i10) {
        super.error(i10);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> fallback(Drawable drawable) {
        super.fallback(drawable);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> placeholder(int i10) {
        super.placeholder(i10);
        return this;
    }

    public DrawableRequestBuilder<ModelType> thumbnail(DrawableRequestBuilder<?> drawableRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) drawableRequestBuilder);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> transform(Transformation<GifBitmapWrapper>... transformationArr) {
        super.transform((Transformation[]) transformationArr);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> animate(ViewPropertyAnimation.Animator animator) {
        super.animate(animator);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> error(Drawable drawable) {
        super.error(drawable);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> fallback(int i10) {
        super.fallback(i10);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> placeholder(Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> thumbnail(GenericRequestBuilder<?, ?, ?, GlideDrawable> genericRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) genericRequestBuilder);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> animate(int i10) {
        super.animate(i10);
        return this;
    }

    @Override // com.hpplay.glide.DrawableOptions
    public final DrawableRequestBuilder<ModelType> crossFade() {
        super.animate(new DrawableCrossFadeFactory());
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> thumbnail(float f10) {
        super.thumbnail(f10);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    @Deprecated
    public DrawableRequestBuilder<ModelType> animate(Animation animation) {
        super.animate(animation);
        return this;
    }

    @Override // com.hpplay.glide.DrawableOptions
    public DrawableRequestBuilder<ModelType> crossFade(int i10) {
        super.animate(new DrawableCrossFadeFactory(i10));
        return this;
    }

    @Override // com.hpplay.glide.DrawableOptions
    @Deprecated
    public DrawableRequestBuilder<ModelType> crossFade(Animation animation, int i10) {
        super.animate(new DrawableCrossFadeFactory(animation, i10));
        return this;
    }

    @Override // com.hpplay.glide.DrawableOptions
    public DrawableRequestBuilder<ModelType> crossFade(int i10, int i11) {
        super.animate(new DrawableCrossFadeFactory(this.context, i10, i11));
        return this;
    }
}
