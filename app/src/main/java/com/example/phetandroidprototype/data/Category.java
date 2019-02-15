package com.example.phetandroidprototype.data;

import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity( tableName = "categories")
public class Category {

    public static final int GRADE_LEVEL = 111;
    public static final int TOPIC = 222;

    @PrimaryKey
    @ColumnInfo( name = "phet_id" )
    private final Integer phetId;
    private final String name;
    private final Integer type;

    public Category(String name, int phetId, int type) {
        this.name = name;
        this.phetId = phetId;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Integer getPhetId() {
        return phetId;
    }

    public Integer getType() {
        return type;
    }
}

