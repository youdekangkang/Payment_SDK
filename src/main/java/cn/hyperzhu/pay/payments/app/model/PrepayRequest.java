package cn.hyperzhu.pay.payments.app.model;

import cn.hyperzhu.pay.utils.SignUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PrepayRequest {

    @JsonProperty("app_id")
    private String appId;
    @JsonProperty("mch_id")
    private String mchid;
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    @JsonProperty("total_fee")
    private String totalFee;
    @JsonProperty("body")
    private String body;
    @JsonProperty("notify_url")
    private String notifyUrl;
    @JsonProperty("attach")
    private String attach;
    @JsonProperty("time_expire")
    private String timeExpire;

    private String timestamp = String.valueOf(System.currentTimeMillis() / 1000);

    public String getTimestamp() {
        return timestamp;
    }

    public String createSign(String partnerKey) {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("app_id", getAppId());
        dataMap.put("mch_id", getMchid());
        dataMap.put("out_trade_no", getOutTradeNo());
        dataMap.put("total_fee", getTotalFee());
        dataMap.put("body", getBody());
        dataMap.put("timestamp", getTimestamp());
        dataMap.put("notify_url", getNotifyUrl());
        return SignUtils.createSign(dataMap, partnerKey);
    }

}

