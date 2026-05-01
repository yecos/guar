package com.hpplay.glide.load.engine;

import com.hpplay.glide.load.Encoder;
import com.hpplay.glide.load.Key;
import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.ResourceEncoder;
import com.hpplay.glide.load.Transformation;
import com.hpplay.glide.load.resource.transcode.ResourceTranscoder;

/* loaded from: classes2.dex */
class EngineKeyFactory {
    public EngineKey buildKey(String str, Key key, int i10, int i11, ResourceDecoder resourceDecoder, ResourceDecoder resourceDecoder2, Transformation transformation, ResourceEncoder resourceEncoder, ResourceTranscoder resourceTranscoder, Encoder encoder) {
        return new EngineKey(str, key, i10, i11, resourceDecoder, resourceDecoder2, transformation, resourceEncoder, resourceTranscoder, encoder);
    }
}
