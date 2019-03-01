package com.example.phetandroidprototype.data.source;

import androidx.annotation.NonNull;
import com.example.phetandroidprototype.data.source.local.entity.Simulation;

import java.util.List;

public interface PhetDataSource {

    interface LoadSimulationsCallback {
        void onSimulationsLoaded( List<Simulation> sims );
        void onDataUnavailable();
    }

    interface GetSimulationCallback {
        void onSimulationLoaded( Simulation simulation );
        void onDataUnavailable();
    }

    void getSimulations( @NonNull LoadSimulationsCallback cb );

    void getSimulation( @NonNull GetSimulationCallback cb );
}
