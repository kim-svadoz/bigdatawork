package mapreduce.product;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

public class MyKey implements WritableComparable<MyKey>{
	private String productID;
	private String userID;
	public MyKey() {
		
	}
	
	public MyKey(String productID, String userID) {
		super();
		this.productID = productID;
		this.userID = userID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String toString() {
		return productID+"\t"+userID+"\t";
	}
	
	@Override
	public void write(DataOutput out) throws IOException {
		WritableUtils.writeString(out, productID);
		WritableUtils.writeString(out, userID);
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		productID = WritableUtils.readString(in);
		userID = WritableUtils.readString(in);
	}
	@Override
	public int compareTo(MyKey obj) {
		int result = productID.compareTo(obj.productID);
		if(result==0) {
			result = userID.compareTo(obj.userID);
		}
		return result;
	}
}
