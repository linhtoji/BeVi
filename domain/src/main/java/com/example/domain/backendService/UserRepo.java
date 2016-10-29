package com.example.domain.backendService;

import com.example.domain.interactor.ResponseCallback;
import com.example.domain.model.User;
import java.util.List;

public interface UserRepo {
  void fetchListUserByDoctorId(String doctorId, ResponseCallback<List<User>> callback);
}
