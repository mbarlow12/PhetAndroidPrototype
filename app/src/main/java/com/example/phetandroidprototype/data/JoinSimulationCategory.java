package com.example.phetandroidprototype.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import static androidx.room.ForeignKey.CASCADE;

@Entity( foreignKeys = {
            @ForeignKey( entity = Simulation.class,
                         parentColumns = "phet_id",
                         childColumns = "sim_id",
                         onDelete = CASCADE ),
            @ForeignKey( entity = Category.class,
                         parentColumns = "phet_id",
                         childColumns = "category_id",
                         onDelete = CASCADE ) },
        primaryKeys = { "sim_id", "category_id" },
        tableName = "join_sim_category",
        indices = { @Index( "category_id" ) } )
public class JoinSimulationCategory {

    @ColumnInfo( name = "sim_id" )
    @NonNull
    public Integer simId;

    @ColumnInfo( name = "category_id" )
    @NonNull
    public Integer categoryId;

    public JoinSimulationCategory(int simId, int categoryId ) {
        this.simId = simId;
        this.categoryId = categoryId;
    }
}