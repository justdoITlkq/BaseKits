package me.lkqmain.basekits.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import me.lkqmain.basekits.utils.LogUtils;

/**
 * Created by lkq on 2017/12/2.
 */

public abstract class BaseFragment extends Fragment {

  public Context mContext;
  /**
   * root view
   */
  private View mRootView;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    LogUtils.e();
    mRootView = inflater.inflate(getRootLayoutId(), container);
    findView(mRootView);
    init(savedInstanceState);
    return mRootView;
  }

  @Override public void onAttach(Context context) {
    LogUtils.e();
    mContext = context;
    super.onAttach(context);
  }

  /**
   * 获取根布局layout id
   */
  protected abstract int getRootLayoutId();

  /**
   * 执行findView操作
   */
  protected abstract void findView(View mRootView);

  /**
   * 初始化其他数据
   */
  protected abstract void init(Bundle savedInstanceState);

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LogUtils.e();
  }

  @Override public void onStop() {
    super.onStop();
    LogUtils.e();
  }

  @Override public void onPause() {
    super.onPause();
    LogUtils.e();
  }

  @Override public void onResume() {
    super.onResume();
    LogUtils.e();
  }

  @Override public void onStart() {
    super.onStart();
    LogUtils.e();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    LogUtils.e();
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    LogUtils.e();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    LogUtils.e();
  }
}
