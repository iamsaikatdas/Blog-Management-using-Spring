package com.blogManagement.Service;

import com.blogManagement.DTO.ImageDescUpdateDto;
import com.blogManagement.DTO.ImageDimensionsUpdateDto;
import com.blogManagement.DTO.ImageEntryDto;
import com.blogManagement.DTO.ImageResponseDto;
import com.blogManagement.Model.Blog;
import com.blogManagement.Model.Image;
import com.blogManagement.Repository.BlogRepository;
import com.blogManagement.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Autowired
    BlogRepository blogRepository;

    public String addImage(ImageEntryDto imageEntryDto){
        Image image = new Image();
        image.setDimension(imageEntryDto.getDimension());
        image.setDescription(imageEntryDto.getDescription());

        int blogId = imageEntryDto.getBlogId();
        Blog blog;

        System.out.println(imageEntryDto.getBlogId() + " blog id");

        try {
            blog = blogRepository.findById(blogId).get();
            System.out.println(blog.getId() + "get blog id");
        }catch (Exception e){
            return "Blog id not found.";
        }
        image.setBlog(blog);
//        blogRepository.save(blog);
        imageRepository.save(image);
        return "Image added successfully.";
    }

    public ImageResponseDto getImage(int id){
        Image imageId = imageRepository.findById(id).get();
        ImageResponseDto imageResponseDto = ImageResponseDto.builder()
                .description(imageId.getDescription())
                .dimension(imageId.getDimension())
                .build();

        return imageResponseDto;
    }

    public String updateImageDescription(int id, ImageDescUpdateDto imageDescUpdateDto){
        Image image = imageRepository.findById(id).get();
        image.setDescription(imageDescUpdateDto.getDescription());

        imageRepository.save(image);
        return "Image description update successfully.";
    }

    public String updateImageDimension(int id, ImageDimensionsUpdateDto imageDimensionsUpdateDto){
        Image image = imageRepository.findById(id).get();
        image.setDimension(imageDimensionsUpdateDto.getDimension());

        imageRepository.save(image);
        return "Image dimensions update successfully.";
    }

    public String deleteImage(int id){
        try {
            imageRepository.deleteById(id);
        }catch (Exception e){
            return e.getMessage();
        }

        return "Image Deleted Successfully.";
    }
}
