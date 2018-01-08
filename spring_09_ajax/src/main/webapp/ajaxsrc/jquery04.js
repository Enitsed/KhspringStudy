$(document).ready(function() {
	$('#btn').click(function() {
		$.ajax({
			type : 'GET',
			dataType : 'json',
			url : 'searchOpen.do?search=' + $('#search').val(),
			success : viewMessage,
			error : function(xhr, textStatus, error) {
				alert(xhr.status);
			}
		});
	});
});

function viewMessage(res) {
	$('#wrap').empty();
	$('#wrap')
			.append(
					'<table><tr><th>title</th><th>image</th><th>author</th><th>price</th></tr>');
	$.each(res.documents, function(index, value) {
		$('#wrap table').append(
				"<tr><td>" + value.title + "</td><td><a href='" + value.url
						+ "' ><img src='" + value.thumbnail + "'></a></td><td>"
						+ value.authors + "</td><td>" + value.price
						+ "</td></tr>")
	});

	$('#search').focus();
}