package com.example.phetandroidprototype.data.source.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.phetandroidprototype.data.source.local.dao.CategoryDao;
import com.example.phetandroidprototype.data.source.local.dao.JoinSimulationCategoryDao;
import com.example.phetandroidprototype.data.source.local.dao.SimulationDao;
import com.example.phetandroidprototype.data.source.local.entity.Category;
import com.example.phetandroidprototype.data.source.local.entity.JoinSimulationCategory;
import com.example.phetandroidprototype.data.source.local.entity.Simulation;

@Database( entities = {Category.class, JoinSimulationCategory.class, Simulation.class }, exportSchema = false, version = 1 )
public abstract class PhetDatabase extends RoomDatabase {

    // data access objects
    public abstract SimulationDao simulationDao();
    public abstract CategoryDao categoryDao();
    public abstract JoinSimulationCategoryDao simCategoryRelationDao();

    private static final String DB_NAME = "phetsims.db";

    // singleton pattern
    private static volatile PhetDatabase INSTANCE = null;

    synchronized public static PhetDatabase getDatabase( Context ctx ) {
        if ( INSTANCE == null ) {
            INSTANCE = create( ctx, false );
        }

        return INSTANCE;
    }

    static PhetDatabase create( Context context, boolean memoryOnly ) {
        RoomDatabase.Builder<PhetDatabase> b;

        if ( memoryOnly ) {
            b = Room.inMemoryDatabaseBuilder( context.getApplicationContext(), PhetDatabase.class );
        }
        else {
            b = Room.databaseBuilder( context.getApplicationContext(), PhetDatabase.class, DB_NAME );
        }

        return ( b.build() );
    }

//    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
//
//        private final SimulationDao simulationDao;
//
//        PopulateDbAsync( PhetDatabase db ) {
//            simulationDao = db.simulationDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            simulationDao.deleteAll();
//            return null;
//        }
//    }
}
