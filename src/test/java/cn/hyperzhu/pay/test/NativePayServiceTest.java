package cn.hyperzhu.pay.test;

import cn.hyperzhu.pay.factory.Configuration;
import cn.hyperzhu.pay.factory.PayFactory;
import cn.hyperzhu.pay.factory.defaults.DefaultPayFactory;
import cn.hyperzhu.pay.payments.nativepay.NativePayService;
import cn.hyperzhu.pay.payments.nativepay.model.PrepayRequest;
import cn.hyperzhu.pay.payments.nativepay.model.PrepayResponse;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class NativePayServiceTest {

    private NativePayService nativePayService;

    @Before
    public void init() {
        Configuration configuration = new Configuration(
                "xxxxxx", "xxxxxxxx", "xxxxxxxxxxxxxxxxxxxxxxxxxxxx"
        );

        PayFactory payFactory = new DefaultPayFactory(configuration);
        this.nativePayService = payFactory.nativePayService();
    }

    @Test
    public void test_prepay() throws Exception {
        // 1. 请求参数
        PrepayRequest request = new PrepayRequest();
        request.setMchid("xxxxxxxxxxxxxx");
        request.setOutTradeNo(RandomStringUtils.randomNumeric(8));
        request.setTotalFee("0.01");
        request.setBody("xxxxxxx");
        request.setNotifyUrl("https://xxxxxxxxxxxxxxx");

        // 2. 创建支付订单
        PrepayResponse response = nativePayService.prepay(request);

        log.info("请求参数:{}", JSON.toJSONString(request));
        log.info("应答结果:{}", JSON.toJSONString(response));

    }

}

