package com.luocj.project.wanandroid.bean;

import java.util.List;

/**
 *
 * 收藏列表
 */

public class CollectBean {

    /**
     * data : {"curPage":1,"datas":[{"author":"tonnyl","chapterId":257,"chapterName":"Span","courseId":13,"desc":"","envelopePic":"","id":28740,"link":"https://tonnyl.github.io/Spantastic-Text-Styling-With-Spans/","niceDate":"19小时前","origin":"","originId":3287,"publishTime":1540189689000,"title":"探索 Android 中的 Span","userId":8084,"visible":0,"zan":0},{"author":"小编","chapterId":360,"chapterName":"小编发布","courseId":13,"desc":"","envelopePic":"","id":28504,"link":"http://www.wanandroid.com/wxarticle/list/408/1","niceDate":"2018-10-19","origin":"","originId":5853,"publishTime":1539932028000,"title":"新功能 | 公众号文章列表强势上线","userId":8084,"visible":0,"zan":0},{"author":"锐心凌志","chapterId":70,"chapterName":"retrofit","courseId":13,"desc":"","envelopePic":"","id":28278,"link":"https://www.jianshu.com/p/07794cb4972a","niceDate":"2018-10-18","origin":"","originId":5855,"publishTime":1539824633000,"title":"观战Retrofit开发中的哪点事","userId":8084,"visible":0,"zan":0}],"offset":0,"over":true,"pageCount":1,"size":20,"total":3}
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
         * datas : [{"author":"tonnyl","chapterId":257,"chapterName":"Span","courseId":13,"desc":"","envelopePic":"","id":28740,"link":"https://tonnyl.github.io/Spantastic-Text-Styling-With-Spans/","niceDate":"19小时前","origin":"","originId":3287,"publishTime":1540189689000,"title":"探索 Android 中的 Span","userId":8084,"visible":0,"zan":0},{"author":"小编","chapterId":360,"chapterName":"小编发布","courseId":13,"desc":"","envelopePic":"","id":28504,"link":"http://www.wanandroid.com/wxarticle/list/408/1","niceDate":"2018-10-19","origin":"","originId":5853,"publishTime":1539932028000,"title":"新功能 | 公众号文章列表强势上线","userId":8084,"visible":0,"zan":0},{"author":"锐心凌志","chapterId":70,"chapterName":"retrofit","courseId":13,"desc":"","envelopePic":"","id":28278,"link":"https://www.jianshu.com/p/07794cb4972a","niceDate":"2018-10-18","origin":"","originId":5855,"publishTime":1539824633000,"title":"观战Retrofit开发中的哪点事","userId":8084,"visible":0,"zan":0}]
         * offset : 0
         * over : true
         * pageCount : 1
         * size : 20
         * total : 3
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

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
             * author : tonnyl
             * chapterId : 257
             * chapterName : Span
             * courseId : 13
             * desc :
             * envelopePic :
             * id : 28740
             * link : https://tonnyl.github.io/Spantastic-Text-Styling-With-Spans/
             * niceDate : 19小时前
             * origin :
             * originId : 3287
             * publishTime : 1540189689000
             * title : 探索 Android 中的 Span
             * userId : 8084
             * visible : 0
             * zan : 0
             */

            private String author;
            private int chapterId;
            private String chapterName;
            private int courseId;
            private String desc;
            private String envelopePic;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private int originId;
            private long publishTime;
            private String title;
            private int userId;
            private int visible;
            private int zan;

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

            public int getOriginId() {
                return originId;
            }

            public void setOriginId(int originId) {
                this.originId = originId;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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

            @Override
            public String toString() {
                return "DatasBean{" +
                        "author='" + author + '\'' +
                        ", chapterId=" + chapterId +
                        ", chapterName='" + chapterName + '\'' +
                        ", courseId=" + courseId +
                        ", desc='" + desc + '\'' +
                        ", envelopePic='" + envelopePic + '\'' +
                        ", id=" + id +
                        ", link='" + link + '\'' +
                        ", niceDate='" + niceDate + '\'' +
                        ", origin='" + origin + '\'' +
                        ", originId=" + originId +
                        ", publishTime=" + publishTime +
                        ", title='" + title + '\'' +
                        ", userId=" + userId +
                        ", visible=" + visible +
                        ", zan=" + zan +
                        '}';
            }
        }
    }
}
