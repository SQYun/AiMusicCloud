package com.ht.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ht.entity.Image;
import com.ht.service.IImageService;

@Controller                     // 指明当前类是控制器
@RequestMapping("/jsp/image")    // 根路径
public class ImageController {
	
	@Autowired
	private IImageService imageService;
	
	@RequestMapping("/getAllImage.action")
	private String getAllImage(HttpServletRequest request) {
		List<Image> imageList = imageService.getAllImage();
		request.setAttribute("imageList", imageList);
		System.out.println("-----------------------------------");
		return "image/imageList";
	}
	
	@RequestMapping("/getImage.action")
    public String getImage(String id,HttpServletRequest request){
		Image image = imageService.getImage(id);
        request.setAttribute("image", image);
        return "image/imageEdit";
    }
	
	@RequestMapping("/getimageAdd.action")
    public String toAddImage(){
        return "image/imageAdd";
    }
	
	@RequestMapping("/imageAdd.action")
    public String addUser(Image image,@RequestParam("idImg") MultipartFile multipartfile,HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("===================================");
		if(multipartfile != null) {
			if(multipartfile.getSize() >200000000) {
				System.out.println("文件大小超过20M，上传失败");
				return "文件大小超过20M，上传失败";
			}
			String savepath = this.idIdentification(multipartfile, request, response);
			
			System.out.println("savepath = "+savepath);
			image.setImg_value(savepath);
		}
		
		imageService.imageAdd(image);
        return "redirect:/jsp/image/getAllImage.action";
    }
	
	@RequestMapping("/delImage.action")
    public void delImage(String id,HttpServletResponse response){
		System.out.println("del");
        String result = "{\"result\":\"error\"}";
        if(imageService.delImage(id)){
            result = "{\"result\":\"success\"}";
        }
        response.setContentType("application/json");
        
        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	 @RequestMapping("/updateImage.action")
	    public String updateImage(Image image,HttpServletRequest request){
	        
	        if(imageService.updateImage(image)){
	        	image = imageService.getImage(image.getImg_id());
	            request.setAttribute("image", image);
	            return "redirect:/jsp/image/getAllImage.action";
	        }else{
	            return "image/error";
	        }
	    }
	 
	 
	 /** 
	    * 单文件上传：
	    * 用@RequestParam注解来指定表单上的file为MultipartFile  
	    * 参数都会实行自动装配~
	    * @param multipartfile 
	    * @return 
	    * @throws IOException  
	    */  
		@ResponseBody
	   @RequestMapping(value = "/uploadId.action")
	   public String idIdentification(@RequestParam("idImg") MultipartFile multipartfile,HttpServletRequest request,HttpServletResponse response) throws IOException {  

	       //测试获取到的文件信息
	       System.out.println("getOriginalFilename:"+multipartfile.getOriginalFilename());  
	       System.out.println("getName:"+multipartfile.getName());  

	       // 设置返回的文件格式,图片  
	       //HttpHeaders headers = new HttpHeaders();  
	       //headers.setContentType(MediaType.IMAGE_JPEG);  

	       //获取项目保存文件的根目录
//	       String savePath = request.getSession().getServletContext().getRealPath("uploadFile\\placeMusic");
	       String savePath = "D:\\apache-tomcat-8.5.31\\webapps\\uploadFile\\placeMusic";
	       

	       //根据原文件名使用时间戳和随机数重命名，保存
	       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
	       String fileName = multipartfile.getOriginalFilename();
	       String lastThreeLetter = fileName.substring(fileName.lastIndexOf("."));
	       String sqlName = sdf.format(new Date())+(int)(Math.random()*10000)+lastThreeLetter;          

	       //根据根目录和文件名，创建新的文件路径  
	       File saveFile = new File(savePath+File.separator+sqlName);  

	       System.out.println("saveFile = "+saveFile);
	       //将获取到的前台的文件流转换到新的文件上面
	       //springmvc已经封装了输入和输出流方法，无需再写输入输出流
	       multipartfile.transferTo(saveFile);  

	       String filepath = saveFile.toString();
	       String readpath = "http://10.25.209.5:8080/music/" + filepath.substring(54);
	       
	        return readpath;

	   }  

}
