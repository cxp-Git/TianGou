

export default {

  store_center_background: '',



  userOrderState:{
    WAIT_PAYMENT : 0,   //待付款
    WAIT_SHIPMENTS : 1, //待发货
    WAIT_RECEIVING : 2, //待收货
    WAIT_EVALUATED : 2, //待评价
  },


  ResultStatus: {
       //user 2xx
      USER_NAME_DISABLED : 201,           //用户名不可用  重复了
      USER_Add_ERROR : 202,               //用户注册失败
      USER_LOGIN_ERROR : 203,             //用户登录失败
      USER_PASSWORD_CHANGE_ERROR : 204,   //修改密码失败
      USER_ID_ERROR : 205,                //账号ID不存在
      USER_ID_LOGIN_OVERDUE : 206,        //用户过期或未登录
      USER_MONEY_INSUFFICIENT : 207,      //买家购物余额不足
      USER_MONEY_CHANGE_ERROE : 208,      //用户余额改变失败
      USER_PHOTO_UPLOAD_ERROE : 209,      //用户头像上传失败
      USER_PHOTO_CHANGE_ERROE : 210,      //用户头像改变失败

      //店铺 3xx
      STORE_NOT_REGISTER : 301,           //未开通 卖家功能
      STORE_NAME_DISABLED : 302,          //店铺名不可用  重复了
      STORE_REGISTER_ERROR : 303,         //用户开通卖家功能 失败
      STORE_ID_ERROR : 304,               //店铺ID不存在
      STORE_EQUAL_USER_ERROR : 305,       //用户买自己店铺的商品


      //商品 4xx
      COMMODITY_NOT_FOUND : 401,           //找不到sql符合条件的某一个商品
      COMMODITY_STOCK_INSUFFICIENT : 402, //商品库存不足买家购买
      COMMODITY_INSERT_ERROR : 403,       //商品添加失败
      COMMODITY_UPDATE_ERROR : 404,       //商品修改失败

      //订单5xx
      ORDER_List_ERROR : 501,             //订单添加失败
      ORDER_Add_ERROR : 502,              //订单添加失败
      ORDER_NOT_FIND : 503,               //订单找不到
      ORDER_ID_USER_ID_MISMATCHING : 504, //订单id 和 买家id不匹配
      ORDER_SUBMIT_ERROR : 505,           //订单支付错误


      //数据库添加失败  6xx
      COLLECT_Add_ERROR : 601,      //收藏夹添加失败
      SHOPCAR_Add_ERROR : 603,      //购物车添加失败

  }

}
