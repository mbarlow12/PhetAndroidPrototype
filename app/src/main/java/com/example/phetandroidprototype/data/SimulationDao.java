package com.example.phetandroidprototype.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SimulationDao {

    // get a simulation by its internal android id
    @Query( "SELECT * from simulations WHERE phet_id=( :id )" )
    Simulation getSimulationById(int id );

    // update a sim's favorite status
    @Query( "UPDATE simulations SET is_favorite = 1 WHERE phet_id=(:id)")
    void addToFavorites( int id );

    // remove a sim's favorite status
    @Query( "UPDATE simulations SET is_favorite = 0 WHERE phet_id=(:id)")
    void removeFromFavorites( int id );

    @Insert
    void insert( Simulation sim );

    @Delete
    void delete( Simulation sim );

    // get all simulations
    @Query( "SELECT * FROM simulations ORDER BY name ASC" )
    LiveData<List<Simulation>> getAllSimulations();

    // git list of limited simulation data (id, name)
    @Query( "select phet_id, name from simulations order by name asc" )
    LiveData<List<SimListItemData>> getSimListItemData();

    // delete all simulations
    @Query( "DELETE FROM simulations" )
    void deleteAll();
}
