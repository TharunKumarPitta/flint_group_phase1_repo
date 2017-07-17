ACC.termsandconditions = {

	bindTermsAndConditionsLink: function() {
		$(document).on("click",".termsAndConditionsLink",function(e) {
			e.preventDefault();
			$.colorbox({
				maxWidth:"100%",
				maxHeight:"80%",
				width:"870px",
				scrolling:true,
				href: $(this).attr("href"),
				close:'<span class="glyphicon glyphicon-remove"></span>',
				title:'<div class="headline"><span id="term-condition-header" class="headline-text"> </span></div>',
				onComplete: function() {
					ACC.common.refreshScreenReaderBuffer();
					$('#term-condition-header').text($('#popup-title').val());
				},
				onClosed: function() {
					ACC.common.refreshScreenReaderBuffer();
				}
			});
		});
	}
}

$(function(){
	with(ACC.termsandconditions) {
		bindTermsAndConditionsLink();
	}
});
