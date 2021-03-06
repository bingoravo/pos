<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Sanasa Booking Engine</title>
  
<link rel="stylesheet" type="text/css" media="screen" href="resources/css/jquery-ui-custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="resources/css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" media="screen" href="resources/css/ui.multiselect.css" />
<link rel="stylesheet" type="text/css" media="screen" href="resources/css/auto-complete.css" />
<style>
html, body {
	margin: 0;			/* Remove body margin/padding */
	padding: 0;
	overflow: hidden;	/* Remove scroll bars on browser window */	
    font-size: 75%;
}
/*Splitter style */


#LeftPane {
	/* optional, initial splitbar position */
	overflow: auto;
}
/*
 * Right-side element of the splitter.
*/

#RightPane {
	padding: 2px;
	overflow: auto;
}
.ui-tabs-nav li {position: relative;}
.ui-tabs-selected a span {padding-right: 10px;}
.ui-tabs-close {display: none;position: absolute;top: 3px;right: 0px;z-index: 800;width: 16px;height: 14px;font-size: 10px; font-style: normal;cursor: pointer;}
.ui-tabs-selected .ui-tabs-close {display: block;}
.ui-layout-west .ui-jqgrid tr.jqgrow td { border-bottom: 0px none;}
.ui-datepicker {z-index:1200;}
.rotate
    {
        /* for Safari */
        -webkit-transform: rotate(-90deg);

        /* for Firefox */
        -moz-transform: rotate(-90deg);

        /* for Internet Explorer */
        filter: progid:DXImageTransform.Microsoft.BasicImage(rotation=3);
    }

</style>

<script src="resources/js/lib/jquery.js" type="text/javascript"></script>
<script src="resources/js/lib/jquery-ui-custom.min.js" type="text/javascript"></script>
<script src="resources/js/lib/jquery.layout.js" type="text/javascript"></script>
<script src="resources/js/lib/i18n/grid.locale-en.js" type="text/javascript"></script>
<script type="text/javascript">
	$.jgrid.no_legacy_api = true;
	$.jgrid.useJSON = true;
</script>
<script src="resources/js/lib/ui.multiselect.js" type="text/javascript"></script>
<script src="resources/js/lib/jquery.jqGrid.js" type="text/javascript"></script>
<script src="resources/js/lib/jquery.tablednd.js" type="text/javascript"></script>
<script src="resources/js/lib/jquery.contextmenu.js" type="text/javascript"></script>
<script src="resources/js/lib/jquery.autocomplete.min.js" type="text/javascript"></script>
<script src="resources/js/system.js" type="text/javascript"></script>

<script type="text/javascript">
/**
 * Since we are appening the scripts on demand,
   this mechanism is used to minimize the consequnces of dulicate loading!
   TODO: Improve
 */
loadCheker = {};
loadCheker.sales = loadCheker.sales || {};

loadCheker.isFirstLoad = function(namesp, jsFile) {
    var isFirst = namesp.firstLoad === undefined;
    namesp.firstLoad = false;
    
    if (!isFirst) {
        console.log( "Warning: Javascript file is included twice: " + jsFile);
    }

    return isFirst;
};

</script>

</head>
<body>
 
  
  	<div id="LeftPane" class="ui-layout-west ui-widget ui-widget-content">
		<table id="west-grid"></table>
	</div> <!-- #LeftPane -->
	
	<div id="RightPane" class="ui-layout-center ui-helper-reset ui-widget-content" ><!-- Tabs pane -->
        <div id="switcher"></div>
		<div id="tabs" class="jqgtabs">
			<ul>
				<li><a href="#tabs-1">Dash Board</a></li>
			</ul>
			<div id="tabs-1" style="font-size:12px;"> Dash Board <br/>
				<br/>
				Welcome to the Sanasa Booking Engine
				<br/>
				<br/>

				<p style="border: 1px solid; background-color: lemonchiffon; width:728px;height:25px;margin-bottom: 8px;padding-top: 8px;text-align: center">
				<b> SANASA BOOKING ENGINE</b></p>
				
				

<!--  				<iframe src="adds_c.html" style="width:728px; height:100px;" scrolling="no" marginwidth="0" marginheight="0" frameborder="0" vspace="0" hspace="0"/>  -->

			</div>
		</div>
		
		<a href='<c:url value="/j_spring_security_logout" />' > Logout</a>
		
	</div> <!-- #RightPane -->
</body>
</html>
