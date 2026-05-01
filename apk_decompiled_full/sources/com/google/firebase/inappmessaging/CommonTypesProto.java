package com.google.firebase.inappmessaging;

import com.google.firebase.inappmessaging.MessagesProto;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.type.Date;
import com.google.type.TimeOfDay;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class CommonTypesProto {

    /* renamed from: com.google.firebase.inappmessaging.CommonTypesProto$1, reason: invalid class name */
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

    public enum CampaignState implements Internal.EnumLite {
        UNKNOWN_CAMPAIGN_STATE(0),
        DRAFT(1),
        PUBLISHED(2),
        STOPPED(3),
        DELETED(4),
        UNRECOGNIZED(-1);

        public static final int DELETED_VALUE = 4;
        public static final int DRAFT_VALUE = 1;
        public static final int PUBLISHED_VALUE = 2;
        public static final int STOPPED_VALUE = 3;
        public static final int UNKNOWN_CAMPAIGN_STATE_VALUE = 0;
        private static final Internal.EnumLiteMap<CampaignState> internalValueMap = new Internal.EnumLiteMap<CampaignState>() { // from class: com.google.firebase.inappmessaging.CommonTypesProto.CampaignState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public CampaignState findValueByNumber(int i10) {
                return CampaignState.forNumber(i10);
            }
        };
        private final int value;

        public static final class CampaignStateVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new CampaignStateVerifier();

            private CampaignStateVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i10) {
                return CampaignState.forNumber(i10) != null;
            }
        }

        CampaignState(int i10) {
            this.value = i10;
        }

        public static CampaignState forNumber(int i10) {
            if (i10 == 0) {
                return UNKNOWN_CAMPAIGN_STATE;
            }
            if (i10 == 1) {
                return DRAFT;
            }
            if (i10 == 2) {
                return PUBLISHED;
            }
            if (i10 == 3) {
                return STOPPED;
            }
            if (i10 != 4) {
                return null;
            }
            return DELETED;
        }

        public static Internal.EnumLiteMap<CampaignState> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return CampaignStateVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static CampaignState valueOf(int i10) {
            return forNumber(i10);
        }
    }

    public static final class CampaignTime extends GeneratedMessageLite<CampaignTime, Builder> implements CampaignTimeOrBuilder {
        public static final int DATE_FIELD_NUMBER = 1;
        private static final CampaignTime DEFAULT_INSTANCE;
        private static volatile Parser<CampaignTime> PARSER = null;
        public static final int TIME_FIELD_NUMBER = 2;
        public static final int TIME_ZONE_FIELD_NUMBER = 3;
        private Date date_;
        private String timeZone_ = "";
        private TimeOfDay time_;

        public static final class Builder extends GeneratedMessageLite.Builder<CampaignTime, Builder> implements CampaignTimeOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDate() {
                copyOnWrite();
                ((CampaignTime) this.instance).clearDate();
                return this;
            }

            public Builder clearTime() {
                copyOnWrite();
                ((CampaignTime) this.instance).clearTime();
                return this;
            }

            public Builder clearTimeZone() {
                copyOnWrite();
                ((CampaignTime) this.instance).clearTimeZone();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public Date getDate() {
                return ((CampaignTime) this.instance).getDate();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public TimeOfDay getTime() {
                return ((CampaignTime) this.instance).getTime();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public String getTimeZone() {
                return ((CampaignTime) this.instance).getTimeZone();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public ByteString getTimeZoneBytes() {
                return ((CampaignTime) this.instance).getTimeZoneBytes();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public boolean hasDate() {
                return ((CampaignTime) this.instance).hasDate();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public boolean hasTime() {
                return ((CampaignTime) this.instance).hasTime();
            }

            public Builder mergeDate(Date date) {
                copyOnWrite();
                ((CampaignTime) this.instance).mergeDate(date);
                return this;
            }

            public Builder mergeTime(TimeOfDay timeOfDay) {
                copyOnWrite();
                ((CampaignTime) this.instance).mergeTime(timeOfDay);
                return this;
            }

            public Builder setDate(Date date) {
                copyOnWrite();
                ((CampaignTime) this.instance).setDate(date);
                return this;
            }

            public Builder setTime(TimeOfDay timeOfDay) {
                copyOnWrite();
                ((CampaignTime) this.instance).setTime(timeOfDay);
                return this;
            }

            public Builder setTimeZone(String str) {
                copyOnWrite();
                ((CampaignTime) this.instance).setTimeZone(str);
                return this;
            }

            public Builder setTimeZoneBytes(ByteString byteString) {
                copyOnWrite();
                ((CampaignTime) this.instance).setTimeZoneBytes(byteString);
                return this;
            }

            private Builder() {
                super(CampaignTime.DEFAULT_INSTANCE);
            }

            public Builder setDate(Date.Builder builder) {
                copyOnWrite();
                ((CampaignTime) this.instance).setDate(builder.build());
                return this;
            }

            public Builder setTime(TimeOfDay.Builder builder) {
                copyOnWrite();
                ((CampaignTime) this.instance).setTime(builder.build());
                return this;
            }
        }

        static {
            CampaignTime campaignTime = new CampaignTime();
            DEFAULT_INSTANCE = campaignTime;
            GeneratedMessageLite.registerDefaultInstance(CampaignTime.class, campaignTime);
        }

        private CampaignTime() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDate() {
            this.date_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.time_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeZone() {
            this.timeZone_ = getDefaultInstance().getTimeZone();
        }

        public static CampaignTime getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDate(Date date) {
            date.getClass();
            Date date2 = this.date_;
            if (date2 == null || date2 == Date.getDefaultInstance()) {
                this.date_ = date;
            } else {
                this.date_ = Date.newBuilder(this.date_).mergeFrom((Date.Builder) date).buildPartial();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTime(TimeOfDay timeOfDay) {
            timeOfDay.getClass();
            TimeOfDay timeOfDay2 = this.time_;
            if (timeOfDay2 == null || timeOfDay2 == TimeOfDay.getDefaultInstance()) {
                this.time_ = timeOfDay;
            } else {
                this.time_ = TimeOfDay.newBuilder(this.time_).mergeFrom((TimeOfDay.Builder) timeOfDay).buildPartial();
            }
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static CampaignTime parseDelimitedFrom(InputStream inputStream) {
            return (CampaignTime) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CampaignTime parseFrom(ByteBuffer byteBuffer) {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<CampaignTime> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDate(Date date) {
            date.getClass();
            this.date_ = date;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(TimeOfDay timeOfDay) {
            timeOfDay.getClass();
            this.time_ = timeOfDay;
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
                    return new CampaignTime();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003Ȉ", new Object[]{"date_", "time_", "timeZone_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<CampaignTime> parser = PARSER;
                    if (parser == null) {
                        synchronized (CampaignTime.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public Date getDate() {
            Date date = this.date_;
            return date == null ? Date.getDefaultInstance() : date;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public TimeOfDay getTime() {
            TimeOfDay timeOfDay = this.time_;
            return timeOfDay == null ? TimeOfDay.getDefaultInstance() : timeOfDay;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public String getTimeZone() {
            return this.timeZone_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public ByteString getTimeZoneBytes() {
            return ByteString.copyFromUtf8(this.timeZone_);
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public boolean hasDate() {
            return this.date_ != null;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public boolean hasTime() {
            return this.time_ != null;
        }

        public static Builder newBuilder(CampaignTime campaignTime) {
            return DEFAULT_INSTANCE.createBuilder(campaignTime);
        }

        public static CampaignTime parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CampaignTime) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CampaignTime parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CampaignTime parseFrom(ByteString byteString) {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CampaignTime parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CampaignTime parseFrom(byte[] bArr) {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CampaignTime parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CampaignTime parseFrom(InputStream inputStream) {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CampaignTime parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CampaignTime parseFrom(CodedInputStream codedInputStream) {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CampaignTime parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface CampaignTimeOrBuilder extends MessageLiteOrBuilder {
        Date getDate();

        TimeOfDay getTime();

        String getTimeZone();

        ByteString getTimeZoneBytes();

        boolean hasDate();

        boolean hasTime();
    }

    public static final class DailyAnalyticsSummary extends GeneratedMessageLite<DailyAnalyticsSummary, Builder> implements DailyAnalyticsSummaryOrBuilder {
        public static final int CLICKS_FIELD_NUMBER = 3;
        private static final DailyAnalyticsSummary DEFAULT_INSTANCE;
        public static final int ERRORS_FIELD_NUMBER = 4;
        public static final int IMPRESSIONS_FIELD_NUMBER = 2;
        private static volatile Parser<DailyAnalyticsSummary> PARSER = null;
        public static final int START_OF_DAY_MILLIS_FIELD_NUMBER = 1;
        private int clicks_;
        private int errors_;
        private int impressions_;
        private long startOfDayMillis_;

        public static final class Builder extends GeneratedMessageLite.Builder<DailyAnalyticsSummary, Builder> implements DailyAnalyticsSummaryOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearClicks() {
                copyOnWrite();
                ((DailyAnalyticsSummary) this.instance).clearClicks();
                return this;
            }

            public Builder clearErrors() {
                copyOnWrite();
                ((DailyAnalyticsSummary) this.instance).clearErrors();
                return this;
            }

            public Builder clearImpressions() {
                copyOnWrite();
                ((DailyAnalyticsSummary) this.instance).clearImpressions();
                return this;
            }

            public Builder clearStartOfDayMillis() {
                copyOnWrite();
                ((DailyAnalyticsSummary) this.instance).clearStartOfDayMillis();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
            public int getClicks() {
                return ((DailyAnalyticsSummary) this.instance).getClicks();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
            public int getErrors() {
                return ((DailyAnalyticsSummary) this.instance).getErrors();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
            public int getImpressions() {
                return ((DailyAnalyticsSummary) this.instance).getImpressions();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
            public long getStartOfDayMillis() {
                return ((DailyAnalyticsSummary) this.instance).getStartOfDayMillis();
            }

            public Builder setClicks(int i10) {
                copyOnWrite();
                ((DailyAnalyticsSummary) this.instance).setClicks(i10);
                return this;
            }

            public Builder setErrors(int i10) {
                copyOnWrite();
                ((DailyAnalyticsSummary) this.instance).setErrors(i10);
                return this;
            }

            public Builder setImpressions(int i10) {
                copyOnWrite();
                ((DailyAnalyticsSummary) this.instance).setImpressions(i10);
                return this;
            }

            public Builder setStartOfDayMillis(long j10) {
                copyOnWrite();
                ((DailyAnalyticsSummary) this.instance).setStartOfDayMillis(j10);
                return this;
            }

            private Builder() {
                super(DailyAnalyticsSummary.DEFAULT_INSTANCE);
            }
        }

        static {
            DailyAnalyticsSummary dailyAnalyticsSummary = new DailyAnalyticsSummary();
            DEFAULT_INSTANCE = dailyAnalyticsSummary;
            GeneratedMessageLite.registerDefaultInstance(DailyAnalyticsSummary.class, dailyAnalyticsSummary);
        }

        private DailyAnalyticsSummary() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClicks() {
            this.clicks_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrors() {
            this.errors_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearImpressions() {
            this.impressions_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartOfDayMillis() {
            this.startOfDayMillis_ = 0L;
        }

        public static DailyAnalyticsSummary getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static DailyAnalyticsSummary parseDelimitedFrom(InputStream inputStream) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DailyAnalyticsSummary parseFrom(ByteBuffer byteBuffer) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<DailyAnalyticsSummary> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClicks(int i10) {
            this.clicks_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrors(int i10) {
            this.errors_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImpressions(int i10) {
            this.impressions_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartOfDayMillis(long j10) {
            this.startOfDayMillis_ = j10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new DailyAnalyticsSummary();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002\u0004\u0003\u0004\u0004\u0004", new Object[]{"startOfDayMillis_", "impressions_", "clicks_", "errors_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DailyAnalyticsSummary> parser = PARSER;
                    if (parser == null) {
                        synchronized (DailyAnalyticsSummary.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
        public int getClicks() {
            return this.clicks_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
        public int getErrors() {
            return this.errors_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
        public int getImpressions() {
            return this.impressions_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
        public long getStartOfDayMillis() {
            return this.startOfDayMillis_;
        }

        public static Builder newBuilder(DailyAnalyticsSummary dailyAnalyticsSummary) {
            return DEFAULT_INSTANCE.createBuilder(dailyAnalyticsSummary);
        }

        public static DailyAnalyticsSummary parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DailyAnalyticsSummary parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DailyAnalyticsSummary parseFrom(ByteString byteString) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DailyAnalyticsSummary parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DailyAnalyticsSummary parseFrom(byte[] bArr) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DailyAnalyticsSummary parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DailyAnalyticsSummary parseFrom(InputStream inputStream) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DailyAnalyticsSummary parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DailyAnalyticsSummary parseFrom(CodedInputStream codedInputStream) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DailyAnalyticsSummary parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface DailyAnalyticsSummaryOrBuilder extends MessageLiteOrBuilder {
        int getClicks();

        int getErrors();

        int getImpressions();

        long getStartOfDayMillis();
    }

    public static final class DailyConversionSummary extends GeneratedMessageLite<DailyConversionSummary, Builder> implements DailyConversionSummaryOrBuilder {
        public static final int CONVERSIONS_FIELD_NUMBER = 2;
        private static final DailyConversionSummary DEFAULT_INSTANCE;
        private static volatile Parser<DailyConversionSummary> PARSER = null;
        public static final int START_OF_DAY_MILLIS_FIELD_NUMBER = 1;
        private int conversions_;
        private long startOfDayMillis_;

        public static final class Builder extends GeneratedMessageLite.Builder<DailyConversionSummary, Builder> implements DailyConversionSummaryOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearConversions() {
                copyOnWrite();
                ((DailyConversionSummary) this.instance).clearConversions();
                return this;
            }

            public Builder clearStartOfDayMillis() {
                copyOnWrite();
                ((DailyConversionSummary) this.instance).clearStartOfDayMillis();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummaryOrBuilder
            public int getConversions() {
                return ((DailyConversionSummary) this.instance).getConversions();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummaryOrBuilder
            public long getStartOfDayMillis() {
                return ((DailyConversionSummary) this.instance).getStartOfDayMillis();
            }

            public Builder setConversions(int i10) {
                copyOnWrite();
                ((DailyConversionSummary) this.instance).setConversions(i10);
                return this;
            }

            public Builder setStartOfDayMillis(long j10) {
                copyOnWrite();
                ((DailyConversionSummary) this.instance).setStartOfDayMillis(j10);
                return this;
            }

            private Builder() {
                super(DailyConversionSummary.DEFAULT_INSTANCE);
            }
        }

        static {
            DailyConversionSummary dailyConversionSummary = new DailyConversionSummary();
            DEFAULT_INSTANCE = dailyConversionSummary;
            GeneratedMessageLite.registerDefaultInstance(DailyConversionSummary.class, dailyConversionSummary);
        }

        private DailyConversionSummary() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearConversions() {
            this.conversions_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartOfDayMillis() {
            this.startOfDayMillis_ = 0L;
        }

        public static DailyConversionSummary getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static DailyConversionSummary parseDelimitedFrom(InputStream inputStream) {
            return (DailyConversionSummary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DailyConversionSummary parseFrom(ByteBuffer byteBuffer) {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<DailyConversionSummary> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setConversions(int i10) {
            this.conversions_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartOfDayMillis(long j10) {
            this.startOfDayMillis_ = j10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new DailyConversionSummary();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"startOfDayMillis_", "conversions_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DailyConversionSummary> parser = PARSER;
                    if (parser == null) {
                        synchronized (DailyConversionSummary.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummaryOrBuilder
        public int getConversions() {
            return this.conversions_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummaryOrBuilder
        public long getStartOfDayMillis() {
            return this.startOfDayMillis_;
        }

        public static Builder newBuilder(DailyConversionSummary dailyConversionSummary) {
            return DEFAULT_INSTANCE.createBuilder(dailyConversionSummary);
        }

        public static DailyConversionSummary parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyConversionSummary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DailyConversionSummary parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DailyConversionSummary parseFrom(ByteString byteString) {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DailyConversionSummary parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DailyConversionSummary parseFrom(byte[] bArr) {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DailyConversionSummary parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DailyConversionSummary parseFrom(InputStream inputStream) {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DailyConversionSummary parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DailyConversionSummary parseFrom(CodedInputStream codedInputStream) {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DailyConversionSummary parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface DailyConversionSummaryOrBuilder extends MessageLiteOrBuilder {
        int getConversions();

        long getStartOfDayMillis();
    }

    public static final class Event extends GeneratedMessageLite<Event, Builder> implements EventOrBuilder {
        public static final int COUNT_FIELD_NUMBER = 5;
        private static final Event DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 2;
        private static volatile Parser<Event> PARSER = null;
        public static final int PREVIOUS_TIMESTAMP_MILLIS_FIELD_NUMBER = 4;
        public static final int TIMESTAMP_MILLIS_FIELD_NUMBER = 3;
        public static final int TRIGGER_PARAMS_FIELD_NUMBER = 1;
        private int count_;
        private long previousTimestampMillis_;
        private long timestampMillis_;
        private Internal.ProtobufList<TriggerParam> triggerParams_ = GeneratedMessageLite.emptyProtobufList();
        private String name_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<Event, Builder> implements EventOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllTriggerParams(Iterable<? extends TriggerParam> iterable) {
                copyOnWrite();
                ((Event) this.instance).addAllTriggerParams(iterable);
                return this;
            }

            public Builder addTriggerParams(TriggerParam triggerParam) {
                copyOnWrite();
                ((Event) this.instance).addTriggerParams(triggerParam);
                return this;
            }

            public Builder clearCount() {
                copyOnWrite();
                ((Event) this.instance).clearCount();
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((Event) this.instance).clearName();
                return this;
            }

            public Builder clearPreviousTimestampMillis() {
                copyOnWrite();
                ((Event) this.instance).clearPreviousTimestampMillis();
                return this;
            }

            public Builder clearTimestampMillis() {
                copyOnWrite();
                ((Event) this.instance).clearTimestampMillis();
                return this;
            }

            public Builder clearTriggerParams() {
                copyOnWrite();
                ((Event) this.instance).clearTriggerParams();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public int getCount() {
                return ((Event) this.instance).getCount();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public String getName() {
                return ((Event) this.instance).getName();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public ByteString getNameBytes() {
                return ((Event) this.instance).getNameBytes();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public long getPreviousTimestampMillis() {
                return ((Event) this.instance).getPreviousTimestampMillis();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public long getTimestampMillis() {
                return ((Event) this.instance).getTimestampMillis();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public TriggerParam getTriggerParams(int i10) {
                return ((Event) this.instance).getTriggerParams(i10);
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public int getTriggerParamsCount() {
                return ((Event) this.instance).getTriggerParamsCount();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public List<TriggerParam> getTriggerParamsList() {
                return Collections.unmodifiableList(((Event) this.instance).getTriggerParamsList());
            }

            public Builder removeTriggerParams(int i10) {
                copyOnWrite();
                ((Event) this.instance).removeTriggerParams(i10);
                return this;
            }

            public Builder setCount(int i10) {
                copyOnWrite();
                ((Event) this.instance).setCount(i10);
                return this;
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((Event) this.instance).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((Event) this.instance).setNameBytes(byteString);
                return this;
            }

            public Builder setPreviousTimestampMillis(long j10) {
                copyOnWrite();
                ((Event) this.instance).setPreviousTimestampMillis(j10);
                return this;
            }

            public Builder setTimestampMillis(long j10) {
                copyOnWrite();
                ((Event) this.instance).setTimestampMillis(j10);
                return this;
            }

            public Builder setTriggerParams(int i10, TriggerParam triggerParam) {
                copyOnWrite();
                ((Event) this.instance).setTriggerParams(i10, triggerParam);
                return this;
            }

            private Builder() {
                super(Event.DEFAULT_INSTANCE);
            }

            public Builder addTriggerParams(int i10, TriggerParam triggerParam) {
                copyOnWrite();
                ((Event) this.instance).addTriggerParams(i10, triggerParam);
                return this;
            }

            public Builder setTriggerParams(int i10, TriggerParam.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setTriggerParams(i10, builder.build());
                return this;
            }

            public Builder addTriggerParams(TriggerParam.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).addTriggerParams(builder.build());
                return this;
            }

            public Builder addTriggerParams(int i10, TriggerParam.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).addTriggerParams(i10, builder.build());
                return this;
            }
        }

        static {
            Event event = new Event();
            DEFAULT_INSTANCE = event;
            GeneratedMessageLite.registerDefaultInstance(Event.class, event);
        }

        private Event() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllTriggerParams(Iterable<? extends TriggerParam> iterable) {
            ensureTriggerParamsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.triggerParams_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTriggerParams(TriggerParam triggerParam) {
            triggerParam.getClass();
            ensureTriggerParamsIsMutable();
            this.triggerParams_.add(triggerParam);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCount() {
            this.count_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPreviousTimestampMillis() {
            this.previousTimestampMillis_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimestampMillis() {
            this.timestampMillis_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTriggerParams() {
            this.triggerParams_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureTriggerParamsIsMutable() {
            Internal.ProtobufList<TriggerParam> protobufList = this.triggerParams_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.triggerParams_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static Event getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Event parseDelimitedFrom(InputStream inputStream) {
            return (Event) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Event parseFrom(ByteBuffer byteBuffer) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Event> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeTriggerParams(int i10) {
            ensureTriggerParamsIsMutable();
            this.triggerParams_.remove(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCount(int i10) {
            this.count_ = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            str.getClass();
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.name_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPreviousTimestampMillis(long j10) {
            this.previousTimestampMillis_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimestampMillis(long j10) {
            this.timestampMillis_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTriggerParams(int i10, TriggerParam triggerParam) {
            triggerParam.getClass();
            ensureTriggerParamsIsMutable();
            this.triggerParams_.set(i10, triggerParam);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Event();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002Ȉ\u0003\u0002\u0004\u0002\u0005\u0004", new Object[]{"triggerParams_", TriggerParam.class, "name_", "timestampMillis_", "previousTimestampMillis_", "count_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Event> parser = PARSER;
                    if (parser == null) {
                        synchronized (Event.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public long getPreviousTimestampMillis() {
            return this.previousTimestampMillis_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public long getTimestampMillis() {
            return this.timestampMillis_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public TriggerParam getTriggerParams(int i10) {
            return this.triggerParams_.get(i10);
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public int getTriggerParamsCount() {
            return this.triggerParams_.size();
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public List<TriggerParam> getTriggerParamsList() {
            return this.triggerParams_;
        }

        public TriggerParamOrBuilder getTriggerParamsOrBuilder(int i10) {
            return this.triggerParams_.get(i10);
        }

        public List<? extends TriggerParamOrBuilder> getTriggerParamsOrBuilderList() {
            return this.triggerParams_;
        }

        public static Builder newBuilder(Event event) {
            return DEFAULT_INSTANCE.createBuilder(event);
        }

        public static Event parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Event parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Event parseFrom(ByteString byteString) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTriggerParams(int i10, TriggerParam triggerParam) {
            triggerParam.getClass();
            ensureTriggerParamsIsMutable();
            this.triggerParams_.add(i10, triggerParam);
        }

        public static Event parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Event parseFrom(byte[] bArr) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Event parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Event parseFrom(InputStream inputStream) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Event parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Event parseFrom(CodedInputStream codedInputStream) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Event parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface EventOrBuilder extends MessageLiteOrBuilder {
        int getCount();

        String getName();

        ByteString getNameBytes();

        long getPreviousTimestampMillis();

        long getTimestampMillis();

        TriggerParam getTriggerParams(int i10);

        int getTriggerParamsCount();

        List<TriggerParam> getTriggerParamsList();
    }

    public static final class ExperimentVariant extends GeneratedMessageLite<ExperimentVariant, Builder> implements ExperimentVariantOrBuilder {
        public static final int CONTENT_FIELD_NUMBER = 2;
        private static final ExperimentVariant DEFAULT_INSTANCE;
        public static final int INDEX_FIELD_NUMBER = 1;
        private static volatile Parser<ExperimentVariant> PARSER;
        private MessagesProto.Content content_;
        private int index_;

        public static final class Builder extends GeneratedMessageLite.Builder<ExperimentVariant, Builder> implements ExperimentVariantOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearContent() {
                copyOnWrite();
                ((ExperimentVariant) this.instance).clearContent();
                return this;
            }

            public Builder clearIndex() {
                copyOnWrite();
                ((ExperimentVariant) this.instance).clearIndex();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
            public MessagesProto.Content getContent() {
                return ((ExperimentVariant) this.instance).getContent();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
            public int getIndex() {
                return ((ExperimentVariant) this.instance).getIndex();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
            public boolean hasContent() {
                return ((ExperimentVariant) this.instance).hasContent();
            }

            public Builder mergeContent(MessagesProto.Content content) {
                copyOnWrite();
                ((ExperimentVariant) this.instance).mergeContent(content);
                return this;
            }

            public Builder setContent(MessagesProto.Content content) {
                copyOnWrite();
                ((ExperimentVariant) this.instance).setContent(content);
                return this;
            }

            public Builder setIndex(int i10) {
                copyOnWrite();
                ((ExperimentVariant) this.instance).setIndex(i10);
                return this;
            }

            private Builder() {
                super(ExperimentVariant.DEFAULT_INSTANCE);
            }

            public Builder setContent(MessagesProto.Content.Builder builder) {
                copyOnWrite();
                ((ExperimentVariant) this.instance).setContent(builder.build());
                return this;
            }
        }

        static {
            ExperimentVariant experimentVariant = new ExperimentVariant();
            DEFAULT_INSTANCE = experimentVariant;
            GeneratedMessageLite.registerDefaultInstance(ExperimentVariant.class, experimentVariant);
        }

        private ExperimentVariant() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContent() {
            this.content_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIndex() {
            this.index_ = 0;
        }

        public static ExperimentVariant getDefaultInstance() {
            return DEFAULT_INSTANCE;
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

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ExperimentVariant parseDelimitedFrom(InputStream inputStream) {
            return (ExperimentVariant) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentVariant parseFrom(ByteBuffer byteBuffer) {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ExperimentVariant> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContent(MessagesProto.Content content) {
            content.getClass();
            this.content_ = content;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIndex(int i10) {
            this.index_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExperimentVariant();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\t", new Object[]{"index_", "content_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ExperimentVariant> parser = PARSER;
                    if (parser == null) {
                        synchronized (ExperimentVariant.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
        public MessagesProto.Content getContent() {
            MessagesProto.Content content = this.content_;
            return content == null ? MessagesProto.Content.getDefaultInstance() : content;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
        public boolean hasContent() {
            return this.content_ != null;
        }

        public static Builder newBuilder(ExperimentVariant experimentVariant) {
            return DEFAULT_INSTANCE.createBuilder(experimentVariant);
        }

        public static ExperimentVariant parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentVariant) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentVariant parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ExperimentVariant parseFrom(ByteString byteString) {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ExperimentVariant parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExperimentVariant parseFrom(byte[] bArr) {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ExperimentVariant parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ExperimentVariant parseFrom(InputStream inputStream) {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentVariant parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentVariant parseFrom(CodedInputStream codedInputStream) {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExperimentVariant parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ExperimentVariantOrBuilder extends MessageLiteOrBuilder {
        MessagesProto.Content getContent();

        int getIndex();

        boolean hasContent();
    }

    public enum ExperimentalCampaignState implements Internal.EnumLite {
        UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE(0),
        EXPERIMENT_DRAFT(1),
        EXPERIMENT_RUNNING(2),
        EXPERIMENT_STOPPED(3),
        EXPERIMENT_ROLLED_OUT(4),
        UNRECOGNIZED(-1);

        public static final int EXPERIMENT_DRAFT_VALUE = 1;
        public static final int EXPERIMENT_ROLLED_OUT_VALUE = 4;
        public static final int EXPERIMENT_RUNNING_VALUE = 2;
        public static final int EXPERIMENT_STOPPED_VALUE = 3;
        public static final int UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE_VALUE = 0;
        private static final Internal.EnumLiteMap<ExperimentalCampaignState> internalValueMap = new Internal.EnumLiteMap<ExperimentalCampaignState>() { // from class: com.google.firebase.inappmessaging.CommonTypesProto.ExperimentalCampaignState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ExperimentalCampaignState findValueByNumber(int i10) {
                return ExperimentalCampaignState.forNumber(i10);
            }
        };
        private final int value;

        public static final class ExperimentalCampaignStateVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new ExperimentalCampaignStateVerifier();

            private ExperimentalCampaignStateVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i10) {
                return ExperimentalCampaignState.forNumber(i10) != null;
            }
        }

        ExperimentalCampaignState(int i10) {
            this.value = i10;
        }

        public static ExperimentalCampaignState forNumber(int i10) {
            if (i10 == 0) {
                return UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE;
            }
            if (i10 == 1) {
                return EXPERIMENT_DRAFT;
            }
            if (i10 == 2) {
                return EXPERIMENT_RUNNING;
            }
            if (i10 == 3) {
                return EXPERIMENT_STOPPED;
            }
            if (i10 != 4) {
                return null;
            }
            return EXPERIMENT_ROLLED_OUT;
        }

        public static Internal.EnumLiteMap<ExperimentalCampaignState> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return ExperimentalCampaignStateVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ExperimentalCampaignState valueOf(int i10) {
            return forNumber(i10);
        }
    }

    public static final class Priority extends GeneratedMessageLite<Priority, Builder> implements PriorityOrBuilder {
        private static final Priority DEFAULT_INSTANCE;
        private static volatile Parser<Priority> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 1;
        private int value_;

        public static final class Builder extends GeneratedMessageLite.Builder<Priority, Builder> implements PriorityOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearValue() {
                copyOnWrite();
                ((Priority) this.instance).clearValue();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.PriorityOrBuilder
            public int getValue() {
                return ((Priority) this.instance).getValue();
            }

            public Builder setValue(int i10) {
                copyOnWrite();
                ((Priority) this.instance).setValue(i10);
                return this;
            }

            private Builder() {
                super(Priority.DEFAULT_INSTANCE);
            }
        }

        static {
            Priority priority = new Priority();
            DEFAULT_INSTANCE = priority;
            GeneratedMessageLite.registerDefaultInstance(Priority.class, priority);
        }

        private Priority() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.value_ = 0;
        }

        public static Priority getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Priority parseDelimitedFrom(InputStream inputStream) {
            return (Priority) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Priority parseFrom(ByteBuffer byteBuffer) {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Priority> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(int i10) {
            this.value_ = i10;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Priority();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Priority> parser = PARSER;
                    if (parser == null) {
                        synchronized (Priority.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.PriorityOrBuilder
        public int getValue() {
            return this.value_;
        }

        public static Builder newBuilder(Priority priority) {
            return DEFAULT_INSTANCE.createBuilder(priority);
        }

        public static Priority parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Priority) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Priority parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Priority parseFrom(ByteString byteString) {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Priority parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Priority parseFrom(byte[] bArr) {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Priority parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Priority parseFrom(InputStream inputStream) {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Priority parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Priority parseFrom(CodedInputStream codedInputStream) {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Priority parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface PriorityOrBuilder extends MessageLiteOrBuilder {
        int getValue();
    }

    public static final class ScionConversionEvent extends GeneratedMessageLite<ScionConversionEvent, Builder> implements ScionConversionEventOrBuilder {
        private static final ScionConversionEvent DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<ScionConversionEvent> PARSER;
        private String name_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<ScionConversionEvent, Builder> implements ScionConversionEventOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearName() {
                copyOnWrite();
                ((ScionConversionEvent) this.instance).clearName();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEventOrBuilder
            public String getName() {
                return ((ScionConversionEvent) this.instance).getName();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEventOrBuilder
            public ByteString getNameBytes() {
                return ((ScionConversionEvent) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((ScionConversionEvent) this.instance).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((ScionConversionEvent) this.instance).setNameBytes(byteString);
                return this;
            }

            private Builder() {
                super(ScionConversionEvent.DEFAULT_INSTANCE);
            }
        }

        static {
            ScionConversionEvent scionConversionEvent = new ScionConversionEvent();
            DEFAULT_INSTANCE = scionConversionEvent;
            GeneratedMessageLite.registerDefaultInstance(ScionConversionEvent.class, scionConversionEvent);
        }

        private ScionConversionEvent() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        public static ScionConversionEvent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ScionConversionEvent parseDelimitedFrom(InputStream inputStream) {
            return (ScionConversionEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ScionConversionEvent parseFrom(ByteBuffer byteBuffer) {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ScionConversionEvent> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            str.getClass();
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.name_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ScionConversionEvent();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"name_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ScionConversionEvent> parser = PARSER;
                    if (parser == null) {
                        synchronized (ScionConversionEvent.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEventOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEventOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        public static Builder newBuilder(ScionConversionEvent scionConversionEvent) {
            return DEFAULT_INSTANCE.createBuilder(scionConversionEvent);
        }

        public static ScionConversionEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ScionConversionEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ScionConversionEvent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ScionConversionEvent parseFrom(ByteString byteString) {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ScionConversionEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ScionConversionEvent parseFrom(byte[] bArr) {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ScionConversionEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ScionConversionEvent parseFrom(InputStream inputStream) {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ScionConversionEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ScionConversionEvent parseFrom(CodedInputStream codedInputStream) {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ScionConversionEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ScionConversionEventOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();
    }

    public enum Trigger implements Internal.EnumLite {
        UNKNOWN_TRIGGER(0),
        APP_LAUNCH(1),
        ON_FOREGROUND(2),
        UNRECOGNIZED(-1);

        public static final int APP_LAUNCH_VALUE = 1;
        public static final int ON_FOREGROUND_VALUE = 2;
        public static final int UNKNOWN_TRIGGER_VALUE = 0;
        private static final Internal.EnumLiteMap<Trigger> internalValueMap = new Internal.EnumLiteMap<Trigger>() { // from class: com.google.firebase.inappmessaging.CommonTypesProto.Trigger.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Trigger findValueByNumber(int i10) {
                return Trigger.forNumber(i10);
            }
        };
        private final int value;

        public static final class TriggerVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new TriggerVerifier();

            private TriggerVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i10) {
                return Trigger.forNumber(i10) != null;
            }
        }

        Trigger(int i10) {
            this.value = i10;
        }

        public static Trigger forNumber(int i10) {
            if (i10 == 0) {
                return UNKNOWN_TRIGGER;
            }
            if (i10 == 1) {
                return APP_LAUNCH;
            }
            if (i10 != 2) {
                return null;
            }
            return ON_FOREGROUND;
        }

        public static Internal.EnumLiteMap<Trigger> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return TriggerVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static Trigger valueOf(int i10) {
            return forNumber(i10);
        }
    }

    public static final class TriggerParam extends GeneratedMessageLite<TriggerParam, Builder> implements TriggerParamOrBuilder {
        private static final TriggerParam DEFAULT_INSTANCE;
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 5;
        public static final int FLOAT_VALUE_FIELD_NUMBER = 4;
        public static final int INT_VALUE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<TriggerParam> PARSER = null;
        public static final int STRING_VALUE_FIELD_NUMBER = 2;
        private double doubleValue_;
        private float floatValue_;
        private long intValue_;
        private String name_ = "";
        private String stringValue_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<TriggerParam, Builder> implements TriggerParamOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDoubleValue() {
                copyOnWrite();
                ((TriggerParam) this.instance).clearDoubleValue();
                return this;
            }

            public Builder clearFloatValue() {
                copyOnWrite();
                ((TriggerParam) this.instance).clearFloatValue();
                return this;
            }

            public Builder clearIntValue() {
                copyOnWrite();
                ((TriggerParam) this.instance).clearIntValue();
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((TriggerParam) this.instance).clearName();
                return this;
            }

            public Builder clearStringValue() {
                copyOnWrite();
                ((TriggerParam) this.instance).clearStringValue();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public double getDoubleValue() {
                return ((TriggerParam) this.instance).getDoubleValue();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public float getFloatValue() {
                return ((TriggerParam) this.instance).getFloatValue();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public long getIntValue() {
                return ((TriggerParam) this.instance).getIntValue();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public String getName() {
                return ((TriggerParam) this.instance).getName();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public ByteString getNameBytes() {
                return ((TriggerParam) this.instance).getNameBytes();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public String getStringValue() {
                return ((TriggerParam) this.instance).getStringValue();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public ByteString getStringValueBytes() {
                return ((TriggerParam) this.instance).getStringValueBytes();
            }

            public Builder setDoubleValue(double d10) {
                copyOnWrite();
                ((TriggerParam) this.instance).setDoubleValue(d10);
                return this;
            }

            public Builder setFloatValue(float f10) {
                copyOnWrite();
                ((TriggerParam) this.instance).setFloatValue(f10);
                return this;
            }

            public Builder setIntValue(long j10) {
                copyOnWrite();
                ((TriggerParam) this.instance).setIntValue(j10);
                return this;
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((TriggerParam) this.instance).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((TriggerParam) this.instance).setNameBytes(byteString);
                return this;
            }

            public Builder setStringValue(String str) {
                copyOnWrite();
                ((TriggerParam) this.instance).setStringValue(str);
                return this;
            }

            public Builder setStringValueBytes(ByteString byteString) {
                copyOnWrite();
                ((TriggerParam) this.instance).setStringValueBytes(byteString);
                return this;
            }

            private Builder() {
                super(TriggerParam.DEFAULT_INSTANCE);
            }
        }

        static {
            TriggerParam triggerParam = new TriggerParam();
            DEFAULT_INSTANCE = triggerParam;
            GeneratedMessageLite.registerDefaultInstance(TriggerParam.class, triggerParam);
        }

        private TriggerParam() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDoubleValue() {
            this.doubleValue_ = 0.0d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFloatValue() {
            this.floatValue_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIntValue() {
            this.intValue_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStringValue() {
            this.stringValue_ = getDefaultInstance().getStringValue();
        }

        public static TriggerParam getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TriggerParam parseDelimitedFrom(InputStream inputStream) {
            return (TriggerParam) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TriggerParam parseFrom(ByteBuffer byteBuffer) {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<TriggerParam> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDoubleValue(double d10) {
            this.doubleValue_ = d10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFloatValue(float f10) {
            this.floatValue_ = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIntValue(long j10) {
            this.intValue_ = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            str.getClass();
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.name_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringValue(String str) {
            str.getClass();
            this.stringValue_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringValueBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.stringValue_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TriggerParam();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004\u0001\u0005\u0000", new Object[]{"name_", "stringValue_", "intValue_", "floatValue_", "doubleValue_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<TriggerParam> parser = PARSER;
                    if (parser == null) {
                        synchronized (TriggerParam.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public double getDoubleValue() {
            return this.doubleValue_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public float getFloatValue() {
            return this.floatValue_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public long getIntValue() {
            return this.intValue_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public String getStringValue() {
            return this.stringValue_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public ByteString getStringValueBytes() {
            return ByteString.copyFromUtf8(this.stringValue_);
        }

        public static Builder newBuilder(TriggerParam triggerParam) {
            return DEFAULT_INSTANCE.createBuilder(triggerParam);
        }

        public static TriggerParam parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggerParam) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TriggerParam parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TriggerParam parseFrom(ByteString byteString) {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TriggerParam parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TriggerParam parseFrom(byte[] bArr) {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TriggerParam parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TriggerParam parseFrom(InputStream inputStream) {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TriggerParam parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TriggerParam parseFrom(CodedInputStream codedInputStream) {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TriggerParam parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface TriggerParamOrBuilder extends MessageLiteOrBuilder {
        double getDoubleValue();

        float getFloatValue();

        long getIntValue();

        String getName();

        ByteString getNameBytes();

        String getStringValue();

        ByteString getStringValueBytes();
    }

    public static final class TriggeringCondition extends GeneratedMessageLite<TriggeringCondition, Builder> implements TriggeringConditionOrBuilder {
        private static final TriggeringCondition DEFAULT_INSTANCE;
        public static final int EVENT_FIELD_NUMBER = 2;
        public static final int FIAM_TRIGGER_FIELD_NUMBER = 1;
        private static volatile Parser<TriggeringCondition> PARSER;
        private int conditionCase_ = 0;
        private Object condition_;

        public static final class Builder extends GeneratedMessageLite.Builder<TriggeringCondition, Builder> implements TriggeringConditionOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCondition() {
                copyOnWrite();
                ((TriggeringCondition) this.instance).clearCondition();
                return this;
            }

            public Builder clearEvent() {
                copyOnWrite();
                ((TriggeringCondition) this.instance).clearEvent();
                return this;
            }

            public Builder clearFiamTrigger() {
                copyOnWrite();
                ((TriggeringCondition) this.instance).clearFiamTrigger();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
            public ConditionCase getConditionCase() {
                return ((TriggeringCondition) this.instance).getConditionCase();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
            public Event getEvent() {
                return ((TriggeringCondition) this.instance).getEvent();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
            public Trigger getFiamTrigger() {
                return ((TriggeringCondition) this.instance).getFiamTrigger();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
            public int getFiamTriggerValue() {
                return ((TriggeringCondition) this.instance).getFiamTriggerValue();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
            public boolean hasEvent() {
                return ((TriggeringCondition) this.instance).hasEvent();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
            public boolean hasFiamTrigger() {
                return ((TriggeringCondition) this.instance).hasFiamTrigger();
            }

            public Builder mergeEvent(Event event) {
                copyOnWrite();
                ((TriggeringCondition) this.instance).mergeEvent(event);
                return this;
            }

            public Builder setEvent(Event event) {
                copyOnWrite();
                ((TriggeringCondition) this.instance).setEvent(event);
                return this;
            }

            public Builder setFiamTrigger(Trigger trigger) {
                copyOnWrite();
                ((TriggeringCondition) this.instance).setFiamTrigger(trigger);
                return this;
            }

            public Builder setFiamTriggerValue(int i10) {
                copyOnWrite();
                ((TriggeringCondition) this.instance).setFiamTriggerValue(i10);
                return this;
            }

            private Builder() {
                super(TriggeringCondition.DEFAULT_INSTANCE);
            }

            public Builder setEvent(Event.Builder builder) {
                copyOnWrite();
                ((TriggeringCondition) this.instance).setEvent(builder.build());
                return this;
            }
        }

        public enum ConditionCase {
            FIAM_TRIGGER(1),
            EVENT(2),
            CONDITION_NOT_SET(0);

            private final int value;

            ConditionCase(int i10) {
                this.value = i10;
            }

            public static ConditionCase forNumber(int i10) {
                if (i10 == 0) {
                    return CONDITION_NOT_SET;
                }
                if (i10 == 1) {
                    return FIAM_TRIGGER;
                }
                if (i10 != 2) {
                    return null;
                }
                return EVENT;
            }

            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static ConditionCase valueOf(int i10) {
                return forNumber(i10);
            }
        }

        static {
            TriggeringCondition triggeringCondition = new TriggeringCondition();
            DEFAULT_INSTANCE = triggeringCondition;
            GeneratedMessageLite.registerDefaultInstance(TriggeringCondition.class, triggeringCondition);
        }

        private TriggeringCondition() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCondition() {
            this.conditionCase_ = 0;
            this.condition_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEvent() {
            if (this.conditionCase_ == 2) {
                this.conditionCase_ = 0;
                this.condition_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFiamTrigger() {
            if (this.conditionCase_ == 1) {
                this.conditionCase_ = 0;
                this.condition_ = null;
            }
        }

        public static TriggeringCondition getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeEvent(Event event) {
            event.getClass();
            if (this.conditionCase_ != 2 || this.condition_ == Event.getDefaultInstance()) {
                this.condition_ = event;
            } else {
                this.condition_ = Event.newBuilder((Event) this.condition_).mergeFrom((Event.Builder) event).buildPartial();
            }
            this.conditionCase_ = 2;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TriggeringCondition parseDelimitedFrom(InputStream inputStream) {
            return (TriggeringCondition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TriggeringCondition parseFrom(ByteBuffer byteBuffer) {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<TriggeringCondition> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEvent(Event event) {
            event.getClass();
            this.condition_ = event;
            this.conditionCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFiamTrigger(Trigger trigger) {
            this.condition_ = Integer.valueOf(trigger.getNumber());
            this.conditionCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFiamTriggerValue(int i10) {
            this.conditionCase_ = 1;
            this.condition_ = Integer.valueOf(i10);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TriggeringCondition();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001?\u0000\u0002<\u0000", new Object[]{"condition_", "conditionCase_", Event.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<TriggeringCondition> parser = PARSER;
                    if (parser == null) {
                        synchronized (TriggeringCondition.class) {
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

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
        public ConditionCase getConditionCase() {
            return ConditionCase.forNumber(this.conditionCase_);
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
        public Event getEvent() {
            return this.conditionCase_ == 2 ? (Event) this.condition_ : Event.getDefaultInstance();
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
        public Trigger getFiamTrigger() {
            if (this.conditionCase_ != 1) {
                return Trigger.UNKNOWN_TRIGGER;
            }
            Trigger forNumber = Trigger.forNumber(((Integer) this.condition_).intValue());
            return forNumber == null ? Trigger.UNRECOGNIZED : forNumber;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
        public int getFiamTriggerValue() {
            if (this.conditionCase_ == 1) {
                return ((Integer) this.condition_).intValue();
            }
            return 0;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
        public boolean hasEvent() {
            return this.conditionCase_ == 2;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
        public boolean hasFiamTrigger() {
            return this.conditionCase_ == 1;
        }

        public static Builder newBuilder(TriggeringCondition triggeringCondition) {
            return DEFAULT_INSTANCE.createBuilder(triggeringCondition);
        }

        public static TriggeringCondition parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggeringCondition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TriggeringCondition parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TriggeringCondition parseFrom(ByteString byteString) {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TriggeringCondition parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TriggeringCondition parseFrom(byte[] bArr) {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TriggeringCondition parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TriggeringCondition parseFrom(InputStream inputStream) {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TriggeringCondition parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TriggeringCondition parseFrom(CodedInputStream codedInputStream) {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TriggeringCondition parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface TriggeringConditionOrBuilder extends MessageLiteOrBuilder {
        TriggeringCondition.ConditionCase getConditionCase();

        Event getEvent();

        Trigger getFiamTrigger();

        int getFiamTriggerValue();

        boolean hasEvent();

        boolean hasFiamTrigger();
    }

    private CommonTypesProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
