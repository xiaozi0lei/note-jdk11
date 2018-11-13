/**
 * Created by lvyz on 2018/2/11.
 */
$(function () {
    $("#register").click(function () {
        var mail = $("#email").val();
        var name = $("#username").val();
        var pwd = $("#password").val();
        var ConfirmPwd = $("#ConfirmPassword").val();
        if (mail.trim() === "" || (!/^[\w\.\-]+@\w+\.\w+$/.test(mail))) {
            alert("email格式必须为xxxx@xxxxx");
            return false;
        }
        else if (name.trim() === "") {
            alert(name + "请输入用户名");
            return false;
        } else if (pwd.trim() === "") {
            alert("请输入密码");
            return false;
        } else if (ConfirmPwd.trim() === "") {
            alert("请输入确认密码");
            return false;
        } else if (ConfirmPwd != pwd) {
            alert("两次输入的密码不一致");
            return false;
        }
        return true;
    })
});
