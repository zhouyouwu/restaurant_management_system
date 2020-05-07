package org.zhouyouwu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.zhouyouwu.util.HttpUtil;
import org.zhouyouwu.base.BaseInfo;

public class AuthService {
    /**获取token
     * 未来添加短期存储token减少请求次数
     * @return
     */
    public static String getToken() {
        String tokenUrl = BaseInfo.auth_host
                +"grant_type=client_credentials"
                +"&client_id="+BaseInfo.client_id
                +"&client_secret="+BaseInfo.client_secret;
        try {
            String json = "";
            json = HttpUtil.post(tokenUrl, "", "");
            JSONObject jsonObject = JSON.parseObject(json);
            return jsonObject.getString("access_token");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
