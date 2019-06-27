<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.cafe.member.model.MemberDto"%>
<%
response.sendRedirect(request.getContextPath()+"/boardadmin/boardmenu");

MemberDto memberDto = new MemberDto();
memberDto.setId("yahoho");
memberDto.setName("포식자영찬");
memberDto.setEmail("yahoho@gmail.com");

session.setAttribute("userInfo", memberDto);
%>