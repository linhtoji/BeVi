package com.example.linht.bevi.application;

import android.content.Context;
import com.example.data.repository.PrefrenceRepository;

public class ServiceLocator {

  private static Context context;
  private static ServiceLocator instance;
  private PrefrenceRepository prefrenceRepository;

  public static ServiceLocator getInstance() {
    if (instance == null) {

      instance = new ServiceLocator();
    }

    return instance;
  }

  public Context getContext() {
    return context;
  }

  public void setContext(Context context) {
    ServiceLocator.context = context;
  }

  public PrefrenceRepository getPrefrenceRepository() {
    return prefrenceRepository;
  }

  public void setPrefrenceRepository(PrefrenceRepository prefrenceRepository) {
    this.prefrenceRepository = prefrenceRepository;
  }
}
