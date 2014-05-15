package <%=packageName%>.<%=projectName%>service;

import com.google.common.base.Optional;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.header.ContentDisposition;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.List;

/**
 * Created by thelmkay on 1/8/14.
 */
@Path("/")
public class <%=projectName%>Resource {
    protected Logger logger = LoggerFactory.getLogger(<%=projectName%>Resource.class);

    public <%=projectName%>Resource() {
	//TODO configure your dao here
    }
    
    @GET
    public Response HelloWorld(){
    	return Response.ok("Hello world").build();
    }
    
    

}
