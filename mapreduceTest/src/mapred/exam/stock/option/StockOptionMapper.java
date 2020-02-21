package mapred.exam.stock.option;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StockOptionMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	String jobType;
	static final IntWritable outputVal = new IntWritable(1);
	Text outputKey = new Text();

	@Override
	protected void setup(Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		jobType = context.getConfiguration().get("jobType");
	}

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if(key.get()>0) {
			String[] line = value.toString().split(",");
			if (line != null & line.length > 0) {
			// 상승마감
				if(jobType.equals("increase")) {
					outputKey.set(line[2].substring(0, 4));
					double result = Double.parseDouble(line[6]) - Double.parseDouble(line[3]);
					if (result > 0) { // 상승마감
						context.write(outputKey, outputVal);
					}
				}
				else if(jobType.equals("decrease")) {
					outputKey.set(line[2].substring(0, 4));
					double result = Double.parseDouble(line[6]) - Double.parseDouble(line[3]);
					if (result < 0) { // 상승마감
						context.write(outputKey, outputVal);
					}
				}
				else if(jobType.equals("same")) {
					outputKey.set(line[2].substring(0, 4));
					double result = Double.parseDouble(line[6]) - Double.parseDouble(line[3]);
					if (result == 0) { // 상승마감
						context.write(outputKey, outputVal);
					}
				}
			}
		}
	}
}
	