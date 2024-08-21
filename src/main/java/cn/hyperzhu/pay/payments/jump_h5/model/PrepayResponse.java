package cn.hyperzhu.pay.payments.jump_h5.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrepayResponse {

    private Integer code;
    private String data;
    private String msg;
    @JsonProperty("request_id")
    private String requestId;

}
