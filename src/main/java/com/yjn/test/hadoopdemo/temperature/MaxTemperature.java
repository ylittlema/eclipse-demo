package com.yjn.test.hadoopdemo.temperature;

// cc MaxTemperature Application to find the maximum temperature in the weather dataset
// vv MaxTemperature
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MaxTemperature {

	public static void main(String[] args) throws Exception {
		System.out.println("计算开始~~~");
		/*
		 * if (args.length != 2) { System.err.println(
		 * "Usage: MaxTemperature <input path> <output path>"); System.exit(-1);
		 * }
		 */

		Job job = new Job();
		job.setJarByClass(MaxTemperature.class);
		job.setJobName("Max temperature");

		FileInputFormat.addInputPath(job, new Path("/input"));
		FileOutputFormat.setOutputPath(job, new Path("/onput"));

		job.setMapperClass(MaxTemperatureMapper.class);
		job.setReducerClass(MaxTemperatureReducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		job.setNumReduceTasks(2);
		
		
		
		

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
// ^^ MaxTemperature
