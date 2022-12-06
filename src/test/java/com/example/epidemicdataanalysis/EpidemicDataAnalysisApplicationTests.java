package com.example.epidemicdataanalysis;

import com.alibaba.fastjson.JSON;
import com.example.bean.EpidemicBean;
import com.example.utils.HdfsUtil;
import com.example.utils.HttpUtils;
import com.example.utils.TimeUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class EpidemicDataAnalysisApplicationTests {

    @Autowired
    private HdfsUtil hdfsUtil;

    private FileSystem fileSystem;

    @Test
    void test1() throws IOException {
        String filename = "/xiyou/test";
        Path path = new Path(filename);
        fileSystem.create(path);
    }

    @Test
    void contextLoads() throws Exception {

        boolean is_mkdir = hdfsUtil.mkdir("/xiyou");
        System.out.println(is_mkdir);

        //时间标志
        String datetime = TimeUtils.format(System.currentTimeMillis(), "yyyy-MM-dd");

        //爬取的页面
        String html = HttpUtils.getHtml("https://ncov.dxy.cn/ncovh5/view/pneumonia");

        //解析页面中的指定内容-即id为getAreaStat的标签中的全国疫情数据
        Document doc = Jsoup.parse(html);
        String text = doc.select("script[id=getAreaStat]").toString();
//        System.out.println(text);

        //使用正则表达式获取json格式的数据
        String pattern = "\\[(.*)\\]";
        Pattern reg = Pattern.compile(pattern);
        Matcher matcher = reg.matcher(text);
        String jsonStr = "";
        if (matcher.find()) {
            jsonStr = matcher.group(0);
//            System.out.println(jsonStr);
        } else {
            System.out.println("NO MATCH");
        }

        //对json数据更进一步的解析
        //将json转换为javabean(省份信息)
        List<EpidemicBean> province_epidemicBeans = JSON.parseArray(jsonStr, EpidemicBean.class);

    }

    @Test
    void test() throws URISyntaxException, IOException, InterruptedException {
        //连接的集群nn地址
        URI uri = new URI("hdfs://192.168.56.104:9000");
        //配置文件
        Configuration configuration = new Configuration();
        //用户
        String user = "niit";
        //获得客户端对象
        FileSystem fileSystem = FileSystem.get(uri, configuration, user);
        //创建一个文件夹
        fileSystem.mkdirs(new Path("/xiyou/huaguoshan"));
        //关闭资源
        fileSystem.close();
    }

}
