package cn.hyperzhu.pay.payments.nativepay;

import cn.hyperzhu.pay.factory.Configuration;
import cn.hyperzhu.pay.payments.nativepay.model.PrepayRequest;
import cn.hyperzhu.pay.payments.nativepay.model.PrepayResponse;
import retrofit2.Call;
import retrofit2.Response;

public class NativePayService {

    private final Configuration configuration;
    private final INativePayApi nativePayApi;

    public NativePayService(Configuration configuration, INativePayApi nativePayApi) {
        this.configuration = configuration;
        this.nativePayApi = nativePayApi;
    }

    public PrepayResponse prepay(PrepayRequest request) throws Exception {
        // 1. 请求接口 & 签名
        Call<PrepayResponse> call = nativePayApi.prepay(
                request.getMchid(),
                request.getOutTradeNo(),
                request.getTotalFee(),
                request.getBody(),
                request.getTimestamp(),
                request.getNotifyUrl(),
                request.createSign(configuration.getPartnerKey()));

        // 2. 获取数据
        Response<PrepayResponse> execute = call.execute();

        // 3. 返回结果
        return execute.body();
    }

}

