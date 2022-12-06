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

        //ʱ���־
        String datetime = TimeUtils.format(System.currentTimeMillis(), "yyyy-MM-dd");

        //��ȡ��ҳ��
        String html = HttpUtils.getHtml("https://ncov.dxy.cn/ncovh5/view/pneumonia");

        //����ҳ���е�ָ������-��idΪgetAreaStat�ı�ǩ�е�ȫ����������
        Document doc = Jsoup.parse(html);
        String text = doc.select("script[id=getAreaStat]").toString();
//        System.out.println(text);

        //ʹ��������ʽ��ȡjson��ʽ������
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

        //��json���ݸ���һ���Ľ���
        //��jsonת��Ϊjavabean(ʡ����Ϣ)
        List<EpidemicBean> province_epidemicBeans = JSON.parseArray(jsonStr, EpidemicBean.class);

    }

    @Test
    void test() throws URISyntaxException, IOException, InterruptedException {
        //���ӵļ�Ⱥnn��ַ
        URI uri = new URI("hdfs://192.168.56.104:9000");
        //�����ļ�
        Configuration configuration = new Configuration();
        //�û�
        String user = "niit";
        //��ÿͻ��˶���
        FileSystem fileSystem = FileSystem.get(uri, configuration, user);
        //����һ���ļ���
        fileSystem.mkdirs(new Path("/xiyou/huaguoshan"));
        //�ر���Դ
        fileSystem.close();
    }

}
