package com.ibox.nft.base.jsbridge;

/* loaded from: JsManager.class */
public class JsManager {
    public static String a(String str) {
        return "javascript:window.iboxWebBridge.postMessage(" + str + ")";
    }
}
