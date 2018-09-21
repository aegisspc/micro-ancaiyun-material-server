package com.ancaiyun.servicempl;

import com.ancaiyun.mapper.PurchaserMaterialMapper;
import com.ancaiyun.responseEntity.PurchaserMaterial;
import com.ancaiyun.service.PurchaserMaterialService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.CurrentUserUtil;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class PurchaserMaterialServiceImpl implements PurchaserMaterialService {

    @Autowired
    private PurchaserMaterialMapper purchaserMaterialMapper;
    @Autowired(required = false)
    private HttpServletRequest request;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Result getPurchaserMaterialList(Integer pageNum,Integer pageSize,Map<String,Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try{
            Map<String,Object> map = CurrentUserUtil.getUserInfo(request,restTemplate);
            Map<String,Object> memberMap = (Map<String, Object>) map.get("member");
            String memberId = (String) memberMap.get("id");
            if (StringUtils.isNotBlank(memberId)){
                PageHelperNew.startPage(pageNum,pageSize);
                params.put("memberId",memberId);
                List<PurchaserMaterial> purchaserMaterialList = purchaserMaterialMapper.selectAllBySelective(params);
                PageInfo<PurchaserMaterial> page = new PageInfo<>(purchaserMaterialList);
                result.setData(page);
                code = Constants.SUCCESS;
                msg = "成功";
            }else {
                code = "-3";
                msg = "获取用户会员信息失败";
            }
        }catch (Exception e){
            msg = "后台繁忙";
            code = Constants.ERROR;
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result delPurchaserMaterial(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try{
            int i = purchaserMaterialMapper.delMaterial(id);
            if (i>0){
                code = Constants.SUCCESS;
                msg = "成功";
            }else {
                code = "-3";
                msg = "删除物资失败";
            }
        }catch (Exception e){
            msg = "后台繁忙";
            code = Constants.ERROR;
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result updatePurchaserMaterial(PurchaserMaterial purchaserMaterial) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try{
            if (StringUtils.isBlank(purchaserMaterial.getEncoding())){
                purchaserMaterial.setEncoding(null);
            }
            int i = purchaserMaterialMapper.updateMaterialEncoding(purchaserMaterial);
            if (i>0){
                code = Constants.SUCCESS;
                msg = "成功";
            }else {
                code = "-3";
                msg = "修改失败";
            }
        }catch (Exception e){
            msg = "后台繁忙";
            code = Constants.ERROR;
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
