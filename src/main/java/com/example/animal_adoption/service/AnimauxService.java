package com.example.animal_adoption.service;

import com.example.animal_adoption.model.Repository.AnimauxRepository;
import com.example.animal_adoption.model.dto.AnimauxDTO;
import com.example.animal_adoption.model.dto.UserDTO;
import com.example.animal_adoption.model.entity.Animaux;
import com.example.animal_adoption.model.entity.User;
import jakarta.activation.MimetypesFileTypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimauxService {

    @Autowired
    private AnimauxRepository animauxRepository;

    public List<AnimauxDTO>  getAnimaux_all(){
        return ((List<Animaux>) animauxRepository
                .findAll())
                .stream()
                .map(this::convertDataIntoDTO)
                .collect(Collectors.toList());
    }
    public List<Animaux>  saveAnimaux(){
        return animauxRepository.findAll();
    }

    // create convertDataIntoDTO() method that returns UserDTO
    private AnimauxDTO convertDataIntoDTO (Animaux animauxData) {

        // create instance of our UserLocationDTO class
        AnimauxDTO dto = new AnimauxDTO();
        dto.setIdAnimaux(animauxData.getIdAnimaux());
        dto.setType(animauxData.getType());
        dto.setAge(animauxData.getAge());
        dto.setPhoto(animauxData.getPhoto());
        dto.setDescription(animauxData.getDescription());
        dto.setNombreJours(animauxData.getNombreJours());
        dto.setUsersByIdUser(animauxData.getUsersByIdUser().getIdentifiant());
        return dto;
    }

//    save image  to directory
    public String saveImageAnimaux(MultipartFile my_file){
//        smya  l2asliya  dyal image li dkhl client
        String name_of_file = my_file.getOriginalFilename();
        String extension_of_my_file =my_file.getOriginalFilename().substring(my_file.getOriginalFilename().lastIndexOf("."));

//        daba  change dyal smya  dyal had image  :: andir  fsmya  dyalha  tarikh wnzid 3liha lwa9t fax
//        dkhlat dik image wnzid 3liha name dyal username dyal client
        Date today = new Date();
        SimpleDateFormat my_format_today = new SimpleDateFormat("yyyyMMddHHmmssS");
        String name_jdid_dyal_image = my_format_today.format(today)+extension_of_my_file;

//        path+name_jdid
        String path_directory_my_mage =".\\my_Upload_images\\"+name_jdid_dyal_image;

//        copy image to docier my_Upload_images
        try {

            Files.copy(
                    my_file.getInputStream(),
                    Paths.get(path_directory_my_mage),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            return  "";
        }

        return  name_jdid_dyal_image;
    }

//    get image
    public Resource getImageAnimaux(String filename){

        Path pathToFile = Paths.get(".\\my_Upload_images\\"+filename);
        UrlResource resource = null;
        try {
            resource = new UrlResource(pathToFile.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return resource;
    }
//   check  file  is image  or not
    public boolean test_type_file(MultipartFile my_file){
        Path f = Paths.get(my_file.getOriginalFilename());
        String mimetype= new MimetypesFileTypeMap().getContentType(f.toFile());
        String type = mimetype.split("/")[0];
        if(type.equals("image"))
            return true;
        else
            return false;
    }
}

