$(function () {

    // 笔记 markdown 预览
    $("#previewButton").click(function () {
        var content = $("#content").val();
        var markdown_content = gfmMarkdown(content);

        if (markdown_content === "error") {
            markdown_content = markdown.toHTML(content);
        }

        $("#preview").html(markdown_content);
    })
});