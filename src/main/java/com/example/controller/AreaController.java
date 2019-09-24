package com.example.controller;

import com.example.entity.Area;
import com.example.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xnz
 * @date 2019/9/20 15:10
 */
@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listArea",method = RequestMethod.GET)
    public Map<String,Object> listArea(){
        HashMap<String,Object> modelMap = new HashMap<>();
        List<Area> areaList = areaService.getAreaList();
        modelMap.put("areaList",areaList);
        return modelMap;
    }

    @RequestMapping(value = "/getAreaById",method = RequestMethod.GET)
    public Map<String,Object> getAreaById(Integer areaId){
        HashMap<String,Object> modelMap = new HashMap<>();
        Area area = areaService.getAreaById(areaId);
        modelMap.put("area",area);
        return modelMap;
    }

    @RequestMapping(value = "/addArea",method = RequestMethod.POST)
    public Map<String,Object> addArea(@RequestBody Area area){
        HashMap<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",areaService.addArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/modifyArea",method = RequestMethod.POST)
    public Map<String,Object> modifyArea(@RequestBody Area area){
        HashMap<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",areaService.modifyArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/removeArea",method = RequestMethod.GET)
    public Map<String,Object> removeArea(Integer areaId){
        HashMap<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",areaService.deleteArea(areaId));
        return modelMap;
    }
}
