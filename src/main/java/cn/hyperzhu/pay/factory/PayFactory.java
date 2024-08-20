package cn.hyperzhu.pay.factory;


import cn.hyperzhu.pay.payments.nativepay.NativePayService;

public interface PayFactory {

    NativePayService nativePayService();

}
