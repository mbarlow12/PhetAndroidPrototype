package com.example.phetandroidprototype.data;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.example.phetandroidprototype.data.source.local.PhetDatabase;
import com.example.phetandroidprototype.data.source.local.dao.SimulationDao;
import com.example.phetandroidprototype.data.source.local.entity.Simulation;

import java.util.List;

public class SimulationRepo {

    private static SimulationRepo INSTANCE = null;
    private SimulationDao mSimulationDao;
    private LiveData<List<Simulation>> mSimulations;

    private SimulationRepo( Application app ) {
        PhetDatabase db = PhetDatabase.getDatabase( app );
        mSimulationDao = db.simulationDao();
        mSimulations = mSimulationDao.getAllSimulations();
    }

    public static SimulationRepo getInstance( Application app ) {
        if ( INSTANCE == null ) {
            INSTANCE = new SimulationRepo( app );
        }
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
