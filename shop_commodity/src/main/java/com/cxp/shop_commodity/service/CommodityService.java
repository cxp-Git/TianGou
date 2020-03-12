package com.cxp.shop_commodity.service;

import com.cxp.shop_api.dto.CommodityToCart;
import com.cxp.shop_api.dto.PurchaseDTO;
import com.cxp.shop_api.entity.Commodity;
import com.cxp.shop_api.entity.Sort;
import com.cxp.shop_api.request.SearchRequest;
import com.cxp.shop_api.result.ResultBean;
import com.cxp.shop_api.vo.CartCommodityVO;
import com.cxp.shop_api.vo.FavoriteCommodityVO;
import com.cxp.shop_api.vo.SearchVO;
import com.cxp.shop_api.vo.StoreCommodityVO;

import java.util.List;
import java.util.Map;

public interface CommodityService {

    //查询商品种类列表
    public List<Sort> listSort();

    //添加商品
    public ResultBean addCommodity(Commodity commodity);

    //修改商品
    public ResultBean updCommodity(Commodity commodity);
    //修改商品上架状态
    public boolean updCommodityOnShelves(Integer storeId, Integer commodityId, Boolean commodityOnShelves);
    //删除商品 永久下架
    public boolean delCommodity(Integer storeId, Integer commodityId);

    //根据商品id返回商品简单信息给 收藏夹微服务 调用
    public Map<Integer, FavoriteCommodityVO> mapFavoriteCommodityVO(List<Integer> commodityIdList);


    //根据商品id返回 一个商品数据
    public Commodity getCommodityPageByCommodityId(int commodityId);
    //返回搜索页 商品信息
    public SearchVO getSearchVO(SearchRequest searchPage_request);

    //搜索商品用于生成购物车
    public CommodityToCart getCommodityToCart(Integer commodityId);
    //返回购物车 商品信息
    public Map<Integer, CartCommodityVO> mapCartCommodityVO(List<Integer> commodityIdList);
    //返回  店铺所销售的商品信息
    public List<StoreCommodityVO> listStoreCommodityVOByStoreId(int storeId);

    //查询商品 用于 店铺修改商品
    public Commodity getCommodityByCommodityId(int commodityId);

    //返回  店铺所销售的信息
    //判断是否 用户购买自己的视频
    public boolean isCommodityStoreEqualUser(int userId, int commodityId);

    //用于订单微服务 提交订单  需要的店铺id 单价  库存
    public  ResultBean getCommodityToOrder(Integer userId, PurchaseDTO purchaseDTO);
    public  ResultBean listCommodityToOrder(Integer userId, List<PurchaseDTO> purchaseDTOList);
    //修改商品 库存 销量
    public ResultBean subCommodityNumber(List<PurchaseDTO> purchaseDTOList);
    //交易过期 回滚商品表 商品数量
    public void addCommodityQuantity(PurchaseDTO purchaseDTO);
    public void addCommodityQuantityList(List<PurchaseDTO> purchaseDTOList);
}
