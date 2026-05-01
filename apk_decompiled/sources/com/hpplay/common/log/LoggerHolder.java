package com.hpplay.common.log;

import android.util.Log;

/* loaded from: classes2.dex */
public class LoggerHolder extends Logger {
    private ILogCallback mLogCallback;

    public LoggerHolder(ILogCallback iLogCallback) {
        this.mLogCallback = iLogCallback;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String D(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String E(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String I(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String V(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String W(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String d(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String e(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String i(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String v(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String w(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String D(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String E(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String I(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String V(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String W(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String d(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String e(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String i(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String v(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String w(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String W(String str, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, Log.getStackTraceString(th));
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.Logger, com.hpplay.common.log.ILog
    public String w(String str, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, Log.getStackTraceString(th));
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }
}
