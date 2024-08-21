package cn.hyperzhu.pay.payments.h5;

import cn.hyperzhu.pay.factory.Configuration;
import cn.hyperzhu.pay.payments.h5.model.*;
import retrofit2.Call;

public class H5PayService {

    private final Configuration configuration;
    private final IH5PayApi h5PayApi;

    public H5PayService(Configuration configuration, IH5PayApi h5PayApi) {
        this.configuration = configuration;
        this.h5PayApi = h5PayApi;
    }

    /**
     * 扫码支付，创建订单
     *
     * @param request 请求入参
     * @return 支付订单，含支付地址和图片
     * @throws Exception 异常
     */
    public PrepayResponse prepay(PrepayRequest request) throws Exception {
        // 1. 请求接口 & 签名
        Call<PrepayResponse> call = h5PayApi.prepay(
                request.getMchid(),
                request.getOutTradeNo(),
                request.getTotalFee(),
                request.getBody(),
                request.getTimestamp(),
                request.getNotifyUrl(),
                request.getReturnUrl(),
                request.getAttach(),
                request.createSign(configuration.getPartnerKey()));

        // 2. 获取数据
        retrofit2.Response<PrepayResponse> execute = call.execute();

        // 3. 返回结果
        return execute.body();
    }

    /**
     * 查询订单
     *
     * @param request 请求入参
     * @return 订单信息
     * @throws Exception 异常
     */
    public QueryOrderByOutTradeNoResponse queryOrderByOutTradeNo(QueryOrderByOutTradeNoRequest request) throws Exception {
        // 1. 请求接口 & 签名
        Call<QueryOrderByOutTradeNoResponse> call = h5PayApi.getPayOrder(
                request.getMchid(),
                request.getOutTradeNo(),
                request.getTimestamp(),
                request.createSign(configuration.getPartnerKey()));

        // 2. 获取数据
        retrofit2.Response<QueryOrderByOutTradeNoResponse> execute = call.execute();

        // 3. 返回结果
        return execute.body();
    }

    /**
     * 发起退单
     *
     * @param request 退单信息
     * @return 退单结果
     * @throws Exception 异常
     */
    public RefundOrderResponse refundOrder(RefundOrderRequest request) throws Exception {
        // 1. 请求接口 & 签名
        Call<RefundOrderResponse> call = h5PayApi.refundOrder(
                request.getMchid(),
                request.getOutTradeNo(),
                request.getOutRefundNo(),
                request.getTimestamp(),
                request.getRefundFee(),
                request.getRefundDesc(),
                request.getNotifyUrl(),
                request.createSign(configuration.getPartnerKey()));

        // 2. 获取数据
        retrofit2.Response<RefundOrderResponse> execute = call.execute();

        // 3. 返回结果
        return execute.body();
    }

    /**
     * 查询退单结果
     * @param request 请求参数
     * @return 退单信息
     * @throws Exception 异常
     */
    public GetRefundOrderResponse getRefundOrder(GetRefundOrderRequest request) throws Exception {
        // 1. 请求接口 & 签名
        Call<GetRefundOrderResponse> call = h5PayApi.getRefundOrder(
                request.getMchid(),
                request.getOutRefundNo(),
                request.getTimestamp(),
                request.createSign(configuration.getPartnerKey()));

        // 2. 获取数据
        retrofit2.Response<GetRefundOrderResponse> execute = call.execute();

        // 3. 返回结果
        return execute.body();
    }

}
