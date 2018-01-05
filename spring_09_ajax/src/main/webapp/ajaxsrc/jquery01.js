$(document).ready(function() {
	$('#btn').on('click', process);
});

function process() {
	$.ajax({
		type : 'GET', // 빈 값이면 자동으로 GET이다. POST 일 경우 명시 해줘야함
		url : 'customer.do?name=' + $('#name').val(),
		dataType : 'text', // 기본 데이터 타입은 text 이다. (생략 가능)
		success : function(res) {
			$('div').html(res);
		} // 성공했을 경우 실행할 함수

	// url과 success는 필수 어트리뷰트이기 때문에 무조건 들어가야한다.
	});
} // end process()
