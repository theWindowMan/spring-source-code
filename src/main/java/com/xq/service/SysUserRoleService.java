package com.xq.service;

import com.xq.dao.SysUserRoleMapper;
import com.xq.entity.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @Auther: Administrator
 * @Date: 2020/6/23 0023 11:14
 * @Description:
 */
@Service
public class SysUserRoleService {
    @Autowired
    private SysUserRoleMapper userRoleMapper;
    public static void main(String[] args) {
           int RUNNER_COUNT = 1000000;
         CountDownLatch end = new CountDownLatch(RUNNER_COUNT);
//        final ExecutorService exec = newFixedThreadPool(1000);
        long Start = System.currentTimeMillis();
        for (int i = 0; i < RUNNER_COUNT; i++) {
            final int NO = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("No." + NO + " arrived");
                    end.countDown();
                }
            };

//            exec.submit(runnable);
        }

        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        exec.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("时间"+(endTime-Start));
    }
    public List<SysUserRole> listByUserId(Integer userId) {

        return userRoleMapper.listByUserId(userId);
    }
}