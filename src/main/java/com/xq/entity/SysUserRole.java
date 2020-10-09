package com.xq.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Auther: Administrator
 * @Date: 2020/6/23 0023 10:56
 * @Description:
 */
@Data
public class SysUserRole implements Serializable {
    static final long serialVersionUID = 1L;
    @Setter
    @Getter
    private Integer userId;
    @Setter
    @Getter
    private Integer roleId;

// 省略getter/setter
}
