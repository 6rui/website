// var config = {
//     // after: '0s',
//     // enter: 'bottom',
//     // move: '50px',
//     // over: '0.5s',
//     // easing: 'ease-in-out',
//     // viewportFactor:.5,
//     reset: false,
//     init: false,
//     viewFactor : 0.15,
//     duration   : 800,
//     distance   : "0px",
//     scale      : 0.8,
// };
// scrollreveal   http://www.ui3g.com/code/uicode-1626.html
var scrollAni = function () {
    (function () {
        var config = {
            viewFactor: 0.15,
            distance: "0px",
            scale: 0.8,
            reset: false,
            init: false
        };
        window.sr = new ScrollReveal(config)
    })();
    var block = {
//        origin: "bottom",//动画的方向
        reset: false,//元素是否在容器边界内来回滚动时都产生动画效果
        duration: 1000,//动画持续时间
        viewOffset: {top: 64}//增加viewport或容器边界，单位像素
    };
    sr.reveal(".ani", block);
};

// 概况和尾部
$("#surveyContent").html('' +
    '<ul class="clearFloat">' +
    '<li class="list">' +
    '<ul>' +
    '<li><a href="#" class="title">产品中心</a></li>' +
    '<li><a href="#">集成装备</a></li>' +
    '<li><a href="#">车载装备</a></li>' +
    '<li><a href="#">智能图像</a></li>' +
    '<li><a href="#">反制装备</a></li>' +
    '<li><a href="#">情报信息</a></li>' +
    '<li><a href="#">信息安全</a></li>' +
    '<li><a href="#">特种侦察</a></li>' +
    '<li><a href="#">指挥调度</a></li>' +
    '<li><a href="#">单警装备</a></li>' +
    '<li><a href="#">家居安防</a></li>' +
    '</ul>' +
    '</li>' +
    '<li class="list">' +
    '<ul>' +
    '<li><a href="#" class="title">应用案例</a></li>' +
    '<li><a href="#">G20</a></li>' +
    '<li><a href="#">车载装备</a></li>' +
    '<li><a href="#">智能图像</a></li>' +
    '</ul>' +
    '</li>' +
    '<li class="list">' +
    '<ul>' +
    '<li><a href="#" class="title">新闻动态</a></li>' +
    '<li><a href="#">公司动态</a></li>' +
    '<li><a href="#">媒体报道</a></li>' +
    '<li><a href="../html/publishNews-login.html" target="_blank">新闻发布</a></li>' +
    '</ul>' +
    '</li>' +
    '<li class="list">' +
    '<ul>' +
    '<li><a href="#" class="title">关于我们</a></li>' +
    '<li><a href="#">公司简介</a></li>' +
    '<li><a href="#">联系方式</a></li>' +
    '</ul>' +
    '</li>' +
    '<li class="list" style="margin-right: 0">' +
    '<ul>' +
    '<li class="title">联系我们</li>' +
    '<li>028-61831693</li>' +
    '<li>四川省成都市高新区（西区）西源大道2006号</li>' +
    '</ul>' +
    '</li>' +
    '</ul>');

// 尾部
$("#footerContent").html('<div>' +
    '©2017-2018 scdkay. All Rights Reserved. 四川省电科公共安全技术研究有限公司' +
    '</div>' +
    '<div>川ICP备15000892号-1 | 川ICP备15000892号-2</div>');
