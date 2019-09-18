package com.example.uiautomatordemo;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.util.Log;

import junit.framework.TestCase;


/**
 * Created by Administrator on 2019/9/15.
 */

public class UiTest extends TestCase {
    private static String TAG = "UiTest";
    // 获取设备对象
    Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
    UiDevice uiDevice = UiDevice.getInstance(instrumentation);
    // 获取上下文
    Context context = instrumentation.getContext();
    private String mPackageName="com.android.calculator2";
    public void testA() throws UiObjectNotFoundException {


        // 启动测试App
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(mPackageName);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // 验证当前显示 的应用包名为计算器
        UiObject settingsValidation = uiDevice.findObject(new UiSelector().packageName(mPackageName));
        // 如果不存在则出错提示
        assertTrue("Unable to start app", settingsValidation.exists());

        UiObject one =uiDevice.findObject(new UiSelector().resourceId("com.android.calculator2:id/digit1"));
        one.click();

        UiObject plus =
        uiDevice.findObject(new UiSelector().resourceId("com.android.calculator2:id/plus"));
        plus.click();

        UiObject nine=
        uiDevice.findObject(new UiSelector().resourceId("com.android.calculator2:id/digit9"));
        nine.click();

        UiObject equal=
        uiDevice.findObject(new UiSelector().resourceId("com.android.calculator2:id/equal"));
        equal.click();

        UiObject ten =  uiDevice.findObject(new UiSelector().text("10"));
        boolean findResult = judgmentText("10");
        assertTrue("plus error", ten.exists());
        // 点击设备返回按钮
//        uiDevice.pressBack();
//        uiDevice.pressBack();


    }


    //判断text否存在
    public  boolean judgmentText(String name) {
        uiDevice.wait(Until.findObject(By.text(name)), 500);
        UiObject x =  uiDevice.findObject(new UiSelector().text("10"));
        if (x != null) {
            Log.e(TAG, "text“ " + name + " ”存在 ");
            return true;
        } else {
            Log.e(TAG, "text“ " + name + " ”不存在 ");
            return false;
        }
    }
}
