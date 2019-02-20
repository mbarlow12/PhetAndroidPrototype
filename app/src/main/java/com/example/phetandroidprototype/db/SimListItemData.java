package com.example.phetandroidprototype.db;

import androidx.room.ColumnInfo;

public class SimListItemData {

    @ColumnInfo( name="name" )
    public String name;

    @ColumnInfo( name = "phet_id" )
    public int id;
}
