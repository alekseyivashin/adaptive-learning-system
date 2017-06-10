'use strict';

$(document).ready(function () {
    $('.courses').show();
    $('.recommendations').hide();

    $('.recommendTab').click(function () {
        $('.active').removeClass('active');
        $('.recommendTab').addClass('active');
        $('.courses').hide();
        $('.recommendations').show();
    });

    $('.coursesTab').click(function () {
        $('.active').removeClass('active');
        $('.coursesTab').addClass('active');
        $('.courses').show();
        $('.recommendations').hide();
    });
});

