package com.luocj.project.wanandroid.bean;

import java.io.Serializable;
import java.util.List;

public class HomeDetailBean  implements Serializable {

    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","author":"mylhyl","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"可配置扫描框、线样式 ，生成二维码（文字、联系人）","envelopePic":"http://www.wanandroid.com/blogimgs/6d3b8a9e-42d2-4d1f-a6e1-1f8d90128446.png","fresh":true,"id":3055,"link":"http://www.wanandroid.com/blog/show/2174","niceDate":"12小时前","origin":"","projectLink":"https://github.com/mylhyl/Android-Zxing","publishTime":1529853175000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=358"}],"title":"Android-Zxing 开源二维码项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xfhy","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"1. 我的毕业设计APP端,目前含有的主要功能如下:用户模块,知乎日报,小视频,新闻,天气,笑话,干货集中营.APP端是纯kotlin和组件化的.\r\n2. 我的毕业设计的服务器端: https://github.com/xfhy/LifeHelperServer  采用Spring Boot来进行的快速开发,数据库是mysql,目前有如下功能:收藏,评论,用户:增加,更新头像,签到等,产品,兴趣","envelopePic":"http://www.wanandroid.com/blogimgs/3d414bfe-7296-4695-98e3-ed0692bfc063.png","fresh":true,"id":3054,"link":"http://www.wanandroid.com/blog/show/2173","niceDate":"12小时前","origin":"","projectLink":"https://github.com/xfhy/LifeHelper","publishTime":1529853044000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=294"}],"title":"毕业设计(100%纯kotlin组件化开发)-LifeHelper","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"AWeiLoveAndroid","chapterId":375,"chapterName":"Flutter","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":3053,"link":"https://www.jianshu.com/p/2c9867e737a1","niceDate":"12小时前","origin":"","projectLink":"","publishTime":1529852866000,"superChapterId":375,"superChapterName":"Flutter","tags":[],"title":"Flutter学习总结系列----第一章、Flutter基础全面详解","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"天然鱼","chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":3052,"link":"https://www.jianshu.com/p/872dc6f89cb4","niceDate":"12小时前","origin":"","projectLink":"","publishTime":1529852753000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android打包之多版本、多环境、多渠道","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"泽毛","chapterId":249,"chapterName":"干货资源","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":3051,"link":"https://www.jianshu.com/p/fd82d18994ce","niceDate":"12小时前","origin":"","projectLink":"","publishTime":1529851599000,"superChapterId":249,"superChapterName":"干货资源","tags":[],"title":"Android 知识梳理目录 - 好吧，这是一个很&quot;干&quot;的标题","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"容华谢后","chapterId":373,"chapterName":"support-design","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":3050,"link":"https://www.jianshu.com/p/b0b54537ac44","niceDate":"12小时前","origin":"","projectLink":"","publishTime":1529850614000,"superChapterId":54,"superChapterName":"5.+高新技术","tags":[],"title":"Android Design Support Library v28 新增组件详解","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"石先","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":3048,"link":"https://www.jianshu.com/p/e664c16bca67","niceDate":"12小时前","origin":"","projectLink":"","publishTime":1529850358000,"superChapterId":191,"superChapterName":"热门专题","tags":[],"title":"Android 应用性能分析工具 &mdash; CPU Profiler","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"梦工厂","chapterId":321,"chapterName":"算法","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":3047,"link":"https://www.jianshu.com/p/ae97c3ceea8d","niceDate":"12小时前","origin":"","projectLink":"","publishTime":1529850325000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"排序算法总结","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Wing_Li","chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":3046,"link":"https://www.jianshu.com/p/533240d222d3","niceDate":"12小时前","origin":"","projectLink":"","publishTime":1529850301000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Gradle多渠道打包(动态设定App名称，应用图标，替换常量，更改包名，变更渠道)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"jessieeeee","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"一个高仿韩寒one一个的开源项目，所有接口全部来源于one一个android版4.3.4抓包获得，项目中使用的素材也是解压apk文件获得，此项目目前只对android进行了适配，ios目前尚未适配，项目结构并非标准的ReactNative项目结构，而是android原生项目结构引入ReactNative框架的混合开发结构。","envelopePic":"http://www.wanandroid.com/blogimgs/bf26da65-ea02-4117-9790-f4ec07a537c5.png","fresh":true,"id":3045,"link":"http://www.wanandroid.com/blog/show/2172","niceDate":"12小时前","origin":"","projectLink":"https://github.com/jessieeeee/SimpleOne","publishTime":1529850259000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=294"}],"title":"one一个高仿开源项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"momentslz","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"仿开眼视频Android客户端，本项目主要用来练手Google-MVP已及kotlin,对于急切想熟悉kotlin的童鞋来说是一个不错的练手项目。","envelopePic":"http://www.wanandroid.com/blogimgs/beb545fa-4a22-4cff-98eb-14358f54c289.png","fresh":true,"id":3044,"link":"http://www.wanandroid.com/blog/show/2171","niceDate":"13小时前","origin":"","projectLink":"https://github.com/momentslz/Eyepetizer","publishTime":1529850040000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=294"}],"title":"kotlin仿开眼视频Android客户端 Eyepetizer","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"thatnight","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"使用最原始的MVP框架，加上一大堆的第三方库，网页图片支持点击放大，支持换肤，谢谢大家支持！","envelopePic":"http://www.wanandroid.com/blogimgs/8786f1a1-e25f-480e-a547-be6dd3e58ad5.png","fresh":true,"id":3042,"link":"http://www.wanandroid.com/blog/show/2169","niceDate":"13小时前","origin":"","projectLink":"https://github.com/thatnight/WanAndroid","publishTime":1529849893000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=294"}],"title":"WanAndroid 酷安Java版","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"jenly1314","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"高仿全民直播（全民TV），项目采用 MVP + RXJava + Retrofit + OKHttp + Material Design + Dagger2 + Base + Glide + GreenDao构建。","envelopePic":"http://www.wanandroid.com/blogimgs/362fdda5-f08f-4cfc-beb5-7a4495b2c14f.png","fresh":true,"id":3040,"link":"http://www.wanandroid.com/blog/show/2167","niceDate":"13小时前","origin":"","projectLink":"https://github.com/jenly1314/KingTV","publishTime":1529849767000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=294"}],"title":"高仿全民直播（全民TV）","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"尘封的落叶","chapterId":262,"chapterName":"SDK开发","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3039,"link":"https://www.jianshu.com/p/4d092c915ef1","niceDate":"1天前","origin":"","projectLink":"","publishTime":1529741359000,"superChapterId":191,"superChapterName":"热门专题","tags":[],"title":"AndroidStudio封装SDK的那些事","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"wisedeveloper","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"练手小项目,WanAndroid客户端Java版,\r\n技术架构:MVP + okhttp-OkGo + RxJava2 + Glide","envelopePic":"http://www.wanandroid.com/blogimgs/6943d423-e68e-482e-b35d-5dc777bc3afa.png","fresh":false,"id":3037,"link":"http://www.wanandroid.com/blog/show/2166","niceDate":"2天前","origin":"","projectLink":"https://github.com/wisedeveloper/WanAndroid","publishTime":1529657049000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=294"}],"title":"WanAndroid客户端Java版","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"jenly1314","chapterId":323,"chapterName":"动画","collect":false,"courseId":13,"desc":"GiftSurfaceView 最初出自于2014年开发HalloStar项目时所写，主要用于HalloStar项目直播间的送礼物动画。现在想来，那夕阳下的奔跑，是我逝去的青春。","envelopePic":"http://www.wanandroid.com/blogimgs/63360c5d-52a6-47a4-b51b-dde95616ecc8.png","fresh":false,"id":3036,"link":"http://www.wanandroid.com/blog/show/2165","niceDate":"2天前","origin":"","projectLink":"https://github.com/jenly1314/GiftSurfaceView","publishTime":1529656806000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=323"}],"title":"GiftSurfaceView 直播间送礼物动画","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Loren1994","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"支持到android8.0,简单小巧.希望对你有帮助.","envelopePic":"http://www.wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":3034,"link":"http://www.wanandroid.com/blog/show/2163","niceDate":"2天前","origin":"","projectLink":"https://github.com/Loren1994/AndroidUpdate","publishTime":1529656524000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=358"}],"title":"android小巧的升级库","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Loren1994","chapterId":314,"chapterName":"RV列表动效","collect":false,"courseId":13,"desc":"这是封装的带分类Recyclerview的Adapter，主要解决项目中分类列表繁琐的重复劳动。\r\n\r\n","envelopePic":"http://www.wanandroid.com/blogimgs/879cffaa-97d6-456b-bf9b-b7e6a176cf0e.png","fresh":false,"id":3033,"link":"http://www.wanandroid.com/blog/show/2162","niceDate":"2天前","origin":"","projectLink":"https://github.com/Loren1994/UniversalTypeRecyclerView","publishTime":1529656448000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=314"}],"title":"封装带分类的RecyclerViewAdapter UniversalTypeRecyclerView","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"拉丁吴","chapterId":261,"chapterName":"屏幕适配","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3032,"link":"https://www.jianshu.com/p/a4b8e4c5d9b0","niceDate":"2天前","origin":"","projectLink":"","publishTime":1529653793000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"Android 稳定和高效的UI适配方案","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"prototypez","chapterId":198,"chapterName":"基础概念","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3031,"link":"http://prototypez.github.io/2018/06/06/using-save-state/","niceDate":"2天前","origin":"","projectLink":"","publishTime":1529653215000,"superChapterId":168,"superChapterName":"基础知识","tags":[],"title":"不需要再手写 onSaveInstanceState 了，因为你的时间非常值钱","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":false,"pageCount":70,"size":20,"total":1387}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"apkLink":"","author":"mylhyl","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"可配置扫描框、线样式 ，生成二维码（文字、联系人）","envelopePic":"http://www.wanandroid.com/blogimgs/6d3b8a9e-42d2-4d1f-a6e1-1f8d90128446.png","fresh":true,"id":3055,"link":"http://www.wanandroid.com/blog/show/2174","niceDate":"12小时前","origin":"","projectLink":"https://github.com/mylhyl/Android-Zxing","publishTime":1529853175000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=358"}],"title":"Android-Zxing 开源二维码项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xfhy","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"1. 我的毕业设计APP端,目前含有的主要功能如下:用户模块,知乎日报,小视频,新闻,天气,笑话,干货集中营.APP端是纯kotlin和组件化的.\r\n2. 我的毕业设计的服务器端: https://github.com/xfhy/LifeHelperServer  采用Spring Boot来进行的快速开发,数据库是mysql,目前有如下功能:收藏,评论,用户:增加,更新头像,签到等,产品,兴趣","envelopePic":"http://www.wanandroid.com/blogimgs/3d414bfe-7296-4695-98e3-ed0692bfc063.png","fresh":true,"id":3054,"link":"http://www.wanandroid.com/blog/show/2173","niceDate":"12小时前","origin":"","projectLink":"https://github.com/xfhy/LifeHelper","publishTime":1529853044000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=294"}],"title":"毕业设计(100%纯kotlin组件化开发)-LifeHelper","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"AWeiLoveAndroid","chapterId":375,"chapterName":"Flutter","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":3053,"link":"https://www.jianshu.com/p/2c9867e737a1","niceDate":"12小时前","origin":"","projectLink":"","publishTime":1529852866000,"superChapterId":375,"superChapterName":"Flutter","tags":[],"title":"Flutter学习总结系列----第一章、Flutter基础全面详解","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"天然鱼","chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":3052,"link":"https://www.jianshu.com/p/872dc6f89cb4","niceDate":"12小时前","origin":"","projectLink":"","publishTime":1529852753000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android打包之多版本、多环境、多渠道","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"泽毛","chapterId":249,"chapterName":"干货资源","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":3051,"link":"https://www.jianshu.com/p/fd82d18994ce","niceDate":"12小时前","origin":"","projectLink":"","publishTime":1529851599000,"superChapterId":249,"superChapterName":"干货资源","tags":[],"title":"Android 知识梳理目录 - 好吧，这是一个很&quot;干&quot;的标题","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"容华谢后","chapterId":373,"chapterName":"support-design","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":3050,"link":"https://www.jianshu.com/p/b0b54537ac44","niceDate":"12小时前","origin":"","projectLink":"","publishTime":1529850614000,"superChapterId":54,"superChapterName":"5.+高新技术","tags":[],"title":"Android Design Support Library v28 新增组件详解","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"石先","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":3048,"link":"https://www.jianshu.com/p/e664c16bca67","niceDate":"12小时前","origin":"","projectLink":"","publishTime":1529850358000,"superChapterId":191,"superChapterName":"热门专题","tags":[],"title":"Android 应用性能分析工具 &mdash; CPU Profiler","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"梦工厂","chapterId":321,"chapterName":"算法","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":3047,"link":"https://www.jianshu.com/p/ae97c3ceea8d","niceDate":"12小时前","origin":"","projectLink":"","publishTime":1529850325000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"排序算法总结","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Wing_Li","chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":3046,"link":"https://www.jianshu.com/p/533240d222d3","niceDate":"12小时前","origin":"","projectLink":"","publishTime":1529850301000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Gradle多渠道打包(动态设定App名称，应用图标，替换常量，更改包名，变更渠道)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"jessieeeee","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"一个高仿韩寒one一个的开源项目，所有接口全部来源于one一个android版4.3.4抓包获得，项目中使用的素材也是解压apk文件获得，此项目目前只对android进行了适配，ios目前尚未适配，项目结构并非标准的ReactNative项目结构，而是android原生项目结构引入ReactNative框架的混合开发结构。","envelopePic":"http://www.wanandroid.com/blogimgs/bf26da65-ea02-4117-9790-f4ec07a537c5.png","fresh":true,"id":3045,"link":"http://www.wanandroid.com/blog/show/2172","niceDate":"12小时前","origin":"","projectLink":"https://github.com/jessieeeee/SimpleOne","publishTime":1529850259000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=294"}],"title":"one一个高仿开源项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"momentslz","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"仿开眼视频Android客户端，本项目主要用来练手Google-MVP已及kotlin,对于急切想熟悉kotlin的童鞋来说是一个不错的练手项目。","envelopePic":"http://www.wanandroid.com/blogimgs/beb545fa-4a22-4cff-98eb-14358f54c289.png","fresh":true,"id":3044,"link":"http://www.wanandroid.com/blog/show/2171","niceDate":"13小时前","origin":"","projectLink":"https://github.com/momentslz/Eyepetizer","publishTime":1529850040000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=294"}],"title":"kotlin仿开眼视频Android客户端 Eyepetizer","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"thatnight","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"使用最原始的MVP框架，加上一大堆的第三方库，网页图片支持点击放大，支持换肤，谢谢大家支持！","envelopePic":"http://www.wanandroid.com/blogimgs/8786f1a1-e25f-480e-a547-be6dd3e58ad5.png","fresh":true,"id":3042,"link":"http://www.wanandroid.com/blog/show/2169","niceDate":"13小时前","origin":"","projectLink":"https://github.com/thatnight/WanAndroid","publishTime":1529849893000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=294"}],"title":"WanAndroid 酷安Java版","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"jenly1314","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"高仿全民直播（全民TV），项目采用 MVP + RXJava + Retrofit + OKHttp + Material Design + Dagger2 + Base + Glide + GreenDao构建。","envelopePic":"http://www.wanandroid.com/blogimgs/362fdda5-f08f-4cfc-beb5-7a4495b2c14f.png","fresh":true,"id":3040,"link":"http://www.wanandroid.com/blog/show/2167","niceDate":"13小时前","origin":"","projectLink":"https://github.com/jenly1314/KingTV","publishTime":1529849767000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=294"}],"title":"高仿全民直播（全民TV）","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"尘封的落叶","chapterId":262,"chapterName":"SDK开发","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3039,"link":"https://www.jianshu.com/p/4d092c915ef1","niceDate":"1天前","origin":"","projectLink":"","publishTime":1529741359000,"superChapterId":191,"superChapterName":"热门专题","tags":[],"title":"AndroidStudio封装SDK的那些事","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"wisedeveloper","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"练手小项目,WanAndroid客户端Java版,\r\n技术架构:MVP + okhttp-OkGo + RxJava2 + Glide","envelopePic":"http://www.wanandroid.com/blogimgs/6943d423-e68e-482e-b35d-5dc777bc3afa.png","fresh":false,"id":3037,"link":"http://www.wanandroid.com/blog/show/2166","niceDate":"2天前","origin":"","projectLink":"https://github.com/wisedeveloper/WanAndroid","publishTime":1529657049000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=294"}],"title":"WanAndroid客户端Java版","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"jenly1314","chapterId":323,"chapterName":"动画","collect":false,"courseId":13,"desc":"GiftSurfaceView 最初出自于2014年开发HalloStar项目时所写，主要用于HalloStar项目直播间的送礼物动画。现在想来，那夕阳下的奔跑，是我逝去的青春。","envelopePic":"http://www.wanandroid.com/blogimgs/63360c5d-52a6-47a4-b51b-dde95616ecc8.png","fresh":false,"id":3036,"link":"http://www.wanandroid.com/blog/show/2165","niceDate":"2天前","origin":"","projectLink":"https://github.com/jenly1314/GiftSurfaceView","publishTime":1529656806000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=323"}],"title":"GiftSurfaceView 直播间送礼物动画","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Loren1994","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"支持到android8.0,简单小巧.希望对你有帮助.","envelopePic":"http://www.wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":3034,"link":"http://www.wanandroid.com/blog/show/2163","niceDate":"2天前","origin":"","projectLink":"https://github.com/Loren1994/AndroidUpdate","publishTime":1529656524000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=358"}],"title":"android小巧的升级库","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Loren1994","chapterId":314,"chapterName":"RV列表动效","collect":false,"courseId":13,"desc":"这是封装的带分类Recyclerview的Adapter，主要解决项目中分类列表繁琐的重复劳动。\r\n\r\n","envelopePic":"http://www.wanandroid.com/blogimgs/879cffaa-97d6-456b-bf9b-b7e6a176cf0e.png","fresh":false,"id":3033,"link":"http://www.wanandroid.com/blog/show/2162","niceDate":"2天前","origin":"","projectLink":"https://github.com/Loren1994/UniversalTypeRecyclerView","publishTime":1529656448000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"tixi","url":"/project/list/1?cid=314"}],"title":"封装带分类的RecyclerViewAdapter UniversalTypeRecyclerView","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"拉丁吴","chapterId":261,"chapterName":"屏幕适配","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3032,"link":"https://www.jianshu.com/p/a4b8e4c5d9b0","niceDate":"2天前","origin":"","projectLink":"","publishTime":1529653793000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"Android 稳定和高效的UI适配方案","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"prototypez","chapterId":198,"chapterName":"基础概念","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3031,"link":"http://prototypez.github.io/2018/06/06/using-save-state/","niceDate":"2天前","origin":"","projectLink":"","publishTime":1529653215000,"superChapterId":168,"superChapterName":"基础知识","tags":[],"title":"不需要再手写 onSaveInstanceState 了，因为你的时间非常值钱","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : false
         * pageCount : 70
         * size : 20
         * total : 1387
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * apkLink :
             * author : mylhyl
             * chapterId : 358
             * chapterName : 项目基础功能
             * collect : false
             * courseId : 13
             * desc : 可配置扫描框、线样式 ，生成二维码（文字、联系人）
             * envelopePic : http://www.wanandroid.com/blogimgs/6d3b8a9e-42d2-4d1f-a6e1-1f8d90128446.png
             * fresh : true
             * id : 3055
             * link : http://www.wanandroid.com/blog/show/2174
             * niceDate : 12小时前
             * origin :
             * projectLink : https://github.com/mylhyl/Android-Zxing
             * publishTime : 1529853175000
             * superChapterId : 294
             * superChapterName : 开源项目主Tab
             * tags : [{"name":"tixi","url":"/project/list/1?cid=358"}]
             * title : Android-Zxing 开源二维码项目
             * type : 0
             * userId : -1
             * visible : 1
             * zan : 0
             */

