<%@page import="java.util.List"%>
<%@page import="kr.multi.bigdataShop.product.comment.ProductCommentResultDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="/bigdataShop/jQCloud-master/jqcloud/jqcloud.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript"
	src="/bigdataShop/jQCloud-master/jqcloud/jqcloud-1.0.4.js"></script>
<script type="text/javascript">
	/*!
	 * Create an array of word objects, each representing a word in the cloud
	 */
	if("${commentresult.size()}"!=0){
	var word_array = [ {
		text : "${commentresult.get(0).getWord()}",
		weight : "${commentresult.get(0).getCount()}"
	}, {
		text : "${commentresult.get(1).getWord()}",
		weight : "${commentresult.get(1).getCount()}"
	}, {
		text : "${commentresult.get(2).getWord()}",
		weight : "${commentresult.get(2).getCount()}"
	}, {
		text : "${commentresult.get(3).getWord()}",
		weight : "${commentresult.get(3).getCount()}"
	}, {
		text : "${commentresult.get(4).getWord()}",
		weight : "${commentresult.get(4).getCount()}"
	}, {
		text : "${commentresult.get(5).getWord()}",
		weight : "${commentresult.get(5).getCount()}"
	}, {
		text : "${commentresult.get(6).getWord()}",
		weight : "${commentresult.get(6).getCount()}"
	}, {
		text : "${commentresult.get(7).getWord()}",
		weight : "${commentresult.get(7).getCount()}"
	}, {
		text : "${commentresult.get(8).getWord()}",
		weight : "${commentresult.get(8).getCount()}"
	}, {
		text : "${commentresult.get(9).getWord()}",
		weight : "${commentresult.get(9).getCount()}"
	} ];
	}
	$(function() {
		// When DOM is ready, select the container element and call the jQCloud method, passing the array of words as the first argument.
		$("#example").jQCloud(word_array);
	});
</script>
<script type="text/javascript">
	year = "${year}";
	month = "${month}";
	$(document)
			.ready(
					function() {
						if (year == "") {
							year = "20";
						}
						$("#year").val(year).attr("selected", "selected");
						$("#year")
								.change(
										function() {
											location.href = "/bigdataShop/comment/result.do?year="
													+ encodeURI($(this).val())
													+ "&month=" + month;
										});
						if (month == ""){
							month = "01";
						}
						$("#month").val(month).attr("selected", "selected");
						$("#month")
								.change(
										function() {
											location.href = "/bigdataShop/comment/result.do?year="
													+ year
													+ "&month="
													+ encodeURI($(this).val());
										});

					});
</script>
<title>Insert title here</title>
</head>
<body>
<% List<ProductCommentResultDTO> list = (List<ProductCommentResultDTO>)request.getAttribute("commentresult");%>
	<div class="row">
		<h3>상품댓글분석</h3>

		<br /> <select class="form-control w-50" name="year"
			id="year">
			<option value="19">2019</option>
			<option value="20">2020</option>
			<option value="21">2021</option>
		</select> 
		
		<select class="form-control w-50" name="month"
			id="month">
			<option value="01">01</option>
			<option value="02">02</option>
			<option value="03">03</option>
			<option value="04">04</option>
			<option value="05">05</option>
			<option value="06">06</option>
			<option value="07">07</option>
			<option value="08">08</option>
			<option value="09">09</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
		</select>
		<a class="btn btn-primary" href="/bigdataShop/comment/result.do">전체보기</a>
		<br />
		<hr />
		<div class="col-sm-5">

			<table class="table">
				<tr>
					<th>키워드</th>
					<th>반복횟수</th>
				</tr>
				<% if(list.size()!=0){%>
				<c:forEach varStatus="mystatus" var="commentresult"
					items="${commentresult}">
					<tr>
						<td id="word">${commentresult.word}</td>
						<td id="count">${commentresult.count}</td>
					</tr>
				</c:forEach>
				<%} %>

			</table>
		</div>
		<div class="col-sm-7">
			<div id="example"
				style="width: 550px; height: 350px; border: 1px solid #ccc;">

			</div>

		</div>

	</div>
</body>
</html>