package org.prebid.veondemo;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.prebid.veondemo.databinding.ActivityDemoBindingImpl;
import org.prebid.veondemo.databinding.ActivityMainBindingImpl;
import org.prebid.veondemo.databinding.ActivitySettingsBindingImpl;
import org.prebid.veondemo.databinding.ListItemAdTypeBindingImpl;
import org.prebid.veondemo.databinding.ViewNativeAdAdMobBindingImpl;
import org.prebid.veondemo.databinding.ViewNativeAdMaxBindingImpl;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYDEMO = 1;

  private static final int LAYOUT_ACTIVITYMAIN = 2;

  private static final int LAYOUT_ACTIVITYSETTINGS = 3;

  private static final int LAYOUT_LISTITEMADTYPE = 4;

  private static final int LAYOUT_VIEWNATIVEADADMOB = 5;

  private static final int LAYOUT_VIEWNATIVEADMAX = 6;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(6);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.prebid.veondemo.R.layout.activity_demo, LAYOUT_ACTIVITYDEMO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.prebid.veondemo.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.prebid.veondemo.R.layout.activity_settings, LAYOUT_ACTIVITYSETTINGS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.prebid.veondemo.R.layout.list_item_ad_type, LAYOUT_LISTITEMADTYPE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.prebid.veondemo.R.layout.view_native_ad_ad_mob, LAYOUT_VIEWNATIVEADADMOB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(org.prebid.veondemo.R.layout.view_native_ad_max, LAYOUT_VIEWNATIVEADMAX);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYDEMO: {
          if ("layout/activity_demo_0".equals(tag)) {
            return new ActivityDemoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_demo is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSETTINGS: {
          if ("layout/activity_settings_0".equals(tag)) {
            return new ActivitySettingsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_settings is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMADTYPE: {
          if ("layout/list_item_ad_type_0".equals(tag)) {
            return new ListItemAdTypeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_ad_type is invalid. Received: " + tag);
        }
        case  LAYOUT_VIEWNATIVEADADMOB: {
          if ("layout/view_native_ad_ad_mob_0".equals(tag)) {
            return new ViewNativeAdAdMobBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for view_native_ad_ad_mob is invalid. Received: " + tag);
        }
        case  LAYOUT_VIEWNATIVEADMAX: {
          if ("layout/view_native_ad_max_0".equals(tag)) {
            return new ViewNativeAdMaxBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for view_native_ad_max is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(6);

    static {
      sKeys.put("layout/activity_demo_0", org.prebid.veondemo.R.layout.activity_demo);
      sKeys.put("layout/activity_main_0", org.prebid.veondemo.R.layout.activity_main);
      sKeys.put("layout/activity_settings_0", org.prebid.veondemo.R.layout.activity_settings);
      sKeys.put("layout/list_item_ad_type_0", org.prebid.veondemo.R.layout.list_item_ad_type);
      sKeys.put("layout/view_native_ad_ad_mob_0", org.prebid.veondemo.R.layout.view_native_ad_ad_mob);
      sKeys.put("layout/view_native_ad_max_0", org.prebid.veondemo.R.layout.view_native_ad_max);
    }
  }
}
