package com.fahai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhanghao on 16/10/31.
 */

@org.springframework.web.bind.annotation.RestController
public class Controller233 {
    @ResponseBody
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hellohksdahsdjkhajkdshkjcnxkzdlfsjfdlsj237827389273892";
    }
}
