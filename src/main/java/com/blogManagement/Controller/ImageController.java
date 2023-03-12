package com.blogManagement.Controller;

import com.blogManagement.DTO.ImageDimensionsUpdateDto;
import com.blogManagement.DTO.ImageEntryDto;
import com.blogManagement.DTO.ImageResponseDto;
import com.blogManagement.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping("/add")
    public String addImage(@RequestBody ImageEntryDto imageEntryDto){
        return imageService.addImage(imageEntryDto);
    }

    @GetMapping("/getImageDetails/{id}")
    public ImageResponseDto getImage(@PathVariable("id") int id){
        return imageService.getImage(id);
    }

    @PutMapping("/updateDimension/{id}")
    public String updateBlogDimension(@PathVariable("id") int id, @RequestBody ImageDimensionsUpdateDto imageDimensionsUpdateDto){
        return imageService.updateImageDimension(id, imageDimensionsUpdateDto);
    }

    @PutMapping("/updateDescription/{id}")
    public String updateBlogDescription(@PathVariable("id") int id, @RequestBody ImageDimensionsUpdateDto imageDimensionsUpdateDto){
        return imageService.updateImageDimension(id, imageDimensionsUpdateDto);
    }

    @DeleteMapping("/deleteImage/{id}")
    public String deleteImage(@PathVariable("id") int id){
        return imageService.deleteImage(id);
    }
}
