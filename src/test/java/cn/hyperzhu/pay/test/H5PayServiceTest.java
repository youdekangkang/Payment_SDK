package cn.hyperzhu.pay.test;

import cn.hyperzhu.pay.factory.Configuration;
import cn.hyperzhu.pay.factory.PayFactory;
import cn.hyperzhu.pay.factory.defaults.DefaultPayFactory;
import cn.hyperzhu.pay.payments.h5.H5PayService;
import cn.hyperzhu.pay.payments.h5.model.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class H5PayServiceTest {

    private H5PayService h5PayService;

    @Before
    public void init() {
        Configuration configuration = new Configuration(
                "xxxxxxxxxxxxx", "xxxxxxxxxxxxxxx", "xxxxxxxxxxxxxxxxxxxx"
        );

        PayFactory payFactory = new DefaultPayFactory(configuration);
        this.h5PayService = payFactory.h5PayService();
    }

    @Test
    public void test_prepay() throws Exception {
        // 1. 请求参数
        PrepayRequest request = new PrepayRequest();
        request.setMchid("xxxxxxx");
        request.setOutTradeNo(RandomStringUtils.randomNumeric(8));
        request.setTotalFee("0.01");
        request.setBody("xxxx");
        request.setNotifyUrl("https://xxxxxxxxxxxx");

        // 2. 创建支付订单
        PrepayResponse response = h5PayService.prepay(request);

//        log.info("请求参数: {}", JSON.toJSONString(request));
//        log.info("应答结果: {}", JSON.toJSONString(response));
    }


    @Test
    public void test_queryOrderByOutTradeNo() throws Exception {
        QueryOrderByOutTradeNoRequest request = new QueryOrderByOutTradeNoRequest();
        request.setMchid("1673424392");
        request.setOutTradeNo("04805636");
        QueryOrderByOutTradeNoResponse response = h5PayService.queryOrderByOutTradeNo(request);
//        log.info("请求参数: {}", JSON.toJSONString(request));
//        log.info("应答结果: {}", JSON.toJSONString(response));
    }

    @Test
    public void test_refundOrder() throws Exception {
        RefundOrderRequest request = new RefundOrderRequest();
        request.setMchid("xxxxxxxxxxxx");
        request.setOutTradeNo("xxxxxxxxxxxx");
        request.setOutRefundNo(RandomStringUtils.randomNumeric(8));
        request.setRefundFee("0.01");
        request.setRefundDesc("测试退款");
        request.setNotifyUrl("https://xxxxxxxxxxxxxxx");

        Object response = h5PayService.refundOrder(request);
//        log.info("请求参数: {}", JSON.toJSONString(request));
//        log.info("应答结果: {}", JSON.toJSONString(response));
    }

    @Test
    public void test_getRefundOrder() throws Exception {
        GetRefundOrderRequest request = new GetRefundOrderRequest();
        request.setMchid("xxxxxxxxxxxxx");
        request.setOutRefundNo("xxxxxxxxxxxxxxx");

        GetRefundOrderResponse response = h5PayService.getRefundOrder(request);
//        log.info("请求参数: {}", JSON.toJSONString(request));
//        log.info("应答结果: {}", JSON.toJSONString(response));
    }

}

