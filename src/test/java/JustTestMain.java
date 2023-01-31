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


    String TABLE = " `cms_feed` ";

   private static String COLUMN = " form_id,content,more_text,pic_url,topic_id,topic_name,file_json,cover_json,pic_json,day_like_count,week_like_count,like_count,sensitive_words,audit_status,audit_user_id,audit_user_name,source_symbol,brand_id,job_id,show_symbol_get,show_symbol_brand,show_symbol_profile,disinterest_count,circle_id,is_markdown,is_real,link_type,link_text,link_url,creator_id,creator_identity,creator_name,random_user_id,random_user_name,create_type,is_deleted,old_dynamic_type,is_old_dynamic,weight,weight_to_zero_time,content_type,file_url,file_name,cover_url,book_id,book_name,book_author,book_pic,book_score,admin_id,admin_name,is_high_quality,set_high_quality_time,set_high_quality_user_id,set_high_quality_username,file_id,get_count,content_desc_backup,wiki_id ";

    String ALL_COLUMN =  " id,add_time,update_time, " + COLUMN;




    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return Math.abs((ax1 - ax2) * (ay1 - ay2)) + Math.abs((bx1 - bx2) * (by1 - by2)) - (Math.max(0, ax1 - bx1) * Math.max(0, by1 - by2));
    }

    public static void main(String[] args) {
        JSONArray jsonArray = JSONObject.parseArray("[\"你好\",\"我很好\"]");
        List<String> comment = JSONObject.parseArray("[\"你好\",\"我很好\",\"\",\"  \"]", String.class);
        comment = comment.stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());
        System.out.println(comment);
        double x = 60 / 14400d;
        System.out.println(x);
        System.out.println(x * 600);
        System.out.println((int) (x * (2.5d * 3600 + 600)));
        int like1 = (int) Math.ceil(0.07f * 135) - 1;
        System.out.println(like1);
        System.out.println(Math.round(9.12d));
        System.out.println(Math.round(9.52d));

        String s = "asjdjajuu:eememmemememeu:u:u:u:ee";
        s = s.replace("u:e", "ue");
        s = s.replace("u:", "v");
        System.out.println(s);
        for (String f:COLUMN.split(",")){
            System.out.println(f);
        }
    }
}

