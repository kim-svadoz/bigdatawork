package kr.multi.bigdataShop.product.comment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.multi.bigdataShop.product.ProductDTO;
@Controller
public class ProductCommentController {
	@Autowired
	ProductCommentService service;
	
	@RequestMapping(value="/comment/write.do")
	public String CommentInsert(ProductCommentDTO dto, HttpServletRequest req) {
		System.out.println(dto);
		service.productcommentinsert(dto);
		return "redirect:/product/read.do?prd_no="+dto.getPrd_no();
	}
	
	@RequestMapping(value="/comment/result.do")
	public ModelAndView commentresult(String year, String month) {
		ModelAndView mav = new ModelAndView();
		List<ProductCommentResultDTO> dto = null;
		if(year==null||month!=null) {
			dto = service.commentResult();
		} else {
			dto = service.commentResult(year,month);
		}
		System.out.println(dto);
		mav.addObject("commentresult", dto);
		mav.setViewName("comment/result");
		return mav;
	}
}









