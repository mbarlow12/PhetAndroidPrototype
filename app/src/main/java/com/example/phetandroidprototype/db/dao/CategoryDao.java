package com.example.phetandroidprototype.db.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.phetandroidprototype.db.entity.Category;

@Dao
public interface CategoryDao {

    @Query( "SELECT * FROM categories WHERE type = :type")
    List<Category> _getCategoriesOfType( int type );

    @Insert
    void insert( Category category );

    @Delete
    void delete( Category category);

    @Query( "DELETE FROM categories WHERE phet_id = (:id)")
    void delete( int id );

    @Query( "DELETE from categories" )
    void deleteAll();
}
