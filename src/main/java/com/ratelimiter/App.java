package com.ratelimiter;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "MY LEAKY BUCKET RATE LIMITER!!!" );

        UserBucketCreator userBucket = new UserBucketCreator(1);
        ExecutorService executors = Executors.newFixedThreadPool(12);

        for (int i = 0; i < 12; i++){
            executors.execute(() -> userBucket.accessApplication(1)); 
        }
        executors.shutdown();
    }
}
