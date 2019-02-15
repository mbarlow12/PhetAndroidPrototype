package com.example.phetandroidprototype.data;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;

import java.util.List;

public class SimulationRepo {

    private SimulationDao simulationDao;
    private LiveData<List<SimulationEntity>> simulations;

    public SimulationRepo( Application app ) {
        PhetDatabase db = PhetDatabase.get( app );
        simulationDao = db.simulationDao();
        simulations = simulationDao.getAllSimulations();
    }

    public LiveData<List<SimulationEntity>> getAllSimulations() {
        return simulations;
    }

    public void insert( SimulationEntity sim ) {
        new insertAsyncTask( simulationDao ).execute( sim );
    }

    private static class insertAsyncTask extends AsyncTask<SimulationEntity, Void, Void > {
        private SimulationDao simulationDao;

        insertAsyncTask( SimulationDao simulationDao ) {
            this.simulationDao = simulationDao;
        }

        @Override protected Void doInBackground( SimulationEntity... simulationEntities ) {
            simulationDao.insert( simulationEntities[ 0 ] );
            return null;
        }
    }
}
