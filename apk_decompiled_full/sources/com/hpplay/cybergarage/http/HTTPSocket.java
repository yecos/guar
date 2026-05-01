package com.hpplay.cybergarage.http;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Calendar;

/* loaded from: classes2.dex */
public class HTTPSocket {
    private Socket socket = null;
    private InputStream sockIn = null;
    private OutputStream sockOut = null;

    public HTTPSocket(Socket socket) {
        setSocket(socket);
        open();
    }

    private OutputStream getOutputStream() {
        return this.sockOut;
    }

    private boolean post(HTTPResponse hTTPResponse, byte[] bArr, long j10, long j11, boolean z10) {
        hTTPResponse.setDate(Calendar.getInstance());
        OutputStream outputStream = getOutputStream();
        try {
            hTTPResponse.setContentLength(j11);
            outputStream.write(hTTPResponse.getHeader().getBytes());
            outputStream.write("\r\n".getBytes());
            if (z10) {
                outputStream.flush();
                return true;
            }
            boolean isChunked = hTTPResponse.isChunked();
            if (isChunked) {
                outputStream.write(Long.toHexString(j11).getBytes());
                outputStream.write("\r\n".getBytes());
            }
            outputStream.write(bArr, (int) j10, (int) j11);
            if (isChunked) {
                outputStream.write("\r\n".getBytes());
                outputStream.write("0".getBytes());
                outputStream.write("\r\n".getBytes());
            }
            outputStream.flush();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void setInputStream(InputStream inputStream) {
        this.sockIn = inputStream;
    }

    private void setOutputStream(OutputStream outputStream) {
        this.sockOut = outputStream;
    }

    private void setSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean close() {
        try {
            InputStream inputStream = this.sockIn;
            if (inputStream != null) {
                inputStream.close();
            }
            OutputStream outputStream = this.sockOut;
            if (outputStream != null) {
                outputStream.close();
            }
            getSocket().close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void finalize() {
        close();
    }

    public InputStream getInputStream() {
        return this.sockIn;
    }

    public String getLocalAddress() {
        return getSocket().getLocalAddress().getHostAddress();
    }

    public int getLocalPort() {
        return getSocket().getLocalPort();
    }

    public Socket getSocket() {
        return this.socket;
    }

    public boolean open() {
        Socket socket = getSocket();
        try {
            this.sockIn = socket.getInputStream();
            this.sockOut = socket.getOutputStream();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public HTTPSocket(HTTPSocket hTTPSocket) {
        setSocket(hTTPSocket.getSocket());
        setInputStream(hTTPSocket.getInputStream());
        setOutputStream(hTTPSocket.getOutputStream());
    }

    private boolean post(HTTPResponse hTTPResponse, InputStream inputStream, long j10, long j11, boolean z10) {
        hTTPResponse.setDate(Calendar.getInstance());
        OutputStream outputStream = getOutputStream();
        try {
            hTTPResponse.setContentLength(j11);
            outputStream.write(hTTPResponse.getHeader().getBytes());
            outputStream.write("\r\n".getBytes());
            if (z10) {
                outputStream.flush();
                return true;
            }
            boolean isChunked = hTTPResponse.isChunked();
            long j12 = 0;
            if (0 < j10) {
                inputStream.skip(j10);
            }
            int chunkSize = HTTP.getChunkSize();
            byte[] bArr = new byte[chunkSize];
            long j13 = chunkSize;
            int read = inputStream.read(bArr, 0, (int) (j13 < j11 ? j13 : j11));
            while (read > 0 && j12 < j11) {
                if (isChunked) {
                    outputStream.write(Long.toHexString(read).getBytes());
                    outputStream.write("\r\n".getBytes());
                }
                outputStream.write(bArr, 0, read);
                if (isChunked) {
                    outputStream.write("\r\n".getBytes());
                }
                j12 += read;
                long j14 = j11 - j12;
                if (j13 < j14) {
                    j14 = j13;
                }
                read = inputStream.read(bArr, 0, (int) j14);
            }
            if (isChunked) {
                outputStream.write("0".getBytes());
                outputStream.write("\r\n".getBytes());
            }
            outputStream.flush();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean post(HTTPResponse hTTPResponse, long j10, long j11, boolean z10) {
        if (hTTPResponse.hasContentInputStream()) {
            return post(hTTPResponse, hTTPResponse.getContentInputStream(), j10, j11, z10);
        }
        return post(hTTPResponse, hTTPResponse.getContent(), j10, j11, z10);
    }
}
