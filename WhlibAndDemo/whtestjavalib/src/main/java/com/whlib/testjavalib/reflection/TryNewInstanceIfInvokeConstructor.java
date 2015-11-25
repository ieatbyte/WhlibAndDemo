package com.whlib.testjavalib.reflection;

import com.whlib.testjavalib.ABaseTry;
import com.whlib.testjavalib.Loger;
import com.whlib.testjavalib.Utils.DemoClassA;

/**
 * Created by wanghui5-s on 2015/11/25.
 */
public class TryNewInstanceIfInvokeConstructor extends ABaseTry {

    @Override
    public void startTry() {
        super.startTry();

        try {
            DemoClassA da = DemoClassA.class.newInstance();
            da.out();
        } catch(Exception e) {
            Loger.d(e.getMessage());
        }
        outputConclusionIfTryDone("reflection newInstance() will call default constructor.");
    }

}
