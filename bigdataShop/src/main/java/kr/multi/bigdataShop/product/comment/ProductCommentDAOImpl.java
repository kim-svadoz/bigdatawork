package kr.multi.bigdataShop.product.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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

	@Override
	public List<ProductCommentResultDTO> commentResult(String year, String month) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("year", year);
		map.put("month", month);
		
		return sqlSession.selectList("kr.multi.bigdataShop.product.comment.comresult", map);
	}

	@Override
	public List<ProductCommentResultDTO> commentResult() {
		return sqlSession.selectList("kr.multi.bigdataShop.product.comment.result");
	}

}













