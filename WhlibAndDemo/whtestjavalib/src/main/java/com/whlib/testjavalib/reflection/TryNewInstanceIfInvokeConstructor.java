package com.whlib.testjavalib.reflection;

import com.whlib.testjavalib.ABaseTry;
import com.whlib.testjavalib.Utils.DemoClassA;
import com.whlib.testjavalib.Utils.DemoClassWithoutDefaultConstructor;

import java.lang.reflect.Constructor;

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
            e.printStackTrace();
        }
        try {
            DemoClassWithoutDefaultConstructor da2 = DemoClassWithoutDefaultConstructor.class.newInstance(); // #1
            da2.out();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Constructor<DemoClassWithoutDefaultConstructor> constructor = DemoClassWithoutDefaultConstructor.class.getConstructor(int.class);
            DemoClassWithoutDefaultConstructor da3 = constructor.newInstance(8);
            da3.out();
        } catch (Exception e) {
            e.printStackTrace();
        }
        outputConclusionIfTryDone("reflection newInstance() will call default constructor.",
                "reflection newInstance() will throw InstantiationException if no default constructor.");
    }

// #1
//    java.lang.InstantiationException: com.whlib.testjavalib.Utils.DemoClassWithoutDefaultConstructor
//    at java.lang.Class.newInstance(Class.java:364)
//    at com.whlib.testjavalib.reflection.TryNewInstanceIfInvokeConstructor.startTry(TryNewInstanceIfInvokeConstructor.java:19)
//    at com.whlib.testjavalib.Main.startTry(Main.java:16)
//    at com.whlib.testjavalib.Main.main(Main.java:9)
//    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
//    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//    at java.lang.reflect.Method.invoke(Method.java:606)
//    at com.intellij.rt.execution.application.AppMain.main(AppMain.java:140)

}
