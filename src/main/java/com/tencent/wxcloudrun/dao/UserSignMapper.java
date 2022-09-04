package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.UserSignEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * UserSignMapper继承基类
 */
@Repository
public interface UserSignMapper extends MyBatisBaseDao<UserSignEntity, String> {
    UserSignEntity selectByUserId(@Param("userId") String userId);
}