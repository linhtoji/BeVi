package com.example.data.repository;

import com.example.domain.interactor.ResponseCallback;
import com.example.domain.model.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepositoryDummy implements com.example.domain.backendService.DoctorRepository {
  private List<Doctor> listDoctor = new ArrayList<>();
  public DoctorRepositoryDummy() {
    init();
  }

  @Override public void fetchDoctors(ResponseCallback<List<Doctor>> callback) {
   callback.successCallback(listDoctor);
  }

  private void init(){
    Doctor doctor1 = new Doctor();
    doctor1.setName("NGUYEN NGOC LINH");
    doctor1.setDepartment("Forensic Psychiatry");
    listDoctor.add(doctor1);

    Doctor doctor2 = new Doctor();
    doctor2.setName("TRAN THI AI NHI");
    doctor2.setDepartment("Psychiatry & Neurology");
    listDoctor.add(doctor2);

    Doctor doctor3 = new Doctor();
    doctor3.setName("LE TRI DAT");
    doctor3.setDepartment("Plastic Surgery");
    listDoctor.add(doctor3);

    Doctor doctor4 = new Doctor();
    doctor4.setName("NGO LUU DUY THAI");
    doctor4.setDepartment("Forensic Psychiatry");
    listDoctor.add(doctor4);

    Doctor doctor5 = new Doctor();
    doctor5.setName("NGUYEN NGOC SON");
    doctor5.setDepartment("Psychiatry & Neurology");
    listDoctor.add(doctor5);
  }
}
