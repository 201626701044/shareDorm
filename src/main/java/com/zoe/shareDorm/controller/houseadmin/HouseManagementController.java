package com.zoe.shareDorm.controller.houseadmin;


import com.zoe.shareDorm.po.House;
import com.zoe.shareDorm.po.Member;
import com.zoe.shareDorm.po.Request;
import com.zoe.shareDorm.service.HouseService;
import org.springframework.beans.Mergeable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/houseadmin")
public class HouseManagementController {
    @Autowired
    private HouseService houseService;

    @RequestMapping(value = "/gethouselist", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getHouseList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            List<House> houseList = houseService.queryHouseList();
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