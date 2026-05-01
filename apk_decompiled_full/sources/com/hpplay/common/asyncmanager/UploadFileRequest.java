package com.hpplay.common.asyncmanager;

import com.hpplay.common.log.LeLog;
import com.hpplay.common.utils.CertUtils;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.Constants;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UploadFileRequest {
    private final String TAG = "UploadFileRequest";
    private HttpMethod httpMethod;
    private Map<String, String> mHeadParameter;
    private String[] mLocalPath;
    private String mURL;

    public UploadFileRequest(String str, String[] strArr, Map<String, String> map, HttpMethod httpMethod) {
        this.mLocalPath = strArr;
        this.mURL = str;
        this.mHeadParameter = map;
        this.httpMethod = httpMethod;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0271 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0260 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0255 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x024a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x023f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0234 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x029d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0292 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0287 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x027c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String uploadFile() {
        InputStreamReader inputStreamReader;
        DataOutputStream dataOutputStream;
        InputStream inputStream;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        DataOutputStream dataOutputStream2;
        InputStream inputStream2;
        BufferedReader bufferedReader2;
        InputStreamReader inputStreamReader2;
        InputStreamReader inputStreamReader3;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            HttpURLConnection httpURLConnection = CertUtils.getHttpURLConnection(new URL(this.mURL));
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            HttpMethod httpMethod = this.httpMethod;
            if (httpMethod != null) {
                httpURLConnection.setRequestMethod(httpMethod.toString());
            }
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
            Map<String, String> map = this.mHeadParameter;
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : this.mHeadParameter.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
            int i10 = 0;
            fileInputStream = null;
            while (true) {
                try {
                    String[] strArr = this.mLocalPath;
                    if (i10 >= strArr.length) {
                        break;
                    }
                    String str = strArr[i10];
                    String substring = str.substring(str.lastIndexOf("//") + 1);
                    if (i10 > 0) {
                        dataOutputStream2.writeBytes("--*****\r\n");
                        dataOutputStream2.writeBytes("Content-Disposition: form-data; name=\"file" + i10 + "\";filename=\"" + substring + "\"\r\n");
                        dataOutputStream2.writeBytes("\r\n");
                    }
                    FileInputStream fileInputStream2 = new FileInputStream(str);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            dataOutputStream2.write(bArr, 0, read);
                        }
                        dataOutputStream2.writeBytes("\r\n");
                        fileInputStream2.close();
                        i10++;
                        fileInputStream = fileInputStream2;
                    } catch (Exception e10) {
                        e = e10;
                        fileInputStream = fileInputStream2;
                        dataOutputStream = dataOutputStream2;
                        inputStreamReader = null;
                        inputStream = null;
                        bufferedReader = null;
                        try {
                            LeLog.w("UploadFileRequest", e);
                            if (dataOutputStream != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            return stringBuffer.toString();
                        } catch (Throwable unused) {
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e11) {
                                    LeLog.w("UploadFileRequest", e11);
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e12) {
                                    LeLog.w("UploadFileRequest", e12);
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e13) {
                                    LeLog.w("UploadFileRequest", e13);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e14) {
                                    LeLog.w("UploadFileRequest", e14);
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e15) {
                                    LeLog.w("UploadFileRequest", e15);
                                }
                            }
                            return stringBuffer.toString();
                        }
                    } catch (Throwable unused2) {
                        fileInputStream = fileInputStream2;
                        dataOutputStream = dataOutputStream2;
                        inputStreamReader = null;
                        inputStream = null;
                        bufferedReader = null;
                        if (dataOutputStream != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        return stringBuffer.toString();
                    }
                } catch (Exception e16) {
                    e = e16;
                } catch (Throwable unused3) {
                }
            }
            dataOutputStream2.flush();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode >= 300) {
                LeLog.w("UploadFileRequest", "HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
                StringBuffer stringBuffer2 = new StringBuffer();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(Constants.KEY_HTTP_CODE, responseCode);
                    jSONObject.put(Constant.KEY_MSG, "");
                    stringBuffer2.append(jSONObject.toString());
                    stringBuffer = stringBuffer2;
                } catch (Exception e17) {
                    e = e17;
                    stringBuffer = stringBuffer2;
                    dataOutputStream = dataOutputStream2;
                    inputStreamReader = null;
                    inputStream = null;
                    bufferedReader = null;
                    LeLog.w("UploadFileRequest", e);
                    if (dataOutputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    return stringBuffer.toString();
                } catch (Throwable unused4) {
                    stringBuffer = stringBuffer2;
                    dataOutputStream = dataOutputStream2;
                    inputStreamReader = null;
                    inputStream = null;
                    bufferedReader = null;
                    if (dataOutputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    return stringBuffer.toString();
                }
            }
            if (responseCode == 200) {
                inputStream2 = httpURLConnection.getInputStream();
                try {
                    inputStreamReader3 = new InputStreamReader(inputStream2);
                } catch (Exception e18) {
                    e = e18;
                    inputStream = inputStream2;
                    dataOutputStream = dataOutputStream2;
                    inputStreamReader = null;
                } catch (Throwable unused5) {
                    inputStream = inputStream2;
                    dataOutputStream = dataOutputStream2;
                    inputStreamReader = null;
                }
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader3);
                    try {
                        StringBuffer stringBuffer3 = new StringBuffer();
                        while (true) {
                            try {
                                String readLine = bufferedReader3.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer3.append(readLine);
                                stringBuffer3.append("\n");
                            } catch (Exception e19) {
                                e = e19;
                                bufferedReader = bufferedReader3;
                                stringBuffer = stringBuffer3;
                                inputStream = inputStream2;
                                inputStreamReader = inputStreamReader3;
                                dataOutputStream = dataOutputStream2;
                                LeLog.w("UploadFileRequest", e);
                                if (dataOutputStream != null) {
                                }
                                if (bufferedReader != null) {
                                }
                                if (inputStreamReader != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (fileInputStream != null) {
                                }
                                return stringBuffer.toString();
                            } catch (Throwable unused6) {
                                bufferedReader = bufferedReader3;
                                stringBuffer = stringBuffer3;
                                inputStream = inputStream2;
                                inputStreamReader = inputStreamReader3;
                                dataOutputStream = dataOutputStream2;
                                if (dataOutputStream != null) {
                                }
                                if (bufferedReader != null) {
                                }
                                if (inputStreamReader != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (fileInputStream != null) {
                                }
                                return stringBuffer.toString();
                            }
                        }
                        inputStreamReader2 = inputStreamReader3;
                        bufferedReader2 = bufferedReader3;
                        stringBuffer = stringBuffer3;
                    } catch (Exception e20) {
                        e = e20;
                        bufferedReader = bufferedReader3;
                    } catch (Throwable unused7) {
                        bufferedReader = bufferedReader3;
                    }
                } catch (Exception e21) {
                    e = e21;
                    inputStream = inputStream2;
                    inputStreamReader = inputStreamReader3;
                    dataOutputStream = dataOutputStream2;
                    bufferedReader = null;
                    LeLog.w("UploadFileRequest", e);
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e22) {
                            LeLog.w("UploadFileRequest", e22);
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e23) {
                            LeLog.w("UploadFileRequest", e23);
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e24) {
                            LeLog.w("UploadFileRequest", e24);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e25) {
                            LeLog.w("UploadFileRequest", e25);
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e26) {
                            LeLog.w("UploadFileRequest", e26);
                        }
                    }
                    return stringBuffer.toString();
                } catch (Throwable unused8) {
                    inputStream = inputStream2;
                    inputStreamReader = inputStreamReader3;
                    dataOutputStream = dataOutputStream2;
                    bufferedReader = null;
                    if (dataOutputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    return stringBuffer.toString();
                }
            } else {
                inputStream2 = null;
                bufferedReader2 = null;
                inputStreamReader2 = null;
            }
        } catch (Exception e27) {
            e = e27;
            inputStreamReader = null;
            dataOutputStream = null;
            inputStream = null;
            fileInputStream = null;
        } catch (Throwable unused9) {
            inputStreamReader = null;
            dataOutputStream = null;
            inputStream = null;
            fileInputStream = null;
        }
        try {
            LeLog.w("UploadFileRequest", "resultBuffer =" + stringBuffer.toString());
            try {
                dataOutputStream2.close();
            } catch (Exception e28) {
                LeLog.w("UploadFileRequest", e28);
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e29) {
                    LeLog.w("UploadFileRequest", e29);
                }
            }
            if (inputStreamReader2 != null) {
                try {
                    inputStreamReader2.close();
                } catch (IOException e30) {
                    LeLog.w("UploadFileRequest", e30);
                }
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e31) {
                    LeLog.w("UploadFileRequest", e31);
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e32) {
                    LeLog.w("UploadFileRequest", e32);
                }
            }
            return stringBuffer.toString();
        } catch (Exception e33) {
            e = e33;
            inputStream = inputStream2;
            inputStreamReader = inputStreamReader2;
            bufferedReader = bufferedReader2;
            dataOutputStream = dataOutputStream2;
            LeLog.w("UploadFileRequest", e);
            if (dataOutputStream != null) {
            }
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            if (fileInputStream != null) {
            }
            return stringBuffer.toString();
        } catch (Throwable unused10) {
            inputStream = inputStream2;
            inputStreamReader = inputStreamReader2;
            bufferedReader = bufferedReader2;
            dataOutputStream = dataOutputStream2;
            if (dataOutputStream != null) {
            }
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            if (fileInputStream != null) {
            }
            return stringBuffer.toString();
        }
    }
}
