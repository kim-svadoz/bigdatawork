package mapreduce.product;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PageViewMapper extends Mapper<LongWritable, Text, MyKey, IntWritable>{
	static final IntWritable outputVal = new IntWritable(1);
	MyKey outputKey = new MyKey();
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, MyKey, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String[] line = value.toString().split("\t");
		outputKey.setProductID(line[2]);
		outputKey.setUserID(line[9]);
		context.write(outputKey, outputVal);
	}
}
