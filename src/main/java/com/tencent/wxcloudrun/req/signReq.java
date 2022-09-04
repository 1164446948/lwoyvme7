package com.tencent.wxcloudrun.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ApiModel("签到请求入参")
public class signReq {
    @NotBlank
    @ApiModelProperty("用户id")
    private String userId;
}
