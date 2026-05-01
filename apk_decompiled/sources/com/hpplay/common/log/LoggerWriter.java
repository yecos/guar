package com.hpplay.common.log;

/* loaded from: classes2.dex */
class LoggerWriter extends Logger {
    private ILogCallback mLogCallback;

    public LoggerWriter(ILogCallback iLogCallback) {
        this.mLogCallback = iLogCallback;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String D(String str, String str2) {
        String D = super.D(str, str2);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(D);
        }
        return D;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String E(String str, String str2) {
        String E = super.E(str, str2);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(E);
        }
        return E;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String I(String str, String str2) {
        String I = super.I(str, str2);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(I);
        }
        return I;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String V(String str, String str2) {
        String V = super.V(str, str2);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(V);
        }
        return V;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String W(String str, String str2) {
        String W = super.W(str, str2);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(W);
        }
        return W;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String d(String str, String str2) {
        String d10 = super.d(str, str2);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(d10);
        }
        return d10;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String e(String str, String str2) {
        String e10 = super.e(str, str2);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(e10);
        }
        return e10;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String i(String str, String str2) {
        String i10 = super.i(str, str2);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(i10);
        }
        return i10;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String v(String str, String str2) {
        String v10 = super.v(str, str2);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(v10);
        }
        return v10;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String w(String str, String str2) {
        String w10 = super.w(str, str2);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(w10);
        }
        return w10;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String D(String str, String str2, Throwable th) {
        String D = super.D(str, str2, th);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(D);
        }
        return D;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String E(String str, String str2, Throwable th) {
        String E = super.E(str, str2, th);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(E);
        }
        return E;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String I(String str, String str2, Throwable th) {
        String I = super.I(str, str2, th);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(I);
        }
        return I;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String V(String str, String str2, Throwable th) {
        String V = super.V(str, str2, th);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(V);
        }
        return V;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String W(String str, String str2, Throwable th) {
        String W = super.W(str, str2, th);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(W);
        }
        return W;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String d(String str, String str2, Throwable th) {
        String d10 = super.d(str, str2, th);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(d10);
        }
        return d10;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String e(String str, String str2, Throwable th) {
        String e10 = super.e(str, str2, th);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(e10);
        }
        return e10;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String i(String str, String str2, Throwable th) {
        String i10 = super.i(str, str2, th);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(i10);
        }
        return i10;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String v(String str, String str2, Throwable th) {
        String v10 = super.v(str, str2, th);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(v10);
        }
        return v10;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String w(String str, String str2, Throwable th) {
        String w10 = super.w(str, str2, th);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(w10);
        }
        return w10;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String W(String str, Throwable th) {
        String W = super.W(str, th);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(W);
        }
        return W;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String w(String str, Throwable th) {
        String w10 = super.w(str, th);
        ILogCallback iLogCallback = this.mLogCallback;
        if (iLogCallback != null) {
            iLogCallback.onLogCallback(w10);
        }
        return w10;
    }
}
