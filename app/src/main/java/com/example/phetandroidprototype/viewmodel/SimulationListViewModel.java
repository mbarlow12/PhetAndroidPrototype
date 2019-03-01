package com.example.phetandroidprototype.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.phetandroidprototype.data.SimulationRepo;
import com.example.phetandroidprototype.data.source.local.entity.Simulation;

import java.util.List;

public class SimulationListViewModel extends AndroidViewModel {
    private SimulationRepo simulationRepo;
    private LiveData<List<Simulation>> simulations;

    public SimulationListViewModel( Application application ) {
        super( application );
        simulationRepo = new SimulationRepo( application );
        simulations = simulationRepo.getAllSimulations();
    }

    LiveData<List<Simulation>> getAllSimulations() {
        return simulations;
    }

    public void insert( Simulation sim ) {
        simulationRepo.insert( sim );
    }
}
