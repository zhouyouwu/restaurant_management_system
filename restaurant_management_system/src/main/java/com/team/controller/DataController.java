package com.team.controller;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value = "/DB")
public class DataController {
    @GetMapping(value = "/backUpData")
    public String backUpData(@Nullable @RequestParam String path, @Nullable @RequestParam String filename){
        if(path == null){
            path = "/usr/local/hudk/appdata/RMS";
        }
        if(filename == null){
            filename = "rms.sql";
        }
        String cmd = "mysqldump -uroot -p12345678 restaurant_management_system > ";
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        File sql = new File(path+"/"+filename);
        if(sql.exists()){
            sql.delete();
        }

        try {
            sql.createNewFile();
            Process process = Runtime.getRuntime().exec(cmd+path+"/"+filename);
            if (process.waitFor() == 0){
                return "{\"message\":\"备份成功\"}";
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return "{\"message\":\"备份失败\"}";
    }

    @GetMapping(value = "/restoreData")
    public String restoreData(@Nullable @RequestParam String path, @Nullable @RequestParam String filename){
        if(path == null){
            path = "/usr/local/hudk/appdata/RMS";
        }
        if(filename == null){
            filename = "rms.sql";
        }
        String cmd = "mysql -uroot -p12345678 restaurant_management_system < ";
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmd+path+"/"+filename);
            if (process.waitFor() == 0){
                return "{\"message\":\"数据恢复成功\"}";
            }
        } catch (InterruptedException | IOException e) {
        e.printStackTrace();
        }
        return "{\"message\":\"数据恢复失败\"}";
    }
}
