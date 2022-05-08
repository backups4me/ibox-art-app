package com.ibox.nft.network.account.config;

import com.ibox.network.lib.bean.IBoxResponse;
import com.ibox.nft.network.account.bean.BankCardInfoBean;
import com.ibox.nft.network.account.bean.BindBankCardStatusBean;
import com.ibox.nft.network.account.bean.CheckTokenInfoBean;
import com.ibox.nft.network.account.bean.DistributeWalletResultBean;
import com.ibox.nft.network.account.bean.LoginInfoBean;
import com.ibox.nft.network.account.bean.PersonInfoBean;
import com.ibox.nft.network.account.bean.UserInfoBean;
import com.ibox.nft.network.account.bean.WxLoginResult;
import io.reactivex.Observable;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/* loaded from: IAccountApiService.class */
public interface IAccountApiService {
    @POST("/nft-mall-web/nft/user/updatePersonalInfo")
    Observable<IBoxResponse> a(@Body Map<String, Object> map);

    @POST("/nft-mall-web/nft/user/sendSMSCode")
    Observable<IBoxResponse<String>> b(@Body Map<String, Object> map);

    @POST("/nft-mall-web/v1.1/nft/user/login")
    Observable<IBoxResponse<LoginInfoBean>> c(@Body Map<String, Object> map);

    @POST("/nft-mall-web/nft/product/updateBindBankCard")
    Observable<IBoxResponse<Object>> d(@Body Map<String, Object> map);

    @POST("/nft-mall-web/v1.1/nft/user/getUserInfo")
    Observable<IBoxResponse<UserInfoBean>> e(@Body Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/user/getPersonalInfo")
    Observable<IBoxResponse<PersonInfoBean>> f(@QueryMap Map<String, Object> map);

    @POST("/nft-mall-web/nft/product/bindBankCard")
    Observable<IBoxResponse<Object>> g(@Body Map<String, Object> map);

    @POST("/nft-mall-web/nft/product/getBindBankCardInfo")
    Observable<IBoxResponse<BankCardInfoBean>> h(@Body Map<String, Object> map);

    @POST("/nft-mall-web/nft/product/updatePersonalAuthority")
    Observable<IBoxResponse<Object>> i(@Body Map<String, Object> map);

    @POST("/nft-mall-web/nft/user/setPublicWalletAddr")
    Observable<IBoxResponse<DistributeWalletResultBean>> j(@Body Map<String, Object> map);

    @POST("/nft-mall-web/v1.1/nft/user/verifyAppSMSCode")
    Observable<IBoxResponse<LoginInfoBean>> k(@Body Map<String, Object> map);

    @POST("/nft-mall-web/v1.1/nft/user/authCode")
    Observable<IBoxResponse<WxLoginResult>> l(@Body Map<String, Object> map);

    @POST("/nft-mall-web/nft/product/getBindBankCardStatus")
    Observable<IBoxResponse<BindBankCardStatusBean>> m(@Body Map<String, Object> map);

    @POST("/nft-mall-web/v1.1/nft/user/bindWechat")
    Observable<IBoxResponse<WxLoginResult>> n(@Body Map<String, Object> map);

    @POST("/nft-mall-web/nft/user/checkToken")
    Observable<IBoxResponse<CheckTokenInfoBean>> o(@Body Map<String, Object> map);
}
