package cn.hyperzhu.pay.payments.h5;

import cn.hyperzhu.pay.payments.nativepay.model.PrepayResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IH5PayApi {

    @POST("api/wxpay/h5")
    @FormUrlEncoded
    @Headers("content-type: application/x-www-form-urlencoded")
    Call<PrepayResponse> prepay(@Field("mch_id") String mchId,
                                @Field("out_trade_no") String outTradeNo,
                                @Field("total_fee") String totalFee,
                                @Field("body") String body,
                                @Field("timestamp") String timestamp,
                                @Field("notify_url") String notifyUrl,
                                @Field("return_url") String returnUrl,
                                @Field("sign") String sign
    );

}
