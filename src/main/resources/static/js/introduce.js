var introduce = {
    init: function () {
        $(document).ready(function () {
            $("#introduce_content ul li").click(function () {
                $("#introduce_content .introduce_box").removeClass("active");
                var _thisClassName = "." + $(this).attr("class");
                $(".introduce_box" + _thisClassName).addClass("active");
            })
        })

    }
};

introduce.init();