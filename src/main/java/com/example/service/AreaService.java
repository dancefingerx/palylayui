package com.example.service;

import com.example.entity.Area;

import java.util.List;

/**
 * @author xnz
 * @date 2019/9/20 9:56
 */
public interface AreaService {
    /**
     * 列出区域列表
     * @return
     */
    List<Area> getAreaList();


    /**
     * 根据Id列出具体区域
     * @param areaId
     * @return
     */
    Area getAreaById(int areaId);


    /**
     * 插入区域信息
     * @param area
     * @return
     */
    boolean addArea(Area area);


    /**
     * 更新区域信息
     * @param area
     * @return
     */
    boolean modifyArea(Area area);

    /**
     * 删除区域信息
     * @param areaId
     * @return
     */
    boolean deleteArea(int areaId);
}
