package com.example.domain.interactor;

public abstract class ResponseCallback<T> implements ErrorCallback {
  public abstract void successCallback(T result);
}
