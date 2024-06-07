package com.ratelimiter;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {

    Map<Integer, LeakyBucketRateLimiter> mp;

    public UserBucketCreator(int userId){
        this.mp = new HashMap<>();
        this.mp.put(userId, new LeakyBucketRateLimiter(10));
    }

    public void accessApplication(int userId){
        LeakyBucketRateLimiter leakyBucketRateLimiter = mp.get(userId);

        if (leakyBucketRateLimiter.grantAccess() == true){
            System.out.println(Thread.currentThread().getName() + " Application processed!");
        }else{
            System.out.println(Thread.currentThread().getName() + " TOO MANY REQUESTS!!!");
        }
    }

}
