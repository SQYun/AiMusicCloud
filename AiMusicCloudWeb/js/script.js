(function ($) {
    var repeat = localStorage.repeat || 0, shuffle = localStorage.shuffle || 'true', continous = true, autoplay = true,
        playlist = [{
            title: "The Diva Dance",
            artist: "Josie Young",
            album: " ",
            cover: "img/0.jpg",
            mp3: "http://ovsrojwiu.bkt.clouddn.com/03d02edf003b1ad3eacb96bc1fca6661.mp3",
        }, {
            title: "爱存在",
            artist: "王诗安",
            album: " ",
            cover: "img/1.jpg",
            mp3: "http://ovsrojwiu.bkt.clouddn.com/1030108101.mp3",
        }, {
            title: "听说爱情回来过",
            artist: "蔡依林",
            album: " ",
            cover: "img/2.jpg",
            mp3: "http://ovsrojwiu.bkt.clouddn.com/cqjjjjjjRingtone.mp3",
        }, {
            title: "答案",
            artist: "Tank",
            album: " ",
            cover: "img/3.jpg",
            mp3: "http://ovsrojwiu.bkt.clouddn.com/tank0622.mp3",
        }, {
            title: "叮叮叮",
            artist: "疯狂青蛙",
            album: " ",
            cover: "img/4.jpg",
            mp3: "http://ovsrojwiu.bkt.clouddn.com/ddddd.mp3",
        }, {
            title: "Electronic music",
            artist: "Electronic",
            album: " ",
            cover: "img/5.jpg",
            mp3: "http://ovsrojwiu.bkt.clouddn.com/downloadfile-2.mp3",
        }, {
            title: "Electronic music",
            artist: "Electronic",
            album: " ",
            cover: "img/5.jpg",
            mp3: "http://ovsrojwiu.bkt.clouddn.com/downloadfile-3.mp3",
        }, {
            title: "Electronic music",
            artist: "Electronic",
            album: " ",
            cover: "img/5.jpg",
            mp3: "http://ovsrojwiu.bkt.clouddn.com/downloadfile-4.mp3",
        }, {
            title: "Electronic music",
            artist: "Electronic",
            album: " ",
            cover: "img/5.jpg",
            mp3: "http://ovsrojwiu.bkt.clouddn.com/downloadfile-5.mp3",
        }, {
            title: "Electronic music",
            artist: "Electronic",
            album: " ",
            cover: "img/5.jpg",
            mp3: "http://ovsrojwiu.bkt.clouddn.com/downloadfile-6.mp3",
        }];
    /*如调用ajax时*/
        // playlist = [];
    // $.ajax({
    //     url: 'http://10.25.209.5:8080/AiMusicCloud/music/getSongNews.action',
    //     type: 'GET',
    //     // contentType: "application/json",
    //     dataType: 'json',
    //     async: false,
    //     success: function (data) {
    //         var contents = data.content;
    //         for (var i = 0; i < contents.length; i++) {
    //             var obj = {
    //                 title: contents[i][2],
    //                 artist: contents[i][3],
    //                 album: ' ',
    //                 cover: ' ',
    //                 mp3: contents[i][1]
    //             };
    //             playlist.push(obj);
    //             obj = {};
    //             $('.p-musicName').text(playlist.title)
    //         }
    //         console.log(playlist);
    //     },
    //     error: function () {
    //         console.log('音乐信息获取失败！');
    //     }
    // });
    // console.log(playlist);
    for (var i = 0; i < playlist.length; i++) {
        var item = playlist[i];
        $('#playlist').append('<li>' + item.artist + ' - ' + item.title + '</li>');
    }
    var time = new Date(), currentTrack = shuffle === 'true' ? time.getTime() % playlist.length : 0, trigger = false,
        audio, timeout, isPlaying, playCounts;
    var play = function () {
        audio.play();
        $('.playback').addClass('playing');
        timeout = setInterval(updateProgress, 500);
        isPlaying = true;
    }
    var pause = function () {
        audio.pause();
        $('.playback').removeClass('playing');
        clearInterval(updateProgress);
        isPlaying = false;
    }
    var setProgress = function (value) {
        var currentSec = parseInt(value % 60) < 10 ? '0' + parseInt(value % 60) : parseInt(value % 60),
            ratio = value / audio.duration * 100;
        $('.timer').html(parseInt(value / 60) + ':' + currentSec);
        $('.progress .pace').css('width', ratio + '%');
        $('.progress .slider a').css('left', ratio + '%');
    }
    var updateProgress = function () {
        setProgress(audio.currentTime);
    }
    $('.progress .slider').slider({
        step: 0.1, slide: function (event, ui) {
            $(this).addClass('enable');
            setProgress(audio.duration * ui.value / 100);
            clearInterval(timeout);
        }, stop: function (event, ui) {
            audio.currentTime = audio.duration * ui.value / 100;
            $(this).removeClass('enable');
            timeout = setInterval(updateProgress, 500);
        }
    });
    var setVolume = function (value) {
        audio.volume = localStorage.volume = value;
        $('.volume .pace').css('width', value * 100 + '%');
        $('.volume .slider a').css('left', value * 100 + '%');
    }
    var volume = localStorage.volume || 0.5;
    $('.volume .slider').slider({
        max: 1, min: 0, step: 0.01, value: volume, slide: function (event, ui) {
            setVolume(ui.value);
            $(this).addClass('enable');
            $('.mute').removeClass('enable');
        }, stop: function () {
            $(this).removeClass('enable');
        }
    }).children('.pace').css('width', volume * 100 + '%');
    $('.mute').click(function () {
        if ($(this).hasClass('enable')) {
            setVolume($(this).data('volume'));
            $(this).removeClass('enable');
        } else {
            $(this).data('volume', audio.volume).addClass('enable');
            setVolume(0);
        }
    });
    var switchTrack = function (i) {
        if (i < 0) {
            track = currentTrack = playlist.length - 1;
        } else if (i >= playlist.length) {
            track = currentTrack = 0;
        } else {
            track = i;
        }
        $('audio').remove();
        loadMusic(track);
        if (isPlaying == true) play();
    }
    var shufflePlay = function () {
        var time = new Date(), lastTrack = currentTrack;
        currentTrack = time.getTime() % playlist.length;
        if (lastTrack == currentTrack) ++currentTrack;
        switchTrack(currentTrack);
    }
    var ended = function () {
        pause();
        audio.currentTime = 0;
        playCounts++;
        if (continous == true) isPlaying = true;
        if (repeat == 1) {
            play();
        } else {
            if (shuffle === 'true') {
                shufflePlay();
            } else {
                if (repeat == 2) {
                    switchTrack(++currentTrack);
                } else {
                    if (currentTrack < playlist.length) switchTrack(++currentTrack);
                }
            }
        }
    }
    var beforeLoad = function () {
        var endVal = this.seekable && this.seekable.length ? this.seekable.end(0) : 0;
        $('.progress .loaded').css('width', (100 / (this.duration || 1) * endVal) + '%');
    }
    var afterLoad = function () {
        if (autoplay == true) play();
    }
    var loadMusic = function (i) {
        var item = playlist[i],
            newaudio = $('<audio>').html('<source src="' + item.mp3 + '"><source src="' + item.ogg + '">').appendTo('#player');
        $('.cover').html('<img src="' + item.cover + '" alt="' + item.album + '">');
        $('.tag').html('<strong>' + item.title + '</strong><span class="artist">' + item.artist + '</span><span class="album">' + item.album + '</span>');
        $('#playlist li').removeClass('playing').eq(i).addClass('playing');
        audio = newaudio[0];
        audio.volume = $('.mute').hasClass('enable') ? 0 : volume;
        audio.addEventListener('progress', beforeLoad, false);
        audio.addEventListener('durationchange', beforeLoad, false);
        audio.addEventListener('canplay', afterLoad, false);
        audio.addEventListener('ended', ended, false);
    }
    loadMusic(currentTrack);
    $('.playback').on('click', function () {
        if ($(this).hasClass('playing')) {
            pause();
        } else {
            play();
        }
    });
    $('.rewind').on('click', function () {
        if (shuffle === 'true') {
            shufflePlay();
        } else {
            switchTrack(--currentTrack);
        }
    });
    $('.fastforward').on('click', function () {
        if (shuffle === 'true') {
            shufflePlay();
        } else {
            switchTrack(++currentTrack);
        }
    });
    $('#playlist li').each(function (i) {
        var _i = i;
        $(this).on('click', function () {
            switchTrack(_i);
        });
    });
    if (shuffle === 'true') $('.shuffle').addClass('enable');
    if (repeat == 1) {
        $('.repeat').addClass('once');
    } else if (repeat == 2) {
        $('.repeat').addClass('all');
    }
    $('.repeat').on('click', function () {
        if ($(this).hasClass('once')) {
            repeat = localStorage.repeat = 2;
            $(this).removeClass('once').addClass('all');
        } else if ($(this).hasClass('all')) {
            repeat = localStorage.repeat = 0;
            $(this).removeClass('all');
        } else {
            repeat = localStorage.repeat = 1;
            $(this).addClass('once');
        }
    });
    $('.shuffle').on('click', function () {
        if ($(this).hasClass('enable')) {
            shuffle = localStorage.shuffle = 'false';
            $(this).removeClass('enable');
        } else {
            shuffle = localStorage.shuffle = 'true';
            $(this).addClass('enable');
        }
    });
})(jQuery);