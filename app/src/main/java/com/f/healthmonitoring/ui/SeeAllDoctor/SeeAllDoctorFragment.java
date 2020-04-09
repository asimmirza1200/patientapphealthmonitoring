package com.f.healthmonitoring.ui.SeeAllDoctor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.f.healthmonitoring.Adapter.DoctorListAdapter;
import com.f.healthmonitoring.Model.Doctor;
import com.f.healthmonitoring.R;

import java.util.ArrayList;
import java.util.List;

public class SeeAllDoctorFragment extends Fragment {

    private SeeAllDoctorViewModel seeAllDoctorViewModel;
    RecyclerView recyclerView;
    private List<Doctor> doctors;
    private SearchView searchView;
    private DoctorListAdapter list;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        seeAllDoctorViewModel =
                ViewModelProviders.of(this).get(SeeAllDoctorViewModel.class);
        View root = inflater.inflate(R.layout.fragment_see_all_doctor, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("All Doctor List");

        searchView = (SearchView)root.findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                list.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                list.getFilter().filter(newText);


                return false;
            }
        });
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        doctors = new ArrayList<>();
        doctors.add(new Doctor("Atif","Surgen","03075445663"));
        doctors.add(new Doctor("Atif","Surgen","03075445663"));
        doctors.add(new Doctor("Atif","Surgen","03075445663"));
        doctors.add(new Doctor("Atif","Surgen","03075445663"));
        doctors.add(new Doctor("Atif","Surgen","03075445663"));
        doctors.add(new Doctor("Atif","Surgen","03075445663"));
        doctors.add(new Doctor("Atif","Surgen","03075445663"));
        doctors.add(new Doctor("Atif","Surgen","03075445663"));


        list = new DoctorListAdapter(doctors, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(list );

        return root;

    }

}
