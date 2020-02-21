package mapred.exam.air.multiple;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AirMultipleMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	static final IntWritable outputVal = new IntWritable(1);
	Text outputKey = new Text();

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if (key.get() > 0) {
			String[] line = value.toString().split(",");
			if (line != null & line.length > 0) {

				if (line[15].equals("NA")) {
					outputKey.set("depNA," + line[1]);
					context.write(outputKey, outputVal);
				} else {
					int Depresult = Integer.parseInt(line[15]); // 15-출발지연
					if(Depresult>0) {
					outputKey.set("dep," + line[1]);
					context.write(outputKey, outputVal);}
				}

				if (line[14].equals("NA")) {
					outputKey.set("arrNA," + line[1]);
					context.write(outputKey, outputVal);
				} else{
					int Arrresult = Integer.parseInt(line[14]); // 14-도착지연
					if(Arrresult>0) {
					outputKey.set("arr," + line[1]);
					context.write(outputKey, outputVal);}
				}

			}
		}
	}
}
