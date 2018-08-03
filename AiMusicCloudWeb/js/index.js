/**
 * Created by Administrator on 2018/7/25/025.
 */
$().ready(
    (function(){
        //播放按钮的旋转
        $("#songSheet .songCoverList>div>div>div").on("mouseenter",function(){
            $(this).find("img").addClass("active");
        });
        $("#songSheet .songCoverList>div>div>div").on("mouseleave",function(){
            $(this).find("img").removeClass("active");
        });

    //   歌单切换
        $("#songSheet>div:first-child ul li a").on("click",function(){
             $(this).addClass("active");
             $(this).parent().siblings().find(".active").removeClass("active");

             var title=$(this).attr("data-title");
             console.log(title);
             $("#songSheet>div>.songCoverList:nth-child("+title+")").addClass("active").siblings(".active").removeClass("active");
            console.log($("#songSheet>div>.songCoverList:nth-child("+title+")").siblings(".active"));

        })
    })()

);