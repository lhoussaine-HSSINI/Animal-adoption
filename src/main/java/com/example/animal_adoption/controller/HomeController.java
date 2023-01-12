package com.example.animal_adoption.controller;

import com.example.animal_adoption.model.dto.AnimauxDTO;
import com.example.animal_adoption.model.dto.UserDTO;
import com.example.animal_adoption.model.entity.Animaux;
import com.example.animal_adoption.model.entity.User;
import com.example.animal_adoption.service.AnimauxService;
import com.example.animal_adoption.service.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.modelmapper.ModelMapper;
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
    @Autowired
    private ModelMapper mapper;

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
        boolean Response_createanimaux =false;
        String name_image =null;
        AnimauxDTO animauxDTO_info = animauxDTO;
        Optional<MultipartFile>  optionalMy_file = Optional.ofNullable(my_file);
        if (optionalMy_file.isPresent()){

            if (animauxService.test_type_file(optionalMy_file.get())){
                name_image = animauxService.saveImageAnimaux(optionalMy_file.get());
                User animaux_of_user = userService.get_user_by_id(animauxDTO_info.getUsersByIdUser()).get();
                animauxDTO_info.setPhoto(name_image);
                animauxDTO_info.setUsersByIdUser(animauxDTO_info.getUsersByIdUser());
                Animaux animaux = mapper.map(animauxDTO_info, Animaux.class);
                animaux.setUsersByIdUser(animaux_of_user);
                System.out.println(animaux.getUsersByIdUser().getIdentifiant());
            }
        }else {
            System.out.println("file  dyali  makaynx aslan");
        }

        return ResponseEntity.ok("succes to upload file image");
    }


    @GetMapping("/get_image/{filename}")
    public Resource download_image(@PathVariable String filename){
        if (!filename.isEmpty())
            return animauxService.getImageAnimaux(filename);
        else
            return null;
    }
}
