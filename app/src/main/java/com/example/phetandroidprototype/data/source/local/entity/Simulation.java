package com.example.phetandroidprototype.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.*;

import java.util.Objects;

import static androidx.room.ColumnInfo.INTEGER;

@Entity( tableName = "simulations" )
public class Simulation {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "phet_id")
    private final Integer phetId;

    @ColumnInfo(name = "favorite")
    private final boolean isFavorite;

    private final String name;
    private final String description;
    private final String title;
    private final String simulationUrl;
    private final String screenshotUrl;
    private final String version;
    private final String simulationHash;
    private final String screenshotHash;

    public Simulation( @NonNull Integer phetId, boolean isFavorite, String name, String description,
                       String title, String simulationUrl, String screenshotUrl, String version,
                       String simulationHash, String screenshotHash ) {
        this.phetId = phetId;
        this.isFavorite = isFavorite;
        this.name = name;
        this.description = description;
        this.title = title;
        this.simulationUrl = simulationUrl;
        this.screenshotUrl = screenshotUrl;
        this.version = version;
        this.simulationHash = simulationHash;
        this.screenshotHash = screenshotHash;
    }

    @NonNull public Integer getPhetId() {
        return phetId;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getSimulationUrl() {
        return simulationUrl;
    }

    public String getScreenshotUrl() {
        return screenshotUrl;
    }

    public String getVersion() {
        return version;
    }

    public String getSimulationHash() {
        return simulationHash;
    }

    public String getScreenshotHash() {
        return screenshotHash;
    }

    @Override
    public boolean equals( @Nullable Object obj ) {
        if ( this == obj ) return true;
        if ( obj == null || getClass() != obj.getClass() ) return false;
        Simulation other = ( Simulation ) obj;
        return phetId == other.phetId &&
               name.equals( other.name ) &&
               description.equals( other.description );
    }

    @Override
    public int hashCode() {
        return Objects.hash( phetId, name, description );
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
