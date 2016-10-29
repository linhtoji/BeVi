package com.example.linht.bevi.methods.checkin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.domain.model.Doctor;
import com.example.linht.bevi.R;
import com.example.linht.bevi.methods.detail.DoctorDetail;
import com.example.linht.bevi.methods.ListDoctorAdapter;
import java.util.List;

public class CheckinActivity extends AppCompatActivity implements CheckinPresenter.ListDoctorView {

  private ListDoctorAdapter adapter;
  private CheckinPresenter presenter;

  @BindView(R.id.listViewDoctor) ListView listViewDoctor;

  public CheckinActivity() {
    this.presenter = new CheckinPresenter(this);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_checkin);
    ButterKnife.bind(this);
    presenter.getListDoctor();
  }

  @Override public void viewListDoctor(final List<Doctor> doctors) {
    adapter = new ListDoctorAdapter(doctors, CheckinActivity.this);
    listViewDoctor.setAdapter(adapter);
    listViewDoctor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(CheckinActivity.this, DoctorDetail.class);
        intent.putExtra(DoctorDetail.DOCTOR_ID, doctors.get(position).getId());
        startActivity(intent);
      }
    });
  }
}
