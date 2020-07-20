$(function () {
         oldPassword();
         newPassword();
         confirmNewPassword();
         sub_form();
});

//对旧密码的处理
function oldPassword() {
    var oldPassword=$("#oldPassword");
    var oldPasswordError=$("#oldPasswordError");
    oldPassword.blur(function () {
        if(oldPassword.val()==""){
            oldPasswordError.text("请输入原密码");
        }
      else {
            $.ajax({
                url: "NoRepeatServlet",
                data: {method: "checkPassword", oldPassword: oldPassword.val()},
                dataType: "text",
                type: "post",
                success: function (resp) {
                    oldPasswordError.text(resp);
                }
            })
        } });

    oldPassword.focus(function () {
            oldPasswordError.text("");
    })
}

//对新密码的处理
function newPassword() {
    var newPassword = $("#newPassword");
    var newPasswordError=$("#newPasswordError");

    newPassword.blur(function () {
        var passwordRegExp = /^[a-zA-Z0-9]{6,16}$/;
        if(!passwordRegExp.test(newPassword.val())){
            newPasswordError.text("需6到16个数字或字母");
        }
    });

    newPassword.focus(function () {
        newPasswordError.text("");
    })
}

//处理确认密码不合法
function confirmNewPassword() {
    var confirmNewPassword = $("#confirmNewPassword");
    var newPassword = $("#newPassword");
    var confirmNewPasswordError=$("#confirmNewPasswordError");

    confirmNewPassword.blur(function () {

        if (confirmNewPassword.val()==""){
            confirmNewPasswordError.text("请输入确认密码");
        }

        if(newPassword.val()!=confirmNewPassword.val()){
            confirmNewPasswordError.text("与原密码不一致");
        }
    });

    confirmNewPassword.focus(function () {
        confirmNewPasswordError.text("");
    })
}

function sub_form() {
    var btn=$("#btn_mod1");
    var oldPassword=$("#oldPassword");
    var oldPasswordError=$("#oldPasswordError");
    var newPassword = $("#newPassword");
    var newPasswordError=$("#newPasswordError");
    var confirmNewPassword = $("#confirmNewPassword");
    var confirmNewPasswordError=$("#confirmNewPasswordError");

    btn.click(function () {
        if(oldPassword.val()==""||newPassword.val()==""||confirmNewPassword==""){
            alert("请将信息填写完整!");
        }
        else if(oldPasswordError==""&&newPasswordError==""&&confirmNewPasswordError==""){
            if(confirm("是否确定提交?")){
                $("#mod_form").submit();
            }
        }
    })
}