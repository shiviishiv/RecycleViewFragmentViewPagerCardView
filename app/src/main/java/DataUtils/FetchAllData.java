package DataUtils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.testingviewpagerrecycleviewfragmentcardview.MainActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import hendrawd.storageutil.library.StorageUtil;

public class FetchAllData {
    public static List<String> imageList  = new ArrayList<>();
    public static List<String> videoList = new ArrayList<>();
    public static List<String> songList = new ArrayList<>();
    public static List<String> pdfList = new ArrayList<>();

    public static List<String> getImageList() {
        return imageList;
    }

    public static List<String> getVideoList() {
        return videoList;
    }

    public static List<String> getSongList() {
        return songList;
    }

    public static List<String> getPdfList() {
        return pdfList;
    }

    MainActivity mainActivity1;
    public static boolean getAllPermission(MainActivity mainActivity){

        MainActivity mainActivity1 = mainActivity;
        if(ContextCompat.checkSelfPermission(mainActivity, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
            String[] externalStoragePaths = StorageUtil.getStorageDirectories(mainActivity);
            for(String string:externalStoragePaths)
                getMyFiles(new File(string));
            return true;
        }
        else ActivityCompat.requestPermissions(mainActivity,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},123);
        return false;
    }

    private static void getMyFiles(File file) {
        if(file.isDirectory()){
            String[] list = file.list();
            for(String string :list)
                getMyFiles(new File(file,string));
        }
        String path = file.getAbsolutePath();
        for(String temp: DataExtension.imageExtension)
            if(path.endsWith(temp))
                imageList.add(path);
        for (String temp: DataExtension.videoExtensions)
            if(path.endsWith(temp))
                videoList.add(path);
        for(String temp: DataExtension.songExtension)
            if(path.endsWith(temp))
                songList.add(temp);
        if(path.endsWith(".pdf"))
            pdfList.add(path);
    }
}
