package me.lkqmain.basekits.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import me.lkqmain.basekits.utils.LogUtils;

/**
 * Created by lkq on 2017/12/1.
 */

public abstract class BaseActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LogUtils.e();
    setContentView(getLayoutId());
    findView();
    initView();
    initListener();
    initData();
  }

  /**
   * 根布局id
   */
  protected abstract int getLayoutId();

  /**
   * 执行findViewById操作 或者以后使用Butterknife时的绑定操作
   */
  protected abstract void findView();

  /**
   * 初始化view的一些操作
   */
  protected abstract void initView();

  /**
   * 设置监听
   */
  protected abstract void initListener();

  /**
   * 初始化数据
   */
  protected abstract void initData();

  @Override protected void onStart() {
    super.onStart();
    LogUtils.e();
  }

  @Override protected void onStop() {
    super.onStop();
    LogUtils.e();
  }

  @Override protected void onResume() {
    super.onResume();
    LogUtils.e();
  }

  @Override protected void onRestart() {
    super.onRestart();
    LogUtils.e();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    LogUtils.e();
  }
}
