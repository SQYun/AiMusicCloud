package com.ht.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ht.entity.Video;
import com.ht.service.IVideoService;

@Controller                     
@RequestMapping("/jsp/video")
public class VideoController {
	
	@Autowired
	private IVideoService videoService;
	
	@RequestMapping("/getAllVideo.action")
	private String getAllVideo(HttpServletRequest request) {
		System.out.println("-----------------------------------");
		List<Video> videoList = videoService.getAllVideo();
		request.setAttribute("videoList", videoList);
		return "video/videoList";
	}
	
	@RequestMapping("/getVideo.action")
    public String getVideo(String id,HttpServletRequest request){
        Video video = videoService.getVideo(id);
        request.setAttribute("video", video);
        return "video/videoEdit";
    }
	
	@RequestMapping("/getVideoAdd.action")
    public String toAddVideo(){
        return "video/videoAdd";
    }
	
	@RequestMapping("/videoAdd.action")
    public String addVideo(Video video,HttpServletRequest request){
		videoService.videoAdd(video);
        return "redirect:/jsp/video/getAllVideo.action";
    }
	
	@RequestMapping("/delVideo.action")
    public void delVideo(String id,HttpServletResponse response){
		System.out.println("del");
        String result = "{\"result\":\"error\"}";
        if(videoService.delVideo(id)){
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
	
	
	 @RequestMapping("/updateVideo.action")
	    public String updateVideo(Video video,HttpServletRequest request){
	        if(videoService.updateVideo(video)){
	        	video = videoService.getVideo(video.getVideo_id());
	            request.setAttribute("video", video);
	            return "redirect:/jsp/video/getAllVideo.action";
	        }else{
	            return "user/error";
	        }
	    }

}
