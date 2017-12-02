package me.lkqmain.basekits.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.util.SimpleArrayMap;
import java.util.Map;

/**
 * Created by lkq on 2017/12/1.
 */

public class SPUtils {

  /**
   * file name
   */
  public static final String FILE_NAME = "share_data";
  private static SimpleArrayMap<String, SPUtils> SP_UTILS_MAP = new SimpleArrayMap<>();
  private SharedPreferences sp;

  public static SPUtils getInstance() {
    SPUtils spUtils = SP_UTILS_MAP.get(FILE_NAME);
    if (spUtils == null) {
      spUtils = new SPUtils(FILE_NAME);
      SP_UTILS_MAP.put(FILE_NAME, spUtils);
    }
    return spUtils;
  }

  private SPUtils(String spName) {
    sp = Utils.getApp().getSharedPreferences(spName, Context.MODE_PRIVATE);
  }

  /**
   * put data
   *
   * @param key key
   * @param object value instance of (String,Integer,Boolean,Long,Float)
   */
  public void put(String key, Object object) {

    SharedPreferences.Editor editor = sp.edit();
    if (object instanceof String) {
      editor.putString(key, (String) object);
    } else if (object instanceof Integer) {
      editor.putInt(key, (Integer) object);
    } else if (object instanceof Boolean) {
      editor.putBoolean(key, (Boolean) object);
    } else if (object instanceof Float) {
      editor.putFloat(key, (Float) object);
    } else if (object instanceof Long) {
      editor.putLong(key, (Long) object);
    } else {
      editor.putString(key, object.toString());
    }
    editor.apply();
  }

  /**
   * get  data
   */
  public Object get(String key, Object defaultObject) {

    if (defaultObject instanceof String) {
      return sp.getString(key, (String) defaultObject);
    } else if (defaultObject instanceof Integer) {
      return sp.getInt(key, (Integer) defaultObject);
    } else if (defaultObject instanceof Boolean) {
      return sp.getBoolean(key, (Boolean) defaultObject);
    } else if (defaultObject instanceof Float) {
      return sp.getFloat(key, (Float) defaultObject);
    } else if (defaultObject instanceof Long) {
      return sp.getLong(key, (Long) defaultObject);
    }

    return null;
  }

  /**
   * remove some key and value
   */
  public void remove(Context context, String key) {
    SharedPreferences.Editor editor = sp.edit();
    editor.remove(key);
    editor.apply();
  }

  /**
   * clear all data
   */
  public void clear(Context context) {
    SharedPreferences.Editor editor = sp.edit();
    editor.clear();
    editor.apply();
  }

  /**
   * judge key is exited or not
   */
  public static boolean contains(Context context, String key) {
    SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    return sp.contains(key);
  }

  /**
   * return all data
   */
  public Map<String, ?> getAll(Context context) {
    SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    return sp.getAll();
  }
}
