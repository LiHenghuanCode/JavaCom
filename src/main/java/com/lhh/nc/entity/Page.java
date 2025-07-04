package com.lhh.nc.entity;

public class Page {
    // 当前页码
    private int currentPage = 1;
    // 显示上限
    private int limit = 10;
    // 数据总数(用于计算总页数)
    private int totalPosts;
    // 查询路径(用于复用分页链接)
    private String path;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if(currentPage > 1){
            this.currentPage = currentPage;
        }

    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(int totalPosts) {
        if (totalPosts >= 0) {
            this.totalPosts= totalPosts;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getOffset() {
        // current * limit - limit
        return (currentPage - 1) * limit;
    }

    public int getTotalPages(){
        if (totalPosts % limit == 0) {
            return totalPosts/ limit;
        } else {
            return totalPosts / limit + 1;
        }
    }

    public int getFrom() {
        int from = currentPage - 2;
        return from < 1 ? 1 : from;
    }

    /**
     * 获取结束页码
     *
     * @return
     */
    public int getTo() {
        int to = currentPage + 2;
        int total = getTotalPages();
        return to > total ? total : to;
    }
}
