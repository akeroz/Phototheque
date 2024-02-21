package fr.epsi.project.phototheque.v1.controller;

import fr.epsi.project.phototheque.entity.Image;
import fr.epsi.project.phototheque.service.ImageService;
import fr.epsi.project.phototheque.v1.dto.ImageDto;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/image")
public class ImageController {

    ImageService imageService;
    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }

    @GetMapping("")
    public Page<ImageDto> getAll(Pageable pageable){
        return this.imageService.getAll(pageable)
                .map(v -> new ImageDto(
                        v.getId(),
                        v.getName(),
                        v.getContent(),
                        v.getCategorie(),
                        v.getDescription(),
                        v.getDate(),
                        v.getHasHuman()));
    }

    @GetMapping("view/{id}/")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        Image image = imageService.getById(Long.valueOf(id));

        if (image.getContent() != null) {
            byte[] byteArray = new byte[image.getContent().length];
            int i = 0;

            for (Byte wrappedByte : image.getContent()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }

    @PostMapping(path = "/upload/",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String updateImage(@RequestParam("image") MultipartFile file, ModelMap modelMap) throws IOException {

        String fileName = file.getOriginalFilename();

        //Recuperation de l'extention du fichier
        String ext = Objects.requireNonNull(fileName).substring(fileName.lastIndexOf('.') + 1).toLowerCase();

        if (ext.equals("jpeg") || ext.equals("jpe") || ext.equals("jpg") || ext.equals("png") || ext.equals("gif")) {

            byte[] content = file.getBytes();
            DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
            Image image = new Image();

            image.setCategorie("default");
            image.setContent(content);
            image.setDate(dateformat.format(LocalDateTime.now()));
            image.setDescription("Default Description");
            image.setName(fileName);
            image.setHasHuman(false);

            this.imageService.save(image);

            modelMap.addAttribute("msg", "Image '" + fileName + "' Successfully Uploaded");

        } else {

            modelMap.addAttribute("msg", "Image '" + fileName + "' must be an image file (jpeg/png/gif)");
        }

        return "upload";
    }
}
