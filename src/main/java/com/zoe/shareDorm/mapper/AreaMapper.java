package com.zoe.shareDorm.mapper;

import com.zoe.shareDorm.po.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AreaMapper")
public interface AreaMapper {
    /**
     * 列出区域列表
     *
     * @return areaList
     */
    List<Area> queryArea();
}
