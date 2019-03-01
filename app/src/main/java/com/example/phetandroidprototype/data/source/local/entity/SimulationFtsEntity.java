package com.example.phetandroidprototype.data.source.local.entity;


import androidx.room.Entity;
import androidx.room.Fts4;

@Entity( tableName = "simulationsFts" )
@Fts4( contentEntity = Simulation.class )
public class SimulationFtsEntity {

    private final String name;
    private final String description;

    public SimulationFtsEntity( String name, String description ) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
