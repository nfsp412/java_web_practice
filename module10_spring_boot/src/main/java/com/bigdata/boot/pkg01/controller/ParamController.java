package com.bigdata.boot.pkg01.controller;

import com.bigdata.boot.pkg01.bean.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name ParamController
 * @create 2024/7/22 7:32
 */

@RestController
//@Controller
public class ParamController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable Map<String, String> map,
                                      @RequestHeader("User-Agent") String h1,
                                      @RequestHeader Map<String, String> h2,
                                      @RequestParam("a1") String a1,
                                      @RequestParam("a2") String a2,
                                      @RequestParam Map<String, String> a3,
                                      @CookieValue("JSESSIONID") String c1,
                                      @CookieValue("JSESSIONID") Cookie c2) {
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("id", id);
        map1.put("pv", map);
        map1.put("h1", h1);
        map1.put("h2", h2);
        map1.put("a1", a1);
        map1.put("a2", a2);
        map1.put("a3", a3);
        map1.put("c1", c1);
        map1.put("c2", c2);
        return map1;
    }

    @RequestMapping(value = "/c1", method = RequestMethod.POST)
    public Map<String, Object> c1(@RequestBody String content) {
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("content", content);
        return map1;
    }

    @PostMapping("/testPojo")
    public People testPojo(People people) {
        return people;
    }
}
