package com.google.internal.firebase.inappmessaging.v1;

import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.firebase.inappmessaging.ExperimentPayloadProto;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class CampaignProto {

    /* renamed from: com.google.internal.firebase.inappmessaging.v1.CampaignProto$1, reason: invalid class name */
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

    public static final class ExperimentalCampaignPayload extends GeneratedMessageLite<ExperimentalCampaignPayload, Builder> implements ExperimentalCampaignPayloadOrBuilder {
        public static final int CAMPAIGN_END_TIME_MILLIS_FIELD_NUMBER = 4;
        public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
        public static final int CAMPAIGN_NAME_FIELD_NUMBER = 5;
        public static final int CAMPAIGN_START_TIME_MILLIS_FIELD_NUMBER = 3;
        private static final ExperimentalCampaignPayload DEFAULT_INSTANCE;
        public static final int EXPERIMENT_PAYLOAD_FIELD_NUMBER = 2;
        private static volatile Parser<ExperimentalCampaignPayload> PARSER;
        private long campaignEndTimeMillis_;
        private String campaignId_ = "";
        private String campaignName_ = "";
        private long campaignStartTimeMillis_;
        private ExperimentPayloadProto.ExperimentPayload experimentPayload_;

        public static final class Builder extends GeneratedMessageLite.Builder<ExperimentalCampaignPayload, Builder> implements ExperimentalCampaignPayloadOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCampaignEndTimeMillis() {
                copyOnWrite();
                ((ExperimentalCampaignPayload) this.instance).clearCampaignEndTimeMillis();
                return this;
            }

            public Builder clearCampaignId() {
                copyOnWrite();
                ((ExperimentalCampaignPayload) this.instance).clearCampaignId();
                return this;
            }

            public Builder clearCampaignName() {
                copyOnWrite();
                ((ExperimentalCampaignPayload) this.instance).clearCampaignName();
                return this;
            }

            public Builder clearCampaignStartTimeMillis() {
                copyOnWrite();
                ((ExperimentalCampaignPayload) this.instance).clearCampaignStartTimeMillis();
                return this;
            }

            public Builder clearExperimentPayload() {
                copyOnWrite();
                ((ExperimentalCampaignPayload) this.instance).clearExperimentPayload();
                return this;
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
            public long getCampaignEndTimeMillis() {
                return ((ExperimentalCampaignPayload) this.instance).getCampaignEndTimeMillis();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
            public String getCampaignId() {
                return ((ExperimentalCampaignPayload) this.instance).getCampaignId();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
            public ByteString getCampaignIdBytes() {
                return ((ExperimentalCampaignPayload) this.instance).getCampaignIdBytes();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
            public String getCampaignName() {
                return ((ExperimentalCampaignPayload) this.instance).getCampaignName();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
            public ByteString getCampaignNameBytes() {
                return ((ExperimentalCampaignPayload) this.instance).getCampaignNameBytes();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
            public long getCampaignStartTimeMillis() {
                return ((ExperimentalCampaignPayload) this.instance).getCampaignStartTimeMillis();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
            public ExperimentPayloadProto.ExperimentPayload getExperimentPayload() {
                return ((ExperimentalCampaignPayload) this.instance).getExperimentPayload();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
            public boolean hasExperimentPayload() {
                return ((ExperimentalCampaignPayload) this.instance).hasExperimentPayload();
            }

            public Builder mergeExperimentPayload(ExperimentPayloadProto.ExperimentPayload experimentPayload) {
                copyOnWrite();
                ((ExperimentalCampaignPayload) this.instance).mergeExperimentPayload(experimentPayload);
                return this;
            }

            public Builder setCampaignEndTimeMillis(long j10) {
                copyOnWrite();
                ((ExperimentalCampaignPayload) this.instance).setCampaignEndTimeMillis(j10);
                return this;
            }

            public Builder setCampaignId(String str) {
                copyOnWrite();
                ((ExperimentalCampaignPayload) this.instance).setCampaignId(str);
                return this;
            }

            public Builder setCampaignIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentalCampaignPayload) this.instance).setCampaignIdBytes(byteString);
                return this;
            }

            public Builder setCampaignName(String str) {
                copyOnWrite();
                ((ExperimentalCampaignPayload) this.instance).setCampaignName(str);
                return this;
            }

            public Builder setCampaignNameBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentalCampaignPayload) this.instance).setCampaignNameBytes(byteString);
                return this;
            }

            public Builder setCampaignStartTimeMillis(long j10) {
                copyOnWrite();
                ((ExperimentalCampaignPayload) this.instance).setCampaignStartTimeMillis(j10);
                return this;
            }

            public Builder setExperimentPayload(ExperimentPayloadProto.ExperimentPayload experimentPayload) {
                copyOnWrite();
                ((ExperimentalCampaignPayload) this.instance).setExperimentPayload(experimentPayload);
                return this;
            }

            private Builder() {
                super(ExperimentalCampaignPayload.DEFAULT_INSTANCE);
            }

            public Builder setExperimentPayload(ExperimentPayloadProto.ExperimentPayload.Builder builder) {
                copyOnWrite();
                ((ExperimentalCampaignPayload) this.instance).setExperimentPayload(builder.build());
                return this;
            }
        }

        static {
            ExperimentalCampaignPayload experimentalCampaignPayload = new ExperimentalCampaignPayload();
            DEFAULT_INSTANCE = experimentalCampaignPayload;
            GeneratedMessageLite.registerDefaultInstance(ExperimentalCampaignPayload.class, experimentalCampaignPayload);
        }

        private ExperimentalCampaignPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCampaignEndTimeMillis() {
            this.campaignEndTimeMillis_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCampaignId() {
            this.campaignId_ = getDefaultInstance().getCampaignId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCampaignName() {
            this.campaignName_ = getDefaultInstance().getCampaignName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCampaignStartTimeMillis() {
            this.campaignStartTimeMillis_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExperimentPayload() {
            this.experimentPayload_ = null;
        }

        public static ExperimentalCampaignPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeExperimentPayload(ExperimentPayloadProto.ExperimentPayload experimentPayload) {
            experimentPayload.getClass();
            ExperimentPayloadProto.ExperimentPayload experimentPayload2 = this.experimentPayload_;
            if (experimentPayload2 == null || experimentPayload2 == ExperimentPayloadProto.ExperimentPayload.getDefaultInstance()) {
                this.experimentPayload_ = experimentPayload;
            } else {
                this.experimentPayload_ = ExperimentPayloadProto.ExperimentPayload.newBuilder(this.experimentPayload_).mergeFrom((ExperimentPayloadProto.ExperimentPayload.Builder) experimentPayload).buildPartial();
            }
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ExperimentalCampaignPayload parseDelimitedFrom(InputStream inputStream) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentalCampaignPayload parseFrom(ByteBuffer byteBuffer) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ExperimentalCampaignPayload> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaignEndTimeMillis(long j10) {
            this.campaignEndTimeMillis_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaignId(String str) {
            str.getClass();
            this.campaignId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaignIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.campaignId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaignName(String str) {
            str.getClass();
            this.campaignName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaignNameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.campaignName_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaignStartTimeMillis(long j10) {
            this.campaignStartTimeMillis_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentPayload(ExperimentPayloadProto.ExperimentPayload experimentPayload) {
            experimentPayload.getClass();
            this.experimentPayload_ = experimentPayload;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExperimentalCampaignPayload();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\t\u0003\u0002\u0004\u0002\u0005Ȉ", new Object[]{"campaignId_", "experimentPayload_", "campaignStartTimeMillis_", "campaignEndTimeMillis_", "campaignName_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ExperimentalCampaignPayload> parser = PARSER;
                    if (parser == null) {
                        synchronized (ExperimentalCampaignPayload.class) {
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

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
        public long getCampaignEndTimeMillis() {
            return this.campaignEndTimeMillis_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
        public String getCampaignId() {
            return this.campaignId_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
        public ByteString getCampaignIdBytes() {
            return ByteString.copyFromUtf8(this.campaignId_);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
        public String getCampaignName() {
            return this.campaignName_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
        public ByteString getCampaignNameBytes() {
            return ByteString.copyFromUtf8(this.campaignName_);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
        public long getCampaignStartTimeMillis() {
            return this.campaignStartTimeMillis_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
        public ExperimentPayloadProto.ExperimentPayload getExperimentPayload() {
            ExperimentPayloadProto.ExperimentPayload experimentPayload = this.experimentPayload_;
            return experimentPayload == null ? ExperimentPayloadProto.ExperimentPayload.getDefaultInstance() : experimentPayload;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignPayloadOrBuilder
        public boolean hasExperimentPayload() {
            return this.experimentPayload_ != null;
        }

        public static Builder newBuilder(ExperimentalCampaignPayload experimentalCampaignPayload) {
            return DEFAULT_INSTANCE.createBuilder(experimentalCampaignPayload);
        }

        public static ExperimentalCampaignPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentalCampaignPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ExperimentalCampaignPayload parseFrom(ByteString byteString) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ExperimentalCampaignPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExperimentalCampaignPayload parseFrom(byte[] bArr) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ExperimentalCampaignPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ExperimentalCampaignPayload parseFrom(InputStream inputStream) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentalCampaignPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentalCampaignPayload parseFrom(CodedInputStream codedInputStream) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExperimentalCampaignPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ExperimentalCampaignPayloadOrBuilder extends MessageLiteOrBuilder {
        long getCampaignEndTimeMillis();

        String getCampaignId();

        ByteString getCampaignIdBytes();

        String getCampaignName();

        ByteString getCampaignNameBytes();

        long getCampaignStartTimeMillis();

        ExperimentPayloadProto.ExperimentPayload getExperimentPayload();

        boolean hasExperimentPayload();
    }

    public static final class ExperimentalCampaignRollout extends GeneratedMessageLite<ExperimentalCampaignRollout, Builder> implements ExperimentalCampaignRolloutOrBuilder {
        private static final ExperimentalCampaignRollout DEFAULT_INSTANCE;
        public static final int END_TIME_FIELD_NUMBER = 5;
        public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
        private static volatile Parser<ExperimentalCampaignRollout> PARSER = null;
        public static final int PRIORITY_FIELD_NUMBER = 3;
        public static final int SELECTED_VARIANT_INDEX_FIELD_NUMBER = 2;
        public static final int START_TIME_FIELD_NUMBER = 4;
        private CommonTypesProto.CampaignTime endTime_;
        private String experimentId_ = "";
        private CommonTypesProto.Priority priority_;
        private int selectedVariantIndex_;
        private CommonTypesProto.CampaignTime startTime_;

        public static final class Builder extends GeneratedMessageLite.Builder<ExperimentalCampaignRollout, Builder> implements ExperimentalCampaignRolloutOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearEndTime() {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).clearEndTime();
                return this;
            }

            public Builder clearExperimentId() {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).clearExperimentId();
                return this;
            }

            public Builder clearPriority() {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).clearPriority();
                return this;
            }

            public Builder clearSelectedVariantIndex() {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).clearSelectedVariantIndex();
                return this;
            }

            public Builder clearStartTime() {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).clearStartTime();
                return this;
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public CommonTypesProto.CampaignTime getEndTime() {
                return ((ExperimentalCampaignRollout) this.instance).getEndTime();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public String getExperimentId() {
                return ((ExperimentalCampaignRollout) this.instance).getExperimentId();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public ByteString getExperimentIdBytes() {
                return ((ExperimentalCampaignRollout) this.instance).getExperimentIdBytes();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public CommonTypesProto.Priority getPriority() {
                return ((ExperimentalCampaignRollout) this.instance).getPriority();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public int getSelectedVariantIndex() {
                return ((ExperimentalCampaignRollout) this.instance).getSelectedVariantIndex();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public CommonTypesProto.CampaignTime getStartTime() {
                return ((ExperimentalCampaignRollout) this.instance).getStartTime();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public boolean hasEndTime() {
                return ((ExperimentalCampaignRollout) this.instance).hasEndTime();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public boolean hasPriority() {
                return ((ExperimentalCampaignRollout) this.instance).hasPriority();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
            public boolean hasStartTime() {
                return ((ExperimentalCampaignRollout) this.instance).hasStartTime();
            }

            public Builder mergeEndTime(CommonTypesProto.CampaignTime campaignTime) {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).mergeEndTime(campaignTime);
                return this;
            }

            public Builder mergePriority(CommonTypesProto.Priority priority) {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).mergePriority(priority);
                return this;
            }

            public Builder mergeStartTime(CommonTypesProto.CampaignTime campaignTime) {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).mergeStartTime(campaignTime);
                return this;
            }

            public Builder setEndTime(CommonTypesProto.CampaignTime campaignTime) {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).setEndTime(campaignTime);
                return this;
            }

            public Builder setExperimentId(String str) {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).setExperimentId(str);
                return this;
            }

            public Builder setExperimentIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).setExperimentIdBytes(byteString);
                return this;
            }

            public Builder setPriority(CommonTypesProto.Priority priority) {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).setPriority(priority);
                return this;
            }

            public Builder setSelectedVariantIndex(int i10) {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).setSelectedVariantIndex(i10);
                return this;
            }

            public Builder setStartTime(CommonTypesProto.CampaignTime campaignTime) {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).setStartTime(campaignTime);
                return this;
            }

            private Builder() {
                super(ExperimentalCampaignRollout.DEFAULT_INSTANCE);
            }

            public Builder setEndTime(CommonTypesProto.CampaignTime.Builder builder) {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).setEndTime(builder.build());
                return this;
            }

            public Builder setPriority(CommonTypesProto.Priority.Builder builder) {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).setPriority(builder.build());
                return this;
            }

            public Builder setStartTime(CommonTypesProto.CampaignTime.Builder builder) {
                copyOnWrite();
                ((ExperimentalCampaignRollout) this.instance).setStartTime(builder.build());
                return this;
            }
        }

        static {
            ExperimentalCampaignRollout experimentalCampaignRollout = new ExperimentalCampaignRollout();
            DEFAULT_INSTANCE = experimentalCampaignRollout;
            GeneratedMessageLite.registerDefaultInstance(ExperimentalCampaignRollout.class, experimentalCampaignRollout);
        }

        private ExperimentalCampaignRollout() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndTime() {
            this.endTime_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExperimentId() {
            this.experimentId_ = getDefaultInstance().getExperimentId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPriority() {
            this.priority_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSelectedVariantIndex() {
            this.selectedVariantIndex_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartTime() {
            this.startTime_ = null;
        }

        public static ExperimentalCampaignRollout getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeEndTime(CommonTypesProto.CampaignTime campaignTime) {
            campaignTime.getClass();
            CommonTypesProto.CampaignTime campaignTime2 = this.endTime_;
            if (campaignTime2 == null || campaignTime2 == CommonTypesProto.CampaignTime.getDefaultInstance()) {
                this.endTime_ = campaignTime;
            } else {
                this.endTime_ = CommonTypesProto.CampaignTime.newBuilder(this.endTime_).mergeFrom((CommonTypesProto.CampaignTime.Builder) campaignTime).buildPartial();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePriority(CommonTypesProto.Priority priority) {
            priority.getClass();
            CommonTypesProto.Priority priority2 = this.priority_;
            if (priority2 == null || priority2 == CommonTypesProto.Priority.getDefaultInstance()) {
                this.priority_ = priority;
            } else {
                this.priority_ = CommonTypesProto.Priority.newBuilder(this.priority_).mergeFrom((CommonTypesProto.Priority.Builder) priority).buildPartial();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeStartTime(CommonTypesProto.CampaignTime campaignTime) {
            campaignTime.getClass();
            CommonTypesProto.CampaignTime campaignTime2 = this.startTime_;
            if (campaignTime2 == null || campaignTime2 == CommonTypesProto.CampaignTime.getDefaultInstance()) {
                this.startTime_ = campaignTime;
            } else {
                this.startTime_ = CommonTypesProto.CampaignTime.newBuilder(this.startTime_).mergeFrom((CommonTypesProto.CampaignTime.Builder) campaignTime).buildPartial();
            }
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ExperimentalCampaignRollout parseDelimitedFrom(InputStream inputStream) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentalCampaignRollout parseFrom(ByteBuffer byteBuffer) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ExperimentalCampaignRollout> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndTime(CommonTypesProto.CampaignTime campaignTime) {
            campaignTime.getClass();
            this.endTime_ = campaignTime;
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
        public void setPriority(CommonTypesProto.Priority priority) {
            priority.getClass();
            this.priority_ = priority;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSelectedVariantIndex(int i10) {
            this.selectedVariantIndex_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartTime(CommonTypesProto.CampaignTime campaignTime) {
            campaignTime.getClass();
            this.startTime_ = campaignTime;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExperimentalCampaignRollout();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\t\u0004\t\u0005\t", new Object[]{"experimentId_", "selectedVariantIndex_", "priority_", "startTime_", "endTime_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ExperimentalCampaignRollout> parser = PARSER;
                    if (parser == null) {
                        synchronized (ExperimentalCampaignRollout.class) {
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

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public CommonTypesProto.CampaignTime getEndTime() {
            CommonTypesProto.CampaignTime campaignTime = this.endTime_;
            return campaignTime == null ? CommonTypesProto.CampaignTime.getDefaultInstance() : campaignTime;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public String getExperimentId() {
            return this.experimentId_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public ByteString getExperimentIdBytes() {
            return ByteString.copyFromUtf8(this.experimentId_);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public CommonTypesProto.Priority getPriority() {
            CommonTypesProto.Priority priority = this.priority_;
            return priority == null ? CommonTypesProto.Priority.getDefaultInstance() : priority;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public int getSelectedVariantIndex() {
            return this.selectedVariantIndex_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public CommonTypesProto.CampaignTime getStartTime() {
            CommonTypesProto.CampaignTime campaignTime = this.startTime_;
            return campaignTime == null ? CommonTypesProto.CampaignTime.getDefaultInstance() : campaignTime;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public boolean hasEndTime() {
            return this.endTime_ != null;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public boolean hasPriority() {
            return this.priority_ != null;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ExperimentalCampaignRolloutOrBuilder
        public boolean hasStartTime() {
            return this.startTime_ != null;
        }

        public static Builder newBuilder(ExperimentalCampaignRollout experimentalCampaignRollout) {
            return DEFAULT_INSTANCE.createBuilder(experimentalCampaignRollout);
        }

        public static ExperimentalCampaignRollout parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentalCampaignRollout parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ExperimentalCampaignRollout parseFrom(ByteString byteString) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ExperimentalCampaignRollout parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExperimentalCampaignRollout parseFrom(byte[] bArr) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ExperimentalCampaignRollout parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ExperimentalCampaignRollout parseFrom(InputStream inputStream) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentalCampaignRollout parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentalCampaignRollout parseFrom(CodedInputStream codedInputStream) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExperimentalCampaignRollout parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentalCampaignRollout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ExperimentalCampaignRolloutOrBuilder extends MessageLiteOrBuilder {
        CommonTypesProto.CampaignTime getEndTime();

        String getExperimentId();

        ByteString getExperimentIdBytes();

        CommonTypesProto.Priority getPriority();

        int getSelectedVariantIndex();

        CommonTypesProto.CampaignTime getStartTime();

        boolean hasEndTime();

        boolean hasPriority();

        boolean hasStartTime();
    }

    public static final class ThickContent extends GeneratedMessageLite<ThickContent, Builder> implements ThickContentOrBuilder {
        public static final int CONTENT_FIELD_NUMBER = 3;
        public static final int DATA_BUNDLE_FIELD_NUMBER = 8;
        private static final ThickContent DEFAULT_INSTANCE;
        public static final int EXPERIMENTAL_PAYLOAD_FIELD_NUMBER = 2;
        public static final int IS_TEST_CAMPAIGN_FIELD_NUMBER = 7;
        private static volatile Parser<ThickContent> PARSER = null;
        public static final int PRIORITY_FIELD_NUMBER = 4;
        public static final int TRIGGERING_CONDITIONS_FIELD_NUMBER = 5;
        public static final int VANILLA_PAYLOAD_FIELD_NUMBER = 1;
        private MessagesProto.Content content_;
        private boolean isTestCampaign_;
        private Object payload_;
        private CommonTypesProto.Priority priority_;
        private int payloadCase_ = 0;
        private MapFieldLite<String, String> dataBundle_ = MapFieldLite.emptyMapField();
        private Internal.ProtobufList<CommonTypesProto.TriggeringCondition> triggeringConditions_ = GeneratedMessageLite.emptyProtobufList();

        public static final class Builder extends GeneratedMessageLite.Builder<ThickContent, Builder> implements ThickContentOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllTriggeringConditions(Iterable<? extends CommonTypesProto.TriggeringCondition> iterable) {
                copyOnWrite();
                ((ThickContent) this.instance).addAllTriggeringConditions(iterable);
                return this;
            }

            public Builder addTriggeringConditions(CommonTypesProto.TriggeringCondition triggeringCondition) {
                copyOnWrite();
                ((ThickContent) this.instance).addTriggeringConditions(triggeringCondition);
                return this;
            }

            public Builder clearContent() {
                copyOnWrite();
                ((ThickContent) this.instance).clearContent();
                return this;
            }

            public Builder clearDataBundle() {
                copyOnWrite();
                ((ThickContent) this.instance).getMutableDataBundleMap().clear();
                return this;
            }

            public Builder clearExperimentalPayload() {
                copyOnWrite();
                ((ThickContent) this.instance).clearExperimentalPayload();
                return this;
            }

            public Builder clearIsTestCampaign() {
                copyOnWrite();
                ((ThickContent) this.instance).clearIsTestCampaign();
                return this;
            }

            public Builder clearPayload() {
                copyOnWrite();
                ((ThickContent) this.instance).clearPayload();
                return this;
            }

            public Builder clearPriority() {
                copyOnWrite();
                ((ThickContent) this.instance).clearPriority();
                return this;
            }

            public Builder clearTriggeringConditions() {
                copyOnWrite();
                ((ThickContent) this.instance).clearTriggeringConditions();
                return this;
            }

            public Builder clearVanillaPayload() {
                copyOnWrite();
                ((ThickContent) this.instance).clearVanillaPayload();
                return this;
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public boolean containsDataBundle(String str) {
                str.getClass();
                return ((ThickContent) this.instance).getDataBundleMap().containsKey(str);
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public MessagesProto.Content getContent() {
                return ((ThickContent) this.instance).getContent();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            @Deprecated
            public Map<String, String> getDataBundle() {
                return getDataBundleMap();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public int getDataBundleCount() {
                return ((ThickContent) this.instance).getDataBundleMap().size();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public Map<String, String> getDataBundleMap() {
                return Collections.unmodifiableMap(((ThickContent) this.instance).getDataBundleMap());
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public String getDataBundleOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> dataBundleMap = ((ThickContent) this.instance).getDataBundleMap();
                return dataBundleMap.containsKey(str) ? dataBundleMap.get(str) : str2;
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public String getDataBundleOrThrow(String str) {
                str.getClass();
                Map<String, String> dataBundleMap = ((ThickContent) this.instance).getDataBundleMap();
                if (dataBundleMap.containsKey(str)) {
                    return dataBundleMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public ExperimentalCampaignPayload getExperimentalPayload() {
                return ((ThickContent) this.instance).getExperimentalPayload();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public boolean getIsTestCampaign() {
                return ((ThickContent) this.instance).getIsTestCampaign();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public PayloadCase getPayloadCase() {
                return ((ThickContent) this.instance).getPayloadCase();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public CommonTypesProto.Priority getPriority() {
                return ((ThickContent) this.instance).getPriority();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public CommonTypesProto.TriggeringCondition getTriggeringConditions(int i10) {
                return ((ThickContent) this.instance).getTriggeringConditions(i10);
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public int getTriggeringConditionsCount() {
                return ((ThickContent) this.instance).getTriggeringConditionsCount();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public List<CommonTypesProto.TriggeringCondition> getTriggeringConditionsList() {
                return Collections.unmodifiableList(((ThickContent) this.instance).getTriggeringConditionsList());
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public VanillaCampaignPayload getVanillaPayload() {
                return ((ThickContent) this.instance).getVanillaPayload();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public boolean hasContent() {
                return ((ThickContent) this.instance).hasContent();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public boolean hasExperimentalPayload() {
                return ((ThickContent) this.instance).hasExperimentalPayload();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public boolean hasPriority() {
                return ((ThickContent) this.instance).hasPriority();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
            public boolean hasVanillaPayload() {
                return ((ThickContent) this.instance).hasVanillaPayload();
            }

            public Builder mergeContent(MessagesProto.Content content) {
                copyOnWrite();
                ((ThickContent) this.instance).mergeContent(content);
                return this;
            }

            public Builder mergeExperimentalPayload(ExperimentalCampaignPayload experimentalCampaignPayload) {
                copyOnWrite();
                ((ThickContent) this.instance).mergeExperimentalPayload(experimentalCampaignPayload);
                return this;
            }

            public Builder mergePriority(CommonTypesProto.Priority priority) {
                copyOnWrite();
                ((ThickContent) this.instance).mergePriority(priority);
                return this;
            }

            public Builder mergeVanillaPayload(VanillaCampaignPayload vanillaCampaignPayload) {
                copyOnWrite();
                ((ThickContent) this.instance).mergeVanillaPayload(vanillaCampaignPayload);
                return this;
            }

            public Builder putAllDataBundle(Map<String, String> map) {
                copyOnWrite();
                ((ThickContent) this.instance).getMutableDataBundleMap().putAll(map);
                return this;
            }

            public Builder putDataBundle(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((ThickContent) this.instance).getMutableDataBundleMap().put(str, str2);
                return this;
            }

            public Builder removeDataBundle(String str) {
                str.getClass();
                copyOnWrite();
                ((ThickContent) this.instance).getMutableDataBundleMap().remove(str);
                return this;
            }

            public Builder removeTriggeringConditions(int i10) {
                copyOnWrite();
                ((ThickContent) this.instance).removeTriggeringConditions(i10);
                return this;
            }

            public Builder setContent(MessagesProto.Content content) {
                copyOnWrite();
                ((ThickContent) this.instance).setContent(content);
                return this;
            }

            public Builder setExperimentalPayload(ExperimentalCampaignPayload experimentalCampaignPayload) {
                copyOnWrite();
                ((ThickContent) this.instance).setExperimentalPayload(experimentalCampaignPayload);
                return this;
            }

            public Builder setIsTestCampaign(boolean z10) {
                copyOnWrite();
                ((ThickContent) this.instance).setIsTestCampaign(z10);
                return this;
            }

            public Builder setPriority(CommonTypesProto.Priority priority) {
                copyOnWrite();
                ((ThickContent) this.instance).setPriority(priority);
                return this;
            }

            public Builder setTriggeringConditions(int i10, CommonTypesProto.TriggeringCondition triggeringCondition) {
                copyOnWrite();
                ((ThickContent) this.instance).setTriggeringConditions(i10, triggeringCondition);
                return this;
            }

            public Builder setVanillaPayload(VanillaCampaignPayload vanillaCampaignPayload) {
                copyOnWrite();
                ((ThickContent) this.instance).setVanillaPayload(vanillaCampaignPayload);
                return this;
            }

            private Builder() {
                super(ThickContent.DEFAULT_INSTANCE);
            }

            public Builder addTriggeringConditions(int i10, CommonTypesProto.TriggeringCondition triggeringCondition) {
                copyOnWrite();
                ((ThickContent) this.instance).addTriggeringConditions(i10, triggeringCondition);
                return this;
            }

            public Builder setContent(MessagesProto.Content.Builder builder) {
                copyOnWrite();
                ((ThickContent) this.instance).setContent(builder.build());
                return this;
            }

            public Builder setExperimentalPayload(ExperimentalCampaignPayload.Builder builder) {
                copyOnWrite();
                ((ThickContent) this.instance).setExperimentalPayload(builder.build());
                return this;
            }

            public Builder setPriority(CommonTypesProto.Priority.Builder builder) {
                copyOnWrite();
                ((ThickContent) this.instance).setPriority(builder.build());
                return this;
            }

            public Builder setTriggeringConditions(int i10, CommonTypesProto.TriggeringCondition.Builder builder) {
                copyOnWrite();
                ((ThickContent) this.instance).setTriggeringConditions(i10, builder.build());
                return this;
            }

            public Builder setVanillaPayload(VanillaCampaignPayload.Builder builder) {
                copyOnWrite();
                ((ThickContent) this.instance).setVanillaPayload(builder.build());
                return this;
            }

            public Builder addTriggeringConditions(CommonTypesProto.TriggeringCondition.Builder builder) {
                copyOnWrite();
                ((ThickContent) this.instance).addTriggeringConditions(builder.build());
                return this;
            }

            public Builder addTriggeringConditions(int i10, CommonTypesProto.TriggeringCondition.Builder builder) {
                copyOnWrite();
                ((ThickContent) this.instance).addTriggeringConditions(i10, builder.build());
                return this;
            }
        }

        public static final class DataBundleDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }

            private DataBundleDefaultEntryHolder() {
            }
        }

        public enum PayloadCase {
            VANILLA_PAYLOAD(1),
            EXPERIMENTAL_PAYLOAD(2),
            PAYLOAD_NOT_SET(0);

            private final int value;

            PayloadCase(int i10) {
                this.value = i10;
            }

            public static PayloadCase forNumber(int i10) {
                if (i10 == 0) {
                    return PAYLOAD_NOT_SET;
                }
                if (i10 == 1) {
                    return VANILLA_PAYLOAD;
                }
                if (i10 != 2) {
                    return null;
                }
                return EXPERIMENTAL_PAYLOAD;
            }

            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static PayloadCase valueOf(int i10) {
                return forNumber(i10);
            }
        }

        static {
            ThickContent thickContent = new ThickContent();
            DEFAULT_INSTANCE = thickContent;
            GeneratedMessageLite.registerDefaultInstance(ThickContent.class, thickContent);
        }

        private ThickContent() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllTriggeringConditions(Iterable<? extends CommonTypesProto.TriggeringCondition> iterable) {
            ensureTriggeringConditionsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.triggeringConditions_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTriggeringConditions(CommonTypesProto.TriggeringCondition triggeringCondition) {
            triggeringCondition.getClass();
            ensureTriggeringConditionsIsMutable();
            this.triggeringConditions_.add(triggeringCondition);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContent() {
            this.content_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExperimentalPayload() {
            if (this.payloadCase_ == 2) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsTestCampaign() {
            this.isTestCampaign_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPayload() {
            this.payloadCase_ = 0;
            this.payload_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPriority() {
            this.priority_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTriggeringConditions() {
            this.triggeringConditions_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVanillaPayload() {
            if (this.payloadCase_ == 1) {
                this.payloadCase_ = 0;
                this.payload_ = null;
            }
        }

        private void ensureTriggeringConditionsIsMutable() {
            Internal.ProtobufList<CommonTypesProto.TriggeringCondition> protobufList = this.triggeringConditions_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.triggeringConditions_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ThickContent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableDataBundleMap() {
            return internalGetMutableDataBundle();
        }

        private MapFieldLite<String, String> internalGetDataBundle() {
            return this.dataBundle_;
        }

        private MapFieldLite<String, String> internalGetMutableDataBundle() {
            if (!this.dataBundle_.isMutable()) {
                this.dataBundle_ = this.dataBundle_.mutableCopy();
            }
            return this.dataBundle_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeContent(MessagesProto.Content content) {
            content.getClass();
            MessagesProto.Content content2 = this.content_;
            if (content2 == null || content2 == MessagesProto.Content.getDefaultInstance()) {
                this.content_ = content;
            } else {
                this.content_ = MessagesProto.Content.newBuilder(this.content_).mergeFrom((MessagesProto.Content.Builder) content).buildPartial();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeExperimentalPayload(ExperimentalCampaignPayload experimentalCampaignPayload) {
            experimentalCampaignPayload.getClass();
            if (this.payloadCase_ != 2 || this.payload_ == ExperimentalCampaignPayload.getDefaultInstance()) {
                this.payload_ = experimentalCampaignPayload;
            } else {
                this.payload_ = ExperimentalCampaignPayload.newBuilder((ExperimentalCampaignPayload) this.payload_).mergeFrom((ExperimentalCampaignPayload.Builder) experimentalCampaignPayload).buildPartial();
            }
            this.payloadCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePriority(CommonTypesProto.Priority priority) {
            priority.getClass();
            CommonTypesProto.Priority priority2 = this.priority_;
            if (priority2 == null || priority2 == CommonTypesProto.Priority.getDefaultInstance()) {
                this.priority_ = priority;
            } else {
                this.priority_ = CommonTypesProto.Priority.newBuilder(this.priority_).mergeFrom((CommonTypesProto.Priority.Builder) priority).buildPartial();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeVanillaPayload(VanillaCampaignPayload vanillaCampaignPayload) {
            vanillaCampaignPayload.getClass();
            if (this.payloadCase_ != 1 || this.payload_ == VanillaCampaignPayload.getDefaultInstance()) {
                this.payload_ = vanillaCampaignPayload;
            } else {
                this.payload_ = VanillaCampaignPayload.newBuilder((VanillaCampaignPayload) this.payload_).mergeFrom((VanillaCampaignPayload.Builder) vanillaCampaignPayload).buildPartial();
            }
            this.payloadCase_ = 1;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ThickContent parseDelimitedFrom(InputStream inputStream) {
            return (ThickContent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ThickContent parseFrom(ByteBuffer byteBuffer) {
            return (ThickContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ThickContent> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeTriggeringConditions(int i10) {
            ensureTriggeringConditionsIsMutable();
            this.triggeringConditions_.remove(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContent(MessagesProto.Content content) {
            content.getClass();
            this.content_ = content;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentalPayload(ExperimentalCampaignPayload experimentalCampaignPayload) {
            experimentalCampaignPayload.getClass();
            this.payload_ = experimentalCampaignPayload;
            this.payloadCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsTestCampaign(boolean z10) {
            this.isTestCampaign_ = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPriority(CommonTypesProto.Priority priority) {
            priority.getClass();
            this.priority_ = priority;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTriggeringConditions(int i10, CommonTypesProto.TriggeringCondition triggeringCondition) {
            triggeringCondition.getClass();
            ensureTriggeringConditionsIsMutable();
            this.triggeringConditions_.set(i10, triggeringCondition);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVanillaPayload(VanillaCampaignPayload vanillaCampaignPayload) {
            vanillaCampaignPayload.getClass();
            this.payload_ = vanillaCampaignPayload;
            this.payloadCase_ = 1;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public boolean containsDataBundle(String str) {
            str.getClass();
            return internalGetDataBundle().containsKey(str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ThickContent();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\b\u0007\u0001\u0001\u0000\u0001<\u0000\u0002<\u0000\u0003\t\u0004\t\u0005\u001b\u0007\u0007\b2", new Object[]{"payload_", "payloadCase_", VanillaCampaignPayload.class, ExperimentalCampaignPayload.class, "content_", "priority_", "triggeringConditions_", CommonTypesProto.TriggeringCondition.class, "isTestCampaign_", "dataBundle_", DataBundleDefaultEntryHolder.defaultEntry});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ThickContent> parser = PARSER;
                    if (parser == null) {
                        synchronized (ThickContent.class) {
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

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public MessagesProto.Content getContent() {
            MessagesProto.Content content = this.content_;
            return content == null ? MessagesProto.Content.getDefaultInstance() : content;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        @Deprecated
        public Map<String, String> getDataBundle() {
            return getDataBundleMap();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public int getDataBundleCount() {
            return internalGetDataBundle().size();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public Map<String, String> getDataBundleMap() {
            return Collections.unmodifiableMap(internalGetDataBundle());
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public String getDataBundleOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> internalGetDataBundle = internalGetDataBundle();
            return internalGetDataBundle.containsKey(str) ? internalGetDataBundle.get(str) : str2;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public String getDataBundleOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> internalGetDataBundle = internalGetDataBundle();
            if (internalGetDataBundle.containsKey(str)) {
                return internalGetDataBundle.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public ExperimentalCampaignPayload getExperimentalPayload() {
            return this.payloadCase_ == 2 ? (ExperimentalCampaignPayload) this.payload_ : ExperimentalCampaignPayload.getDefaultInstance();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public boolean getIsTestCampaign() {
            return this.isTestCampaign_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public PayloadCase getPayloadCase() {
            return PayloadCase.forNumber(this.payloadCase_);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public CommonTypesProto.Priority getPriority() {
            CommonTypesProto.Priority priority = this.priority_;
            return priority == null ? CommonTypesProto.Priority.getDefaultInstance() : priority;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public CommonTypesProto.TriggeringCondition getTriggeringConditions(int i10) {
            return this.triggeringConditions_.get(i10);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public int getTriggeringConditionsCount() {
            return this.triggeringConditions_.size();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public List<CommonTypesProto.TriggeringCondition> getTriggeringConditionsList() {
            return this.triggeringConditions_;
        }

        public CommonTypesProto.TriggeringConditionOrBuilder getTriggeringConditionsOrBuilder(int i10) {
            return this.triggeringConditions_.get(i10);
        }

        public List<? extends CommonTypesProto.TriggeringConditionOrBuilder> getTriggeringConditionsOrBuilderList() {
            return this.triggeringConditions_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public VanillaCampaignPayload getVanillaPayload() {
            return this.payloadCase_ == 1 ? (VanillaCampaignPayload) this.payload_ : VanillaCampaignPayload.getDefaultInstance();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public boolean hasContent() {
            return this.content_ != null;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public boolean hasExperimentalPayload() {
            return this.payloadCase_ == 2;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public boolean hasPriority() {
            return this.priority_ != null;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.ThickContentOrBuilder
        public boolean hasVanillaPayload() {
            return this.payloadCase_ == 1;
        }

        public static Builder newBuilder(ThickContent thickContent) {
            return DEFAULT_INSTANCE.createBuilder(thickContent);
        }

        public static ThickContent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ThickContent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ThickContent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ThickContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ThickContent parseFrom(ByteString byteString) {
            return (ThickContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTriggeringConditions(int i10, CommonTypesProto.TriggeringCondition triggeringCondition) {
            triggeringCondition.getClass();
            ensureTriggeringConditionsIsMutable();
            this.triggeringConditions_.add(i10, triggeringCondition);
        }

        public static ThickContent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ThickContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ThickContent parseFrom(byte[] bArr) {
            return (ThickContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ThickContent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ThickContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ThickContent parseFrom(InputStream inputStream) {
            return (ThickContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ThickContent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ThickContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ThickContent parseFrom(CodedInputStream codedInputStream) {
            return (ThickContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ThickContent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ThickContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ThickContentOrBuilder extends MessageLiteOrBuilder {
        boolean containsDataBundle(String str);

        MessagesProto.Content getContent();

        @Deprecated
        Map<String, String> getDataBundle();

        int getDataBundleCount();

        Map<String, String> getDataBundleMap();

        String getDataBundleOrDefault(String str, String str2);

        String getDataBundleOrThrow(String str);

        ExperimentalCampaignPayload getExperimentalPayload();

        boolean getIsTestCampaign();

        ThickContent.PayloadCase getPayloadCase();

        CommonTypesProto.Priority getPriority();

        CommonTypesProto.TriggeringCondition getTriggeringConditions(int i10);

        int getTriggeringConditionsCount();

        List<CommonTypesProto.TriggeringCondition> getTriggeringConditionsList();

        VanillaCampaignPayload getVanillaPayload();

        boolean hasContent();

        boolean hasExperimentalPayload();

        boolean hasPriority();

        boolean hasVanillaPayload();
    }

    public static final class VanillaCampaignPayload extends GeneratedMessageLite<VanillaCampaignPayload, Builder> implements VanillaCampaignPayloadOrBuilder {
        public static final int CAMPAIGN_END_TIME_MILLIS_FIELD_NUMBER = 4;
        public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
        public static final int CAMPAIGN_NAME_FIELD_NUMBER = 5;
        public static final int CAMPAIGN_START_TIME_MILLIS_FIELD_NUMBER = 3;
        private static final VanillaCampaignPayload DEFAULT_INSTANCE;
        public static final int EXPERIMENTAL_CAMPAIGN_ID_FIELD_NUMBER = 2;
        private static volatile Parser<VanillaCampaignPayload> PARSER;
        private long campaignEndTimeMillis_;
        private long campaignStartTimeMillis_;
        private String campaignId_ = "";
        private String experimentalCampaignId_ = "";
        private String campaignName_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<VanillaCampaignPayload, Builder> implements VanillaCampaignPayloadOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCampaignEndTimeMillis() {
                copyOnWrite();
                ((VanillaCampaignPayload) this.instance).clearCampaignEndTimeMillis();
                return this;
            }

            public Builder clearCampaignId() {
                copyOnWrite();
                ((VanillaCampaignPayload) this.instance).clearCampaignId();
                return this;
            }

            public Builder clearCampaignName() {
                copyOnWrite();
                ((VanillaCampaignPayload) this.instance).clearCampaignName();
                return this;
            }

            public Builder clearCampaignStartTimeMillis() {
                copyOnWrite();
                ((VanillaCampaignPayload) this.instance).clearCampaignStartTimeMillis();
                return this;
            }

            public Builder clearExperimentalCampaignId() {
                copyOnWrite();
                ((VanillaCampaignPayload) this.instance).clearExperimentalCampaignId();
                return this;
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
            public long getCampaignEndTimeMillis() {
                return ((VanillaCampaignPayload) this.instance).getCampaignEndTimeMillis();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
            public String getCampaignId() {
                return ((VanillaCampaignPayload) this.instance).getCampaignId();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
            public ByteString getCampaignIdBytes() {
                return ((VanillaCampaignPayload) this.instance).getCampaignIdBytes();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
            public String getCampaignName() {
                return ((VanillaCampaignPayload) this.instance).getCampaignName();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
            public ByteString getCampaignNameBytes() {
                return ((VanillaCampaignPayload) this.instance).getCampaignNameBytes();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
            public long getCampaignStartTimeMillis() {
                return ((VanillaCampaignPayload) this.instance).getCampaignStartTimeMillis();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
            public String getExperimentalCampaignId() {
                return ((VanillaCampaignPayload) this.instance).getExperimentalCampaignId();
            }

            @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
            public ByteString getExperimentalCampaignIdBytes() {
                return ((VanillaCampaignPayload) this.instance).getExperimentalCampaignIdBytes();
            }

            public Builder setCampaignEndTimeMillis(long j10) {
                copyOnWrite();
                ((VanillaCampaignPayload) this.instance).setCampaignEndTimeMillis(j10);
                return this;
            }

            public Builder setCampaignId(String str) {
                copyOnWrite();
                ((VanillaCampaignPayload) this.instance).setCampaignId(str);
                return this;
            }

            public Builder setCampaignIdBytes(ByteString byteString) {
                copyOnWrite();
                ((VanillaCampaignPayload) this.instance).setCampaignIdBytes(byteString);
                return this;
            }

            public Builder setCampaignName(String str) {
                copyOnWrite();
                ((VanillaCampaignPayload) this.instance).setCampaignName(str);
                return this;
            }

            public Builder setCampaignNameBytes(ByteString byteString) {
                copyOnWrite();
                ((VanillaCampaignPayload) this.instance).setCampaignNameBytes(byteString);
                return this;
            }

            public Builder setCampaignStartTimeMillis(long j10) {
                copyOnWrite();
                ((VanillaCampaignPayload) this.instance).setCampaignStartTimeMillis(j10);
                return this;
            }

            public Builder setExperimentalCampaignId(String str) {
                copyOnWrite();
                ((VanillaCampaignPayload) this.instance).setExperimentalCampaignId(str);
                return this;
            }

            public Builder setExperimentalCampaignIdBytes(ByteString byteString) {
                copyOnWrite();
                ((VanillaCampaignPayload) this.instance).setExperimentalCampaignIdBytes(byteString);
                return this;
            }

            private Builder() {
                super(VanillaCampaignPayload.DEFAULT_INSTANCE);
            }
        }

        static {
            VanillaCampaignPayload vanillaCampaignPayload = new VanillaCampaignPayload();
            DEFAULT_INSTANCE = vanillaCampaignPayload;
            GeneratedMessageLite.registerDefaultInstance(VanillaCampaignPayload.class, vanillaCampaignPayload);
        }

        private VanillaCampaignPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCampaignEndTimeMillis() {
            this.campaignEndTimeMillis_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCampaignId() {
            this.campaignId_ = getDefaultInstance().getCampaignId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCampaignName() {
            this.campaignName_ = getDefaultInstance().getCampaignName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCampaignStartTimeMillis() {
            this.campaignStartTimeMillis_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExperimentalCampaignId() {
            this.experimentalCampaignId_ = getDefaultInstance().getExperimentalCampaignId();
        }

        public static VanillaCampaignPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static VanillaCampaignPayload parseDelimitedFrom(InputStream inputStream) {
            return (VanillaCampaignPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static VanillaCampaignPayload parseFrom(ByteBuffer byteBuffer) {
            return (VanillaCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<VanillaCampaignPayload> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaignEndTimeMillis(long j10) {
            this.campaignEndTimeMillis_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaignId(String str) {
            str.getClass();
            this.campaignId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaignIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.campaignId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaignName(String str) {
            str.getClass();
            this.campaignName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaignNameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.campaignName_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaignStartTimeMillis(long j10) {
            this.campaignStartTimeMillis_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentalCampaignId(String str) {
            str.getClass();
            this.experimentalCampaignId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentalCampaignIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.experimentalCampaignId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new VanillaCampaignPayload();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004\u0002\u0005Ȉ", new Object[]{"campaignId_", "experimentalCampaignId_", "campaignStartTimeMillis_", "campaignEndTimeMillis_", "campaignName_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<VanillaCampaignPayload> parser = PARSER;
                    if (parser == null) {
                        synchronized (VanillaCampaignPayload.class) {
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

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
        public long getCampaignEndTimeMillis() {
            return this.campaignEndTimeMillis_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
        public String getCampaignId() {
            return this.campaignId_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
        public ByteString getCampaignIdBytes() {
            return ByteString.copyFromUtf8(this.campaignId_);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
        public String getCampaignName() {
            return this.campaignName_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
        public ByteString getCampaignNameBytes() {
            return ByteString.copyFromUtf8(this.campaignName_);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
        public long getCampaignStartTimeMillis() {
            return this.campaignStartTimeMillis_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
        public String getExperimentalCampaignId() {
            return this.experimentalCampaignId_;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.CampaignProto.VanillaCampaignPayloadOrBuilder
        public ByteString getExperimentalCampaignIdBytes() {
            return ByteString.copyFromUtf8(this.experimentalCampaignId_);
        }

        public static Builder newBuilder(VanillaCampaignPayload vanillaCampaignPayload) {
            return DEFAULT_INSTANCE.createBuilder(vanillaCampaignPayload);
        }

        public static VanillaCampaignPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (VanillaCampaignPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static VanillaCampaignPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (VanillaCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static VanillaCampaignPayload parseFrom(ByteString byteString) {
            return (VanillaCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static VanillaCampaignPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (VanillaCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static VanillaCampaignPayload parseFrom(byte[] bArr) {
            return (VanillaCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static VanillaCampaignPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (VanillaCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static VanillaCampaignPayload parseFrom(InputStream inputStream) {
            return (VanillaCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static VanillaCampaignPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (VanillaCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static VanillaCampaignPayload parseFrom(CodedInputStream codedInputStream) {
            return (VanillaCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static VanillaCampaignPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (VanillaCampaignPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface VanillaCampaignPayloadOrBuilder extends MessageLiteOrBuilder {
        long getCampaignEndTimeMillis();

        String getCampaignId();

        ByteString getCampaignIdBytes();

        String getCampaignName();

        ByteString getCampaignNameBytes();

        long getCampaignStartTimeMillis();

        String getExperimentalCampaignId();

        ByteString getExperimentalCampaignIdBytes();
    }

    private CampaignProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
