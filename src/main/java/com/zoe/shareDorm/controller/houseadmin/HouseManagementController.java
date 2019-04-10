package com.zoe.shareDorm.controller.houseadmin;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoe.shareDorm.po.House;
import com.zoe.shareDorm.po.Member;
import com.zoe.shareDorm.po.Request;
import com.zoe.shareDorm.service.HouseService;
import com.zoe.shareDorm.util.HttpServletRequestUtil;
import com.zoe.shareDorm.vo.HouseVo;
import org.springframework.beans.Mergeable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/houseadmin")
public class HouseManagementController {
    @Autowired
    private HouseService houseService;

    @RequestMapping(value = "/gethouselist", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> getHouseList(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            // 1.接收并转化相应的参数，包
            String   houseStr = HttpServletRequestUtil.getString(request, "houseStr");
            System.out.println("houseStr="+houseStr);

            HouseVo  houseVo=null;
            if (houseStr==null) houseVo=new HouseVo();
            else {   // ObjectMapper是com.fasterxml.jackson.databind.ObjectMapper;
                // 用于json和pojo对象的转换。
                ObjectMapper mapper = new ObjectMapper();

                try {
                    // 将表单中接收到的shop信息转成shop对象
                    houseVo = mapper.readValue(houseStr, HouseVo.class);
                    System.out.println(houseVo.getWay());
                } catch (Exception e) {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", e.getMessage());
                    return modelMap;
                }
            }

            List<House> houseList = houseService.queryHouseList(houseVo);
            modelMap.put("houseList", houseList);
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/homePage")
    public String houseList() {
        return "house/homePage";
    }


    @RequestMapping(value = "/queryByArea", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> queryByArea(@RequestParam("area") String area) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            List<House> houseList = houseService.queryByArea(area);
            modelMap.put("houseList", houseList);
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }
}