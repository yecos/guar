package com.hpplay.component.protocol.server;

/* loaded from: classes2.dex */
public interface IRequstManager {
    void closeAll();

    void closed(IRequestHandler iRequestHandler);

    void exec(IRequestHandler iRequestHandler);
}
