package com.ancaiyun.mapper;

import com.ancaiyun.responseEntity.PurchaserMaterial;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PurchaserMaterialMapper {

    /**
     * 动态查询物资列表
     * @param params
     * @return
     */
    List<PurchaserMaterial> selectAllBySelective(Map<String,Object> params);

    /**
     * 移除物资
     * @param record
     * @return
     */
    int delMaterial(String record);

    /**
     * 修改物资编码
     * @param purchaserMaterial
     * @return
     */
    int updateMaterialEncoding(PurchaserMaterial purchaserMaterial);
}
