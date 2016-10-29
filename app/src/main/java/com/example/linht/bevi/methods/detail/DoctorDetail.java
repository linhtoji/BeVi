package com.example.linht.bevi.methods.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.domain.model.Doctor;
import com.example.domain.model.User;
import com.example.linht.bevi.R;
import java.util.List;

public class DoctorDetail extends AppCompatActivity
    implements DoctorDetailPresenter.ViewDoctorDetail {
  public static String DOCTOR_ID = "com.example.linht.bevi.methods";
  @BindView(R.id.userOrder) TextView userOrder;
  @BindView(R.id.currentOrder) TextView currentOrder;

  private String doctorId;
  private DoctorDetailPresenter presenter;

  public DoctorDetail() {
    this.presenter = new DoctorDetailPresenter(this);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_doctor_detail);
    ButterKnife.bind(this);

    Bundle bundle = getIntent().getExtras();
    doctorId = bundle.getString(DOCTOR_ID);
    if (doctorId != null) {
      presenter.getDoctor(doctorId);
      presenter.getListUser(doctorId);
    }
  }

  @Override public void viewDoctor(Doctor doctor) {
    currentOrder.setText(doctor.getNumber());
  }

  @Override public void viewOrder(List<User> users) {
    int order = users.size();
    userOrder.setText(String.valueOf(order));
  }
}
