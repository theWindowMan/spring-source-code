package com.xq.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Auther: Administrator
 * @Date: 2020/6/23 0023 10:53
 * @Description:
 */
@Data
public class SysUser implements Serializable {
    static final long serialVersionUID = 1L;
    @Setter
    @Getter
    private Integer id;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String password;

    public static void main(String[] args) {
        String str1= "abc";
        String str2= new String("abc");
        String str3= str2.intern();
        System.out.println(str1==str2);
        System.out.println(str2==str3);
        System.out.println(str1==str3);
        LinkedList<Object> objects = new LinkedList<>();
        objects.addLast(123);
    }
// 省略getter/setter
}
