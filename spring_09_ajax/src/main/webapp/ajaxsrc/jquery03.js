$(document).ready(function() {
	$('#btn').click(function() {
		$.ajax({
			type : 'GET',
			dataType : 'json',
			url : 'process.do?data=' + $('#data').val(),
			success : viewMessage
		});
	});
});

/*
 * 실행순서가 Java ==> JSTL ==> HTML ==> Javascript 라고 하기때문에 스크립트 변수를 jstl에다 사용할 수
 * 없다. 반대로 jstl값을 스크립트에서는 사용할 수 있다.
 */

function viewMessage(res) {
	// 자식요소 삭제
	// $('#wrap').children().remove();
	$('#wrap').empty();

	$('#wrap')
			.append(
					'<table><tr><th>first_name</th><th>email</th><th>hire_date</th><th>salary</th></tr>');

	$.each(res, function(index, value) {
		// console.log(value.first_name);
		var sdate = new Date(value.hire_date);
		var sm = sdate.getFullYear() + "-";
		sm += (sdate.getMonth() + 1) + "-";
		sm += sdate.getDate();

		$('#wrap table').append(
				'<tr><td>' + value.first_name + '</td><td>' + value.email
						+ '</td><td>' + sm + '</td><td>' + value.salary
						+ '</td></tr>');

		$('#data').val('');
		$('#data').focus();

	});
} // end view Message()
