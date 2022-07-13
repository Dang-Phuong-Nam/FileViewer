package com.example.fileviewer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && !Environment.isExternalStorageManager()) {
            Uri uri = Uri.parse("package:" + BuildConfig.APPLICATION_ID);
            Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, uri);
            startActivity(intent);
        }

//        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
//
//        Log.d("Files", "Path: " + path);
//
//        try {
//            File directory = new File(path);
//            File[] files = directory.listFiles();
//            Log.d("Files", "Size: " + files.length);
//            for (File file : files) {
//                Log.d("Files", "File name: " + file.getName());
//            }
//            mainView = findViewById(R.id.main_view);
//            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//            mainView.setLayoutManager(layoutManager);
//            mainView.setItemAnimator(new DefaultItemAnimator());
//            List<File> lFiles = new ArrayList<>(Arrays.asList(files));
//            FileAdapter adapter = new FileAdapter(lFiles, getApplicationContext());
//            mainView.setAdapter(adapter);
//            mainView.addItemDecoration(new DividerItemDecoration(mainView.getContext(), DividerItemDecoration.VERTICAL));
//            View decorView = getWindow().getDecorView();
//            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
//            decorView.setSystemUiVisibility(uiOptions);
//        }catch (Exception e) {
//            Log.e("FilesErr", e.getMessage());
//        }
        Intent intent = new Intent(MainActivity.this, FileListActivity.class);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        intent.putExtra("PATH", path);
        startActivity(intent);
    }
}