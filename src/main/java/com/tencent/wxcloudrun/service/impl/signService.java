package com.tencent.wxcloudrun.service.impl;

import java.util.List;

public interface signService {

    public List<Integer> updateSignTime(String userId);

    List<Integer> selectSign(String userId);
}
