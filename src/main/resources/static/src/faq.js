$(document).ready(function(){
    $('#faq_list dl dt div b').click(function(){
        if($(this).hasClass('bold')){
            $('#faq_list dl dt div b').removeClass('bold');
            $('#faq_list dl dt p').removeClass('rotate');
            $('#faq_list dl dd').slideUp();
        }else{
            $('#faq_list dl dt div b').removeClass('bold');
            $('#faq_list dl dt p').removeClass('rotate');
            $('#faq_list dl dd').slideUp();
            $(this).addClass('bold');
            $(this).parent().next().addClass('rotate');
            $(this).closest('dt').next().slideDown();
        }
    });
});




