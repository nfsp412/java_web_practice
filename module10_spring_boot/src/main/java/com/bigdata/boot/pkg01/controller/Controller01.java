package com.bigdata.boot.pkg01.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name Controller01
 * @create 2024/9/12 14:17
 */

//@RestController
@Controller
public class Controller01 {
    @GetMapping("/page1")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg", "success");
        request.setAttribute("code", "200");
        return "forward:/success";
    }


    @GetMapping("/success")
    @ResponseBody
    public Map<String, Object> success1(@RequestAttribute("msg") String msg,
                                        @RequestAttribute("code") String code,
                                        HttpServletRequest request) {
        Object msg1 = request.getAttribute("msg");
        Object code1 = request.getAttribute("code");
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("code", code);
        map.put("msg1", msg1);
        map.put("code1", code1);
        return map;
    }

    @GetMapping("/cars/{path}")
    @ResponseBody
    public Map<String, Object> cars1(
            @MatrixVariable("low") Integer low,
            @MatrixVariable("brand") List<String> brand,
            @PathVariable("path") String path
    ) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    @GetMapping("/boss/{path1}/{path2}")
    @ResponseBody
    public Map<String, Object> boss(
            @PathVariable("path1") String path1,
            @PathVariable("path2") String path2,
            @MatrixVariable(value = "age", pathVar = "path1") String age1,
            @MatrixVariable(value = "age", pathVar = "path2") String age2
    ) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("path1", path1);
        map.put("path2", path2);
        map.put("age1", age1);
        map.put("age2", age2);
        return map;
    }


}
