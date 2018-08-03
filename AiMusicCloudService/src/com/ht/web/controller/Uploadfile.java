package com.ht.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * springMVC文件上传方法实例
 * @author hqc
 *
 */
@Controller
@RequestMapping(value = "/upload")
public class Uploadfile{

    /** 
    * 单文件上传：
    * 用@RequestParam注解来指定表单上的file为MultipartFile  
    * 参数都会实行自动装配~
    * @param multipartfile 
    * @return 
    * @throws IOException  
    */  
	@ResponseBody
   @RequestMapping(value = "/uploadId")
   public String idIdentification(@RequestParam("idPic") MultipartFile multipartfile,HttpServletRequest request,HttpServletResponse response) throws IOException {  
		//测试获取到的文件信息
       System.out.println("getOriginalFilename:"+multipartfile.getOriginalFilename());  
       System.out.println("getName:"+multipartfile.getName());  
       System.out.println("---savePath-------"+multipartfile.getName());

       // 设置返回的文件格式,图片  
       //HttpHeaders headers = new HttpHeaders();  
       //headers.setContentType(MediaType.IMAGE_JPEG);  


       //获取项目保存文件的根目录
       String savePath = request.getSession().getServletContext().getRealPath("/uploadFile/placeMusic");  
       
       
       System.out.println("---savePath =-------"+savePath);

       //根据原文件名使用时间戳和随机数重命名，保存
       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
       String fileName = multipartfile.getOriginalFilename();
       String lastThreeLetter = fileName.substring(fileName.lastIndexOf("."));
       String sqlName = sdf.format(new Date())+(int)(Math.random()*10000)+lastThreeLetter;          

       //根据根目录和文件名，创建新的文件路径  
       File saveFile = new File(savePath+File.separator+sqlName);  

       //将获取到的前台的文件流转换到新的文件上面
       //springmvc已经封装了输入和输出流方法，无需再写输入输出流
       multipartfile.transferTo(saveFile);  

       //返回json
        String json = "{\"result\":\"'+result+'\"}";
        return json;

       //返回页面显示用户上传的图片  
       //return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(saveFile), headers, HttpStatus.OK);  
   }  

    /** 
     * 多文件上传：
     * 前台可上传多个文件，使用MultipartFile的数组形式接收
     * @param multipartfiles 
     * @return 
     * @throws IllegalStateException 
     * @throws IOException 
     */  
    @RequestMapping(value = "/multiUploadId")  
    public String multiUpload(@RequestParam("idPic") MultipartFile[] multipartfiles,HttpServletRequest request,HttpServletResponse response)   
            throws IllegalStateException, IOException {  

        //获取项目保存文件的根目录
        String savePath = request.getSession().getServletContext().getRealPath("/uploadFile/placeMusic"); 

        //格式化时间戳
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String timePath = sdf.format(new Date());

        if(null != multipartfiles && multipartfiles.length > 0){  
            //遍历并保存文件  
            for(MultipartFile file : multipartfiles){  
                //1. 使用原文件名作为保存的路径
                //file.transferTo(new File(savePath + file.getOriginalFilename()));  

                //2. 针对每个文件创建不同的时间戳+随机数名称
                   String fileName = file.getOriginalFilename();
                   String lastThreeLetter = fileName.substring(fileName.lastIndexOf("."));
                   String sqlName = timePath+(int)(Math.random()*10000)+lastThreeLetter;    

                   //根据根目录和文件名，创建新的文件路径  
                   File saveFile = new File(savePath+File.separator+sqlName);

                   //将获取到的每个文件流分别转换到新的文件上面
                   //springmvc已经封装了输入和输出流方法，无需再写输入输出流
                   file.transferTo(saveFile);  
            }  
        }  
        return "redirect:uploadPage";  
    }  
}