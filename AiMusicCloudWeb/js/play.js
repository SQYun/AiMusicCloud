var comments = [
    {username:'石俊涵',content:'我爱听歌'},
    {username:'黄仁宇',content:'我很漂亮'},
    {username:'王嘉佳',content:'我爱学习'},
    {username:'豆芬',content:'tao 我最喜欢了'}
    ];
var statiHtml= '';
comments.map(function (value) {
    $('.comment-list2').addClass('comment-list');
    // console.log(value);
    statiHtml += '<div class="comment">' +
        '<div class="comment-user"> ' +
        '    <!--<span>{this.props.comment.username} </span>：--> ' +
        '    <span>'+value.username+'</span> ' +
        '</div> ' +
        '<!--<p>{this.props.comment.content}</p>--> ' +
        '    <p>'+value.content+'</p> ' +
        '</div>'
});
$('.comment-list').html(statiHtml);

(function ($) {
    $('.comment-field-button button').click(function () {
        var comment = {};
        var html = '';

        // console.log($('.comment-input-user input').val());
        comment.username = $('.comment-input-user input').val();
        comment.content = $('.comment-input-content textarea').val();

        comments.push(comment);
        console.log(comments);
        // comment = {};
// console.log(comments);
        comments.map(function (value) {
            $('.comment-list2').addClass('comment-list');
            // console.log(value);
            html += '<div class="comment">' +
                        '<div class="comment-user"> ' +
                        '    <!--<span>{this.props.comment.username} </span>：--> ' +
                        '    <span>'+value.username+'</span> ' +
                        '</div> ' +
                        '<!--<p>{this.props.comment.content}</p>--> ' +
                        '    <p>'+value.content+'</p> ' +
                    '</div>'
        });
        $('.comment-list').html(html);

    });
    // console.log(comments);
}(jQuery));
