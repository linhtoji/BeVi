package com.example.linht.bevi.methods;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.linht.bevi.R;
import com.example.linht.bevi.methods.booking.BookingActivity;
import com.example.linht.bevi.methods.checkin.CheckinActivity;

public class MethodFragment extends Fragment {
  @BindView(R.id.booking) LinearLayout booking;
  @BindView(R.id.checkin) LinearLayout checkin;

  public MethodFragment() {
    // Required empty public constructor
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_method, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @OnClick(R.id.booking) public void booking(){
    Intent intent = new Intent(getActivity(), BookingActivity.class);
    startActivity(intent);
  }

  @OnClick(R.id.checkin) public void checkin(){
    Intent intent = new Intent(getActivity(), CheckinActivity.class);
    startActivity(intent);
  }
}
