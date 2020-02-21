package mapred.exam.air.multiple;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class AirMultipleReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	IntWritable resultVal = new IntWritable();
	Text resultKey = new Text();
	MultipleOutputs<Text, IntWritable> multiOut;

	@Override
	protected void setup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		multiOut = new MultipleOutputs<Text, IntWritable>(context);
	}
	@Override
	protected void cleanup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		multiOut.close();
	}
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		String[] data = key.toString().split(",");
		resultKey.set(data[1]);
		
		if(data[0].equals("dep")) {
			int sum = 0;
			for(IntWritable value : values) {
				sum += value.get();
			}
			resultVal.set(sum);
			multiOut.write("dep", resultKey, resultVal);
		}else if(data[0].equals("arr")) {
			int sum = 0;
			for(IntWritable value : values) {
				sum += value.get();
			}
			resultVal.set(sum);
			multiOut.write("arr", resultKey, resultVal);
		}else if(data[0].equals("depNA")) {
			int sum = 0;
			for(IntWritable value : values) {
				sum += value.get();
			}
			resultVal.set(sum);
			multiOut.write("depNA", resultKey, resultVal);
		}
		else if(data[0].equals("arrNA")) {
			int sum = 0;
			for(IntWritable value : values) {
				sum += value.get();
			}
			resultVal.set(sum);
			multiOut.write("arrNA", resultKey, resultVal);
		}
	}
}
