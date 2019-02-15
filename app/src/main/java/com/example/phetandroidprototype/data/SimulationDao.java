package com.example.phetandroidprototype.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SimulationDao {

    @Insert
    void insert( SimulationEntity sim );

    @Delete
    void delete( SimulationEntity sim );

    @Query( "SELECT * from simulations ORDER BY name ASC" )
    LiveData<List<SimulationEntity>> getAllSimulations();
}
