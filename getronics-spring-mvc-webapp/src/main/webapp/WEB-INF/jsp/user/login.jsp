<%@ include file="../common/taglibs.jsp"%>

<spring:url value="/j_spring_security_check" var="url"></spring:url>

<div>
        <form name="login" action="${ url }" method="post">               
            <fieldset>
                <legend>Please Login</legend>
                <label for="username">Username</label>
                <input type="text" id="j_username" name="j_username"/>        
                <label for="password">Password</label>
                <input type="password" id="j_password" name="j_password"/>    
                <div class="form-actions">
                    <button type="submit" class="btn">Log in</button>
                </div>
            </fieldset>
        </form>
    </div>

