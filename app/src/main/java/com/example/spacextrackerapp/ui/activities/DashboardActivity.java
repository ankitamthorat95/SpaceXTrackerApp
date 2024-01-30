package com.example.spacextrackerapp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.spacextrackerapp.R;
import com.example.spacextrackerapp.databinding.ActivityDashboardBinding;
import com.example.spacextrackerapp.model.FlightItemDetails;
import com.example.spacextrackerapp.repositories.LaunchesRepository;
import com.example.spacextrackerapp.ui.adapter.LaunchesAdapter;
import com.example.spacextrackerapp.viewmodels.LaunchesViewModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    ActivityDashboardBinding binding;
    private LaunchesViewModel launchesViewModel;
    private List<FlightItemDetails> flightItemDetailsList = new ArrayList<>();
    private LaunchesAdapter adapter;
    private RecyclerView recyclerView;
    private LaunchesRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        launchesViewModel = new ViewModelProvider(this).get(LaunchesViewModel.class);
        binding.dashboardRecyclerView.setLayoutManager (new LinearLayoutManager(DashboardActivity.this));
        adapter = new LaunchesAdapter(DashboardActivity.this, flightItemDetailsList,launchesViewModel, new LaunchesAdapter.ActionListener() {
            @Override
            public void onCardClick(FlightItemDetails flightItemDetails) {
                Intent intent = new Intent(DashboardActivity.this, LaunchDetailsActivity.class);
                intent.putExtra("LaunchDetails",flightItemDetails);
                startActivity(intent);
            }

            @Override
            public void addFavorite(FlightItemDetails flightItemDetails) {
                launchesViewModel.addFavourite(flightItemDetails.flightNumber);
            }

            @Override
            public void removeFavorite(FlightItemDetails flightItemDetails) {
                launchesViewModel.removeFavourite(flightItemDetails.flightNumber);
            }

        });
        binding.dashboardRecyclerView.setAdapter(adapter);


        handleSwipeToRefresh();


        binding.progressBar.setVisibility(View.VISIBLE);
        launchesViewModel.getAllLaunches.observe(DashboardActivity.this, new Observer<List<FlightItemDetails>>() {
            @Override
            public void onChanged(List<FlightItemDetails> flightItemDetailslist) {
                if (flightItemDetailslist.size() == 0){
                    // no offline data found
                    binding.placeholderImageView.setVisibility(View.VISIBLE);
                    binding.placeholderTextView.setVisibility(View.VISIBLE);
                    fetchLaunchesList(true);
                }else {
                    binding.progressBar.setVisibility(View.GONE);
                    binding.placeholderImageView.setVisibility(View.GONE);
                    binding.placeholderTextView.setVisibility(View.GONE);
                    flightItemDetailsList.clear();
                    flightItemDetailsList.addAll(flightItemDetailslist);
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }


    private void handleSwipeToRefresh() {
        binding.progressBar.setVisibility( View.VISIBLE);

        binding.swipeToRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh()  {
                //getting list from Api
                fetchLaunchesList(true);
                binding.swipeToRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void fetchLaunchesList(boolean refresh) {
        launchesViewModel.getAllLaunchesUpdate(refresh).observe(this, new Observer<List<FlightItemDetails>>() {
            @Override
            public void onChanged(List<FlightItemDetails> flightItemDetails) {
                launchesViewModel.getAllLaunches();
                binding.progressBar.setVisibility( View.GONE);
            }
        });
    }
    }
