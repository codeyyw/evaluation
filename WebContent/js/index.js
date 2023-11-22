$(function () {
    var mySwiper = new Swiper (".swiper-container", {
        autoplay:{
            stopOnLastSlide:false,
            delay:3000,
            disableOnInteraction: false,
        },
        pagination:{
            el:'.swiper-pagination',
            clickable:true,
        },
        effect:'fade',
        loop : true,
        speed: 2000,
        updateOnImagesReady : true,
        touchRatio:1.3,
        followFinger : false,
    })
})
