package com.example.linht.bevi.methods.checkin;

import com.example.domain.interactor.ListDoctorInteractor;
import com.example.domain.model.Doctor;
import com.example.linht.bevi.application.ServiceLocator;
import com.example.linht.bevi.methods.ListDoctorAdapter;
import java.util.ArrayList;
import java.util.List;

public class CheckinPresenter implements ListDoctorInteractor.FetchListDoctorInteface {
  private ListDoctorView view;
  private ListDoctorInteractor interactor;

  public CheckinPresenter(ListDoctorView view) {
    this.view = view;
    interactor = new ListDoctorInteractor();
    interactor.setDoctorRepository(ServiceLocator.getInstance().getDoctorRepository());
    interactor.setListener(this);
  }

  public void getListDoctor(){
    interactor.fetchListDoctor();
  }

  @Override public void listDoctorSucc(List<Doctor> doctors) {
    view.viewListDoctor(doctors);
  }

  public interface ListDoctorView{
    void viewListDoctor(List<Doctor> doctors);
  }
}
