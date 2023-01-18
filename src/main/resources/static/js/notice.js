var notice = {
    init: function () {
        var _this = this;
        $(document).ready(function () {
            $("#introduce_content ul li").click(function () {
                $("#introduce_content .introduce_box").removeClass("active");
                var _thisClassName = "." + $(this).attr("class");
                $(".introduce_box" + _thisClassName).addClass("active");
            })

            $("#btn-save").on("click", function (e) {
                e.preventDefault();
                _this.save();
            })
            $("#btn-update").on("click", function (e) {
                e.preventDefault();
                _this.update();
            })
            $("#btn-delete").on("click", function (e) {
                e.preventDefault();
                _this.delete();
            })

            /* 페이지 이동 */
            $("#btn-move-update").on("click", function (e) {
                e.preventDefault();
                var id = $(this).attr("name");
                location.href = "/notice/update/" + id;
            })

            // summernote
            $('#summernote').summernote({
                // 에디터 높이
                height: 450,
                // 에디터 한글 설정
                lang: "ko-KR",
                // 에디터에 커서 이동 (input창의 autofocus라고 생각)
                focus: true,
                toolbar: [
                    ['style', ['style']],
                    ['font', ['bold', 'italic', 'underline', 'clear']],
                    ['fontname', ['fontname']],
                    ['color', ['color']],
                    ['para', ['ul', 'ol', 'paragraph']],
                    ['height', ['height']],
                    ['table', ['table']],
                    ['insert', ['link', 'picture', 'hr']],
                    ['view', ['fullscreen', 'codeview']],
                    ['help', ['help']]
                ],
                // 추가한 글꼴
                fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', '맑은 고딕', '궁서', '굴림체', '굴림', '돋음체', '바탕체'],
                // 추가한 폰트사이즈
                fontSizes: ['8', '9', '10', '11', '12', '14', '16', '18', '20', '22', '24', '28', '30', '36', '50', '72']

            });
            $("#summernote.disable").summernote('disable');

        });
    },
    save: function () {
        var data = {
            title: $(".title").val(),
            author: $(".author").val(),
            content: $(".content").val()
        }

        $.ajax({
            type: "post",
            url: "/api/notice",
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data)
        }).done(function () {
            alert("글이 등록되었습니다.");
            window.location.href = "/notice";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
    update: function () {
        var data = {
            title: $(".title").val(),
            content: $(".content").val()
        };

        var id = $("#btn-update").attr("name");

        $.ajax({
            type: "PUT",
            url: "/api/notice/" + id,
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data)
        }).done(function () {
            alert("글이 수정되었습니다.");
            window.location.href = "/notice";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
    delete: function () {
        var id = $("#btn-delete").attr("name");

        $.ajax({
            type: "DELETE",
            url: "/api/notice/" + id,
            dataType: "json",
            contentType: "application/json; charset=utf-8",
        }).done(function () {
            alert("글이 삭제되었습니다.");
            window.location.href = "/notice";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    }
}

notice.init();