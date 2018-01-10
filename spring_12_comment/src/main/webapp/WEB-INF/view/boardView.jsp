<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.modifyShow {
	display: block;
	position: absolute;
	top: 150px;
	left: 200px;
	width: 400px;
	height: 150px;
	z-index: 1000;
	border: 1px solid black;
	background-color: yellow;
	text-align: center;
}

.modifyHide {
	visibility: hidden;
	width: 0px;
	height: 0px;
}
</style>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		//수정 모달 숨기기
		$('#modifyModal').addClass('modifyHide');
		$('#replyAddBtn').on('click', reply_list);

		//댓글 수정, 삭제 버튼에 click이벤트 연결
		$(document).on('click', '.timeline button', reply_update_delete);
	});/////////////////end readly()////////////////

	function reply_update_delete() {
		if ($(this).text() == 'delete') {
			var drno = $(this).prop("id");
			$.ajax({
				type : 'GET',
				dataType : 'json',
				url : 'replyDelete.do?bno=${boardDTO.bno}&rno=' + drno,
				success : reply_list_result
			});
		} else if ($(this).text() == 'update') {
			alert('update')
		}
	}

	function reply_list() {
		if ($('#newReplyWriter').val() == '') {
			alert('writer을 작성하세요');
			return false;
		}

		if ($('#newReplyText').val() == '') {
			alert('Reply text를 작성하세요.');
			return false;
		}

		$.ajax({
			type : 'POST',
			dataType : 'json',
			url : 'replyInsertList.do',
			data : "bno=${boardDTO.bno}&replyer=" + $('#newReplyWriter').val()
					+ "&replytext=" + $('#newReplyText').val(),
			success : reply_list_result
		});

	}//end reply_list()/////////////////////////////

	Handlebars.registerHelper("newDate", function(timeValue) {
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();

		return year + "/" + month + "/" + date;
	})

	function reply_list_result(res) {
		//console.log(res);
		$('.timeline .time_sub').remove();
		$('#replycntSmall').text('[' + res.length + ']');
		$.each(res, function(index, value) {
			/* $('.timeline').append('<li class="time_sub" id="'+value.rno+'"><p>'+value.replyer+'</p><p>'+value.replytext+'</p><p>'+new Date(value.regdate)+'</p><p><button id="'+value.rno+'">delete</button><button id="'+value.rno+'">update</button></p></li>'); */
			var source = "<li class='time_sub' id='{{rno}}'>"
					+ "<p>{{replyer}}</p>" + "<p>{{replytext}}</p>"
					+ "<p>{{newDate regdate}}</p>"
					+ "<p><button id='{{rno}}'>delete</button> "
					+ "<button id='{{rno}}'>update</button></p></li>";
			var template = Handlebars.compile(source);
			$('.timeline').append(template(value));
		});
	}//end reply_list_result()
</script>

</head>
<body>
	<div class="wrap">
		<!-- class="box-body" 시작 -->
		<div class="box-body">
			<div class="form-group">
				<label>Title</label> <input type="text" name='title'
					class="form-control" value="${boardDTO.title}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>Content</label>
				<textarea class="form-control" name="content" rows="3"
					readonly="readonly">${boardDTO.content}</textarea>
			</div>
			<div class="form-group">
				<label>Writer</label> <input type="text" name="writer"
					class="form-control" value="${boardDTO.writer}" readonly="readonly">
			</div>
		</div>
		<!-- class="box-body" 끝 -->

		<!--class="box-footer" 시작  -->
		<div class="box-footer">
			<button type="submit" class="btn btn-warning" id="modifyBtn">Modify</button>
			<button type="submit" class="btn btn-danger" id="removeBtn">REMOVE</button>
			<button type="submit" class="btn btn-primary" id="goListBtn">GO
				LIST</button>
		</div>
		<!-- class="box-footer" 끝 -->

		<hr />
		<!-- box box-success 시작 -->
		<div class="box box-success">
			<div class="box-header">
				<h3 class="box-title">ADD NEW REPLY</h3>
			</div>

			<div class="box-body">
				<label for="newReplyWriter">Writer</label> <input
					class="form-control" type="text" placeholder="USER ID"
					id="newReplyWriter"> <label for="newReplyText">Reply
					Text</label> <input class="form-control" type="text"
					placeholder="REPLY TEXT" id="newReplyText">
			</div>

			<div class="box-footer">
				<button type="button" class="btn btn-primary" id="replyAddBtn">ADD
					REPLY</button>
			</div>
		</div>
		<!-- box box-success 끝 -->

		<hr />
		<ul class="timeline">
			<li class="time-label" id="repliesDiv"><span class="bg-green">Replies
					List <small id='replycntSmall'> [
						${fn:length(boardDTO.replyList)} ] </small>
			</span></li>

			<c:forEach items="${boardDTO.replyList}" var="replyDTO">
				<li class="time_sub" id="${replyDTO.rno}">
					<p>${replyDTO.replyer}</p>
					<p>${replyDTO.replytext}</p>
					<p>
						<fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short"
							value="${replyDTO.regdate}" />
					</p>
					<p>
						<button id="${replyDTO.rno}">delete</button>
						<button id="${replyDTO.rno}">update</button>
					</p>
				</li>
			</c:forEach>
		</ul>
	</div>

	<!-- Model -->
	<!-- Modal -->
	<div id="modifyModal">
		<p>
			<label for="updateReplyText">Reply Text</label> <input
				class="form-control" type="text" placeholder="REPLY TEXT"
				id="updateReplyText">
		</p>
		<p>
			<button id="btnModify">Modify</button>
			<button id="btnClose">Close</button>
		</p>
	</div>
</body>
</html>









