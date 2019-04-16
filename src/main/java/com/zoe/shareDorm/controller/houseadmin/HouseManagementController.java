package com.zoe.shareDorm.controller.houseadmin;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoe.shareDorm.po.House;
import com.zoe.shareDorm.po.Member;
import com.zoe.shareDorm.po.Request;
import com.zoe.shareDorm.service.HouseService;
import com.zoe.shareDorm.util.CodeUtil;
import com.zoe.shareDorm.util.HttpServletRequestUtil;
import com.zoe.shareDorm.vo.HouseVo;
import com.zoe.shareDorm.vo.ImageHolder;
import org.springframework.beans.Mergeable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
            else {

                // ObjectMapper是com.fasterxml.jackson.databind.ObjectMapper;
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




    @ResponseBody
    @RequestMapping("addHouse")
    public String addHouse(House house, MultipartFile file, HttpServletRequest request) throws IOException {

        System.out.println("提交的房源："+house);
        //定义图片上传后的路径
        String filePath = request.getSession().getServletContext().getRealPath("/upload");
        String newFileName = fileOperate(file,filePath);
        house.setImage(newFileName);
        System.out.println("最后的house"+house);
        houseService.insert(house);
        return "redirect:/gethouselist";
    }

    /**
     * 封装操作文件方法， 添加用户 和修改用户都会用到
     * @param file
     * @param filePath
     * @return
     */
    private String fileOperate(MultipartFile file,String filePath) {
        String originalFileName = file.getOriginalFilename();//获取原始图片的扩展名
        System.out.println("图片原始名称："+originalFileName);
        String newFileName = UUID.randomUUID()+originalFileName;  //新的文件名称
        System.out.println("新的文件名称："+newFileName);
        File targetFile = new File(filePath,newFileName); //创建新文件
        try {
            file.transferTo(targetFile); //把本地文件上传到文件位置 , transferTo()是springmvc封装的方法，用于图片上传时，把内存中图片写入磁盘
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileName;
    }

}