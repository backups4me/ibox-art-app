package com.ibox.nft.base.flutter;

import androidx.annotation.NonNull;
import com.ibox.libs.common.utils.JsonTool;
import com.ibox.libs.common.utils.LogTool;
import com.ibox.platform.sdk.manager.AliTigerTallyManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;

/* loaded from: IBoxFlutterMethodCallHandler.class */
public class IBoxFlutterMethodCallHandler implements MethodChannel.MethodCallHandler {
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        LogTool.a("###### Flutter-onMethodCall  methodName: " + methodCall.method + "， args: " + methodCall.arguments());
        String str = methodCall.method;
        str.hashCode();
        if (!str.equals("generateAliRequestSign")) {
            result.notImplemented();
            return;
        }
        Object arguments = methodCall.arguments();
        String str2 = "";
        if (arguments != null) {
            if (arguments instanceof Map) {
                str2 = JsonTool.d((Map) arguments);
            } else if (arguments instanceof String) {
                str2 = (String) arguments;
            }
        }
        LogTool.a("###### Flutter-onMethodCall  requestBodyStr: " + str2);
        String d2 = AliTigerTallyManager.a().d(str2);
        LogTool.a("###### Flutter-onMethodCall  result_wToken: " + d2);
        result.success(d2);
    }
}
