package com.example.domain.backendService;

import com.example.domain.interactor.ResponseCallback;
import com.example.domain.model.Doctor;
import com.example.domain.model.User;
import java.util.List;

public interface DoctorRepositoryService {
  void fetchDoctors(ResponseCallback<List<Doctor>> callback);

  void getDoctorById(String id,ResponseCallback<Doctor> callback);

  void getListUserByDoctorId(String doctorId, ResponseCallback<List<User>> callback);
}
