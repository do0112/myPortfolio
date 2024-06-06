$(document).ready(function(){
    var num = $('#quantity').val();
    num = parseInt(num);
    $('#minus').click(function(){
       num = num - 1;
       if(num<1){
        num = 1;
       }
       $('#quantity').val(num);
    });

    $('#plus').click(function(){
        num = num + 1;
      
        $('#quantity').val(num);
     });

   
    
    
})