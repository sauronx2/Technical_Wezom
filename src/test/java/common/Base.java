package common;

import org.testng.Assert;

public class Base extends Assert {
    protected void sleep(long millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public long getRandomNumber() {
        return System.currentTimeMillis();
    }
}
