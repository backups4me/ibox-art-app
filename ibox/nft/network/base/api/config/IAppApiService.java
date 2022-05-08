package com.ibox.nft.network.base.api.config;

import com.ibox.network.lib.bean.IBoxResponse;
import com.ibox.nft.network.base.api.bean.AppConfigInfoBean;
import com.ibox.nft.network.base.api.bean.IBoxBannerBean;
import com.ibox.nft.network.base.api.bean.IBoxNoticeInfoBean;
import com.ibox.nft.network.base.api.bean.IBoxVersionInfo;
import com.ibox.nft.network.base.api.bean.RecommendInfoBean;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;

/* loaded from: IAppApiService.class */
public interface IAppApiService {
    @POST("/file/upload")
    @Multipart
    Observable<IBoxResponse<List<String>>> a(@Header("IB-USER-TOKEN") String str, @PartMap Map<String, RequestBody> map);

    @GET("/nft-mall-web/v1.2/nft/banner/getBannerByType")
    Observable<IBoxResponse<List<IBoxBannerBean>>> b(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getNoticeList")
    Observable<IBoxResponse<List<IBoxNoticeInfoBean>>> c(@QueryMap Map<String, Object> map);

    @POST("/nft-mall-web/nft/yee/uploadPic")
    @Multipart
    Observable<IBoxResponse<String>> d(@Header("IB-USER-TOKEN") String str, @PartMap Map<String, RequestBody> map);

    @GET("/nft-mall-web/v1.2/nft/recommend/list")
    Observable<IBoxResponse<List<RecommendInfoBean>>> e(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/nft/app/getConfig")
    Observable<IBoxResponse<AppConfigInfoBean>> f(@QueryMap Map<String, Object> map);

    @POST("/nft-mall-web/v1.1/nft/user/checkVersion")
    Observable<IBoxResponse<IBoxVersionInfo>> g(@Body Map<String, Object> map);

    @POST("/nft-mall-web/nft/product/openYeeWallet")
    Observable<IBoxResponse<Object>> h(@Body Map<String, Object> map);
}
