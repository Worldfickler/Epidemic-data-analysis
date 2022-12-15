package com.example.mapperReduce.suspectedMR;

import com.example.mapperReduce.curedMR.CuredDriver;
import com.example.mapperReduce.curedMR.CuredMapper;
import com.example.mapperReduce.curedMR.CuredReducer;
import com.example.mapperReduce.curedMR.CuredWritable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
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
public class SuspectedDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        //获取job
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        //设置jar包路径
        job.setJarByClass(SuspectedDriver.class);
        //关联mapper和reducer
        job.setMapperClass(SuspectedMapper.class);
        job.setReducerClass(SuspectedReducer.class);
        //设置map输出的key，value输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(SuspectedWritable.class);
        //设置最终输出的key，value类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(SuspectedWritable.class);
        //设置输入路径和输出路径
        FileInputFormat.setInputPaths(job, new Path("data/province_epidemic.txt"));
        FileOutputFormat.setOutputPath(job, new Path("data/suspected_output"));

        FileSystem fs = FileSystem.get(configuration);
        if(fs.exists(new Path("data/province_epidemic.txt"))){
            fs.delete(new Path("data/suspected_output"),true);
        }

        //提交job
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);

    }

}
