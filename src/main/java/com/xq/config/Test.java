package com.xq.config;

import org.apache.tomcat.jni.Time;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Auther: Administrator
 * @Date: 2020/6/28 0028 15:54
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        Random random = new Random();
        IntStream.range(0,5).forEach(a ->new Thread(()->{
            threadLocal.set(a+"--"+random.nextInt(10));
            System.out.println("线程-值："+threadLocal.get());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());
        Test test = new Test();
        test.testLinkedHashMap();
    }
    public void testLinkedHashMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(5, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                //当LinkHashMap的容量大于等于5的时候,再插入就移除旧的元素
                return this.size() >= 5;
            }
        };
        map.put("aa", "bb");
        map.put("cc", "dd");
        map.put("ee", "ff");
        map.put("gg", "hh");
        print(map);
        map.get("cc");
        System.out.println("=============1======================");
        print(map);

        map.get("ee");
        map.get("aa");
        System.out.println("=============2======================");
        print(map);
        System.out.println("=============3=======================");
        map.put("ss","oo");
        print(map);
    }

    void print(LinkedHashMap<String, String> source) {
        source.keySet().iterator().forEachRemaining(System.out::println);
    }
}
