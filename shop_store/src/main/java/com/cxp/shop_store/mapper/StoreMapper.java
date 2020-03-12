package com.cxp.shop_store.mapper;

import com.cxp.shop_api.entity.Store;
import com.cxp.shop_api.entity.StoreBase;
import com.cxp.shop_store.pojo.StoreIdStoreName;
import com.cxp.shop_store.pojo.StoreIdUserId;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StoreMapper {



    //用于 网关 检测用户对应的 店铺id
    @Select("select store_id from store where user_id = #{userId} limit 0,1")
    public Integer selStoreIdByUserId(Integer userId);

    //用户 开通店铺功能
    public int addStoreIdByUserId(StoreBase storeBase);

    //判断用户名是否可以注册 (防止已经有人注册过了)
    @Select("select count(*) from store where store_name = #{storeName} limit 0,1")
    public int storeNameCout(String storeName);


    //返回店铺大致信息：名字、地点 用于组成搜索页商品的店铺信息
    @MapKey("storeId")
    public Map<Integer,StoreBase> mapStoreBaseByStoreId(List<Integer> storeIdList);

    //返回店铺大致信息：名字、地点 用于组成搜索页商品的店铺信息  根据店铺名字 模糊查询
    @MapKey("storeId")
    public Map<Integer,StoreBase> selStoreBaseMapByStoreName(String searchWord);

    //返回店铺完整信息 根据storeId  用于商品页 和 店铺页
    @Select("select * from store where store_id = #{storeId}")
    public Store getStoreByStoreId(@Param("storeId") int storeId);


    //查询一组店铺名 根据id
    public List<StoreIdStoreName> listStoreNameByStoreId(List<Integer> storeIdList);

    //查询用户id 根据店铺id
    public List<StoreIdUserId> listUserIdByStoreId(List<Integer> storeIdList);

    //查询店铺名 根据id
    @Select("select store_name from store where store_id = #{storeId}")
    public String  getStoreNameByStoreId(@Param("storeId") Integer storeId);
}
