<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/layer/layer.js"></script>
<script type="text/javascript" language="javascript">
	//more javascript from http://www.smallrain.net
	function sAlert(str) {
		var msgw, msgh, bordercolor;
		msgw = 400;//提示窗口的宽度
		msgh = 100;//提示窗口的高度
		titleheight = 25 //提示窗口标题高度
		bordercolor = "#c51100";//提示窗口的边框颜色
		titlecolor = "#c51100";//提示窗口的标题颜色

		var sWidth, sHeight;
		sWidth = screen.width;
		sHeight = screen.height;

		var bgObj = document.createElement("div");
		bgObj.setAttribute('id', 'bgDiv');
		bgObj.style.position = "absolute";
		bgObj.style.top = "0";
		bgObj.style.background = "#cccccc";
		bgObj.style.filter = "progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
		bgObj.style.opacity = "0.6";
		bgObj.style.left = "0";
		bgObj.style.width = sWidth + "px";
		bgObj.style.height = sHeight + "px";
		bgObj.style.zIndex = "10000";
		document.body.appendChild(bgObj);

		var msgObj = document.createElement("div")
		msgObj.setAttribute("id", "msgDiv");
		msgObj.setAttribute("align", "center");
		msgObj.style.background = "white";
		msgObj.style.border = "1px solid " + bordercolor;
		msgObj.style.position = "absolute";
		msgObj.style.left = "50%";
		msgObj.style.top = "50%";
		msgObj.style.font = "12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
		msgObj.style.marginLeft = "-225px";
		msgObj.style.marginTop = -75 + document.documentElement.scrollTop
				+ "px";
		msgObj.style.width = msgw + "px";
		msgObj.style.height = msgh + "px";
		msgObj.style.textAlign = "center";
		msgObj.style.lineHeight = "25px";
		msgObj.style.zIndex = "10001";

		var title = document.createElement("h4");
		title.setAttribute("id", "msgTitle");
		title.setAttribute("align", "right");
		title.style.margin = "0";
		title.style.padding = "3px";
		title.style.background = bordercolor;
		title.style.filter = "progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
		title.style.opacity = "0.75";
		title.style.border = "1px solid " + bordercolor;
		title.style.height = "18px";
		title.style.font = "12px Verdana, Geneva, Arial, Helvetica, sans-serif";
		title.style.color = "white";
		title.style.cursor = "pointer";
		/*title.innerHTML="关闭";
		title.onclick=function(){
		document.body.removeChild(bgObj);
		document.getElementById("msgDiv").removeChild(title);
		document.body.removeChild(msgObj);
		     }*/
		document.body.appendChild(msgObj);
		document.getElementById("msgDiv").appendChild(title);
		var txt = document.createElement("p");
		txt.style.margin = "1em 0"
		txt.setAttribute("id", "msgTxt");
		txt.innerHTML = str;
		document.getElementById("msgDiv").appendChild(txt);
	}
	
	function div_close() {
		var bgObj = document.getElementById("bgDiv");
		var msgObj = document.getElementById("msgDiv");
		document.body.removeChild(bgObj);
		document.body.removeChild(msgObj);
	}
</script>
<script language="javascript">
function jxdk(){
	if(confirm('确定用户卡已插入！')){
		sAlert('读卡中，请等待……');
		try{
			var result = document.dtapplet.read();
			if(result==1){
				div_close();
				
				layer.open({
					type : 2,
					title : '监控回传',
					shadeClose : false,
					area : [ '620px', '90%' ],
					content : '${contextpath}/skqsbsj/jkhcdk.htm'
				});
				 
			}
			else{
				div_close();
				alert('基本信息读取失败，有可能卡文件损！');
			}
		}
		catch(err){
			div_close();
			alert('读卡失败，请检查读卡器是否连接！');
		}
	}	
}
 
</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">申报数据</a></li>
		</ul>
	</div>
	 <div class="formtitle1">
		<span>纳税户基本信息</span>
	</div>
	<table class="tableEdit">
		<thead>
			<tr>
				<th>纳税人微机编码</th>
				<td>${nsrxx.nsrwjbm }</td>
				<th>纳税人识别号</th>
				<td>${nsrxx.nsrsbh }</td>
			</tr>
			<tr>
				<th>纳税人名称</th>
				<td>${nsrxx.nsrmc }</td>
				<th>经营地址</th>
				<td>${nsrxx.jydz }</td>
			</tr>
		</thead>
	</table>
	 <div class="formtitle1">
		<span>机器编号为【${sbsj.jqbh }】申报信息</span>
	</div>
	<table class="tableEdit">
		<thead>
			<tr>
				<th>所属开始时间</th>
				<td>${sbsj.sskssj }</td>
				<th>所属结束时间</th>
				<td>${sbsj.ssjzsj }</td>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<tr>
				<th>正常票份数</th>
				<td>${sbsj.zcpfs }</td>
				<th>退票份数</th>
				<td>${sbsj.tpfs}</td>
				<th>废票份数</th>
				<td>${sbsj.fpfs}</td>
			</tr>
			<tr>
				<th>正常票金额（元）</th>
				<td>${sbsj.zcpzje }</td>
				<th>退票金额（元）</th>
				<td>${sbsj.tpzje}</td>
				<th>实际开票金额（元）</th>
				<td>${sbsj.zcpzje-sbsj.tpzje}</td>
			</tr>
		</thead>
	</table>
	
	 <div class="formtitle1">
		<span>阶段申报信息</span>
	</div>
	<c:forEach var="item" items="${alJdsb }">
	<table class="tableEdit">
		<thead>
			<tr>
				<th>所属开始时间</th>
				<td>${item.sskssj }</td>
				<th>所属结束时间</th>
				<td>${item.ssjzsj }</td>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<tr>
				<th>正常票份数</th>
				<td>${item.zcpfs }</td>
				<th>退票份数</th>
				<td>${item.tpfs}</td>
				<th>废票份数</th>
				<td>${item.fpfs}</td>
			</tr>
			<tr>
				<th>正常票金额（元）</th>
				<td>${item.zcpzje }</td>
				<th>退票金额（元）</th>
				<td>${item.tpzje}</td>
				<th>实际开票金额（元）</th>
				<td>${item.zcpzje-item.tpzje}</td>
			</tr>
		</thead>
	</table>
	</c:forEach>
	<table class="tableEdit">
	<tr>
	<c:if test="${sbflag==0 }">
	 <td>
		<input type="button" name="jxdk" class="btn" value="监控回传" onclick="jxdk();" style="cursor:hand;" />&nbsp;&nbsp;
			<jsp:plugin name="dtapplet" type="applet" code="com.jsdt.web.applet.TYUcReadlet.class" codebase="." archive="dtapplet.jar" width="1" height="1">
			<jsp:params>  
			  <jsp:param name="serverUrl" value="<%=basePath%>"   />
			</jsp:params>
			</jsp:plugin>
	</td>
	</c:if>
	<c:if test="${sbflag!=0 }">
		<td>系统正在计算汇总数据，请等待...    </td> 
	</c:if>
	</tr>
	</table>
	 <input type="hidden" name="nsrwjbm" id="nsrwjbm" value="${nsrxx.nsrwjbm }"/>
</body>
</html>