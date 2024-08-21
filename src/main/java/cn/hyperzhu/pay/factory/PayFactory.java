package cn.hyperzhu.pay.factory;


import cn.hyperzhu.pay.payments.h5.H5PayService;
import cn.hyperzhu.pay.payments.nativepay.NativePayService;

public interface PayFactory {

    NativePayService nativePayService();

    H5PayService h5PayService();
}
