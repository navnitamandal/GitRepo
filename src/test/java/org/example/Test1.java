package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void failedTest() {
        System.out.println("run");
        Assert.assertFalse(true,"failed");
    }
}
