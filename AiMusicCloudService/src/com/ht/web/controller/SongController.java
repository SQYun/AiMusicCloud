package com.ht.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.ht.entity.Song;
import com.ht.service.ISongService;


	@Controller                     // 指明当前类是控制器
	@RequestMapping("/jsp/song")    // 根路径

public class SongController {

		
		@Autowired
		private ISongService songService;
		
		@RequestMapping(value = "/getSongJson",method = RequestMethod.GET)
		@ResponseBody
		private String getSongJson(HttpServletRequest request,HttpServletResponse response) {
			try {
				List<Song> songList = songService.getAllSong();
				return Result.getSuccess(songList);
				
			} catch (Exception e) {
				System.out.println("JSONObject catch ");
				return Result.getError(getExceptionAllinformation(e));
			}
			
		}
		
		private String getExceptionAllinformation(Exception e) {
			// TODO Auto-generated method stub
			return null;
		}

		@RequestMapping("/getAllSong.action")
		private String getAllSong(HttpServletRequest request) {
			List<Song> songList = songService.getAllSong();
			request.setAttribute("songList", songList);
			System.out.println("-----------------------------------");
			return "song/songList";
		}
		
		@RequestMapping("/getSong.action")
	    public String getSong(String id,HttpServletRequest request){
	        Song song = songService.getSong(id);
	        request.setAttribute("song", song);
	        return "song/songEdit";
	    }
		
		@RequestMapping("/getsongAdd.action")
	    public String toAddSong(){
	        return "song/songAdd";
	    }
		
		@RequestMapping("/songAdd.action")
	    public String addSong(Song song,@RequestParam("idMic") MultipartFile multipartfile,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			
			if(multipartfile != null) {
				if(multipartfile.getSize() >200000000) {
					System.out.println("文件大小超过20M，上传失败");
					return "文件大小超过20M，上传失败";
				}
//			System.out.println("===============songAdd====================");
//			System.out.println("getOriginalFilename:"+multipartfile.getOriginalFilename());  
//		    System.out.println("getName:"+multipartfile.getName());  
			String songFileName = multipartfile.getOriginalFilename();
			String songName = songFileName.substring(0, songFileName.length()-4);
//			System.out.println("songName = "+songName);
			song.setSong_name(songName);
			 long fileS = multipartfile.getSize();
			 DecimalFormat df = new DecimalFormat("#.00");
			String songLength = df.format((double) fileS / 1048576);
			BigDecimal songSize=new BigDecimal(songLength);
			song.setSong_size(songSize);
			
			String savepath = this.idIdentification(multipartfile, request, response);
			System.out.println("savepath = "+savepath);
			song.setSong_url(savepath);
			
			 String readpath = "D:\\apache-tomcat-8.5.31\\webapps\\uploadFile\\placeMusic\\" + savepath.substring(30);
			
			 System.out.println("readpath = "+readpath);
			 
			File file = new File(readpath);
			try {
				MP3File f = (MP3File)AudioFileIO.read(file);
				MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
				
				int songTimeLen = audioHeader.getTrackLength();
				song.setSong_timelen(songTimeLen);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
			
			songService.songAdd(song);
	        return "redirect:/jsp/song/getAllSong.action";
	    }
		
		@RequestMapping("/delSong.action")
	    public void delSong(String id,HttpServletResponse response){
			System.out.println("del");
	        String result = "{\"result\":\"error\"}";
	        if(songService.delSong(id)){
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
		
		
		 @RequestMapping("/updateSong.action")
		    public String updateAdmin(Song song,HttpServletRequest request){
		        
		        if(songService.updateSong(song)){
		        	song = songService.getSong(song.getSong_id());
		            request.setAttribute("song", song);
		            return "redirect:/jsp/song/getAllSong.action";
		        }else{
		            return "user/error";
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
		   public String idIdentification(@RequestParam("idPic") MultipartFile multipartfile,HttpServletRequest request,HttpServletResponse response) throws IOException {  

		       //测试获取到的文件信息
		       System.out.println("getOriginalFilename:"+multipartfile.getOriginalFilename());  
		       System.out.println("getName:"+multipartfile.getName());  

		       // 设置返回的文件格式,图片  
		       //HttpHeaders headers = new HttpHeaders();  
		       //headers.setContentType(MediaType.IMAGE_JPEG);  

		       //获取项目保存文件的根目录
//		       String savePath = request.getSession().getServletContext().getRealPath("uploadFile\\placeMusic");
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
		       
		       //返回json
//		       String json = "{\"result\":\"'+result+'\"}";
		        return readpath;

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
		        String savePath = request.getSession().getServletContext().getRealPath("uploadFile\\placeMusic"); 

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

