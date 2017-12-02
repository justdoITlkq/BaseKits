package me.lkqmain.basekits.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import java.util.Stack;

/**
 * 用于管理所有activity，以后在增加service的管理
 * Created by lkq on 2017/7/18.
 */

public class ActivityUtils {
  private volatile static ActivityUtils instance;
  private static Stack<AppCompatActivity> stack;

  public static ActivityUtils getInstance() {
    if (instance == null) {
      synchronized (ActivityUtils.class) {
        if (instance == null) {
          instance = new ActivityUtils();
        }
      }
    }
    return instance;
  }

  private ActivityUtils() {
    throw new UnsupportedOperationException("u can't instantiate me...");
  }

  //将activity添加到activity栈中
  public void addActivity(AppCompatActivity activity) {
    if (stack == null) {
      stack = new Stack<>();
    }
    stack.add(activity);
  }

  /**
   * 获取最后一个进栈的activity
   */
  public AppCompatActivity getCurrentActivity() {
    return stack.lastElement();
  }

  /**
   * 结束当前即栈顶activity
   */
  public void finishCurrentActivity() {
    stack.lastElement().finish();
  }

  /**
   * 销毁指定acitivy
   */
  public void destroryActivity(AppCompatActivity activity) {
    stack.remove(activity);
    activity.finish();
    activity = null;
  }

  /**
   * 销毁指定类名的Activity
   */
  public void destroryActivity(Class<?> clz) {
    for (int i = 0; i < stack.size(); i++) {
      AppCompatActivity activity = stack.get(i);
      if (activity != null) {
        if (clz.equals(activity.getClass())) {
          stack.remove(i);
          activity.finish();
          activity = null;
        }
      }
    }
  }

  /**
   * 退出应用程序
   */
  @SuppressWarnings("deprecation") public void AppExit(Context context) {
    try {
      finishAllActivity();
      ActivityManager activityManager =
          (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
      activityManager.restartPackage(context.getPackageName());
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void finishAllActivity() {
    for (AppCompatActivity activity : stack) {
      if (activity != null) {
        activity.finish();
      }
    }
    stack.clear();
  }
}