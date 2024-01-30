package com.example.spacextrackerapp.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.spacextrackerapp.model.Favorite;
import com.example.spacextrackerapp.model.FlightItemDetails;
import com.example.spacextrackerapp.network.ApiInterface;
import com.example.spacextrackerapp.network.NetworkModule;
import com.example.spacextrackerapp.repositories.LaunchesRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class LaunchesViewModel extends AndroidViewModel {
    private LaunchesRepository repository;
    public LiveData<List<FlightItemDetails>> getAllLaunches;

    public LaunchesViewModel(@NonNull Application application) {
        super(application);
        repository=new LaunchesRepository(application);
        getAllLaunches=repository.getAllLaunches();
    }

    public void insert(List<FlightItemDetails> launches){
        repository.insert(launches);
    }

    public boolean getIsFavorite(int flightId){
        return repository.isFavourite(flightId);
    }

    public void addFavourite(int flightId){
        Favorite favorite = new Favorite(flightId,true);
        repository.addFavorite(favorite);
    }

    public void removeFavourite(int flightId){
        Favorite favorite = new Favorite(flightId, false);
        repository.removeFavorite(favorite);
    }

    public LiveData<List<FlightItemDetails>> getAllLaunches()
    {
        return getAllLaunches;
    }



    public LiveData<List<FlightItemDetails>> getAllLaunchesUpdate(Boolean update) {

        if (getAllLaunches.getValue() == null || update) {
            ApiInterface api = NetworkModule.getClient();
            Call<List<FlightItemDetails>> call = api.getLaunches();
            call.enqueue(new retrofit2.Callback<List<FlightItemDetails>>() {
                @Override
                public void onResponse(Call<List<FlightItemDetails>> call, Response<List<FlightItemDetails>> response) {
                    if (response.isSuccessful()) {
                        repository.insert(response.body());
                    }
                }
                @Override
                public void onFailure(Call<List<FlightItemDetails>> call, Throwable t) {
                    Log.e("main", "onFailure: " + t.getMessage());
                }
            });
        } else {
            getAllLaunches=repository.getAllLaunches();
        }

        return getAllLaunches;
    }


}
