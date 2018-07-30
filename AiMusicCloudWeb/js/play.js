var comments = [];
// {username: '石俊涵', content: '我爱听歌'},
// {username: '黄仁宇', content: '我很漂亮'},
// {username: '王嘉佳', content: '我爱学习'},
// {username: '豆芬', content: 'tao 我最喜欢了'}
var statiHtml = '';

function addHtml(domHtml, className) {

    comments.map(function (value, i) {
        if (comments.length !== 0) {
            $('.' + className).addClass('comment-list');
        }
        var timeString = updateTimeString(value);
        // console.log(value);
        domHtml += '<div class="comment">' +
            '<div class="comment-user"> ' +
            '    <!--<span>{this.props.comment.username} </span>：--> ' +
            '    <span class="comment-username  ">' + value.username + ':</span> ' +
            '</div> ' +
            '<!--<p>{this.props.comment.content}</p>--> ' +
            '    <p>' + value.content + '</p> ' +
            ' <span class="comment-createdtime">\n' + timeString +
            // '                {this.state.timeString}\n' +
            '                </span>' +
            '                <span' +
            // '                    onClick={this.handleDeleteComment.bind(this)}\n' +
            '                    class="comment-delete"' +
            'onclick="deleteComment(' + i + ')">' +
            '                删除' +
            '                </span>' +
            '</div>'
    });

    // console.log(domHtml)
    $('.comment-list').html(domHtml);
    if (comments.length === 0) {
        $('.' + className).removeClass('comment-list');
    }

}

function deleteComment(i) {
    comments.splice(i, 1);
    saveComments(comments);
    addHtml(statiHtml, "comment-list2");

}

function saveComments(comments) {
    localStorage.setItem('comments', JSON.stringify(comments));
}

function getComments() {
    var storageComments = localStorage.getItem('comments')
    if (storageComments) {
        comments = JSON.parse(storageComments)// this.setState({ comments })
        // return comments;
        // var _timer = setInterval(addHtml(statiHtml, 'comment-list2'), 5000);
        setInterval('addHtml(statiHtml, "comment-list2")', 5000)
        addHtml(statiHtml, 'comment-list2');


    }
}

function updateTimeString(comment) {
    if (!comment.createdTime) {
        comment.createdTime = new Date().getTime();
    }
    var duration = (new Date().getTime() - comment.createdTime) / 1000;
    console.log(duration);
    // var timeString;
    // switch (duration) {
    //     case (duration >= 60 && duration < 3600):
    //          timeString = Math.round(duration / 60) + '分钟前';
    //         console.log(2)
    //         break;
    //     case (duration >= 3600 && duration < 86400) :
    //          timeString = Math.round(duration / 3600) + '小时前';
    //         console.log(3)
    //         break;
    //     case (duration > 86400):
    //          timeString = Math.round(duration / 86400) + '天前';
    //         console.log(4)
    //         break;
    //     case (duration >= 0 && duration < 60):
    //          timeString = Math.round(Math.max(duration, 1)) + '秒前';
    //         console.log(5)
    //         break;
    //     default:
    //         console.log('a');
    //         break;
    //
    // }
    var timeString;
    if (duration >= 0 && duration < 60){
         timeString = Math.round(Math.max(duration, 1)) + '秒前';
    }else if(duration >= 60 && duration < 3600){
         timeString = Math.round(duration / 60) + '分钟前';
    }else if(duration >= 3600 && duration < 86400){
        timeString = Math.round(duration / 3600) + '小时前';
    }else if(duration > 86400){
        timeString = Math.round(duration / 86400) + '天前';
    }else {
        console.log('时间判断错误！');
    }

    // timeString = duration > 60 ? Math.round(duration / 60) + '分钟前' : Math.round(Math.max(duration, 1)) + '秒前';
        console.log(timeString);
    return timeString;
}

// addHtml(statiHtml,'comment-list2');


(function ($) {
    $('.comment-field-button button').click(function () {
        var comment = {};
        var html = '';

        // console.log($('.comment-input-user input').val());
        comment.username = $('.comment-input-user input').val();
        comment.content = $('.comment-input-content textarea').val();
        $('.comment-input-content textarea').val('');
        comment.createdTime = new Date().getTime();
        console.log(comment)
        if (!comment.username) {
            alert('请输入用户名!');
            return;
        }
        if (!comment.content) {
            alert('请输入评论内容!')
            $('.comment-input-content textarea').focus();
            return;
        }
        comments.push(comment);
        saveComments(comments);
        $('.comment-input-content textarea').focus();
        // console.log(comments);
        addHtml(html, 'comment-list2');
        // comment = {};
// console.log(comments);
//         comments.map(function (value) {
//             $('.comment-list2').addClass('comment-list');
//             // console.log(value);
//             html += '<div class="comment">' +
//                 '<div class="comment-user"> ' +
//                 '    <!--<span>{this.props.comment.username} </span>：--> ' +
//                 '    <span>' + value.username + '</span> : ' +
//                 '</div> ' +
//                 '<!--<p>{this.props.comment.content}</p>--> ' +
//                 '    <p>' + value.content + '</p> ' +
//                 ' <span class="comment-createdtime">\n' +
//                 '                {this.state.timeString}\n' +
//                 '                </span>' +
//                 '                <span' +
//                 // '                    onClick={this.handleDeleteComment.bind(this)}\n' +
//                 '                    class="comment-delete">\n' +
//                 '                删除' +
//                 '                </span>' +
//
//                 '</div>'
//         });
//         $('.comment-list').html(html);
    });

    $('.comment-input-user input').blur(function () {
        var userName = $('.comment-input-user input').val();
        localStorage.setItem('userName', userName);
    });


    // console.log(comments);
}(jQuery));
window.onload = function () {
    var userName = localStorage.getItem('userName');
    console.log(userName);
    $('.comment-input-user input').val(userName);
    $('.comment-input-content textarea').focus();
    getComments();
};
