package com.f.healthmonitoring.ui.SeeMedicinePrescriptions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.f.healthmonitoring.Adapter.MedicineListAdapter;
import com.f.healthmonitoring.Model.Medicine;
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

public class SeeMedicinePrescriptionsFragment extends Fragment {

    private SeeMedicinePrescriptionsViewModel seeMedicinePrescriptionsViewModel;


    RecyclerView recyclerView;
    private List<Medicine> medicines;
    private SearchView searchView;
    private MedicineListAdapter list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        seeMedicinePrescriptionsViewModel =
                ViewModelProviders.of(this).get(SeeMedicinePrescriptionsViewModel.class);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Medicine list");

        View root = inflater.inflate(R.layout.fragment_see_medicine_prescriptions, container, false);

        final TextView textView = root.findViewById(R.id.text_home);
        seeMedicinePrescriptionsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
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
        medicines = new ArrayList<>();
        medicines.add(new Medicine("Panadol","Atif","null","fever"));
        medicines.add(new Medicine("Panadol","Atif","null","fever"));
        medicines.add(new Medicine("Panadol","Atif","null","fever"));
        medicines.add(new Medicine("Panadol","Atif","null","fever"));
        medicines.add(new Medicine("Panadol","Atif","null","fever"));
        medicines.add(new Medicine("Panadol","Atif","null","fever"));
        medicines.add(new Medicine("Panadol","Atif","null","fever"));
        medicines.add(new Medicine("Panadol","Atif","null","fever"));

        list = new MedicineListAdapter(medicines, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(list );

        return root;

    }
}