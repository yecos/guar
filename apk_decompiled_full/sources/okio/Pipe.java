package okio;

import java.io.IOException;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public final class Pipe {

    @Nullable
    private Sink foldedSink;
    final long maxBufferSize;
    boolean sinkClosed;
    boolean sourceClosed;
    final Buffer buffer = new Buffer();
    private final Sink sink = new PipeSink();
    private final Source source = new PipeSource();

    public final class PipeSink implements Sink {
        final PushableTimeout timeout = new PushableTimeout();

        public PipeSink() {
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Sink sink;
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                if (pipe.sinkClosed) {
                    return;
                }
                if (pipe.foldedSink != null) {
                    sink = Pipe.this.foldedSink;
                } else {
                    Pipe pipe2 = Pipe.this;
                    if (pipe2.sourceClosed && pipe2.buffer.size() > 0) {
                        throw new IOException("source is closed");
                    }
                    Pipe pipe3 = Pipe.this;
                    pipe3.sinkClosed = true;
                    pipe3.buffer.notifyAll();
                    sink = null;
                }
                if (sink != null) {
                    this.timeout.push(sink.timeout());
                    try {
                        sink.close();
                    } finally {
                        this.timeout.pop();
                    }
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            Sink sink;
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                if (pipe.sinkClosed) {
                    throw new IllegalStateException("closed");
                }
                if (pipe.foldedSink != null) {
                    sink = Pipe.this.foldedSink;
                } else {
                    Pipe pipe2 = Pipe.this;
                    if (pipe2.sourceClosed && pipe2.buffer.size() > 0) {
                        throw new IOException("source is closed");
                    }
                    sink = null;
                }
            }
            if (sink != null) {
                this.timeout.push(sink.timeout());
                try {
                    sink.flush();
                } finally {
                    this.timeout.pop();
                }
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j10) {
            Sink sink;
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sinkClosed) {
                    while (true) {
                        if (j10 <= 0) {
                            sink = null;
                            break;
                        }
                        if (Pipe.this.foldedSink != null) {
                            sink = Pipe.this.foldedSink;
                            break;
                        }
                        Pipe pipe = Pipe.this;
                        if (pipe.sourceClosed) {
                            throw new IOException("source is closed");
                        }
                        long size = pipe.maxBufferSize - pipe.buffer.size();
                        if (size == 0) {
                            this.timeout.waitUntilNotified(Pipe.this.buffer);
                        } else {
                            long min = Math.min(size, j10);
                            Pipe.this.buffer.write(buffer, min);
                            j10 -= min;
                            Pipe.this.buffer.notifyAll();
                        }
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
            if (sink != null) {
                this.timeout.push(sink.timeout());
                try {
                    sink.write(buffer, j10);
                } finally {
                    this.timeout.pop();
                }
            }
        }
    }

    public final class PipeSource implements Source {
        final Timeout timeout = new Timeout();

        public PipeSource() {
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                pipe.sourceClosed = true;
                pipe.buffer.notifyAll();
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j10) {
            synchronized (Pipe.this.buffer) {
                if (Pipe.this.sourceClosed) {
                    throw new IllegalStateException("closed");
                }
                while (Pipe.this.buffer.size() == 0) {
                    Pipe pipe = Pipe.this;
                    if (pipe.sinkClosed) {
                        return -1L;
                    }
                    this.timeout.waitUntilNotified(pipe.buffer);
                }
                long read = Pipe.this.buffer.read(buffer, j10);
                Pipe.this.buffer.notifyAll();
                return read;
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    public Pipe(long j10) {
        if (j10 >= 1) {
            this.maxBufferSize = j10;
            return;
        }
        throw new IllegalArgumentException("maxBufferSize < 1: " + j10);
    }

    public void fold(Sink sink) {
        boolean z10;
        Buffer buffer;
        while (true) {
            synchronized (this.buffer) {
                if (this.foldedSink != null) {
                    throw new IllegalStateException("sink already folded");
                }
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    return;
                } else {
                    z10 = this.sinkClosed;
                    buffer = new Buffer();
                    Buffer buffer2 = this.buffer;
                    buffer.write(buffer2, buffer2.size);
                    this.buffer.notifyAll();
                }
            }
            try {
                sink.write(buffer, buffer.size);
                if (z10) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th) {
                synchronized (this.buffer) {
                    this.sourceClosed = true;
                    this.buffer.notifyAll();
                    throw th;
                }
            }
        }
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}
