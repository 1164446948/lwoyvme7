package com.tencent.wxcloudrun.resp;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class signResp extends baseResp {
    List<String> signTime;

}
