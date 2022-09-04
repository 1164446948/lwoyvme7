package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.req.signReq;
import com.tencent.wxcloudrun.resp.signResp;
import com.tencent.wxcloudrun.service.impl.signService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class signController {
    @Resource
    private signService signService;
    @PutMapping("/usersign")
    private signResp usersign(@RequestBody @Validated signReq signReq){
        signResp resp=new signResp();
        List<Integer> signTime = signService.updateSignTime(signReq.getUserId());
        resp.setSignTime(signTime);
        return resp;
    }
    @GetMapping("/selectSign")
    private signResp selectSign(@RequestParam("userId")  String userId){
        signResp resp=new signResp();
        List<Integer> signTime = signService.selectSign(userId);
        resp.setSignTime(signTime);
        return resp;
    }
}
