<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
 
</head>
<body>
<!--==========right部分==========-->
<div id="right">
  <div id="tool">
  </div>
  <div id="main">
	<table width="60%" border="0" align="center" cellpadding="0" cellspacing="0" id="userLogin2" >
      <tr>
        <th width="5%">成功信息</th>
      </tr>
      <tr>
        <td height="152" align="center" style="text-align:center">
          <font color="#FF0000" style="font-size:16px;">${successMsg }</font><br /><br />
          <input type="button" name="btn" value=" 返 回 " onclick="window.history.location.href='${contextpath}/toSjyzImport.htm'" />
        </td>
      </tr>
    </table>
  </div>
</div>
</body>
</html>