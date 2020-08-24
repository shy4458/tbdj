package com.sx.model.erFragmentModel;

import java.util.List;

public class RecommendBean {


    private List<VideoListBean> videoList;

    public List<VideoListBean> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<VideoListBean> videoList) {
        this.videoList = videoList;
    }

    public static class VideoListBean {
        /**
         * po : 0
         * url :
         * bofang : 10000
         * sj : 1:50
         * pic :
         * name : 谭林杰
         * title : 豪车
         * zan : 9999
         * pinglun : 500
         */

        private String po;
        private String url;
        private String bofang;
        private String sj;
        private String pic;
        private String name;
        private String title;
        private String zan;
        private String pinglun;

        public String getPo() {
            return po;
        }

        public void setPo(String po) {
            this.po = po;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getBofang() {
            return bofang;
        }

        public void setBofang(String bofang) {
            this.bofang = bofang;
        }

        public String getSj() {
            return sj;
        }

        public void setSj(String sj) {
            this.sj = sj;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getZan() {
            return zan;
        }

        public void setZan(String zan) {
            this.zan = zan;
        }

        public String getPinglun() {
            return pinglun;
        }

        public void setPinglun(String pinglun) {
            this.pinglun = pinglun;
        }
    }
}
