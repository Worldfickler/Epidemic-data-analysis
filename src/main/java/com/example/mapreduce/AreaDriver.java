package com.example.mapreduce;

import com.example.bean.AreaBean;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class AreaDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);

        job.setJarByClass(AreaDriver.class);

        System.out.println("111");
        job.setMapperClass(AreaMapper.class);
        job.setReducerClass(AreaReducer.class);

        System.out.println("222");
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(AreaBean.class);

        System.out.println("333");
        job.setOutputKeyClass(Text.class);
        job.setMapOutputValueClass(AreaBean.class);

        System.out.println("444");
        FileInputFormat.setInputPaths(job, new Path("C:\\Users\\dell\\Desktop\\input"));
        FileOutputFormat.setOutputPath(job, new Path("C:\\Users\\dell\\Desktop\\output"));

        System.out.println("555");
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);

    }

}
