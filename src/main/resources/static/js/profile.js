'use strict';

$(document).ready(function () {
    $('.courses').show();
    $('.recommendations').hide();
    $('.question').hide();

    $('.recommendTab').click(function () {
        $('.active').removeClass('active');
        $('.recommendations').addClass('active');
        $('.courses').hide();
        $('.recommendations').show();
        $('.question').show();
    });

    $('.coursesTab').click(function () {
        $('.active').removeClass('active');
        $('.courses').addClass('active');
        $('.courses').show();
        $('.recommendations').hide();
        $('.question').hide();
    });
});

