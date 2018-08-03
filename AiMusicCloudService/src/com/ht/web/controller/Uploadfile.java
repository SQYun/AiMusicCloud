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
 * springMVC�ļ��ϴ�����ʵ��
 * @author hqc
 *
 */
@Controller
@RequestMapping(value = "/upload")
public class Uploadfile{

    /** 
    * ���ļ��ϴ���
    * ��@RequestParamע����ָ�����ϵ�fileΪMultipartFile  
    * ��������ʵ���Զ�װ��~
    * @param multipartfile 
    * @return 
    * @throws IOException  
    */  
	@ResponseBody
   @RequestMapping(value = "/uploadId")
   public String idIdentification(@RequestParam("idPic") MultipartFile multipartfile,HttpServletRequest request,HttpServletResponse response) throws IOException {  
		//���Ի�ȡ�����ļ���Ϣ
       System.out.println("getOriginalFilename:"+multipartfile.getOriginalFilename());  
       System.out.println("getName:"+multipartfile.getName());  
       System.out.println("---savePath-------"+multipartfile.getName());

       // ���÷��ص��ļ���ʽ,ͼƬ  
       //HttpHeaders headers = new HttpHeaders();  
       //headers.setContentType(MediaType.IMAGE_JPEG);  


       //��ȡ��Ŀ�����ļ��ĸ�Ŀ¼
       String savePath = request.getSession().getServletContext().getRealPath("/uploadFile/placeMusic");  
       
       
       System.out.println("---savePath =-------"+savePath);

       //����ԭ�ļ���ʹ��ʱ����������������������
       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
       String fileName = multipartfile.getOriginalFilename();
       String lastThreeLetter = fileName.substring(fileName.lastIndexOf("."));
       String sqlName = sdf.format(new Date())+(int)(Math.random()*10000)+lastThreeLetter;          

       //���ݸ�Ŀ¼���ļ����������µ��ļ�·��  
       File saveFile = new File(savePath+File.separator+sqlName);  

       //����ȡ����ǰ̨���ļ���ת�����µ��ļ�����
       //springmvc�Ѿ���װ������������������������д���������
       multipartfile.transferTo(saveFile);  

       //����json
        String json = "{\"result\":\"'+result+'\"}";
        return json;

       //����ҳ����ʾ�û��ϴ���ͼƬ  
       //return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(saveFile), headers, HttpStatus.OK);  
   }  

    /** 
     * ���ļ��ϴ���
     * ǰ̨���ϴ�����ļ���ʹ��MultipartFile��������ʽ����
     * @param multipartfiles 
     * @return 
     * @throws IllegalStateException 
     * @throws IOException 
     */  
    @RequestMapping(value = "/multiUploadId")  
    public String multiUpload(@RequestParam("idPic") MultipartFile[] multipartfiles,HttpServletRequest request,HttpServletResponse response)   
            throws IllegalStateException, IOException {  

        //��ȡ��Ŀ�����ļ��ĸ�Ŀ¼
        String savePath = request.getSession().getServletContext().getRealPath("/uploadFile/placeMusic"); 

        //��ʽ��ʱ���
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String timePath = sdf.format(new Date());

        if(null != multipartfiles && multipartfiles.length > 0){  
            //�����������ļ�  
            for(MultipartFile file : multipartfiles){  
                //1. ʹ��ԭ�ļ�����Ϊ�����·��
                //file.transferTo(new File(savePath + file.getOriginalFilename()));  

                //2. ���ÿ���ļ�������ͬ��ʱ���+���������
                   String fileName = file.getOriginalFilename();
                   String lastThreeLetter = fileName.substring(fileName.lastIndexOf("."));
                   String sqlName = timePath+(int)(Math.random()*10000)+lastThreeLetter;    

                   //���ݸ�Ŀ¼���ļ����������µ��ļ�·��  
                   File saveFile = new File(savePath+File.separator+sqlName);

                   //����ȡ����ÿ���ļ����ֱ�ת�����µ��ļ�����
                   //springmvc�Ѿ���װ������������������������д���������
                   file.transferTo(saveFile);  
            }  
        }  
        return "redirect:uploadPage";  
    }  
}