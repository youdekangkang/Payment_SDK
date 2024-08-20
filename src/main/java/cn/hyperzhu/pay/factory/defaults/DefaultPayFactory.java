package cn.hyperzhu.pay.factory.defaults;

import cn.hyperzhu.pay.factory.Configuration;
import cn.hyperzhu.pay.factory.PayFactory;
import cn.hyperzhu.pay.payments.nativepay.INativePayApi;
import cn.hyperzhu.pay.payments.nativepay.NativePayService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.HTTP;

import java.util.concurrent.TimeUnit;

//支付工厂实现类
public class DefaultPayFactory implements PayFactory {

    private Configuration configuration;

    private final OkHttpClient httpClient;

    public DefaultPayFactory(Configuration configuration){
        this.configuration = configuration;
        //1.开启日志
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(configuration.getLevel());


        //2. 开启HTTP客户端
        this.httpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(configuration.getConnectTimeout(), TimeUnit.SECONDS)
                .writeTimeout(configuration.getWriteTimeout(),TimeUnit.SECONDS)
                .readTimeout(configuration.getReadTimeout(),TimeUnit.SECONDS)
                .build();
    }


    @Override
    public NativePayService nativePayService() {
        // 构建API
        INativePayApi nativePayApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(INativePayApi.class);
        // 创建Native支付服务
        return new NativePayService(configuration, nativePayApi);
    }

}
