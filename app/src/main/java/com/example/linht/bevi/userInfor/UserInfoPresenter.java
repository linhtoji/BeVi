package com.example.linht.bevi.userInfor;

import com.example.domain.interactor.UserInteractor;

public class UserInfoPresenter implements UserInteractor.UserInfoInterface{
  private ViewUserInfo view;
  public UserInfoPresenter(ViewUserInfo view) {
    this.view = view;
  }

  public void setUserState(boolean state){

  }

  public void getUserState(){
    view.viewUserInfo(true);
  }

  @Override public void userState() {
  }

  public interface ViewUserInfo{
    void viewUserInfo(boolean userState);
  }
}
