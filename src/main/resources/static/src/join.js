$(document).ready(function(){
	
	//약관
    $('#join_btn').click(function(){
        var checked1 = $('#terms_check').is(":checked");
        var checked2 = $('#privacy_check').is(":checked");
        if((checked1 == false) || (checked2 == false)){
            alert('약관에 모두 동의 해주세요!');
        }
    });
    
    
	//id
	$('#userId').on('input',function(){
        var input_val = $(this).val();
        $('#id_pass').css('display','none');
		$('#id_error').css('display','none');
		if(input_val.length >= 4 && input_val.length <= 10){
            
            $('#id_check').css('display','none');
			$('table #id_heart').addClass('green');
		}else{
            $('table #id_heart').removeClass('green');
			$('#id_check').css('display','block');
		}
	});


    //password
    $('#userPw').on('input',function(){
        var input_val = $(this).val();
        var pw_pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{6,20}$/;
		
        if(pw_pattern.test(input_val)){
			$('table #pw_heart').addClass('green');
		}else{
            $('table #pw_heart').removeClass('green');
		}
	});

    //password check
    $('#pw_check').on('input',function(){
        var input_val = $(this).val();
        var pw = $('#userPw').val();
        if(pw == input_val){
            $('#pw_ch').css('display','none');
			$('table #pw_check_heart').addClass('green');
		}else{
            $('table #pw_check_heart').removeClass('green');
            $('#pw_ch').css('display','block');
		}
	});

    //email
    $('#mail1').on('input',function(){
        var input_value = $(this).val();
        var selected_value = $('#mail2 option:selected').val();
        var mail_pattern1 = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        var mail_pattern2 = /[`~@().,/]/g;
 
        if(selected_value == 'default'){
            if(mail_pattern1.test(input_value)){
                $('table #email_check').css('display','none');
                $('table #mail_heart').addClass('green');
            }else{
                $('table #mail_heart').removeClass('green');
                $('table #email_check').css('display','block');
            }
 
        }else{
            if(!mail_pattern2.test(input_value)){
                $('table #email_check').css('display','none');
                $('table #mail_heart').addClass('green');
            }else{
                $('table #mail_heart').removeClass('green');
                $('table #email_check').css('display','block');
            }
        }

    });

    $('#mail1').on('input',function(){
        var input_val = $(this).val();
        var mail_pattern1 = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; 
        var mail_pattern2 = /[`~@().,/]/g;
        
        $('#mail2').change(function(){
            var option_val = $(this).val();
            if(option_val == 'default'){
                if(mail_pattern1.test(input_val)){
                    $('table #email_check').css('display','none');
                    $('table #mail_heart').addClass('green');
                }else{
                    $('table #mail_heart').removeClass('green');
                    $('table #email_check').css('display','block');
                }
            }else{
                if(mail_pattern2.test(input_val) == false){
                    $('table #email_check').css('display','none');
                    $('table #mail_heart').addClass('green');
                }else{
                    $('table #mail_heart').removeClass('green');
                    $('table #email_check').css('display','block');
                }
            }
        });
    });
    
    
    //mail 값
    $('#mail2').change(function(){
        var mail1_val = $('#mail1').val();
        var mail2_val = $("select[name='mail2'] option:selected").text();
        var hidden_val= "";
        if(mail2_val == '직접입력'){
        	$('#mail').val(mail1_val);
        }else{
            hidden_val = mail1_val + mail2_val;
            $('#mail').val(hidden_val);
        }
    });

    //phone
    $('#phone').on('input',function(){
        var input_val = $(this).val();
        var phone_pattern = /^010[0-9]{4}[0-9]{4}$/;
        if(phone_pattern.test(input_val)){
            $('table #phone_check').css('display','none');
			$('table #phone_heart').addClass('green');
		}else{
            $('table #phone_heart').removeClass('green');
            $('table #phone_check').css('display','block');
		}
	});
    
    
    //중복 확인
    $('table #duplicate_check').click(function(){
        var userId = $('table #userId').val();

        fetch('/member/duplicatecheck',{
        	method : 'POST',
        	body : JSON.stringify({ userid : userId }),
        	headers : {
        		'Content-Type' : 'application/json'
        	}
        }).then(response => response.json()).then(data => {
        	$(data.message).css('display','block');
        }).catch(error => {
        	console.log('통신 오류');
        });
        
    });
    

    
	
});