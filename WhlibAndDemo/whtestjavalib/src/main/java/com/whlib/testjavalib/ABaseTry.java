package com.whlib.testjavalib;

/**
 * Created by wanghui5-s on 2015/11/25.
 */
public class ABaseTry implements ATry {

    @Override
    public void startTry() {
        Loger.d("****** startTry " + getClass().getSimpleName());
    }

    @Override
    public void outputConclusionIfTryDone(String conclusion) {
        Loger.d("****** " + getClass().getSimpleName() + " Conclusion: " + conclusion);
    }
}
