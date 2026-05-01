package com.google.firebase.encoders;

/* loaded from: classes2.dex */
public interface ObjectEncoderContext {
    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d10);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f10);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i10);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j10);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z10);

    @Deprecated
    ObjectEncoderContext add(String str, double d10);

    @Deprecated
    ObjectEncoderContext add(String str, int i10);

    @Deprecated
    ObjectEncoderContext add(String str, long j10);

    @Deprecated
    ObjectEncoderContext add(String str, Object obj);

    @Deprecated
    ObjectEncoderContext add(String str, boolean z10);

    ObjectEncoderContext inline(Object obj);

    ObjectEncoderContext nested(FieldDescriptor fieldDescriptor);

    ObjectEncoderContext nested(String str);
}
