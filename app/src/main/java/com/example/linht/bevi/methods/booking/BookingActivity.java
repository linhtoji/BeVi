package com.example.linht.bevi.methods.booking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.domain.model.Doctor;
import com.example.domain.model.User;
import com.example.linht.bevi.R;
import com.example.linht.bevi.methods.ListDoctorAdapter;
import com.example.linht.bevi.methods.checkin.CheckinActivity;
import com.example.linht.bevi.methods.checkin.CheckinPresenter;
import com.example.linht.bevi.methods.detail.DoctorDetail;
import com.example.linht.bevi.methods.detail.DoctorDetailPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookingActivity extends AppCompatActivity implements CheckinPresenter.ListDoctorView{

  private ListDoctorAdapter adapter;
  private CheckinPresenter presenter;

  @BindView(R.id.listViewDoctorbooking) ListView listViewDoctor;

  public BookingActivity() {
    this.presenter = new CheckinPresenter(this);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_booking);
    ButterKnife.bind(this);
    presenter.getListDoctor();
  }

  @Override public void viewListDoctor(final List<Doctor> doctors) {
    adapter = new ListDoctorAdapter(doctors, BookingActivity.this);
    listViewDoctor.setAdapter(adapter);
    listViewDoctor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(BookingActivity.this, BookindCalender.class);
        startActivity(intent);
      }
    });
  }
}
