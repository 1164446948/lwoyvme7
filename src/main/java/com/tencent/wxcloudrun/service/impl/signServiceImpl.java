package com.tencent.wxcloudrun.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.dao.UserSignMapper;
import com.tencent.wxcloudrun.dto.UserSignEntity;
import com.tencent.wxcloudrun.util.keyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class signServiceImpl implements signService{
    @Resource
    private UserSignMapper userSignMapper;
    @Override
    public List<String> updateSignTime(String userId) {
        List<String> signTimeList=new ArrayList<>();
        boolean sign=false;
        UserSignEntity userSignEntity = userSignMapper.selectByUserId(userId);
        if(userSignEntity==null){
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd");
            String dateString = formatter.format(currentTime);
            signTimeList.add(dateString);
            String newSignTime=JSON.toJSONString(signTimeList);
            UserSignEntity userSignentity=new UserSignEntity();
            String userKey=keyUtil.getUUIDTOLongNew();
            userSignentity.setUserKey(userKey);
            userSignentity.setUserId(userId);
            userSignentity.setCreateTime(new Date());
            userSignentity.setUpdateTime(new Date());
            userSignentity.setDeleteFlag(0);
            userSignentity.setSignTime(newSignTime);
            userSignMapper.insertSelective(userSignentity);
            signTimeList= JSONObject.parseArray(newSignTime, String.class);
            return signTimeList;
        }else {
            String signTime=userSignEntity.getSignTime();
            signTimeList = JSONObject.parseArray(signTime, String.class);
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd");
            String dateString = formatter.format(currentTime);
            if(!signTimeList.contains(dateString)){
                signTimeList.add(dateString);
            }
            String newSignTime = JSON.toJSONString(signTimeList);
            userSignEntity.setSignTime(newSignTime);
            userSignMapper.updateByPrimaryKey(userSignEntity);
            return signTimeList;
        }
    }

    @Override
    public List<String> selectSign(String userId) {
        UserSignEntity userSignEntity = userSignMapper.selectByUserId(userId);
        List<String> signTimeList= JSONObject.parseArray(userSignEntity.getSignTime(), String.class);
        return signTimeList;
    }
}