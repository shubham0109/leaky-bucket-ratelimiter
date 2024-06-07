package com.ratelimiter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LeakyBucketRateLimiter implements RateLimiter{


    BlockingQueue<Integer> queue;

    public LeakyBucketRateLimiter(int capacity){
        this.queue = new LinkedBlockingQueue<>(capacity);
    }


    @Override
    public boolean grantAccess(){

        if (queue.size() < 10){
            queue.add(1);
            return true;
        }

        return false;
    }

}
