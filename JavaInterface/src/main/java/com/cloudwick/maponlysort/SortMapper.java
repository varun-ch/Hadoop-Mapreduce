package com.cloudwick.maponlysort;
/*
 * this program does map-only sort. it filters those records who salary is greater than 3000
 */
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SortMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		String[] items = value.toString().split("\\t");
		
		if (Integer.parseInt(items[2])>3000){
			context.write(value, null);
		}
		
	}

}
