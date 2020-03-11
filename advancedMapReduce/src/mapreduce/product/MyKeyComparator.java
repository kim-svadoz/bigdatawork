package mapreduce.product;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class MyKeyComparator extends WritableComparator{
	protected MyKeyComparator() {
		super(MyKey.class, true);
	}

	//WritableComparable의 타입이 정확하지 않기 때문에 warning발생
	//타입에 대한 부분을 무시하고 체크하지 않고 처리하겠다는 의미
	@SuppressWarnings("rawtypes")
	@Override
	public int compare(WritableComparable obj1, WritableComparable obj2) {
		MyKey key1 = (MyKey)obj1;
		MyKey key2 = (MyKey)obj2;
		
		return key1.compareTo(key2);
			
	}
}
