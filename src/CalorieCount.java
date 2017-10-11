/**
 * Created by geshuaiqi on 2017/10/11.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  卡路里计算模块
 *  这个模块暂时未写函数，直接main调用。如有需要自行改写
 */
public class CalorieCount {
    static String infor;

    public static void main(String[] args) {
        // 调用命令行，不确定windows可不可以
        String []cmds = {"curl", "-H", "-i", "-F", "media=@./pic/4.jpeg","https://api-2445582032290.production.gw.apicast.io/v1/foodrecognition?"
                + "user_key=7601dc4ce3192d433ba40e7492069677"};
        ProcessBuilder pb=new ProcessBuilder(cmds);
        pb.redirectErrorStream(true);
        Process p;
        try {
            p = pb.start();
            BufferedReader br=null;
            String line=null;

            br=new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((line=br.readLine())!=null){
                infor = line; // 最后一行信息是json对象
            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //System.out.println(infor);
        MyObject v = new MyObject();
        v.calorieCoubt(infor);// 计算卡路里

    }
}