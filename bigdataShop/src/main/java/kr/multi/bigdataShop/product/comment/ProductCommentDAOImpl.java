package kr.multi.bigdataShop.product.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.multi.bigdataShop.product.ProductDTO;
@Repository("productcommentdao")
public class ProductCommentDAOImpl implements ProductCommentDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<ProductCommentDTO> productcommentlist(String prd_no) {
		List<ProductCommentDTO> commentList = sqlSession.selectList("kr.multi.bigdataShop.product.comment.commentlist", prd_no);
		return commentList;
		
	}
	
	@Override
	public int productcommentinsert(ProductCommentDTO dto) {
		int result = sqlSession.insert("kr.multi.bigdataShop.product.comment.commentinsert", dto);
		return result;
	}

}













