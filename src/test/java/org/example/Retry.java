package org.example;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

    static int count=0;
    static int maxCount=3;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count>maxCount){
            count++;
            return true;
        }
        return false;
    }
}