package cn.hyperzhu.pay.factory;


import cn.hyperzhu.pay.payments.app.AppPayService;
import cn.hyperzhu.pay.payments.h5.H5PayService;
import cn.hyperzhu.pay.payments.jsapi.JSPayService;
import cn.hyperzhu.pay.payments.jump_h5.JumpH5PayService;
import cn.hyperzhu.pay.payments.nativepay.NativePayService;

public interface PayFactory {

    NativePayService nativePayService();

    H5PayService h5PayService();


    AppPayService appPayService();

    JSPayService jsPayService();

    JumpH5PayService jumpH5PayService();


}
