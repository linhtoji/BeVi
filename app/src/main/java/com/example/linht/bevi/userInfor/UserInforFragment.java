package com.example.linht.bevi.userInfor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.linht.bevi.R;
import com.example.linht.bevi.methods.MethodFragment;

public class UserInforFragment extends Fragment implements UserInfoPresenter.ViewUserInfo {
  @BindView(R.id.userOkBtn) Button userOk;
  private UserInfoPresenter presenter;
  public UserInforFragment() {
    this.presenter = new UserInfoPresenter(this);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_user_infor, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @OnClick(R.id.userOkBtn) public void okBtn(){
    MethodFragment methodFragment = new MethodFragment();
    FragmentManager userFragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = userFragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.fistFrag, methodFragment);
    fragmentTransaction.commit();
    presenter.setUserState(true);
  }

  @Override public void viewUserInfo(boolean userState) {

  }
}
