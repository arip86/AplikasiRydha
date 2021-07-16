package com.example.akhmadarip.tentangkami;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewStub stubGrid;
    private ViewStub stubList;
    private ListView listView;
    private GridView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;
    private List<Menubar> menubarList;
    private int currentViewMode = 0;
    static final int VIEW_MODE_LISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stubList = (ViewStub) findViewById(R.id.stub_list);
        stubGrid = (ViewStub) findViewById(R.id.stub_grid);


        stubList.inflate();
        stubGrid.inflate();

        listView = (ListView) findViewById(R.id.mylistview);
        gridView = (GridView) findViewById(R.id.mygridview);


        getMenubarList();
        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
        currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);

        listView.setOnItemClickListener(onItemClick);
        gridView.setOnItemClickListener(onItemClick);



        switchView();

    }

    private void switchView() {
        if (VIEW_MODE_LISTVIEW == currentViewMode) {
            stubList.setVisibility(View.VISIBLE);
            stubGrid.setVisibility(View.GONE);
        } else {
            stubList.setVisibility(View.GONE);
            stubGrid.setVisibility(View.VISIBLE);

        }
        setAdapter();
    }

    private void setAdapter() {
        if (VIEW_MODE_LISTVIEW == currentViewMode) {
            listViewAdapter = new ListViewAdapter(this, R.layout.list_item, menubarList);
            listView.setAdapter(listViewAdapter);
        } else {
            gridViewAdapter = new GridViewAdapter(this, R.layout.grid_item, menubarList);
            gridView.setAdapter(gridViewAdapter);
        }
    }

    public List<Menubar> getMenubarList() {

        menubarList = new ArrayList<>();
        menubarList.add(new Menubar(R.drawable.logo_rydha, "Sejarah Rydha", "Yayasan Rumah Yatim Dhuafa Rydha berdiri pada tahun..."));
        menubarList.add(new Menubar(R.drawable.logo_rydha, "Visi & Misi", "Visi Rumah Yatim Dhuafa Rydha sebagai berikut.."));
        menubarList.add(new Menubar(R.drawable.logo_rydha, "Data anak", "Data anak asuh Rumah Yatim Dhuafa Rydha..."));
        return menubarList;

    }

    private AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Toast.makeText(getApplicationContext(), menubarList.get(position).getTitle() +" - "+ menubarList.get(position).getDescription(), Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_menu_1:
            if (VIEW_MODE_LISTVIEW == currentViewMode) {
                currentViewMode = VIEW_MODE_GRIDVIEW;
            } else {
                currentViewMode = VIEW_MODE_LISTVIEW;
            }
            switchView();
             SharedPreferences sharedPreference = getSharedPreferences("ViewMode", MODE_PRIVATE);
             SharedPreferences.Editor editor = sharedPreference.edit();
             editor.putInt("currentViewMode", currentViewMode);
             editor.commit();
                break;
        }
        return true;
    }
}


