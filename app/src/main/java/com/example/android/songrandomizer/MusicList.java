package com.example.android.songrandomizer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.PermissionRequest;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;




public class MusicList extends AppCompatActivity {


    ListView listView;
    String items[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);

        listView=findViewById(R.id.listViewSong);

        runtimePermission();
    }

    public void runtimePermission()
    {
        Dexter.withContext(this).withPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                        displaySongs();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<com.karumi.dexter.listener.PermissionRequest> list, PermissionToken permissionToken) {

                        permissionToken.continuePermissionRequest();
                    }
                }).check();

    }

    public ArrayList<File> findSong(File file)
    {
        ArrayList<File> arrayList = new ArrayList<>();

        File[] files= file.listFiles();

        for (File singlefile: files != null ? files : new File[0])
        {
            if(singlefile.isDirectory() && !singlefile.isHidden())
            {
                arrayList.addAll(findSong(singlefile));
            }

            else
            {
                if(singlefile.getName().endsWith(".mp3") || singlefile.getName().endsWith(".wav"))
                {
                    arrayList.add(singlefile);
                }
            }
        }
        return arrayList;
    }

    void displaySongs()
    {
        final ArrayList<File> mySongs= findSong(Environment.getExternalStorageDirectory());

        items=new String[mySongs.size()];

        for(int i=0;i< mySongs.size();i++)
        {
            items[i]=mySongs.get(i).getName().toString().replace(".mp3", "").replace(".wav", "");
        }
            /*ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
            listView.setAdapter(myAdapter); */

        customAdapter customAdapter= new customAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                String songName = (String) listView.getItemAtPosition(i);


                startActivity(new Intent(getApplicationContext(),PlayerActivity.class)
                        .putExtra("songs", mySongs)
                        .putExtra("songname",songName)
                        .putExtra("pos",i));
            }
        });
    }

    class customAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View myView = getLayoutInflater().inflate(R.layout.list_internal, null);
            TextView textsong = myView.findViewById(R.id.txtsongname);
            textsong.setSelected(true);
            textsong.setText(items[i]);

            return myView;
        }




    }







}
