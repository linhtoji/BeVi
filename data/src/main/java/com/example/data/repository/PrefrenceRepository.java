package com.example.data.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import com.example.domain.backendService.PrefrenceManager;

public class PrefrenceRepository implements PrefrenceManager {
  private final static String PREFERENCES = "preferences";
  private final static String STATE_REGISTER = "stateRegister";
  private Context context;

  public void setContext(Context context) {
    this.context = context;
  }

  @Override public void setStateLogin(boolean isLogin) {
    SharedPreferences pre =
        context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = pre.edit();
    editor.putBoolean(STATE_REGISTER, true);
    editor.apply();
  }

  @Override public boolean isStateLogin() {
    SharedPreferences pre =
        context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    return pre.getBoolean(STATE_REGISTER, false);
  }
}
