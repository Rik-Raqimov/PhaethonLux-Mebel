
  // Slider işə sal
        function initializeSliders() {
          document.querySelectorAll('.before-after').forEach(function(container) {
            const slider = container.querySelector('.slider');
            slider.addEventListener('input', function (e) {
              container.style.setProperty('--position', e.target.value + '%');
            });
          });
          console.log("Sliders initialized");
        }

        initializeSliders();
console.log("Script loaded");

    // Şəkilləri yüklə
    function loadImages() {
      const file1 = document.querySelector('#imageUpload1').files[0];
      const file2 = document.querySelector('#imageUpload2').files[0];

      if (file1 && file2 && file1.type.startsWith('image/') && file2.type.startsWith('image/')) {
        const imageBefore = document.querySelector('.image-before');
        const imageAfter = document.querySelector('.image-after');

        imageBefore.src = URL.createObjectURL(file1);
        imageAfter.src = URL.createObjectURL(file2);
      } else {
        alert('Xahiş olunur iki şəkil seçin.');
      }
    }

    // səhifə açılanda slider işə düşsün
    initializeSliders();

(function ($) {
    "use strict";

    // Spinner
    var spinner = function () {
        setTimeout(function () {
            if ($('#spinner').length > 0) {
                $('#spinner').removeClass('show');
            }
        }, 1);
    };
    spinner();
    
    
    // Initiate the wowjs
    new WOW().init();


    // Sticky Navbar
    $(window).scroll(function () {
        if ($(this).scrollTop() > 300) {
            $('.sticky-top').addClass('bg-white shadow-sm').css('top', '0px');
        } else {
            $('.sticky-top').removeClass('bg-white shadow-sm').css('top', '-150px');
        }
    });
    
    
    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({scrollTop: 0}, 1500, 'easeInOutExpo');
        return false;
    });


    // Header carousel
    $(".header-carousel").owlCarousel({
        autoplay: true,
        smartSpeed: 1000,
        loop: true,
        dots: true,
        items: 1
    });


    // Testimonials carousel
    $(".testimonial-carousel").owlCarousel({
        items: 1,
        autoplay: true,
        smartSpeed: 1000,
        animateIn: 'fadeIn',
        animateOut: 'fadeOut',
        dots: true,
        loop: true,
        nav: false
    });
    
})(jQuery);



