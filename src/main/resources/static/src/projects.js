$(document).ready(function(){

    // menu font color
    $('nav ul li').mouseenter(function(){
        $('nav ul li').css('font-weight','normal');
        $(this).css('font-weight','bold');
    }).mouseleave(function(){
        $('nav ul li').css('font-weight','bold');
    });

    // banner image fade
    $('#banner_img li').first().show();
    var idx = 0;
    var timer = setInterval(autofade,5000);
    function autofade(){
        idx += 1;
        if(idx > 4){
            idx = 0;
        }
        $('#banner_img li').stop().fadeOut();
		$('#banner_img li').eq(idx).stop().fadeIn();
    }
    $('#icon_left').click(function(){
		clearInterval(timer);
		var prev_idx = idx - 1;
        if(prev_idx < 0){
            prev_idx = 4;
        }
		$('#banner_img li').stop().fadeOut();
		$('#banner_img li').eq(prev_idx).stop().fadeIn();
		idx = prev_idx;
		timer = setInterval(autofade,5000);
	});

    $('#icon_right').click(function(){
		clearInterval(timer);
		var next_idx = idx + 1;
        if(next_idx > 4){
            next_idx = 0;
        }
		$('#banner_img li').stop().fadeOut();
		$('#banner_img li').eq(next_idx).stop().fadeIn();
		idx = next_idx;
		timer = setInterval(autofade,5000);
	});

    // new & best
    $('#new_items>div').first().show();
    $('#new_items #nb p').first().addClass('font_color');

    $('#new_items #nb p').click(function(){
        $('#new_items #nb p').removeClass('font_color');
        $(this).addClass('font_color');
        $('#new_items>div').hide();
		$('#new_items>div').eq($(this).index()).show();
    });

    // brand
    $('#items>div').first().show();
    $('#brand .categories span').first().addClass('count');
    $('.categories .category').first().addClass('on');
    var val = 0;
    $('#items .item_brand ul').css('transform',`translateX(${val}px)`);

    $('.categories .category').click(function(){
        $('#brand .categories span').removeClass('count');
        $('#brand .categories span').eq($(this).index()).addClass('count');
        val = 0;
        $('#items .item_brand ul').css('transform',`translateX(${val}px)`);
        $('.categories .category').removeClass('on');
        $(this).addClass('on');
        $('#items div').hide();
		$('#items div').eq($(this).index()).show();

    });
    $('#items .right_btn').click(function(){
        if(val === -691.5){
            val = -691.5;
        }else{
            val -= 230.5;
        }
        $('#items .item_brand ul').css('transform',`translateX(${val}px)`);
    });

    $('#items .left_btn').click(function(){
        if(val == 0){
            val = 0;
         }else{
            val += 230.5;
        }
            
        $('#items .item_brand ul').css('transform',`translateX(${val}px)`);
     });
    

    $('#other .other_brand').first().show();
    $('#other #country p').first().addClass('selected');

    $('#other #country p').click(function(){
        $('#other #country p').removeClass('selected');
        $(this).addClass('selected');
        $('#other .other_brand').hide();
		$('#other .other_brand').eq($(this).index()).show();
    });
     

});

