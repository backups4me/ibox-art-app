package com.ibox.nft.network.art.config;

import com.ibox.network.lib.bean.IBoxResponse;
import com.ibox.nft.network.art.beans.AlbumDetailBean;
import com.ibox.nft.network.art.beans.ArtBrandInfoBean;
import com.ibox.nft.network.art.beans.ArtProductDetailBean;
import com.ibox.nft.network.art.beans.ArtProductInfoBean;
import com.ibox.nft.network.art.beans.ArtProductResultResp;
import com.ibox.nft.network.art.beans.ArtResellPoundageBean;
import com.ibox.nft.network.art.beans.BlindBoxDetailBean;
import com.ibox.nft.network.art.beans.BlindBoxInfoBean;
import com.ibox.nft.network.art.beans.BlindBoxResellResp;
import com.ibox.nft.network.art.beans.BlindBoxResultResp;
import com.ibox.nft.network.art.beans.GroupBlindBoxResultResp;
import com.ibox.nft.network.art.beans.GroupProductResultResp;
import com.ibox.nft.network.art.beans.OpenBlindBoxDynamicBean;
import com.ibox.nft.network.art.beans.OrderDetailInfoBean;
import com.ibox.nft.network.art.beans.OrderListResp;
import com.ibox.nft.network.art.beans.OrderPrePayResp;
import com.ibox.nft.network.art.beans.ResellResultResp;
import com.ibox.nft.network.art.beans.SearchResultResp;
import com.ibox.nft.network.art.beans.SynthesisArtInfoBean;
import com.ibox.nft.network.art.beans.SynthesisArtItemBean;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/* loaded from: IArtApiService.class */
public interface IArtApiService {
    @POST("/nft-mall-web/v1/nft/blind/open")
    Observable<IBoxResponse<ArtProductResultResp>> A(@Body Map<String, Object> map);

    @POST("/nft-mall-web/nft/product/goodsSetUpResale")
    Observable<IBoxResponse<String>> B(@Body Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getGoodsListByAlbumId")
    Observable<IBoxResponse<BlindBoxResultResp>> C(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getResellList")
    Observable<IBoxResponse<ResellResultResp>> D(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1/nft/order/payContinue")
    Observable<IBoxResponse<OrderPrePayResp<String>>> E(@QueryMap Map<String, Object> map);

    @POST("/nft-mall-web/nft/order/callback")
    Observable<IBoxResponse<Object>> F(@Body Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/searchPersonalGoods")
    Observable<IBoxResponse<BlindBoxResultResp>> G(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1/nft/order/list")
    Observable<IBoxResponse<OrderListResp>> H(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getAlbumSearch")
    Observable<IBoxResponse<ArtProductResultResp>> I(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1.1/nft/blind/getDynamic")
    Observable<IBoxResponse<List<OpenBlindBoxDynamicBean>>> J(@QueryMap Map<String, Object> map);

    @POST("/nft-mall-web/nft/product/blindSetUpResale")
    Observable<IBoxResponse<BlindBoxResellResp>> K(@Body Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getCollectionListByUidV3")
    Observable<IBoxResponse<BlindBoxResultResp>> a(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getAlbumDetails")
    Observable<IBoxResponse<AlbumDetailBean>> b(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getProductDetail")
    Observable<IBoxResponse<ArtProductDetailBean>> c(@QueryMap Map<String, Object> map);

    @POST("/nft-mall-web/nft/order/create")
    Observable<IBoxResponse<OrderPrePayResp<String>>> d(@Body Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getGoodsListByAlbumId")
    Observable<IBoxResponse<ArtProductResultResp>> e(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1/nft/order/payContinue")
    Observable<IBoxResponse<OrderPrePayResp<String>>> f(@QueryMap Map<String, Object> map);

    @POST("/nft-mall-web/nft/product/getGoodsPoundage")
    Observable<IBoxResponse<ArtResellPoundageBean>> g(@Body Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getCollectionListByUidV3")
    Observable<IBoxResponse<GroupBlindBoxResultResp>> h(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/searchGoodsV2")
    Observable<IBoxResponse<SearchResultResp>> i(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getHotSaleList")
    Observable<IBoxResponse<List<ArtProductInfoBean>>> j(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/searchPersonalGoods")
    Observable<IBoxResponse<ArtProductResultResp>> k(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1/nft/order/detail")
    Observable<IBoxResponse<OrderDetailInfoBean>> l(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getCollectionListByUidV2")
    @Deprecated
    Observable<IBoxResponse<BlindBoxResultResp>> m(@QueryMap Map<String, Object> map);

    @POST("/nft-mall-web/v1/nft/order/create")
    Observable<IBoxResponse<OrderPrePayResp<String>>> n(@Body Map<String, Object> map);

    @GET("/nft-mall-web/v1/nft/blind/info")
    Observable<IBoxResponse<BlindBoxDetailBean>> o(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/blind/list")
    Observable<IBoxResponse<List<BlindBoxInfoBean>>> p(@QueryMap Map<String, Object> map);

    @POST("/nft-mall-web/nft/product/syntheticNewGoods")
    Observable<IBoxResponse<SynthesisArtInfoBean>> q(@Body Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getAlbumByBrand")
    Observable<IBoxResponse<ArtProductResultResp>> r(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getCollectionListByUidV2")
    @Deprecated
    Observable<IBoxResponse<ArtProductResultResp>> s(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getCollectionListByUidV3")
    Observable<IBoxResponse<GroupProductResultResp>> t(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getBrandList")
    Observable<IBoxResponse<List<ArtBrandInfoBean>>> u(@QueryMap Map<String, Object> map);

    @POST("/nft-mall-web/v1/nft/blind/order/create")
    Observable<IBoxResponse<OrderPrePayResp<String>>> v(@Body Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getSyntheticGoodsList")
    Observable<IBoxResponse<SynthesisArtItemBean>> w(@QueryMap Map<String, Object> map);

    @GET("/nft-mall-web/v1.2/nft/product/getCollectionListByUidV3")
    Observable<IBoxResponse<ArtProductResultResp>> x(@QueryMap Map<String, Object> map);

    @POST("/nft-mall-web/nft/product/getBlindPoundage")
    Observable<IBoxResponse<ArtResellPoundageBean>> y(@Body Map<String, Object> map);

    @POST("/nft-mall-web/nft/order/cancle")
    Observable<IBoxResponse<Object>> z(@Body Map<String, Object> map);
}
