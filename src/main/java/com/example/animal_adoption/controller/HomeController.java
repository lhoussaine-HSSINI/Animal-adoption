package com.example.animal_adoption.controller;

import com.example.animal_adoption.model.dto.AnimauxDTO;
import com.example.animal_adoption.model.dto.UserDTO;
import com.example.animal_adoption.model.entity.Animaux;
import com.example.animal_adoption.model.entity.User;
import com.example.animal_adoption.service.AnimauxService;
import com.example.animal_adoption.service.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/faho/auth")
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private AnimauxService animauxService;

//    page index
    @GetMapping("/")
    @ResponseBody
    public List<UserDTO> index() {
        return  userService.getpageHome();
    }

    @GetMapping("/animo")
    @ResponseBody
    public List<AnimauxDTO> animo() {
        return  animauxService.getAnimaux_all();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createanimaux(@ModelAttribute AnimauxDTO animauxDTO, @RequestParam("file") MultipartFile my_file) {

//        smya  l2asliya  dyal image li dkhl client
        String name_of_file = my_file.getOriginalFilename();
        String extension_of_my_file =my_file.getOriginalFilename().substring(my_file.getOriginalFilename().lastIndexOf("."));

//        daba  change dyal smya  dyal had image  :: andir  fsmya  dyalha  tarikh wnzid 3liha lwa9t fax  dkhlat dik image wnzid 3liha name dyal username dyal client
        Date today = new Date();
        SimpleDateFormat my_format_today = new SimpleDateFormat("yyyyMMddHHmmssS");
        String name_jdid_dyal_image = my_format_today.format(today)+extension_of_my_file;

//        path+name_jdid
        System.out.println(name_jdid_dyal_image);
        String path_directory_my_mage =".\\my_Upload_images\\"+name_jdid_dyal_image;

//        copy image to docier my_Upload_images
        try {

            Files.copy(
                    my_file.getInputStream(),
                    Paths.get(path_directory_my_mage),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

        return ResponseEntity.ok("succes to upload file image");
    }


    @GetMapping("/get_image/{filename}")
    public Resource download_image(@PathVariable String filename){
        Path pathToFile = Paths.get(".\\my_Upload_images\\"+filename);
        UrlResource resource = null;
        try {
            resource = new UrlResource(pathToFile.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return resource;
    }
}
