package com.example.phetandroidprototype.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;

import static androidx.room.ColumnInfo.INTEGER;

@Entity( tableName = "simulations" )
public class Simulation {

    @PrimaryKey
    @NonNull
    @ColumnInfo( name = "phet_id" )
    private Integer phetId;

    @ColumnInfo( name = "is_favorite",
                 typeAffinity = INTEGER )
    private boolean isFavorite;

    private String name;

    public Simulation(@NonNull String name, @NonNull int phetId ) {
        this.phetId = phetId;
        this.name = name;
        this.isFavorite = false;
    }

    public Integer getPhetId() {
        return phetId;
    }

    public void setPhetId(Integer phetId) {
        this.phetId = phetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}


/**
 * the architecture should be
 * public class Simulation {
 *     this will not be an entity just a POJO
 *     int phetId;
 *     int id...
 *     name, screenshotUrl, etc...
 * }
 *
 * @Entity
 * public class Category {
 *     // used for all grade level and topics
 *     int id;
 *     int phetId;
 *     name, type(GRADE_LEVEL|TOPIC)   // NOTE: 'all' will probably need 2 entries
 * }
 *
 * public class CategoryId {
 *      int id;
 * }
 *
 * @Entity
 * public class SimWithCateogory {
 * @Embedded
 * public Simulation simulation;
 * @Relation(
 * }
 */
