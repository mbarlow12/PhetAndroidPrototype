package com.example.phetandroidprototype.data;

import androidx.room.ColumnInfo;

public class SimListItemData {

    @ColumnInfo( name="name" )
    public String name;

    @ColumnInfo( name = "phet_id" )
    public int id;
}
