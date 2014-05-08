<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 
<tiles:insertDefinition name="root-container">
    <tiles:putAttribute name="content">
        <div class="content" id="contentdiv">
            <h1>Home page !</h1>
 
            <p>The time on the server is ${serverTime}.</p>
            <p>FouR Guys - Health Scheduler Home Page!</P>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>