package com.example.phetandroidprototype.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;

@Entity( tableName = "simulations" )
public class SimulationEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;

    @Relation( entity = SimCategoryRelation.class, parentColumn = "sim_id", entityColumn = "id" )
    public List<CategoryEntity> categories;

    public SimulationEntity( @NonNull String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Number> getCategoryPhetIds() {
        List<Number> ids = new ArrayList<>();
        for ( CategoryEntity cat : categories ) {
            ids.add( cat.getPhetId() );
        }
        return ids;
    }
}
