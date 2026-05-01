package com.hpplay.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.ParcelFileDescriptor;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.hpplay.glide.load.DecodeFormat;
import com.hpplay.glide.load.Encoder;
import com.hpplay.glide.load.Key;
import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.ResourceEncoder;
import com.hpplay.glide.load.Transformation;
import com.hpplay.glide.load.engine.DiskCacheStrategy;
import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;
import com.hpplay.glide.load.model.ImageVideoWrapper;
import com.hpplay.glide.load.resource.bitmap.BitmapTransformation;
import com.hpplay.glide.load.resource.bitmap.Downsampler;
import com.hpplay.glide.load.resource.bitmap.FileDescriptorBitmapDecoder;
import com.hpplay.glide.load.resource.bitmap.ImageVideoBitmapDecoder;
import com.hpplay.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.hpplay.glide.load.resource.bitmap.VideoBitmapDecoder;
import com.hpplay.glide.load.resource.file.FileToStreamDecoder;
import com.hpplay.glide.load.resource.transcode.ResourceTranscoder;
import com.hpplay.glide.provider.LoadProvider;
import com.hpplay.glide.request.RequestListener;
import com.hpplay.glide.request.animation.ViewPropertyAnimation;
import com.hpplay.glide.request.target.Target;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class BitmapRequestBuilder<ModelType, TranscodeType> extends GenericRequestBuilder<ModelType, ImageVideoWrapper, Bitmap, TranscodeType> implements BitmapOptions {
    private final BitmapPool bitmapPool;
    private DecodeFormat decodeFormat;
    private Downsampler downsampler;
    private ResourceDecoder<InputStream, Bitmap> imageDecoder;
    private ResourceDecoder<ParcelFileDescriptor, Bitmap> videoDecoder;

    public BitmapRequestBuilder(LoadProvider<ModelType, ImageVideoWrapper, Bitmap, TranscodeType> loadProvider, Class<TranscodeType> cls, GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder) {
        super(loadProvider, cls, genericRequestBuilder);
        this.downsampler = Downsampler.AT_LEAST;
        BitmapPool bitmapPool = genericRequestBuilder.glide.getBitmapPool();
        this.bitmapPool = bitmapPool;
        DecodeFormat decodeFormat = genericRequestBuilder.glide.getDecodeFormat();
        this.decodeFormat = decodeFormat;
        this.imageDecoder = new StreamBitmapDecoder(bitmapPool, decodeFormat);
        this.videoDecoder = new FileDescriptorBitmapDecoder(bitmapPool, this.decodeFormat);
    }

    private BitmapRequestBuilder<ModelType, TranscodeType> downsample(Downsampler downsampler) {
        this.downsampler = downsampler;
        StreamBitmapDecoder streamBitmapDecoder = new StreamBitmapDecoder(downsampler, this.bitmapPool, this.decodeFormat);
        this.imageDecoder = streamBitmapDecoder;
        super.decoder((ResourceDecoder) new ImageVideoBitmapDecoder(streamBitmapDecoder, this.videoDecoder));
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public void applyCenterCrop() {
        centerCrop();
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public void applyFitCenter() {
        fitCenter();
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> approximate() {
        return downsample(Downsampler.AT_LEAST);
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> asIs() {
        return downsample(Downsampler.NONE);
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> atMost() {
        return downsample(Downsampler.AT_MOST);
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> format(DecodeFormat decodeFormat) {
        this.decodeFormat = decodeFormat;
        this.imageDecoder = new StreamBitmapDecoder(this.downsampler, this.bitmapPool, decodeFormat);
        this.videoDecoder = new FileDescriptorBitmapDecoder(new VideoBitmapDecoder(), this.bitmapPool, decodeFormat);
        super.cacheDecoder((ResourceDecoder) new FileToStreamDecoder(new StreamBitmapDecoder(this.downsampler, this.bitmapPool, decodeFormat)));
        super.decoder((ResourceDecoder) new ImageVideoBitmapDecoder(this.imageDecoder, this.videoDecoder));
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> imageDecoder(ResourceDecoder<InputStream, Bitmap> resourceDecoder) {
        this.imageDecoder = resourceDecoder;
        super.decoder((ResourceDecoder) new ImageVideoBitmapDecoder(resourceDecoder, this.videoDecoder));
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public Target<TranscodeType> into(ImageView imageView) {
        return super.into(imageView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public /* bridge */ /* synthetic */ GenericRequestBuilder load(Object obj) {
        return load((BitmapRequestBuilder<ModelType, TranscodeType>) obj);
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> videoDecoder(ResourceDecoder<ParcelFileDescriptor, Bitmap> resourceDecoder) {
        this.videoDecoder = resourceDecoder;
        super.decoder((ResourceDecoder) new ImageVideoBitmapDecoder(this.imageDecoder, resourceDecoder));
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> cacheDecoder(ResourceDecoder<File, Bitmap> resourceDecoder) {
        super.cacheDecoder((ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.hpplay.glide.BitmapOptions
    public BitmapRequestBuilder<ModelType, TranscodeType> centerCrop() {
        return transform(this.glide.getBitmapCenterCrop());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> decoder(ResourceDecoder<ImageVideoWrapper, Bitmap> resourceDecoder) {
        super.decoder((ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> dontAnimate() {
        super.dontAnimate();
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> dontTransform() {
        super.dontTransform();
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> encoder(ResourceEncoder<Bitmap> resourceEncoder) {
        super.encoder((ResourceEncoder) resourceEncoder);
        return this;
    }

    @Override // com.hpplay.glide.BitmapOptions
    public BitmapRequestBuilder<ModelType, TranscodeType> fitCenter() {
        return transform(this.glide.getBitmapFitCenter());
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> listener(RequestListener<? super ModelType, TranscodeType> requestListener) {
        super.listener((RequestListener) requestListener);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> load(ModelType modeltype) {
        super.load((BitmapRequestBuilder<ModelType, TranscodeType>) modeltype);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> override(int i10, int i11) {
        super.override(i10, i11);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> priority(Priority priority) {
        super.priority(priority);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> signature(Key key) {
        super.signature(key);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> sizeMultiplier(float f10) {
        super.sizeMultiplier(f10);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> skipMemoryCache(boolean z10) {
        super.skipMemoryCache(z10);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> sourceEncoder(Encoder<ImageVideoWrapper> encoder) {
        super.sourceEncoder((Encoder) encoder);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> transcoder(ResourceTranscoder<Bitmap, TranscodeType> resourceTranscoder) {
        super.transcoder((ResourceTranscoder) resourceTranscoder);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> transform(BitmapTransformation... bitmapTransformationArr) {
        super.transform((Transformation[]) bitmapTransformationArr);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    /* renamed from: clone */
    public BitmapRequestBuilder<ModelType, TranscodeType> mo36clone() {
        return (BitmapRequestBuilder) super.mo36clone();
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> error(int i10) {
        super.error(i10);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> fallback(Drawable drawable) {
        super.fallback(drawable);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> placeholder(int i10) {
        super.placeholder(i10);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> thumbnail(float f10) {
        super.thumbnail(f10);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> transform(Transformation<Bitmap>... transformationArr) {
        super.transform((Transformation[]) transformationArr);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> animate(int i10) {
        super.animate(i10);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> error(Drawable drawable) {
        super.error(drawable);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> fallback(int i10) {
        super.fallback(i10);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> placeholder(Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> thumbnail(BitmapRequestBuilder<?, TranscodeType> bitmapRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) bitmapRequestBuilder);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    @Deprecated
    public BitmapRequestBuilder<ModelType, TranscodeType> animate(Animation animation) {
        super.animate(animation);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> thumbnail(GenericRequestBuilder<?, ?, ?, TranscodeType> genericRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) genericRequestBuilder);
        return this;
    }

    @Override // com.hpplay.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> animate(ViewPropertyAnimation.Animator animator) {
        super.animate(animator);
        return this;
    }
}
