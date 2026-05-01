package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class RateLimitProto {

    /* renamed from: com.google.firebase.inappmessaging.internal.RateLimitProto$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class Counter extends GeneratedMessageLite<Counter, Builder> implements CounterOrBuilder {
        private static final Counter DEFAULT_INSTANCE;
        private static volatile Parser<Counter> PARSER = null;
        public static final int START_TIME_EPOCH_FIELD_NUMBER = 2;
        public static final int VALUE_FIELD_NUMBER = 1;
        private long startTimeEpoch_;
        private long value_;

        public static final class Builder extends GeneratedMessageLite.Builder<Counter, Builder> implements CounterOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearStartTimeEpoch() {
                copyOnWrite();
                ((Counter) this.instance).clearStartTimeEpoch();
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((Counter) this.instance).clearValue();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.CounterOrBuilder
            public long getStartTimeEpoch() {
                return ((Counter) this.instance).getStartTimeEpoch();
            }

            @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.CounterOrBuilder
            public long getValue() {
                return ((Counter) this.instance).getValue();
            }

            public Builder setStartTimeEpoch(long j10) {
                copyOnWrite();
                ((Counter) this.instance).setStartTimeEpoch(j10);
                return this;
            }

            public Builder setValue(long j10) {
                copyOnWrite();
                ((Counter) this.instance).setValue(j10);
                return this;
            }

            private Builder() {
                super(Counter.DEFAULT_INSTANCE);
            }
        }

        static {
            Counter counter = new Counter();
            DEFAULT_INSTANCE = counter;
            GeneratedMessageLite.registerDefaultInstance(Counter.class, counter);
        }

        private Counter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartTimeEpoch() {
            this.startTimeEpoch_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.value_ = 0L;
        }

        public static Counter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Counter parseDelimitedFrom(InputStream inputStream) {
            return (Counter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Counter parseFrom(ByteBuffer byteBuffer) {
            return (Counter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Counter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartTimeEpoch(long j10) {
            this.startTimeEpoch_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(long j10) {
            this.value_ = j10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Counter();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0002", new Object[]{"value_", "startTimeEpoch_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Counter> parser = PARSER;
                    if (parser == null) {
                        synchronized (Counter.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.CounterOrBuilder
        public long getStartTimeEpoch() {
            return this.startTimeEpoch_;
        }

        @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.CounterOrBuilder
        public long getValue() {
            return this.value_;
        }

        public static Builder newBuilder(Counter counter) {
            return DEFAULT_INSTANCE.createBuilder(counter);
        }

        public static Counter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Counter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Counter parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Counter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Counter parseFrom(ByteString byteString) {
            return (Counter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Counter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Counter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Counter parseFrom(byte[] bArr) {
            return (Counter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Counter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Counter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Counter parseFrom(InputStream inputStream) {
            return (Counter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Counter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Counter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Counter parseFrom(CodedInputStream codedInputStream) {
            return (Counter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Counter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Counter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface CounterOrBuilder extends MessageLiteOrBuilder {
        long getStartTimeEpoch();

        long getValue();
    }

    public static final class RateLimit extends GeneratedMessageLite<RateLimit, Builder> implements RateLimitOrBuilder {
        private static final RateLimit DEFAULT_INSTANCE;
        public static final int LIMITS_FIELD_NUMBER = 1;
        private static volatile Parser<RateLimit> PARSER;
        private MapFieldLite<String, Counter> limits_ = MapFieldLite.emptyMapField();

        public static final class Builder extends GeneratedMessageLite.Builder<RateLimit, Builder> implements RateLimitOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearLimits() {
                copyOnWrite();
                ((RateLimit) this.instance).getMutableLimitsMap().clear();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
            public boolean containsLimits(String str) {
                str.getClass();
                return ((RateLimit) this.instance).getLimitsMap().containsKey(str);
            }

            @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
            @Deprecated
            public Map<String, Counter> getLimits() {
                return getLimitsMap();
            }

            @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
            public int getLimitsCount() {
                return ((RateLimit) this.instance).getLimitsMap().size();
            }

            @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
            public Map<String, Counter> getLimitsMap() {
                return Collections.unmodifiableMap(((RateLimit) this.instance).getLimitsMap());
            }

            @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
            public Counter getLimitsOrDefault(String str, Counter counter) {
                str.getClass();
                Map<String, Counter> limitsMap = ((RateLimit) this.instance).getLimitsMap();
                return limitsMap.containsKey(str) ? limitsMap.get(str) : counter;
            }

            @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
            public Counter getLimitsOrThrow(String str) {
                str.getClass();
                Map<String, Counter> limitsMap = ((RateLimit) this.instance).getLimitsMap();
                if (limitsMap.containsKey(str)) {
                    return limitsMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            public Builder putAllLimits(Map<String, Counter> map) {
                copyOnWrite();
                ((RateLimit) this.instance).getMutableLimitsMap().putAll(map);
                return this;
            }

            public Builder putLimits(String str, Counter counter) {
                str.getClass();
                counter.getClass();
                copyOnWrite();
                ((RateLimit) this.instance).getMutableLimitsMap().put(str, counter);
                return this;
            }

            public Builder removeLimits(String str) {
                str.getClass();
                copyOnWrite();
                ((RateLimit) this.instance).getMutableLimitsMap().remove(str);
                return this;
            }

            private Builder() {
                super(RateLimit.DEFAULT_INSTANCE);
            }
        }

        public static final class LimitsDefaultEntryHolder {
            static final MapEntryLite<String, Counter> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Counter.getDefaultInstance());

            private LimitsDefaultEntryHolder() {
            }
        }

        static {
            RateLimit rateLimit = new RateLimit();
            DEFAULT_INSTANCE = rateLimit;
            GeneratedMessageLite.registerDefaultInstance(RateLimit.class, rateLimit);
        }

        private RateLimit() {
        }

        public static RateLimit getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Counter> getMutableLimitsMap() {
            return internalGetMutableLimits();
        }

        private MapFieldLite<String, Counter> internalGetLimits() {
            return this.limits_;
        }

        private MapFieldLite<String, Counter> internalGetMutableLimits() {
            if (!this.limits_.isMutable()) {
                this.limits_ = this.limits_.mutableCopy();
            }
            return this.limits_;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static RateLimit parseDelimitedFrom(InputStream inputStream) {
            return (RateLimit) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RateLimit parseFrom(ByteBuffer byteBuffer) {
            return (RateLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<RateLimit> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
        public boolean containsLimits(String str) {
            str.getClass();
            return internalGetLimits().containsKey(str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new RateLimit();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"limits_", LimitsDefaultEntryHolder.defaultEntry});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<RateLimit> parser = PARSER;
                    if (parser == null) {
                        synchronized (RateLimit.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
        @Deprecated
        public Map<String, Counter> getLimits() {
            return getLimitsMap();
        }

        @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
        public int getLimitsCount() {
            return internalGetLimits().size();
        }

        @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
        public Map<String, Counter> getLimitsMap() {
            return Collections.unmodifiableMap(internalGetLimits());
        }

        @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
        public Counter getLimitsOrDefault(String str, Counter counter) {
            str.getClass();
            MapFieldLite<String, Counter> internalGetLimits = internalGetLimits();
            return internalGetLimits.containsKey(str) ? internalGetLimits.get(str) : counter;
        }

        @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
        public Counter getLimitsOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, Counter> internalGetLimits = internalGetLimits();
            if (internalGetLimits.containsKey(str)) {
                return internalGetLimits.get(str);
            }
            throw new IllegalArgumentException();
        }

        public static Builder newBuilder(RateLimit rateLimit) {
            return DEFAULT_INSTANCE.createBuilder(rateLimit);
        }

        public static RateLimit parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RateLimit) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RateLimit parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (RateLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RateLimit parseFrom(ByteString byteString) {
            return (RateLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static RateLimit parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (RateLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RateLimit parseFrom(byte[] bArr) {
            return (RateLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RateLimit parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (RateLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RateLimit parseFrom(InputStream inputStream) {
            return (RateLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RateLimit parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RateLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RateLimit parseFrom(CodedInputStream codedInputStream) {
            return (RateLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RateLimit parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RateLimit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface RateLimitOrBuilder extends MessageLiteOrBuilder {
        boolean containsLimits(String str);

        @Deprecated
        Map<String, Counter> getLimits();

        int getLimitsCount();

        Map<String, Counter> getLimitsMap();

        Counter getLimitsOrDefault(String str, Counter counter);

        Counter getLimitsOrThrow(String str);
    }

    private RateLimitProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
