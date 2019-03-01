package com.example.phetandroidprototype.data.source.local;

import androidx.annotation.NonNull;
import com.example.phetandroidprototype.data.source.PhetDataSource;
import com.example.phetandroidprototype.data.source.local.dao.CategoryDao;
import com.example.phetandroidprototype.data.source.local.dao.SimulationDao;

public class PhetLocalDataSource implements PhetDataSource {

    private static PhetLocalDataSource INSTANCE;

    private SimulationDao mSimulationDao;
    private CategoryDao mCategoryDao;

    private AppExecutors mAppExecutors;
    
    @Override public void getSimulations( @NonNull LoadSimulationsCallback cb ) {

    }

    @Override public void getSimulation( @NonNull GetSimulationCallback cb ) {

    }
}
