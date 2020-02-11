package controller;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.UploadedImageFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @RequestMapping("/uploadImage")
    public ModelAndView upload(HttpServletRequest request, UploadedImageFile uploadedImageFile) throws IllegalStateException,IOException {
        //获取随机文件名
        String name=RandomStringUtils.randomAlphanumeric(10);
        String newFileName=name+".jpg";
        //获取web目录下的image目录，用于存放上传的文件，intelliJ IDEA中的realpath是out\artifacts\springmvc_war_exploded\image
        File newFile=new File(request.getServletContext().getRealPath("/image"),newFileName);
        newFile.getParentFile().mkdirs();
        //复制文件
        uploadedImageFile.getImage().transferTo(newFile);
        ModelAndView mav=new ModelAndView("showUploadedFile");
        mav.addObject("imageName",newFileName);
        return mav;

    }
}
