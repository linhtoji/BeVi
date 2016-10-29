package com.example.linht.bevi.application;

import android.app.Application;
import android.content.Context;
import com.example.data.repository.PrefrenceRepository;

public class BeViAplication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    initSetup();
  }

  private void initSetup(){
    ServiceLocator locator = ServiceLocator.getInstance();
    Context context = getApplicationContext();
    locator.setContext(context);
    PrefrenceRepository prefrenceRepository = new PrefrenceRepository();
    prefrenceRepository.setContext(context);
    locator.setPrefrenceRepository(prefrenceRepository);
  }
}
