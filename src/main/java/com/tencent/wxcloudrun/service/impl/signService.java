package com.tencent.wxcloudrun.service.impl;

import java.util.List;

public interface signService {

    public List<String> updateSignTime(String userId);

    List<String> selectSign(String userId);
}
