import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-09-30
 **/
public class JustTestMain {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return Math.abs((ax1 - ax2) * (ay1 - ay2)) + Math.abs((bx1 - bx2) * (by1 - by2)) - (Math.max(0, ax1 - bx1) * Math.max(0, by1 - by2));
    }

    public static void main(String[] args) {
        JSONArray jsonArray = JSONObject.parseArray("[\"你好\",\"我很好\"]");
        List<String> comment = JSONObject.parseArray("[\"你好\",\"我很好\",\"\",\"  \"]",String.class);
        comment = comment.stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());
        System.out.println(comment);
    }
}

