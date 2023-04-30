

;(function() {

	window.jsPlumbDemo = {
		init : function() {
			// disable dragging events
			jsPlumb.setDraggableByDefault(false);

			// default drag options
			jsPlumb.Defaults.DragOptions = { cursor: 'pointer', zIndex:2000 };
			// default to blue at one end and green at the other
			jsPlumb.Defaults.EndpointStyles = [{ fillStyle:'#225588' }, { fillStyle:'#558822' }];
			// blue endpoints 7 px; green endpoints 11.
			jsPlumb.Defaults.Endpoints = [ [ "Dot", {radius:7} ], [ "Dot", { radius:11 } ]];
			// enable mouse events
			jsPlumb.setMouseEventsEnabled(true);
			// the overlays to decorate each connection with.  note that the label overlay uses a function to generate the label text; in this
			// case it returns the 'labelText' member that we set on each connection in the 'init' method below.
			jsPlumb.Defaults.Overlays = [
				[ "Arrow", { location:0.9 } ],
				[ "Label", {
					location:0.1,
					label:function(label) {
						return label.connection.labelText || "";
					},
					cssClass:"aLabel"
				}]
			];

			// this is the paint style for the connecting lines..
			var connectorPaintStyle = {
				lineWidth:3,
				strokeStyle:"#deea18",
				joinstyle:"round"
			},
			// .. and this is the hover style.
			connectorHoverStyle = {
				lineWidth:5,
				strokeStyle:"#2e2aF8"
			},
			// the definition of source endpoints (the small blue ones)
			sourceEndpoint = {
				endpoint:"Dot",
				paintStyle:{ fillStyle:"#225588",radius:5 },
				isSource:true,
				connector:[ "Flowchart", { stub:40 } ],
				connectorStyle:connectorPaintStyle,
				hoverPaintStyle:connectorHoverStyle,
				connectorHoverStyle:connectorHoverStyle
			},
			// a source endpoint that sits at BottomCenter
			bottomSource = jsPlumb.extend( { anchor:"BottomCenter" }, sourceEndpoint),
			// a source endpoint that sits at TopCenter
			topSource = jsPlumb.extend( { anchor:"TopCenter" }, sourceEndpoint),

			// the definition of target endpoints (will appear when the user drags a connection)
			targetEndpoint = {
				endpoint:"Dot",
				paintStyle:{ fillStyle:"#558822",radius:9 },
				hoverPaintStyle:connectorHoverStyle,
				maxConnections:-1,
				dropOptions:{ hoverClass:"hover", activeClass:"active" },
				isTarget:true,
				anchor:[ "LeftMiddle", "RightMiddle" ]
			},
			windows = ["window1", "window2", "window3", "window4"],
			init = function(connection) {
                        var sourceTarget=connection.sourceId+connection.targetId;
                        switch (sourceTarget) {
                               case "window4window3":
                                connection.labelText = "  Payment ";
                                break;
                               case "window1window3":
                                connection.labelText = "  Invoice ";
                                break;
                               case "window3window2":
                                connection.labelText = "  Trial Balance ";
                                break;
                               case "window3window4":
                                connection.labelText = "  Invoice ";
                                break;
                               case "window3window1":
                                connection.labelText = "  Payment ";
                                break;
                               case "window2window3":
                                connection.labelText = "  G/L Adjustments ";
                                break;

                               default:
				        connection.labelText = connection.sourceId.substring(6) + " - " + connection.targetId.substring(6);
                                break;

                              }



			};

			//
			// add endpoints to all windows. note here we use a string array; that's just because this demo is framework-agnostic.  you'd
			// probably use a selector in the real world, eg.
			//
			// jsPlumb.addEndpoint($(".window"), [ bottomSource ]);
			//
			var sourceEndpoints = jsPlumb.addEndpoint(windows, bottomSource),
			targetEndpoints = jsPlumb.addEndpoint(windows, targetEndpoint);

			// listen for new connections; initialise them the same way we initialise the connections at startup.
			jsPlumb.bind("jsPlumbConnection", function(connInfo) {
				init(connInfo.connection);
			});

			//
			// make all windows drop targets.  again note the string array vs selector issue.
			//
			/*jsPlumb.makeTarget(windows, {
				endpoint:targetEndpoint,
				dropOptions:{ hoverClass:"hover", activeClass:"active" },
				deleteEndpointsOnDetach:true
			});*/
				// add endpoints to the various elements
				var e11 = jsPlumb.addEndpoint("window1", {anchor:"BottomCenter"}, targetEndpoint);
				var e12 = jsPlumb.addEndpoint("window1", {anchor:"RightMiddle"}, sourceEndpoint);
				var e21 = jsPlumb.addEndpoint("window2", {anchor:"LeftMiddle"}, sourceEndpoint);
				var e22 = jsPlumb.addEndpoint("window2", {anchor:"BottomCenter"}, targetEndpoint);
				var e31 = jsPlumb.addEndpoint("window3", {anchor:"LeftMiddle"}, sourceEndpoint);
				var e32 = jsPlumb.addEndpoint("window3", {anchor:"LeftMiddle"}, targetEndpoint);
				var e33 = jsPlumb.addEndpoint("window3", {anchor:"RightMiddle"}, targetEndpoint);
				var e34 = jsPlumb.addEndpoint("window3", {anchor:"BottomLeft"}, sourceEndpoint);
				var e35 = jsPlumb.addEndpoint("window3", {anchor:"TopLeft"}, sourceEndpoint);
				var e36 = jsPlumb.addEndpoint("window3", {anchor:"BottomRight"}, sourceEndpoint);
				var e37 = jsPlumb.addEndpoint("window3", {anchor:"TopCenter"}, targetEndpoint);
				var e41 = jsPlumb.addEndpoint("window4", {anchor:"RightMiddle"}, sourceEndpoint);
				var e42 = jsPlumb.addEndpoint("window4", {anchor:"BottomCenter"}, targetEndpoint);

			// make a couple of connections. note that the return value of addEndpoints is an array of Endpoints,
				// connect two elements.  calls the init function to register mouse handlers etc.
				var connect = function(s,t) {
					var c = jsPlumb.connect({source:s,target:t, overlays:jsPlumb.Defaults.Overlays});
					if (c) init(c);
				};
				// connect, by Endpoint.
				connect(e34, e11);
				connect(e12, e32);
				connect(e41, e37 );
				connect(e35, e42);
				connect(e21, e33);
				connect(e36, e22);

			//
			// listen for clicks on connections, and offer to delete connections on click.
			//
			jsPlumb.bind("click", function(conn) {

						if (confirm("Go to Menu Option "+conn.labelText + "?")){
                                         if (conn.labelText=="  Payment " &&  conn.targetId=="window3"){
                                          window.location.href=("cpaymentEdit.wflow");
                                         }
                                         if (conn.labelText=="  Payment " &&  conn.sourceId=="window3"){
                                          window.location.href=("vpaymentEdit.wflow");
                                         }
                                         if (conn.labelText=="  Invoice " &&  conn.targetId=="window4"){
                                          window.location.href=("cuinvoiceEdit.wflow");
                                         }
                                         if (conn.labelText=="  Invoice " &&  conn.targetId=="window3"){
                                          window.location.href=("vinvoiceEdit.wflow");
                                         }
                                         if (conn.labelText=="  Trial Balance " &&  conn.sourceId=="window3"){
                                          window.location.href=("Reporttrialbalance.wflow");
                                         }
                                         if (conn.labelText=="  G/L Adjustments " &&  conn.sourceId=="window2"){
                                          window.location.href=("glentriesEdit.wflow");
                                         }
                               }

					});
					jsPlumb.bind("mouseenter", function(conn) { conn.setLabel("click to delete"); });
					jsPlumb.bind("mouseexit", function(conn) { conn.setLabel(""); });
					jsPlumb.repaint();

		}
	};
})();