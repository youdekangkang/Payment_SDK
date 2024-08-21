package cn.hyperzhu.pay.test;

import cn.hyperzhu.pay.payments.nativepay.INativePayApi;
import cn.hyperzhu.pay.payments.nativepay.model.PrepayResponse;
import cn.hyperzhu.pay.utils.SignUtils;
import com.alibaba.fastjson.JSON;
import okhttp3.OkHttpClient;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.sun.javafx.webkit.InputMethodClientImpl.log;

public class ApiTest {
    public static void main(String[] args) {
        System.out.println("");
    }

    @Test
    public void test_retrofit2() throws IOException {
        OkHttpClient httpClient = new OkHttpClient();

        INativePayApi nativePayApi = new Retrofit.Builder()
                .baseUrl("https://api.ltzf.cn/")
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(INativePayApi.class);

        long timestamp = System.currentTimeMillis() / 1000;
        System.out.println(timestamp);

        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("mch_id", "");
        dataMap.put("out_trade_no", "");
        dataMap.put("total_fee", "0.01");
        dataMap.put("body", "");
        dataMap.put("timestamp", String.valueOf(timestamp));
        dataMap.put("notify_url", "");


        Call<PrepayResponse> call = nativePayApi.prepay(
                dataMap.get("mch_id"),
                dataMap.get("out_trade_no"),
                dataMap.get("total_fee"),
                dataMap.get("body"),
                dataMap.get("timestamp"),
                dataMap.get("notify_url"),
                SignUtils.createSign(dataMap, "6d3e889f359fcb83d150e9553a9217b9"));

        Response<PrepayResponse> response = call.execute();
        Object object = response.body();

//        log.info("测试结果:{}", JSON.toJSONString(object));

    }


}
