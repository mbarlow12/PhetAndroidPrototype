package com.example.phetandroidprototype.data.source.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.example.phetandroidprototype.data.source.local.entity.Simulation;

import java.util.List;

@Dao
public interface SimulationDao {

    // get a simulation by its internal android id
    @Query( "SELECT * from simulations WHERE phet_id=( :id )" )
    Simulation getSimulationById( int id );

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

    @Update
    void update( Simulation sim );

    // get all simulations
    @Query( "SELECT * FROM simulations ORDER BY name ASC" )
    LiveData<List<Simulation>> getAllSimulations();

    // delete all simulations
    @Query( "DELETE FROM simulations" )
    void deleteAll();

//    @Query( "SELECT simulations.* FROM simulations " +
//            "JOIN join_sim_category ON (simulations.phet_id = sim_id) " +
//            "JOIN simulationsFts ON (simulations.phet_id = simulations.rowid) " +
//            "WHERE simulationsFts MATCH :query" )
//    LiveData<List<Simulation>> searchSimulations( String query );
}
