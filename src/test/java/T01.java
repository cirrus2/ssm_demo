import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cyh.my.web.HttpRequest;
import org.junit.Test;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T01
{
    @Test
    public void t1() {

        String str = HttpRequest.sendGet("http://dyn.ithome.com/jsonp/news/wappage", "page=2");
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
        while (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println();
            linkList.put(m.group(2).substring(3), m.group(1).substring(3, m.group(1).length() - 2));
        }
        System.out.println(linkList);
    }
}

