package team.chronus.amona.presentation.master;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import team.chronus.amona.R;
import team.chronus.amona.data.model.Event;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

public class MasterFragment extends Fragment implements
        NavigationView.OnNavigationItemSelectedListener{
    private List<Event> eventList;
    private EventAdapter adapter;
    @BindView(R.id.event_list)
    RecyclerView recyclerView;

    @BindView(R.id.no_events)
    RelativeLayout emptyLayout;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        eventList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstance){
        View view = inflater.inflate(R.layout.fragment_master_navigation,
                parent, false);
        unbinder = ButterKnife.bind(this, view);
        update();
        setUpNavigationDrawer();
        if (eventList.isEmpty()){
            emptyLayout.setVisibility(View.VISIBLE);
        }
        return view;
    }
    //call from presenter on success
    public void update(){
        if (adapter == null){
            adapter =  new EventAdapter(eventList);
            recyclerView.setAdapter(adapter);
        }else {
            adapter.setEventList(eventList);
            recyclerView.setAdapter(adapter);
        }


        if (!eventList.isEmpty()){
            emptyLayout.setVisibility(View.GONE);
        }
    }

    //call from presenter on success
    public void setEventList(List<Event> eventList){
        this.eventList = eventList;

    }

    class EventHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.group_picture)
        ImageView eventPicture;

        @BindView(R.id.event_name)
        TextView eventName;

        @BindView(R.id.event_description)
        TextView eventDescription;

        @BindView(R.id.group_name)
        TextView eventGroup;

        @BindView(R.id.event_date)
        TextView eventDate;

        EventHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindEvent(Event event){
            String imageUrl = event.group().urlname();
            //confirm image url
            Picasso.with(getActivity())
                    .load(imageUrl)
                    .placeholder(R.drawable.image_placeholder)
                    .into(eventPicture);

            eventName.setText(event.name());
            eventDescription.setText(event.description());
            eventGroup.setText(event.group().name());
            Date date = new Date(event.time());
            SimpleDateFormat sdf = new SimpleDateFormat
                    ("EEE, MMM d, yyyy 'at' h:mm a", Locale.US);
            String dateString = sdf.format(date);
            eventDate.setText(dateString);
        }
    }

    private class EventAdapter extends RecyclerView.Adapter<EventHolder>{
        private List<Event> eventList;
        private EventAdapter(List<Event> eventList){
            this.eventList = eventList;
        }

        @Override
        public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.master_list_item, parent,
                    false);
            return new EventHolder(view);
        }

        @Override
        public void onBindViewHolder(EventHolder holder, int position) {
            Event event = eventList.get(position);
            holder.bindEvent(event);
        }

        @Override
        public int getItemCount() {
            return eventList.size();
        }

        private void setEventList(List<Event> eventList){
            this.eventList = eventList;

        }
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        unbinder.unbind();
    }

    private void setUpNavigationDrawer(){
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                getActivity(), drawerLayout, toolbar, R.string.open_drawer,
                R.string.close_drawer
        );

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.current_direction:
                //do something
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.meet_up:
                //do something
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.edit_profile:
                //do something:
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
