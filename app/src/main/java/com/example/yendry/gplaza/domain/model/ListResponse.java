
package com.example.yendry.gplaza.domain.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListResponse {

    @SerializedName("page")
    @Expose
    private long page;
    @SerializedName("per_page")
    @Expose
    private long perPage;
    @SerializedName("total")
    @Expose
    private long total;
    @SerializedName("total_pages")
    @Expose
    private long totalPages;
    @SerializedName("data")
    @Expose
    private List<User> data = null;

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getPerPage() {
        return perPage;
    }

    public void setPerPage(long perPage) {
        this.perPage = perPage;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

}
