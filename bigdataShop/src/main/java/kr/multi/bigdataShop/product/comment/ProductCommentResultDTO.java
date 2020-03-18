package kr.multi.bigdataShop.product.comment;

public class ProductCommentResultDTO {
	public String year;
	public String month;
	public String word;
	public String count;
	public ProductCommentResultDTO() {
		
	}
	public ProductCommentResultDTO(String year, String month, String word, String count) {
		super();
		this.year = year;
		this.month = month;
		this.word = word;
		this.count = count;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	
}
