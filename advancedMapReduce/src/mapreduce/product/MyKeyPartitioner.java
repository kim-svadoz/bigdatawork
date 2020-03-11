package mapreduce.product;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyKeyPartitioner extends Partitioner<MyKey, IntWritable>{

	@Override
	public int getPartition(MyKey key, IntWritable value, int numPartitions) {
		return key.getProductID().hashCode() % numPartitions;
	}
	
//	public int getPartition(MyKey key, Text value, int numPartitions) {
//		return key.getProductID().hashCode() % numPartitions;
//	}

}
