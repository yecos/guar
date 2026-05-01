package j7;

import android.util.Xml;
import com.hpplay.cybergarage.upnp.Icon;
import com.hpplay.cybergarage.xml.XML;
import com.mobile.bean.UpdateBean;
import com.taobao.accs.common.Constants;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public abstract class e {
    public static UpdateBean a(InputStream inputStream) {
        XmlPullParser newPullParser = Xml.newPullParser();
        UpdateBean updateBean = null;
        try {
            try {
                try {
                    try {
                        newPullParser.setInput(inputStream, XML.CHARSET_UTF8);
                        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                            if (eventType == 2) {
                                if (newPullParser.getName().equals("App")) {
                                    updateBean = new UpdateBean();
                                } else if (newPullParser.getName().equals("id")) {
                                    newPullParser.next();
                                    updateBean.setId(Integer.parseInt(newPullParser.getText()));
                                } else if (newPullParser.getName().equals("name")) {
                                    newPullParser.next();
                                    updateBean.setName(newPullParser.getText());
                                } else if (newPullParser.getName().equals("appDownloadCount")) {
                                    newPullParser.next();
                                    updateBean.setAppDownloadCount(Integer.parseInt(newPullParser.getText()));
                                } else if (newPullParser.getName().equals(Constants.KEY_PACKAGE_NAME)) {
                                    newPullParser.next();
                                    updateBean.setPackageName(newPullParser.getText());
                                } else if (newPullParser.getName().equals(Icon.ELEM_NAME)) {
                                    newPullParser.next();
                                    updateBean.setIcon(newPullParser.getText());
                                } else if (newPullParser.getName().equals("versionName")) {
                                    newPullParser.next();
                                    updateBean.setVersionName(newPullParser.getText());
                                } else if (newPullParser.getName().equals("versionCode")) {
                                    newPullParser.next();
                                    updateBean.setVersionCode(Integer.parseInt(newPullParser.getText()));
                                } else if (newPullParser.getName().equals("minSdk")) {
                                    newPullParser.next();
                                    updateBean.setMinSdk(Integer.parseInt(newPullParser.getText()));
                                } else if (newPullParser.getName().equals("img")) {
                                    newPullParser.next();
                                    updateBean.setImg(newPullParser.getText());
                                } else if (newPullParser.getName().equals("url")) {
                                    newPullParser.next();
                                    updateBean.setUrl(newPullParser.getText());
                                } else if (newPullParser.getName().equals("appStar")) {
                                    newPullParser.next();
                                    updateBean.setAppStar(Integer.parseInt(newPullParser.getText()));
                                } else if (newPullParser.getName().equals("note")) {
                                    newPullParser.next();
                                    updateBean.setNote(newPullParser.getText());
                                } else if (newPullParser.getName().equals("forceUpdate")) {
                                    newPullParser.next();
                                    updateBean.setForceUpdate(Integer.parseInt(newPullParser.getText()));
                                } else if (newPullParser.getName().equals("md5Value")) {
                                    newPullParser.next();
                                    updateBean.setMd5(newPullParser.getText());
                                } else if (newPullParser.getName().equals("defaultDownloadURL")) {
                                    newPullParser.next();
                                    updateBean.setDefaultDownloadUrl(newPullParser.getText());
                                } else if (newPullParser.getName().equals("spareUrl")) {
                                    newPullParser.next();
                                    updateBean.setSpareUrl(newPullParser.getText());
                                }
                            }
                        }
                        inputStream.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                } catch (XmlPullParserException e11) {
                    e11.printStackTrace();
                    inputStream.close();
                }
            } catch (IOException e12) {
                e12.printStackTrace();
                inputStream.close();
            }
            return updateBean;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e13) {
                e13.printStackTrace();
            }
            throw th;
        }
    }
}
