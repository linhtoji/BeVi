package com.example.linht.bevi;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import com.example.linht.bevi.methods.MethodFragment;
import com.example.linht.bevi.userInfor.UserInfoPresenter;
import com.example.linht.bevi.userInfor.UserInforFragment;

public class Main extends AppCompatActivity implements UserInfoPresenter.ViewUserInfo {
  private static final int REQUEST_CODE_LOCATION = 3;
  private UserInfoPresenter presenter;

  public Main() {
    this.presenter = new UserInfoPresenter(this);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    presenter.getUserState();
    handleLocationPermission();
  }

  public void handleLocationPermission() {
    int permissionCheck =
        ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
    if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(this,
          new String[] { Manifest.permission.ACCESS_FINE_LOCATION }, REQUEST_CODE_LOCATION);
    }
  }

  @Override public void viewUserInfo(boolean userState) {
    if (!userState){
      UserInforFragment userInforFragment = new UserInforFragment();
      FragmentManager userFragmentManager = getSupportFragmentManager();
      FragmentTransaction fragmentTransaction = userFragmentManager.beginTransaction();
      fragmentTransaction.replace(R.id.fistFrag, userInforFragment);
      fragmentTransaction.commit();
    } else {
      MethodFragment methodFragment = new MethodFragment();
      FragmentManager userFragmentManager = getSupportFragmentManager();
      FragmentTransaction fragmentTransaction = userFragmentManager.beginTransaction();
      fragmentTransaction.replace(R.id.fistFrag, methodFragment);
      fragmentTransaction.commit();
    }
  }
}
