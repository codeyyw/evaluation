$(function () {
    //头部关闭以及显示
    $('.navbar-toggle .navbar-show').on('click',function () {
        $(this).hide().siblings().show();
        $('body').addClass('open');
        $('.main-content').css('left','250px');
        $('.popup-bg').toggleClass('popup-show');
        $('.main-content').on('touchmove',function (e) {
            e.preventDefault();
        })
    })

    $('.popup-bg').on('click',function () {
        $('.navbar-toggle .navbar-close').hide().siblings().show();
        $('body').removeClass('open');
        $('.main-content').css('left','0');
        $(this).toggleClass('popup-show');
        $('.main-content').off('touchmove');
    })

    $('.mobile-nav >li').on('click',function () {
        $(this).toggleClass('active');
        if ($(this).hasClass('active') && $(this).children('.main').hasClass('hassub')){
            $(this).children('.more').show();
        }else{
            $(this).children('.more').hide();
        }
    })

    var winH=$(window).height();
    $(window).scroll(function () {
        if($(window).scrollTop()>=winH+100){
            $(".header .navbar-notmobile").addClass("header-slide");
        }else {
            $(".header .navbar-notmobile").removeClass("header-slide");
        }
    })

    /*function IsPC() {
        var userAgentInfo = navigator.userAgent;
        var Agents = ["Android", "iPhone",
            "SymbianOS", "Windows Phone",
            "iPad", "iPod"];
        var flag = true;
        for (var v = 0; v < Agents.length; v++) {
            if (userAgentInfo.indexOf(Agents[v]) > 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    var flag = IsPC(); //true为PC端，false为手机端*/

    /*$("img.lazy").lazyload({
        effect:'fadeIn',
        threshold:30,
        failure_limit:10,
    })*/
})
