package com.example.mapperReduce.continent_confirmedMR;

import com.example.mapperReduce.continent_deadMR.ContinentDeadDriver;
import com.example.mapperReduce.continent_deadMR.ContinentDeadMapper;
import com.example.mapperReduce.continent_deadMR.ContinentDeadReducer;
import com.example.mapperReduce.continent_deadMR.ContinentDeadWritable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class ContinentConfirmedDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        //获取job
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        //设置jar包路径
        job.setJarByClass(ContinentConfirmedDriver.class);
        //关联mapper和reducer
        job.setMapperClass(ContinentConfirmedMapper.class);
        job.setReducerClass(ContinentConfirmedReducer.class);
        //设置map输出的key，value输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(ContinentConfirmedWritable.class);
        //设置最终输出的key，value类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(ContinentConfirmedWritable.class);
        //设置输入路径和输出路径
        FileInputFormat.setInputPaths(job, new Path("data/country_epidemic.txt"));
        FileOutputFormat.setOutputPath(job, new Path("data/continent_Confirmed_output"));

        FileSystem fs = FileSystem.get(configuration);
        if(fs.exists(new Path("data/country_epidemic.txt"))){
            fs.delete(new Path("data/continent_Confirmed_output"),true);
        }

        //提交job
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }
}
