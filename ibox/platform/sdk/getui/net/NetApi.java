package com.ibox.platform.sdk.getui.net;

import com.ibox.platform.sdk.getui.net.request.AuthRequest;
import com.ibox.platform.sdk.getui.net.request.LinkNotificationRequest;
import com.ibox.platform.sdk.getui.net.request.TransmissionRequest;
import com.ibox.platform.sdk.getui.net.response.AuthResp;
import com.ibox.platform.sdk.getui.net.response.NotificationResp;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* loaded from: NetApi.class */
public interface NetApi {
    @POST("v1/{appid}/auth_sign")
    Observable<AuthResp> a(@Path("appid") String str, @Body AuthRequest authRequest);

    @POST("v1/{appid}/push_single")
    Observable<NotificationResp> b(@Header("authtoken") String str, @Path("appid") String str2, @Body TransmissionRequest transmissionRequest);

    @POST("v1/{appid}/push_single")
    Observable<NotificationResp> c(@Header("authtoken") String str, @Path("appid") String str2, @Body LinkNotificationRequest linkNotificationRequest);
}
