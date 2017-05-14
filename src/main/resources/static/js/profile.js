'use strict';

$(document).ready(function () {
    $('.courses').show();
    $('.recommendations').hide();

    $('.tab').click(function () {
        $('.active').removeClass('active');
        $(this).closest('li').addClass('active');
        $('.courses').toggle();
        $('.recommendations').toggle();
    });
});

