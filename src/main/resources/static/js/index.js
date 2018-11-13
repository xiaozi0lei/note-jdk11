$(function () {
    ////// 分页
    // 首页
    $("#homePage").click(function () {
        window.location.href = "/";
    });
    // 上一页
    $("#previousPage").click(function () {
        if (isFirstPage === true) {
            // 第一页
            window.location.href = "/index?pageNum=1";
        } else {
            // 不是第一页
            window.location.href = "/index?pageNum=" + previousPage;
        }
    });
    // 下一页
    $("#nextPage").click(function () {
        if (isLastPage === true) {
            // 最后一页
            window.location.href = "/index?pageNum=" + lastPage;
        } else {
            // 不是最后一页
            window.location.href = "/index?pageNum=" + nextPage;
        }
    });
    // 最后一页
    $("#lastPage").click(function () {
        window.location.href = "/index?pageNum=" + lastPage;
    });
});
