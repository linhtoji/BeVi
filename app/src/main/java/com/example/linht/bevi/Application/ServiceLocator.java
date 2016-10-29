package com.example.linht.bevi.application;

import android.content.Context;
import com.example.data.repository.PrefrenceRepository;
import com.example.domain.backendService.DoctorRepository;

public class ServiceLocator {

  private static Context context;
  private static ServiceLocator instance;
  private PrefrenceRepository prefrenceRepository;
  private DoctorRepository doctorRepository;

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

  public DoctorRepository getDoctorRepository() {
    return doctorRepository;
  }

  public void setDoctorRepository(DoctorRepository doctorRepository) {
    this.doctorRepository = doctorRepository;
  }
}
