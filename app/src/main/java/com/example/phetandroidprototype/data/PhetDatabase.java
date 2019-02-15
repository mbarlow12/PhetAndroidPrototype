package com.example.phetandroidprototype.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database( entities = {CategoryEntity.class, SimCategoryRelation.class, SimulationEntity.class }, version = 1 )
public abstract class PhetDatabase extends RoomDatabase {
    public abstract SimulationDao simulationDao();

    private static final String DB_NAME = "phetsims.db";
    private static volatile PhetDatabase INSTANCE = null;

    synchronized static PhetDatabase get( Context ctx ) {
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
}
