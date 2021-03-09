package com.detectwebshell.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author justnow
 * Created on 2021-03-08
 * Description
 */

@RestController
public class TestController {

    @GetMapping("test")
    @ResponseBody
    public String getResult() throws IOException {
        String cmd = "F:\\python\\python.exe D:\\phpfiles\\demo.py";
        Process p = Runtime.getRuntime().exec(cmd);

        //读取命令的输出信息
        InputStream is = p.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String s = null;
        String res = "";
        while ((s = reader.readLine()) != null) {
            res = res + s;
        }
        return res;
    }
}
