package com.example.linht.bevi.methods.checkin;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.eddystone.Eddystone;
import com.example.domain.model.Doctor;
import com.example.linht.bevi.R;
import com.example.linht.bevi.methods.detail.DoctorDetail;
import com.example.linht.bevi.methods.ListDoctorAdapter;
import java.util.ArrayList;
import java.util.List;

public class CheckinActivity extends AppCompatActivity implements CheckinPresenter.ListDoctorView {

  private ListDoctorAdapter adapter;
  private CheckinPresenter presenter;
  private BeaconManager beaconManager;
  private String scanId;
  private List<Eddystone> eddystones;
  private static final int REQUEST_CODE_LOCATION = 3;

  @BindView(R.id.listViewDoctor) ListView listViewDoctor;

  public CheckinActivity() {
    this.presenter = new CheckinPresenter(this);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_checkin);
    ButterKnife.bind(this);
    handleLocationPermission();
    presenter.getListDoctor();
    beaconManager = new BeaconManager(this);
    scanBeacon();
  }

  public void handleLocationPermission() {
    int permissionCheck =
        ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
    if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(this,
          new String[] { Manifest.permission.ACCESS_FINE_LOCATION }, REQUEST_CODE_LOCATION);
    }
  }

  @OnClick(R.id.bt_back) public void onBackPress() {
    onBackPressed();
  }

  @Override protected void onStart() {
    super.onStart();
  }

  private void scanBeacon() {
    beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
      @Override public void onServiceReady() {
        scanId = beaconManager.startEddystoneScanning();
      }
    });

    beaconManager.setEddystoneListener(new BeaconManager.EddystoneListener() {
      @Override public void onEddystonesFound(List<Eddystone> eddystones) {
        if (!eddystones.isEmpty()) {
          CheckinActivity.this.eddystones = eddystones;
          List<Doctor> doctors = CheckinActivity.this.presenter.getDoctorFormSample();
          List<Doctor> upDateDoctors = new ArrayList<Doctor>();
          for (Doctor doctor : doctors) {
            for (Eddystone eddystone : eddystones) {
              if (doctor.getBeaconId() != null) {
                if (doctor.getBeaconId().equals(eddystone.namespace + eddystone.instance)) {
                  upDateDoctors.add(doctor);
                }
              }
            }
          }

          CheckinActivity.this.presenter.updateListDoctor(upDateDoctors);
        }
      }
    });
  }

  @Override protected void onStop() {
    super.onStop();
    beaconManager.stopEddystoneScanning(scanId);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    beaconManager.disconnect();
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
