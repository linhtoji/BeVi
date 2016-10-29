package com.example.data.repository;

import com.example.domain.backendService.DoctorRepositoryService;
import com.example.domain.interactor.ResponseCallback;
import com.example.domain.model.Doctor;
import com.example.domain.model.User;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepositoryDummy implements DoctorRepositoryService {
  private List<Doctor> listDoctor = new ArrayList<>();
  public DoctorRepositoryDummy() {
    init();
  }

  @Override public void fetchDoctors(ResponseCallback<List<Doctor>> callback) {
   callback.successCallback(listDoctor);
  }

  @Override public void getDoctorById(String id, ResponseCallback<Doctor> callback) {
      for (Doctor doctor:listDoctor){
        if (id.equals(doctor.getId())){
          callback.successCallback(doctor);
          return;
        }
      }
  }

  @Override
  public void getListUserByDoctorId(String doctorId, ResponseCallback<List<User>> callback) {
    for (Doctor doctor: listDoctor){
      if (doctorId.equals(doctor.getId())){
        callback.successCallback(doctor.getUsers());
      }
    }
  }

  private void init(){
    Doctor doctor1 = new Doctor();
    doctor1.setName("Dr. NGUYEN NGOC LINH");
    doctor1.setDepartment("Forensic Psychiatry");
    doctor1.setNumber("32");
    doctor1.setId("d1");

    List<User> users1 = new ArrayList<>();
    for (int i = 0; i<52; i++){
      User user = new User();
      user.setOrder(String.valueOf(i));
      users1.add(user);
    }
    doctor1.setUsers(users1);
    listDoctor.add(doctor1);

    Doctor doctor2 = new Doctor();
    doctor2.setName("Dr. TRAN THI AI NHI");
    doctor2.setDepartment("Psychiatry & Neurology");
    doctor2.setNumber("46");
    doctor2.setId("d2");
    doctor2.setBeaconId("edd1ebeac04e5defa017df9be790c76f");
    List<User> users2 = new ArrayList<>();
    for (int i = 0; i<55; i++){
      User user = new User();
      user.setOrder(String.valueOf(i));
      users2.add(user);
    }
    doctor2.setUsers(users2);
    listDoctor.add(doctor2);

    Doctor doctor3 = new Doctor();
    doctor3.setName("Dr. LE TRI DAT");
    doctor3.setDepartment("Plastic Surgery");
    doctor3.setBeaconId("edd1ebeac04e5defa017fa2daab6f2c1");
    doctor3.setId("d3");
    List<User> users3 = new ArrayList<>();
    for (int i = 0; i<25; i++){
      User user = new User();
      user.setOrder(String.valueOf(i));
      users3.add(user);
    }
    doctor3.setUsers(users3);
    listDoctor.add(doctor3);

    Doctor doctor4 = new Doctor();
    doctor4.setName("Dr. NGO LUU DUY THAI");
    doctor4.setDepartment("Forensic Psychiatry");
    doctor4.setNumber("20");
    doctor4.setId("d4");
    List<User> users4 = new ArrayList<>();
    for (int i = 0; i<15; i++){
      User user = new User();
      user.setOrder(String.valueOf(i));
      users4.add(user);
    }
    doctor4.setUsers(users4);
    listDoctor.add(doctor4);

    Doctor doctor5 = new Doctor();
    doctor5.setName("Dr. NGUYEN NGOC SON");
    doctor5.setDepartment("Psychiatry & Neurology");
    doctor5.setNumber("39");
    doctor5.setId("d5");
    List<User> users5 = new ArrayList<>();
    for (int i = 0; i<50; i++){
      User user = new User();
      user.setOrder(String.valueOf(i));
      users5.add(user);
    }
    doctor5.setUsers(users5);
    listDoctor.add(doctor5);
  }
}
