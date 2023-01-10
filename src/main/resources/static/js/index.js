var index = {
    init: function() {
        $(document).ready(function () {
            $(".slider").slick({
                dots: false,
                autoplay: true,
                autoplaySpeed: 3000,
                arrows: false,
                responsive: [
                    {
                        breakpoint: 768,
                        settings: {
                            autoplay: false
                        }
                    }
                ]
            });

            $(".menu_mobile").click(function () {
                $(".menu_mobile").toggleClass("click");
            });
        })

    }
};

index.init();