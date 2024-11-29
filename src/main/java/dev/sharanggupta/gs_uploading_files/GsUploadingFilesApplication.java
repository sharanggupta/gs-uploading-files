package dev.sharanggupta.gs_uploading_files;

import dev.sharanggupta.gs_uploading_files.storage.StorageProperties;
import dev.sharanggupta.gs_uploading_files.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class GsUploadingFilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GsUploadingFilesApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
