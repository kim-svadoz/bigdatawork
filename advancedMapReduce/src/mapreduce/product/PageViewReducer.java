package mapreduce.product;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class PageViewReducer extends Reducer<MyKey, IntWritable, MyKey, IntWritable>{
	IntWritable resultVal = new IntWritable();
	MyKey resultKey = new MyKey();
	@Override
	protected void reduce(MyKey key, Iterable<IntWritable> values,
			Reducer<MyKey, IntWritable, MyKey, IntWritable>.Context context) throws IOException, InterruptedException {
		int sumuser = 0;
		int sumhit = 0;
		
		/*
		int sum=0;	// 하나의 상품이 클릭된 총 횟수
		int user_count=0; // 클릭한 사용자의 수
		String beforUser="";
		*/
		
		
		for(IntWritable value:values) {
			String currentUser = value.toString();
			/*
			if(!beforeUser.equals(currentUser)) {
				user_count++;
			}
			sum++;
			beforeUser = currentUser;
			*/ 
			
			sumuser++;
			sumhit += value.get();
		}
		//상품코드가 바뀔때마다 출력
		/*
		resultKey.setProductID(key.getProductID());
		StringBuffer data = new StringBuffer();
		data.append(user_count).append("\t").append(sum);
		resultVal.set(data.toString());
		context.write(resultKey, resultVal);
		*/
		
		resultKey.setProductID(key.getProductID());
		resultKey.setUserID(Integer.toString(sumuser));
		resultVal.set(sumhit);
		context.write(resultKey, resultVal);
	}
}
