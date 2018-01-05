$(document).ready(function() {
	$('#btn').on('click', process);
})

/*
 * 파라미터 처리 get방식 일 때는 url 속성에서 넘겨주고 post방식 일 때는 data 속성에서 넘겨준다
 */
function process() {
	$.ajax({
		type : 'POST',
		dataType : 'text',
		url : 'loginPro.do',
		data : 'id=' + $('#id').val() + '&pass=' + $('#pass').val(),
		success : function(res) {
			$('div').html(res);
		},
		error : function(err) {
			alert('readyState:' + err.readyState);
			alert('status:' + err.status);
			alert('statusText:' + err.statusText);
			alert('responseText:' + err.responseText);
		}

	});
} // end process
