package com.example.phetandroidprototype;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.example.phetandroidprototype.db.PhetDatabase;
import com.example.phetandroidprototype.db.dao.SimulationDao;
import com.example.phetandroidprototype.db.entity.Simulation;

import java.util.List;

public class SimulationRepo {

    private SimulationDao mSimulationDao;
    private LiveData<List<Simulation>> mSimulations;

    SimulationRepo( Application app ) {
        PhetDatabase db = PhetDatabase.getDatabase( app );
        mSimulationDao = db.simulationDao();
        mSimulations = mSimulationDao.getAllSimulations();
    }

    public LiveData<List<Simulation>> getAllSimulations() {
        return mSimulations;
    }

    // adds a simulation to the database
    public void insert( Simulation sim ) {
        new insertAsyncTask( mSimulationDao ).execute( sim );
    }

    private static class insertAsyncTask extends AsyncTask<Simulation, Void, Void > {
        private SimulationDao mSimulationDao;

        insertAsyncTask( SimulationDao simulationDao ) {
            mSimulationDao = simulationDao;
        }

        @Override protected Void doInBackground( final Simulation... simulationEntities ) {
            mSimulationDao.insert( simulationEntities[ 0 ] );
            return null;
        }
    }
}
