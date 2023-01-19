var users = {
    init: function () {
        var _this = this;
        $(document).ready(function () {
            $("#btn-sign-up-submit").on("click", function (e) {
                e.preventDefault();
                _this.save();
            })
        });
    },
    save: function () {
        var data = {
            id: $("#id").val(),
            name: $("#name").val(),
            password: $("#password").val()
        }

        $.ajax({
            type: "post",
            url: "/api/users",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data)
        }).done(function () {
            alert("성공적으로 회원가입 되었습니다..");
            window.location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    }
}

users.init();