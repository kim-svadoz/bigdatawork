package kr.multi.bigdataShop.product.comment;

import java.util.List;


public interface ProductCommentDAO {
	List<ProductCommentDTO> productcommentlist (String prd_no);
	int productcommentinsert (ProductCommentDTO dto);
	List<ProductCommentResultDTO> commentResult();
	List<ProductCommentResultDTO> commentResult(String year, String month);
}