package org.zhouyouwu.service;

import org.springframework.web.multipart.MultipartFile;
import org.zhouyouwu.base.BaseInfo;

import java.io.File;
import java.io.IOException;

public class FileService {
    private String uri = BaseInfo.uri;

    /**保存文件
     * 仅保存一个
     * @param multipartFile
     */
    public void saveFile(MultipartFile multipartFile) {
        try {
            File dir = new File(uri);
            if (!dir.exists()) {
                boolean flog = dir.mkdirs();//mkdir创建单层目录,mkdirs才创建多层
            }


            File image = new File(uri + "/image.jpg");
            if (image.exists()) {
                image.delete();
            }
            image.createNewFile();

            multipartFile.transferTo(image);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
