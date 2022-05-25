package com.example.fileupload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
public class FileUploadController {

	Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);
	@PostMapping(value = "/")
	public Status handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {

		LOGGER.info("Received file to upload {} ", file);

		final java.nio.file.Path path = Paths.get(file.getOriginalFilename());

		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

		return Status.OK;
	}
}
