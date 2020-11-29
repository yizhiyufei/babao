package com.babao.common.utils.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : RichTextUtil
 * @Author : Administrator
 * @Date: 2020/11/27 22:14
 * @Description : 富文本转义
 */
public class RichTextUtil {

    /**
     * 富文本解析转
     * @param html 富文本
     * @param tag 标签
     * @return 列表
     */
    public static List<String> text(String html,String tag){
        //解析html
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select(tag);
        List<String> texts = new LinkedList<>();
        for(Element e : elements){
            texts.add(e.text());
        }
        return texts;
    }
}
