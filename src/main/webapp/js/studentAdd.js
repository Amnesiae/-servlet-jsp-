$(function () {

    dealName();
    dealEmail();
    dealAge();
    dealAddress();
    dealUsername();
    dealPassword();
    dealConfirmPassword();
    submitForm();
});


//处理name不合法
function dealName() {
    var nameError = $("#nameError");
    var stuName = $("#stuName");
    stuName.blur(function () {//失去焦点时判断`
        var nameRegExp = /^[\u4E00-\u9FA5A-Za-z0-9_]+$/;
        if (!nameRegExp.test(stuName.val())) {
            nameError.text("至少一位(中文、英文、数字下划线)");
        }
    });

    stuName.focus(function () {

        nameError.html("");
    })
}

//处理email不合法
function dealEmail() {
    var emailError = $("#emailError");
    var stuEmail = $("#stuEmail");
    stuEmail.blur(function () {//失去焦点时判断`
        var emailRegExp = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        if (!emailRegExp.test(stuEmail.val())) {
            emailError.text("请输入合法的邮箱");
        }
    });

    stuEmail.focus(function () {
        emailError.html("");
    })
}

//处理age不合法
function dealAge() {
    var ageError = $("#ageError");
    var stuAge = $("#stuAge");
    stuAge.blur(function () {//失去焦点时判断`
        var ageRegExp = /([1-9]|[1-9][0-9]|120)/;
        if (!ageRegExp.test(stuAge.val())) {
            ageError.text("请输入合法的年龄");
        }
    });

    stuAge.focus(function () {
        if (ageError != "") {
            stuAge.val("");
        }
        ageError.html("");
    })
}

//处理address不合法
function dealAddress() {
    var addressError = $("#addressError");
    var stuAddress = $("#stuAddress");
    stuAddress.blur(function () {//失去焦点时判断`
        var addressRegExp = /^[\u4E00-\u9FA5A-Za-z0-9_]+$/;
        if (!addressRegExp.test(stuAddress.val())) {
            addressError.text("至少一位(中文、英文、数字下划线)");
        }
    });

    stuAddress.focus(function () {
        addressError.html("");
    })
}

//处理用户名不合法
function dealUsername() {
    var stuUsername = $("#stuUsername")
    var usernameError=$("#usernameError")

    stuUsername.blur(function () {

        var usernameRegExp = /^[a-zA-Z0-9]{3,16}$/;
        if(!usernameRegExp.test(stuUsername.val())){
            usernameError.text("需3到16个数字或字母");
        }
        /*处理username不能重复*/
        else{
            $.ajax({
                type:"post",
                url:"NoRepeatServlet",
                dataType:"text",
                data:{method:"checkUsername",username:stuUsername.val()},
                success:function (resp) {
                    usernameError.text(resp);
                }
            }
            )
        }
    });

    stuUsername.focus(function () {
        usernameError.text("");
    })
}
//处理密码不合法
function dealPassword() {
    var stuPassword = $("#stuPassword");
    var passwordError=$("#passwordError");

    stuPassword.blur(function () {
        var passwordRegExp = /^[a-zA-Z0-9]{6,16}$/;
        if(!passwordRegExp.test(stuPassword.val())){
            passwordError.text("需6到16个数字或字母");
        }
    });

    stuPassword.focus(function () {
        passwordError.text("");
    })
}

//处理确认密码不合法
function dealConfirmPassword() {
    var stuPassword = $("#stuPassword");
    var stuConfirmPassword = $("#stuConfirmPassword");
    var passwordConfirmError=$("#passwordConfirmError");

    stuConfirmPassword.blur(function () {

        if (stuConfirmPassword.val()==""){
            passwordConfirmError.text("请输入确认密码");
        }

        if(stuPassword.val()!=stuConfirmPassword.val()){
            passwordConfirmError.text("与原密码不一致");
        }
    });

    stuConfirmPassword.focus(function () {
        passwordConfirmError.text("");
    })
}

function submitForm() {

    var stuName=$("#stuName");
    var stuEmail = $("#stuEmail");
    var stuAge = $("#stuAge");
    var stuAddress = $("#stuAddress");
    var stuUsername = $("#stuUsername");
    var stuPassword = $("#stuPassword");
    var stuConfirmPassword = $("#stuConfirmPassword");


    var nameError=$("#nameError").text();
    var ageError=$("#ageError").text();
    var emailError=$("#emailError").text();
    var addressError=$("#addressError").text();
    var usernameError=$("#usernameError").text();
    var passwordError=$("#passwordError").text();
    var passwordConfirmError=$("#passwordConfirmError").text();

    var sub=$("#add_btn1");
    sub.click(function () {

  //      alert(stuName.val()+""+stuEmail.val()+","+stuAge.val()+","+stuAddress.val()+","+stuUsername.val()+","+stuPassword.val()+","+stuConfirmPassword.val());

        //当有未填写完整时
        if(stuName.val()==""||stuEmail.val()==""||stuAge.val()==""||stuAddress.val()==""||stuUsername.val()==""||stuPassword.val()==""||stuConfirmPassword.val()==""){
            alert("请将信息填写完整!")
        }

        //当所有的错误提示都没出现
        if((stuName.val()!=""&&stuEmail.val()!=""&&stuAge.val()!=""&&stuAddress.val()!=""&&stuUsername.val()!=""&&stuPassword.val()!=""&&stuConfirmPassword.val()!="")
            &&nameError==""&&ageError==""&&emailError==""&&addressError==""&&usernameError==""&&passwordError==""&&passwordConfirmError==""){
            if(confirm("是否确认数据提交")){
                $("#add_form").submit();
            }
        }
    })
}