package com.example.linht.bevi;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.linht.bevi.methods.MethodFragment;
import com.example.linht.bevi.userInfor.UserInfoPresenter;
import com.example.linht.bevi.userInfor.UserInforFragment;

public class Main extends AppCompatActivity implements UserInfoPresenter.ViewUserInfo {
  private UserInfoPresenter presenter;

  public Main() {
    this.presenter = new UserInfoPresenter(this);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    presenter.getUserState();
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
