package mapreduce.basic;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.xml.transform.OutputKeys;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper 
	extends Mapper<LongWritable, Text, Text, IntWritable>{
	static final IntWritable outputVal = new IntWritable(1);
	Text outputKey = new Text();
	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		StringTokenizer st = new StringTokenizer(value.toString(), " ");
		while(st.hasMoreTokens()) { //token : read , a, book 이것들이 존재하면 계속 돌리겟다. 분린된게 token
			String token = st.nextToken();
			outputKey.set(token); //output데이터의 키를 셋팅
			context.write(outputKey, outputVal);
		}
	}
}
