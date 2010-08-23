<%@ include file="adminHeaders.jsp" %>

<%

/* $Id$ */

/**
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements. See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
* 
* http://www.apache.org/licenses/LICENSE-2.0
* 
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
%>

<?xml version="1.0" encoding="utf-8"?>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="StyleSheet" href="style.css" type="text/css" media="screen"/>
	<title>
		Apache Connectors Framework: List job descriptions
	</title>

	<script type="text/javascript">
	<!--

	function Delete(jobID)
	{
		if (confirm("Warning: Deleting this job will remove all\nassociated documents from the index.\nDo you want to proceed?"))
		{
			document.listjobs.op.value="Delete";
			document.listjobs.jobid.value=jobID;
			document.listjobs.submit();
		}
	}

	//-->
	</script>


</head>

<body class="standardbody">

    <table class="page">
      <tr><td colspan="2" class="banner"><jsp:include page="banner.jsp" flush="true"/></td></tr>
      <tr><td class="navigation"><jsp:include page="navigation.jsp" flush="true"/></td>
       <td class="window">
	<p class="windowtitle">Job List</p>
	<form class="standardform" name="listjobs" action="execute.jsp" method="POST">
		<input type="hidden" name="op" value="Continue"/>
		<input type="hidden" name="type" value="job"/>
		<input type="hidden" name="jobid" value=""/>

<%
    try
    {
	// Get the job manager handle
	IJobManager manager = JobManagerFactory.make(threadContext);
	IJobDescription[] jobs = manager.getAllJobs();
%>
		<table class="datatable">
			<tr>
				<td class="separator" colspan="5"><hr/></td>
			</tr>
			<tr class="headerrow">
				<td class="columnheader"></td>
				<td class="columnheader"><nobr>Name</nobr></td>
				<td class="columnheader"><nobr>Output Connection</nobr></td>
				<td class="columnheader"><nobr>Repository Connection</nobr></td>
				<td class="columnheader"><nobr>Schedule Type</nobr></td>
			</tr>
<%
	int i = 0;
	while (i < jobs.length)
	{
		IJobDescription jd = jobs[i++];

		String jobType = "";
		switch (jd.getType())
		{
		case IJobDescription.TYPE_CONTINUOUS:
			jobType = "Continuous crawl";
			break;
		case IJobDescription.TYPE_SPECIFIED:
			jobType = "Specified time";
			break;
		default:
		}

%>
		<tr <%="class=\""+((i%2==0)?"evendatarow":"odddatarow")+"\""%>>
		    <td class="columncell">
			<a href='<%="viewjob.jsp?jobid="+jd.getID()%>' alt='<%="View job "+jd.getID()%>'>View</a>&nbsp;<a href='<%="editjob.jsp?jobid="+jd.getID()%>' alt='<%="Edit job "+jd.getID()%>'>Edit</a>&nbsp;<a href='<%="javascript:Delete(\""+jd.getID()+"\")"%>' alt='<%="Delete job "+jd.getID()%>'>Delete</a>&nbsp;<a href='<%="editjob.jsp?origjobid="+jd.getID()%>' alt='<%="Copy job "+jd.getID()%>'>Copy</a>
		    </td>
		    <td class="columncell"><%=org.apache.acf.ui.util.Encoder.bodyEscape(jd.getDescription())%></td>
		    <td class="columncell"><%=org.apache.acf.ui.util.Encoder.bodyEscape(jd.getOutputConnectionName())%></td>
		    <td class="columncell"><%=org.apache.acf.ui.util.Encoder.bodyEscape(jd.getConnectionName())%></td>
		    <td class="columncell"><%=jobType%></td>
		</tr>
<%
	}
%>
			<tr>
				<td class="separator" colspan="5"><hr/></td>
			</tr>
		<tr><td class="message" colspan="5"><a href="editjob.jsp" alt="Add a job">Add a new job</a></td></tr>
		</table>

<%
    }
    catch (LCFException e)
    {
	e.printStackTrace();
	variableContext.setParameter("text",e.getMessage());
	variableContext.setParameter("target","index.jsp");
%>
	<jsp:forward page="error.jsp"/>
<%
    }
%>
	    </form>
       </td>
      </tr>
    </table>

</body>

</html>
