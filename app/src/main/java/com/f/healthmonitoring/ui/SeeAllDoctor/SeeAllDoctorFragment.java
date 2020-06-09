package com.f.healthmonitoring.ui.SeeAllDoctor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.f.healthmonitoring.Adapter.DoctorListAdapter;
import com.f.healthmonitoring.Model.AllDoctor;
import com.f.healthmonitoring.Model.Doctor;
import com.f.healthmonitoring.R;
import com.f.healthmonitoring.api_response.ApiClient;
import com.f.healthmonitoring.api_response.ApiInterface;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class SeeAllDoctorFragment extends Fragment {

    private SeeAllDoctorViewModel seeAllDoctorViewModel;
    RecyclerView recyclerView;
    private List<Doctor> doctors;
private AllDoctor allDoctor;
    private ProgressBar progressBar;

    private SearchView searchView;
    private DoctorListAdapter list;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        seeAllDoctorViewModel =
                ViewModelProviders.of(this).get(SeeAllDoctorViewModel.class);
        View root = inflater.inflate(R.layout.fragment_see_all_doctor, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("All Doctor List");

        recyclerView = (RecyclerView)root.findViewById(R.id.recycler_view);
        searchView = (SearchView)root.findViewById(R.id.search);

        progressBar=(ProgressBar)root.findViewById(R.id.progress_doctor);
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
        prepareMovieData();

        return root;
    }
    private void prepareMovieData() {



        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

       progressBar.setVisibility(View.VISIBLE);

        /**
         GET List Resources
         **/
        SharedPreferences prefs = getActivity().getSharedPreferences("login", MODE_PRIVATE);
        String token = prefs.getString("Token", null);//"No name defined" is the default value.
        Call<AllDoctor> call = apiInterface.getAllDoctor("Bearer "+token);
        call.enqueue(new Callback<AllDoctor>() {
            @Override
            public void onResponse(Call<AllDoctor> call, Response<AllDoctor> response) {
                progressBar.setVisibility(View.INVISIBLE);

                if (response.isSuccessful()) {

                    list = new DoctorListAdapter(response.body().getResponse(), getContext());
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(list);
                } else {

                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            private Intent getIntent() {
                return null;
            }

            @Override
            public void onFailure(Call<AllDoctor> call, Throwable t) {
                call.cancel();
                progressBar.setVisibility(View.GONE);

                Log.e("gfgf",t.getMessage());
            }
        });

    }

    private SharedPreferences getSharedPreferences(String login, int modePrivate) {
        return null;
    }
}


