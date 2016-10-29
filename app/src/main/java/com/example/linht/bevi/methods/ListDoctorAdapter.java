package com.example.linht.bevi.methods;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.domain.model.Doctor;
import com.example.linht.bevi.R;
import java.util.List;

public class ListDoctorAdapter extends BaseAdapter {
  private List<Doctor> doctors;
  private LayoutInflater mInflater;
  public ListDoctorAdapter(List<Doctor> doctors) {
    this.doctors = doctors;
  }

  @Override public int getCount() {
    return doctors.size();
  }

  @Override public Object getItem(int position) {
    return doctors.get(position);
  }

  @Override public long getItemId(int position) {
    return doctors.get(position).hashCode();
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    if (convertView==null){
      holder = new ViewHolder();
      convertView = mInflater.inflate(R.layout.doctor_item, parent, false)
    }
    return null;
  }

  private class ViewHolder{
    private ImageView image;
    private TextView name;
    private TextView department;
  }
}
