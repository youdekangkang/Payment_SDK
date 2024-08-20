package cn.hyperzhu.pay.factory;

import lombok.Getter;
import lombok.Setter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Getter
public class Configuration {

    @Setter
    private String apiHost = "https://api.ltzf.cn/";

    // 开发者ID
    private final String appId;
    // 商户号ID
    private final String merchantId;
    // 商户秘钥
    private final String partnerKey;

    public Configuration(String appId, String merchantId, String partnerKey) {
        this.appId = appId;
        this.merchantId = merchantId;
        this.partnerKey = partnerKey;
    }

    @Setter
    private OkHttpClient okHttpClient;
    // okHttp本身提供日志的级别
    @Setter
    private HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.HEADERS;
    // 各种超时时间
    @Setter
    private long connectTimeout = 60;
    @Setter
    private long writeTimeout = 60;
    @Setter
    private long readTimeout = 60;

}

