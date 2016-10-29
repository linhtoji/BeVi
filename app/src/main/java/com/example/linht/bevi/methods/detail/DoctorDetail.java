package com.example.linht.bevi.methods.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.domain.model.Doctor;
import com.example.domain.model.User;
import com.example.linht.bevi.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.List;
import java.util.Objects;

public class DoctorDetail extends AppCompatActivity
    implements DoctorDetailPresenter.ViewDoctorDetail {
  private static final String TAG = DoctorDetail.class.getSimpleName();
  public static String DOCTOR_ID = "com.example.linht.bevi.methods";
  @BindView(R.id.userOrder) TextView userOrder;
  @BindView(R.id.currentOrder) TextView currentOrder;

  private String doctorId;
  private DoctorDetailPresenter presenter;
  private DatabaseReference doctorInfor;
  private DatabaseReference doctorInforGet;
  private int lastNumberPatient = 0;
  private int currentNUmber = 0;

  public DoctorDetail() {
    this.presenter = new DoctorDetailPresenter(this);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_doctor_detail);
    ButterKnife.bind(this);
    doctorInfor = FirebaseDatabase.getInstance().getReference();
    doctorInforGet = FirebaseDatabase.getInstance().getReference().child("doctor").child("d3");
    listenerCurrentNumber();
    listenerLastNumber();
  }

  private void setDoctorId() {
    Bundle bundle = getIntent().getExtras();
    doctorId = bundle.getString(DOCTOR_ID);
    if (doctorId != null) {
      presenter.getDoctor(doctorId);
      presenter.getListUser(doctorId);
      if (doctorId.equals("d3")) {
        doctorInfor.child("doctor")
            .child(doctorId)
            .child("lastPatientNumber")
            .setValue(String.valueOf(lastNumberPatient + 1));
      }
    }
  }

  private void listenerCurrentNumber() {
    ValueEventListener numberListener = new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot dataSnapshot) {
        Doctor doctor = dataSnapshot.getValue(Doctor.class);
        currentOrder.setText(doctor.getCurrentPatientNumber());
        currentNUmber = Integer.valueOf(doctor.getCurrentPatientNumber());
      }

      @Override public void onCancelled(DatabaseError databaseError) {
        Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
      }
    };
    doctorInforGet.addValueEventListener(numberListener);
  }

  private void listenerLastNumber() {
    final ValueEventListener lastNumber = new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot dataSnapshot) {
        Doctor doctor = dataSnapshot.getValue(Doctor.class);
        userOrder.setText(String.valueOf(Integer.valueOf(doctor.getLastPatientNumber()) + 1));
        lastNumberPatient = Integer.valueOf(doctor.getLastPatientNumber());
        setDoctorId();
      }

      @Override public void onCancelled(DatabaseError databaseError) {
        Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
      }
    };
    doctorInforGet.addListenerForSingleValueEvent(lastNumber);
  }

  @Override public void viewDoctor(Doctor doctor) {
    currentOrder.setText(doctor.getNumber());
  }

  @Override public void viewOrder(List<User> users) {
    if (!doctorId.equals("d3")) {
      int order = users.size();
      userOrder.setText(String.valueOf(order));
    }
  }
}
