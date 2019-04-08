package com.zoe.shareDorm.controller.houseadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/houseadmin",method = {RequestMethod.GET})
/**
 * 主要用来解析路由器并转发到相应的html;
 *
 */
public class HouseAdminController {
    @RequestMapping(value = "/houseoperation")
    public String houseOperation(){
        // 转发至店铺注册/编辑页面
        //在springmvc的配置中已经设定了前后缀
        return "house/houseoperation";
    }
}
