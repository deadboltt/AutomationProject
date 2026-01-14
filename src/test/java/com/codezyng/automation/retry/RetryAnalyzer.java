package com.codezyng.automation.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.codezyng.automation.config.ConfigReader;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private final int maxRetryCount;

    public RetryAnalyzer() {
        String retryValue = ConfigReader.getProperty("retryCount");
        this.maxRetryCount = retryValue == null ? 1 : Integer.parseInt(retryValue);
    }

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
