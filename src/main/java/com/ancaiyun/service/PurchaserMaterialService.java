package com.ancaiyun.service;

import com.ancaiyun.responseEntity.PurchaserMaterial;
import com.ancaiyun.utils.Result;

import java.util.Map;

public interface PurchaserMaterialService {
    /**
     * 动态分页获取物资列表
     * @return
     */
    Result getPurchaserMaterialList(Integer pageSize,Integer pageum,Map<String,Object> params);

    /**
     * 移除物资
     * @param id
     * @return
     */
    Result delPurchaserMaterial(String id);

    /**
     * 修改编码
     * @param purchaserMaterial
     * @return
     */
    Result updatePurchaserMaterial(PurchaserMaterial purchaserMaterial);


}
