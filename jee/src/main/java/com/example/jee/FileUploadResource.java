package com.example.jee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Path("/")
public class FileUploadResource {

    Logger LOGGER = LoggerFactory.getLogger(FileUploadResource.class);

    @POST
    @Consumes("multipart/form-data")
    @Produces("text/plain")
    public Status upload(@QueryParam("file") String file, InputStream stream ) throws IOException {

        LOGGER.info("Received file to upload {} ", file);

        final java.nio.file.Path path = Paths.get(file);

        Files.copy(stream, path, StandardCopyOption.REPLACE_EXISTING);

        return Status.OK;
    }
}