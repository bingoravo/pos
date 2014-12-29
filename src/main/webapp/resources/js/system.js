jQuery(document).ready(function(){
	$('body').layout({
		resizerClass: 'ui-state-default',
        west__onresize: function (pane, $Pane) {
            jQuery("#west-grid").jqGrid('setGridWidth',$Pane.innerWidth()-2);
		}
	});
	$.jgrid.defaults = $.extend($.jgrid.defaults,{loadui:"enable"});
	
	//Logics for Main tabs
	var maintab =jQuery('#tabs','#RightPane').tabs({
        add: function(e, ui) {
            $(ui.tab).parents('li:first')
                .append('<span class="ui-tabs-close ui-icon ui-icon-close" title="Close Tab"></span>')
                .find('span.ui-tabs-close')
				.show()
                .click(function() {
                    maintab.tabs('remove', $('li', maintab).index($(this).parents('li:first')[0]));
                });
            maintab.tabs('select', '#' + ui.panel.id);
        }
    });
	
	//Menu click logics
    jQuery("#west-grid").jqGrid({
        url: "resources/menu.xml",
        datatype: "xml",
        height: "auto",
        pager: false,
        loadui: "disable",
        colNames: ["id","Functions","url"],
        colModel: [
            {name: "id",width:1,hidden:true, key:true},
            {name: "menu", width:150, resizable: false, sortable:false},
            {name: "url",width:1,hidden:true}
        ],
        treeGrid: true,
		caption: "Sanasa Grocery",
        ExpandColumn: "menu",
        autowidth: true,
        //width: 180,
        rowNum: 200,
        ExpandColClick: true,
        treeIcons: {leaf:'ui-icon-document-b'},
        onSelectRow: function(rowid) {
            var treedata = $("#west-grid").jqGrid('getRowData',rowid);
            if(treedata.isLeaf=="true") {
                //treedata.url
                var st = "#t"+treedata.id;
				if($(st).html() != null ) {
					maintab.tabs('select',st);
				} else {
					maintab.tabs('add',st, treedata.menu);
					//$(st,"#tabs").load(treedata.url);
					$.ajax({
						url: treedata.url,
						type: "GET",
						dataType: "html",
						complete : function (req, err) {
							
							var headID = document.getElementsByTagName("head")[0];         
							var newScript = document.createElement('script');
							newScript.type = 'text/javascript';
							newScript.src = 'resources/js/performSales.js';
							headID.appendChild(newScript);
							
//							http://jsfiddle.net/mkennedy/eEBZh/
//							http://jsfiddle.net/eEBZh/18/
							
							$(st,"#tabs").append(req.responseText);
							
							
							var clck = '<p style="border: 1px solid; background-color: lemonchiffon; width:654px;height:25px;margin-bottom: 8px;padding-top: 8px;text-align: center">';
							clck += '<b> Hi Rimaz</b></p>';
							$(st,"#tabs").append(clck);
							
						}
					});
				}
            }
        }
    });
	
// end splitter

});