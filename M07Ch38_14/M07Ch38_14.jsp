<%@ page import="java.util.Locale" %>
<%@ page import="java.util.TimeZone" %>
<%@ page import="chapter38.TimeBean" %>
<jsp:useBean id="timeBeanId" class="chapter38.TimeBean" scope="application" />

<%
    // Get parameters from the request
    int localeIndex = Integer.parseInt(request.getParameter("localeIndex"));
    int timeZoneIndex = Integer.parseInt(request.getParameter("timeZoneIndex"));
    
    // Retrieve the selected locale and time zone
    Locale locale = timeBeanId.getAllLocales()[localeIndex];
    TimeZone timeZone = timeBeanId.getAllTimeZones()[timeZoneIndex];
    
    // Set the locale and time zone
    timeBeanId.setLocale(locale);
    timeBeanId.setTimeZone(timeZone);
%>

<html>
<head>
    <title>Display Time</title>
</head>
<body>
    <h3>Current Time</h3>
    <p>Locale: <%= locale.getDisplayName() %></p>
    <p>Time Zone: <%= timeZone.getDisplayName() %></p>
    <p>Current Time: <%= timeBeanId.getCurrentTime() %></p>
    <p><a href="DisplayTimeForm.jsp">Back to Time Form</a></p>
</body>
</html>
