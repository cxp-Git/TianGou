package com.cxp.shop_order.service;


import com.cxp.shop_api.entity.OrderParent;
import com.cxp.shop_api.entity.OrderSon;
import com.cxp.shop_api.result.ResultBean;
import com.cxp.shop_api.vo.StoreStatusFullVO;
import com.cxp.shop_order.eception.AddOrderException;

import java.util.LinkedList;
import java.util.List;

public interface OrderService {


    //添加订单
    public ResultBean submitOrder(Integer userId, LinkedList<OrderSon> orderSonList) throws AddOrderException;
    //支付订单
    public ResultBean payOrderByUserId(int userId, String orderTime);

    //查询店铺状态
    public StoreStatusFullVO selStoreStatusFullVO(Integer storeId);




    //查询该卖家所有订单 总体内容
    public List<OrderParent> listStoreOrderParentRough(Integer storeId);
    //查询该用户所有订单 总体内容
    public List<OrderParent> listUserOrderParentRough(Integer userId, Integer orderState);


    //查询该卖家某一个订单 详细内容
    public OrderParent selStoreOrderParent(Integer storeId, Integer orderId);
    //查询该用户某一个订单 详细内容
    public OrderParent selUserOrderParent(Integer userId, Integer orderId);



}
