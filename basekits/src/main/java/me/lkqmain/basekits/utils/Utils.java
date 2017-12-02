package me.lkqmain.basekits.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.support.annotation.NonNull;

/**
 * Created by lkq on 2017/12/1.
 */

public class Utils {
  @SuppressLint("StaticFieldLeak") private static Application sApplication;

  /**
   * 初始化工具类,在Application中初始化
   *
   * @param app Application
   */
  public static void init(@NonNull final Application app) {
    Utils.sApplication = app;
  }

  /**
   * 获取Application实例
   *
   * @return Application
   */
  public static Application getApp() {
    if (sApplication != null) return sApplication;
    throw new NullPointerException("you should init Utils first!");
  }
}
