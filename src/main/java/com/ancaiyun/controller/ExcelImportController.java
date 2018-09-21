package com.ancaiyun.controller;

import com.ancaiyun.responseEntity.Material;
import com.ancaiyun.utils.ImportExcelUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ExcelImportController {

    /**
     * 导入物资模板
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "v1/upload", method = RequestMethod.POST)
    public List<Material> doUploadFile(MultipartFile file) throws Exception {

        InputStream in = null;
        List<List<Object>> listob = null;
        in = file.getInputStream();
        listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
        // 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        List<Material> list = new ArrayList<Material>();
        for (int i = 0; i < listob.size(); i++) {
            List<Object> lo = listob.get(i);
            Material m = new Material();
            m.setProductName(String.valueOf(lo.get(0)));
            m.setSpecificationsModel(String.valueOf(lo.get(1)));
            m.setParameter(String.valueOf(lo.get(2)));
            m.setBrand(String.valueOf(lo.get(3)));
            m.setFillingType(String.valueOf(lo.get(4)));
            m.setUnit(String.valueOf(lo.get(5)));
            m.setPurchaseQuantity(String.valueOf(lo.get(6)));
            m.setBidderPrice(String.valueOf(lo.get(7)));
            m.setPricescount(String.valueOf(lo.get(8)));
            m.setDescription(String.valueOf(lo.get(9)));
            list.add(m);
        }
        return list;
    }

}
