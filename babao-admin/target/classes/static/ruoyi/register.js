
$(function() {
    validateRule();
	$('.imgcode').click(function() {
		var url = ctx + "captcha/captchaImage?type=" + captchaType + "&s=" + Math.random();
		$(".imgcode").attr("src", url);
	});
});

$.validator.setDefaults({
    submitHandler: function() {
    	register();
    }
});

function register() {
	$.modal.loading($("#btnSubmit").data("loading"));
	var account = $.common.trim($("input[name='account']").val());
    var password = $.common.trim($("input[name='password']").val());
    var membername = $("input[name='membername']").val();
    $.ajax({
        type: "post",
        url: ctx + "register",
        data: {
            "account": account,
            "password": password,
            "membername" : membername
        },
        success: function(r) {
            if (r.code == 0) {
                location.href = ctx + 'login';
            } else {
            	$.modal.closeLoading();
            	$('.imgcode').click();
            	$(".code").val("");
            	$.modal.msg(r.msg);
            }
        }
    });
}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            username: {
                required: true
            },
            password: {
                required: true
            }
        },
        messages: {
            username: {
                required: icon + "请输入您的用户名",
            },
            password: {
                required: icon + "请输入您的密码",
            }
        }
    })
}
