package com.example.linht.bevi.methods.detail;

import com.example.data.repository.DoctorRepositoryDummy;
import com.example.domain.backendService.DoctorRepositoryService;
import com.example.domain.interactor.ResponseCallback;
import com.example.domain.model.Doctor;
import com.example.domain.model.User;
import com.example.linht.bevi.application.ServiceLocator;
import java.util.List;

public class DoctorDetailPresenter {
  private DoctorRepositoryDummy doctorRepositoryDummy = ServiceLocator.getInstance().getDoctorRepository();
  private ViewDoctorDetail view;

  public DoctorDetailPresenter(ViewDoctorDetail view) {
    this.view = view;
  }

  public void getDoctor(String id){
    doctorRepositoryDummy.getDoctorById(id, new ResponseCallback<Doctor>() {
      @Override public void successCallback(Doctor result) {
        view.viewDoctor(result);
      }

      @Override public void errorCallback(Throwable e) {

      }
    });
  }

  public void getListUser(String id){
    doctorRepositoryDummy.getListUserByDoctorId(id, new ResponseCallback<List<User>>() {
      @Override public void successCallback(List<User> result) {
        view.viewOrder(result);
      }

      @Override public void errorCallback(Throwable e) {

      }
    });
  }

  public interface ViewDoctorDetail{
    void viewDoctor(Doctor doctor);
    void viewOrder(List<User> users);
  }
}
