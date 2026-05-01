package com.hpplay.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.hpplay.glide.load.Encoder;
import com.hpplay.glide.load.Key;
import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.ResourceEncoder;
import com.hpplay.glide.load.Transformation;
import com.hpplay.glide.load.engine.DiskCacheStrategy;
import com.hpplay.glide.load.resource.bitmap.BitmapTransformation;
import com.hpplay.glide.load.resource.gif.GifDrawable;
import com.hpplay.glide.load.resource.gif.GifDrawableTransformation;
import com.hpplay.glide.load.resource.transcode.ResourceTranscoder;
import com.hpplay.glide.provider.LoadProvider;
import com.hpplay.glide.request.RequestListener;
import com.hpplay.glide.request.animation.DrawableCrossFadeFactory;
import com.hpplay.glide.request.animation.ViewPropertyAnimation;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class GifRequestBuilder<ModelType> extends GenericRequestBuilder<ModelType, InputStream, GifDrawable, GifDrawable> implements BitmapOptions, DrawableOptions {
    public GifRequestBuilder(LoadProvider<ModelType, InputStream, GifDrawable, GifDrawable> loadProvider, Class<GifDrawable> cls, GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder) {
        super(loadProvider, cls, genericRequestBuilder);
    }

    private GifDrawableTransformation[] toGifTransformations(Transformation<Bitmap>[] transformationArr) {
        GifDrawableTransformation[] gifDrawableTransformationArr = new GifDrawableTransformation[transformationArr.length];
        for (int i10 = 0; i10 < transformationArr.length; i10++) {
            gifDrawableTransformationArr[i10] = new GifDrawableTransformation(transformationArr[i10], this.glide.getBitmapPool());
        }
        return gifDrawableTransformationArr;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public void applyCenterCrop() {
        centerCrop();
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public void applyFitCenter() {
        fitCenter();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public /* bridge */ /* synthetic */ GenericRequestBuilder load(Object obj) {
        return load((GifRequestBuilder<ModelType>) obj);
    }

    public GifRequestBuilder<ModelType> transformFrame(BitmapTransformation... bitmapTransformationArr) {
        return transform((Transformation<GifDrawable>[]) toGifTransformations(bitmapTransformationArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> cacheDecoder(ResourceDecoder<File, GifDrawable> resourceDecoder) {
        super.cacheDecoder((ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.hpplay.glide.BitmapOptions
    public GifRequestBuilder<ModelType> centerCrop() {
        return transformFrame(this.glide.getBitmapCenterCrop());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> decoder(ResourceDecoder<InputStream, GifDrawable> resourceDecoder) {
        super.decoder((ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> dontAnimate() {
        super.dontAnimate();
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> dontTransform() {
        super.dontTransform();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> encoder(ResourceEncoder<GifDrawable> resourceEncoder) {
        super.encoder((ResourceEncoder) resourceEncoder);
        return this;
    }

    @Override // com.hpplay.glide.BitmapOptions
    public GifRequestBuilder<ModelType> fitCenter() {
        return transformFrame(this.glide.getBitmapFitCenter());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> listener(RequestListener<? super ModelType, GifDrawable> requestListener) {
        super.listener((RequestListener) requestListener);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> load(ModelType modeltype) {
        super.load((GifRequestBuilder<ModelType>) modeltype);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> override(int i10, int i11) {
        super.override(i10, i11);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> priority(Priority priority) {
        super.priority(priority);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> signature(Key key) {
        super.signature(key);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> sizeMultiplier(float f10) {
        super.sizeMultiplier(f10);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> skipMemoryCache(boolean z10) {
        super.skipMemoryCache(z10);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> sourceEncoder(Encoder<InputStream> encoder) {
        super.sourceEncoder((Encoder) encoder);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> transcoder(ResourceTranscoder<GifDrawable, GifDrawable> resourceTranscoder) {
        super.transcoder((ResourceTranscoder) resourceTranscoder);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> transform(Transformation<GifDrawable>... transformationArr) {
        super.transform((Transformation[]) transformationArr);
        return this;
    }

    public GifRequestBuilder<ModelType> transformFrame(Transformation<Bitmap>... transformationArr) {
        return transform((Transformation<GifDrawable>[]) toGifTransformations(transformationArr));
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    /* renamed from: clone */
    public GifRequestBuilder<ModelType> mo36clone() {
        return (GifRequestBuilder) super.mo36clone();
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> error(int i10) {
        super.error(i10);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> fallback(Drawable drawable) {
        super.fallback(drawable);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> placeholder(int i10) {
        super.placeholder(i10);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> thumbnail(GenericRequestBuilder<?, ?, ?, GifDrawable> genericRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) genericRequestBuilder);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> animate(int i10) {
        super.animate(i10);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> error(Drawable drawable) {
        super.error(drawable);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> fallback(int i10) {
        super.fallback(i10);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> placeholder(Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }

    public GifRequestBuilder<ModelType> thumbnail(GifRequestBuilder<?> gifRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) gifRequestBuilder);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    @Deprecated
    public GifRequestBuilder<ModelType> animate(Animation animation) {
        super.animate(animation);
        return this;
    }

    @Override // com.hpplay.glide.DrawableOptions
    public GifRequestBuilder<ModelType> crossFade() {
        super.animate(new DrawableCrossFadeFactory());
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> thumbnail(float f10) {
        super.thumbnail(f10);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> animate(ViewPropertyAnimation.Animator animator) {
        super.animate(animator);
        return this;
    }

    @Override // com.hpplay.glide.DrawableOptions
    public GifRequestBuilder<ModelType> crossFade(int i10) {
        super.animate(new DrawableCrossFadeFactory(i10));
        return this;
    }

    @Override // com.hpplay.glide.DrawableOptions
    @Deprecated
    public GifRequestBuilder<ModelType> crossFade(Animation animation, int i10) {
        super.animate(new DrawableCrossFadeFactory(animation, i10));
        return this;
    }

    @Override // com.hpplay.glide.DrawableOptions
    public GifRequestBuilder<ModelType> crossFade(int i10, int i11) {
        super.animate(new DrawableCrossFadeFactory(this.context, i10, i11));
        return this;
    }
}
