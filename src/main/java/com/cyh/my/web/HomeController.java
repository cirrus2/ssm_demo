package com.cyh.my.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {
    @RequestMapping("/")
    public ModelAndView index(Model model) {

        Map<String, Object> linkList = getPage(2);

        model.addAttribute("title", "首页");
        model.addAttribute("list", linkList);
        return new ModelAndView("my/index");
    }

    @RequestMapping(value = "/more", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String more(@RequestParam("page") int page) {
        System.out.println(page);
        Map<String, Object> linkList = getPage(page);
        LinkedList<Object> newList = new LinkedList<>();
        Iterator<Map.Entry<String, Object>> iterator = linkList.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            HashMap<String, Object> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("title", next.getKey());
            stringStringHashMap.put("link", next.getValue());
            newList.add(stringStringHashMap);
        }
        String s = JSON.toJSONString(newList);
        return s;
    }

    private Map<String, Object> getPage(int page) {
        String str = HttpRequest.sendGet("http://dyn.ithome.com/jsonp/news/wappage", "page=" + page);
        System.out.println(str);

        str = str.substring(8, str.length() - 2);
        JSONObject jsonObject = JSON.parseObject(str);
        str = jsonObject.toString();

        // 按指定模式在字符串查找
        String pattern = "<li>.+?href(.+?)>.+?title(.+?)<.+?</li>";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(str);
        HashMap<String, Object> linkList = new HashMap<>();
        while (m.find()) {
            String title = m.group(2).substring(3).trim();
            String link = m.group(1).substring(3, m.group(1).length() - 2);
            if (title.length() == 0 || link.indexOf("http") == 0) {
                continue;
            }
            linkList.put(title, link);
        }
        return linkList;
    }

    @RequestMapping("/detail")
    public ModelAndView detail(@RequestParam("url") String url, Model model) {
        if (url.indexOf("http") == 0) {
            return new ModelAndView("redirect:/");
        }

        String str = HttpRequest.sendGet("https://m.ithome.com" + url, "");
        String patten = "<title>(.+?)</title>.+?news-content(.+?)news-footer";
        Pattern compile = Pattern.compile(patten);
        Matcher matcher = compile.matcher(str);

        String title = "";
        String content = "";
        if (matcher.find()) {
            title = matcher.group(1);
            content = matcher.group(2);
            content = content.substring(2, content.length() - 26);
            content = content.trim();
        }

        System.out.println(title + content);
        model.addAttribute("title", title);
        model.addAttribute("content", content);
        return new ModelAndView("my/detail");
    }
}
