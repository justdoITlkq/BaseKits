package me.lkqmain.basekits.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lkq on 2017/12/1.
 */

public abstract class BaseActivity extends AppCompatActivity {
  protected final String TAG = this.getClass().getSimpleName();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
    findView();
    initView();
    initListener();
    initData();
  }

  protected abstract int getLayoutId();

  protected abstract void findView();

  protected abstract void initView();

  protected abstract void initListener();

  protected abstract void initData();
}
