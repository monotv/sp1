(function($){
	$(document).ready(function(e){
		$('body').addClass('js-enabled');
		// start()
		try {
			Typekit.load({
				active: function() {
					// Javascript to execute when fonts become active
					$('body').addClass('din');
					init();
					if (typeof initStart == 'function') {
						initStart();
					}
				}
			});
		} catch(e) {
			console.log(e);
		}		 		
	});
	var ffTimer = false;
	var ffRetries = 0;
	function start() {
		var ff = $('#wrapper').css('font-family');
		if(ff.indexOf('din-zanox-web-pro-1')!=-1 || ffRetries == 100) {
			if(ff.indexOf('din-zanox-web-pro-1')!=-1) {
				$('body').addClass('din');
			}
			init();
			if (typeof initStart == 'function') {
				initStart();
			}
			if (ffTimer) {
				clearTimeout(ffTimer)
			};
		} else {
			ffTimer = setTimeout('start()',1);
			ffRetries++;
		}
	} 	
}(jQuery));

//javascript:(function(){var%20u='http://www.paidonresults.com/deepLinkGenerator?security_id=DHDsEsvBmB&loader=1&url='+escape(location);var%20scriptElement=document.createElement('script');scriptElement.type='text/javascript';scriptElement.src=u;var%20head=document.getElementsByTagName('head')[0];if%20(!head){var%20head=document.getElementsByTagName('body')[0];}if(head){head.appendChild(scriptElement);}else{window.location=u+'&fullpage=1';}}())
