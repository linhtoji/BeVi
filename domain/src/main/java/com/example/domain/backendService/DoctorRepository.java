package com.example.domain.backendService;

import com.example.domain.interactor.ResponseCallback;
import com.example.domain.model.Doctor;
import java.util.List;

public interface DoctorRepository {
void fetchDoctors(ResponseCallback<List<Doctor>> callback);
}
