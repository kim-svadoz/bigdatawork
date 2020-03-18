package kr.multi.bigdataShop.product.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class ProductCommentServiceImpl implements ProductCommentService {
	@Autowired
	@Qualifier("productcommentdao")
	ProductCommentDAO dao;
	@Override
	public List<ProductCommentDTO> productcommentlist(String prd_no) {
		return dao.productcommentlist(prd_no);
	}
	
	@Override
	public int productcommentinsert(ProductCommentDTO dto) {
		return dao.productcommentinsert(dto);
	}
	
	public List<ProductCommentResultDTO> commentResult(String year, String month){
		return dao.commentResult(year, month);
	}

	@Override
	public List<ProductCommentResultDTO> commentResult() {
		return dao.commentResult();
	}
}











