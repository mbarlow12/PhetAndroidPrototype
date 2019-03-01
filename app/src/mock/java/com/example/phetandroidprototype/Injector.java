package com.example.phetandroidprototype;

import android.content.Context;
import androidx.annotation.NonNull;
import com.example.phetandroidprototype.data.SimulationFakeRemoteDataSource;
import com.example.phetandroidprototype.data.SimulationRepo;
import com.example.phetandroidprototype.data.source.local.PhetDatabase;

import static com.google.common.base.Preconditions.checkNotNull;

public class Injector {

    public static SimulationRepo provideSimulationRepo( @NonNull Context context ) {
        checkNotNull( context );
        PhetDatabase db = PhetDatabase.getDatabase( context );
        return SimulationRepo.getInstance( SimulationFakeRemoteDataSource.getInstance(),
                                           SimulationLocalDataSource.getInstance( new AppExecutors(), db.simulationDao() ) );
    }
}
