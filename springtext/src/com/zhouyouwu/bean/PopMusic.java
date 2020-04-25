package com.zhouyouwu.bean;

import com.zhouyouwu.interfaces.CompactDisc;
import org.springframework.stereotype.Component;

@Component
public class PopMusic implements CompactDisc {
    private String title = "加冕为王";
    private String artist = "排骨教主";
    private String lyric = "轻吟一曲归来 共饮一壶清茶\n" +
                            "穿越一片火海 谁同我争天下\n" +
                            "三千世界太大 何惧刹那芳华";
    @Override
    public void play() {
        System.out.println(title + "\n" + artist + "\n" + lyric);
    }
}
