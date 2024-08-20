package cn.hyperzhu.pay.payments.nativepay;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface INativePayApi {

    @POST("api/wxpay/native")
    @FormUrlEncoded
    @Headers("content-type: application/x-www-form-urlencoded")
    Call<Object> prepay(@Field("mch_id") String mchId,
                        @Field("out_trade_no") String outTradeNo,
                        @Field("total_fee") String totalFee,
                        @Field("body") String body,
                        @Field("timestamp") String timestamp,
                        @Field("notify_url") String notifyUrl,
                        @Field("sign") String sign
    );

}

