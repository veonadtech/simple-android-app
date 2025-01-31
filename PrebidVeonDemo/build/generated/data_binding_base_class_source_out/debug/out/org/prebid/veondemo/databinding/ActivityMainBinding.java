// Generated by data binding compiler. Do not edit!
package org.prebid.veondemo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import org.prebid.veondemo.R;

public abstract class ActivityMainBinding extends ViewDataBinding {
  @NonNull
  public final FrameLayout adInterstitial;

  @NonNull
  public final FrameLayout adLayout;

  @NonNull
  public final FrameLayout banner300x250;

  @NonNull
  public final FrameLayout banner320x100;

  @NonNull
  public final FrameLayout banner320x50;

  @NonNull
  public final WebView iframe;

  @NonNull
  public final Button showBanner;

  @NonNull
  public final Spinner spinnerAdType;

  @NonNull
  public final TextView tvAdFormat;

  protected ActivityMainBinding(Object _bindingComponent, View _root, int _localFieldCount,
      FrameLayout adInterstitial, FrameLayout adLayout, FrameLayout banner300x250,
      FrameLayout banner320x100, FrameLayout banner320x50, WebView iframe, Button showBanner,
      Spinner spinnerAdType, TextView tvAdFormat) {
    super(_bindingComponent, _root, _localFieldCount);
    this.adInterstitial = adInterstitial;
    this.adLayout = adLayout;
    this.banner300x250 = banner300x250;
    this.banner320x100 = banner320x100;
    this.banner320x50 = banner320x50;
    this.iframe = iframe;
    this.showBanner = showBanner;
    this.spinnerAdType = spinnerAdType;
    this.tvAdFormat = tvAdFormat;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_main, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMainBinding>inflateInternal(inflater, R.layout.activity_main, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_main, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMainBinding>inflateInternal(inflater, R.layout.activity_main, null, false, component);
  }

  public static ActivityMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityMainBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityMainBinding)bind(component, view, R.layout.activity_main);
  }
}
