package com.example.phetandroidprototype.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CategoryEntity {

    @PrimaryKey( autoGenerate = true )
    public int id;
    public String name;
    public int phetId;

    public CategoryEntity( String name, int phetId ) {
        this.name = name;
        this.phetId = phetId;
    }

    public String getName() {
        return name;
    }

    public int getPhetId() {
        return phetId;
    }
}
