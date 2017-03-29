function chg(id){ 

if (document.getElementById(id).src.indexOf("image/onepacient.jpg")>0){ 

document.getElementById(id).src="image/graf2.jpg"
}else(document.getElementById(id).src.indexOf("image/graf2.jpg")>0){
    document.getElementById(id).src="image/graf1.jpg"
}


}
//    if (document.getElementById(id).src.indexOf("image/graf2.jpg")>0){ 
//
//document.getElementById(id).src="image/graf1.jpg" 
//
//} 
//
//} 
//var i=0;
//var image=document.getElementById("image");
//var imgs=new Array('image/graf1.jpg','image/graf2.jpg', 'image/graf.jpg'); //Добавте свои картинки через запятую
//function chg(){
//i++;
//image.src=imgs[i];
//}
//
//
//var i=0;
//var image=document.getElementById("image");
//var imgs=new Array('image/graf1.jpg','image/graf2.jpg', 'image/graf.jpg'); //Добавте свои картинки через запятую
//function chg(){
//i++;
//image.src=imgs[i];
//}

// function chg(source)
// {  document.pact.src = source + '.jpg';
// }
//
// function one(source)
// {  document.pict.src = source + '.jpg';
// }
//
// function two(source)
// {  document.pict.src = source + '.jpg';
// }
//$("#change_img").click(function(){
//    var num_img_0 = '<img src="image/graf.jpg" />';
//    var num_img_1 = '<img src="image/graf1.jpg" />';
//    var num_img_2 = '<img src="image/graf2.jpg" />';
//    var num_img_3 = '<img src="image/graf.jpg" />';
//    
//    if($("#images").html() == num_img_0){
//        $("#images").html(num_img_1);
//    }
//    else if($("#images").html() == num_img_1){
//        $("#images").html(num_img_2);
//    }
//    else if($("#images").html() == num_img_2){
//        $("#images").html(num_img_3);
//    }
//    else if($("#images").html() == num_img_3){
//        $("#images").html(num_img_0);
//    }
//})
