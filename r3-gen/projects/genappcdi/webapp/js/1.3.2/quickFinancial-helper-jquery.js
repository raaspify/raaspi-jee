/*
 *  This file contains the JS that handles the first init of each jQuery demonstration, and also switching
 *  between render modes.
 */
jsPlumb.bind("ready", function() {

	// chrome fix.
	document.onselectstart = function () { return false; };				

    // render mode
	var resetRenderMode = function(desiredMode) {
		var newMode = jsPlumb.setRenderMode(desiredMode);
		jQuery(".rmode").removeClass("selected");
		jQuery(".rmode[mode='" + newMode + "']").addClass("selected");
		var disableList = (newMode === jsPlumb.VML) ? ".rmode[mode='canvas'],.rmode[mode='svg']" : ".rmode[mode='vml']"; 
		jQuery(disableList).attr("disabled", true);				
		jsPlumbDemo.init();
	};
     
	jQuery(".rmode").bind("click", function() {
		var desiredMode = jQuery(this).attr("mode");
		if (jsPlumbDemo.reset) jsPlumbDemo.reset();
		jsPlumb.reset();
		resetRenderMode(desiredMode);					
	});

	resetRenderMode(jsPlumb.CANVAS);
       
});