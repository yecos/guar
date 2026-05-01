package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import com.google.type.TimeZone;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class DateTime extends GeneratedMessageLite<DateTime, Builder> implements DateTimeOrBuilder {
    public static final int DAY_FIELD_NUMBER = 3;
    private static final DateTime DEFAULT_INSTANCE;
    public static final int HOURS_FIELD_NUMBER = 4;
    public static final int MINUTES_FIELD_NUMBER = 5;
    public static final int MONTH_FIELD_NUMBER = 2;
    public static final int NANOS_FIELD_NUMBER = 7;
    private static volatile Parser<DateTime> PARSER = null;
    public static final int SECONDS_FIELD_NUMBER = 6;
    public static final int TIME_ZONE_FIELD_NUMBER = 9;
    public static final int UTC_OFFSET_FIELD_NUMBER = 8;
    public static final int YEAR_FIELD_NUMBER = 1;
    private int day_;
    private int hours_;
    private int minutes_;
    private int month_;
    private int nanos_;
    private int seconds_;
    private int timeOffsetCase_ = 0;
    private Object timeOffset_;
    private int year_;

    /* renamed from: com.google.type.DateTime$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<DateTime, Builder> implements DateTimeOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDay() {
            copyOnWrite();
            ((DateTime) this.instance).clearDay();
            return this;
        }

        public Builder clearHours() {
            copyOnWrite();
            ((DateTime) this.instance).clearHours();
            return this;
        }

        public Builder clearMinutes() {
            copyOnWrite();
            ((DateTime) this.instance).clearMinutes();
            return this;
        }

        public Builder clearMonth() {
            copyOnWrite();
            ((DateTime) this.instance).clearMonth();
            return this;
        }

        public Builder clearNanos() {
            copyOnWrite();
            ((DateTime) this.instance).clearNanos();
            return this;
        }

        public Builder clearSeconds() {
            copyOnWrite();
            ((DateTime) this.instance).clearSeconds();
            return this;
        }

        public Builder clearTimeOffset() {
            copyOnWrite();
            ((DateTime) this.instance).clearTimeOffset();
            return this;
        }

        public Builder clearTimeZone() {
            copyOnWrite();
            ((DateTime) this.instance).clearTimeZone();
            return this;
        }

        public Builder clearUtcOffset() {
            copyOnWrite();
            ((DateTime) this.instance).clearUtcOffset();
            return this;
        }

        public Builder clearYear() {
            copyOnWrite();
            ((DateTime) this.instance).clearYear();
            return this;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getDay() {
            return ((DateTime) this.instance).getDay();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getHours() {
            return ((DateTime) this.instance).getHours();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getMinutes() {
            return ((DateTime) this.instance).getMinutes();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getMonth() {
            return ((DateTime) this.instance).getMonth();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getNanos() {
            return ((DateTime) this.instance).getNanos();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getSeconds() {
            return ((DateTime) this.instance).getSeconds();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public TimeOffsetCase getTimeOffsetCase() {
            return ((DateTime) this.instance).getTimeOffsetCase();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public TimeZone getTimeZone() {
            return ((DateTime) this.instance).getTimeZone();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public Duration getUtcOffset() {
            return ((DateTime) this.instance).getUtcOffset();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getYear() {
            return ((DateTime) this.instance).getYear();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public boolean hasTimeZone() {
            return ((DateTime) this.instance).hasTimeZone();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public boolean hasUtcOffset() {
            return ((DateTime) this.instance).hasUtcOffset();
        }

        public Builder mergeTimeZone(TimeZone timeZone) {
            copyOnWrite();
            ((DateTime) this.instance).mergeTimeZone(timeZone);
            return this;
        }

        public Builder mergeUtcOffset(Duration duration) {
            copyOnWrite();
            ((DateTime) this.instance).mergeUtcOffset(duration);
            return this;
        }

        public Builder setDay(int i10) {
            copyOnWrite();
            ((DateTime) this.instance).setDay(i10);
            return this;
        }

        public Builder setHours(int i10) {
            copyOnWrite();
            ((DateTime) this.instance).setHours(i10);
            return this;
        }

        public Builder setMinutes(int i10) {
            copyOnWrite();
            ((DateTime) this.instance).setMinutes(i10);
            return this;
        }

        public Builder setMonth(int i10) {
            copyOnWrite();
            ((DateTime) this.instance).setMonth(i10);
            return this;
        }

        public Builder setNanos(int i10) {
            copyOnWrite();
            ((DateTime) this.instance).setNanos(i10);
            return this;
        }

        public Builder setSeconds(int i10) {
            copyOnWrite();
            ((DateTime) this.instance).setSeconds(i10);
            return this;
        }

        public Builder setTimeZone(TimeZone timeZone) {
            copyOnWrite();
            ((DateTime) this.instance).setTimeZone(timeZone);
            return this;
        }

        public Builder setUtcOffset(Duration duration) {
            copyOnWrite();
            ((DateTime) this.instance).setUtcOffset(duration);
            return this;
        }

        public Builder setYear(int i10) {
            copyOnWrite();
            ((DateTime) this.instance).setYear(i10);
            return this;
        }

        private Builder() {
            super(DateTime.DEFAULT_INSTANCE);
        }

        public Builder setTimeZone(TimeZone.Builder builder) {
            copyOnWrite();
            ((DateTime) this.instance).setTimeZone(builder.build());
            return this;
        }

        public Builder setUtcOffset(Duration.Builder builder) {
            copyOnWrite();
            ((DateTime) this.instance).setUtcOffset(builder.build());
            return this;
        }
    }

    public enum TimeOffsetCase {
        UTC_OFFSET(8),
        TIME_ZONE(9),
        TIMEOFFSET_NOT_SET(0);

        private final int value;

        TimeOffsetCase(int i10) {
            this.value = i10;
        }

        public static TimeOffsetCase forNumber(int i10) {
            if (i10 == 0) {
                return TIMEOFFSET_NOT_SET;
            }
            if (i10 == 8) {
                return UTC_OFFSET;
            }
            if (i10 != 9) {
                return null;
            }
            return TIME_ZONE;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TimeOffsetCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    static {
        DateTime dateTime = new DateTime();
        DEFAULT_INSTANCE = dateTime;
        GeneratedMessageLite.registerDefaultInstance(DateTime.class, dateTime);
    }

    private DateTime() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDay() {
        this.day_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHours() {
        this.hours_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMinutes() {
        this.minutes_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMonth() {
        this.month_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNanos() {
        this.nanos_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSeconds() {
        this.seconds_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimeOffset() {
        this.timeOffsetCase_ = 0;
        this.timeOffset_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimeZone() {
        if (this.timeOffsetCase_ == 9) {
            this.timeOffsetCase_ = 0;
            this.timeOffset_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUtcOffset() {
        if (this.timeOffsetCase_ == 8) {
            this.timeOffsetCase_ = 0;
            this.timeOffset_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearYear() {
        this.year_ = 0;
    }

    public static DateTime getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTimeZone(TimeZone timeZone) {
        timeZone.getClass();
        if (this.timeOffsetCase_ != 9 || this.timeOffset_ == TimeZone.getDefaultInstance()) {
            this.timeOffset_ = timeZone;
        } else {
            this.timeOffset_ = TimeZone.newBuilder((TimeZone) this.timeOffset_).mergeFrom((TimeZone.Builder) timeZone).buildPartial();
        }
        this.timeOffsetCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUtcOffset(Duration duration) {
        duration.getClass();
        if (this.timeOffsetCase_ != 8 || this.timeOffset_ == Duration.getDefaultInstance()) {
            this.timeOffset_ = duration;
        } else {
            this.timeOffset_ = Duration.newBuilder((Duration) this.timeOffset_).mergeFrom((Duration.Builder) duration).buildPartial();
        }
        this.timeOffsetCase_ = 8;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static DateTime parseDelimitedFrom(InputStream inputStream) {
        return (DateTime) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DateTime parseFrom(ByteBuffer byteBuffer) {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DateTime> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDay(int i10) {
        this.day_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHours(int i10) {
        this.hours_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMinutes(int i10) {
        this.minutes_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMonth(int i10) {
        this.month_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNanos(int i10) {
        this.nanos_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeconds(int i10) {
        this.seconds_ = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeZone(TimeZone timeZone) {
        timeZone.getClass();
        this.timeOffset_ = timeZone;
        this.timeOffsetCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUtcOffset(Duration duration) {
        duration.getClass();
        this.timeOffset_ = duration;
        this.timeOffsetCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setYear(int i10) {
        this.year_ = i10;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new DateTime();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0001\u0000\u0001\t\t\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004\u0004\u0004\u0005\u0004\u0006\u0004\u0007\u0004\b<\u0000\t<\u0000", new Object[]{"timeOffset_", "timeOffsetCase_", "year_", "month_", "day_", "hours_", "minutes_", "seconds_", "nanos_", Duration.class, TimeZone.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DateTime> parser = PARSER;
                if (parser == null) {
                    synchronized (DateTime.class) {
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

    @Override // com.google.type.DateTimeOrBuilder
    public int getDay() {
        return this.day_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getHours() {
        return this.hours_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getMinutes() {
        return this.minutes_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getMonth() {
        return this.month_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getNanos() {
        return this.nanos_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getSeconds() {
        return this.seconds_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public TimeOffsetCase getTimeOffsetCase() {
        return TimeOffsetCase.forNumber(this.timeOffsetCase_);
    }

    @Override // com.google.type.DateTimeOrBuilder
    public TimeZone getTimeZone() {
        return this.timeOffsetCase_ == 9 ? (TimeZone) this.timeOffset_ : TimeZone.getDefaultInstance();
    }

    @Override // com.google.type.DateTimeOrBuilder
    public Duration getUtcOffset() {
        return this.timeOffsetCase_ == 8 ? (Duration) this.timeOffset_ : Duration.getDefaultInstance();
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getYear() {
        return this.year_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public boolean hasTimeZone() {
        return this.timeOffsetCase_ == 9;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public boolean hasUtcOffset() {
        return this.timeOffsetCase_ == 8;
    }

    public static Builder newBuilder(DateTime dateTime) {
        return DEFAULT_INSTANCE.createBuilder(dateTime);
    }

    public static DateTime parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DateTime) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DateTime parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DateTime parseFrom(ByteString byteString) {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static DateTime parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DateTime parseFrom(byte[] bArr) {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DateTime parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DateTime parseFrom(InputStream inputStream) {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DateTime parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DateTime parseFrom(CodedInputStream codedInputStream) {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DateTime parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
