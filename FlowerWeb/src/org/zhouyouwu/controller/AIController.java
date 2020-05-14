package org.zhouyouwu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zhouyouwu.service.FileService;
import org.zhouyouwu.service.PlantService;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class AIController {

    /**图片文件处理
     * 保存，提交百度云，接收结果
     * @param multipartFile
     * @return
     */
    @ResponseBody
    @RequestMapping("/upFile")
    public String upFile(@RequestParam("imageFile") MultipartFile multipartFile){
        System.out.println("ok");
        FileService fileService = new FileService();
        fileService.saveFile(multipartFile);

        String json = PlantService.plant();

        return json;
    }

}
