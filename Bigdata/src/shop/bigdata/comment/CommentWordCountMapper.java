package shop.bigdata.comment;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.transform.OutputKeys;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CommentWordCountMapper 
	extends Mapper<LongWritable, Text, Text, IntWritable>{
	static final IntWritable outputVal = new IntWritable(1);
	Text outputKey = new Text();
	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		String line[] = value.toString().split(",");
		String str = line[2];
		String year = line[3].substring(0,2);
		String month = line[3].substring(5,7);
		String patternStr = "[a-z0-9가-힣]+[^은는이가에 ]";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher m = pattern.matcher(str);
		while(m.find()) {
			outputKey.set(year+"\t"+month+"\t"+m.group());
			context.write(outputKey, outputVal);
		}
	}
}
