
import org.json.JSONArray;
import org.json.JSONObject;



/**
 * Created by geshuaiqi on 2017/10/11.
 */
public class MyObject {
    MyObject(){

    }
    /*
     * 该函数用于解析json
     * jsonStr为calorie mama API返回的json
     */
    public void calorieCoubt(String jsonStr){
        JSONObject res = new JSONObject(jsonStr); // 创建jsonobject对象
        JSONArray t; // json数组
        // 这块对照返回的json格式看笔记容易理解
        t=res.getJSONArray("results");

        Translate tanslateModule = new Translate();

        for(int i=0;i<t.length();i++){
           JSONObject o = t.getJSONObject(i);
           JSONArray oo = o.getJSONArray("items");

            for(int j=0;j<oo.length();j++){
                JSONObject q = oo.getJSONObject(j).getJSONObject("nutrition");
                String calory =  q.get("calories").toString();
                String ChineseName = tanslateModule.Translate( oo.getJSONObject(j).get("name").toString());
                System.out.println( ChineseName  + ":" + oo.getJSONObject(j).get("score") +", calorie:"+calory );

            }

        }
    }
}
