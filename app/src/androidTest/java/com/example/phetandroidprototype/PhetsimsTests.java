package com.example.phetandroidprototype;

import android.content.Context;

import com.example.phetandroidprototype.db.entity.Category;
import com.example.phetandroidprototype.db.entity.JoinSimulationCategory;
import com.example.phetandroidprototype.db.PhetDatabase;
import com.example.phetandroidprototype.db.entity.Simulation;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests to execute
 * - save and retrieve each type (Simulation, Category, JoinSimulationCategory)
 * - ensure deleting a sim & category cascades to the relation table
 * - test the relation field on the Simulation
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class PhetsimsTests {

    private List<Simulation> testSims;
    private List<Category> testCats;
    Context appContext = InstrumentationRegistry.getTargetContext();
    PhetDatabase db = PhetDatabase.get( appContext );

    public void initTestSims() {
        List<Simulation> sims = new ArrayList<>();
        sims.add(new Simulation( "Test Simulation", 44 ) );
        sims.add( new Simulation( "atomic interaction", 88 ) );
        sims.add( new Simulation( "coulombs law", 131 ) );
        testSims = sims;
    }

    private void insertTestSims() {
        for (Simulation sim :
                testSims) {
            db.simulationDao().insert(sim);
        }
    }

    private void insertTestCategories() {
        for (Category cat :
                testCats) {
            db.categoryDao().insert(cat);
        }
    }

    public void initCategories() {
        testCats = new ArrayList<>();
        testCats.add( new Category( "cat1", 11, Category.GRADE_LEVEL ) );
        testCats.add( new Category( "biology", 22, Category.TOPIC ) );
        testCats.add( new Category( "university", 33, Category.GRADE_LEVEL ) );
    }

    @Test
    public void SimulationTest() {
        // Context of the app under test.
        db.clearAllTables();
        initCategories();
        initTestSims();

        Simulation ret = db.simulationDao().getSimulationById( 44 );
        assertEquals( ret.getName(), testSims.get( 0 ).getName() );
    }

    @Test
    public void JoinSimulationCategoryTests() {
        db.clearAllTables();
        initTestSims();
        initCategories();
        insertTestCategories();
        insertTestSims();


        int[] testCatIds = { 11, 22 };

        for ( int catId : testCatIds ) {

            JoinSimulationCategory join = new JoinSimulationCategory( 88, catId );
            db.simCategoryRelationDao().insert( join );
        }

        List<Category> retCats = db.simCategoryRelationDao().getSimulationCategories( 88 );

        // should only have 2 categories
        assertEquals( retCats.size(), 2 );

        for (int i = 0; i < retCats.size(); i++) {
            assertEquals( retCats.get( i ).getPhetId(), (Integer) testCatIds[ i ] );
        }
    }
}
