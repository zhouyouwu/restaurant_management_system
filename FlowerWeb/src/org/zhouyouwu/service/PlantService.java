package org.zhouyouwu.service;

import org.zhouyouwu.base.BaseInfo;
import org.zhouyouwu.util.Base64Util;
import org.zhouyouwu.util.FileUtil;
import org.zhouyouwu.util.HttpUtil;

import java.net.URLEncoder;

public class PlantService {
    private static String uri = BaseInfo.uri + "/image.jpg";

    public static String plant(){
        String json = "";
        try {
            //把图片变为编码
            byte[] byteImage = FileUtil.readFileByBytes(uri);
            //把编码变成url字符串
            String stringImage = Base64Util.encode(byteImage);
            stringImage = URLEncoder.encode(stringImage, "utf-8");
            System.out.println(stringImage);
            String param = "image=" + stringImage + "&baike_num=1";

            String token = AuthService.getToken();

            json = HttpUtil.post(BaseInfo.plant, token, param);

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }
}
