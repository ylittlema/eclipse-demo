package com.yjn.test.hadoopdemo.wc2;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;

public class JobRuner {
	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		conf.set("mapred.job.tracker","192.");
		@SuppressWarnings("deprecation")
		Job job = new Job(conf);
	}
}
