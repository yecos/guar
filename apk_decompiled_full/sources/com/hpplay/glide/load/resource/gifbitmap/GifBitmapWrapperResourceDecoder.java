package com.hpplay.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.engine.Resource;
import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;
import com.hpplay.glide.load.model.ImageVideoWrapper;
import com.hpplay.glide.load.resource.bitmap.BitmapResource;
import com.hpplay.glide.load.resource.bitmap.ImageHeaderParser;
import com.hpplay.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.hpplay.glide.load.resource.gif.GifDrawable;
import com.hpplay.glide.util.ByteArrayPool;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class GifBitmapWrapperResourceDecoder implements ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> {
    private static final ImageTypeParser DEFAULT_PARSER = new ImageTypeParser();
    private static final BufferedStreamFactory DEFAULT_STREAM_FACTORY = new BufferedStreamFactory();
    static final int MARK_LIMIT_BYTES = 2048;
    private final ResourceDecoder<ImageVideoWrapper, Bitmap> bitmapDecoder;
    private final BitmapPool bitmapPool;
    private final ResourceDecoder<InputStream, GifDrawable> gifDecoder;
    private String id;
    private final ImageTypeParser parser;
    private final BufferedStreamFactory streamFactory;

    public static class BufferedStreamFactory {
        public InputStream build(InputStream inputStream, byte[] bArr) {
            return new RecyclableBufferedInputStream(inputStream, bArr);
        }
    }

    public static class ImageTypeParser {
        public ImageHeaderParser.ImageType parse(InputStream inputStream) {
            return new ImageHeaderParser(inputStream).getType();
        }
    }

    public GifBitmapWrapperResourceDecoder(ResourceDecoder<ImageVideoWrapper, Bitmap> resourceDecoder, ResourceDecoder<InputStream, GifDrawable> resourceDecoder2, BitmapPool bitmapPool) {
        this(resourceDecoder, resourceDecoder2, bitmapPool, DEFAULT_PARSER, DEFAULT_STREAM_FACTORY);
    }

    private GifBitmapWrapper decodeBitmapWrapper(ImageVideoWrapper imageVideoWrapper, int i10, int i11) {
        Resource<Bitmap> decode = this.bitmapDecoder.decode(imageVideoWrapper, i10, i11);
        if (decode != null) {
            return new GifBitmapWrapper(decode, null);
        }
        return null;
    }

    private GifBitmapWrapper decodeGifWrapper(InputStream inputStream, int i10, int i11) {
        Resource<GifDrawable> decode = this.gifDecoder.decode(inputStream, i10, i11);
        if (decode == null) {
            return null;
        }
        GifDrawable gifDrawable = decode.get();
        return gifDrawable.getFrameCount() > 1 ? new GifBitmapWrapper(null, decode) : new GifBitmapWrapper(new BitmapResource(gifDrawable.getFirstFrame(), this.bitmapPool), null);
    }

    private GifBitmapWrapper decodeStream(ImageVideoWrapper imageVideoWrapper, int i10, int i11, byte[] bArr) {
        InputStream build = this.streamFactory.build(imageVideoWrapper.getStream(), bArr);
        build.mark(2048);
        ImageHeaderParser.ImageType parse = this.parser.parse(build);
        build.reset();
        GifBitmapWrapper decodeGifWrapper = parse == ImageHeaderParser.ImageType.GIF ? decodeGifWrapper(build, i10, i11) : null;
        return decodeGifWrapper == null ? decodeBitmapWrapper(new ImageVideoWrapper(build, imageVideoWrapper.getFileDescriptor()), i10, i11) : decodeGifWrapper;
    }

    @Override // com.hpplay.glide.load.ResourceDecoder
    public String getId() {
        if (this.id == null) {
            this.id = this.gifDecoder.getId() + this.bitmapDecoder.getId();
        }
        return this.id;
    }

    public GifBitmapWrapperResourceDecoder(ResourceDecoder<ImageVideoWrapper, Bitmap> resourceDecoder, ResourceDecoder<InputStream, GifDrawable> resourceDecoder2, BitmapPool bitmapPool, ImageTypeParser imageTypeParser, BufferedStreamFactory bufferedStreamFactory) {
        this.bitmapDecoder = resourceDecoder;
        this.gifDecoder = resourceDecoder2;
        this.bitmapPool = bitmapPool;
        this.parser = imageTypeParser;
        this.streamFactory = bufferedStreamFactory;
    }

    @Override // com.hpplay.glide.load.ResourceDecoder
    public Resource<GifBitmapWrapper> decode(ImageVideoWrapper imageVideoWrapper, int i10, int i11) {
        ByteArrayPool byteArrayPool = ByteArrayPool.get();
        byte[] bytes = byteArrayPool.getBytes();
        try {
            GifBitmapWrapper decode = decode(imageVideoWrapper, i10, i11, bytes);
            if (decode != null) {
                return new GifBitmapWrapperResource(decode);
            }
            return null;
        } finally {
            byteArrayPool.releaseBytes(bytes);
        }
    }

    private GifBitmapWrapper decode(ImageVideoWrapper imageVideoWrapper, int i10, int i11, byte[] bArr) {
        if (imageVideoWrapper.getStream() != null) {
            return decodeStream(imageVideoWrapper, i10, i11, bArr);
        }
        return decodeBitmapWrapper(imageVideoWrapper, i10, i11);
    }
}
