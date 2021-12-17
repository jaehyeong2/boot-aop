package com.high.mvc2.converter;

import com.high.mvc2.converter.type.IpPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ExController {

    @GetMapping("/conv")
    public String suv(HttpServletRequest request){
        String data = request.getParameter("data");
        Integer intValue = Integer.valueOf(data);
        System.out.println("integer value = " + data);
        return "ok";
    }

    @GetMapping("/conv-2")
    public String conv(@RequestParam Integer data){
        System.out.println("integer value = " + data);
        return "ok";
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort){
        System.out.println("ipPort ip=" + ipPort.getIp());
        System.out.println("ipPort port=" + ipPort.getPort());
        return "ok";
    }
}
