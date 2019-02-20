package com.example.phetandroidprototype.db.entity;


import androidx.room.Entity;
import androidx.room.Fts4;

@Entity( tableName = "simulationsFts" )
@Fts4( contentEntity = Simulation.class )
public class SimulationFtsEntity {

    private final String name;

    public SimulationFtsEntity( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
