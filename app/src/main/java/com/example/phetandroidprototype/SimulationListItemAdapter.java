package com.example.phetandroidprototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.phetandroidprototype.data.CategoryEntity;
import com.example.phetandroidprototype.data.SimulationEntity;

import java.util.Arrays;
import java.util.List;

public class SimulationListItemAdapter extends RecyclerView.Adapter<SimulationListItemAdapter.SimItemViewHolder> {


    class SimItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView simName;
        private final TextView categories;

        public SimItemViewHolder( View view ) {
            super( view );
            simName = view.findViewById( R.id.title );
            categories = view.findViewById( R.id.categories );
        }
    }

    private final LayoutInflater mLayoutInflater;
    private List<SimulationEntity>  mSimulationList;

    public SimulationListItemAdapter( Context context ) {
        mLayoutInflater = LayoutInflater.from( context );
    }

    void setSimulationList( List<SimulationEntity> sims ) {
        mSimulationList = sims;
        notifyDataSetChanged();
    }

    @NonNull @Override public SimItemViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        View itemView = mLayoutInflater.inflate( R.layout.sim_list_item, parent, false );
        return new SimItemViewHolder( itemView );
    }

    @Override public void onBindViewHolder( @NonNull SimItemViewHolder holder, int position ) {
        SimulationEntity sim = mSimulationList.get( position );
        holder.simName.setText( sim.getName() );
        holder.categories.setText( String.format( "%d %d %d", sim.getCategoryPhetIds() ) );
    }

    @Override public int getItemCount() {
        return 0;
    }
}
