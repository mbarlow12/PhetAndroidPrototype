package com.example.phetandroidprototype.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity( foreignKeys = {
        @ForeignKey( entity = SimulationEntity.class, parentColumns = "id", childColumns = "sim_id" ),
        @ForeignKey( entity = CategoryEntity.class, parentColumns = "id", childColumns = "category_id" )
} )
public class SimCategoryRelation {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo( name = "sim_id" )
    public int simId;

    @ColumnInfo( name = "category_id" )
    public int categoryId;

    public SimCategoryRelation( int simId, int categoryId ) {
        this.simId = simId;
        this.categoryId = categoryId;
    }
}
