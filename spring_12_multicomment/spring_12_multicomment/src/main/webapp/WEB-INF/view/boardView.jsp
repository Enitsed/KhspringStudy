<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		
		<style type="text/css">
			.modifyShow {
				display: block;
				position: absolute;
				/* top: 150px; */
				left: 200px;
				width: 400px;
				height: 150px;
				z-index: 1000;
				border: 1px solid black;
				background-color: yellow;
				text-align: center;
			}
			
			.modifyHide {
				visibility:hidden;
				width:0px; 
				height:0px;	
			}
			
			.fileDrop {
				width : 500px;
				height : 100px;
				border : 1px dotted blue;
				overflow : auto;
			}
			
			ul.fileDrop li, p{
			 margin:0px;
			}
		</style>
		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.js"></script>
		
		<script type="text/javascript">		
			var urno = '';
			var fileList = [];
		
			$(document).ready(function() {				
				$('#modifyModal').addClass('modifyHide');
				//선택자에 class속성을 넣는다.
				
				$('#replyAddBtn').on('click', reply_list);
				//댓글 추가하기 위한 이벤트
				
				$(document).on('click', '.timeline button', reply_update_delete);
				//댓글 수정,삭제 버튼에 click이벤트 연결
				
				//모달창에 닫기버튼
				$('#btnClose').on('click', function() {					
					$('#updateReplyText').val('');
					$('#modifyModal').removeClass('modifyShow');
					$('#modifyModal').addClass('modifyHide');
					$(document).on('click','.timeline button',reply_update_delete);
					urno = '';					
				})
				
				//모달창에 수정버튼
				$('#btnModify').on('click', reply_update_send);
				
				//내PC 첨부파일 시작////////////////////
				//var filecount = 0;
				var userfile = '';
				$('#userpc').on('click', function() {
					userfile = $('<input type="file" />');
					userfile.click();
					userfile.change(function() {						
						console.log($(userfile[0]).val());
						var partname = $(userfile[0]).val().substring($(userfile[0]).val().lastIndexOf("\\")+1);
						console.log(partname);
						var str = '<p><input type="checkbox" />' + partname + '</p>';
					//	$('.fileDrop').empty(); //초기화
						$('.fileDrop').append(str);						
						//fileList = fileList + userfile[0].files[0];
						fileList.push(userfile[0].files[0]);
						//console.log(fileList);
					});
				});
				//내PC 첨부파일끝///////////////////////
				
				//첨부파일 드래그 시작///////////////
				var obj = $('.fileDrop');
				var win=$('body');
				win.on('dragover', function(e) {
					//dragover, dragenter은 되지만 drop이 안되므로 preventDefault() 메소드를 호출한다.
					e.preventDefault();
					$(this).css('border', '2px solid #0B85A1');
				});
				
				win.on('drop', function(e) {
					e.preventDefault();
				//	$(obj).empty();
					var files = e.originalEvent.dataTransfer.files;
					for(i=0; i<files.length;i++){
					obj.append('<p><input type="checkbox" />' + files[i].name + '</p>');
					fileList.push(files[i]);
					}
					console.log(fileList);
				});				
				//첨부파일 드래그 끝///////////////
				
				
				//첨부파일 삭제 시작////
				$(document).on('click','.fileDrop input' ,function(){
					//alert($(this)[0].nodeName);
					if($(this).prop('checked')){
						fileList.pop($(this).index());
						$(this).parent().remove();
					}
				});
				//첨부파일 삭제 끝///////////////////
				
			});//end readly()////////////////////////////
			
			function reply_update_send() {
				
				if ($('#updateReplyText').val() == '') {
					alert('Modify text를 작성하세요.');
					return false;
				}
				
				$.ajax({
					type 		: 'GET', 
					dataType 	: 'json', 
					url 		: 'replyUpdateList.do?bno=${boardDTO.bno}&replytext=' + $("#updateReplyText").val() + '&rno=' + urno,
					success 	: reply_list_result 
				});
				
				 $('#updateReplyText').val('');
				 // $('#modifyModal').removeClass('modifyShow');
				 // $('#modifyModal').addClass('modifyHide');
				$('#modifyModal').removeClass('modifyShow').addClass('modifyHide');
				$(document).on('click','.timeline button',reply_update_delete); 
				urno='';
				
			}//end end reply_update_send()///////////////////////////////
			
			function reply_update_delete() {
				if ($(this).text() == 'delete') {
					var drno = $(this).prop("id");
					//delete버튼의 id값 변수선언
					
					$.ajax({
						type 		: 'GET', 
						dataType 	: 'json', 
						url 		: 'replyDelete.do?bno=${boardDTO.bno}&rno=' + drno, 
						success 	: reply_list_result 
					});
				} else if ($(this).text() == 'update') {
					 urno=$(this).prop("id");
					 var stop=$(window).scrollTop();		
					 $('#modifyModal').css('top',50+stop);
					 $('#modifyModal').removeClass('modifyHide');
					 $('#modifyModal').addClass('modifyShow');
					 // $('#modifyModal').removeClass('modifyHide').addClass('modifyShow');
									
					$(document).off('click','.timeline button');
				}				
			}//end reply_update_delete()///////////////
			
			
			function reply_list() {
				if ($('#newReplyWriter').val() == '') {
					alert('Writer를 작성하세요.');
					return false;
				}
				
				if ($('#newReplyText').val() == '') {
					alert('Reply text를 작성하세요.');
					return false;
				}
				
				//첨부파일을 보낼때는 이렇게
				var form_data = new FormData();
				form_data.append('bno', '${boardDTO.bno}');
				form_data.append('replyer', $("#newReplyWriter").val());
				form_data.append('replytext', $("#newReplyText").val());
				
//				console.log('filename', $('#filename')[0].files[0]);
//				if($('#filename')[0].files[0] != undefined) {
//					form_data.append('filename', $('#filename')[0].files[0]);
//				}

// 				if (fileList != '') {
// 					form_data.append('filename', fileList);
// 				}
				
//				다중첨부파일
				if(fileList){
					for(var index in fileList){
						form_data.append('filename', fileList[index]);
					}
				}
				
				$.ajax({
					// 첨부파일이 있을때는 data, contentType, enctype, processData가 이런 폼으로 있어야한다.
					type 		: 'POST', 
					dataType 	: 'json', 
					url 		: 'replyInsertList.do', 
					data 		: form_data, 
					contentType : false, 
					enctype 	: 'multipart/form-data', 
					processData : false, 
					success 	: reply_list_result 
					
				});
				
				fileList = [];
				
			}
			
			Handlebars.registerHelper("newDate", function(timeValue) {
														//timeValue : 받아온 regdate의 변수명
				var sdate = new Date(timeValue);
				var year = sdate.getFullYear();
				var month = sdate.getMonth() + 1;
				var date = sdate.getDate();
				
				return year + "/" + month + "/" + date;
			});
			
			/* Handlebars.registerHelper('newUpload', function(uploadFile) {
				if (uploadFile != null) {
					return uploadFile.substring(uploadFile.indexOf('_') + 1);
				} else {
					return uploadFile;
				}
			}); */
			
			function reply_list_result (res) {
				
				$('.timeline .time_sub').remove();
				$('#replycntSmall').text('[' + res.length + ']');
				$.each(res, function(index, value) {
					
					/* var sdate = new Date(value.regdate);
					var sm = sdate.getFullYear() + "/";
					sm = sm + (sdate.getMonth() + 1) + "/";
					sm = sm + sdate.getDate(); */
					
					/* $('.timeline').append(   '<li class="time_sub" id="' + value.rno + '">'
											+		'<p>' + value.replyer + '</p>'
							      			+		'<p>' + value.replytext + '</p>'
							      			+		'<p>' + sm + '</p>'
							      			+		'<p>'
							      			+			'<button id = "' + value.rno + '">delete</button>'
							      			+			'<button id = "' + value.rno + '">update</button>'
							      			+		'</p>'
					      					+	'</li>'
												); */
												
												
					//handlebarsjs
					var source 	= 	'<li class="time_sub" id="{{rno}}">'
								+		'<p>{{replyer}}</p>'
								+		'<p id="{{rno}}text">{{replytext}}</p>'
								+		'<p>{{newDate regdate}}</p>';
					
					//수정삭제되었을때 파일이름이 여러개인 스트링을 나눠줌
					if (value.rupload != null) {
						if (value.rupload.includes(',')) {
							var split = value.rupload.split(',');
							for (var index in split) {
					source +=			'<p>' + split[index].substring(split[index].indexOf('_') + 1) + '</p>';
							}
						} else {
					source +=			'<p>' + value.rupload.substring(value.rupload.indexOf('_') + 1) + '</p>';
						}
					}			
								
					source +=			'<p>'
								+			'<button id="{{rno}}">delete</button>'
								+			' <button id="{{rno}}">update</button>'
											//HTML영역에서는 엔터를 공백으로 인식함
								+		'</p>'
								+	'</li>';
					var template = Handlebars.compile(source);
					$('.timeline').append(template(value));
					
				});
				
				$("#newReplyWriter").val('');
				$("#newReplyText").val('');
				$('.fileDrop').empty();
				
			}
		
		</script>
		
	</head>
	
	<body>
		
		<div class = "wrap">
			<!-- class="box-body" 시작 -->
		      <div class="box-body">
		          <div class="form-group">
		            <label>Title</label> 
		            <input type="text"   name='title' class="form-control" value="${boardDTO.title}" readonly="readonly">
		         </div>
		         <div class="form-group">
		            <label>Content</label>
		            <textarea class="form-control" name="content" rows="3"
		               readonly="readonly">${boardDTO.content}
		            </textarea>
		         </div>
		         <div class="form-group">
		            <label>Writer</label>
		            <input type="text" name="writer" class="form-control" value="${boardDTO.writer}" readonly="readonly">
		         </div>
		      </div>
      <!-- class="box-body" 끝 -->
      
      			<hr/>
      			<!-- 댓글 리스트 출력 시작 -->
      			
      			<ul class = "timeline">
      				<li class = "time-label" id = "repliesDiv">
      					<span class = "bg-green">
							Replies List
							<small id = "replycntSmall">
								[ ${fn:length(boardDTO.replyList)} ]
							</small>
      					</span>
      				</li>
      				
      					<hr/>
						<!-- box box-success 시작 -->
					  <div class="box box-success">
					   <div class="box-header">
						 <h3 class="box-title">ADD NEW REPLY</h3>
					   </div>
					   
					   <div class="box-body">
						 <label for="newReplyWriter">Writer</label> 
						 <input	class="form-control" type="text" 
						        placeholder="USER ID" id="newReplyWriter">
					     <label for="newReplyText">Reply	Text</label> 
					     <input class="form-control" type="text"
							   placeholder="REPLY TEXT" id="newReplyText">
					<!-- 	<label for = "filename">Upload</label>
						<input type = "file" id = "filename" name = "filename" /> -->
						
							<div>
								<span id = "userpc" style = "cursor:pointer">내PC</span>
							</div>
							<div class ="fileDrop">
								
							</div>
					   </div>
						
						<div class="box-footer">
						 <button type="button" class="btn btn-primary" 
								 id="replyAddBtn">ADD REPLY</button>
						</div>		
					  </div>
					  <!-- box box-success 끝 -->
	  
      				
      				<c:forEach items="${boardDTO.replyList }" var="replyDTO">
      					<li class = "time_sub" id = "${replyDTO.rno }">
	      					<p>${replyDTO.replyer }</p>
	      					<p id="${replyDTO.rno }text">${replyDTO.replytext }</p>
	      					<p><fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short" value="${replyDTO.regdate }" /></p>
	      					
	      					<%-- <c:if test="${replyDTO.rupload != null }">
	      						<p>
	      							<c:set var = "numload" value = "${fn:indexOf(replyDTO.rupload, '_')+1 }" />
	      							<c:set var = "strlength" value = "${fn:length(replyDTO.rupload) }" />
	      							${fn:substring(replyDTO.rupload, numload, strlength) }
	      						</p>
	      					</c:if> --%>
	      					
	      					<c:if test="${!empty replyDTO.rupload}">
	      						<c:choose>
		      						<c:when test="${fn:contains(replyDTO.rupload, ',') }">
		      							<c:forEach items="${fn:split(replyDTO.rupload, ',') }" var="ruploads">
			      							<p>${fn:substring(ruploads , 37, fn:length(ruploads))}</p>
		      							</c:forEach>
		      						</c:when>
		      						<c:otherwise>
		      							<p>${fn:substring(replyDTO.rupload , 37, fn:length(replyDTO.rupload))}</p>
		      						</c:otherwise>
	      						
	      						</c:choose>
	      					</c:if>
							<p>
								<button id = "${replyDTO.rno }">delete</button>
								<button id = "${replyDTO.rno }">update</button>
							</p>
      					</li>
      				</c:forEach>
      				
      			</ul>
      			
      			<!-- 댓글 리스트 출력 끝 -->
      			
		</div>
		
			<!-- Modal -->
		<div id="modifyModal">			
			<p>
				<label for="updateReplyText">Reply Text</label> 
				<input class="form-control" type="text" 
				       placeholder="REPLY TEXT"
					   id="updateReplyText">
			</p>
			<p>			    
				<button id="btnModify">Modify</button>
				<button id="btnClose">Close</button>
			</p>
		</div>	
		
	</body>
	
</html>