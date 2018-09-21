package com.ancaiyun.controller;

import com.ancaiyun.responseEntity.PurchaserMaterial;
import com.ancaiyun.service.PurchaserMaterialService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PurchaserMaterialController {

    @Autowired
    private PurchaserMaterialService purchaserMaterialService;

    /**
     * 动态分页查询物资列表
     * @param pageNum
     * @param pageSize
     * @param params
     * @return
     */
    @RequestMapping(value = "v1/auth/material/pagenation",method = RequestMethod.GET)
    public Result getPurchaserMaterialList(Integer pageNum, Integer pageSize, @RequestParam Map<String,Object> params){
        return purchaserMaterialService.getPurchaserMaterialList(pageNum,pageSize,params);
    }

    /**
     * 动态分页查询物资列表(公共权限)
     * @param pageNum
     * @param pageSize
     * @param params
     * @return
     */
    @RequestMapping(value = "v1/auth/common/pagenation",method = RequestMethod.GET)
    public Result getPurchaserMaterials(Integer pageNum, Integer pageSize, @RequestParam Map<String,Object> params){
        return purchaserMaterialService.getPurchaserMaterialList(pageNum,pageSize,params);
    }

    /**
     * 移除物资
     * @param id
     * @return
     */
    @RequestMapping(value = "v1/auth/material/del",method = RequestMethod.DELETE)
    public Result delMaterial(String id){
        return purchaserMaterialService.delPurchaserMaterial(id);
    }

    /**
     * 修改编码
     * @param purchaserMaterial
     * @return
     */
    @RequestMapping(value = "v1/auth/material",method = RequestMethod.POST)
    public Result updateMetarialEncoding(PurchaserMaterial purchaserMaterial){
        return purchaserMaterialService.updatePurchaserMaterial(purchaserMaterial);
    }
}
