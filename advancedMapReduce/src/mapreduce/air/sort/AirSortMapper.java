package mapreduce.air.sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AirSortMapper extends Mapper<LongWritable, Text, CustomKey, IntWritable>{
	static final IntWritable outputVal = new IntWritable(1);
	CustomKey outputKey = new CustomKey();
	
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, CustomKey, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if(key.get()>0) {
			String[] line = value.toString().split(",");
			if(!line[15].equals("NA")) {
			if(line!=null & line.length >0) {
			outputKey.setYear(line[0]);
			outputKey.setMonth(new Integer(line[1]));
			int result = Integer.parseInt(line[15]); 	
				if(result>0) {
					context.write(outputKey, outputVal);
				}
			}
			}
		}
	}
}
