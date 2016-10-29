package com.example.linht.bevi.methods;

import android.content.Context;
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
  public ListDoctorAdapter(List<Doctor> doctors, Context context) {
    this.doctors = doctors;
    mInflater = LayoutInflater.from(context);
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
      convertView = mInflater.inflate(R.layout.doctor_item, parent, false);
      holder.image = (ImageView) convertView.findViewById(R.id.doctorAva);
      holder.name = (TextView) convertView.findViewById(R.id.doctorName);
      holder.department = (TextView) convertView.findViewById(R.id.department);
      convertView.setTag(holder);
    } else {
      holder = (ViewHolder) convertView.getTag();
    }
    Doctor doctor = doctors.get(position);

    holder.name.setText(doctor.getName());
    holder.department.setText(doctor.getDepartment());
    return convertView;
  }

  private class ViewHolder{
    private ImageView image;
    private TextView name;
    private TextView department;
  }
}
