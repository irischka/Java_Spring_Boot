package ua.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.entity.Transporter;
import ua.repository.TransporterRepository;
import ua.repository.UserRepository;
import ua.service.FileWritter;

import java.io.File;
import java.io.IOException;

@Service
public class FileWritterImpl implements FileWritter{

	@Value("${file.path}")
	private String path;
	
	private final UserRepository repository;
	
	private final TransporterRepository transporterRepository;
	
	
	public FileWritterImpl(UserRepository repository, TransporterRepository transporterRepository) {
		this.repository = repository;
		this.transporterRepository=transporterRepository;
	}

	@Override
	public String write(MultipartFile file, String string) {
		String filename = file.getOriginalFilename();
		File pathToFolder = new File(path);
		File pathToFile = new File(pathToFolder, filename);
		try {
			file.transferTo(pathToFile);
		} catch (IllegalStateException | IOException e) {
			return null;
		}
		Transporter transporter = repository.findProfileTransporterRepository(string);
		transporter.setPhotoUrl(filename.toString());
		transporterRepository.save(transporter);
 		return pathToFile.toString();
	}

}
