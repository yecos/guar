package com.google.developers.mobile.targeting.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class ClientSignalsProto {

    /* renamed from: com.google.developers.mobile.targeting.proto.ClientSignalsProto$1, reason: invalid class name */
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

    public static final class AppInstanceClaim extends GeneratedMessageLite<AppInstanceClaim, Builder> implements AppInstanceClaimOrBuilder {
        public static final int APP_INSTANCE_ID_FIELD_NUMBER = 1;
        public static final int APP_INSTANCE_TOKEN_FIELD_NUMBER = 2;
        private static final AppInstanceClaim DEFAULT_INSTANCE;
        public static final int GMP_APP_ID_FIELD_NUMBER = 3;
        private static volatile Parser<AppInstanceClaim> PARSER;
        private String appInstanceId_ = "";
        private String appInstanceToken_ = "";
        private String gmpAppId_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<AppInstanceClaim, Builder> implements AppInstanceClaimOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppInstanceId() {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).clearAppInstanceId();
                return this;
            }

            public Builder clearAppInstanceToken() {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).clearAppInstanceToken();
                return this;
            }

            public Builder clearGmpAppId() {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).clearGmpAppId();
                return this;
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
            public String getAppInstanceId() {
                return ((AppInstanceClaim) this.instance).getAppInstanceId();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
            public ByteString getAppInstanceIdBytes() {
                return ((AppInstanceClaim) this.instance).getAppInstanceIdBytes();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
            public String getAppInstanceToken() {
                return ((AppInstanceClaim) this.instance).getAppInstanceToken();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
            public ByteString getAppInstanceTokenBytes() {
                return ((AppInstanceClaim) this.instance).getAppInstanceTokenBytes();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
            public String getGmpAppId() {
                return ((AppInstanceClaim) this.instance).getGmpAppId();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
            public ByteString getGmpAppIdBytes() {
                return ((AppInstanceClaim) this.instance).getGmpAppIdBytes();
            }

            public Builder setAppInstanceId(String str) {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).setAppInstanceId(str);
                return this;
            }

            public Builder setAppInstanceIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).setAppInstanceIdBytes(byteString);
                return this;
            }

            public Builder setAppInstanceToken(String str) {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).setAppInstanceToken(str);
                return this;
            }

            public Builder setAppInstanceTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).setAppInstanceTokenBytes(byteString);
                return this;
            }

            public Builder setGmpAppId(String str) {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).setGmpAppId(str);
                return this;
            }

            public Builder setGmpAppIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).setGmpAppIdBytes(byteString);
                return this;
            }

            private Builder() {
                super(AppInstanceClaim.DEFAULT_INSTANCE);
            }
        }

        static {
            AppInstanceClaim appInstanceClaim = new AppInstanceClaim();
            DEFAULT_INSTANCE = appInstanceClaim;
            GeneratedMessageLite.registerDefaultInstance(AppInstanceClaim.class, appInstanceClaim);
        }

        private AppInstanceClaim() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppInstanceId() {
            this.appInstanceId_ = getDefaultInstance().getAppInstanceId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppInstanceToken() {
            this.appInstanceToken_ = getDefaultInstance().getAppInstanceToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGmpAppId() {
            this.gmpAppId_ = getDefaultInstance().getGmpAppId();
        }

        public static AppInstanceClaim getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static AppInstanceClaim parseDelimitedFrom(InputStream inputStream) {
            return (AppInstanceClaim) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AppInstanceClaim parseFrom(ByteBuffer byteBuffer) {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<AppInstanceClaim> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppInstanceId(String str) {
            str.getClass();
            this.appInstanceId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppInstanceIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.appInstanceId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppInstanceToken(String str) {
            str.getClass();
            this.appInstanceToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppInstanceTokenBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.appInstanceToken_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGmpAppId(String str) {
            str.getClass();
            this.gmpAppId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGmpAppIdBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.gmpAppId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new AppInstanceClaim();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"appInstanceId_", "appInstanceToken_", "gmpAppId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AppInstanceClaim> parser = PARSER;
                    if (parser == null) {
                        synchronized (AppInstanceClaim.class) {
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

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
        public String getAppInstanceId() {
            return this.appInstanceId_;
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
        public ByteString getAppInstanceIdBytes() {
            return ByteString.copyFromUtf8(this.appInstanceId_);
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
        public String getAppInstanceToken() {
            return this.appInstanceToken_;
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
        public ByteString getAppInstanceTokenBytes() {
            return ByteString.copyFromUtf8(this.appInstanceToken_);
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
        public String getGmpAppId() {
            return this.gmpAppId_;
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.AppInstanceClaimOrBuilder
        public ByteString getGmpAppIdBytes() {
            return ByteString.copyFromUtf8(this.gmpAppId_);
        }

        public static Builder newBuilder(AppInstanceClaim appInstanceClaim) {
            return DEFAULT_INSTANCE.createBuilder(appInstanceClaim);
        }

        public static AppInstanceClaim parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AppInstanceClaim) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AppInstanceClaim parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AppInstanceClaim parseFrom(ByteString byteString) {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AppInstanceClaim parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AppInstanceClaim parseFrom(byte[] bArr) {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AppInstanceClaim parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AppInstanceClaim parseFrom(InputStream inputStream) {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AppInstanceClaim parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AppInstanceClaim parseFrom(CodedInputStream codedInputStream) {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AppInstanceClaim parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface AppInstanceClaimOrBuilder extends MessageLiteOrBuilder {
        String getAppInstanceId();

        ByteString getAppInstanceIdBytes();

        String getAppInstanceToken();

        ByteString getAppInstanceTokenBytes();

        String getGmpAppId();

        ByteString getGmpAppIdBytes();
    }

    public static final class ClientSignals extends GeneratedMessageLite<ClientSignals, Builder> implements ClientSignalsOrBuilder {
        public static final int APP_VERSION_FIELD_NUMBER = 1;
        private static final ClientSignals DEFAULT_INSTANCE;
        public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
        private static volatile Parser<ClientSignals> PARSER = null;
        public static final int PLATFORM_VERSION_FIELD_NUMBER = 2;
        public static final int TIME_ZONE_FIELD_NUMBER = 4;
        private String appVersion_ = "";
        private String platformVersion_ = "";
        private String languageCode_ = "";
        private String timeZone_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<ClientSignals, Builder> implements ClientSignalsOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppVersion() {
                copyOnWrite();
                ((ClientSignals) this.instance).clearAppVersion();
                return this;
            }

            public Builder clearLanguageCode() {
                copyOnWrite();
                ((ClientSignals) this.instance).clearLanguageCode();
                return this;
            }

            public Builder clearPlatformVersion() {
                copyOnWrite();
                ((ClientSignals) this.instance).clearPlatformVersion();
                return this;
            }

            public Builder clearTimeZone() {
                copyOnWrite();
                ((ClientSignals) this.instance).clearTimeZone();
                return this;
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
            public String getAppVersion() {
                return ((ClientSignals) this.instance).getAppVersion();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
            public ByteString getAppVersionBytes() {
                return ((ClientSignals) this.instance).getAppVersionBytes();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
            public String getLanguageCode() {
                return ((ClientSignals) this.instance).getLanguageCode();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
            public ByteString getLanguageCodeBytes() {
                return ((ClientSignals) this.instance).getLanguageCodeBytes();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
            public String getPlatformVersion() {
                return ((ClientSignals) this.instance).getPlatformVersion();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
            public ByteString getPlatformVersionBytes() {
                return ((ClientSignals) this.instance).getPlatformVersionBytes();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
            public String getTimeZone() {
                return ((ClientSignals) this.instance).getTimeZone();
            }

            @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
            public ByteString getTimeZoneBytes() {
                return ((ClientSignals) this.instance).getTimeZoneBytes();
            }

            public Builder setAppVersion(String str) {
                copyOnWrite();
                ((ClientSignals) this.instance).setAppVersion(str);
                return this;
            }

            public Builder setAppVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientSignals) this.instance).setAppVersionBytes(byteString);
                return this;
            }

            public Builder setLanguageCode(String str) {
                copyOnWrite();
                ((ClientSignals) this.instance).setLanguageCode(str);
                return this;
            }

            public Builder setLanguageCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientSignals) this.instance).setLanguageCodeBytes(byteString);
                return this;
            }

            public Builder setPlatformVersion(String str) {
                copyOnWrite();
                ((ClientSignals) this.instance).setPlatformVersion(str);
                return this;
            }

            public Builder setPlatformVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientSignals) this.instance).setPlatformVersionBytes(byteString);
                return this;
            }

            public Builder setTimeZone(String str) {
                copyOnWrite();
                ((ClientSignals) this.instance).setTimeZone(str);
                return this;
            }

            public Builder setTimeZoneBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientSignals) this.instance).setTimeZoneBytes(byteString);
                return this;
            }

            private Builder() {
                super(ClientSignals.DEFAULT_INSTANCE);
            }
        }

        static {
            ClientSignals clientSignals = new ClientSignals();
            DEFAULT_INSTANCE = clientSignals;
            GeneratedMessageLite.registerDefaultInstance(ClientSignals.class, clientSignals);
        }

        private ClientSignals() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppVersion() {
            this.appVersion_ = getDefaultInstance().getAppVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLanguageCode() {
            this.languageCode_ = getDefaultInstance().getLanguageCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPlatformVersion() {
            this.platformVersion_ = getDefaultInstance().getPlatformVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeZone() {
            this.timeZone_ = getDefaultInstance().getTimeZone();
        }

        public static ClientSignals getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ClientSignals parseDelimitedFrom(InputStream inputStream) {
            return (ClientSignals) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClientSignals parseFrom(ByteBuffer byteBuffer) {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ClientSignals> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppVersion(String str) {
            str.getClass();
            this.appVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppVersionBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.appVersion_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLanguageCode(String str) {
            str.getClass();
            this.languageCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLanguageCodeBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.languageCode_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlatformVersion(String str) {
            str.getClass();
            this.platformVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlatformVersionBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.platformVersion_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeZone(String str) {
            str.getClass();
            this.timeZone_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeZoneBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.timeZone_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ClientSignals();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"appVersion_", "platformVersion_", "languageCode_", "timeZone_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ClientSignals> parser = PARSER;
                    if (parser == null) {
                        synchronized (ClientSignals.class) {
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

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
        public String getAppVersion() {
            return this.appVersion_;
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
        public ByteString getAppVersionBytes() {
            return ByteString.copyFromUtf8(this.appVersion_);
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
        public String getLanguageCode() {
            return this.languageCode_;
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
        public ByteString getLanguageCodeBytes() {
            return ByteString.copyFromUtf8(this.languageCode_);
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
        public String getPlatformVersion() {
            return this.platformVersion_;
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
        public ByteString getPlatformVersionBytes() {
            return ByteString.copyFromUtf8(this.platformVersion_);
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
        public String getTimeZone() {
            return this.timeZone_;
        }

        @Override // com.google.developers.mobile.targeting.proto.ClientSignalsProto.ClientSignalsOrBuilder
        public ByteString getTimeZoneBytes() {
            return ByteString.copyFromUtf8(this.timeZone_);
        }

        public static Builder newBuilder(ClientSignals clientSignals) {
            return DEFAULT_INSTANCE.createBuilder(clientSignals);
        }

        public static ClientSignals parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientSignals) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ClientSignals parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ClientSignals parseFrom(ByteString byteString) {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ClientSignals parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ClientSignals parseFrom(byte[] bArr) {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ClientSignals parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ClientSignals parseFrom(InputStream inputStream) {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClientSignals parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ClientSignals parseFrom(CodedInputStream codedInputStream) {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ClientSignals parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ClientSignalsOrBuilder extends MessageLiteOrBuilder {
        String getAppVersion();

        ByteString getAppVersionBytes();

        String getLanguageCode();

        ByteString getLanguageCodeBytes();

        String getPlatformVersion();

        ByteString getPlatformVersionBytes();

        String getTimeZone();

        ByteString getTimeZoneBytes();
    }

    private ClientSignalsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
