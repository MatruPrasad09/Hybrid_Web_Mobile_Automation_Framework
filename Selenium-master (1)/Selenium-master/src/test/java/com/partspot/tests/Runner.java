package com.partspot.tests;

import com.appium.manager.ParallelThread;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    @Test(groups = {"Mobile"})
    public void testApp () throws Exception {
        ParallelThread parallelThread = new ParallelThread();
        List<String> list = new ArrayList<>();
        list.add("RegistrationTest");
        Boolean hasFailures = parallelThread.runner("com.partspot.tests", list);

        Assert.assertFalse(hasFailures);
    }
}
