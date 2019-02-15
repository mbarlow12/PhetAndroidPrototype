package com.example.phetandroidprototype;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.phetandroidprototype.data.SimulationEntity;
import com.example.phetandroidprototype.data.SimulationRepo;

import java.util.List;

public class SimulationListViewModel extends AndroidViewModel {
    private SimulationRepo simulationRepo;
    private LiveData<List<SimulationEntity>> simulations;

    public SimulationListViewModel( Application application ) {
        super( application );
        simulationRepo = new SimulationRepo( application );
        simulations = simulationRepo.getAllSimulations();
    }

    LiveData<List<SimulationEntity>> getAllSimulations() {
        return simulations;
    }

    public void insert( SimulationEntity sim ) {
        simulationRepo.insert( sim );
    }
}
