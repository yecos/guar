package com.hpplay.cybergarage.xml;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.http.HTTPRequest;
import com.hpplay.cybergarage.http.HTTPResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

/* loaded from: classes2.dex */
public abstract class Parser {
    private Node httpGet(URL url, int i10, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(i10);
        httpURLConnection.setRequestProperty("Content-Length", "0");
        if (str != null) {
            httpURLConnection.setRequestProperty(HTTP.HOST, str);
        }
        InputStream inputStream = httpURLConnection.getInputStream();
        Node parse = parse(inputStream);
        inputStream.close();
        httpURLConnection.disconnect();
        CLog.i("parserp", "   end ======== " + (System.currentTimeMillis() - currentTimeMillis));
        return parse;
    }

    public abstract Node parse(InputStream inputStream);

    public Node parse(String str, int i10) {
        URL url;
        try {
            url = new URL(str);
        } catch (Exception unused) {
            url = new URL(URLDecoder.decode(str));
        }
        String host = url.getHost();
        int port = url.getPort();
        if (port == -1) {
            port = 80;
        }
        String path = url.getPath();
        CLog.i("parserp", "   start " + url.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return httpGet(url, i10, host);
        } catch (Exception unused2) {
            CLog.i("parserp", "first parse failed");
            CLog.i("parserp", url + "   error ");
            HTTPRequest hTTPRequest = new HTTPRequest();
            hTTPRequest.setMethod("GET");
            hTTPRequest.setURI(path);
            HTTPResponse post = hTTPRequest.post(host, port);
            if (!post.isSuccessful()) {
                throw new ParserException("HTTP comunication failed: no answer from peer.Unable to retrive resoure -> " + url.toString());
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new String(post.getContent()).getBytes());
            CLog.i("parserp", "   end ======== " + (System.currentTimeMillis() - currentTimeMillis));
            return parse(byteArrayInputStream);
        }
    }

    public Node parseUrl(String str) {
        return parse(str, 30000);
    }

    public Node parse(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Node parse = parse(fileInputStream);
            fileInputStream.close();
            return parse;
        } catch (Exception e10) {
            throw new ParserException(e10);
        }
    }

    public Node parse(String str) {
        try {
            try {
                return parse(new ByteArrayInputStream(str.getBytes()));
            } catch (Exception e10) {
                throw new ParserException(e10);
            }
        } catch (Exception unused) {
            return parse(new ByteArrayInputStream(URLDecoder.decode(str).getBytes()));
        }
    }
}
