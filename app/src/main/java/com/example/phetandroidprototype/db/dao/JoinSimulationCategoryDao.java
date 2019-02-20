package com.example.phetandroidprototype.db.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.phetandroidprototype.db.entity.Category;
import com.example.phetandroidprototype.db.entity.JoinSimulationCategory;
import com.example.phetandroidprototype.db.entity.Simulation;

@Dao
public interface JoinSimulationCategoryDao {

    // get all category ids for a single sim
    @Query( "select phet_id, name, type from categories " +
            "inner join join_sim_category on categories.phet_id = join_sim_category.category_id " +
            "where sim_id = :simulationPhetId" )
    List<Category> getSimulationCategories( int simulationPhetId );

    // get all sims from a category
    @Query( "select phet_id, name, is_favorite from simulations " +
            "inner join join_sim_category on simulations.phet_id = sim_id " +
            "where category_id = :catId" )
    List<Simulation> getSingleFilteredSimulations( int catId );

    // git all sims for individual grade level and topic categories
    @Query( "select phet_id, name, is_favorite from simulations " +
            "inner join join_sim_category on simulations.phet_id = sim_id " +
            "where category_id = :gradeLevelId and category_id = :topicId" )
    List<Simulation> getDualFilteredSimulationIds( int gradeLevelId, int topicId );

    @Insert
    void insert( JoinSimulationCategory relation );

//    @Query( "delete from sim_category_relation where sim_id = :simId")
//    void deleteSimulationById( int simId );
//
//    @Query( "delete from sim_category_relation where category_id = :catId" )
//    void deleteCategoryById( int catId );

}
