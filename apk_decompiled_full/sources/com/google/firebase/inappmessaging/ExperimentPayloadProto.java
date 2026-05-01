package com.google.firebase.inappmessaging;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class ExperimentPayloadProto {

    /* renamed from: com.google.firebase.inappmessaging.ExperimentPayloadProto$1, reason: invalid class name */
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

    public static final class ExperimentLite extends GeneratedMessageLite<ExperimentLite, Builder> implements ExperimentLiteOrBuilder {
        private static final ExperimentLite DEFAULT_INSTANCE;
        public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
        private static volatile Parser<ExperimentLite> PARSER;
        private String experimentId_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<ExperimentLite, Builder> implements ExperimentLiteOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearExperimentId() {
                copyOnWrite();
                ((ExperimentLite) this.instance).clearExperimentId();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLiteOrBuilder
            public String getExperimentId() {
                return ((ExperimentLite) this.instance).getExperimentId();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLiteOrBuilder
            public ByteString getExperimentIdBytes() {
                return ((ExperimentLite) this.instance).getExperimentIdBytes();
            }

            public Builder setExperimentId(String str) {
                copyOnWrite();
                ((ExperimentLite) this.instance).setExperimentId(str);
                return this;
            }

            public Builder setExperimentIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentLite) this.instance).setExperimentIdBytes(byteString);
                return this;
            }

            private Builder() {
                super(ExperimentLite.DEFAULT_INSTANCE);
            }
        }

        static {
            ExperimentLite experimentLite = new ExperimentLite();
            DEFAULT_INSTANCE = experimentLite;
            GeneratedMessageLite.registerDefaultInstance(ExperimentLite.class, experimentLite);
        }

        private ExperimentLite() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExperimentId() {
            this.experimentId_ = getDefaultInstance().getExperimentId();
        }

        public static ExperimentLite getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ExperimentLite parseDelimitedFrom(InputStream inputStream) {
            return (ExperimentLite) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentLite parseFrom(ByteBuffer byteBuffer) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ExperimentLite> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentId(String str) {
            str.getClass();
            this.experimentId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.experimentId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExperimentLite();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"experimentId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ExperimentLite> parser = PARSER;
                    if (parser == null) {
                        synchronized (ExperimentLite.class) {
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

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLiteOrBuilder
        public String getExperimentId() {
            return this.experimentId_;
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLiteOrBuilder
        public ByteString getExperimentIdBytes() {
            return ByteString.copyFromUtf8(this.experimentId_);
        }

        public static Builder newBuilder(ExperimentLite experimentLite) {
            return DEFAULT_INSTANCE.createBuilder(experimentLite);
        }

        public static ExperimentLite parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(ByteString byteString) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ExperimentLite parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(byte[] bArr) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ExperimentLite parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(InputStream inputStream) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentLite parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(CodedInputStream codedInputStream) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExperimentLite parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentLite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ExperimentLiteOrBuilder extends MessageLiteOrBuilder {
        String getExperimentId();

        ByteString getExperimentIdBytes();
    }

    public static final class ExperimentPayload extends GeneratedMessageLite<ExperimentPayload, Builder> implements ExperimentPayloadOrBuilder {
        public static final int ACTIVATE_EVENT_TO_LOG_FIELD_NUMBER = 8;
        public static final int CLEAR_EVENT_TO_LOG_FIELD_NUMBER = 9;
        private static final ExperimentPayload DEFAULT_INSTANCE;
        public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
        public static final int EXPERIMENT_START_TIME_MILLIS_FIELD_NUMBER = 3;
        public static final int ONGOING_EXPERIMENTS_FIELD_NUMBER = 13;
        public static final int OVERFLOW_POLICY_FIELD_NUMBER = 12;
        private static volatile Parser<ExperimentPayload> PARSER = null;
        public static final int SET_EVENT_TO_LOG_FIELD_NUMBER = 7;
        public static final int TIMEOUT_EVENT_TO_LOG_FIELD_NUMBER = 10;
        public static final int TIME_TO_LIVE_MILLIS_FIELD_NUMBER = 6;
        public static final int TRIGGER_EVENT_FIELD_NUMBER = 4;
        public static final int TRIGGER_TIMEOUT_MILLIS_FIELD_NUMBER = 5;
        public static final int TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER = 11;
        public static final int VARIANT_ID_FIELD_NUMBER = 2;
        private long experimentStartTimeMillis_;
        private int overflowPolicy_;
        private long timeToLiveMillis_;
        private long triggerTimeoutMillis_;
        private String experimentId_ = "";
        private String variantId_ = "";
        private String triggerEvent_ = "";
        private String setEventToLog_ = "";
        private String activateEventToLog_ = "";
        private String clearEventToLog_ = "";
        private String timeoutEventToLog_ = "";
        private String ttlExpiryEventToLog_ = "";
        private Internal.ProtobufList<ExperimentLite> ongoingExperiments_ = GeneratedMessageLite.emptyProtobufList();

        public static final class Builder extends GeneratedMessageLite.Builder<ExperimentPayload, Builder> implements ExperimentPayloadOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllOngoingExperiments(Iterable<? extends ExperimentLite> iterable) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).addAllOngoingExperiments(iterable);
                return this;
            }

            public Builder addOngoingExperiments(ExperimentLite experimentLite) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).addOngoingExperiments(experimentLite);
                return this;
            }

            public Builder clearActivateEventToLog() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).clearActivateEventToLog();
                return this;
            }

            public Builder clearClearEventToLog() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).clearClearEventToLog();
                return this;
            }

            public Builder clearExperimentId() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).clearExperimentId();
                return this;
            }

            public Builder clearExperimentStartTimeMillis() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).clearExperimentStartTimeMillis();
                return this;
            }

            public Builder clearOngoingExperiments() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).clearOngoingExperiments();
                return this;
            }

            public Builder clearOverflowPolicy() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).clearOverflowPolicy();
                return this;
            }

            public Builder clearSetEventToLog() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).clearSetEventToLog();
                return this;
            }

            public Builder clearTimeToLiveMillis() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).clearTimeToLiveMillis();
                return this;
            }

            public Builder clearTimeoutEventToLog() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).clearTimeoutEventToLog();
                return this;
            }

            public Builder clearTriggerEvent() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).clearTriggerEvent();
                return this;
            }

            public Builder clearTriggerTimeoutMillis() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).clearTriggerTimeoutMillis();
                return this;
            }

            public Builder clearTtlExpiryEventToLog() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).clearTtlExpiryEventToLog();
                return this;
            }

            public Builder clearVariantId() {
                copyOnWrite();
                ((ExperimentPayload) this.instance).clearVariantId();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public String getActivateEventToLog() {
                return ((ExperimentPayload) this.instance).getActivateEventToLog();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public ByteString getActivateEventToLogBytes() {
                return ((ExperimentPayload) this.instance).getActivateEventToLogBytes();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public String getClearEventToLog() {
                return ((ExperimentPayload) this.instance).getClearEventToLog();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public ByteString getClearEventToLogBytes() {
                return ((ExperimentPayload) this.instance).getClearEventToLogBytes();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public String getExperimentId() {
                return ((ExperimentPayload) this.instance).getExperimentId();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public ByteString getExperimentIdBytes() {
                return ((ExperimentPayload) this.instance).getExperimentIdBytes();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public long getExperimentStartTimeMillis() {
                return ((ExperimentPayload) this.instance).getExperimentStartTimeMillis();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public ExperimentLite getOngoingExperiments(int i10) {
                return ((ExperimentPayload) this.instance).getOngoingExperiments(i10);
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public int getOngoingExperimentsCount() {
                return ((ExperimentPayload) this.instance).getOngoingExperimentsCount();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public List<ExperimentLite> getOngoingExperimentsList() {
                return Collections.unmodifiableList(((ExperimentPayload) this.instance).getOngoingExperimentsList());
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public ExperimentOverflowPolicy getOverflowPolicy() {
                return ((ExperimentPayload) this.instance).getOverflowPolicy();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public int getOverflowPolicyValue() {
                return ((ExperimentPayload) this.instance).getOverflowPolicyValue();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public String getSetEventToLog() {
                return ((ExperimentPayload) this.instance).getSetEventToLog();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public ByteString getSetEventToLogBytes() {
                return ((ExperimentPayload) this.instance).getSetEventToLogBytes();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public long getTimeToLiveMillis() {
                return ((ExperimentPayload) this.instance).getTimeToLiveMillis();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public String getTimeoutEventToLog() {
                return ((ExperimentPayload) this.instance).getTimeoutEventToLog();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public ByteString getTimeoutEventToLogBytes() {
                return ((ExperimentPayload) this.instance).getTimeoutEventToLogBytes();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public String getTriggerEvent() {
                return ((ExperimentPayload) this.instance).getTriggerEvent();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public ByteString getTriggerEventBytes() {
                return ((ExperimentPayload) this.instance).getTriggerEventBytes();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public long getTriggerTimeoutMillis() {
                return ((ExperimentPayload) this.instance).getTriggerTimeoutMillis();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public String getTtlExpiryEventToLog() {
                return ((ExperimentPayload) this.instance).getTtlExpiryEventToLog();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public ByteString getTtlExpiryEventToLogBytes() {
                return ((ExperimentPayload) this.instance).getTtlExpiryEventToLogBytes();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public String getVariantId() {
                return ((ExperimentPayload) this.instance).getVariantId();
            }

            @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
            public ByteString getVariantIdBytes() {
                return ((ExperimentPayload) this.instance).getVariantIdBytes();
            }

            public Builder removeOngoingExperiments(int i10) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).removeOngoingExperiments(i10);
                return this;
            }

            public Builder setActivateEventToLog(String str) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setActivateEventToLog(str);
                return this;
            }

            public Builder setActivateEventToLogBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setActivateEventToLogBytes(byteString);
                return this;
            }

            public Builder setClearEventToLog(String str) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setClearEventToLog(str);
                return this;
            }

            public Builder setClearEventToLogBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setClearEventToLogBytes(byteString);
                return this;
            }

            public Builder setExperimentId(String str) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setExperimentId(str);
                return this;
            }

            public Builder setExperimentIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setExperimentIdBytes(byteString);
                return this;
            }

            public Builder setExperimentStartTimeMillis(long j10) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setExperimentStartTimeMillis(j10);
                return this;
            }

            public Builder setOngoingExperiments(int i10, ExperimentLite experimentLite) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setOngoingExperiments(i10, experimentLite);
                return this;
            }

            public Builder setOverflowPolicy(ExperimentOverflowPolicy experimentOverflowPolicy) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setOverflowPolicy(experimentOverflowPolicy);
                return this;
            }

            public Builder setOverflowPolicyValue(int i10) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setOverflowPolicyValue(i10);
                return this;
            }

            public Builder setSetEventToLog(String str) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setSetEventToLog(str);
                return this;
            }

            public Builder setSetEventToLogBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setSetEventToLogBytes(byteString);
                return this;
            }

            public Builder setTimeToLiveMillis(long j10) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setTimeToLiveMillis(j10);
                return this;
            }

            public Builder setTimeoutEventToLog(String str) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setTimeoutEventToLog(str);
                return this;
            }

            public Builder setTimeoutEventToLogBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setTimeoutEventToLogBytes(byteString);
                return this;
            }

            public Builder setTriggerEvent(String str) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setTriggerEvent(str);
                return this;
            }

            public Builder setTriggerEventBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setTriggerEventBytes(byteString);
                return this;
            }

            public Builder setTriggerTimeoutMillis(long j10) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setTriggerTimeoutMillis(j10);
                return this;
            }

            public Builder setTtlExpiryEventToLog(String str) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setTtlExpiryEventToLog(str);
                return this;
            }

            public Builder setTtlExpiryEventToLogBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setTtlExpiryEventToLogBytes(byteString);
                return this;
            }

            public Builder setVariantId(String str) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setVariantId(str);
                return this;
            }

            public Builder setVariantIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setVariantIdBytes(byteString);
                return this;
            }

            private Builder() {
                super(ExperimentPayload.DEFAULT_INSTANCE);
            }

            public Builder addOngoingExperiments(int i10, ExperimentLite experimentLite) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).addOngoingExperiments(i10, experimentLite);
                return this;
            }

            public Builder setOngoingExperiments(int i10, ExperimentLite.Builder builder) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).setOngoingExperiments(i10, builder.build());
                return this;
            }

            public Builder addOngoingExperiments(ExperimentLite.Builder builder) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).addOngoingExperiments(builder.build());
                return this;
            }

            public Builder addOngoingExperiments(int i10, ExperimentLite.Builder builder) {
                copyOnWrite();
                ((ExperimentPayload) this.instance).addOngoingExperiments(i10, builder.build());
                return this;
            }
        }

        public enum ExperimentOverflowPolicy implements Internal.EnumLite {
            POLICY_UNSPECIFIED(0),
            DISCARD_OLDEST(1),
            IGNORE_NEWEST(2),
            UNRECOGNIZED(-1);

            public static final int DISCARD_OLDEST_VALUE = 1;
            public static final int IGNORE_NEWEST_VALUE = 2;
            public static final int POLICY_UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<ExperimentOverflowPolicy> internalValueMap = new Internal.EnumLiteMap<ExperimentOverflowPolicy>() { // from class: com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload.ExperimentOverflowPolicy.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public ExperimentOverflowPolicy findValueByNumber(int i10) {
                    return ExperimentOverflowPolicy.forNumber(i10);
                }
            };
            private final int value;

            public static final class ExperimentOverflowPolicyVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new ExperimentOverflowPolicyVerifier();

                private ExperimentOverflowPolicyVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i10) {
                    return ExperimentOverflowPolicy.forNumber(i10) != null;
                }
            }

            ExperimentOverflowPolicy(int i10) {
                this.value = i10;
            }

            public static ExperimentOverflowPolicy forNumber(int i10) {
                if (i10 == 0) {
                    return POLICY_UNSPECIFIED;
                }
                if (i10 == 1) {
                    return DISCARD_OLDEST;
                }
                if (i10 != 2) {
                    return null;
                }
                return IGNORE_NEWEST;
            }

            public static Internal.EnumLiteMap<ExperimentOverflowPolicy> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return ExperimentOverflowPolicyVerifier.INSTANCE;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static ExperimentOverflowPolicy valueOf(int i10) {
                return forNumber(i10);
            }
        }

        static {
            ExperimentPayload experimentPayload = new ExperimentPayload();
            DEFAULT_INSTANCE = experimentPayload;
            GeneratedMessageLite.registerDefaultInstance(ExperimentPayload.class, experimentPayload);
        }

        private ExperimentPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllOngoingExperiments(Iterable<? extends ExperimentLite> iterable) {
            ensureOngoingExperimentsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.ongoingExperiments_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addOngoingExperiments(ExperimentLite experimentLite) {
            experimentLite.getClass();
            ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.add(experimentLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearActivateEventToLog() {
            this.activateEventToLog_ = getDefaultInstance().getActivateEventToLog();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClearEventToLog() {
            this.clearEventToLog_ = getDefaultInstance().getClearEventToLog();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExperimentId() {
            this.experimentId_ = getDefaultInstance().getExperimentId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExperimentStartTimeMillis() {
            this.experimentStartTimeMillis_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOngoingExperiments() {
            this.ongoingExperiments_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOverflowPolicy() {
            this.overflowPolicy_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSetEventToLog() {
            this.setEventToLog_ = getDefaultInstance().getSetEventToLog();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeToLiveMillis() {
            this.timeToLiveMillis_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeoutEventToLog() {
            this.timeoutEventToLog_ = getDefaultInstance().getTimeoutEventToLog();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTriggerEvent() {
            this.triggerEvent_ = getDefaultInstance().getTriggerEvent();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTriggerTimeoutMillis() {
            this.triggerTimeoutMillis_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTtlExpiryEventToLog() {
            this.ttlExpiryEventToLog_ = getDefaultInstance().getTtlExpiryEventToLog();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVariantId() {
            this.variantId_ = getDefaultInstance().getVariantId();
        }

        private void ensureOngoingExperimentsIsMutable() {
            Internal.ProtobufList<ExperimentLite> protobufList = this.ongoingExperiments_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.ongoingExperiments_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ExperimentPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ExperimentPayload parseDelimitedFrom(InputStream inputStream) {
            return (ExperimentPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentPayload parseFrom(ByteBuffer byteBuffer) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ExperimentPayload> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeOngoingExperiments(int i10) {
            ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.remove(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setActivateEventToLog(String str) {
            str.getClass();
            this.activateEventToLog_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setActivateEventToLogBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.activateEventToLog_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClearEventToLog(String str) {
            str.getClass();
            this.clearEventToLog_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClearEventToLogBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.clearEventToLog_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentId(String str) {
            str.getClass();
            this.experimentId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.experimentId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentStartTimeMillis(long j10) {
            this.experimentStartTimeMillis_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOngoingExperiments(int i10, ExperimentLite experimentLite) {
            experimentLite.getClass();
            ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.set(i10, experimentLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOverflowPolicy(ExperimentOverflowPolicy experimentOverflowPolicy) {
            this.overflowPolicy_ = experimentOverflowPolicy.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOverflowPolicyValue(int i10) {
            this.overflowPolicy_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSetEventToLog(String str) {
            str.getClass();
            this.setEventToLog_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSetEventToLogBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.setEventToLog_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeToLiveMillis(long j10) {
            this.timeToLiveMillis_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeoutEventToLog(String str) {
            str.getClass();
            this.timeoutEventToLog_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeoutEventToLogBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.timeoutEventToLog_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTriggerEvent(String str) {
            str.getClass();
            this.triggerEvent_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTriggerEventBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.triggerEvent_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTriggerTimeoutMillis(long j10) {
            this.triggerTimeoutMillis_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTtlExpiryEventToLog(String str) {
            str.getClass();
            this.ttlExpiryEventToLog_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTtlExpiryEventToLogBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.ttlExpiryEventToLog_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVariantId(String str) {
            str.getClass();
            this.variantId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVariantIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.variantId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExperimentPayload();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\r\u0000\u0000\u0001\r\r\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004Ȉ\u0005\u0002\u0006\u0002\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\f\f\r\u001b", new Object[]{"experimentId_", "variantId_", "experimentStartTimeMillis_", "triggerEvent_", "triggerTimeoutMillis_", "timeToLiveMillis_", "setEventToLog_", "activateEventToLog_", "clearEventToLog_", "timeoutEventToLog_", "ttlExpiryEventToLog_", "overflowPolicy_", "ongoingExperiments_", ExperimentLite.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ExperimentPayload> parser = PARSER;
                    if (parser == null) {
                        synchronized (ExperimentPayload.class) {
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

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public String getActivateEventToLog() {
            return this.activateEventToLog_;
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public ByteString getActivateEventToLogBytes() {
            return ByteString.copyFromUtf8(this.activateEventToLog_);
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public String getClearEventToLog() {
            return this.clearEventToLog_;
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public ByteString getClearEventToLogBytes() {
            return ByteString.copyFromUtf8(this.clearEventToLog_);
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public String getExperimentId() {
            return this.experimentId_;
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public ByteString getExperimentIdBytes() {
            return ByteString.copyFromUtf8(this.experimentId_);
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public long getExperimentStartTimeMillis() {
            return this.experimentStartTimeMillis_;
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public ExperimentLite getOngoingExperiments(int i10) {
            return this.ongoingExperiments_.get(i10);
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public int getOngoingExperimentsCount() {
            return this.ongoingExperiments_.size();
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public List<ExperimentLite> getOngoingExperimentsList() {
            return this.ongoingExperiments_;
        }

        public ExperimentLiteOrBuilder getOngoingExperimentsOrBuilder(int i10) {
            return this.ongoingExperiments_.get(i10);
        }

        public List<? extends ExperimentLiteOrBuilder> getOngoingExperimentsOrBuilderList() {
            return this.ongoingExperiments_;
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public ExperimentOverflowPolicy getOverflowPolicy() {
            ExperimentOverflowPolicy forNumber = ExperimentOverflowPolicy.forNumber(this.overflowPolicy_);
            return forNumber == null ? ExperimentOverflowPolicy.UNRECOGNIZED : forNumber;
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public int getOverflowPolicyValue() {
            return this.overflowPolicy_;
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public String getSetEventToLog() {
            return this.setEventToLog_;
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public ByteString getSetEventToLogBytes() {
            return ByteString.copyFromUtf8(this.setEventToLog_);
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public long getTimeToLiveMillis() {
            return this.timeToLiveMillis_;
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public String getTimeoutEventToLog() {
            return this.timeoutEventToLog_;
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public ByteString getTimeoutEventToLogBytes() {
            return ByteString.copyFromUtf8(this.timeoutEventToLog_);
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public String getTriggerEvent() {
            return this.triggerEvent_;
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public ByteString getTriggerEventBytes() {
            return ByteString.copyFromUtf8(this.triggerEvent_);
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public long getTriggerTimeoutMillis() {
            return this.triggerTimeoutMillis_;
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public String getTtlExpiryEventToLog() {
            return this.ttlExpiryEventToLog_;
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public ByteString getTtlExpiryEventToLogBytes() {
            return ByteString.copyFromUtf8(this.ttlExpiryEventToLog_);
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public String getVariantId() {
            return this.variantId_;
        }

        @Override // com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder
        public ByteString getVariantIdBytes() {
            return ByteString.copyFromUtf8(this.variantId_);
        }

        public static Builder newBuilder(ExperimentPayload experimentPayload) {
            return DEFAULT_INSTANCE.createBuilder(experimentPayload);
        }

        public static ExperimentPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(ByteString byteString) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addOngoingExperiments(int i10, ExperimentLite experimentLite) {
            experimentLite.getClass();
            ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.add(i10, experimentLite);
        }

        public static ExperimentPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(byte[] bArr) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ExperimentPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(InputStream inputStream) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(CodedInputStream codedInputStream) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExperimentPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ExperimentPayloadOrBuilder extends MessageLiteOrBuilder {
        String getActivateEventToLog();

        ByteString getActivateEventToLogBytes();

        String getClearEventToLog();

        ByteString getClearEventToLogBytes();

        String getExperimentId();

        ByteString getExperimentIdBytes();

        long getExperimentStartTimeMillis();

        ExperimentLite getOngoingExperiments(int i10);

        int getOngoingExperimentsCount();

        List<ExperimentLite> getOngoingExperimentsList();

        ExperimentPayload.ExperimentOverflowPolicy getOverflowPolicy();

        int getOverflowPolicyValue();

        String getSetEventToLog();

        ByteString getSetEventToLogBytes();

        long getTimeToLiveMillis();

        String getTimeoutEventToLog();

        ByteString getTimeoutEventToLogBytes();

        String getTriggerEvent();

        ByteString getTriggerEventBytes();

        long getTriggerTimeoutMillis();

        String getTtlExpiryEventToLog();

        ByteString getTtlExpiryEventToLogBytes();

        String getVariantId();

        ByteString getVariantIdBytes();
    }

    private ExperimentPayloadProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
