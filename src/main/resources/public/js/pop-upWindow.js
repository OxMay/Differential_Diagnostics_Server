	function WinOp(str){

var msg = new String("");

msg = '<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1251\" /><link rel="stylesheet" type="text/css" href="http://javascript.ru/clientscript/vbulletin_css/style-81884d78-00003.css" id="vbulletin_css" /><title>Что -то</title>'

msg+= "<body><div id=\"pun\" class=\"punbb\"><div id=\"pun-main\" class=\"main\">"

msg+="Тут контент"+str;

msg+="</div></div></body></html>";

popup = window.open("", "", "height=300, width=700, top=300, left=300, scrollbars=1")

popup.document.write(msg)

popup.document.close()

return false

}

 

var Conten_000='<div>fhjlkfjhklgklh<div>';
