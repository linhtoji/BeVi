package com.example.linht.bevi.userInfor;

import com.example.domain.interactor.UserInteractor;
import com.example.linht.bevi.application.ServiceLocator;

public class UserInfoPresenter implements UserInteractor.UserInfoInterface {
  private ViewUserInfo view;

  public UserInfoPresenter(ViewUserInfo view) {
    this.view = view;
  }

  public void setUserState(boolean state) {
    ServiceLocator.getInstance().getPrefrenceRepository().setStateLogin(state);
  }

  public void getUserState() {
    view.viewUserInfo(ServiceLocator.getInstance().getPrefrenceRepository().isStateLogin());
  }

  @Override public void userState() {
  }

  public interface ViewUserInfo {
    void viewUserInfo(boolean userState);
  }
}
