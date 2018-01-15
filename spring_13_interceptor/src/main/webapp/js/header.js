
function init(chk){	
	
	if (chk) {
		console.log('aa');
		$('#logInPage').removeClass('hidePage').addClass('showPage');
		$('#logOutPage').removeClass('showPage').addClass('hidePage');
	} else {
		console.log('bb');
		$('#logInPage').removeClass('showPage').addClass('hidePage');
		$('#logOutPage').removeClass('hidePage').addClass('showPage');
	}

}//end init()