package com.bigdata.controller;

import com.bigdata.pojo.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name RequestMappingController
 * @create 2024/7/20 22:37
 */

@Controller
//@RequestMapping("/test")
public class RequestMappingController {
    //此时请求映射所映射的请求的请求路径为：/test/testRequestMapping
//    @RequestMapping("/testRequestMapping")
    @RequestMapping(
            value = {"/testRequestMapping", "/test"},
            method = {RequestMethod.GET, RequestMethod.POST},
            params = {"username","password!=123456"},
            headers = {}
    )
    public String testRequestMapping(){
        return "success";
    }

    @RequestMapping("/a?a")
    public String testAnt() {
        return "success";
    }

    @RequestMapping("/testRest/{id}/{username}")
    public String testRest(@PathVariable("id") String id, @PathVariable("username") String username){
        //最终输出的内容为-->id:1,username:admin
        System.out.println("id:"+id+",username:"+username);
        return "success";
    }

//    @RequestMapping("/testParam")
//    public String testParam(HttpServletRequest request){
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        System.out.println("username:"+username+",password:"+password);
//        return "success";
//    }

    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam("userName") String username,
            String password,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String cookie
    ){
        System.out.println("username:"+username+",password:"+password);
        System.out.println(referer);
        System.out.println(cookie);
        return "success";
    }

    @RequestMapping("/testpojo")
    public String testPOJO(User user){
        //最终结果-->User{id=null, username='张三', password='123', age=23, sex='男',email='123@qq.com'}
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        request.setAttribute("testScope", "hello,servletAPI");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        /**
         * ModelAndView 有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //向请求域共享数据
        mav.addObject("testScope", "hello,ModelAndView");
        //设置视图，实现页面跳转
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testScope", "hello,Model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        map.put("testScope", "hello,Map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testScope", "hello,ModelMap");
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "hello,application");
        return "success";
    }

    @RequestMapping("/testHello")
    public String testHello(){
        return "hello";
    }

    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testHello";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testHello";
    }

    @RequestMapping("/test/RequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        //格式username=1&password=2
        System.out.println("requestBody:"+requestBody);
        return "success";
    }

    //将json格式的数据转换为map集合
    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody Map<String, Object> map,
                                HttpServletResponse response) throws IOException {
        System.out.println(map);
        //{username=admin, password=123456}
        response.getWriter().print("hello,axios");
    }

    //将json格式的数据转换为实体类对象
//    @RequestMapping("/test/RequestBody/json")
//    public void testRequestBody(@RequestBody User user, HttpServletResponse
//            response) throws IOException {
//        System.out.println(user);
//        //User{id=null, username='admin', password='123456', age=null,gender='null'}
//        response.getWriter().print("hello,axios");
//    }

//    @RequestMapping("/testResponseBody")
//    public String testResponseBody(){
////        此时会跳转到逻辑视图success所对应的页面
//        return "success";
//    }
//    @RequestMapping("/testResponseBody")
//    @ResponseBody
//    public String testResponseBody(){
//        //此时响应浏览器数据success
//        return "successA";
//    }

    //响应浏览器list集合
//    @RequestMapping("/test/ResponseBody/json")
//    @ResponseBody
//    public List<User> testResponseBody(){
//        User user1 = new User(1001,"admin1","123456",23,"男");
//        User user2 = new User(1002,"admin2","123456",23,"男");
//        User user3 = new User(1003,"admin3","123456",23,"男");
//        List<User> list = Arrays.asList(user1, user2, user3);
//        return list;
//    }


    //响应浏览器map集合
//    @RequestMapping("/test/ResponseBody/json")
//    @ResponseBody
//    public Map<String, Object> testResponseBody(){
//        User user1 = new User(1001,"admin1","123456",23,"男");
//        User user2 = new User(1002,"admin2","123456",23,"男");
//        User user3 = new User(1003,"admin3","123456",23,"男");
//        Map<String, Object> map = new HashMap<>();
//        map.put("1001", user1);
//        map.put("1002", user2);
//        map.put("1003", user3);
//        return map;
//    }

    //响应浏览器实体类对象
    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public User testResponseBody(){
        User user = new User(1001,"admin1","123456",23,"男");
        return user;
    }

    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        //获取上传的文件的文件名
        String fileName = photo.getOriginalFilename();
        //处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        //获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        //实现上传功能
        photo.transferTo(new File(finalPath));
        return "success";
    }

}

