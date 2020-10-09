package com.xq.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Auther: Administrator
 * @Date: 2020/6/23 0023 10:55
 * @Description:
 */
@Data
public class SysRole implements Serializable {
    static final long serialVersionUID = 1L;
    @Setter
    @Getter
    private Integer id;
    @Setter
    @Getter
    private String name;

// 省略getter/setter
}
