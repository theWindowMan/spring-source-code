package com.xq.service;

import java.util.concurrent.CompletableFuture;

/**
 * @Auther: Administrator
 * @Date: 2020/7/15 0015 14:59
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // 两个CompletableFuture执行异步查询:
        for ( int i = 1; i<10 ;i++){
            LongInt<Integer> longInt = new LongInt<Integer>();
            longInt.setT(i);
            CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
                return queryCode("中国石油", longInt.getT());
            });
            cfQueryFromSina.thenAccept((result) -> {
                System.out.println("price123: " + result);
            });
            // 如果执行异常:
            cfQueryFromSina.exceptionally((e) -> {
                e.printStackTrace();
                return "发达省了错误";
            });
        }
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", 11);
        });

//        // 用anyOf合并为一个新的CompletableFuture:
//        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);
//
//        // 两个CompletableFuture执行异步查询:
//        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
//            return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
//        });
//        CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
//            return fetchPrice((String) code, "https://money.163.com/price/");
//        });
//
//        // 用anyOf合并为一个新的CompletableFuture:
//        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);
//
//        // 最终结果:
//        cfFetch.thenAccept((result) -> {
//            System.out.println("price: " + result);
//        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static String queryCode(String name, int url) {
        int a = 1/url;
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return "601857";
    }
    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}
