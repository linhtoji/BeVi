package com.example.domain.interactor;

import com.example.domain.backendService.DoctorRepositoryService;
import com.example.domain.model.Doctor;
import java.util.List;

public class ListDoctorInteractor {
  private FetchListDoctorInteface listener;
  private DoctorRepositoryService doctorRepository;

  public void fetchListDoctor(){
    doctorRepository.fetchDoctors(new ResponseCallback<List<Doctor>>() {
      @Override public void successCallback(List<Doctor> result) {
        listener.listDoctorSucc(result);
      }

      @Override public void errorCallback(Throwable e) {

      }
    });
  }

  public void setListener(FetchListDoctorInteface listener) {
    this.listener = listener;
  }

  public void setDoctorRepository(DoctorRepositoryService doctorRepository) {
    this.doctorRepository = doctorRepository;
  }

  public interface FetchListDoctorInteface{
    void listDoctorSucc(List<Doctor> doctors);
  }
}
