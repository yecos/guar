package com.hpplay.glide.load.engine;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.glide.load.Encoder;
import com.hpplay.glide.load.Key;
import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.ResourceEncoder;
import com.hpplay.glide.load.Transformation;
import com.hpplay.glide.load.resource.transcode.ResourceTranscoder;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
class EngineKey implements Key {
    private static final String EMPTY_LOG_STRING = "";
    private final ResourceDecoder cacheDecoder;
    private final ResourceDecoder decoder;
    private final ResourceEncoder encoder;
    private int hashCode;
    private final int height;
    private final String id;
    private Key originalKey;
    private final Key signature;
    private final Encoder sourceEncoder;
    private String stringKey;
    private final ResourceTranscoder transcoder;
    private final Transformation transformation;
    private final int width;

    public EngineKey(String str, Key key, int i10, int i11, ResourceDecoder resourceDecoder, ResourceDecoder resourceDecoder2, Transformation transformation, ResourceEncoder resourceEncoder, ResourceTranscoder resourceTranscoder, Encoder encoder) {
        this.id = str;
        this.signature = key;
        this.width = i10;
        this.height = i11;
        this.cacheDecoder = resourceDecoder;
        this.decoder = resourceDecoder2;
        this.transformation = transformation;
        this.encoder = resourceEncoder;
        this.transcoder = resourceTranscoder;
        this.sourceEncoder = encoder;
    }

    @Override // com.hpplay.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EngineKey engineKey = (EngineKey) obj;
        if (!this.id.equals(engineKey.id) || !this.signature.equals(engineKey.signature) || this.height != engineKey.height || this.width != engineKey.width) {
            return false;
        }
        Transformation transformation = this.transformation;
        if ((transformation == null) ^ (engineKey.transformation == null)) {
            return false;
        }
        if (transformation != null && !transformation.getId().equals(engineKey.transformation.getId())) {
            return false;
        }
        ResourceDecoder resourceDecoder = this.decoder;
        if ((resourceDecoder == null) ^ (engineKey.decoder == null)) {
            return false;
        }
        if (resourceDecoder != null && !resourceDecoder.getId().equals(engineKey.decoder.getId())) {
            return false;
        }
        ResourceDecoder resourceDecoder2 = this.cacheDecoder;
        if ((resourceDecoder2 == null) ^ (engineKey.cacheDecoder == null)) {
            return false;
        }
        if (resourceDecoder2 != null && !resourceDecoder2.getId().equals(engineKey.cacheDecoder.getId())) {
            return false;
        }
        ResourceEncoder resourceEncoder = this.encoder;
        if ((resourceEncoder == null) ^ (engineKey.encoder == null)) {
            return false;
        }
        if (resourceEncoder != null && !resourceEncoder.getId().equals(engineKey.encoder.getId())) {
            return false;
        }
        ResourceTranscoder resourceTranscoder = this.transcoder;
        if ((resourceTranscoder == null) ^ (engineKey.transcoder == null)) {
            return false;
        }
        if (resourceTranscoder != null && !resourceTranscoder.getId().equals(engineKey.transcoder.getId())) {
            return false;
        }
        Encoder encoder = this.sourceEncoder;
        if ((encoder == null) ^ (engineKey.sourceEncoder == null)) {
            return false;
        }
        return encoder == null || encoder.getId().equals(engineKey.sourceEncoder.getId());
    }

    public Key getOriginalKey() {
        if (this.originalKey == null) {
            this.originalKey = new OriginalKey(this.id, this.signature);
        }
        return this.originalKey;
    }

    @Override // com.hpplay.glide.load.Key
    public int hashCode() {
        if (this.hashCode == 0) {
            int hashCode = this.id.hashCode();
            this.hashCode = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.signature.hashCode()) * 31) + this.width) * 31) + this.height;
            this.hashCode = hashCode2;
            int i10 = hashCode2 * 31;
            ResourceDecoder resourceDecoder = this.cacheDecoder;
            int hashCode3 = i10 + (resourceDecoder != null ? resourceDecoder.getId().hashCode() : 0);
            this.hashCode = hashCode3;
            int i11 = hashCode3 * 31;
            ResourceDecoder resourceDecoder2 = this.decoder;
            int hashCode4 = i11 + (resourceDecoder2 != null ? resourceDecoder2.getId().hashCode() : 0);
            this.hashCode = hashCode4;
            int i12 = hashCode4 * 31;
            Transformation transformation = this.transformation;
            int hashCode5 = i12 + (transformation != null ? transformation.getId().hashCode() : 0);
            this.hashCode = hashCode5;
            int i13 = hashCode5 * 31;
            ResourceEncoder resourceEncoder = this.encoder;
            int hashCode6 = i13 + (resourceEncoder != null ? resourceEncoder.getId().hashCode() : 0);
            this.hashCode = hashCode6;
            int i14 = hashCode6 * 31;
            ResourceTranscoder resourceTranscoder = this.transcoder;
            int hashCode7 = i14 + (resourceTranscoder != null ? resourceTranscoder.getId().hashCode() : 0);
            this.hashCode = hashCode7;
            int i15 = hashCode7 * 31;
            Encoder encoder = this.sourceEncoder;
            this.hashCode = i15 + (encoder != null ? encoder.getId().hashCode() : 0);
        }
        return this.hashCode;
    }

    public String toString() {
        if (this.stringKey == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("EngineKey{");
            sb.append(this.id);
            sb.append('+');
            sb.append(this.signature);
            sb.append("+[");
            sb.append(this.width);
            sb.append('x');
            sb.append(this.height);
            sb.append("]+");
            sb.append('\'');
            ResourceDecoder resourceDecoder = this.cacheDecoder;
            sb.append(resourceDecoder != null ? resourceDecoder.getId() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            ResourceDecoder resourceDecoder2 = this.decoder;
            sb.append(resourceDecoder2 != null ? resourceDecoder2.getId() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            Transformation transformation = this.transformation;
            sb.append(transformation != null ? transformation.getId() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            ResourceEncoder resourceEncoder = this.encoder;
            sb.append(resourceEncoder != null ? resourceEncoder.getId() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            ResourceTranscoder resourceTranscoder = this.transcoder;
            sb.append(resourceTranscoder != null ? resourceTranscoder.getId() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            Encoder encoder = this.sourceEncoder;
            sb.append(encoder != null ? encoder.getId() : "");
            sb.append('\'');
            sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
            this.stringKey = sb.toString();
        }
        return this.stringKey;
    }

    @Override // com.hpplay.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] array = ByteBuffer.allocate(8).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(messageDigest);
        messageDigest.update(this.id.getBytes("UTF-8"));
        messageDigest.update(array);
        ResourceDecoder resourceDecoder = this.cacheDecoder;
        messageDigest.update((resourceDecoder != null ? resourceDecoder.getId() : "").getBytes("UTF-8"));
        ResourceDecoder resourceDecoder2 = this.decoder;
        messageDigest.update((resourceDecoder2 != null ? resourceDecoder2.getId() : "").getBytes("UTF-8"));
        Transformation transformation = this.transformation;
        messageDigest.update((transformation != null ? transformation.getId() : "").getBytes("UTF-8"));
        ResourceEncoder resourceEncoder = this.encoder;
        messageDigest.update((resourceEncoder != null ? resourceEncoder.getId() : "").getBytes("UTF-8"));
        Encoder encoder = this.sourceEncoder;
        messageDigest.update((encoder != null ? encoder.getId() : "").getBytes("UTF-8"));
    }
}
