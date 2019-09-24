package com.example.service.impl;

import com.example.dao.AreaDao;
import com.example.entity.Area;
import com.example.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author xnz
 * @date 2019/9/20 11:44
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Override
    // Transactional 默认当发生RuntimeException()异常时会发生回滚
    //可通过配置 @Transactional(rollbackFor=Exception.class) 时，可使其在发生Exception时回滚
    @Transactional
    public boolean addArea(Area area) {
        if(area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastTime(new Date());
            try {
                int i = areaDao.insertArea(area);
                if(i>0){
                    return true;
                }else {
                    throw new RuntimeException("添加信息失败！");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("插入信息失败: " + e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不可为空！");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaId() != null && area.getAreaId()>0){
            area.setLastTime(new Date());
            try {
                int i = areaDao.updateArea(area);
                if(i>0){
                    return true;
                }else {
                    throw new RuntimeException("更新信息失败！");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("更新信息失败: " + e.toString());
            }
        }else {
            throw new RuntimeException("区域id不可为空！");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId>0){
            try {
                int i = areaDao.deleteArea(areaId);
                if(i>0){
                    return true;
                }else {
                    throw new RuntimeException("删除信息失败！");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("删除信息失败: " + e.toString());
            }
        }else {
            throw new RuntimeException("区域id不可为空！");
        }
    }
}
