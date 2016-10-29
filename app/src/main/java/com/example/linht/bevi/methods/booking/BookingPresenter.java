package com.example.linht.bevi.methods.booking;

import com.example.domain.interactor.ListDoctorInteractor;
import com.example.domain.model.Doctor;
import com.example.linht.bevi.application.ServiceLocator;
import com.example.linht.bevi.methods.checkin.CheckinPresenter;

import java.util.List;

public class BookingPresenter implements ListDoctorInteractor.FetchListDoctorInteface {
        private com.example.linht.bevi.methods.checkin.CheckinPresenter.ListDoctorView view;
        private ListDoctorInteractor interactor;

        public BookingPresenter(CheckinPresenter.ListDoctorView view) {
            this.view = view;
            interactor = new ListDoctorInteractor();
            interactor.setDoctorRepository(ServiceLocator.getInstance().getDoctorRepository());
            interactor.setListener(this);
        }

        public void getListDoctor(){
            interactor.fetchListDoctor();
        }

        @Override public void listDoctorSucc(List<Doctor> doctors) {
            view.viewListDoctor(doctors);
        }

        public interface ListDoctorView{
            void viewListDoctor(List<Doctor> doctors);
        }
}
