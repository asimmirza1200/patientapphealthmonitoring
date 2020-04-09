package com.f.healthmonitoring.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.f.healthmonitoring.Adapter.PatientListAdapter;
import com.f.healthmonitoring.Model.Patient;
import com.f.healthmonitoring.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView recyclerView;
    private List<Patient> patients;
    private SearchView searchView;
    private PatientListAdapter list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Home");

        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        searchView = (SearchView)root.findViewById(R.id.searchp);
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
        RecyclerView recyclerView = root.findViewById(R.id.recyclep);
        patients = new ArrayList<>();
        patients.add(new Patient("ali","umer"));
        patients.add(new Patient("hassan","usman"));
        patients.add(new Patient("raza","munir"));
        patients.add(new Patient("asad","uzair"));
        patients.add(new Patient("awais","uzair"));
        patients.add(new Patient("haseeb","adnan"));
        patients.add(new Patient("faisal","umer"));
        patients.add(new Patient("babar","azam"));
        patients.add(new Patient("ubaid","fazal"));
        patients.add(new Patient("moiz","kamran"));
        patients.add(new Patient("hamza","aftab"));
        patients.add(new Patient("hamza","khalid"));

        list = new PatientListAdapter(patients, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(list );

        return root;

    }
}
