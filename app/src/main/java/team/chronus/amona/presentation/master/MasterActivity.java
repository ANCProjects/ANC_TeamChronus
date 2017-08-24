package team.chronus.amona.presentation.master;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import team.chronus.amona.R;
import team.chronus.amona.data.model.Event;
import team.chronus.amona.presentation.base.BaseActivity;

public class MasterActivity extends BaseActivity implements MasterMvpView,
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


    @Inject
    MasterMvpPresenter<MasterMvpView> mPresenter;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MasterActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_master_navigation);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        eventList = new ArrayList<>();

        mPresenter.onAttach(MasterActivity.this);
        setUp();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        update();
        setUpNavigationDrawer();
        if (eventList.isEmpty()){
            emptyLayout.setVisibility(View.VISIBLE);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void update(){
        if (adapter == null){
            adapter =  new EventAdapter(eventList, this);
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

    private void setUpNavigationDrawer(){
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open_drawer,
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
