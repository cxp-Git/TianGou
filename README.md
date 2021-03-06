
仿天猫 分布式电商项目
====  

使用技术： Vue + Element + SpringCloud + Maven + Mybatis + RabbitMQ
--

### 项目描述:
项目采用前后端分离技术，前端通过vue、Element 进行用户交互和数据展示，后台通过SpringCloud 对项目按功能模块进行划分，并通过Feign实现服务交互与负载均衡。前后端使用http协议进行数据交互，共同完成 用户身份验证、商品信息可视化、金融交易，等业务流程处理。
作品用时一个半月，用于近期的校招和几个月后的毕业设计

## [>>效果展示<<](#xiaoGuo)
#### 源码：	[https://github.com/cxp-Git/TianGou](https://github.com/cxp-Git/TianGou)
# 项目结构:

<table>
  <tr>
    <th width=8%>端口</th>
    <th width=20%>应用</th>
    <th width="25%">说明</th>
    <th width="27%">数据表</th>
  </tr>
  <tr>
    <td > 3306 </td>
    <td> mysql  </td>
    <td> 用户：  root , 密码：  123456 </td>
    <td>  </td>
  </tr>
  <tr>
    <td>  6379 </td>
    <td> redis</td>
    <td> key=>   token  , value=> userId </td>
    <td>   </td>
  </tr>
  <tr>
    <td>   </td>
    <td> shop_api</td>
    <td>  公共实体类 Maven项目 </td>
    <td>   </td>
  </tr>
  <tr>
    <td>  80 </td>
    <td> shop_vue</td>
    <td>  vue前端 </td>
    <td>   </td>
  </tr>
  <tr>
    <td>  8761 </td>
    <td> shop_eureka</td>
    <td>  eureka注册中心 </td>
    <td>   </td>
  </tr>
  <tr>
    <td>  7000 </td>
    <td> shop_zuul</td>
    <td>  zuul网关 </td>
    <td>   </td>
  </tr>
  <tr>
      <td>  7010 </td>
      <td> images_zuul</td>
      <td>  七牛云_图片微服务 </td>
      <td>   </td>
    </tr>
  <tr>
    <td>  7020 </td>
    <td> shop_user</td>
    <td>  用户_微服务 </td>
    <td>  user （账号）</td>
  </tr>
  <tr>
    <td>  7030 </td>
    <td> shop_store</td>
    <td>  店铺_微服务 </td>
    <td>  store （店铺） </td>
  </tr>
  <tr>
    <td>  7040 </td>
    <td> shop_commodity</td>
    <td>  商品_微服务 </td>
    <td>  commodity（商品），sort （种类）</td>
  </tr>
   <tr>
    <td>  7050 </td>
    <td> shop_order</td>
    <td>  订单_微服务 </td>
    <td>  order_parent（订单父表），order_son（订单子表） </td>
  </tr>
   <tr>
    <td>  7060 </td>
    <td> shop_car</td>
    <td>  购物车_微服务 </td>
    <td>  shop_car（购物车） </td>
  </tr>
  <tr>
    <td>  7070 </td>
    <td> shop_favorite</td>
    <td>  收藏夹_微服务 </td>
    <td>  favorite（收藏夹） </td>
  </tr>
</table>

# 数据表
* user ====>用户(用户Id，用户名，密码，头像图片名字，余额)
* store ===> 店铺(店铺Id，店铺名，省，市，评分如实描述，评分服务态度，评分发货速度)
* sort ====>种类(种类Id，种类名字)
* commodity>商品(商品Id，店铺Id，种类Id，商品名，商品描述，包邮，单价，销量，人气，库存，是否处于上架状态，商品图片名字，商品视频名字)
* order_parent > 订单父表（订单Id，用户Id，店铺Id，下单时间，订单总数量，订单总金额，订单支付状态）
* order_son ==> 订单子表(订单Id，商品Id，选购数量，商品单价)
* shop_car => 购物车(购物车Id，用户Id，商品Id，选购数量)
* favorite ==>收藏夹(用户Id，商品Id，加入时间)

# 项目要点：
* 通过SpringCloud 对项目按功能模块进行划分，并通过Feign实现服务交互与负载均衡
* 建立shop_api  Maven项目编写公共实体类，通过其他项目聚合以保证一致性
* 用户身份验证： 
 1、vue axios设置拦截器请求头添加token 信息                  
2、zuul 网关设置过滤器对指定uri进行token验证，并添加userId,storeId进请求头参数   


* 后台统一返回一定格式数据

```java
public class ResultBean {
    private boolean success;    //操作是否成功
    private int status;         //操作失败对应的类型
    private Object data;        //操作成功后台返回的响应数据
}
```
前端先判断success， 如果为true则获取data，如果为false则根据status对不同类型错误进行响应



<span id="xiaoGuo"/>


# 效果展示
### 关于我们
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200106165142504.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)
### 主页：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200106154520170.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200106154538579.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)
### 搜索页：
右侧可以简略的查看购物车和收藏夹
![在这里插入图片描述](https://img-blog.csdnimg.cn/202001061546185.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)
搜索页进行了分页处理，下拉 搜索框会划出来
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200106154628669.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)


### 商品页

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200106155249514.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)
商品图片可以放大

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020010615485833.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)
### 购物车
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200106155352113.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)
### 收藏夹
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200106155429383.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)
### 卖家中心
#### 更换头像
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200106155655720.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)
#### 查看订单
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200106160141383.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)
#### 订单详细内容
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200106160147751.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)
### 卖家中心
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020010616461674.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)
#### 卖家出售的商品
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200106164727648.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)
#### 添加、修改商品
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200106164917184.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)
### 登录页面
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191110110311322.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)
### 注册页面
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019111011032375.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)

### 错误信息处理
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191110110459678.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20191110110452766.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTQyMzM3OA==,size_16,color_FFFFFF,t_70)