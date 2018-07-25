(function (window, $, document) {
    $('.h-ul li:first-child').mouseover(function () {
        $('.h-hidden').show();
    });
    $('.header').mouseleave(function () {
        $('.h-hidden').hide();
    });
}(window, jQuery, document));