            private String apkLink;
            private String author;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private String projectLink;
            private long publishTime;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<TagsBean> tags;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public static class TagsBean {
                /**
                 * name : tixi
                 * url : /project/list/1?cid=358
                 */

                private String name;
                private String url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                @Override
                public String toString() {
                    return "TagsBean{" +
                            "name='" + name + '\'' +
                            ", url='" + url + '\'' +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "DatasBean{" +
                        "apkLink='" + apkLink + '\'' +
                        ", author='" + author + '\'' +
                        ", chapterId=" + chapterId +
                        ", chapterName='" + chapterName + '\'' +
                        ", collect=" + collect +
                        ", courseId=" + courseId +
                        ", desc='" + desc + '\'' +
                        ", envelopePic='" + envelopePic + '\'' +
                        ", fresh=" + fresh +
                        ", id=" + id +
                        ", link='" + link + '\'' +
                        ", niceDate='" + niceDate + '\'' +
                        ", origin='" + origin + '\'' +
                        ", projectLink='" + projectLink + '\'' +
                        ", publishTime=" + publishTime +
                        ", superChapterId=" + superChapterId +
                        ", superChapterName='" + superChapterName + '\'' +
                        ", title='" + title + '\'' +
                        ", type=" + type +
                        ", userId=" + userId +
                        ", visible=" + visible +
                        ", zan=" + zan +
                        ", tags=" + tags +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "curPage=" + curPage +
                    ", offset=" + offset +
                    ", over=" + over +
                    ", pageCount=" + pageCount +
                    ", size=" + size +
                    ", total=" + total +
                    ", datas=" + datas +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "HomeDetailBean{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
