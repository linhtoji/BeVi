package com.example.data.repository;

import com.example.domain.backendService.UserRepo;
import com.example.domain.interactor.ResponseCallback;
import com.example.domain.model.User;
import java.util.List;

public class UserRepoDummy implements UserRepo {

  public UserRepoDummy() {

  }

  @Override
  public void fetchListUserByDoctorId(String doctorId, ResponseCallback<List<User>> callback) {

  }

  public void init(){

  }
}
