package io.grpc.stub;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import y8.c;
import y8.t;

/* loaded from: classes3.dex */
public abstract class d {
    private final y8.c callOptions;
    private final y8.d channel;

    public interface a {
        d newStub(y8.d dVar, y8.c cVar);
    }

    public d(y8.d dVar, y8.c cVar) {
        this.channel = (y8.d) Preconditions.checkNotNull(dVar, "channel");
        this.callOptions = (y8.c) Preconditions.checkNotNull(cVar, "callOptions");
    }

    public abstract d build(y8.d dVar, y8.c cVar);

    public final y8.c getCallOptions() {
        return this.callOptions;
    }

    public final y8.d getChannel() {
        return this.channel;
    }

    public final d withCallCredentials(y8.b bVar) {
        return build(this.channel, this.callOptions.l(bVar));
    }

    @Deprecated
    public final d withChannel(y8.d dVar) {
        return build(dVar, this.callOptions);
    }

    public final d withCompression(String str) {
        return build(this.channel, this.callOptions.m(str));
    }

    public final d withDeadline(@Nullable t tVar) {
        return build(this.channel, this.callOptions.n(tVar));
    }

    public final d withDeadlineAfter(long j10, TimeUnit timeUnit) {
        return build(this.channel, this.callOptions.o(j10, timeUnit));
    }

    public final d withExecutor(Executor executor) {
        return build(this.channel, this.callOptions.p(executor));
    }

    public final d withInterceptors(y8.h... hVarArr) {
        return build(y8.j.b(this.channel, hVarArr), this.callOptions);
    }

    public final d withMaxInboundMessageSize(int i10) {
        return build(this.channel, this.callOptions.q(i10));
    }

    public final d withMaxOutboundMessageSize(int i10) {
        return build(this.channel, this.callOptions.r(i10));
    }

    public final <T> d withOption(c.C0345c c0345c, T t10) {
        return build(this.channel, this.callOptions.s(c0345c, t10));
    }

    public final d withWaitForReady() {
        return build(this.channel, this.callOptions.u());
    }
}
